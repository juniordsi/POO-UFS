package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginViewController implements Initializable {

	@FXML
	private TextField textFieldUser;

	@FXML
	private PasswordField passwordFieldPassword;

	@FXML
	private Button buttonEntrar;

	@FXML
	private Button buttonCadastrar;

	@FXML
	public void onButtonEntrarAction() {
		this.setLogin();
		this.setPassword();
	}
	
	@FXML
	public void onEnterPressed() {
		this.onButtonEntrarAction();
	}

	@FXML
	private void setLogin() {
		String login = textFieldUser.getText();
		System.out.println(login);
	}

	@FXML
	private void setPassword() {
		String password = passwordFieldPassword.getText();
		System.out.println(password);
	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {

	}

}
