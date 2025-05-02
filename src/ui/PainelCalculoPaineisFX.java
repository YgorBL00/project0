package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import model.LinhaTabelaPainel;

import static model.DadosCâmara.*;

public class PainelCalculoPaineisFX extends VBox {

    // Campos de entrada
    private final TextField tfEspessura = novoCampo();
    private final TextField tfLargura = novoCampo();
    private final TextField tfAltura = novoCampo();
    private final TextField tfComprimento = novoCampo();
    private final TextField tfLarguraPainel = novoCampo();
    private final RadioButton rbPisoSim = new RadioButton("Sim");
    private final RadioButton rbPisoNao = new RadioButton("Não");

    // Tabela e totais
    private final TableView<LinhaTabelaPainel> tabela = new TableView<>();
    private final Label lbTotalPaineis = new Label("Total painéis: -");
    private final Label lbTotalM2 = new Label("Total m²: -");

    public PainelCalculoPaineisFX() {
        setSpacing(0);
        setPadding(new Insets(18, 16, 12, 16));

        HBox linha = new HBox(30);
        linha.setAlignment(Pos.TOP_LEFT);

        VBox painelCampos = montarPainelCampos();
        VBox painelResultados = montarPainelResultados();
        linha.getChildren().addAll(painelCampos, painelResultados);

        getChildren().add(linha);
    }

    private VBox montarPainelCampos() {
        VBox campos = new VBox(11);
        campos.setAlignment(Pos.TOP_LEFT);
        campos.setPadding(new Insets(13, 13, 13, 13));
        campos.setPrefWidth(262);

        tfLarguraPainel.setText("1.15"); // padrão

        ToggleGroup grupoPiso = new ToggleGroup();
        rbPisoSim.setToggleGroup(grupoPiso);
        rbPisoNao.setToggleGroup(grupoPiso);
        rbPisoNao.setSelected(true);

        campos.getChildren().addAll(
                new Label("Espessura do painel (mm):"), tfEspessura,
                new Label("Largura (m):"), tfLargura,
                new Label("Altura (m):"), tfAltura,
                new Label("Comprimento (m):"), tfComprimento,
                new Label("Possui piso?"), new HBox(14, rbPisoSim, rbPisoNao),
                new Label("Largura do painel (m):"), tfLarguraPainel
        );

        Button calcular = new Button("Calcular");
        calcular.setMaxWidth(Double.MAX_VALUE);
        calcular.setOnAction(e -> calcularPaineis());
        campos.getChildren().add(calcular);

        TitledPane titulo = new TitledPane("Dados da Câmara", campos);
        titulo.setCollapsible(false);

        VBox painel = new VBox(titulo);
        painel.setAlignment(Pos.TOP_LEFT);
        return painel;
    }

    private VBox montarPainelResultados() {
        // Configurar colunas
        TableColumn<LinhaTabelaPainel, String> colLocal   = new TableColumn<>("Local");
        TableColumn<LinhaTabelaPainel, String> colQtd     = new TableColumn<>("Qtd. Painéis");
        TableColumn<LinhaTabelaPainel, String> colAltura  = new TableColumn<>("Altura (m)");
        TableColumn<LinhaTabelaPainel, String> colLargura = new TableColumn<>("Largura (m)");
        TableColumn<LinhaTabelaPainel, String> colArea    = new TableColumn<>("Área (m²)");
        colLocal.setCellValueFactory(data -> data.getValue().localProperty());
        colQtd.setCellValueFactory(data -> data.getValue().qtdProperty());
        colAltura.setCellValueFactory(data -> data.getValue().alturaProperty());
        colLargura.setCellValueFactory(data -> data.getValue().larguraProperty());
        colArea.setCellValueFactory(data -> data.getValue().areaProperty());
        tabela.getColumns().setAll(colLocal, colQtd, colAltura, colLargura, colArea);
        tabela.setPrefHeight(170);
        tabela.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

        TitledPane detailingPane = new TitledPane("Detalhamento dos Painéis", tabela);
        detailingPane.setCollapsible(false);

        // Totais alinhados: painel à esquerda, m² à direita
        HBox totais = new HBox();
        totais.setPadding(new Insets(10, 10, 2, 4));
        totais.setPrefWidth(600);
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        lbTotalPaineis.setFont(Font.font("SansSerif", 16));
        lbTotalM2.setFont(Font.font("SansSerif", 16));
        totais.getChildren().addAll(lbTotalPaineis, spacer, lbTotalM2);

        VBox painel = new VBox(12);
        painel.setPadding(new Insets(2,10,2,2));
        painel.getChildren().addAll(detailingPane, totais);
        painel.setPrefWidth(700);
        return painel;
    }

