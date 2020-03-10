/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.LoginM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class LoginD {
    public static String eliminarLogin(String clave) {
        String result = null;
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "DELETE FROM login WHERE IDLOG = ?";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setInt(1, Integer.parseInt(clave));
                pst.executeUpdate();
//                result = "Disco eliminado con exito";
                JOptionPane.showMessageDialog(null, "Usuario eliminado con exito");
            }
        } catch (SQLException e) {
//            result = "Error en la consulta: " + e.getMessage();
            JOptionPane.showMessageDialog(null, "Error en la consulta: "+ e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
//                result = "Error " + e;
                JOptionPane.showMessageDialog(null, "Error : "+e);
            }
        }
        return result;
    }
    
    
    
    public static String actualizarLogin(LoginM loginM) {
        String result = null;
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "UPDATE login SET USRLOG=?,PSSWLOG=?,TIPLOG=?,ESTLOG=? WHERE IDLOG=?";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setString(1, loginM.getUSRLOG());
                pst.setString(2, loginM.getPSSWLOG());
                pst.setString(3, loginM.getTIPLOG());
                pst.setString(4, loginM.getESTLOG());
                pst.setInt(5, loginM.getIDLOG());
                pst.executeUpdate();
//                result = "Disco Actualizado con exito, ID: " + loginM.getIDLOG();
                JOptionPane.showMessageDialog(null, "Usuario Actualizado con exito, ID: "+ loginM.getIDLOG());
            }
        } catch (SQLException e) {
//            result = "Error durante el registro: " + e.getMessage();
            JOptionPane.showMessageDialog(null, "Error durante el registro: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
//                result = "Error " + e;
                JOptionPane.showMessageDialog(null, "Error " + e);
            }
        }
        return result;
    }
    
    public static LoginM buscarLogin(String clave) {
        LoginM loginM = new LoginM();
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "SELECT * FROM login WHERE IDLOG = ?";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setString(1, clave); 
//                 pst.setString(1, loginM.getUSRLOG());
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
//                   
                    loginM.setUSRLOG(rs.getString(2));
                    loginM.setPSSWLOG(rs.getString(3));
                    loginM.setTIPLOG(rs.getString(4));
                    loginM.setESTLOG(rs.getString(5));
                    loginM.setIDLOG(Integer.parseInt(rs.getString(1)));
//                    
                }
//                discoVO.setResultado("Busqueda exitosa");
                JOptionPane.showMessageDialog(null, "Busqueda exitosa");
            }
        } catch (SQLException e) {
//            discoVO.setResultado("Error en la consulta: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error en la consulta" + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
//                discoVO.setResultado("Error " + e);
                JOptionPane.showMessageDialog(null, "Error" + e );
            }
        }
        return loginM;
    }
}
