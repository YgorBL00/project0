package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class UnidadeCondensadoras {
    private String marca;
    private String modelo;
    private double capacidadeKcal; // Capacidade em kcal/h
    private double temperaturaMin; // Temperatura mínima de operação (°C)
    private double temperaturaMax; // Temperatura máxima de operação (°C)
    private String gas;
    private String tensao;

    public UnidadeCondensadoras(String marca, String modelo, double capacidadeKcal, double temperaturaMin, double temperaturaMax,String gas, String tensao) {
        this.marca = marca;
        this.modelo = modelo;
        this.capacidadeKcal = capacidadeKcal;
        this.temperaturaMin = temperaturaMin;
        this.temperaturaMax = temperaturaMax;
        this.gas = gas;
        this.tensao = tensao;
    }

    public String getModelo() { return modelo; }
    public double getCapacidadeKcal() { return capacidadeKcal; }
    public double getTemperaturaMin() { return temperaturaMin; }
    public double getTemperaturaMax() { return temperaturaMax; }
    public String getTensao() { return tensao; }

    private static final List<UnidadeCondensadoras> catalogo = Arrays.asList(
            new UnidadeCondensadoras("Danfoss","OP-HJM019",2618,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM019",3324,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM019",4130,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM019",5034,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM022",3586,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM022",4421,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM022",5334,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM022",6321,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM028",5279,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM028",6395,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM028",7616,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM028",8943,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM032",5584,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM032",6535,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM032",7850,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM032",9291,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM036",6508,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM036",7796,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM036",9185,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM036",10670,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM040",7421,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM040",8967,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM040",10670,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM040",12210,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM044",7555,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM044",9348,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM044",11330,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM044",13510,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM050",8541,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM050",10460,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM050",12590,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM050",14910,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM056",9554,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM056",11620,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM056",13880,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM056",16320,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM064",10580,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM064",12860,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM064",15360,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM064",18080,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM072",12600,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM072",15370,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM072",18460,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM072",21840,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM080",14110,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM080",17120,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM080",20440,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM080",24040,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM0100",15480,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM0100",18850,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM0100",22580,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM0100",26660,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM0125",21320,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM0125",25910,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM0125",30980,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM0125",36540,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM0144",23680,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM0144",28670,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM0144",34180,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM0144",40180,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM0160",25740,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM0160",31100,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM0160",36990,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM0160",43370,10,20,"R22","220V"),


            new UnidadeCondensadoras("Danfoss","OP-HJZ019",586,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ019",952,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ019",1385,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ019",1888,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ019",2462,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJZ022",1023,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ022",1449,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ022",1995,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ022",2543,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ022",3211,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJZ022",1531,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ022",2098,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ022",2761,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ022",3525,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ022",4394,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJZ028",1616,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ028",2222,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ028",2944,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ028",3785,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ028",4746,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJZ032",1779,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ032",2490,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ032",3325,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ032",4286,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ032",5372,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJZ036",2122,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ036",2972,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ036",3977,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ036",5145,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ036",6479,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJZ040",2168,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ040",3101,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ040",4199,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ040",5471,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ040",6920,-10,-6,"R404A","220V")

            /*
            new UnidadeCondensadoras("Danfoss","OP-HJZ040",586,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ040",952,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ040",1385,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ040",1888,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ040",2462,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJZ044",586,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ044",952,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ044",1385,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ044",1888,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ044",2462,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJZ050",586,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ050",952,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ050",1385,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ050",1888,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ050",2462,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJZ056",586,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ056",952,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ056",1385,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ056",1888,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ056",2462,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJZ064",586,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ064",952,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ064",1385,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ064",1888,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ064",2462,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HGZ072",586,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ072",952,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ072",1385,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ072",1888,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ072",2462,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HGZ080",586,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ080",952,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ080",1385,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ080",1888,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ080",2462,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HGZ0100",586,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ0100",952,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ0100",1385,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ0100",1888,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ0100",2462,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HGZ0125",586,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ0125",952,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ0125",1385,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ0125",1888,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ0125",2462,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HGZ0144",586,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ0160",952,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ0160",1385,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ0160",1888,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ0160",2462,-10,-6,"R404A","220V")
            **/












    );

    public static List<UnidadeCondensadoras> getCatalogo() {
        return catalogo;
    }
}
