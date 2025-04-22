package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PainelCargaTermicaFX extends VBox {
    // --- Área 1
    private TextField compField, alturaField, larguraField, areaPortaField, espessuraField;
    private ComboBox<String> isolanteCombo;
    private Label condutividadeLabel;

    // --- Área 2
    private TextField tempAmbField, tempIntField, tempEntProdField, qtdProdField;
    private ComboBox<String> tipoProdBox, variedadeProdBox;

    // --- Área 3
    private TextField resultadoField;
    private ToggleGroup unidadeGroup;

    // --- Considerações adicionais (modal) - agora são atributos!
    private TextField pessoasField, permanenciaField, tempoCondField,
            potIluminacaoField, tempoIlumField, potMotoresField, tempoMotorField;

    public PainelCargaTermicaFX() {
        setPrefHeight(550);
        setStyle("-fx-background-color:linear-gradient(#f8fafc 85%, #ebeef2 100%);-fx-border-color:#afc3d6;-fx-border-width:1px;");

        // ============ ÁREA 1 ============
        VBox area1 = criarArea1();
        area1.setPrefWidth(315);
        area1.setMaxWidth(320);

        // ============ ÁREA 2 ============
        VBox area2 = criarArea2();
        area2.setPrefWidth(315);
        area2.setMaxWidth(320);

        // ============ ÁREA 3 (Resultado) ============
        VBox area3 = criarArea3();
        area3.setPrefWidth(270);
        area3.setMaxWidth(280);

        // ============ LAYOUT PRINCIPAL ============
        HBox principal = new HBox(18, area1, area2, area3);
        principal.setPadding(new Insets(28, 16, 0, 32));
        principal.setPrefHeight(450);

        // ========= BOTÃO CONSIDERAÇÕES ADICIONAIS =========
        Button consideracoesBtn = new Button("Considerações adicionais");
        consideracoesBtn.setStyle("-fx-background-color:#e1e2e9;-fx-text-fill:#27416b;-fx-font-weight:bold;-fx-border-radius:8px;-fx-background-radius:8px;-fx-border-color:#b6b7bb;");
        consideracoesBtn.setPrefWidth(160);
        consideracoesBtn.setPrefHeight(28);
        consideracoesBtn.setOnAction(e -> mostrarConsideracoesAdicionais());

        HBox boxConsideracoes = new HBox(consideracoesBtn);
        boxConsideracoes.setAlignment(Pos.CENTER_LEFT);
        boxConsideracoes.setPadding(new Insets(16, 0, 8, 33));

        // =========== FINAL ===========
        getChildren().addAll(principal, boxConsideracoes);
    }

    private VBox criarArea1() {
        VBox box = new VBox(15);
        box.setPadding(new Insets(18,16,10,16));
        box.setStyle("-fx-border-color:#c5cedf;-fx-border-width:1.6;-fx-background-color:#f3f4f6;-fx-background-radius:7px;-fx-border-radius:7px;");
        Text titulo = new Text("Área 1 – Dimensões e Isolamento");
        titulo.setStyle("-fx-font-weight:bold;-fx-font-size:15px;");

        GridPane grid = new GridPane();
        grid.setHgap(12); grid.setVgap(10);
        int ln=0;
        grid.add(lblObg("Comprimento (m):"), 0, ln);   compField = campoEx("10");   grid.add(compField,1,ln++);
        grid.add(lblObg("Altura (m):"),      0, ln);   alturaField = campoEx("3");  grid.add(alturaField,1,ln++);
        grid.add(lblObg("Largura (m):"),     0, ln);   larguraField = campoEx("4"); grid.add(larguraField,1,ln++);
        grid.add(new Label("Área da porta (m²):"), 0, ln); areaPortaField = campoEx("1"); grid.add(areaPortaField,1,ln++);

        grid.add(lblObg("Material isolante:"), 0, ln);
        isolanteCombo = new ComboBox<>();
        isolanteCombo.getItems().addAll("PIR", "PUR", "EPS");
        isolanteCombo.setValue("PUR");
        isolanteCombo.setStyle("-fx-font-size:10.5pt;-fx-fill:#626675;");
        grid.add(isolanteCombo,1,ln);

        grid.add(lblObg("Espessura (mm):"),0,++ln);   espessuraField = campoEx("100"); grid.add(espessuraField,1,ln);

        grid.add(new Label("Condutividade térmica (W/m.K):"),0,++ln);
        condutividadeLabel = new Label(condutPorMaterial("PUR"));
        condutividadeLabel.setStyle("-fx-background-color:#f3f4f6;-fx-padding:1 8 1 8;-fx-border-radius:5px;-fx-background-radius:5px;");
        grid.add(condutividadeLabel,1,ln);

        // Atualização automática
        isolanteCombo.setOnAction(e -> condutividadeLabel.setText(condutPorMaterial(isolanteCombo.getValue())));

        box.getChildren().addAll(titulo, grid, obs("Todos os campos obrigatórios*.\nCondutividade fixa do material: PIR=0,018 | PUR=0,019 | EPS=0,027"));
        return box;
    }

    private VBox criarArea2() {
        VBox box = new VBox(15);
        box.setPadding(new Insets(18,16,10,16));
        box.setStyle("-fx-border-color:#c5cedf;-fx-border-width:1.6;-fx-background-color:#f3f4f6;-fx-background-radius:7px;-fx-border-radius:7px;");
        Text titulo = new Text("Área 2 – Temperaturas e Produto");
        titulo.setStyle("-fx-font-weight:bold;-fx-font-size:15px;");

        GridPane grid = new GridPane();
        grid.setHgap(12); grid.setVgap(10);
        int ln=0;
        grid.add(lblObg("Temperatura ambiente (°C):"), 0, ln); tempAmbField = campoEx("32"); grid.add(tempAmbField,1,ln++);
        grid.add(lblObg("Temperatura interna (°C):"), 0, ln);  tempIntField = campoEx("1");  grid.add(tempIntField,1,ln++);

        // Tipo do produto
        grid.add(lblObg("Tipo de produto:"), 0, ln);
        tipoProdBox = new ComboBox<>();
        tipoProdBox.getItems().addAll("Carnes", "Frutas", "Vegetais", "Laticínios", "Outros");
        tipoProdBox.setValue("Carnes");
        tipoProdBox.setStyle("-fx-background-color:#f3f4f6;");
        grid.add(tipoProdBox,1,ln++);

        // Variedade do produto (dinâmico)
        grid.add(lblObg("Variedade:"), 0, ln);
        variedadeProdBox = new ComboBox<>();
        variedadeProdBox.setStyle("-fx-background-color:#f3f4f6;");
        variedadeProdBox.setPrefWidth(150);
        grid.add(variedadeProdBox, 1, ln++);

        // Popula variedades iniciais
        atualizarVariedades("Carnes");

        // Atualiza ao mudar o tipo
        tipoProdBox.setOnAction(e -> atualizarVariedades(tipoProdBox.getValue()));

        grid.add(lblObg("Temp. entrada produto (°C):"),0,ln);  tempEntProdField = campoEx("22"); grid.add(tempEntProdField,1,ln++);
        grid.add(lblObg("Movimentação/dia (kg):"),    0, ln);  qtdProdField = campoEx("700"); grid.add(qtdProdField,1,ln);

        box.getChildren().addAll(titulo, grid, obs("Preencha valores reais para maior precisão."));
        return box;
    }
    private void atualizarVariedades(String tipo) {
        variedadeProdBox.getItems().clear();
        switch (tipo) {
            case "Carnes" -> variedadeProdBox.getItems().addAll(
                    "Bovina - Ponta de Agulha", "Bovina - Coxão Mole", "Bovina - Acém", "Bovina - Maminha", "Bovina - Outro",
                    "Suína - Lombo", "Suína - Pernil", "Suína - Costela", "Suína - Outro",
                    "Aves - Frango", "Aves - Peru", "Aves - Chester", "Aves - Outro",
                    "Peixes - Tilápia", "Peixes - Salmão", "Peixes - Merluza", "Peixes - Outro"
            );
            case "Frutas" -> variedadeProdBox.getItems().addAll(
                    "Banana Prata", "Banana Nanica", "Maçã Gala", "Maçã Fuji", "Maçã Verde",
                    "Abacaxi Pérola", "Abacaxi Havaí",
                    "Uva Itália", "Uva Niágara", "Uva Thompson",
                    "Melancia", "Melão", "Mamão", "Manga Palmer", "Manga Tommy", "Laranja Pera", "Laranja Lima",
                    "Limão Tahiti", "Limão Siciliano", "Abacate", "Outro"
            );
            case "Vegetais" -> variedadeProdBox.getItems().addAll(
                    "Batata Inglesa", "Batata Doce",
                    "Cenoura", "Beterraba", "Tomate Italiano", "Tomate Cereja", "Cebola Roxa", "Cebola Amarela",
                    "Alface Crespa", "Alface Americana", "Repolho Verde", "Repolho Roxo", "Rúcula", "Agrião", "Rabanete",
                    "Pepino", "Pimentão Verde", "Pimentão Amarelo", "Pimentão Vermelho", "Brócolis", "Couve-flor", "Abobrinha", "Outro"
            );
            case "Laticínios" -> variedadeProdBox.getItems().addAll(
                    "Queijo Mussarela", "Queijo Prato", "Queijo Parmesão", "Queijo Coalho", "Queijo Minas", "Queijo Gouda", "Queijo Brie",
                    "Leite Integral", "Leite Desnatado", "Leite Longa Vida", "Iogurte Natural", "Iogurte Grego",
                    "Requeijão", "Manteiga", "Creme de Leite", "Ricota", "Doce de Leite", "Outro"
            );
            case "Outros" -> variedadeProdBox.getItems().addAll(
                    "Produtos Industrializados", "Grãos - Arroz", "Grãos - Feijão", "Grãos - Milho", "Grãos - Soja",
                    "Embutidos - Presunto", "Embutidos - Mortadela", "Embutidos - Salsicha", "Outros Frios", "Doces", "Bebidas", "Outro"
            );
        }
        if (!variedadeProdBox.getItems().isEmpty()) {
            variedadeProdBox.setValue(variedadeProdBox.getItems().get(0));
        }
    }

    private VBox criarArea3() {
        VBox box = new VBox(18);
        box.setAlignment(Pos.TOP_CENTER);
        box.setPadding(new Insets(24,12,12,12));
        box.setStyle("-fx-background-color:#f3f4f6;-fx-border-color:#b7c1d4;-fx-border-width:1.4;-fx-background-radius:7px;-fx-border-radius:7px;");

        Text labelExplicativo = new Text("Informe a carga térmica");
        labelExplicativo.setStyle("-fx-font-size:15px;-fx-font-weight:bold;");

        // Unidade (se quiser manter)
        unidadeGroup = new ToggleGroup();
        RadioButton btuBtn = new RadioButton("BTU/h");
        RadioButton kcalBtn = new RadioButton("kcal/h");
        btuBtn.setToggleGroup(unidadeGroup);
        kcalBtn.setToggleGroup(unidadeGroup);
        btuBtn.setSelected(true);
        HBox unidadeBox = new HBox(10, btuBtn, kcalBtn);

        // Caixa para digitar o resultado (agora editável)
        resultadoField = new TextField();
        resultadoField.setPromptText("Digite o valor…");
        resultadoField.setEditable(true);
        resultadoField.setPrefWidth(120);
        resultadoField.setStyle("-fx-background-color:#fffbe6;-fx-font-weight:bold;-fx-font-size:15px;");

        box.getChildren().addAll(labelExplicativo, unidadeBox, resultadoField);
        return box;
    }



    // UTILITÁRIOS
    private static Label lblObg(String t) { Label l = new Label(t); l.setStyle("-fx-font-weight:bold;-fx-text-fill:#162d52;"); return l; }
    private static String condutPorMaterial(String m) {
        return switch (m) { case "PIR" -> "0,018"; case "PUR" -> "0,019"; case "EPS" -> "0,027"; default -> "-"; };
    }
    private static TextField campoEx(String ex) { TextField t=new TextField(); t.setPromptText("Ex: "+ex); t.setPrefWidth(100); return t; }
    private static Text obs(String t) { Text n=new Text(t); n.setStyle("-fx-font-size:10.5pt;-fx-fill:#626675;"); return n; }

    // Novo utilitário local:
    private Label lblUnid(String s) {
        Label l = new Label(s);
        l.setStyle("-fx-text-fill:#6e7fa1;");
        return l;
    }

    // Considerações Adicionais – MODAL COMPLETO: TODOS OS CAMPOS SÃO ATRIBUTOS!
    private void mostrarConsideracoesAdicionais() {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Passo 3 – Considerações Adicionais");

        VBox mainBox = new VBox(18);
        mainBox.setPadding(new Insets(22,28,22,28));
        mainBox.setStyle("-fx-border-color:#aac5e2; -fx-border-width:1.5; -fx-background-color:#f3f4f6;");

        Text titulo = new Text("Passo 3 – Considerações Adicionais");
        titulo.setStyle("-fx-font-size:15.5px; -fx-font-weight:bold; -fx-fill:#204d85;");

        // --- Bloco 1: Considerações Gerais ---
        GridPane gridCons = new GridPane();
        gridCons.setHgap(14); gridCons.setVgap(8);

        int ln = 0;
        gridCons.add(lblObg("Número de pessoas na câmara:"), 0, ln);
        pessoasField = campoEx("1");
        pessoasField.setText(pessoasField.getText().isEmpty() ? "1" : pessoasField.getText()); // manter se já preenchido
        gridCons.add(pessoasField, 1, ln);

        gridCons.add(lblObg("Tempo de permanência:"), 0, ++ln);
        permanenciaField = campoEx("h");
        permanenciaField.setText(permanenciaField.getText().isEmpty() ? "1" : permanenciaField.getText());
        gridCons.add(permanenciaField, 1, ln);
        gridCons.add(lblUnid("h"), 2, ln);

        gridCons.add(lblObg("Tempo unidade condensadora:"), 0, ++ln);
        tempoCondField = campoEx("h");
        tempoCondField.setText(tempoCondField.getText().isEmpty() ? "18" : tempoCondField.getText());
        gridCons.add(tempoCondField, 1, ln);
        gridCons.add(lblUnid("h"), 2, ln);

        // --- Título bloco equipamentos ---
        Text tituloEq = new Text("Equipamentos que Geram Calor na Câmara");
        tituloEq.setStyle("-fx-font-size:13.5px; -fx-font-weight:bold; -fx-fill:#274d72;");

        // --- Bloco 2: Equipamentos ---
        GridPane gridEq = new GridPane();
        gridEq.setHgap(14); gridEq.setVgap(8);

        int lnEq = 0;
        gridEq.add(lblObg("Potência da iluminação:"), 0, lnEq);
        potIluminacaoField = campoEx("W");
        potIluminacaoField.setText(potIluminacaoField.getText().isEmpty() ? "600" : potIluminacaoField.getText());
        gridEq.add(potIluminacaoField, 1, lnEq);
        gridEq.add(lblUnid("W"), 2, lnEq);

        gridEq.add(lblObg("Tempo de iluminação:"), 0, ++lnEq);
        tempoIlumField = campoEx("h");
        tempoIlumField.setText(tempoIlumField.getText().isEmpty() ? "1" : tempoIlumField.getText());
        gridEq.add(tempoIlumField, 1, lnEq);
        gridEq.add(lblUnid("h"), 2, lnEq);

        gridEq.add(lblObg("Potência total dos motores:"), 0, ++lnEq);
        potMotoresField = campoEx("HP");
        potMotoresField.setText(potMotoresField.getText().isEmpty() ? "1" : potMotoresField.getText());
        gridEq.add(potMotoresField, 1, lnEq);
        gridEq.add(lblUnid("HP"), 2, lnEq);

        gridEq.add(lblObg("Tempo de trabalho do motor:"), 0, ++lnEq);
        tempoMotorField = campoEx("h");
        tempoMotorField.setText(tempoMotorField.getText().isEmpty() ? "1" : tempoMotorField.getText());
        gridEq.add(tempoMotorField, 1, lnEq);
        gridEq.add(lblUnid("h"), 2, lnEq);

        // Botão Fechar
        Button fecharBtn = new Button("Fechar");
        fecharBtn.setPrefWidth(86);
        fecharBtn.setStyle("-fx-background-color:#e0e6ef;-fx-text-fill:#204d85;-fx-font-weight:bold;-fx-background-radius:6;-fx-border-radius:6;");
        fecharBtn.setOnAction(e -> dialog.close());

        HBox fecharBox = new HBox(fecharBtn);
        fecharBox.setAlignment(Pos.CENTER_RIGHT);

        mainBox.getChildren().addAll(
                titulo,
                new VBox(8, gridCons),
                tituloEq,
                new VBox(8, gridEq),
                fecharBox
        );

        Scene scene = new Scene(mainBox, 500, 380);
        dialog.setScene(scene);
        dialog.showAndWait();
    }
}