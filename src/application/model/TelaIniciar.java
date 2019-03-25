package application.model;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaIniciar extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private static Stage stage;
	
	@Override
	public void start(Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/gui/view/IniciarView.fxml"));
			AnchorPane anchorPane = loader.load();
			Scene iniciar = new Scene(anchorPane);
			
			stage.setScene(iniciar);
			stage.setTitle("Poogram");
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
	
	public static void setStage(Stage stage) {
		TelaIniciar.stage = stage;
	}

	
}