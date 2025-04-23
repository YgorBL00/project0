package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.DadosCâmara;
import java.util.*;

public class PainelCargaTermicaFX extends HBox {

    private final Label lbComprimento = new Label();
    private final Label lbLargura = new Label();
    private final Label lbAltura = new Label();
    private final Label lbEspessura = new Label();

    // Isolamento
    private final ComboBox<String> cbIsolamento = new ComboBox<>();
    private final TextField tfCondutividade = new TextField();
    private final Button btnConsideracoes = new Button("Considerações adicionais");

    // Bloco Meio - Temperaturas e Produto
    private final TextField tfTempAmbiente = new TextField();
    private final TextField tfTempDesejada = new TextField();
    private final ComboBox<String> cbTipoProduto = new ComboBox<>();
    private final ComboBox<String> cbProduto = new ComboBox<>();
    private final TextField tfTempEntradaProduto = new TextField();
    private final TextField tfQtdProdutoDia = new TextField();
    private final TextField tfTempoProcessamento = new TextField();

    // Bloco Direito - Carga Térmica
    private final TextField tfCargaTermica = new TextField();

    // Tabelas para produtos
    private final Map<String, List<String>> produtosPorTipo = new HashMap<>();

    // Tabela de condutividades
    private final Map<String, String> condutividades = Map.of(
            "PIR", "0,021 W/m·K",
            "PUR", "0,023 W/m·K",
            "EPS", "0,036 W/m·K"
    );

    public PainelCargaTermicaFX() {
        setSpacing(18);
        setPadding(new Insets(18));
        setStyle("-fx-background-color: #f7f7fc;"); // cor de fundo bem clara

        // Preencher dados de produtos
        produtosPorTipo.put("Frutas", Arrays.asList("Maçã", "Banana", "Laranja", "Uva", "Pera", "Melancia", "Manga", "Abacaxi", "Morango", "Melão"));
        produtosPorTipo.put("Carnes", Arrays.asList("Bovina", "Suína", "Frango", "Peixe", "Cordeiro", "Carneiro", "Peru", "Pato", "Coelho", "Vitela"));
        produtosPorTipo.put("Laticínios", Arrays.asList("Leite", "Queijo", "Iogurte", "Manteiga", "Requeijão", "Leite condensado", "Creme de leite", "Soro de leite", "Ricota", "Doce de leite"));
        produtosPorTipo.put("Grãos", Arrays.asList("Arroz", "Feijão", "Trigo", "Soja", "Milho", "Cevada", "Aveia", "Quinoa", "Lentilha", "Grão-de-bico"));
        produtosPorTipo.put("Vegetais", Arrays.asList("Batata", "Cenoura", "Tomate", "Cebola", "Alface", "Brócolis", "Espinafre", "Pepino", "Abobrinha", "Berinjela"));

        VBox blocoEsquerdo = criarBlocoEsquerdo();
        VBox blocoMeio = criarBlocoMeio();
        VBox blocoDireito = criarBlocoDireito();

        getChildren().addAll(blocoEsquerdo, blocoMeio, blocoDireito);
        atualizarDados();
    }

    private VBox criarBlocoEsquerdo() {
        VBox box = new VBox(14);
        box.setPadding(new Insets(16));
        box.setPrefWidth(250);
        box.setStyle("-fx-background-color: #f9fafd; -fx-border-color: #e3e6ef; -fx-border-width: 1; -fx-border-radius: 7; -fx-background-radius: 7;");

        VBox painelDimensao = new VBox(7,
                titulo("Dimensões da Câmara"),
                linha("Comprimento (m):", lbComprimento),
                linha("Largura (m):", lbLargura),
                linha("Altura (m):", lbAltura),
                linha("Espessura (mm):", lbEspessura)
        );
        painelDimensao.setStyle("-fx-background-color: #ffffff; -fx-border-color: #ececec; -fx-border-width: 1; -fx-border-radius: 6; -fx-background-radius: 6;");

        cbIsolamento.getItems().addAll("PIR", "PUR", "EPS");
        cbIsolamento.setValue("PIR");
        cbIsolamento.valueProperty().addListener((o, a, novo) -> atualizarCondutividade());

        tfCondutividade.setEditable(false);
        tfCondutividade.setFocusTraversable(false);

        VBox painelIsolamento = new VBox(7,
                titulo("Isolamento"),
                new HBox(10, new Label("Tipo:"), cbIsolamento),
                new HBox(10, new Label("Condutividade (λ):"), tfCondutividade)
        );
        painelIsolamento.setStyle("-fx-background-color: #fffefe; -fx-border-color: #ececec; -fx-border-width: 1; -fx-border-radius: 6; -fx-background-radius: 6;");

        Region espaco = new Region();
        VBox.setVgrow(espaco, Priority.ALWAYS);
        HBox botaoBox = new HBox(btnConsideracoes);
        botaoBox.setAlignment(Pos.BOTTOM_LEFT);

        box.getChildren().addAll(painelDimensao, painelIsolamento, espaco, botaoBox);
        box.setAlignment(Pos.TOP_LEFT);
        atualizarCondutividade();
        return box;
    }

