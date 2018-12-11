package qualosabor.com.br.qualosabor.controller;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import qualosabor.com.br.qualosabor.R;
import qualosabor.com.br.qualosabor.dao.CadastroClienteDAO;
import qualosabor.com.br.qualosabor.dao.CadastroSaborDAO;
import qualosabor.com.br.qualosabor.models.Cliente;
import qualosabor.com.br.qualosabor.models.Sabor;


public class NomeUsuario extends AppCompatActivity {

    CallbackManager callbackManager;
    private EditText txtNomeCliente;
    String mesa = "";
    private LoginButton login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nome_usuario);

        txtNomeCliente = (   EditText) NomeUsuario.this.findViewById(R.id.txtCodNomeUsu);

        Intent it = getIntent();
        mesa = it.getStringExtra("NumeroMesa");
        TextView label = findViewById(R.id.txtNomeUsu);
        label.setText("Código scaneado com sucesso na Mesa "+mesa+"! Por favor, insira seu nome:");

        callbackManager = CallbackManager.Factory.create();

        LoginButton loginButton = (LoginButton)findViewById(R.id.login_button);
        loginButton.setReadPermissions("email", "public_profile"); //, "user_friends"

        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "qualosabor.com.br.qualosabor",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException error) {
            }
        });

        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(getApplicationContext(),  "Logado com sucesso", Toast.LENGTH_SHORT).show();
                executeGraphRequest(loginResult.getAccessToken().getUserId());
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(),  error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void executeGraphRequest(final String userId){
        GraphRequest request =new GraphRequest(AccessToken.getCurrentAccessToken(), userId, null, HttpMethod.GET, new GraphRequest.Callback() {
            @Override
            public void onCompleted(GraphResponse response) {
                Log.i("FACEBOOK", response.getJSONObject().toString());
                Log.i("FACEBOOK", Profile.getCurrentProfile().toString());
            }
        });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "name");
        request.setParameters(parameters);
        request.executeAsync();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        Intent voltaMenu = new Intent(this, LoginUsuario.class);
        startActivity(voltaMenu);
    }

    public void cadastroCliente (View view){ // View V serve para ação de CLICK
        Cliente cliente = new Cliente(txtNomeCliente.getText().toString(),1);
        CadastroClienteDAO cadastroClienteDAO = new CadastroClienteDAO();

        String erros_usuario = validarUsuario();
        if (erros_usuario.equals("")) {
            int idCliente = cadastroClienteDAO.insert(cliente);
            if (idCliente != 0) {
                Toast toast = Toast.makeText(this, "Cliente cadastrado com sucesso", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 520);
                toast.show();
                this.avancar(view, String.valueOf(idCliente), txtNomeCliente.getText().toString());
            } else {
                Toast.makeText(this, "Erro ao cadastrar o cliente", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(NomeUsuario.this, "Verifique os erros: "+erros_usuario, Toast.LENGTH_SHORT).show();
        }
    }

    public void avancar(View view, String idCliente, String nomeCli){
        Intent abreSabores = new Intent(this, EscolherSabores.class);
        abreSabores.putExtra("numeroMesa", mesa);
        abreSabores.putExtra("idCliente", idCliente);
        abreSabores.putExtra("NomeCliente", nomeCli);
        startActivity(abreSabores);
    }

    public String validarUsuario(){
        String errosUsuario = "";

        if(txtNomeCliente.getText().toString().equals("")){
            errosUsuario = "Os campos marcados em vermelho estão sem informação ou incorretos";
            txtNomeCliente.setError("Esse campo é obrigatório");
        }

        return errosUsuario;
    }

}
