package qualosabor.com.br.qualosabor.dao;

import android.util.Log;

import qualosabor.com.br.qualosabor.models.Pedido;
import qualosabor.com.br.qualosabor.models.Sabor;

public class CadastroPedidoDAO {

    public Boolean insert(Pedido pedido) {
        try {
            pedido.save();
            Log.i("teste", "Pedido" + pedido.getId() + " Inserido com sucesso!");
            return true;
        } catch(Exception erro) {
            Log.e("teste", "Erro " + erro.getMessage());
            return false;
        }

    }
}