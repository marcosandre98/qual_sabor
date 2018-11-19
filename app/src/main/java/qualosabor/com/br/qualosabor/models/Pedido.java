package qualosabor.com.br.qualosabor.models;

import com.orm.SugarRecord;

public class Pedido extends SugarRecord {

    private Integer numeroMesa;
    private Integer idSabor;
    private Integer idCliente;
    private Integer idEmpresa;
    private Integer situacaoPedido;


    public Pedido(Integer numeroMesa, Integer idSabor, Integer idCliente, Integer idEmpresa, Integer situacaoPedido) {
        this.numeroMesa = numeroMesa;
        this.idSabor = idSabor;
        this.idCliente = idCliente;
        this.idEmpresa = idEmpresa;
        this.situacaoPedido = situacaoPedido;
    }

    public Pedido() {

    }

    public Integer getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(Integer numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public Integer getIdSabor() {
        return idSabor;
    }

    public void setIdSabor(Integer idSabor) {
        this.idSabor = idSabor;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getSituacaoPedido() {
        return situacaoPedido;
    }

    public void setSituacaoPedido(Integer situacaoPedido) {
        this.situacaoPedido = situacaoPedido;
    }

}
