package educational.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Class Main
 * @author Juan Fco. Losa Marquez
 * @version 1.0
 * @since java 11
 */
public class Main extends Application {
    /**
     * Starts the app
     * @param primaryStage the fist one scene for the app
     */
    @Override
    public void start(Stage primaryStage) {

        try{
            Parent root = FXMLLoader.load(getClass().getResource(
                    "/educational/scene/mainMenuScene.fxml"));
            primaryStage.setTitle("Educational game");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.show();

        } catch (Exception exception){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(String.valueOf(exception));
            alert.showAndWait();
        }
    }

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {launch(args);}
}
