package qualosabor.com.br.qualosabor;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import qualosabor.com.br.qualosabor.adapter.EmpresaAdapter;
import qualosabor.com.br.qualosabor.dominioCRUD.CadastroEmpresaDAO;
import qualosabor.com.br.qualosabor.dominioCRUD.entidades.Empresa;

public class CadastroEmpresa extends AppCompatActivity {

    private EditText txtRazaoSocial;
    private EditText txtNomeFantasia;
    private EditText txtCnpj;
    private EditText txtCep;
    private EditText txtUf;
    private EditText txtMunicipio;
    private Button btnCadastrarEmpresa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_empresa);

        txtRazaoSocial = (EditText) CadastroEmpresa.this.findViewById(R.id.txtRazaoSocial);
        txtNomeFantasia = (EditText) CadastroEmpresa.this.findViewById(R.id.txtNomeFantasia);
        txtCnpj = (EditText) CadastroEmpresa.this.findViewById(R.id.txtCnpj);
        txtCep = (EditText) CadastroEmpresa.this.findViewById(R.id.txtCep);
        txtUf = (EditText) CadastroEmpresa.this.findViewById(R.id.txtUf);
        txtMunicipio = (EditText) CadastroEmpresa.this.findViewById(R.id.txtMunicipio);
        btnCadastrarEmpresa = (Button) findViewById(R.id.btnCadastrarEmpresa);
    }

    public Empresa recuperaCampos() {
        Empresa empresa = new Empresa();
        empresa.setRazao_social(txtRazaoSocial.getText().toString());
        empresa.setNome_fantasia(txtNomeFantasia.getText().toString());
        empresa.setCnpj(txtCnpj.getText().toString());
        empresa.setCep(txtCep.getText().toString());
        empresa.setUf(txtUf.getText().toString());
        empresa.setMunicipio(txtMunicipio.getText().toString());
        return empresa;
    }

    public void cadastroEmpresa (View view){ // View V serve para ação de CLICK
        CadastroEmpresaDAO cadastroEmpresaDAO = new CadastroEmpresaDAO(this);
        if (cadastroEmpresaDAO.insert(recuperaCampos())) {
            this.avancar(view);
        }
      //  this.limparCampos();

    }

    public void buscaEmpresa(View view) {
        Intent abreListaEmpresas = new Intent(this, ListarEmpresas.class);
        startActivity(abreListaEmpresas);
    }

    //private void limparCampos(){
      //  txtRazaoSocial.setText(null);
        //txtCnpj.setText(null);
    //}

    public void avancar(View view){
        Intent abreConfirmacaoEmpresa = new Intent(this, ConfirmaCadastro.class);
        startActivity(abreConfirmacaoEmpresa);
    }

}
