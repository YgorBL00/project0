package model;

import model.UnidadeCondensadoras;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class RecomendacaoMotor {

    public static Optional<UnidadeCondensadoras> recomendarMotor(double temperaturaInterna, double cargaTermica) {
        return UnidadeCondensadoras.getCatalogo().stream()
                .filter(motor ->
                        motor.getCapacidadeKcal() >= cargaTermica &&
                                temperaturaInterna >= motor.getTemperaturaMin() &&
                                temperaturaInterna <= motor.getTemperaturaMax()
                )
                .min(Comparator.comparingDouble(UnidadeCondensadoras::getCapacidadeKcal));
    }
}
