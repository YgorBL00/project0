package model;

public class Evaporadoras {
    private String modelo;
    private double capacidadeKcal;
    private double tempOperacao;
    private String tensao;

    public Evaporadoras(String modelo, double capacidadeKcal, double tempOperacao, String tensao) {
        this.modelo = modelo;
        this.capacidadeKcal = capacidadeKcal;
        this.tempOperacao = tempOperacao;
        this.tensao = tensao;
    }

    public String getModelo() { return modelo; }
    public double getCapacidadeKcal() { return capacidadeKcal; }
    public double getTempOperacao() { return tempOperacao; }
    public String getTensao() { return tensao; }
}