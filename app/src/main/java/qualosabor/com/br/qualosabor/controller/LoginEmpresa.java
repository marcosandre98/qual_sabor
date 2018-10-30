package qualosabor.com.br.qualosabor.controller;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import qualosabor.com.br.qualosabor.R;

public class LoginEmpresa extends AppCompatActivity {

    private EditText txtLogin;
    private EditText txtSenha;
    private Button btnLogin;
    private Button btnRegistroEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_empresa);

        txtLogin = (EditText) LoginEmpresa.this.findViewById(R.id.txtLogin);
        txtSenha = (EditText) LoginEmpresa.this.findViewById(R.id.txtSenha);
        btnLogin = (Button) LoginEmpresa.this.findViewById(R.id.btnLogin);
        btnRegistroEmpresa = (Button) LoginEmpresa.this.findViewById(R.id.btnRegistro);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Login Empresa");
    }

    public void abrirCadastro(View view){
        Intent abreCadEmpresa = new Intent(this, CadastroEmpresa.class);
        startActivity(abreCadEmpresa);
    }

    public void abrirEmpresa(View view){
        Intent abreMenuEmpresa = new Intent(this, MenuEmpresa.class);
        startActivity(abreMenuEmpresa);
    }

}
