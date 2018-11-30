package qualosabor.com.br.qualosabor.models;

import com.orm.SugarRecord;

public class CodigoVerificacao extends SugarRecord {

    private int codigoValidacao;


    public CodigoVerificacao(int codigoValidacao) {
        this.codigoValidacao = codigoValidacao;
    }

    public CodigoVerificacao() {

    }

    public int getCodigoValidacao() {
        return codigoValidacao;
    }

    public void setCodigoValidacao(int codigoValidacao) {
        this.codigoValidacao = codigoValidacao;
    }

}
