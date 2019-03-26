package application.gui.view;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.TelaBusca;
import application.model.TelaFeed;
import application.model.TelaLogin;
import application.model.Usuario;
import application.model.dao.UsuarioDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FeedViewController implements Initializable{
	
	@FXML private Label usr;
	@FXML private Label name;
	@FXML private Label sgrs;
	@FXML private Label sgnd;
	@FXML private ImageView perfil_img;
	@FXML private TextField pesquisar;
	@FXML private Button logout;
	
	private static String login;
	private static String busca;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		this.initFeed();
		
		pesquisar.setOnKeyPressed((KeyEvent e)->{
			if (e.getCode() == KeyCode.ENTER) {
				busca();
			}
		});
		
		logout.setOnMouseClicked((MouseEvent e)->{
			fechar();
		});
	}
	
	public void initFeed() {
		login = LoginViewController.setLogin();
		Usuario usuario = new Usuario();
		UsuarioDAO dao = new UsuarioDAO();
		usuario = dao.feed(login);
		usr.setText("@"+usuario.getUser());
		name.setText(usuario.getName());
		sgrs.setText(String.valueOf(usuario.getFollowers()));
		sgnd.setText(String.valueOf(usuario.getFollowing()));
		perfil_img.setImage(new Image("file:///"+usuario.getPerfil_img()));
		
		LoginViewController.fecharTelaLogin();
	}
	
	public void busca() {
		busca = pesquisar.getText();
		TelaBusca busca = new TelaBusca();
		busca.start(new Stage());
	}
	
	public static String pessoa() {
		return busca;
	}
	
	public static String usuarioAtual() {
		return login;
	}
	
	
	public void fechar() {
		TelaLogin login = new TelaLogin();
		login.start(new Stage());
		fecharFeed();
	}
	
	public static void fecharFeed() {
		TelaFeed.getStage().close();
	}
	
}
