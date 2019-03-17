package application.model;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Iniciar extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private static Stage stage;
	
	@Override
	public void start(Stage stage) {
		try {
			Parent loader = FXMLLoader.load(getClass().getResource("/application/gui/view/IniciarView.fxml"));
			Scene iniciar = new Scene(loader);
			
			stage.setResizable(false);
			stage.setScene(iniciar);
			stage.setTitle("Poogram");
			stage.show();
			setStage(stage);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Stage getStage() {
		return stage;
	}
	
	public static void setStage(Stage stage) {
		Iniciar.stage = stage;
	}

	
}