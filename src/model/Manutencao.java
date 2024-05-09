
package model;


public class Manutencao {
    private int idManutencao;
    private int dtManutencao;
    private int idMaterial;
    private String manuDescri;
    

    public String getManuDescri() {
        return manuDescri;
    }

    public void setManuDescri(String manuDescri) {
        this.manuDescri = manuDescri;
    }
    
    public int getIdManutencao() {
        return idManutencao;
    }

    public void setIdManutencao(int idManutencao) {
        this.idManutencao = idManutencao;
    }

    public int getDtManutencao() {
        return dtManutencao;
    }

    public void setDtManutencao(int dtManutencao) {
        this.dtManutencao = dtManutencao;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }
    
}
