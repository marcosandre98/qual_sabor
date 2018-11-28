package qualosabor.com.br.qualosabor.controller;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.Arrays;

import qualosabor.com.br.qualosabor.R;
import qualosabor.com.br.qualosabor.dao.CadastroClienteDAO;
import qualosabor.com.br.qualosabor.dao.CadastroSaborDAO;
import qualosabor.com.br.qualosabor.models.Cliente;
import qualosabor.com.br.qualosabor.models.Sabor;


public class NomeUsuario extends AppCompatActivity {

    CallbackManager callbackManager;
    private EditText txtNomeCliente;
    private Button login_button;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nome_usuario);

        txtNomeCliente = (EditText) NomeUsuario.this.findViewById(R.id.txtCodNomeUsu);

        Intent it = getIntent();
        String mesa = it.getStringExtra("NumeroMesa");
        TextView label = findViewById(R.id.txtNomeUsu);
        label.setText("Código scaneado com sucesso na Mesa "+mesa+"! Por favor, insira seu nome:");
        callbackManager = CallbackManager.Factory.create();

        LoginButton loginButton = (LoginButton)findViewById(R.id.login_button);
        //loginButton.setFragment(this);

        callbackManager = CallbackManager.Factory.create();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException error) {

            }
            
        });
    }

    public void cadastroCliente (View view){ // View V serve para ação de CLICK
        CadastroEmpresa c = new CadastroEmpresa();
        Cliente cliente = new Cliente(txtNomeCliente.getText().toString(),1);
        Log.i("teste", "Cliente" + c.idEmpresa + " Inserido com sucesso!");
        CadastroClienteDAO cadastroClienteDAO = new CadastroClienteDAO();
        if (cadastroClienteDAO.insert(cliente)) {
            Toast.makeText(this, "Cliente cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            this.avancar(view,txtNomeCliente.getText().toString());
        }else{
            Toast.makeText(this, "Erro ao cadastrar o cliente!", Toast.LENGTH_SHORT).show();
        }
    }

    public void avancar(View view, String nomeCli){
        Intent abreSabores = new Intent(this, EscolherSabores.class);
        abreSabores.putExtra("NomeCliente", nomeCli);
        startActivity(abreSabores);
    }
}
