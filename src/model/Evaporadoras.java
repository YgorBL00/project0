package model;

import java.util.Arrays;
import java.util.List;

public class Evaporadoras {
    private String marca;
    private String modelo;
    private double capacidadeKcal;
    private double temperaturaMin;
    private double temperaturaMax;
    private String gas;
    private String tensao;
    private int hp; // se quiser usar também
    private double Preco;

    public Evaporadoras(String marca, String modelo, double capacidadeKcal,
                        double temperaturaMin, double temperaturaMax, String gas, String tensao, int hp, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.capacidadeKcal = capacidadeKcal;
        this.temperaturaMin = temperaturaMin;
        this.temperaturaMax = temperaturaMax;
        this.gas = gas;
        this.tensao = tensao;
        this.hp = hp;
        this.Preco = preco;
    }

    public String getModelo() { return modelo; }
    public double getCapacidadeKcal() { return capacidadeKcal; }
    public double getTemperaturaMin() { return temperaturaMin; }
    public double getTemperaturaMax() { return temperaturaMax; }
    public String getGas() { return gas; }
    public String getTensao() { return tensao; }
    public int getHp() { return hp; }
    public double getPreco() { return Preco; }

    private static final List<Evaporadoras> catalogo = Arrays.asList(
            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),

            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),

            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),

            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),

            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 10000, -25, 5, "R22", "220V", 1,1),
            new Evaporadoras("MIPAL", "HD400", 12000, -20, 5, "R22", "220V", 1,1)

            // adicione o restante
    );

    public static List<Evaporadoras> getCatalogo() {
        return catalogo;
    }
}
