
package model;


public class Manutencao {
    private String idManutencao;
    private String dtManutencao;
    private String idMaterial;
    private String manuDescri;
    private String fkSupri;

    public String getFkSupri() {
        return fkSupri;
    }

    public void setFkSupri(String fkSupri) {
        this.fkSupri = fkSupri;
    }

    public String getIdManutencao() {
        return idManutencao;
    }

    public void setIdManutencao(String idManutencao) {
        this.idManutencao = idManutencao;
    }

    public String getDtManutencao() {
        return dtManutencao;
    }

    public void setDtManutencao(String dtManutencao) {
        this.dtManutencao = dtManutencao;
    }

    public String getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(String idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getManuDescri() {
        return manuDescri;
    }

    public void setManuDescri(String manuDescri) {
        this.manuDescri = manuDescri;
    }
    

    
    
}
