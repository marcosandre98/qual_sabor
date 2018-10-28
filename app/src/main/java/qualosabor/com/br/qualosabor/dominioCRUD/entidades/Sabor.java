package qualosabor.com.br.qualosabor.dominioCRUD.entidades;

import java.sql.Blob;

public class Sabor {

    private String nomeSabor;
    private String ingredientes;
    private Blob imagem;
    private Integer idEmpresa;


    public Sabor(String nomeSabor, String ingredientes, Blob imagem, Integer idEmpresa) {
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

    public Blob getImagem() {
        return imagem;
    }

    public void setImagem(Blob imagem) {
        this.imagem = imagem;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
