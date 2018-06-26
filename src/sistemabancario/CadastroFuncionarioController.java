/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario;

import model.Database;
import model.Gerente;
import model.Empregado;
import model.Seguranca;
import model.Funcionario;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author majinbuzz
 */
public class CadastroFuncionarioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public ArrayList<Empregado> empregados;
    public Database db = Database.getInstance();
    @FXML
    private TextField nome;
    @FXML
    private TextField email;
    @FXML
    private TextField senha;
    
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
    public   ListView lvEmpregado;
    @FXML
    public RadioButton gerenteButton;
    @FXML
    public RadioButton funcionarioButton;
    @FXML
    public RadioButton empregadoButton;
    @FXML
    public RadioButton segurancaButton;
    @FXML
    private ToggleGroup tipoEmpregado;
    @FXML
    private void start(){ 
        funcionarioButton.setUserData(1);
        gerenteButton.setUserData(2);
        segurancaButton.setUserData(3);
    }
    private void clearStuff(){
        nome.setText("");
        email.setText("");
        senha.setText("");
        
        for (Toggle rb : tipoEmpregado.getToggles()) {
            rb.setSelected(false);
            
        }
        lvEmpregado.getItems().clear();
        for (Empregado empregado : empregados) {
            System.out.println(empregado);
            lvEmpregado.scrollTo(lvEmpregado.getItems().size() - 1);
            lvEmpregado.getItems().add(empregado);
            
        }
    }
    @FXML
    private void cadastroButtonAction(ActionEvent event) {
        start();
//        if (!verificaSenhaIgual(senha.getText(), reSenha.getText()) && senha.getText().length()>0){
//            mensagemSistema.setText("Senhas incompativeis");
//        }
        System.out.println(tipoEmpregado.getSelectedToggle().getUserData());
              Empregado emp = null;
          switch((int)tipoEmpregado.getSelectedToggle().getUserData() ){
              case 1: 
                  emp = new Funcionario(); 
                  emp.setNome(nome.getText());
                  emp.setEmail(email.getText());
                  emp.setSenha(senha.getText());
                  emp.setReSenha(senha.getText());
                  break;
                  
              case 2: 
                  emp = new Gerente();
                  emp.setNome(nome.getText());
                  emp.setEmail(email.getText());
                  emp.setSenha(senha.getText());
                  emp.setReSenha(senha.getText());
                  break;
              case 3: 
                  emp = new Seguranca(); 
                  emp.setNome(nome.getText());
                  emp.setEmail(email.getText());
                  emp.setSenha(senha.getText());
                  emp.setReSenha(senha.getText());
                  break;
                
                  
          }
          empregados.add(emp);
          clearStuff();
//        Em u = new Cliente();
//        u.setNome(nomeCompleto.getText());
//        u.setEmail(email.getText());
//        u.setSenha(senha.getText());
//        u.setReSenha(reSenha.getText());
//        clientes.add(u);
//        mensagemSistema.setText("Usuario "+u.getUniqueID()+" cadastrado corretamente!");
//        
//        //lvUsuario.getItems().add(u);
//        lvUsuario.scrollTo(lvUsuario.getItems().size() - 1);
//        lvUsuario.getItems().add(u);
//        //insertUser(u.getNome(), u.getEmail(), u.getUsuario(), u.getSenha(), u.getReSenha());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        empregados = db.getEmpregados();
        // com erro
        for (Empregado empregado : empregados) {
            System.out.println(empregado);
            lvEmpregado.scrollTo(lvEmpregado.getItems().size() - 1);
            lvEmpregado.getItems().add(empregado);
            
        }
       
        
        // TODO
    }    
    
}
