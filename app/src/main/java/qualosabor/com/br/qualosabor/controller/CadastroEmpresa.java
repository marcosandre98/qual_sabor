package qualosabor.com.br.qualosabor.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import qualosabor.com.br.qualosabor.R;
import qualosabor.com.br.qualosabor.dao.CadastroEmpresaDAO;
import qualosabor.com.br.qualosabor.models.Empresa;

public class CadastroEmpresa extends AppCompatActivity {

    private EditText txtRazaoSocial;
    private EditText txtNomeFantasia;
    private EditText txtCnpj;
    private EditText txtCep;
    private EditText txtUf;
    private EditText txtMunicipio;
    private EditText txtEmail;
    private Button btnCadastrarEmpresa;
    public Long idEmpresa;

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
        txtEmail = (EditText) CadastroEmpresa.this.findViewById(R.id.txtEmail);
        btnCadastrarEmpresa = (Button) findViewById(R.id.btnCadastrarEmpresa);
    }

//    public Empresa recuperaCampos(Empresa) {
//        Empresa empresa = new Empresa();
//        empresa.setRazaoSocial(txtRazaoSocial.getText().toString());
//        empresa.setNomeFantasia(txtNomeFantasia.getText().toString());
//        empresa.setCnpj(txtCnpj.getText().toString());
//        empresa.setCep(txtCep.getText().toString());
//        empresa.setUf(txtUf.getText().toString());
//        empresa.setMunicipio(txtMunicipio.getText().toString());
//        return empresa;
//    }

    public void cadastrarEmpresa(View view) {
        Empresa empresa = new Empresa(txtRazaoSocial.getText().toString(), txtNomeFantasia.getText().toString(), txtCnpj.getText().toString(),
                txtCep.getText().toString(), txtUf.getText().toString(), txtMunicipio.getText().toString(), txtEmail.getText().toString());

        CadastroEmpresaDAO cadastroEmpresaDAO = new CadastroEmpresaDAO();
        if (cadastroEmpresaDAO.insert(empresa)) {
            Toast.makeText(this,"Empresa inserida com sucesso!", Toast.LENGTH_SHORT).show();
            this.idEmpresa = empresa.getId();
            this.avancar(view);
            Mail m = new Mail();
            m.enviarEmail();
        } else {
            Toast.makeText(this,"Erro ao inserir a empresa!", Toast.LENGTH_SHORT).show();
        }
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
