package qualosabor.com.br.qualosabor.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import qualosabor.com.br.qualosabor.R;
import qualosabor.com.br.qualosabor.dao.CadastroSaborDAO;
import qualosabor.com.br.qualosabor.dao.CadastroUsuarioDAO;
import qualosabor.com.br.qualosabor.models.Sabor;
import qualosabor.com.br.qualosabor.models.Usuario;

public class CadastroSabor extends AppCompatActivity {

    private EditText txtNomeSabor;
    private EditText txtIngre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_sabor);

        txtNomeSabor = (EditText) CadastroSabor.this.findViewById(R.id.txtNomeSabor);
        txtIngre = (EditText) CadastroSabor.this.findViewById(R.id.txtIngre);
    }

    public void cadastrarSabor(View view){ // View V serve para ação de CLICK
        CadastroEmpresa c = new CadastroEmpresa();
        Sabor sabor = new Sabor(txtNomeSabor.getText().toString(), txtIngre.getText().toString(), null, 1);
        Log.i("teste", "Usuário" + c.idEmpresa + " Inserido com sucesso!");
        CadastroSaborDAO cadastroSaborDAO = new CadastroSaborDAO();
        if (cadastroSaborDAO.insert(sabor)) {
            Toast.makeText(this, "Sabor cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            this.voltar(view);
        }else{
            Toast.makeText(this, "Erro ao inserir sabor!", Toast.LENGTH_SHORT).show();
        }
    }

    public void voltar(View view){
        Intent abreMenuEmpresa = new Intent(this, MenuEmpresa.class);
        startActivity(abreMenuEmpresa);
    }
}
