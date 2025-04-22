package ui;

import javafx.beans.property.*;

public class ItemMaterial {
    private final IntegerProperty numero;
    private final StringProperty categoria;
    private final StringProperty material;
    private final StringProperty especificacao;
    private final StringProperty unidade;
    private final DoubleProperty quantidade;
    private final StringProperty observacoes;

    public ItemMaterial(int numero, String categoria, String material, String especificacao,
                        String unidade, double quantidade, String observacoes) {
        this.numero = new SimpleIntegerProperty(numero);
        this.categoria = new SimpleStringProperty(categoria);
        this.material = new SimpleStringProperty(material);
        this.especificacao = new SimpleStringProperty(especificacao);
        this.unidade = new SimpleStringProperty(unidade);
        this.quantidade = new SimpleDoubleProperty(quantidade);
        this.observacoes = new SimpleStringProperty(observacoes);
    }

    public IntegerProperty numeroProperty() { return numero; }
    public StringProperty categoriaProperty() { return categoria; }
    public StringProperty materialProperty() { return material; }
    public StringProperty especificacaoProperty() { return especificacao; }
    public StringProperty unidadeProperty() { return unidade; }
    public DoubleProperty quantidadeProperty() { return quantidade; }
    public StringProperty observacoesProperty() { return observacoes; }
}