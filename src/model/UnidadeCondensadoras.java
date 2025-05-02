package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class UnidadeCondensadoras {
    private String marca;
    private String modelo;
    private String HP;
    private double capacidadeKcal; // Capacidade em kcal/h
    private double temperaturaMin; // Temperatura mínima de operação (°C)
    private double temperaturaMax; // Temperatura máxima de operação (°C)
    private String gas;
    private String tensao;

    public UnidadeCondensadoras(String marca, String modelo,String HP, double capacidadeKcal, double temperaturaMin, double temperaturaMax,String gas, String tensao) {
        this.marca = marca;
        this.modelo = modelo;
        this.HP = HP;
        this.capacidadeKcal = capacidadeKcal;
        this.temperaturaMin = temperaturaMin;
        this.temperaturaMax = temperaturaMax;
        this.gas = gas;
        this.tensao = tensao;
    }

    public String getModelo() { return modelo; }
    public String getHP() {return HP;}
    public double getCapacidadeKcal() { return capacidadeKcal; }
    public double getTemperaturaMin() { return temperaturaMin; }
    public double getTemperaturaMax() { return temperaturaMax; }
    public String getTensao() { return tensao; }

    private static final List<UnidadeCondensadoras> catalogo = Arrays.asList(
            new UnidadeCondensadoras("Danfoss","OP-HJM019","1",2618,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM019","1",3324,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM019","1",4130,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM019","1",5034,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM022","1",3586,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM022","1",4421,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM022","1",5334,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM022","1",6321,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM028","1",5279,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM028","1",6395,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM028","1",7616,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM028","1",8943,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM032","1",5584,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM032","1",6535,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM032","1",7850,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM032","1",9291,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM036","1",6508,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM036","1",7796,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM036","1",9185,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM036","1",10670,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM040","1",7421,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM040","1",8967,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM040","1",10670,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM040","1",12210,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM044","1",7555,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM044","1",9348,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM044","1",11330,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM044","1",13510,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM050","1",8541,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM050","1",10460,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM050","1",12590,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM050","1",14910,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM056","1",9554,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM056","1",11620,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM056","1",13880,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM056","1",16320,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM064","1",10580,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM064","1",12860,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM064","1",15360,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM064","1",18080,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM072","1",12600,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM072","1",15370,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM072","1",18460,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM072","1",21840,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM080","1",14110,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM080","1",17120,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM080","1",20440,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM080","1",24040,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM0100","1",15480,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM0100","1",18850,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM0100","1",22580,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM0100","1",26660,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM0125","1",21320,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM0125","1",25910,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM0125","1",30980,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM0125","1",36540,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM0144","1",23680,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM0144","1",28670,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM0144","1",34180,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM0144","1",40180,10,20,"R22","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJM0160","1",25740,-5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM0160","1",31100,0,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM0160","1",36990,5,20,"R22","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJM0160","1",43370,10,20,"R22","220V"),


            new UnidadeCondensadoras("Danfoss","OP-HJZ019","1",586,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ019","1",952,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ019","1",1385,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ019","1",1888,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ019","1",2462,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJZ022","1",1023,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ022","1",1449,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ022","1",1995,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ022","1",2543,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ022","1",3211,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJZ028","1",1531,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ028","1",2098,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ028","1",2761,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ028","1",3525,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ028","1",4394,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJZ032","1",1616,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ032","1",2222,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ032","1",2944,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ032","1",3785,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ032","1",4746,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJZ036","1",1779,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ036","1",2490,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ036","1",3325,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ036","1",4286,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ036","1",5372,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJZ040","1",2122,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ040","1",2972,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ040","1",3977,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ040","1",5145,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ040","1",6479,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJZ044","1",2168,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ044","1",3101,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ044","1",4199,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ044","1",5471,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ044","1",6920,-10,-6,"R404A","220V"),


            new UnidadeCondensadoras("Danfoss","OP-HJZ050","1",2630,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ050","1",3652,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ050","1",4850,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ050","1",6234,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ050","1",7612,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJZ056","1",2918,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ056","1",4082,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ056","1",5437,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ056","1",6985,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ056","1",8723,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJZ064","1",3316,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ064","1",4548,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ064","1",5980,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ064","1",7615,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ064","1",9450,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJZ072","1",3973,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ072","1",5393,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ072","1",7066,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ072","1",9002,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ072","1",11210,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HJZ080","1",4677,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ080","1",6205,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ080","1",7989,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ080","1",10040,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HJZ080","1",12350,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HGZ100","1",4788,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ100","1",6603,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ100","1",8697,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ100","1",11070,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ100","1",13720,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HGZ125","1",7162,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ125","1",9464,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ125","1",12130,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ125","1",15180,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ125","1",18630,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HGZ0144","1",8503,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ0144","1",11080,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ0144","1",14060,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ0144","1",17460,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ0144","1",21290,-10,-6,"R404A","220V"),

            new UnidadeCondensadoras("Danfoss","OP-HGZ0160","1",9256,-30,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ0160","1",11980,-25,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ0160","1",15110,-20,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ0160","1",18660,-15,-6,"R404A","220V"),
            new UnidadeCondensadoras("Danfoss","OP-HGZ0160","1",22640,-10,-6,"R404A","220V")












    );

    public static List<UnidadeCondensadoras> getCatalogo() {
        return catalogo;
    }

}
