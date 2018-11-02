package qualosabor.com.br.qualosabor.dao;

import android.util.Log;

import qualosabor.com.br.qualosabor.models.Cliente;
import qualosabor.com.br.qualosabor.models.Sabor;

public class CadastroClienteDAO {

    public Boolean insert(Cliente cliente) {
        try {
            cliente.save();
            Log.i("teste", "Cliente" + cliente.getId() + " Inserido com sucesso!");
            return true;
        } catch(Exception erro) {
            Log.e("teste", "Erro " + erro.getMessage());
            return false;
        }

    }
}