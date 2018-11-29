package qualosabor.com.br.qualosabor.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import qualosabor.com.br.qualosabor.R;
import qualosabor.com.br.qualosabor.dao.CadastroUsuarioDAO;
import qualosabor.com.br.qualosabor.models.Usuario;


public class CadastroUsuario extends AppCompatActivity {

    private EditText txtUsuarioLogin;
    private EditText txtSenha;
    private Button btnCadastrarUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        txtUsuarioLogin = (EditText) CadastroUsuario.this.findViewById(R.id.txtUsuarioLogin);
        txtSenha = (EditText) CadastroUsuario.this.findViewById(R.id.txtSenha);
        //txtIdEmpresa = (EditText) CadastroUsuario.this.findViewById(R.id.txtIdEmpresa);
        btnCadastrarUsuario = (Button) findViewById(R.id.btnCadastrarUsuario);
    }

    public void cadastrarUsuario(View view) {
        Usuario usuario = new Usuario(txtUsuarioLogin.getText().toString(), txtSenha.getText().toString(),1);
        CadastroUsuarioDAO cadastroUsuarioDAO = new CadastroUsuarioDAO();
        if (cadastroUsuarioDAO.insert(usuario)) {
            Toast.makeText(this, "Usuário inserido com sucesso!", Toast.LENGTH_SHORT).show();
            this.avancar(view);
        } else {
            Toast.makeText(this, "Erro ao inserir usuário!", Toast.LENGTH_SHORT).show();
        }
    }

    public void avancar(View view) {
        Intent abreMenuEmpresa = new Intent(this, MenuEmpresa.class);
        startActivity(abreMenuEmpresa);
    }

}
