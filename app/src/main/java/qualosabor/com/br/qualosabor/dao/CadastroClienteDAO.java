package qualosabor.com.br.qualosabor.dao;

import android.util.Log;

import qualosabor.com.br.qualosabor.models.Cliente;
import qualosabor.com.br.qualosabor.models.Sabor;

public class CadastroClienteDAO {

    public int insert(Cliente cliente) {
        try {
            cliente.save();
            Log.i("teste", "Cliente" + cliente.getId() + " Inserido com sucesso!");
            return (int) (long) cliente.getId();
        } catch(Exception erro) {
            Log.e("teste", "Erro " + erro.getMessage());
            return 0;
        }

    }
}