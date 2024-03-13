
package model;


public class Estoque {
    private int idMaterial;
    private String nomeEquip;
    private int qtdMaterial;
    private double validade;

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNomeEquip() {
        return nomeEquip;
    }

    public void setNomeEquip(String nomeEquip) {
        this.nomeEquip = nomeEquip;
    }

    public int getQtdMaterial() {
        return qtdMaterial;
    }

    public void setQtdMaterial(int qtdMaterial) {
        this.qtdMaterial = qtdMaterial;
    }

    public double getValidade() {
        return validade;
    }

    public void setValidade(double validade) {
        this.validade = validade;
    }
        
}
