package qualosabor.com.br.qualosabor.dao;

import android.util.Log;

import qualosabor.com.br.qualosabor.models.Sabor;
import qualosabor.com.br.qualosabor.models.Usuario;

public class CadastroSaborDAO {

    public Boolean insert(Sabor sabor) {
        try {
            sabor.save();
            Log.i("teste", "Sabor" + sabor.getId() + " Inserido com sucesso!");
            return true;
        } catch(Exception erro) {
            Log.e("teste", "Erro " + erro.getMessage());
            return false;
        }

    }
}