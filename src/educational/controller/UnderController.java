package educational.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Class for controller underScene
 * Inheritance GeneralController
 * @see GeneralController
 */
public class UnderController extends GeneralController {
    @FXML
    private Button btnCatchTheMouse;
    @FXML
    private Button btnHowMany;
    private Stage stage = new Stage();
    private Parent root;
    /**
     * Initialize the scene
     * @param url scene's path
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnCatchTheMouse.setOnAction(ActionEvent -> {
            try {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(
                        "/educational/scene/catchTheMouseScene.fxml")));
                stage.setTitle("Catch the mouse");
            } catch (Exception e) {
                dialog.setHeaderText("Information");
                dialog.setContentText(e.toString());
                dialog.showAndWait();
            }
            stage.setScene(new javafx.scene.Scene(root, 600, 400));
            stage.show();
        });
        btnHowMany.setOnAction(actionEvent -> {
            try {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(
                        "/educational/scene/howManyAreThereScene.fxml")));
                stage.setTitle("How many are there");
            } catch (Exception e) {
                dialog.setHeaderText("Information");
                dialog.setContentText(e.toString());
                dialog.showAndWait();
            }
            stage.setScene(new javafx.scene.Scene(root, 600, 400));
            stage.show();
        });
    }
}