    private TextField novoCampo() {
        TextField tf = new TextField();
        tf.setPrefWidth(75);
        return tf;
    }

    private void calcularPaineis() {
        try {
            // Salva os dados em DadosCâmara ao calcular painéis:
            double espessura = Double.parseDouble(tfEspessura.getText().replace(",", ".").trim());
            double largura = Double.parseDouble(tfLargura.getText().replace(",", ".").trim());
            double altura = Double.parseDouble(tfAltura.getText().replace(",", ".").trim());
            double comprimento = Double.parseDouble(tfComprimento.getText().replace(",", ".").trim());
            boolean temPiso = rbPisoSim.isSelected();
            double larguraPainel = Double.parseDouble(tfLarguraPainel.getText().replace(",", ".").trim());

            model.DadosCâmara.setMedidas(comprimento, largura, altura, espessura);

            tabela.getItems().clear();

            // Menor dimensão para piso/teto
            double alturaPisoETeto = Math.min(largura, comprimento);

            // Paredes
            double perimetro = 2 * (largura + comprimento);
            int qtdPainelParedes = (int) Math.ceil(perimetro / larguraPainel);
            double areaPorPainelParede = altura * larguraPainel;
            double areaTotalParedes = qtdPainelParedes * areaPorPainelParede;

            // Teto
            int qtdPainelTeto;
            double areaPainelTeto = alturaPisoETeto * larguraPainel;
            double areaTeto = largura * comprimento;
            qtdPainelTeto = (int) Math.ceil(areaTeto / areaPainelTeto);
            double areaTotalTeto = qtdPainelTeto * areaPainelTeto;

            // Piso
            int qtdPainelPiso = 0;
            double areaPainelPiso = alturaPisoETeto * larguraPainel;
            double areaTotalPiso = 0;
            if (temPiso) {
                double areaPiso = largura * comprimento;
                qtdPainelPiso = (int) Math.ceil(areaPiso / areaPainelPiso);
                areaTotalPiso = qtdPainelPiso * areaPainelPiso;
            }

            String alturaPisoTetoStr = format(alturaPisoETeto);

            // Ordem: Paredes, Teto, Piso
            tabela.getItems().add(new LinhaTabelaPainel(
                    "Paredes", String.valueOf(qtdPainelParedes), format(altura), format(larguraPainel), format(areaTotalParedes)
            ));
            tabela.getItems().add(new LinhaTabelaPainel(
                    "Teto", String.valueOf(qtdPainelTeto), alturaPisoTetoStr, format(larguraPainel), format(areaTotalTeto)
            ));
            tabela.getItems().add(new LinhaTabelaPainel(
                    "Piso", temPiso ? String.valueOf(qtdPainelPiso) : "-",
                    temPiso ? alturaPisoTetoStr : "-",
                    temPiso ? format(larguraPainel) : "-",
                    temPiso ? format(areaTotalPiso) : "-"
            ));

            int qtdTotal = qtdPainelParedes + (temPiso ? qtdPainelPiso : 0) + qtdPainelTeto;
            double areaTotal = areaTotalParedes + (temPiso ? areaTotalPiso : 0) + areaTotalTeto;

            lbTotalPaineis.setText("Total painéis: " + qtdTotal);
            lbTotalM2.setText("Total m²: " + format(areaTotal));

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Preencha todos os campos corretamente.", ButtonType.OK);
            alert.showAndWait();
        }
    }

    private static String format(double valor) {
        return String.format("%.2f", valor).replace('.', ',');
    }

}