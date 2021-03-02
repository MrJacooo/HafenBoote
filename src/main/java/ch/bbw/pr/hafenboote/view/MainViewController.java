package ch.bbw.pr.hafenboote.view;

import ch.bbw.pr.hafenboote.Hafen;
import ch.bbw.pr.hafenboote.model.Bootsliste;
import ch.bbw.pr.hafenboote.model.Boot;
import ch.bbw.pr.hafenboote.model.Segelboot;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * @class: MainViewController
 * @package: ch.bbw.hafenboote
 * @author: Sebastian
 * @date: 23.02.2021
 **/
public class MainViewController {
	@FXML
	private ListView<Boot> booteListView;
	
	// Reference to the model
	private Bootsliste model;
	
	/**
	 * The constructor. The constructor is called before the initialize() method.
	 */
	public MainViewController() {
	}
	
	/**
	 * Initializes the controller class. This method is automatically called after
	 * the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
	}

	@FXML
	private void handleDelete(ActionEvent ae) {
		Node source = (Node) ae.getSource();
		Window window = source.getScene().getWindow();

		int selectedIndex = booteListView.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			booteListView.getItems().remove(selectedIndex);
			System.out.println(model.toString());
		} else {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.initOwner(window);
			alert.setTitle("No selection");
			alert.setHeaderText("No Boot Selected");
			alert.setContentText("Please select a boot in from the table");
			alert.showAndWait();
		}
	}
	@FXML
	private void handleNewSegelboot(ActionEvent ae){
		Node source = (Node) ae.getSource();
		Window window = source.getScene().getWindow();

		Boot temp = showSegelbootDialog(window);
		if (temp != null) {
			model.add(temp);
			System.out.println(model.toString());
		}
	}
	@FXML
	private void handleNewMotorboot(ActionEvent ae){
		Node source = (Node) ae.getSource();
		Window window = source.getScene().getWindow();

		Boot temp = showMotorbootDialog(window);
		if (temp != null) {
			model.add(temp);
			System.out.println(model.toString());
		}
	}

	public void setModel(Bootsliste model) {
		this.model = model;
		
		booteListView.setItems(model.getBoote());
	}

	private Boot showSegelbootDialog(Window window) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Hafen.class.getResource("view/Segelbootdialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Add Segelboot");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(window);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			SegelbootDialogController controller = loader.getController();

			dialogStage.showAndWait();

			return controller.getBoot();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private Boot showMotorbootDialog(Window window) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Hafen.class.getResource("view/MotorbootDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Add Motorboot");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(window);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			MotorbootDialogController controller = loader.getController();

			dialogStage.showAndWait();

			return controller.getBoot();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
