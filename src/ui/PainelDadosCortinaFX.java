package ui;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import model.DadosCâmara;

public class PainelDadosCortinaFX extends VBox {
    public PainelDadosCortinaFX() {
        setSpacing(8);
        getChildren().addAll(
                new Label("Comprimento: " + DadosCâmara.getComprimento()),
                new Label("Largura: " + DadosCâmara.getLargura()),
                new Label("Altura: " + DadosCâmara.getAltura()),
                new Label("Espessura: " + DadosCâmara.getEspessura())
        );
    }
}