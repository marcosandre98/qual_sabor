package qualosabor.com.br.qualosabor.dominioCRUD.entidades;

import java.sql.Blob;

public class Cliente {

    private String nomeCliente;
    private Integer idEmpresa;


    public Cliente(String nomeCliente, Integer idEmpresa) {
        this.nomeCliente = nomeCliente;
        this.idEmpresa = idEmpresa;
    }

    public Cliente() {

    }


    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
