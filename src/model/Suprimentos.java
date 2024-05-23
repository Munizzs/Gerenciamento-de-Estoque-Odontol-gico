package model;

public class Suprimentos {
    private int idEquip;
    private String nomeEquip;
    private String dtValidade;
    private String dtCompra;
    private String codLote;
    private String quantidade;
    private boolean reutilizavel;
    
    public String getDtValidade() {
        return dtValidade;
    }

    public void setDtValidade(String dtValidade) {
        this.dtValidade = dtValidade;
    }

    public String getDtCompra() {
        return dtCompra;
    }

    public void setDtCompra(String dtCompra) {
        this.dtCompra = dtCompra;
    }

    public String getCodLote() {
        return codLote;
    }

    public void setCodLote(String codLote) {
        this.codLote = codLote;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
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

    public boolean isReutilizavel() {
        return reutilizavel;
    }

    public void setReutilizavel(boolean reutilizavel) {
        this.reutilizavel = reutilizavel;
    }
    
    // estoque
    public String getCodigo() {
        return codLote;
    }

    public void setCodigo(String codigo) {
        this.codLote = codigo;
    }
}
