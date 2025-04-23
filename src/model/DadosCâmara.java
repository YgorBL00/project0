package model;

public class DadosCâmara {
    public static double comprimento = 0, largura = 0, altura = 0, espessura = 0;

    public static double getComprimento() { return comprimento; }
    public static double getLargura() { return largura; }
    public static double getAltura() { return altura; }
    public static double getEspessura() { return espessura; }

    public static void set(double novoComprimento, double novaLargura, double novaAltura, double novaEspessura) {
        comprimento = novoComprimento;
        largura = novaLargura;
        altura = novaAltura;
        espessura = novaEspessura;
    }
}