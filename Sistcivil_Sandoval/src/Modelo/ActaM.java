/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author govas
 */
public class ActaM {
    private Integer IDACTA;
    private String LIBACTA;
    private String FECREGACTA;
    private String OBSACTA;
    private String TIPACTA;
    private String ESTACTA;
//    private Integer IDPER;

    public Integer getIDACTA() {
        return IDACTA;
    }

    public void setIDACTA(Integer IDACTA) {
        this.IDACTA = IDACTA;
    }

    public String getLIBACTA() {
        return LIBACTA;
    }

    public void setLIBACTA(String LIBACTA) {
        this.LIBACTA = LIBACTA;
    }

    public String getFECREGACTA() {
        return FECREGACTA;
    }

    public void setFECREGACTA(String FECREGACTA) {
        this.FECREGACTA = FECREGACTA;
    }

    public String getOBSACTA() {
        return OBSACTA;
    }

    public void setOBSACTA(String OBSACTA) {
        this.OBSACTA = OBSACTA;
    }

    public String getTIPACTA() {
        return TIPACTA;
    }

    public void setTIPACTA(String TIPACTA) {
        this.TIPACTA = TIPACTA;
    }

    public String getESTACTA() {
        return ESTACTA;
    }

    public void setESTACTA(String ESTACTA) {
        this.ESTACTA = ESTACTA;
    }
    
}
