/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.MunicipalidadM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author govas
 */
public class MunicipalidadD {
    
    public static String eliminarMuni(String clave) {
        String result = null;
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "DELETE FROM municipalidad WHERE IDMUN = ?";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setInt(1, Integer.parseInt(clave));
                pst.executeUpdate();
//                result = "Disco eliminado con exito";
                JOptionPane.showMessageDialog(null, "Municipalidad eliminado con exito");
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
    
    public static MunicipalidadM buscarMuni(String clave) {
        MunicipalidadM muni = new MunicipalidadM();
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "SELECT * FROM municipalidad WHERE IDMUN = ?";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setInt(1, Integer.parseInt(clave));
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
//                   
                    muni.setIDMUN(Integer.parseInt(rs.getString(1)));
                    muni.setDIRMUN(rs.getString(2));
                    muni.setNOMMUN(rs.getString(3));
                    muni.setTLFMUN(rs.getString(4));
                    muni.setESTMUN(rs.getString(5));
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
    
public static String actualizarMuni(MunicipalidadM municipalidadM) {
        String result = null;
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "UPDATE municipalidad SET DIRMUN=?,NOMMUN=?,TLFMUN=?,ESTMUN=? WHERE IDMUN=?";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setString(1, municipalidadM.getDIRMUN());
                pst.setString(2, municipalidadM.getNOMMUN());
                pst.setString(3, municipalidadM.getTLFMUN());
                pst.setString(4, municipalidadM.getESTMUN());
                pst.setInt(5, municipalidadM.getIDMUN());
                pst.executeUpdate();
//                result = "Disco Actualizado con exito, ID: " + loginM.getIDLOG();
                JOptionPane.showMessageDialog(null, "Municipalidad Actualizado con exito, ID: "+ municipalidadM.getIDMUN());
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
    
    public static String registrarMuni(MunicipalidadM municipalidadM) {
        String result = null, last = null;
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "insert into municipalidad values(null,?,?,?,?)";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setString(1, municipalidadM.getDIRMUN());
                pst.setString(2, municipalidadM.getNOMMUN());
                pst.setString(3, municipalidadM.getTLFMUN());
                pst.setString(4, municipalidadM.getESTMUN());
                pst.execute();
                pst = cn.prepareStatement("SELECT MAX(IDMUN) AS id FROM municipalidad");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                last = rs.getString(1);
                }
                JOptionPane.showMessageDialog(null, "Municipalidad registrado con exito, ID: " + last);
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
