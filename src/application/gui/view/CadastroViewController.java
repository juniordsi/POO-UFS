package application.gui.view;

import java.io.File;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class CadastroViewController implements Initializable{
	
	@FXML private TextField textFieldNome;
	@FXML private TextField textFieldUsuario;
	@FXML private TextField textFieldEmail;
	@FXML private PasswordField passwordFieldSenha;
	@FXML private Button buttonProximo;
	@FXML private Button buttonVoltar;
	@FXML private CheckBox ckbMasc;
	@FXML private CheckBox ckbFem;
	@FXML private Label labelIncomplete;
	@FXML private ImageView perfil_img;
	
	private String sexo;
	private String path_perfil_img;
	private static String login;
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		
		buttonVoltar.setOnMouseClicked((MouseEvent e)->{
			voltar();
		});
		
		buttonProximo.setOnMouseClicked((MouseEvent e)->{
			this.cadastrar();
			this.login();
		});
		
		ckbMasc.setOnMouseClicked((MouseEvent e)->{
			sexo = "M";
		});
		
		ckbFem.setOnMouseClicked((MouseEvent e)->{
			sexo = "F";
		});
		
		perfil_img.setOnMouseClicked((MouseEvent e)->{
			this.selecionarFoto();
		});
	}
	
	@FXML
	private String getNome() {
		return textFieldNome.getText();
	}
	
	@FXML
	private String getEmail() {
		return textFieldEmail.getText();
	}
	
	@FXML
	private String getSenha() {
		 return passwordFieldSenha.getText();
	}
	
	@FXML
	private String getUsuario() {
		return textFieldUsuario.getText();
	}
	
	public void cadastrar() {
		Usuario usuario = new Usuario();
		usuario.setName(getNome());
		usuario.setEmail(getEmail());
		usuario.setUser(getUsuario());
		usuario.setPassword(getSenha());
		usuario.setGender(sexo);
		usuario.setPerfil_img(path_perfil_img);
		
		login = usuario.getUser();
		
		UsuarioDAO dao = new UsuarioDAO();
		dao.cadastrar(usuario);
	}
	
	public void selecionarFoto() {
		FileChooser foto = new FileChooser();
		foto.getExtensionFilters().add(new ExtensionFilter("imagem", "*.jpg", "*.jpeg", "*.png"));
		File img = foto.showOpenDialog(new Stage());
		if (img != null) {
			perfil_img.setImage(new Image("file:///"+img.getAbsolutePath()));
			this.path_perfil_img = img.getAbsolutePath();
			perfil_img.setOpacity(1);
		}
	}
	
	
	public void feed() {
		TelaFeed feed = new TelaFeed();
		feed.start(new Stage());
	}
	
	public void login() {
		TelaLogin login = new TelaLogin();
		login.start(new Stage());
		fecharTelaCadastro();
	}
	
	public void voltar() {
		TelaLogin login = new TelaLogin();
		login.start(new Stage());
		fecharTelaCadastro();
	}
	
	public static String setLoing() {
		return login;
	}
	
	public static void fecharTelaCadastro() {
		TelaCadastro.getStage().close();
	}

}
