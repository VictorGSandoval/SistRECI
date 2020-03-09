/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.ConexionBD;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;



/**
 *
 * @author govas
 */
public class LoginController implements Initializable {
    
    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField cjPassword;

    @FXML
    private TextField cjUsuario;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   

    
    @FXML 
    void cerrarSesion() { 
        
        System.exit(0); }  
    
    @FXML
    void iniciarSesion(ActionEvent evt){ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConnection();
        int resultado = 0;
        String pass = cjPassword.getText();
        String usuario = cjUsuario.getText();
        String tipo_permiso_usuario;
        PreparedStatement pst = null;
        String SQL = "select * from login where USRLOG= ? && PSSWLOG=?  ";
        try {
            pst = cn.prepareStatement(SQL);
            pst.setString(1, usuario);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                usuario = rs.getString("USRLOG");
                pass = rs.getString("PSSWLOG");

                if (usuario != null && pass != null) {
                    tipo_permiso_usuario = rs.getString("TIPLOG");

                    switch (tipo_permiso_usuario) {

                        case "Administrador":
                            ((Node) (evt.getSource())).getScene().getWindow().hide();
                            PersonaC form = new PersonaC();    //FORMULARIO EL CUAL SE VA ABRIR
                            form.setVisible(true);
//                            System.out.println("Admi");
                            
                            break;
                        case "Invitado":
                            ((Node) (evt.getSource())).getScene().getWindow().hide();
                            PersonaC1 form1 = new PersonaC1();    //FORMULARIO EL CUAL SE VA ABRIR
                            form1.setVisible(true);
//                            System.out.println("invi");
                            
                            break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error de Acceso,Usuario no Registrado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error no hay nada" + e.getMessage());
        }
    }
}
