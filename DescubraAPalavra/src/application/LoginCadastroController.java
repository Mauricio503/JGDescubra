package application;


import java.io.IOException;

import br.edu.unoesc.DescobrirAPalavra.DAO.CodUserAtualDAO;
import br.edu.unoesc.DescobrirAPalavra.DAO.DaoFactory;
import br.edu.unoesc.DescobrirAPalavra.DAO.PontuacaoDAO;
import br.edu.unoesc.DescobrirAPalavra.DAO.UsuarioDAO;
import br.edu.unoesc.DescobrirAPalavra.DAO.UsuarioDAOLogin;
import br.edu.unoesc.DescobrirAPalavra.modelo.CodUserAtual;
import br.edu.unoesc.DescobrirAPalavra.modelo.Pontuacao;
import br.edu.unoesc.DescobrirAPalavra.modelo.Usuario;
import br.edu.unoesc.DescobrirAPalavra.modelo.ValidarLogin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class LoginCadastroController {
	

    @FXML
    private TextField tfUsuario;

    @FXML
    private TextField tfSenha;
    
    @FXML
    private BorderPane principal;
    
    @FXML
    private Button btnLogin;
    
    private Usuario usuario = new Usuario();
    
    @FXML
    private Button btnCadastrar;
    
    @FXML
    private Label lbErro1;

    @FXML
    private Label lbErro2;

    @FXML
    private Label lbErro3;
    
    @FXML
    private Label lbmgmCadastro;

    private UsuarioDAO usuarioDao = DaoFactory.get().usuarioDao();
    private ValidarLogin validarlogin = new ValidarLogin();
    private UsuarioDAOLogin usuarioDaoLogin = DaoFactory.get().usuarioDaoLogin();
    private PontuacaoDAO pontuacaoDao = DaoFactory.get().pontuacaoDao();
    private CodUserAtualDAO coduserDao = DaoFactory.get().coduseratualDao();
    
    private Pontuacao pontuacao = new Pontuacao();
    private CodUserAtual coduser = new CodUserAtual();
    
    private String usuar;
    private String usuariodig;
	private String senha;
	private String senhadig;
	
	

    @FXML
    void onCadastrar(ActionEvent event) {
    	/*- Cadastrar no banco usuario a senha,
    	 * se o usuario ja existir emite uma mensagem*/
    		usuario.setUsuario(tfUsuario.getText());
    		usuario.setSenha(tfSenha.getText());
    		usuarioDao.inserir(usuario);
    		validarlogin.setUsuariodig(tfUsuario.getText());
        	Usuario usuario = usuarioDaoLogin.get("usuario ='"+validarlogin.getUsuariodig()+"'");
        	validarlogin.setUsuario(usuario.getUsuario());
        	usuar=validarlogin.getUsuario();
        	usuariodig=validarlogin.getUsuariodig();
        	if(usuar.equalsIgnoreCase(usuariodig)) {
        		lbmgmCadastro.setText("Usuário Cadastrado");
        	}
    }
    

	    private long numero=1;
	    private long pontos=100;
	    CodUserAtual cod_user_atual;
    @FXML
    void onLogin(ActionEvent event) {
    	              /*VALIDAR LOGIN*/
    	/*- Armazena em variavel usuario e senha digitado
    	 * - Busca no banco o mesmo usuario e senha digita
    	 * - Se são iguais vai para o menu principal
    	 * - Tambem armazena em variavel codigo usuario*/
    	validarlogin.setUsuariodig(tfUsuario.getText());
    	Usuario usuario = usuarioDaoLogin.get("usuario ='"+validarlogin.getUsuariodig()+"'");
    	validarlogin.setUsuario(usuario.getUsuario());
    	usuar=validarlogin.getUsuario();
    	usuariodig=validarlogin.getUsuariodig();
    	validarlogin.setSenhadig(tfSenha.getText());
    	Usuario senhauser = usuarioDaoLogin.get("senha ='"+validarlogin.getSenhadig()+"'");
    	validarlogin.setSenha(senhauser.getSenha());
    	senha=validarlogin.getSenha();
    	senhadig=validarlogin.getSenhadig();
    	lbErro1.setText("Ops, Algo esta errado....");
    	lbErro2.setText("Digitação incoreta ou se é novo por aqui precisa se");
    	lbErro3.setText("cadastrar primeiro.");
    	coduser.setCodigo(numero);
    	coduser.setCod_user_atual(usuario.getCodigo());
    	coduserDao.alterar(coduser);
    	if(usuar.equalsIgnoreCase(usuariodig)&&senha.equalsIgnoreCase(senhadig)) {
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Principalform.fxml"));
		try {
			TabPane loginView = (TabPane) loader.load();
			principal.setCenter(loginView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    	}
    		
    }
}
