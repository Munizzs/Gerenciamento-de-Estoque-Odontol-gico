
package model;


public class ServicosPrestados {
    private int idServicoPrestado;
    private String convenio;
    private int pago;
    private int idDentista;
    private int idMaterial;
    private int codServico;

    public int getIdServicoPrestado() {
        return idServicoPrestado;
    }

    public void setIdServicoPrestado(int idServicoPrestado) {
        this.idServicoPrestado = idServicoPrestado;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    public int getIdDentista() {
        return idDentista;
    }

    public void setIdDentista(int idDentista) {
        this.idDentista = idDentista;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public int getCodServico() {
        return codServico;
    }

    public void setCodServico(int codServico) {
        this.codServico = codServico;
    }
    
    
    
}
