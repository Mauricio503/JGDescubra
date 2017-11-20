package application;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import br.edu.unoesc.DescobrirAPalavra.DAO.CodUserAtualDAO;
import br.edu.unoesc.DescobrirAPalavra.DAO.ConexaoUtil;
import br.edu.unoesc.DescobrirAPalavra.DAO.DaoFactory;
import br.edu.unoesc.DescobrirAPalavra.DAO.PerguntasDAO;
import br.edu.unoesc.DescobrirAPalavra.DAO.PontosDAO;
import br.edu.unoesc.DescobrirAPalavra.DAO.PontuacaoDAO;
import br.edu.unoesc.DescobrirAPalavra.modelo.CodUserAtual;
import br.edu.unoesc.DescobrirAPalavra.modelo.CorretoErrado;
import br.edu.unoesc.DescobrirAPalavra.modelo.Perguntas;
import br.edu.unoesc.DescobrirAPalavra.modelo.Pontuacao;
import br.edu.unoesc.DescobrirAPalavra.modelo.Resposta;
import br.edu.unoesc.DescobrirAPalavra.modelo.ValidarLogin;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class PrincipalController {

    @FXML
    private AnchorPane principal;

    @FXML
    private Button btnMostrar;
    
    
    @FXML
    private Label lbAssunto;


    @FXML
    private Label lbPergunta1;

    @FXML
    private Label lbDica1Perg1;

    @FXML
    private Label lbDica2Perg1;

    @FXML
    private Label lbDica3Perg1;

    @FXML
    private Label lbPergunta2;

    @FXML
    private Label lbDica1Perg2;

    @FXML
    private Label lbDica2Perg2;

    @FXML
    private Label lbDica3Perg2;

    @FXML
    private Label lbPergunta3;

    @FXML
    private Label lbDica1Perg3;

    @FXML
    private Label lbDica2Perg3;

    @FXML
    private Label lbDica3Perg3;

    @FXML
    private Label lbPergunta4;

    @FXML
    private Label lbDica1Perg4;

    @FXML
    private Label lbDica2Perg4;

    @FXML
    private Label lbDica3Perg4;

    @FXML
    private Label lbPergunta5;

    @FXML
    private Label lbDica1Perg5;

    @FXML
    private Label lbDica2Perg5;

    @FXML
    private Label lbDica3Perg5;

    @FXML
    private TextField tfRespPerg1;

    @FXML
    private Button btnConferirRespPerg1;

    @FXML
    private Label lbResultPerg1;
    
    @FXML
    private Label lbPontos;

    @FXML
    private TextField tfRespPerg2;

    @FXML
    private Button btnConferirRespPerg2;

    @FXML
    private Label lbResultPerg2;

    @FXML
    private TextField tfRespPerg3;

    @FXML
    private Button btnConferirRespPerg3;

    @FXML
    private Label lbResultPerg3;

    @FXML
    private TextField tfRespPerg4;

    @FXML
    private Button btnConferirRespPerg4;

    @FXML
    private Label lbResultPerg4;

    @FXML
    private TextField tfRespPerg5;

    @FXML
    private Button btnConferirRespPerg5;

    @FXML
    private Label lbResultPerg5;
    
    @FXML
    private TextField tfPergunta1;

    @FXML
    private TextField tfAssunto;

    @FXML
    private TextField tfDica1Perg1;

    @FXML
    private TextField tfDica2Perg1;

    @FXML
    private TextField tfDica3Perg1;

    @FXML
    private TextField tfPergunta2;

    @FXML
    private TextField tfDica1Perg2;

    @FXML
    private TextField tfDica2Perg2;

    @FXML
    private TextField tfDica3Perg2;

    @FXML
    private TextField tfPergunta3;

    @FXML
    private TextField tfDica1Perg3;

    @FXML
    private TextField tfDica2Perg3;

    @FXML
    private TextField tfDica3Perg3;

    @FXML
    private TextField tfPergunta4;

    @FXML
    private TextField tfDica1Perg4;

    @FXML
    private TextField tfDica2Perg4;

    @FXML
    private TextField tfDica3Perg4;

    @FXML
    private TextField tfPergunta5;

    @FXML
    private TextField tfDica1Perg5;

    @FXML
    private TextField tfDica2Perg5;

    @FXML
    private TextField tfDica3Perg5;

    @FXML
    private TextField tfResPerg1;

    @FXML
    private TextField tfResPerg2;

    @FXML
    private TextField tfResPerg3;

    @FXML
    private TextField tfResPerg4;

    @FXML
    private TextField tfResPerg5;

    @FXML
    private Button btnSalvar;
    
    @FXML
    private Button btnVoltar;

    @FXML
    private TableView<Pontuacao> tblPontuacao;

    @FXML
    private TableColumn<Long, Pontuacao> tbnPontos;
    
    @FXML
    private TableColumn<String, Pontuacao> tbnAssunto;
    
    @FXML
    private TableColumn<String, Pontuacao> tbnData;
    
    @FXML
    private Button btnCliente;

    @FXML
    private Button btnPerguntas;

    @FXML
    private Button btnPontuação;


    private Perguntas perguntas = new Perguntas();
    private Pontuacao ponto = new Pontuacao();
    
    private PontuacaoDAO pontuacaoDao = DaoFactory.get().pontuacaoDao();
    private PerguntasDAO perguntasDao = DaoFactory.get().perguntasDao();
    private PontosDAO pontosDaoString = DaoFactory.get().pontosDao();
    private CodUserAtualDAO coduserDao = DaoFactory.get().coduseratualDao();
    
    private CorretoErrado conferir = new CorretoErrado();
	private Resposta resposta = new Resposta();
	private Pontuacao pontuacao = new Pontuacao();
	private ValidarLogin validarlogin;
	private CodUserAtual coduser = new CodUserAtual();

	private String assunto_atual;
	private String resperg1; 
	private String digperg1;
	private String resperg2; 
	private String digperg2;
	private String resperg3; 
	private String digperg3;
	private String resperg4; 
	private String digperg4;
	private String resperg5; 
	private String digperg5;
	
	
	private long pontos = 0;
	
	private boolean confereperg1=true;
	private boolean confereperg2=true;
	private boolean confereperg3=true;
	private boolean confereperg4=true;
	private boolean confereperg5=true;
	private boolean dica1perg1=true;
	private boolean dica2perg1=true;
	private boolean dica3perg1=true;
	private boolean dica1perg2=true;
	private boolean dica2perg2=true;
	private boolean dica3perg2=true;
	private boolean dica1perg3=true;
	private boolean dica2perg3=true;
	private boolean dica3perg3=true;
	private boolean dica1perg4=true;
	private boolean dica2perg4=true;
	private boolean dica3perg4=true;
	private boolean dica1perg5=true;
	private boolean dica2perg5=true;
	private boolean dica3perg5=true;
	
	
	/***********************MENU1(PERGUNTAS)*******************/

    
    private int perg_codigo = 0;
    private int qtd_perguntas;
    /*limpa conteudo da tela*/
    public void novoDicasPerguntas() {
    	lbPontos.setText("");
    	tfRespPerg1.setText("");
    	tfRespPerg2.setText("");
    	tfRespPerg3.setText("");
    	tfRespPerg4.setText("");
    	tfRespPerg5.setText("");
    	lbResultPerg1.setText("");
    	lbResultPerg2.setText("");
    	lbResultPerg3.setText("");
    	lbResultPerg4.setText("");
    	lbResultPerg5.setText("");
    	lbDica1Perg1.setText("");
    	lbDica2Perg1.setText("");
    	lbDica3Perg1.setText("");
    	lbDica1Perg2.setText("");
    	lbDica2Perg2.setText("");
    	lbDica3Perg2.setText("");
    	lbDica1Perg3.setText("");
    	lbDica2Perg3.setText("");
    	lbDica3Perg3.setText("");
    	lbDica1Perg4.setText("");
    	lbDica2Perg4.setText("");
    	lbDica3Perg4.setText("");
    	lbDica1Perg5.setText("");
    	lbDica2Perg5.setText("");
    	lbDica3Perg5.setText("");
    }
    /*busca no BD tabela pontuacao a quantidade de perguntas para
     * o random saber quantos numero aleatórios gerar,
     * ao gerar o numero busca no banco o assunto referente o numero/codigo
     * gerado*/
    @FXML
    void onMostrar(ActionEvent event) {
    	pontos = 0;
    	List<Pontuacao> pont = pontuacaoDao.listar();
    	List<Perguntas> perguntas = perguntasDao.listar();
    	Pontuacao qtd_perg = pont.get(0);
    	ponto.setQtd_perguntas(qtd_perg.getQtd_perguntas());
    	qtd_perguntas=ponto.getQtd_perguntas();
    	Random radom  = new Random();
        perg_codigo=radom.nextInt(qtd_perguntas);
    	Perguntas pergunta = perguntas.get(perg_codigo);
    	assunto_atual=pergunta.getAssunto();
    	lbAssunto.setText(pergunta.getAssunto());
    	lbPergunta1.setText(pergunta.getPergunta1());
    	lbPergunta2.setText(pergunta.getPergunta2());
    	lbPergunta3.setText(pergunta.getPergunta3());
    	lbPergunta4.setText(pergunta.getPergunta4());
    	lbPergunta5.setText(pergunta.getPergunta5());
    	novoDicasPerguntas();
    	pontuacao.setPontos(pontos);
		lbPontos.setText(pontuacao.getPontos().toString());
		confereperg1=true;
		confereperg2=true;
		confereperg3=true;
		confereperg4=true;
		confereperg5=true;
		dica1perg1=true;
		dica2perg1=true;
		dica3perg1=true;
		dica1perg2=true;
		dica2perg2=true;
		dica3perg2=true;
		dica1perg3=true;
		dica2perg3=true;
		dica3perg3=true;
		dica1perg4=true;
		dica2perg4=true;
		dica3perg4=true;
		dica1perg5=true;
		dica2perg5=true;
		dica3perg5=true;
    }

    /*São referente os botões para conferir a resposta, grava
     * em uma variavel a resposta digitada e busca no banco pela
     * resposta digita depois compara a variavel digitada com a 
     * do banco, caso forem iguais acrescenta 20 pontos e torna
     * a variavel confereperg1 com false para não somar mais uma
     * vez 20 pontos, a logica tambem informa se esta correto ou
     * não */
	@FXML
    void onConferirRespPerg1(ActionEvent event) {
    	resposta.setDigperg1(tfRespPerg1.getText());
    	List<Perguntas> perguntas = perguntasDao.listar();
    	Perguntas pergunta = perguntas.get(perg_codigo);
    	resposta.setRespperg1(pergunta.getRespperg1());
    	resperg1=resposta.getRespperg1();
    	digperg1=resposta.getDigperg1();
    	if(resperg1.equalsIgnoreCase(digperg1)) {
    		if(confereperg1 == true) {
        		pontuacao.setPontos(pontos=pontos+20);
            	lbPontos.setText(pontuacao.getPontos().toString());
            	confereperg1 = false;
        	}
    		lbResultPerg1.setText(conferir.getCorreto());
    	}else {
    		lbResultPerg1.setText(conferir.getErrado());	
    	}
    }

    @FXML
    void onConferirRespPerg2(ActionEvent event) {
    	resposta.setDigperg2(tfRespPerg2.getText());
    	List<Perguntas> perguntas = perguntasDao.listar();
    	Perguntas pergunta = perguntas.get(perg_codigo);
    	resposta.setRespperg2(pergunta.getRespperg2());
    	resperg2=resposta.getRespperg2();
    	digperg2=resposta.getDigperg2();
    	if(resperg2.equalsIgnoreCase(digperg2)) {
    		if(confereperg2 == true) {
        		pontuacao.setPontos(pontos=pontos+20);
            	lbPontos.setText(pontuacao.getPontos().toString());
            	confereperg2 = false;
        	}
    		lbResultPerg2.setText(conferir.getCorreto());
    	}else {
    		lbResultPerg2.setText(conferir.getErrado());	
    	}
    	
    }
    

    @FXML
    void onConferirRespPerg3(ActionEvent event) {
    	resposta.setDigperg3(tfRespPerg3.getText());
    	List<Perguntas> perguntas = perguntasDao.listar();
    	Perguntas pergunta = perguntas.get(perg_codigo);
    	resposta.setRespperg3(pergunta.getRespperg3());
    	resperg3=resposta.getRespperg3();
    	digperg3=resposta.getDigperg3();
    	if(resperg3.equalsIgnoreCase(digperg3)) {
    		if(confereperg3 == true) {
        		pontuacao.setPontos(pontos=pontos+20);
            	lbPontos.setText(pontuacao.getPontos().toString());
            	confereperg3 = false;
        	}
    		lbResultPerg3.setText(conferir.getCorreto());
    	}else {
    		lbResultPerg3.setText(conferir.getErrado());	
    	}
    	
    }
    

    @FXML
    void onConferirRespPerg4(ActionEvent event) {
    	resposta.setDigperg4(tfRespPerg4.getText());
    	List<Perguntas> perguntas = perguntasDao.listar();
    	Perguntas pergunta = perguntas.get(perg_codigo);
    	resposta.setRespperg4(pergunta.getRespperg4());
    	resperg4=resposta.getRespperg4();
    	digperg4=resposta.getDigperg4();
    	if(resperg4.equalsIgnoreCase(digperg4)) {
    		if(confereperg4 == true) {
        		pontuacao.setPontos(pontos=pontos+20);
            	lbPontos.setText(pontuacao.getPontos().toString());
            	confereperg4 = false;
        	}
    		lbResultPerg4.setText(conferir.getCorreto());
    	}else {
    		lbResultPerg4.setText(conferir.getErrado());	
    	}
    	
    }
    

    @FXML
    void onConferirRespPerg5(ActionEvent event) {
    	resposta.setDigperg5(tfRespPerg5.getText());
    	List<Perguntas> perguntas = perguntasDao.listar();
    	Perguntas pergunta = perguntas.get(perg_codigo);
    	resposta.setRespperg5(pergunta.getRespperg5());
    	resperg5=resposta.getRespperg5();
    	digperg5=resposta.getDigperg5();
    	if(resperg5.equalsIgnoreCase(digperg5)) {
    		if(confereperg5 == true) {
        		pontuacao.setPontos(pontos=pontos+20);
            	lbPontos.setText(pontuacao.getPontos().toString());
            	confereperg5 = false;
        	}
    		lbResultPerg5.setText(conferir.getCorreto());
    	}else {
    		lbResultPerg5.setText(conferir.getErrado());	
    	}
    	
    }

    @FXML
    void onDica1Perg1(ActionEvent event) {
    	if(dica1perg1 ==true) {
    	pontuacao.setPontos(pontos=pontos-5);
    	lbPontos.setText(pontuacao.getPontos().toString());
    	List<Perguntas> perguntas = perguntasDao.listar();
    	Perguntas pergunta = perguntas.get(perg_codigo);
     	lbDica1Perg1.setText(pergunta.getDica1perg1());
    	}
    	dica1perg1=false;
    }    
    
    @FXML
    void onDica2Perg1(ActionEvent event) {
    	if(dica2perg1==true) {
    	pontuacao.setPontos(pontos=pontos-5);
    	lbPontos.setText(pontuacao.getPontos().toString());
    	List<Perguntas> perguntas = perguntasDao.listar();
    	Perguntas pergunta = perguntas.get(perg_codigo);
     	lbDica2Perg1.setText(pergunta.getDica2perg1());
    	}
    	dica2perg1=false;
    }
    
    @FXML
    void onDica3Perg1(ActionEvent event) {
    	if(dica3perg1==true) {
    	pontuacao.setPontos(pontos=pontos-5);
    	lbPontos.setText(pontuacao.getPontos().toString());
    	List<Perguntas> perguntas = perguntasDao.listar();
    	Perguntas pergunta = perguntas.get(perg_codigo);
     	lbDica3Perg1.setText(pergunta.getDica3perg1());
    	}
    	dica3perg1=false;
    }
    
    @FXML
    void onDica1Perg2(ActionEvent event) {
    	if(dica1perg2==true) {
    	pontuacao.setPontos(pontos=pontos-5);
    	lbPontos.setText(pontuacao.getPontos().toString());
    	List<Perguntas> perguntas = perguntasDao.listar();
    	Perguntas pergunta = perguntas.get(perg_codigo);
     	lbDica1Perg2.setText(pergunta.getDica1perg2());
    	}
    	dica1perg2=false;
    }    
    
    @FXML
    void onDica2Perg2(ActionEvent event) {
    	if(dica2perg2==true) {
    	pontuacao.setPontos(pontos=pontos-5);
    	lbPontos.setText(pontuacao.getPontos().toString());
    	List<Perguntas> perguntas = perguntasDao.listar();
    	Perguntas pergunta = perguntas.get(perg_codigo);
     	lbDica2Perg2.setText(pergunta.getDica2perg2());
    	}
    	dica2perg2=false;
    }
    
    @FXML
    void onDica3Perg2(ActionEvent event) {
    	if(dica3perg2==true) {
    	pontuacao.setPontos(pontos=pontos-5);
    	lbPontos.setText(pontuacao.getPontos().toString());
    	List<Perguntas> perguntas = perguntasDao.listar();
    	Perguntas pergunta = perguntas.get(perg_codigo);
     	lbDica3Perg2.setText(pergunta.getDica3perg2());
    	}
    	dica3perg2=false;
    }
    
    @FXML
    void onDica1Perg3(ActionEvent event) {
    	if(dica1perg3==true) {
    	pontuacao.setPontos(pontos=pontos-5);
    	lbPontos.setText(pontuacao.getPontos().toString());
    	List<Perguntas> perguntas = perguntasDao.listar();
    	Perguntas pergunta = perguntas.get(perg_codigo);
     	lbDica1Perg3.setText(pergunta.getDica1perg3());
    	}
    	dica1perg3=false;
    }    
    
    @FXML
    void onDica2Perg3(ActionEvent event) {
    	if(dica2perg3==true) {
    	pontuacao.setPontos(pontos=pontos-5);
    	lbPontos.setText(pontuacao.getPontos().toString());
    	List<Perguntas> perguntas = perguntasDao.listar();
    	Perguntas pergunta = perguntas.get(perg_codigo);
     	lbDica2Perg3.setText(pergunta.getDica2perg3());
    	}
    	dica2perg3=false;
    }
    
    @FXML
    void onDica3Perg3(ActionEvent event) {
    	if(dica3perg3==true) {
    	pontuacao.setPontos(pontos=pontos-5);
    	lbPontos.setText(pontuacao.getPontos().toString());
    	List<Perguntas> perguntas = perguntasDao.listar();
    	Perguntas pergunta = perguntas.get(perg_codigo);
     	lbDica3Perg3.setText(pergunta.getDica3perg3());
    	}
    	dica3perg3=false;
    }
    
    @FXML
    void onDica1Perg4(ActionEvent event) {
    	if(dica1perg4==true) {
    	pontuacao.setPontos(pontos=pontos-5);
    	lbPontos.setText(pontuacao.getPontos().toString());
    	List<Perguntas> perguntas = perguntasDao.listar();
    	Perguntas pergunta = perguntas.get(perg_codigo);
     	lbDica1Perg4.setText(pergunta.getDica1perg4());
    	}
    	dica1perg4=false;
    }    
    
    @FXML
    void onDica2Perg4(ActionEvent event) {
    	if(dica2perg4==true) {
    	pontuacao.setPontos(pontos=pontos-5);
    	lbPontos.setText(pontuacao.getPontos().toString());
    	List<Perguntas> perguntas = perguntasDao.listar();
    	Perguntas pergunta = perguntas.get(perg_codigo);
     	lbDica2Perg4.setText(pergunta.getDica2perg4());
    	}
    	dica2perg4=false;
    }
    
    @FXML
    void onDica3Perg4(ActionEvent event) {
    	if(dica3perg4==true) {
    	pontuacao.setPontos(pontos=pontos-5);
    	lbPontos.setText(pontuacao.getPontos().toString());
    	List<Perguntas> perguntas = perguntasDao.listar();
    	Perguntas pergunta = perguntas.get(perg_codigo);
     	lbDica3Perg4.setText(pergunta.getDica3perg4());
     	}
    	dica3perg4=false;
    }
   
    @FXML
    void onDica1Perg5(ActionEvent event) {
    	if(dica1perg5==true) {
    	pontuacao.setPontos(pontos=pontos-5);
    	lbPontos.setText(pontuacao.getPontos().toString());
    	List<Perguntas> perguntas = perguntasDao.listar();
    	Perguntas pergunta = perguntas.get(perg_codigo);
     	lbDica1Perg5.setText(pergunta.getDica1perg5());
    	}
    	dica1perg5=false;
    }    
    
    @FXML
    void onDica2Perg5(ActionEvent event) {
    	if(dica2perg5==true) {
    	pontuacao.setPontos(pontos=pontos-5);
    	lbPontos.setText(pontuacao.getPontos().toString());
    	List<Perguntas> perguntas = perguntasDao.listar();
    	Perguntas pergunta = perguntas.get(perg_codigo);
     	lbDica2Perg5.setText(pergunta.getDica2perg5());
    	}
    	dica2perg5=false;
    }
    
    @FXML
    void onDica3Perg5(ActionEvent event) {
    	if(dica3perg5==true) {
    	pontuacao.setPontos(pontos=pontos-5);
    	lbPontos.setText(pontuacao.getPontos().toString());
    	List<Perguntas> perguntas = perguntasDao.listar();
    	Perguntas pergunta = perguntas.get(perg_codigo);
     	lbDica3Perg5.setText(pergunta.getDica3perg5());
    	}
    	dica3perg5=false;
    }
    
    /*grava na tabela pontuacao do banco os pontos e assunto
     * das perguntas alem do codigo do usuario*/

    @FXML
    void onConfirmar(ActionEvent event) {
    	List<CodUserAtual> listcoduseratual = coduserDao.listar();
    	CodUserAtual getcoduseratual = listcoduseratual.get(0);
    	List<Pontuacao> pont = pontuacaoDao.listar();
    	pontuacao.setCodusuario(getcoduseratual.getCod_user_atual());
    	pontuacao.setPontos(pontos);
    	pontuacao.setAssunto(assunto_atual);
		pontuacaoDao.inserir(pontuacao);
		lbAssunto.setText("");
		lbPergunta1.setText("");
		lbPergunta2.setText("");
		lbPergunta3.setText("");
		lbPergunta4.setText("");
		lbPergunta5.setText("");
		pontos=0;
		novoDicasPerguntas();
    }
                       
    /***********************MENU2(CRIAR PERGUNTAS)*******************/
   /* Salva na tabela perguntas do banco as perguntas e
    * limpa a tela*/
    @FXML
    void onSalvar(ActionEvent event) {
    	perguntas.setAssunto(tfAssunto.getText());
		perguntas.setPergunta1(tfPergunta1.getText());
		perguntas.setDica1perg1(tfDica1Perg1.getText());
		perguntas.setDica2perg1(tfDica2Perg1.getText());
		perguntas.setDica3perg1(tfDica3Perg1.getText());
		perguntas.setRespperg1(tfRespPerg1.getText());
		perguntas.setPergunta2(tfPergunta2.getText());
		perguntas.setDica1perg2(tfDica1Perg2.getText());
		perguntas.setDica2perg2(tfDica2Perg2.getText());
		perguntas.setDica3perg2(tfDica3Perg2.getText());
		perguntas.setRespperg2(tfRespPerg2.getText());
		perguntas.setPergunta3(tfPergunta3.getText());
		perguntas.setDica1perg3(tfDica1Perg3.getText());
		perguntas.setDica2perg3(tfDica2Perg3.getText());
		perguntas.setDica3perg3(tfDica3Perg3.getText());
		perguntas.setRespperg3(tfRespPerg3.getText());
		perguntas.setPergunta4(tfPergunta4.getText());
		perguntas.setDica1perg4(tfDica1Perg4.getText());
		perguntas.setDica2perg4(tfDica2Perg4.getText());
		perguntas.setDica3perg4(tfDica3Perg4.getText());
		perguntas.setRespperg4(tfRespPerg4.getText());
		perguntas.setPergunta5(tfPergunta5.getText());
		perguntas.setDica1perg5(tfDica1Perg5.getText());
		perguntas.setDica2perg5(tfDica2Perg5.getText());
		perguntas.setDica3perg5(tfDica3Perg5.getText());
		perguntas.setRespperg5(tfRespPerg5.getText());
		perguntasDao.inserir(perguntas);
		tfAssunto.setText("");
		tfPergunta1.setText("");
		tfDica1Perg1.setText("");
		tfDica2Perg1.setText("");
		tfDica3Perg1.setText("");
		tfResPerg1.setText("");
		tfDica1Perg2.setText("");
		tfDica2Perg2.setText("");
		tfDica3Perg2.setText("");
		tfResPerg2.setText("");
		tfDica1Perg3.setText("");
		tfDica2Perg3.setText("");
		tfDica3Perg3.setText("");
		tfResPerg3.setText("");
		tfDica1Perg4.setText("");
		tfDica2Perg4.setText("");
		tfDica3Perg4.setText("");
		tfResPerg4.setText("");
		tfDica1Perg5.setText("");
		tfDica2Perg5.setText("");
		tfDica3Perg5.setText("");
		tfResPerg5.setText("");
    }
   
    /***********************MENU3(PONTUACAO)*******************/
    /* busca a tabela pontuacao no banco pelo numero do usuario*/
    @FXML
	void onMostrarPontuacao(){
    	List<CodUserAtual> codusuario = coduserDao.listar();
    	CodUserAtual coduseratual = codusuario.get(0);
    	coduser.setCod_user_atual(coduseratual.getCod_user_atual());
    	tbnAssunto.setCellValueFactory(new PropertyValueFactory<>("assunto"));
    	tbnPontos.setCellValueFactory(new PropertyValueFactory<>("pontos"));
    	tbnData.setCellValueFactory(new PropertyValueFactory<>("data"));
		tblPontuacao.setItems(FXCollections.observableArrayList(pontosDaoString.listarpontos()));
    }
    
    /***********************MENU4(RELATÓRIOS)*******************/
    /*Gera relatório da tabela usuario do banco*/
    @FXML
    void onUsuarios(ActionEvent event) {
    	URL url = getClass().getResource("/usuarios.jasper");
    	try {
    		Map<String, Object> parametros = new HashMap<>();
    		parametros.put("usuario", "%%");

    		JasperPrint print = JasperFillManager
    				.fillReport(url.getPath(),
    				parametros, ConexaoUtil.getCon());
    		JasperViewer.viewReport(print);
    		JasperExportManager.exportReportToPdfFile(print,"RelUsuarios.pdf");
    	}catch(JRException e) {
    		e.printStackTrace();
    	}

    }
    /*Gera Relatorio da tabela perguntas do banco*/
    @FXML
    void onPerguntas(ActionEvent event) {
    	URL url = getClass().getResource("/perguntas.jasper");
    	try {
    		Map<String, Object> parametros = new HashMap<>();
    		parametros.put("assunto", "%%");

    		JasperPrint print = JasperFillManager
    				.fillReport(url.getPath(),
    				parametros, ConexaoUtil.getCon());
    		JasperViewer.viewReport(print);
    		JasperExportManager.exportReportToPdfFile(print,"RelPerguntas.pdf");
    	}catch(JRException e) {
    		e.printStackTrace();
    	}

    }
    /* Gera relatorio da tabela pontuacao do banco*/
    @FXML
    void onPontuacao(ActionEvent event) {
    	URL url = getClass().getResource("/pontos.jasper");
    	try {
    		Map<String, Object> parametros = new HashMap<>();
    		parametros.put("assunto", "%%");

    		JasperPrint print = JasperFillManager
    				.fillReport(url.getPath(),
    				parametros, ConexaoUtil.getCon());
    		JasperViewer.viewReport(print);
    		JasperExportManager.exportReportToPdfFile(print,"RelPontuacao.pdf");
    	}catch(JRException e) {
    		e.printStackTrace();
    	}
    }
   
}
