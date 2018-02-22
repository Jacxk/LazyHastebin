package me.jack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("lazyhastebin.fxml"));
        Scene scene = new Scene(root, 809, 515);

        primaryStage.setTitle("Lazy Hastebin");
        primaryStage.setScene(scene);

        primaryStage.setMinWidth(809);
        primaryStage.setMinHeight(515);
        primaryStage.getIcons().add(new Image("https://pbs.twimg.com/profile_images/1664989409/twitter_400x400.png"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
