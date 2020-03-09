/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.ActaM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author govas
 */
public class ActaD {
    public static String eliminarActa(String clave) {
        String result = null;
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "DELETE FROM acta WHERE IDACTA = ?";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setInt(1, Integer.parseInt(clave));
                pst.executeUpdate();
//                result = "Disco eliminado con exito";
                JOptionPane.showMessageDialog(null, "Acta eliminado con exito");
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
    
    public static ActaM buscarActa(String clave) {
        ActaM act = new ActaM();
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "SELECT * FROM acta WHERE IDACTA = ?";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setInt(1, Integer.parseInt(clave));
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
//                   
                    act.setIDACTA(Integer.parseInt(rs.getString(1)));
                    act.setLIBACTA(rs.getString(2));
                    act.setFECREGACTA(rs.getString(3));
                    act.setOBSACTA(rs.getString(4));
                    act.setTIPACTA(rs.getString(5));
                    act.setESTACTA(rs.getString(6));
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
        return act;
    }
    
public static String actualizarActa(ActaM actaM) {
        String result = null;
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "UPDATE acta SET LIBACTA=?,FECREGACTA=?,OBSACTA=?,TIPACTA=? ,ESTACTA=? WHERE IDACTA=?";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setString(1, actaM.getLIBACTA());
                pst.setString(2, actaM.getFECREGACTA());
                pst.setString(3, actaM.getOBSACTA());
                pst.setString(4, actaM.getTIPACTA());
                pst.setString(5, actaM.getESTACTA());
                pst.setInt(6, actaM.getIDACTA());
                pst.executeUpdate();
//                result = "Disco Actualizado con exito, ID: " + loginM.getIDLOG();
                JOptionPane.showMessageDialog(null, "Acta Actualizado con exito, ID: "+ actaM.getIDACTA());
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
    
    public static String registrarActa(ActaM actaM) {
        String result = null, last = null;
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "insert into acta values(null,?,?,?,?,?)";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setString(1, actaM.getLIBACTA());
                pst.setString(2, actaM.getFECREGACTA());
                pst.setString(3, actaM.getOBSACTA());
                pst.setString(4, actaM.getTIPACTA());
                pst.setString(5, actaM.getESTACTA());
                pst.execute();
                pst = cn.prepareStatement("SELECT MAX(IDACTA) AS id FROM acta");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                last = rs.getString(1);
                }
                JOptionPane.showMessageDialog(null, "acta registrado con exito, ID: " + last);
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
    
    public static ArrayList<ActaM> getListActa(){
        ArrayList<ActaM> arrActa = new ArrayList<ActaM>();
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        ActaM actaM = null;
        String sql = "SELECT * FROM acta";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while(rs.next()) {
                    actaM = new ActaM();
                    
                    actaM.setIDACTA(Integer.parseInt(rs.getString(1)));
                    actaM.setLIBACTA(rs.getString(2));
                    actaM.setFECREGACTA(rs.getString(3));
                    actaM.setOBSACTA(rs.getString(4));
                    actaM.setTIPACTA(rs.getString(5));
                    actaM.setESTACTA(rs.getString(6));
                    arrActa.add(actaM);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
                System.out.println("Error " + e);
            }
        }
        return arrActa;
    }
}
