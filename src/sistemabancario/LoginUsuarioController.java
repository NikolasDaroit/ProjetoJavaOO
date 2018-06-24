/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class LoginUsuarioController implements Initializable {
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField txtSenha;
    @FXML 
    private Button btnEntrar;
    
    
    public ArrayList<Cliente> clientes;
    public Database db = Database.getInstance();
    
    /**
     * Initializes the controller class.
     */
    
    @FXML
    private void autenticar(ActionEvent av){
        System.out.println("sistemabancario.PrincipalController.autenticar()");
        Parent root;
        boolean encontrado=false;
        for (Cliente cliente : clientes) {
          
            if (cliente.getEmail().equals(txtEmail.getText())){
                encontrado=true;
                if (cliente.getSenha().equals(txtSenha.getText())){
                    
                    try{
                        
                        db.setClienteAtivo(cliente);
                        System.out.println("ATIVO"+cliente);
                        Alert alert = new Alert(AlertType.CONFIRMATION, "Login correto", ButtonType.OK);
                        //alert.show();
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        root = fxmlLoader.load(getClass().getResource("BancoEletronico.fxml").openStream());
                        BancoEletronicoController bancoEletronico = (BancoEletronicoController) fxmlLoader.getController();
                        
                        System.out.println("HAUAHAUA"+db.getClienteAtivo());
                        Stage stage = SistemaBancario.stage;
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                    System.out.println("sistemabancario.PrincipalController.autenticar() asd@asd.com");
                        break;

                    }catch (IOException e){

                    }
                }else{
                    Alert alert = new Alert(AlertType.ERROR, "Email ou Senha incorrreto", ButtonType.OK);
                    alert.showAndWait();
                    break;
                }
            }
        }
        if (!encontrado){
            Alert alert = new Alert(AlertType.ERROR, "Email ou Senha incorrreto", ButtonType.OK);
            alert.showAndWait();
        }
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        clientes = db.getClientes();
        Cliente c2 = new Cliente();
        c2.setCpf("234234");
        c2.setNome("JohnDoe2");
        c2.setEmail("john@doe2.com");
        c2.setSenha("1234");
        c2.setReSenha("1234");
        c2.abrirConta(20);
        clientes.add(c2);
        
        Cliente c3 = new Cliente();
        c3.setCpf("234234");
        c3.setNome("JohnDoe3");
        c3.setEmail("john@doe3.com");
        c3.setSenha("1234");
        c3.setReSenha("1234");
        c3.abrirConta(30);
        clientes.add(c3);
        
        Cliente c4 = new Cliente();
        c4.setCpf("234234");
        c4.setNome("JohnDoe4");
        c4.setEmail("john@doe4.com");
        c4.setSenha("1234");
        c4.setReSenha("1234");
        c4.abrirConta(30);
        c4.abrirConta(20);
        clientes.add(c4);
        
        Cliente c5 = new Cliente();
        c5.setCpf("234234");
        c5.setNome("JohnDoe5");
        c5.setEmail("john@doe5.com");
        c5.setSenha("1234");
        c5.setReSenha("1234");
        c5.abrirConta(10);
        c5.abrirConta(20);
        clientes.add(c5);
        
              
    }  
   
    
    
}
