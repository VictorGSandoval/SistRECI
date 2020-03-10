/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Modelo.PersonaM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class PersonaD {
 
    public static String eliminarPersona(String clave) {
        String result = null;
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "DELETE FROM persona WHERE IDPER = ?";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setInt(1, Integer.parseInt(clave));
                pst.executeUpdate();
//                result = "Disco eliminado con exito";
                JOptionPane.showMessageDialog(null, "Persona eliminada con exito");
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
    
    public static PersonaM buscarPersona(String clave) {
        PersonaM per = new PersonaM();
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "SELECT * FROM persona WHERE IDPER = ?";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setString(1, clave);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
//                   
                    per.setIDPER(Integer.parseInt(rs.getString(1)));
                    per.setAPEPATPER(rs.getString(2));
                    per.setAPEMATERPER(rs.getString(3));
                    per.setNOMPER(rs.getString(4));
                    per.setFECNACPER(rs.getString(5));
                    per.setDNIPER(rs.getString(6));
                    per.setDIRPER(rs.getString(7));
                    per.setGENPER(rs.getString(8));
                    per.setCELPER(rs.getString(9));
                    per.setESTPER(rs.getString(10));
                    per.setESTCIVPER(rs.getString(11));
                    
                    
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
        return per;
    }
    
public static String actualizarPersona(PersonaM personaM) {
        String result = null;
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "UPDATE persona SET APEPATPER=?,APEMATERPER=?,NOMPER=?,FECNACPER=?,DNIPER=?,DIRPER=?,GENPER=?,CELPER=?,ESTPER=?,ESTCIVPER=? WHERE IDPER=?";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setString(1, personaM.getAPEPATPER());
                pst.setString(2, personaM.getAPEMATERPER());
                pst.setString(3, personaM.getNOMPER());
                pst.setString(4, personaM.getFECNACPER());
                pst.setString(5, personaM.getDNIPER());
                pst.setString(6, personaM.getDIRPER());
                pst.setString(7, personaM.getGENPER());
                pst.setString(8, personaM.getCELPER());
                pst.setString(9, personaM.getESTPER());
                pst.setString(10, personaM.getESTCIVPER());
                pst.setInt(11, personaM.getIDPER());
                pst.executeUpdate();
//                result = "Disco Actualizado con exito, ID: " + loginM.getIDLOG();
                JOptionPane.showMessageDialog(null, "Persona Actualizado con exito, ID: "+ personaM.getIDPER());
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
    
    public static String registrarPer(PersonaM personaM) {
        String result = null, last = null;
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "insert into persona values(null,?,?,?,?,?,?,?,?,?,?)";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setString(1, personaM.getAPEPATPER());
                pst.setString(2, personaM.getAPEMATERPER());
                pst.setString(3, personaM.getNOMPER());
                pst.setString(4, personaM.getFECNACPER());
                pst.setString(5, personaM.getDNIPER());
                pst.setString(6, personaM.getDIRPER());
                pst.setString(7, personaM.getGENPER());
                pst.setString(8, personaM.getCELPER());
                pst.setString(9, personaM.getESTPER());
                pst.setString(10, personaM.getESTCIVPER());
                pst.execute();
                pst = cn.prepareStatement("SELECT MAX(IDPER) AS id FROM persona");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                last = rs.getString(1);
                }
                JOptionPane.showMessageDialog(null, "Persona registrada con exito, ID: " + last);
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

    public static ArrayList<PersonaM> getListPersona(){
        ArrayList<PersonaM> arrPersona = new ArrayList<PersonaM>();
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        PersonaM personaM = null;
        String sql = "SELECT * FROM persona";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while(rs.next()) {
                    personaM = new PersonaM();
                    
                    personaM.setIDPER(Integer.parseInt(rs.getString(1)));
                    personaM.setAPEPATPER(rs.getString(2));
                    personaM.setAPEMATERPER(rs.getString(3));
                    personaM.setNOMPER(rs.getString(4));
                    personaM.setFECNACPER(rs.getString(5));
                    personaM.setDNIPER(rs.getString(6));
                    personaM.setDIRPER(rs.getString(7));
                    personaM.setGENPER(rs.getString(8));
                    personaM.setCELPER(rs.getString(9));
                    personaM.setESTPER(rs.getString(10));
                    personaM.setESTCIVPER(rs.getString(11));
                    arrPersona.add(personaM);
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
        return arrPersona;
    }
}
