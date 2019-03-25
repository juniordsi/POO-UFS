package application.model;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TelaFeed extends Application{
	
	private static Stage stage;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/gui/view/FeedView.fxml"));
			BorderPane borderPane = loader.load();
			
			Scene feed = new Scene(borderPane);
			
			stage.setScene(feed);
			stage.setTitle("PooGram");
			stage.setResizable(false);
			stage.show();
			setStage(stage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Stage getStage() {
		return stage;
	}
	
	private static void setStage(Stage stage) {
		TelaFeed.stage = stage;
	}

}
