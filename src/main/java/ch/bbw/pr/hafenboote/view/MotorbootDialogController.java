package ch.bbw.pr.hafenboote.view;

import ch.bbw.pr.hafenboote.model.Boot;
import ch.bbw.pr.hafenboote.model.Motorboot;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
/**
 * @class: MotorbootDialogController
 * @package: ch.bbw.hafenboote
 * @author: Sebastian
 * @date: 23.02.2021
 **/
public class MotorbootDialogController {

    private Motorboot boot;

    @FXML
    private TextField nameField;
    @FXML
    private TextField laengeField;
    @FXML
    private TextField leistungField;

    public MotorbootDialogController() {
        this.boot = null;
    }

    public Boot getBoot() {
        return this.boot;
    }

    @FXML
    private void initialize() {
    }

    @FXML
    private void handleOk(ActionEvent ae) {
        String errorMessage = "";
        if (isInputValid(errorMessage)) {
            Motorboot boot = new Motorboot(nameField.getText(), Integer.parseInt(laengeField.getText()), Integer.parseInt(leistungField.getText()));
            this.boot = boot;
        } else {
            Node source = (Node) ae.getSource();
            Window window = source.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(window);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();
            this.boot = null;
        }
        Node source = (Node) ae.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleCancel(ActionEvent ae) {
        this.boot = null;
        Node source = (Node) ae.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    private boolean isInputValid(String errorMessage) {
        errorMessage = "";

        if (nameField.getText() == null || nameField.getText().length() == 0) {
            errorMessage += "No valid name!\n";
        }
        if (laengeField.getText() == null || laengeField.getText().length() == 0) {
            errorMessage += "No valid laenge!\n";
        }
        if (leistungField.getText() == null || leistungField.getText().length() == 0) {
            errorMessage += "No valid leistung!\n";
        }

        if (errorMessage.length() == 0) return true;
        else return false;
    }
}
