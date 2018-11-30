package qualosabor.com.br.qualosabor.dao;

import qualosabor.com.br.qualosabor.models.CodigoVerificacao;

public class GravaCodigoDAO {

    public Boolean insert(CodigoVerificacao codigo) {
        try {
            codigo.save();
            return true;
        } catch(Exception erro) {
            return false;
        }
    }
}