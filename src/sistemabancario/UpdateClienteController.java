/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario;

import model.Cliente;
import model.Database;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class UpdateClienteController implements Initializable {
    public Database db = Database.getInstance();
    @FXML
    private TextField nomeCompleto;
    @FXML
    private TextField nome;
    @FXML
    private PasswordField senha;
    @FXML
    private PasswordField reSenha;
    @FXML
    private Cliente clienteAtivo;
    
    @FXML
    private void goToMenu(){
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            root = fxmlLoader.load(getClass().getResource("MenuPrincipal.fxml").openStream());                       
            Stage stage = SistemaBancario.stage;
            Scene scene = new Scene(root);
            stage.setScene(scene);
            
        } catch (Exception e) {
        }
    }
    @FXML
    public void teste(){
        this.clienteAtivo = db.getClienteAtivo();
        System.out.println("CLIENTE ATIVO"+this.clienteAtivo);
        this.nome.setText(this.clienteAtivo.getNome());
        this.senha.setText(this.clienteAtivo.getSenha());
        this.reSenha.setText(this.clienteAtivo.getSenha());
    }
    @FXML
    public void updateUser(){
        Conexao c = new Conexao();
        Connection dbConnection = c.getConexao();
        String insertUserSql = ("UPDATE usuariojava SET nome = ?, senha = ?, reSenha = ? WHERE email = ?");
        try {   
           PreparedStatement ps = null; 
           ps = dbConnection.prepareStatement(insertUserSql);
           ps.setString(1, nome.getText());
           ps.setString(2, senha.getText());
           ps.setString(3, reSenha.getText());
           ps.setString(4, this.clienteAtivo.getEmail());
           int ret = ps.executeUpdate();
           if (ret>0){
             System.out.println(insertUserSql);   
           }
        } catch (Exception e) {
            System.out.println("aqui "+e);
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        teste();
        
        
        
    }    
    
}
