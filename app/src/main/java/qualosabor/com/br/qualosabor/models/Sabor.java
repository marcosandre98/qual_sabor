package qualosabor.com.br.qualosabor.models;

import com.orm.SugarRecord;

import java.sql.Blob;

public class Sabor extends SugarRecord {

    private String nomeSabor;
    private String ingredientes;
    private byte[] imagem;
    private Integer idEmpresa;


    public Sabor(String nomeSabor, String ingredientes, byte[] imagem, Integer idEmpresa) {
        this.nomeSabor = nomeSabor;
        this.ingredientes = ingredientes;
        this.imagem = imagem;
        this.idEmpresa = idEmpresa;
    }

    public Sabor() {

    }


    public String getNomeSabor() {
        return nomeSabor;
    }

    public void setNomeSabor(String nomeSabor) {
        this.nomeSabor = nomeSabor;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

}
