package model;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RecomendacaoEvaporadora {

    public static List<Evaporadoras> recomendarEvaporadoras(double temperaturaInterna, double cargaTermica) {
        return Evaporadoras.getCatalogo().stream()
                .filter(evap ->
                        temperaturaInterna >= evap.getTemperaturaMin() &&
                                temperaturaInterna <= evap.getTemperaturaMax() &&
                                evap.getCapacidadeKcal() >= cargaTermica
                )
                .sorted(Comparator.comparingDouble(Evaporadoras::getCapacidadeKcal))
                .limit(1) // só pega a melhor (menor acima da carga)
                .collect(Collectors.toList());
    }
}
