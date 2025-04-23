package ui;

import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.JanelaAbasManualFX;

public class PainelBemVindo extends BorderPane {

    public PainelBemVindo(Stage stage) {
        setStyle("-fx-background-color: white;");

        // Topo: LOGO CENTRALIZADO
        VBox topo = new VBox();
        topo.setAlignment(Pos.CENTER);

        ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("/logo.png")));
        logo.setPreserveRatio(true);
        logo.setFitHeight(130);
        topo.getChildren().add(logo);
        topo.setPrefHeight(160);
        setTop(topo);

        // Centro: MENSAGEM + BOTÃO
        Label mensagem = new Label("Novo Projeto");
        mensagem.setFont(Font.font("SansSerif", 38));
        mensagem.setTextFill(Color.web("#23336f"));
        mensagem.setOpacity(0);

        Button iniciar = new Button("Iniciar");
        iniciar.setFont(Font.font("SansSerif", 20));
        iniciar.setStyle("-fx-background-color: #245edb; -fx-text-fill: white; -fx-background-radius: 24;");
        iniciar.setPrefWidth(170);
        iniciar.setOpacity(0);

        VBox centro = new VBox(28, mensagem, iniciar);
        centro.setAlignment(Pos.TOP_CENTER);
        centro.setPadding(new Insets(40, 0, 0, 0));
        setCenter(centro);

        // RODAPÉ: LINK
        Label linkManual = new Label("Adicionar dados manualmente");
        linkManual.setFont(Font.font("SansSerif", 15));
        linkManual.setTextFill(Color.web("#2a7fd1"));
        linkManual.setUnderline(true);
        linkManual.setOpacity(0);

        linkManual.setOnMouseEntered(e -> linkManual.setTextFill(Color.web("#14507F")));
        linkManual.setOnMouseExited(e -> linkManual.setTextFill(Color.web("#2a7fd1")));
        linkManual.setCursor(Cursor.HAND);
        StackPane rodape = new StackPane(linkManual);
        rodape.setPrefHeight(44);
        setBottom(rodape);

        // ANIMAÇÕES


        FadeTransition ftMensagem = new FadeTransition(Duration.seconds(1.5), mensagem);
        ftMensagem.setFromValue(0);
        ftMensagem.setToValue(1);
        ftMensagem.setOnFinished(ev -> {
            FadeTransition ftBtn = new FadeTransition(Duration.millis(700), iniciar);
            ftBtn.setFromValue(0);
            ftBtn.setToValue(1);
            ftBtn.setOnFinished(ev2 -> {
                FadeTransition ftLink = new FadeTransition(Duration.millis(600), linkManual);
                ftLink.setFromValue(0);
                ftLink.setToValue(1);
                ftLink.play();
            });
            ftBtn.play();
        });
        mensagem.setTranslateY(30);
        ftMensagem.currentTimeProperty().addListener((obs, o, n) -> {
            if (n != null && ftMensagem.getDuration().greaterThan(Duration.ZERO)) {
                double frac = n.toMillis() / ftMensagem.getDuration().toMillis();
                mensagem.setTranslateY(30 - frac * 30);
            }
        });
        ftMensagem.play();

        // CALLBACKS de troca de tela
        iniciar.setOnAction(e -> {
            JanelaAbasManualFX manual = new JanelaAbasManualFX(stage);
            Scene sceneManual = new Scene(manual, 1050, 550);
            stage.setScene(sceneManual);
            stage.setResizable(false); // Impede redimensionamento
        });

        linkManual.setOnMouseClicked(e -> {
            JanelaAbasManualFX manual = new JanelaAbasManualFX(stage);
            Scene sceneManual = new Scene(manual, 1050, 550);
            stage.setScene(sceneManual);
            stage.setResizable(false); // Impede redimensionamento
        });

    }
}