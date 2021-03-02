package ch.bbw.pr.hafenboote;
	
import ch.bbw.pr.hafenboote.model.Boot;
import ch.bbw.pr.hafenboote.model.Bootsliste;
import ch.bbw.pr.hafenboote.model.Motorboot;
import ch.bbw.pr.hafenboote.model.Segelboot;
import ch.bbw.pr.hafenboote.view.MainViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


/**
 * @class: Hafen
 * @package: ch.bbw.hafenboote
 * @author: Sebastian
 * @date: 23.02.2021
 **/
public class Hafen extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//Initialize model with add some data
			Bootsliste myBootsliste = new Bootsliste();
			myBootsliste.add(new Boot("Harvey", 13));
			myBootsliste.add(new Segelboot("Harvey",13, 40));
			myBootsliste.add(new Motorboot("Harvey",13, 150));


			//Print out the model to console
			System.out.println(myBootsliste.toString());
			
	    	
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Hafen.class.getResource("view/MainView.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            
            // Give the controller access to the model
            MainViewController controller = (MainViewController) loader.getController();
            controller.setModel(myBootsliste);
	    	
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("view/application.css").toExternalForm());

			primaryStage.setScene(scene);
            primaryStage.setTitle("Hafen und Boote");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
