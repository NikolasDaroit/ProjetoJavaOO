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
import java.util.ArrayList;
import java.util.ResourceBundle;
import static javafx.application.ConditionalFeature.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class CadastroClienteController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField nomeCompleto;
    @FXML
    private TextField usuario;
    @FXML
    private TextField email;
    @FXML
    private TextField senha;
    @FXML
    private TextField reSenha;
    @FXML
    private Label mensagemSistema;
    @FXML
    public   ListView lvUsuario;
    
    
    public ArrayList<Cliente> clientes;
    public Database db = Database.getInstance();
    private boolean verificaSenhaIgual(String senha1, String senha2){
        if(senha1.equals(senha2)){
            return true;
        }
        return false;
    }
        @FXML
    private Button btnMenu;
    
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
    private void loginUsuario(ActionEvent av){
        Parent root;
        try{
            
            FXMLLoader fxmlLoader = new FXMLLoader();
            root = fxmlLoader.load(getClass().getResource("LoginUsuario.fxml").openStream());
            
            Stage stage = SistemaBancario.stage;
            Scene scene = new Scene(root);
            stage.setScene(scene);


        }catch (IOException e){

        }
    }
    @FXML
    private void cadastroButtonAction(ActionEvent event) {
        if (!verificaSenhaIgual(senha.getText(), reSenha.getText()) && senha.getText().length()>0){
            mensagemSistema.setText("Senhas incompativeis");
        }
        Cliente u = new Cliente();
        u.setNome(nomeCompleto.getText());
        u.setEmail(email.getText());
        u.setSenha(senha.getText());
        u.setReSenha(reSenha.getText());
        clientes.add(u);
        mensagemSistema.setText("Usuario "+u.getUniqueID()+" cadastrado corretamente!");
        
        //lvUsuario.getItems().add(u);
        lvUsuario.scrollTo(lvUsuario.getItems().size() - 1);
        lvUsuario.getItems().add(u);
        //insertUser(u.getNome(), u.getEmail(), u.getUsuario(), u.getSenha(), u.getReSenha());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clientes = db.getClientes();   
        // TODO
    }    
    public void insertUser(String nome, String email, String usuario, String senha, String reSenha){
        Conexao c = new Conexao();
        Connection dbConnection = c.getConexao();
        String insertUserSql = "INSERT INTO usuariojava"
                               +"(nome, email, usuario, senha, reSenha) VALUES"
                               +"(?,?,?,?,?)";
        try {   
           PreparedStatement ps = null; 
           ps = dbConnection.prepareStatement(insertUserSql);
           ps.setString(1, nome);
           ps.setString(2, email);
           ps.setString(3, usuario);
           ps.setString(4, senha);
           ps.setString(5, reSenha);
           int ret = ps.executeUpdate();
           if (ret>0){
             System.out.println(insertUserSql);   
           }
        } catch (Exception e) {
        }
    }
    
}
