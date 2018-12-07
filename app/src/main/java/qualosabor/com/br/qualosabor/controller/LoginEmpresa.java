package qualosabor.com.br.qualosabor.controller;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.orm.SugarRecord;

import java.util.List;

import qualosabor.com.br.qualosabor.MainActivity;
import qualosabor.com.br.qualosabor.R;
import qualosabor.com.br.qualosabor.models.Usuario;

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

    @Override
    public void onBackPressed() {
        Intent voltaMenu = new Intent(this, MainActivity.class);
        startActivity(voltaMenu);
    }

    public void abrirCadastro(View view){
        Intent abreCadEmpresa = new Intent(this, CadastroEmpresa.class);
        startActivity(abreCadEmpresa);
    }

    public void abrirEmpresa(View view) {
        //verifica se o usuário existe
        String errosLogin = validarLogin();

        if(errosLogin.equals("")) {
            if (validaLogin()) {
                Intent abreMenuEmpresa = new Intent(this, MenuEmpresa.class);
                startActivity(abreMenuEmpresa);
            } else {
                Toast.makeText(this, "Erro! Usuário ou senha incorretos", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(LoginEmpresa.this, "Verifique os erros: "+errosLogin, Toast.LENGTH_SHORT).show();
        }
    }

    public boolean validaLogin() {
        List<Usuario> usuarios = Usuario.find(Usuario.class, "login_usuario = ?", txtLogin.getText().toString());
        if (!usuarios.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public String validarLogin(){
        String erros_login = "";

        if(txtLogin.getText().toString().equals("")){
            erros_login = "Os campos marcados em vermelho estão sem informação ou incorretos";
            txtLogin.setError("Esse campo é obrigatório");
        }
        if(txtSenha.getText().toString().equals("")){
            erros_login = "Os campos marcados em vermelho estão sem informação ou incorretos";
            txtSenha.setError("Esse campo é obrigatório");
        }

        return erros_login;
    }
}
