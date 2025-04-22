package ui;

import ui.AbaMateriaisFX;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class JanelaAbasManualFX extends TabPane {

    public JanelaAbasManualFX(Stage stage) {
        Tab aba1 = new Tab("Cálculo de Painéis", new PainelCalculoPaineisFX());
        Tab aba2 = new Tab("Carga Térmica", new PainelCargaTermicaFX());
        Tab aba3 = new Tab("Matérias", new AbaMateriaisFX());
        Tab aba4 = new Tab("Ordem Serviço", new javafx.scene.control.Label("Conteúdo da Aba 4"));

        // NENHUMA aba pode ser fechada
        aba1.setClosable(false);
        aba2.setClosable(false);
        aba3.setClosable(false);
        aba4.setClosable(false);

        this.getTabs().addAll(aba1, aba2, aba3, aba4);
        // Aqui você pode adicionar lógica de troca de tela, se desejar.
    }
}