package qualosabor.com.br.qualosabor.models;

import com.orm.SugarRecord;

import java.sql.Blob;

public class Cliente extends SugarRecord {

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
