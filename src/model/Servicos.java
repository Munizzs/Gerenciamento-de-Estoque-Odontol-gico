
package model;


public class Servicos {
    private int codServico;
    private String tipoServico;
    private double preco;
    private double qtEquipamento;
    private int idMaterial;
    private int idDentista;

    public int getCodServico() {
        return codServico;
    }

    public void setCodServico(int codServico) {
        this.codServico = codServico;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getQtEquipamento() {
        return qtEquipamento;
    }

    public void setQtEquipamento(double qtEquipamento) {
        this.qtEquipamento = qtEquipamento;
    }

    public int getFkidMaterial() {
        return idMaterial;
    }

    public void setFkidMaterial(int fkidMaterial) {
        this.idMaterial = fkidMaterial;
    }

    public int getFkidDentista() {
        return idDentista;
    }

    public void setFkidDentista(int fkidDentista) {
        this.idDentista = fkidDentista;
    }
    
    
}
