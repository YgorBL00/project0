package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PainelMaterialFX extends SplitPane {

    private boolean listaVisivel = true;

    public PainelMaterialFX() {
        // ------------------ Parte da planilha -----------------------
        TableView<Item> tabela = new TableView<>();

        TableColumn<Item, String> coluna1 = new TableColumn<>("Nome");
        coluna1.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<Item, Integer> coluna2 = new TableColumn<>("Quantidade");
        coluna2.setCellValueFactory(new PropertyValueFactory<>("quantidade"));

        tabela.getColumns().addAll(coluna1, coluna2);
        for (int i = 1; i <= 20; i++) {
            tabela.getItems().add(new Item("Item " + i, i * 5));
        }

        Button btnValores = new Button("Valores");
        btnValores.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        btnValores.setPadding(new Insets(6, 12, 6, 12));

        Label titulo = new Label("Lista de materiais");
        titulo.setFont(Font.font("System", FontWeight.BOLD, 14));

        Button btnToggle = new Button("▲");
        btnToggle.setOnAction(e -> {
            listaVisivel = !listaVisivel;
            tabela.setVisible(listaVisivel);
            tabela.setManaged(listaVisivel);
            btnToggle.setText(listaVisivel ? "▲" : "▼");
        });

        HBox barraTopo = new HBox(titulo, new Region(), btnToggle);
        HBox.setHgrow(barraTopo.getChildren().get(1), Priority.ALWAYS);
        barraTopo.setAlignment(Pos.CENTER_LEFT);
        barraTopo.setPadding(new Insets(5, 10, 5, 10));
        barraTopo.setSpacing(10);
        barraTopo.setStyle("-fx-background-color: #eeeeee; -fx-border-radius: 8 8 0 0; -fx-background-radius: 8 8 0 0;");

        VBox painelTabela = new VBox();
        painelTabela.setPadding(new Insets(10, 10, 5, 10));
        painelTabela.setSpacing(10);
        painelTabela.setStyle("""
            -fx-background-color: white;
            -fx-border-color: #cccccc;
            -fx-border-radius: 8;
            -fx-background-radius: 8;
        """);

        ScrollPane scrollPane = new ScrollPane(tabela);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setStyle("-fx-background-color: transparent;");

        HBox rodape = new HBox(new Region(), btnValores);
        HBox.setHgrow(rodape.getChildren().get(0), Priority.ALWAYS);
        rodape.setPadding(new Insets(0, 0, 0, 0));

        painelTabela.getChildren().addAll(barraTopo, scrollPane, rodape);

        // ------------------ Parte lateral (Custo/Venda) -----------------------
        VBox painelLateral = new VBox(10);
        painelLateral.setPadding(new Insets(10));
        painelLateral.setStyle("""
    -fx-background-color: #f9f9f9;
    -fx-border-color: #cccccc;
    -fx-border-radius: 8;
    -fx-background-radius: 8;
""");

        Label lblCustoTitulo = new Label("Custo da câmara");
        lblCustoTitulo.setFont(Font.font("System", FontWeight.BOLD, 13));

        double custoBase = 100.00;
        Label lblCusto = new Label(String.format("R$ %.2f", custoBase));

        Label lblSugeridoTitulo = new Label("Valor de venda sugerido");
        lblSugeridoTitulo.setFont(Font.font("System", FontWeight.BOLD, 13));

        double vendaSugerida = custoBase * 1.3;
        Label lblSugerido = new Label(String.format("R$ %.2f (30%% de margem)", vendaSugerida));

        Label lblVendaTitulo = new Label("Valor da venda");
        lblVendaTitulo.setFont(Font.font("System", FontWeight.BOLD, 13));

        TextField campoVenda = new TextField();
        campoVenda.setPromptText("Digite o valor de venda");

        Button btnCalcular = new Button("Calcular");
        btnCalcular.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        btnCalcular.setMaxWidth(Double.MAX_VALUE);

        Label lblResultado = new Label();

        btnCalcular.setOnAction(e -> {
            try {
                double venda = Double.parseDouble(campoVenda.getText());
                double lucro = venda - custoBase;
                double porcentagem = (lucro / custoBase) * 100;
                lblResultado.setText(String.format("Lucro: R$ %.2f\nMargem: %.1f%%", lucro, porcentagem));
            } catch (Exception ex) {
                lblResultado.setText("Valor inválido.");
            }
        });

        painelLateral.getChildren().addAll(
                lblCustoTitulo,
                lblCusto,
                lblSugeridoTitulo,
                lblSugerido,
                new Separator(),
                lblVendaTitulo,
                campoVenda,
                btnCalcular,
                lblResultado
        );

        // ------------------ Montagem final -----------------------
        this.getItems().addAll(painelTabela, painelLateral);
        this.setDividerPositions(0.7);

        // Botão "Custos operacionais"
        Button btnCustos = new Button("Custos operacionais");
        btnCustos.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-padding: 10px;");

// Barra inferior no canto esquerdo
        HBox barraInferior2 = new HBox();
        barraInferior2.setPadding(new Insets(10, 10, 10, 10));  // Padding inferior
        barraInferior2.setAlignment(Pos.BOTTOM_RIGHT);  // Alinha no canto inferior esquerdo
        barraInferior2.getChildren().add(btnCustos);

// Coloca a barra inferior dentro do painel de 30% (painelLateral)
        painelLateral.getChildren().add(barraInferior2);

// Ação do botão
        btnCustos.setOnAction(e -> abrirJanelaCustos());

    }

    private void abrirJanelaCustos() {
        Stage popup = new Stage();
        popup.setTitle("Custos Operacionais");

        VBox conteudo = new VBox(10);
        conteudo.setPadding(new Insets(15));
        conteudo.setStyle("-fx-background-color: white;");

        TextField campoTempo = new TextField();
        campoTempo.setPromptText("Tempo da obra (dias)");

        TextField campoEquipe = new TextField();
        campoEquipe.setPromptText("Custo da equipe (R$)");

        TextField campoBonificacao = new TextField();
        campoBonificacao.setPromptText("Bonificação (R$)");

        Button btnSalvar = new Button("Salvar");
        btnSalvar.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        btnSalvar.setMaxWidth(Double.MAX_VALUE);

        btnSalvar.setOnAction(ev -> {
            // Aqui você pode armazenar os dados em variáveis ou passar para outra classe
            String tempo = campoTempo.getText();
            String equipe = campoEquipe.getText();
            String bonificacao = campoBonificacao.getText();

            // Exemplo: print no console (pode substituir por lógica real)
            System.out.println("Tempo da obra: " + tempo);
            System.out.println("Custo equipe: " + equipe);
            System.out.println("Bonificação: " + bonificacao);

            popup.close();
        });

        conteudo.getChildren().addAll(
                new Label("Tempo da obra (dias)"), campoTempo,
                new Label("Custo da equipe"), campoEquipe,
                new Label("Bonificação"), campoBonificacao,
                btnSalvar
        );

        Scene scene = new Scene(conteudo, 300, 280);
        popup.setScene(scene);
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.showAndWait();
    }
    public static class Item {
        private final String nome;
        private final int quantidade;

        public Item(String nome, int quantidade) {
            this.nome = nome;
            this.quantidade = quantidade;
        }

        public String getNome() {
            return nome;
        }

        public int getQuantidade() {
            return quantidade;
        }
    }
}
