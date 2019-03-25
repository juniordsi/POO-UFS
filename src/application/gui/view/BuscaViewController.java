package application.gui.view;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.TelaBusca;
import application.model.TelaFeed;
import application.model.Usuario;
import application.model.dao.UsuarioDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BuscaViewController implements Initializable{
	
	@FXML private TextField pesquisar;
	@FXML private Button voltar;
	@FXML private Button seguir;
	@FXML private Label resultadoDaPesquisa;
	@FXML private Label name;
	@FXML private Label seguidores;
	@FXML private Label sgdrs;
	@FXML private Label seguindo;
	@FXML private Label sgnd;
	@FXML private Label nenhumResultado;
	@FXML private ImageView img;
	
	private static String usuarioAtual;
	
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		
		carregaBusca();
		
		pesquisar.setOnKeyPressed((KeyEvent e)->{
			if (e.getCode() == KeyCode.ENTER) {
				busca();
			}
		});
		
		voltar.setOnMouseClicked((MouseEvent e)->{
			fechar();
		});
		
	}
	
	@FXML
	public void seguir() {
		Usuario usuario = new Usuario();
		UsuarioDAO dao = new UsuarioDAO();
		if (seguir.getText().equals("seguir")) {
			seguir.setText("seguindo");
			usuario = dao.somaSeguidor(pesquisar.getText());
			atualizaInfo(usuario);
		} else {
			seguir.setText("seguir");
			usuario = dao.subtraiSeguidor(pesquisar.getText());
			atualizaInfo(usuario);
		}
	}
	
	public void carregaBusca() {
		usuarioAtual = FeedViewController.usuarioAtual();
		FeedViewController.fecharFeed();
		String pessoa = FeedViewController.pessoa();
		
		resultadoDaPesquisa.setText("Resultado da pesquisa por: "+pessoa);
		
		UsuarioDAO buscar = new UsuarioDAO();
		Usuario usuario = new Usuario();
		usuario = buscar.busca(pessoa);
		
		if (usuario == null) {
			nenhumResultado.setOpacity(1);
		} else {
			atualizaInfo(usuario);
			mostraInfo();
			
		}
	}
	
	public void busca() {
		FeedViewController.fecharFeed();
		UsuarioDAO buscar = new UsuarioDAO();
		Usuario usuario = new Usuario();
		
		usuario = buscar.busca(pesquisar.getText());
		resultadoDaPesquisa.setText("Resultado da pesquisa por: "+pesquisar.getText());
		
		if (usuario == null) {
			nenhumResultado.setOpacity(1);
		} else {
			atualizaInfo(usuario);
			mostraInfo();
		}
	}
	
	private void mostraInfo() {
		seguir.setOpacity(1);
		name.setOpacity(1);
		seguidores.setOpacity(1);
		seguindo.setOpacity(1);
		sgdrs.setOpacity(1);
		sgnd.setOpacity(1);
		img.setOpacity(1);
	}
	
	private void atualizaInfo(Usuario usuario) {
		name.setText(usuario.getName());
		sgdrs.setText(String.valueOf(usuario.getFollowers()));
		sgnd.setText(String.valueOf(usuario.getFollowing()));
	}
	
	public void fechar() {
		TelaFeed feed = new TelaFeed();
		feed.start(new Stage());
		fecharBusca();
	}
	
	public static void fecharBusca() {
		TelaBusca.getStage().close();
	}

}
