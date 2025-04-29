package model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.*;
import java.util.stream.Collectors;

public class JanelaPrincipalController {

    // Campos para a interface do usuário
    private TextField tfTempDesejada;  // Campo para temperatura desejada
    private TextField tfCargaTermica; // Campo para carga térmica
    private Button btnRecomendar;     // Botão para recomendar motores

    public void initialize() {
        // Configura o comportamento do botão
        btnRecomendar.setOnAction(event -> recomendar());
    }

    /**
     * Método que é chamado ao clicar no botão "Recomendar".
     */
    private void recomendar() {
        try {
            // Captura as entradas do usuário
            double tempDesejada = Double.parseDouble(tfTempDesejada.getText());
            double cargaTermica = Double.parseDouble(tfCargaTermica.getText());

            // Realiza a recomendação dos motores
            List<RecomendacaoMotor> recomendados = recomendarMotores(tempDesejada, cargaTermica);

            // Exibe os resultados
            mostrarResultados(recomendados);
        } catch (Exception e) {
            // Mostra erro caso os campos não estejam preenchidos corretamente
            mostrarErro("Preencha corretamente todos os campos.");
        }
    }

    /**
     * Método que realiza a lógica de recomendação de motores.
     *
     * @param tempDesejada  Temperatura desejada (em °C).
     * @param cargaTermica  Carga térmica necessária (em kcal/h).
     * @return Lista de recomendações adequadas.
     */
    private List<RecomendacaoMotor> recomendarMotores(double tempDesejada, double cargaTermica) {
        List<UnidadeCondensadoras> catalogo = UnidadeCondensadoras.getCatalogo();

        // Agrupa por modelo para facilitar a interpolação
        Map<String, List<UnidadeCondensadoras>> agrupadoPorModelo = new HashMap<>();

        for (UnidadeCondensadoras unidade : catalogo) {
            String chave = unidade.getModelo() + unidade.getGas() + unidade.getTensao();
            agrupadoPorModelo.computeIfAbsent(chave, k -> new ArrayList<>()).add(unidade);
        }

        List<RecomendacaoMotor> recomendados = new ArrayList<>();

        for (List<UnidadeCondensadoras> lista : agrupadoPorModelo.values()) {
            lista.sort(Comparator.comparingDouble(UnidadeCondensadoras::getTemperaturaMin)); // Ordena por temperatura mínima

            // Verifica se a temperatura desejada está no intervalo do modelo
            if (tempDesejada < lista.get(0).getTemperaturaMin() || tempDesejada > lista.get(lista.size() - 1).getTemperaturaMin())
                continue;

            UnidadeCondensadoras menor = null, maior = null;
            for (int i = 0; i < lista.size(); i++) {
                UnidadeCondensadoras unidade = lista.get(i);
                if (unidade.getTemperaturaMin() <= tempDesejada) menor = unidade;
                if (unidade.getTemperaturaMin() > tempDesejada && maior == null) maior = unidade;
            }

            if (menor == null || maior == null) continue;

            // Interpolação linear (ou capacidade exata, caso menor == maior)
            double capacidadeEstimada;
            if (menor.getTemperaturaMin() == maior.getTemperaturaMin()) {
                capacidadeEstimada = menor.getCapacidadeKcal();
            } else {
                double t1 = menor.getTemperaturaMin();
                double t2 = maior.getTemperaturaMin();
                double c1 = menor.getCapacidadeKcal();
                double c2 = maior.getCapacidadeKcal();
                capacidadeEstimada = c1 + ((tempDesejada - t1) / (t2 - t1)) * (c2 - c1);
            }

            // Se a capacidade atender à carga térmica, adiciona como recomendação
            if (capacidadeEstimada >= cargaTermica) {
                recomendados.add(new RecomendacaoMotor(
                        menor.getMarca(),
                        menor.getModelo(),
                        menor.getGas(),
                        menor.getTensao(),
                        capacidadeEstimada
                ));
            }
        }

        // Ordena para mostrar os melhores (menor capacidade suficiente) primeiro
        recomendados.sort(Comparator.comparingDouble(RecomendacaoMotor::getCapacidadeEstimada));
        return recomendados;
    }

    /**
     * Método para exibir os resultados na interface.
     *
     * @param recomendados Lista de motores recomendados.
     */
    private void mostrarResultados(List<RecomendacaoMotor> recomendados) {
        if (recomendados.isEmpty()) {
            mostrarErro("Nenhum motor atende às condições informadas.");
            return;
        }

        StringBuilder resultado = new StringBuilder("Recomendações de motores:\n\n");
        for (RecomendacaoMotor r : recomendados) {
            resultado.append("Modelo: ").append(r.getModelo())
                    .append("\nMarca: ").append(r.getMarca())
                    .append("\nGás: ").append(r.getGas())
                    .append("\nTensão: ").append(r.getTensao())
                    .append("\nCapacidade Estimada: ").append(String.format("%.1f kcal/h", r.getCapacidadeEstimada()))
                    .append("\n\n");
        }

        Alert alert = new Alert(AlertType.INFORMATION, resultado.toString());
        alert.setHeaderText("Motores Recomendados");
        alert.show();
    }

    /**
     * Método para exibir mensagens de erro.
     */
    private void mostrarErro(String mensagem) {
        Alert alert = new Alert(AlertType.ERROR, mensagem);
        alert.setHeaderText("Erro");
        alert.show();
    }
}