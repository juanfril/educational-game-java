package educational.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CatchTheMouseController extends GeneralController{
    @FXML
    private Canvas cvMouse;
    Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cvMouse.setOnMouseClicked(ActionEvent -> {
            stage = (Stage) this.cvMouse.getScene().getWindow();
            stage.close();
        });
    }
}
