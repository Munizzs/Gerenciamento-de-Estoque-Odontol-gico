package model;

public class Estoque {
    private int idMaterial;
    private int idEquip;
    private String nomeEquip;
    private int quantidade;
    private String dtValidade;
    private String codLote;
    private int quantRemove;

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public int getIdEquip() {
        return idEquip;
    }

    public void setIdEquip(int idEquip) {
        this.idEquip = idEquip;
    }

    public String getNomeEquip() {
        return nomeEquip;
    }

    public void setNomeEquip(String nomeEquip) {
        this.nomeEquip = nomeEquip;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDtValidade() {
        return dtValidade;
    }

    public void setDtValidade(String dtValidade) {
        this.dtValidade = dtValidade;
    }

    public String getCodLote() {
        return codLote;
    }

    public void setCodLote(String codLote) {
        this.codLote = codLote;
    }

    public int getQuantRemove() {
        return quantRemove;
    }

    public void setQuantRemove(int quantRemove) {
        this.quantRemove = quantRemove;
    }
}
