package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaCadastro extends Application {
	@Override
	public void start(Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/CadastroView.fxml"));
			AnchorPane anchorPane = loader.load();
			
			Scene telaCadastro = new Scene(anchorPane);
			stage.setScene(telaCadastro);
			stage.setTitle("Realizar Cadastro");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
