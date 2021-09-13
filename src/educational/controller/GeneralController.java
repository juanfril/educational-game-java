package educational.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import java.net.URL;
import java.util.ResourceBundle;
/**
 * SuperClass for controller Scenes
 * Implement Initializable
 * @see Initializable
 */
public class GeneralController implements Initializable {

    protected Alert dialog = new Alert(Alert.AlertType.INFORMATION);

    public void setNumbers(){}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public void clic(ActionEvent actionEvent) {}
}
