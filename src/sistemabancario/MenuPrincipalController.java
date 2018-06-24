/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author majinbuzz
 */
public class MenuPrincipalController implements Initializable {
    @FXML
    private Button cadastroClienteButton;
    @FXML
    private Button loginClienteButton;
    @FXML
    private Button cadastroFuncionarioButton;
    @FXML
    private Button cadastroAgenciaButton;
    @FXML
    private Button cadastroCaixaButton;
    
    @FXML
    private void handleCadastroCliente(){
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            root = fxmlLoader.load(getClass().getResource("CadastroCliente.fxml").openStream());
            //BancoEletronicoController bancoEletronico = (BancoEletronicoController) fxmlLoader.getController();

            //System.out.println("HAUAHAUA"+db.getClienteAtivo());
            Stage stage = SistemaBancario.stage;
            Scene scene = new Scene(root);
            stage.setScene(scene);
            
        } catch (Exception e) {
        }
    }
    @FXML
    private void handleLoginCliente(){
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            root = fxmlLoader.load(getClass().getResource("LoginUsuario.fxml").openStream());
            //BancoEletronicoController bancoEletronico = (BancoEletronicoController) fxmlLoader.getController();

            //System.out.println("HAUAHAUA"+db.getClienteAtivo());
            Stage stage = SistemaBancario.stage;
            Scene scene = new Scene(root);
            stage.setScene(scene);
            
        } catch (Exception e) {
        }
    }
    @FXML
    private void handleCadastroFuncionario(){
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            root = fxmlLoader.load(getClass().getResource("CadastroFuncionario.fxml").openStream());
            //BancoEletronicoController bancoEletronico = (BancoEletronicoController) fxmlLoader.getController();

            //System.out.println("HAUAHAUA"+db.getClienteAtivo());
            Stage stage = SistemaBancario.stage;
            Scene scene = new Scene(root);
            stage.setScene(scene);
            
        } catch (Exception e) {
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
