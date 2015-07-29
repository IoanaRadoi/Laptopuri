/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.util.ArrayList;

/**
 *
 * @author Oana
 */
public class LaptopNew implements java.io.Serializable{
    private String marca;
    private String tip;
    private String denumire;
    private String disponibilitate;
    private String frec_proc;
    private String dim_cache;
    private String tip_unitate_stocare;
    private String memorie_ram;
    private String cap_hdd;
    private String pret;
    private String poza;

    public String getPoza() {
        return poza;
    }

    public void setPoza(String poza) {
        this.poza = poza;
    }
    
    

    public LaptopNew() {
        
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getDisponibilitate() {
        return disponibilitate;
    }

    public void setDisponibilitate(String disponibilitate) {
        this.disponibilitate = disponibilitate;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getFrec_proc() {
        return frec_proc;
    }

    public void setFrec_proc(String frec_proc) {
        this.frec_proc = frec_proc;
    }

    public String getDim_cache() {
        return dim_cache;
    }

    public void setDim_cache(String dim_cache) {
        this.dim_cache = dim_cache;
    }

   

    public String getTip_unitate_stocare() {
        return tip_unitate_stocare;
    }

    public void setTip_unitate_stocare(String tip_unitate_stocare) {
        this.tip_unitate_stocare = tip_unitate_stocare;
    }

    public String getMemorie_ram() {
        return memorie_ram;
    }

    public void setMemorie_ram(String memorie_ram) {
        this.memorie_ram = memorie_ram;
    }

    public String getCap_hdd() {
        return cap_hdd;
    }

    public void setCap_hdd(String cap_hdd) {
        this.cap_hdd = cap_hdd;
    }

    public String getPret() {
        return pret;
    }

    public void setPret(String pret) {
        this.pret = pret;
    }

  
}
