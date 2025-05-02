package model;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import ui.PainelCalculoPaineisFX;
import ui.PainelCargaTermicaFX;
import ui.PainelMaterialFX;

public class JanelaAbasManualFX extends TabPane {

    public JanelaAbasManualFX(Stage stage) {

        PainelCalculoPaineisFX painel1 = new PainelCalculoPaineisFX();
        PainelCargaTermicaFX painel2 = new PainelCargaTermicaFX();
        PainelMaterialFX painel3 = new PainelMaterialFX();

        painel2.setPainelMaterialFX(painel3);

        Tab aba1 = new Tab("Cálculo de Painéis", painel1);
        Tab aba2 = new Tab("Carga Térmica", painel2);
        Tab aba3 = new Tab("Matérias", painel3);
        Tab aba4 = new Tab("Ordem Serviço", new javafx.scene.control.Label("Conteúdo da Aba 4"));

        // NENHUMA aba pode ser fechada
        aba1.setClosable(false);
        aba2.setClosable(false);
        aba3.setClosable(false);
        aba4.setClosable(false);

        this.getTabs().addAll(aba1, aba2, aba3, aba4);
        // Aqui você pode adicionar lógica de troca de tela, se desejar.
        this.getSelectionModel().selectedItemProperty().addListener((obs, oldTab, newTab) -> {
            if (newTab == aba2) {
                // Dá um cast para acessar métodos da aba 2, se precisar
                if (aba2.getContent() instanceof PainelCargaTermicaFX) {
                    ((PainelCargaTermicaFX) aba2.getContent()).atualizarDados();

                }
            }
    });
    }
}