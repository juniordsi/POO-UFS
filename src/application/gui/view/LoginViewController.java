package application.gui.view;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.TelaCadastro;
import application.model.TelaFeed;
import application.model.TelaLogin;
import application.model.Usuario;
import application.model.dao.UsuarioDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginViewController implements Initializable {

	@FXML private TextField textFieldUser;
	@FXML private PasswordField passwordFieldPassword;
	@FXML private Button buttonEntrar;
	@FXML private Button buttonCadastrar;
	@FXML private Label labelErroLogin;
	
	private static String usuario;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		buttonEntrar.setOnMouseClicked((MouseEvent e)->{
				this.logar();
		});
		
		buttonCadastrar.setOnMouseClicked((MouseEvent e)->{
			TelaCadastro cadastro = new TelaCadastro();
			cadastro.start(new Stage());
			fecharTelaLogin();
		});
			
	}
	
	
	@FXML
	private String getLogin() {
		usuario = textFieldUser.getText();
		return usuario;
	}

	@FXML
	private String getPassword() {
		return passwordFieldPassword.getText();
	}
	
	
	public static String setLogin() {
		return usuario;
	}
	
	public void logar() {
		Usuario usuario = new Usuario(this.getLogin(), this.getPassword());
		UsuarioDAO dao = new UsuarioDAO();
		if(dao.logar(usuario)) {
			TelaFeed feed = new TelaFeed();
			feed.start(new Stage());
		} else {
			labelErroLogin.setOpacity(1);
		}
		
	}
	
	public static void fecharTelaLogin() {
		TelaLogin.getStage().close();
	}
	
}
