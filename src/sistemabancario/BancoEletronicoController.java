/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static javafx.application.ConditionalFeature.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class BancoEletronicoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    int accopc;
    private Cliente clienteAtivo = null;
    public Database db;
    private ArrayList<Conta> contas;
    Conta cc, cs, cp;
    @FXML
    private ListView lvClienteAtivo;
    @FXML
    private TextField txtConta;
    @FXML
    private TextField txtValor;
    @FXML
    private Label lblConta;
    @FXML
    private Label lblValor;
    @FXML
    public   ListView lvUsuario;
    @FXML
    private ButtonBar btbOpcoes;
    @FXML
    private ButtonBar btbContas;
    @FXML
    private Button btnSalario;
    @FXML
    private Button btnCorrente;
    @FXML
    private Button btnPoupanca;
    @FXML
    private Button btnCriarConta;
    @FXML
    private Button btnDepositar;
    @FXML
    private Button btnTransferir;
    @FXML
    private Button btnSacar;
    @FXML
    private Button btnAtt;
    @FXML
    private Button btnFinalizarDeposito;
    public BancoEletronicoController(){
        
    }
    public BancoEletronicoController(Cliente c){
        this.clienteAtivo = c;
    }
    @FXML
    private void liberaSalario(ActionEvent av){
        
        liberaAcoes(1);
        btbContas.setVisible(false);
        
    }
    @FXML
    private void liberaCorrente(ActionEvent av){
        liberaAcoes(2);
        btbContas.setVisible(false);
    }
    @FXML
    private void liberaPoupanca(ActionEvent av){
        liberaAcoes(3);
        btbContas.setVisible(false);
    }
    
    private void liberaAcoes(int opc){
        switch(opc){
            case 1: 
                btbOpcoes.setVisible(true);
                accopc=10;
                break;
            case 2: 
                btbOpcoes.setVisible(true);
                accopc=20;
                break;
            case 3:
                btbOpcoes.setVisible(true);
                accopc=30;
                break;
        }
    }
   
    @FXML
    private void handleDepositar(ActionEvent av){
        lblValor.setVisible(true); 
        txtValor.setVisible(true);
        btnFinalizarDeposito.setVisible(true);
    }
    
    private void hideItens(){
        btnCorrente.setVisible(false);
        btnCriarConta.setVisible(false);
        btnPoupanca.setVisible(false);
        btbOpcoes.setVisible(false);
        btnSalario.setVisible(false);
        lblValor.setVisible(false); 
        txtValor.setVisible(false);
        lblConta.setVisible(false); 
        txtConta.setVisible(false);
        btnFinalizarDeposito.setVisible(false);
    }
    @FXML
    public void updateClienteAtivo(){
        hideItens();
        this.clienteAtivo = db.getClienteAtivo();
        btbContas.setVisible(true);
        lvClienteAtivo.getItems().clear();
        lvClienteAtivo.scrollTo(lvClienteAtivo.getItems().size() - 1);
        lvClienteAtivo.getItems().add(this.clienteAtivo);
        if (this.clienteAtivo!=null){
            System.out.println(this.clienteAtivo.getConta(10));
            if (clienteAtivo.getConta(10) !=null){ //salario
                btnSalario.setVisible(true);
            }else{
               btnSalario.setVisible(false); 
            }
            if (clienteAtivo.getConta(20) !=null){ //corrente
                btnCorrente.setVisible(true);
            }else{
               btnCorrente.setVisible(false); 
            }
            if (clienteAtivo.getConta(30) !=null){ //poupanca
                btnPoupanca.setVisible(true);
            }else{
               btnPoupanca.setVisible(false); 
            }
            if (clienteAtivo.getConta(10) ==null && clienteAtivo.getConta(20) ==null  && clienteAtivo.getConta(30) ==null ){ //salario
                btnCriarConta.setVisible(true);
            }else{
                btnCriarConta.setVisible(false);
            }
        }
    }
    
    @FXML
    private void realizarDeposito(ActionEvent av){
        this.clienteAtivo.getConta(accopc).deposita(Double.parseDouble(txtValor.getText()));
        System.out.println(this.clienteAtivo.getConta(accopc).getSaldo());
        updateClienteAtivo();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        db = Database.getInstance();
        
            
        btbOpcoes.setVisible(false);
        hideItens();

    }   
}