    private VBox criarBlocoMeio() {
        VBox box = new VBox(14);
        box.setPadding(new Insets(16));
        box.setPrefWidth(320);
        box.setStyle("-fx-background-color: #f9fafd; -fx-border-color: #e3e6ef; -fx-border-width: 1; -fx-border-radius: 7; -fx-background-radius: 7;");

        Label titulo = titulo("Condições e Produto");

        cbTipoProduto.getItems().addAll(produtosPorTipo.keySet());
        cbTipoProduto.setPromptText("Escolha o tipo");
        cbTipoProduto.valueProperty().addListener((o, a, novo) -> atualizarProdutos());
        cbTipoProduto.setValue("Frutas");
        cbProduto.setPromptText("Escolha o produto");

        atualizarProdutos();

        GridPane painel = new GridPane();
        painel.setHgap(8);
        painel.setVgap(8);
        int row = 0;
        painel.add(new Label("Temperatura ambiente (°C):"), 0, row); painel.add(tfTempAmbiente, 1, row++);
        painel.add(new Label("Temperatura desejada (°C):"), 0, row); painel.add(tfTempDesejada, 1, row++);
        painel.add(new Label("Tipo do produto:"), 0, row); painel.add(cbTipoProduto, 1, row++);
        painel.add(new Label("Produto:"), 0, row); painel.add(cbProduto, 1, row++);
        painel.add(new Label("Temp. entrada do produto (°C):"), 0, row); painel.add(tfTempEntradaProduto, 1, row++);
        painel.add(new Label("Qtd produto/dia (kg):"), 0, row); painel.add(tfQtdProdutoDia, 1, row++);
        painel.add(new Label("Tempo process. (h):"), 0, row); painel.add(tfTempoProcessamento, 1, row++);

        box.getChildren().addAll(titulo, painel);
        box.setAlignment(Pos.TOP_LEFT);
        return box;
    }

    private VBox criarBlocoDireito() {
        VBox box = new VBox(22);
        box.setPadding(new Insets(16));
        box.setPrefWidth(230);
        box.setStyle("-fx-background-color: #f9fafd; -fx-border-color: #e3e6ef; -fx-border-width: 1; -fx-border-radius: 7; -fx-background-radius: 7;");

        Label titulo = titulo("Carga Térmica");

        Label sub = new Label("Carga térmica necessária (kcal/h):");
        box.getChildren().addAll(titulo, sub, tfCargaTermica);

        return box;
    }

    private Label titulo(String txt) {
        Label lb = new Label(txt);
        lb.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: #205081;");
        return lb;
    }
    private HBox linha(String nome, Label valor) {
        HBox h = new HBox(8, new Label(nome), valor);
        h.setAlignment(Pos.CENTER_LEFT);
        return h;
    }

    public void atualizarDados() {
        lbComprimento.setText(String.format("%.2f", DadosCâmara.getComprimento()));
        lbLargura.setText(String.format("%.2f", DadosCâmara.getLargura()));
        lbAltura.setText(String.format("%.2f", DadosCâmara.getAltura()));
        lbEspessura.setText(String.format("%.0f", DadosCâmara.getEspessura()));
    }
    private void atualizarCondutividade() {
        String tipo = cbIsolamento.getValue();
        tfCondutividade.setText(condutividades.getOrDefault(tipo, ""));
    }
    private void atualizarProdutos() {
        String tipo = cbTipoProduto.getValue();
        cbProduto.getItems().clear();
        if (tipo != null && produtosPorTipo.containsKey(tipo)) {
            cbProduto.getItems().addAll(produtosPorTipo.get(tipo));
            cbProduto.setValue(produtosPorTipo.get(tipo).get(0));
        }
    }
}