package ui;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AbaMateriaisFX extends VBox {

    // Modelo de dados
    public static class ItemMaterial {
        private final IntegerProperty numero;
        private final StringProperty categoria;
        private final StringProperty material;
        private final StringProperty especificacao;
        private final StringProperty unidade;
        private final DoubleProperty quantidade;
        private final DoubleProperty valor; // Novo valor
        private final StringProperty observacoes;

        public ItemMaterial(int numero, String categoria, String material, String especificacao,
                            String unidade, double quantidade, double valor, String observacoes) {
            this.numero = new SimpleIntegerProperty(numero);
            this.categoria = new SimpleStringProperty(categoria);
            this.material = new SimpleStringProperty(material);
            this.especificacao = new SimpleStringProperty(especificacao);
            this.unidade = new SimpleStringProperty(unidade);
            this.quantidade = new SimpleDoubleProperty(quantidade);
            this.valor = new SimpleDoubleProperty(valor); // Novo valor
            this.observacoes = new SimpleStringProperty(observacoes);
        }

        public IntegerProperty numeroProperty() { return numero; }
        public StringProperty categoriaProperty() { return categoria; }
        public StringProperty materialProperty() { return material; }
        public StringProperty especificacaoProperty() { return especificacao; }
        public StringProperty unidadeProperty() { return unidade; }
        public DoubleProperty quantidadeProperty() { return quantidade; }
        public DoubleProperty valorProperty() { return valor; } // Getter novo
        public StringProperty observacoesProperty() { return observacoes; }
    }

    private final TableView<ItemMaterial> tabela = new TableView<>();
    private boolean isMinimized = false; // Estado do painel minimizado

    public AbaMateriaisFX() {
        setPadding(new Insets(10));
        setSpacing(10);

        // Configuração da tabela
        configurarTabela();

        // Criação do cabeçalho com botão minimizar/maximizar
        HBox header = criarHeader();

        // Botão "Valor do Material"
        Button btnValorMaterial = criarBotaoValorMaterial();

        // Layout final
        getChildren().addAll(header, tabela, btnValorMaterial);
    }

    private void configurarTabela() {
        tabela.setItems(getMateriais());

        TableColumn<ItemMaterial, Number> colNum = new TableColumn<>("#");
        colNum.setCellValueFactory(cellData -> cellData.getValue().numeroProperty());
        colNum.setPrefWidth(35);

        TableColumn<ItemMaterial, String> colCategoria = new TableColumn<>("Categoria");
        colCategoria.setCellValueFactory(cellData -> cellData.getValue().categoriaProperty());
        colCategoria.setPrefWidth(100);

        TableColumn<ItemMaterial, String> colMaterial = new TableColumn<>("Material/Item");
        colMaterial.setCellValueFactory(cellData -> cellData.getValue().materialProperty());
        colMaterial.setPrefWidth(180);

        TableColumn<ItemMaterial, String> colEspecificacao = new TableColumn<>("Especificação/Medida");
        colEspecificacao.setCellValueFactory(cellData -> cellData.getValue().especificacaoProperty());
        colEspecificacao.setPrefWidth(220);

        TableColumn<ItemMaterial, String> colUnidade = new TableColumn<>("Unid.");
        colUnidade.setCellValueFactory(cellData -> cellData.getValue().unidadeProperty());
        colUnidade.setPrefWidth(60);

        TableColumn<ItemMaterial, Number> colQtd = new TableColumn<>("Qtd.");
        colQtd.setCellValueFactory(cellData -> cellData.getValue().quantidadeProperty());
        colQtd.setPrefWidth(55);

        TableColumn<ItemMaterial, Number> colValor = new TableColumn<>("Valor");
        colValor.setCellValueFactory(cellData -> cellData.getValue().valorProperty());
        colValor.setPrefWidth(70);

        TableColumn<ItemMaterial, String> colObs = new TableColumn<>("Observações");
        colObs.setCellValueFactory(cellData -> cellData.getValue().observacoesProperty());
        colObs.setPrefWidth(220);

        tabela.getColumns().addAll(colNum, colCategoria, colMaterial, colEspecificacao, colUnidade, colQtd, colValor, colObs);
        tabela.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tabela.setPrefHeight(400); // Altura inicial
    }

    private HBox criarHeader() {
        HBox header = new HBox();
        header.setSpacing(10);
        header.setAlignment(Pos.CENTER_RIGHT);
        header.setPadding(new Insets(5));

        Label title = new Label("Detalhamento dos Materiais");
        title.setStyle("-fx-font-weight: bold;");

        Button btnMinimizar = new Button("_");
        btnMinimizar.setPrefWidth(30);
        btnMinimizar.setOnAction(e -> {
            if (isMinimized) {
                tabela.setPrefHeight(400); // Restaurar tamanho original
                btnMinimizar.setText("_");
            } else {
                tabela.setPrefHeight(0); // Ocultar tabela
                btnMinimizar.setText("+");
            }
            isMinimized = !isMinimized;
        });

        header.getChildren().addAll(title, btnMinimizar);
        return header;
    }

    private Button criarBotaoValorMaterial() {
        Button btnValorMaterial = new Button("Valor do Material");
        btnValorMaterial.setAlignment(Pos.BASELINE_LEFT);
        btnValorMaterial.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Editar Valores");
            alert.setHeaderText("Edição de Valores");
            alert.setContentText("Aqui você poderá editar os valores dos materiais.");
            alert.showAndWait();
        });
        return btnValorMaterial;
    }

    private ObservableList<ItemMaterial> getMateriais() {
        return FXCollections.observableArrayList(
                new ItemMaterial(1, "Painéis", "Painel Isotérmico – Parede", "PU, 100mm, branco", "m²", 12, 150.0, "Conforme cálculo"),
                new ItemMaterial(2, "Painéis", "Painel Isotérmico – Teto", "PU, 100mm, branco", "m²", 8, 120.0, "Conforme cálculo"),
                new ItemMaterial(3, "Painéis", "Painel Isotérmico – Piso", "PU, 100mm, antiderrapante", "m²", 8, 200.0, "Se aplicável"),
                new ItemMaterial(4, "Porta", "Porta Isotérmica", "2,10x0,90m, abrir, c/vedação", "un", 1, 1000.0, "Entrada principal")
                // Adicione mais itens conforme necessário.
        );
    }
}