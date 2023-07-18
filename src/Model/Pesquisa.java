/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author murilo.comim
 */
public class Pesquisa {
    private String Campo;
    private String CampoDb;

    public String getCampo() {
        return Campo;
    }

    public void setCampo(String Campo) {
        this.Campo = Campo;
    }

    public String getCampoDb() {
        return CampoDb;
    }

    public void setCampoDb(String CampoDb) {
        this.CampoDb = CampoDb;
    }

    @Override
    public String toString() {
        return getCampo(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
