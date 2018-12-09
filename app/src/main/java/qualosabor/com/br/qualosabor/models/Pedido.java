package qualosabor.com.br.qualosabor.models;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

import java.util.ArrayList;
import java.util.List;

public class Pedido extends SugarRecord {

    private Integer numeroMesa;
    private Integer idSabor;
    private Integer idCliente;
    private Integer idEmpresa;
    private Integer situacaoPedido;

    @Ignore
    private Sabor sabor;
    private Cliente cliente;


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

    public Sabor getSabor() {
        return sabor;
    }

    public void setSabor(Sabor sabor) {
        this.sabor = sabor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {

        return "Mesa: " + this.numeroMesa
                + "; Sabor: " + this.idSabor
                + "; Cliente: " + this.idCliente
                + "; Situação: " + this.situacaoPedido;
    }



}
