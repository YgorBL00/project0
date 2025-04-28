package model;

public class DadosCargaTermica {
    private double cargaTermica; // em kcal/h
    private double temperaturaDesejada; // em °C

    public DadosCargaTermica(double cargaTermica, double temperaturaDesejada) {
        this.cargaTermica = cargaTermica;
        this.temperaturaDesejada = temperaturaDesejada;
    }

    public double getCargaTermica() { return cargaTermica; }
    public void setCargaTermica(double cargaTermica) { this.cargaTermica = cargaTermica; }

    public double getTemperaturaDesejada() { return temperaturaDesejada; }
    public void setTemperaturaDesejada(double temperaturaDesejada) { this.temperaturaDesejada = temperaturaDesejada; }
}