package application.gui.view;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.Iniciar;
import application.model.TelaLogin;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class IniciarController implements Initializable {
	
	@FXML Button buttonTeste;

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		
		buttonTeste.setOnKeyPressed((KeyEvent e)->{
			if (e.getCode() == KeyCode.ENTER) {
				TelaLogin login = new TelaLogin();
				login.start(new Stage());
				fechar();	
			}
		});
		

	}
	
	public static void fechar() {
		Iniciar.getStage().close();
	}

}
