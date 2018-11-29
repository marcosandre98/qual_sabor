package qualosabor.com.br.qualosabor.dao;

import android.util.Log;

import qualosabor.com.br.qualosabor.models.Usuario;

public class CadastroUsuarioDAO {

    public Boolean insert(Usuario usuario) {
        try {
            usuario.save();
            Log.i("teste", "Usuário " + usuario.getId() +" - " + usuario.getLoginUsuario() + " Inserido com sucesso!");
            return true;
        } catch(Exception erro) {
            Log.e("teste", "Erro " + erro.getMessage());
            return false;
        }

    }
}