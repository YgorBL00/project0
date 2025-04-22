package util;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FadeInPanel extends Application {
    @Override
    public void start(Stage stage) {
        // === IMAGEM CENTRALIZADA NO TOPO ===
        Image image = new Image(getClass().getResource("/logo.png").toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(280);
        imageView.setPreserveRatio(true);

        // === FRASE CENTRAL (MENOR) ===
        Text frase = new Text("Começar novo projeto");
        frase.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        frase.setFill(Color.web("#1e3a8a"));
        frase.setOpacity(0);
        frase.setTranslateY(20);

        // === BOTÃO TRANSPARENTE ===
        Button botao = new Button("Iniciar");
        botao.setStyle(
                "-fx-font-size: 16px;" +
                        "-fx-background-color: transparent;" +
                        "-fx-text-fill: white;" +
                        "-fx-border-color: white;" +
                        "-fx-border-width: 2;" +
                        "-fx-padding: 8 16;" +
                        "-fx-background-radius: 8;"
        );
        botao.setOpacity(0);

        // === LINK INFERIOR COM FADE ===
        Hyperlink link = new Hyperlink("www.bssrefri.com");
        link.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        link.setOpacity(0);
        link.setTextFill(Color.GRAY);

        // === LAYOUT CENTRAL ===
        VBox centro = new VBox(15, frase, botao);
        centro.setAlignment(Pos.CENTER);

        // === LAYOUT PRINCIPAL ===
        BorderPane root = new BorderPane();
        root.setTop(imageView);
        BorderPane.setAlignment(imageView, Pos.CENTER);
        root.setCenter(centro);
        root.setBottom(link);
        BorderPane.setAlignment(link, Pos.CENTER);
        root.setPrefSize(950, 650);
        root.setPadding(new Insets(40));

        // === NOVO FUNDO "FROZEN SKY" DUOTONE (DE BAIXO PRA CIMA) ===
        Background bg = new Background(new BackgroundFill(
                new LinearGradient(
                        0, 1, 0, 0, true, CycleMethod.NO_CYCLE,
                        new Stop(0.0, Color.web("#0ea5e9")), // azul vibrante
                        new Stop(1.0, Color.web("#f0f9ff"))  // branco-azulado
                ),
                CornerRadii.EMPTY,
                Insets.EMPTY
        ));
        root.setBackground(bg);

        // === ANIMAÇÕES COM VELOCIDADE AUMENTADA (1.5s) ===
        Duration fast = Duration.seconds(1.5);

        FadeTransition fadeFrase = new FadeTransition(fast, frase);
        fadeFrase.setFromValue(0);
        fadeFrase.setToValue(1);

        TranslateTransition subirFrase = new TranslateTransition(fast, frase);
        subirFrase.setFromY(20);
        subirFrase.setToY(0);

        FadeTransition fadeBotao = new FadeTransition(fast, botao);
        fadeBotao.setFromValue(0);
        fadeBotao.setToValue(1);
        fadeBotao.setDelay(Duration.seconds(1.5));

        FadeTransition fadeLink = new FadeTransition(fast, link);
        fadeLink.setFromValue(0);
        fadeLink.setToValue(1);
        fadeLink.setDelay(Duration.seconds(2.5));

        fadeFrase.play();
        subirFrase.play();
        fadeBotao.play();
        fadeLink.play();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Tela Inicial - BSS Refrigeração");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
