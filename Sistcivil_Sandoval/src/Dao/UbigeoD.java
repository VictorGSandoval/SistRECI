/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.UbigeoM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author govas
 */
public class UbigeoD {
    public static String eliminarUbi(String clave) {
        String result = null;
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "DELETE FROM ubigeo WHERE CODUBI = ?";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setInt(1, Integer.parseInt(clave));
                pst.executeUpdate();
//                result = "Disco eliminado con exito";
                JOptionPane.showMessageDialog(null, "Ubigeo eliminado con exito");
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
    
    public static UbigeoM buscarUbi(String clave) {
        UbigeoM muni = new UbigeoM();
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "SELECT * FROM ubigeo WHERE CODUBI = ?";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setString(1, clave);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
//                   
                    muni.setCODUBI(rs.getString(1));
                    muni.setDEPUBI(rs.getString(2));
                    muni.setPROVUBI(rs.getString(3));
                    muni.setDISTUBI(rs.getString(4));
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
        return muni;
    }
    
public static String actualizarUbi(UbigeoM ubigeoM) {
        String result = null;
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "UPDATE ubigeo SET CODUBI=?,DEPUBI=?,PROVUBI=?,DISTUBI=? WHERE CODUBI=?";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setString(1, ubigeoM.getCODUBI());
                pst.setString(2, ubigeoM.getDEPUBI());
                pst.setString(3, ubigeoM.getPROVUBI());
                pst.setString(4, ubigeoM.getDISTUBI());
                pst.setString(5, ubigeoM.getCODUBI());
                pst.executeUpdate();
//                result = "Disco Actualizado con exito, ID: " + loginM.getIDLOG();
                JOptionPane.showMessageDialog(null, "Ubigeo Actualizado con exito, ID: "+ ubigeoM.getCODUBI());
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
    
   public static String registrarUbi(UbigeoM ubigeoM) {
        String result = null, last = null;
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "insert into ubigeo values(?,?,?,?)";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setString(1, ubigeoM.getCODUBI());
                pst.setString(2, ubigeoM.getDEPUBI());
                pst.setString(3, ubigeoM.getPROVUBI());
                pst.setString(4, ubigeoM.getDISTUBI());
                pst.execute();
                pst = cn.prepareStatement("SELECT MAX(CODUBI) AS id FROM ubigeo");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                last = rs.getString(1);
                }
                JOptionPane.showMessageDialog(null, "Ubigeo registrado con exito, ID: " + last);
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
}
