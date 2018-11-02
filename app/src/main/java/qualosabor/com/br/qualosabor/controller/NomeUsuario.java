package qualosabor.com.br.qualosabor.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import qualosabor.com.br.qualosabor.R;
import qualosabor.com.br.qualosabor.dao.CadastroClienteDAO;
import qualosabor.com.br.qualosabor.dao.CadastroSaborDAO;
import qualosabor.com.br.qualosabor.models.Cliente;
import qualosabor.com.br.qualosabor.models.Sabor;

public class NomeUsuario extends AppCompatActivity {

    private EditText txtNomeCliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nome_usuario);

        txtNomeCliente = (EditText) NomeUsuario.this.findViewById(R.id.txtCodNomeUsu);
    }

    public void cadastroCliente (View view){ // View V serve para ação de CLICK
        CadastroEmpresa c = new CadastroEmpresa();
        Cliente cliente = new Cliente(txtNomeCliente.getText().toString(),1);
        Log.i("teste", "Cliente" + c.idEmpresa + " Inserido com sucesso!");
        CadastroClienteDAO cadastroClienteDAO = new CadastroClienteDAO();
        if (cadastroClienteDAO.insert(cliente)) {
            Toast.makeText(this, "Cliente cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            this.avancar(view);
        }else{
            Toast.makeText(this, "Erro ao inserir sabor!", Toast.LENGTH_SHORT).show();
        }
    }

    public void avancar(View view){
        Intent abreSabores = new Intent(this, EscolherSabores.class);
        startActivity(abreSabores);
    }
}
