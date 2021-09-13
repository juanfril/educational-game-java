package educational.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Class for controller olderScene
 * Inheritance GeneralController
 * @see GeneralController
 */
public class OlderController extends GeneralController {

    @FXML
    private Button btnSums;
    @FXML
    private Button btnSubtract;
    @FXML
    private Button btnSubtractWithCarriedController;
    private Stage stage = new Stage();
    private Parent root;
    /**
     * Initialize the scene
     * @param url scene's path
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnSums.setOnAction(ActionEvent -> {
            try {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(
                        "/educational/scene/sumsScene.fxml")));
                stage.setTitle("Sums");
            } catch (Exception e) {
                dialog.setHeaderText("Information");
                dialog.setContentText(e.toString());
                dialog.showAndWait();
            }
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        });
        btnSubtract.setOnAction(actionEvent -> {
            try {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(
                        "/educational/scene/subtractsScene.fxml")));
                stage.setTitle("Subtract");
            } catch (Exception e) {
                dialog.setHeaderText("Information");
                dialog.setContentText(e.toString());
                dialog.showAndWait();
            }
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        });
        btnSubtractWithCarriedController.setOnAction(actionEvent -> {
            try {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(
                        "/educational/scene/subtractWithCarriedScene.fxml")));
                stage.setTitle("Subtract with carried");
            } catch (Exception e) {
                dialog.setHeaderText("Information");
                dialog.setContentText(e.toString());
                dialog.showAndWait();
            }
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        });
    }
}
