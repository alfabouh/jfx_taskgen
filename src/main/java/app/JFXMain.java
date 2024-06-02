package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Random;

public class JFXMain extends Application {
    public static Random random = new Random();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(JFXMain.loadFromResources("/main.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(JFXMain.loadFromResources("/main.css").toExternalForm());

        stage.setTitle("Generator v1.0");
        stage.setResizable(false);
        stage.setHeight(640);
        stage.setWidth(960);
        stage.setScene(scene);

        Rectangle2D screenBounds = JFXMain.getScreenSize();
        stage.setX((screenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((screenBounds.getHeight() - stage.getHeight()) / 2);

        stage.show();
    }

    public static void showWarn(String warn) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Ошибка");
        alert.setHeaderText(null);
        alert.setContentText(warn);
        alert.showAndWait();
    }

    public static void showSuccess(String warn) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Успех");
        alert.setHeaderText(null);
        alert.setContentText(warn);
        alert.showAndWait();
    }

    public static String date() {
        LocalDateTime now = LocalDateTime.now();
        int day = now.getDayOfMonth();
        int month = now.getMonthValue();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();

        return String.format("%02d-%02d_%02d-%02d-%02d", day, month, hour, minute, second);
    }

    public static Rectangle2D getScreenSize() {
        return Screen.getPrimary().getVisualBounds();
    }

    public static URL loadFromResources(String url) {
        return JFXMain.class.getResource(url);
    }
}
