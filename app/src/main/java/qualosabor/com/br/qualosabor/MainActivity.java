package qualosabor.com.br.qualosabor;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import qualosabor.com.br.qualosabor.controller.LoginEmpresa;
import qualosabor.com.br.qualosabor.controller.LoginUsuario;

public class MainActivity extends AppCompatActivity {

    private Button btnEmpresa;
    private Button btnUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEmpresa = (Button) findViewById(R.id.btnEmpresa);
        btnUsuario = (Button) findViewById(R.id.btnUsuario);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Qual é o Sabor?");
    }

    public void mostrar(View view){
        if(!(verificaConexao())){
            Toast.makeText(this, "Erro, você não está conectado", Toast.LENGTH_SHORT).show();
        }else{
            if (view.equals(btnEmpresa)) {
                Intent abreLoginEmpresa = new Intent(this, LoginEmpresa.class);
                startActivity(abreLoginEmpresa);
            }
            if (view.equals(btnUsuario)) {
                Intent abreLoginUsuario = new Intent(this, LoginUsuario.class);
                startActivity(abreLoginUsuario);
            }
        }
    }

    public  boolean verificaConexao() {
        boolean conectado;
        ConnectivityManager conectivtyManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conectivtyManager.getActiveNetworkInfo() != null
                && conectivtyManager.getActiveNetworkInfo().isAvailable()
                && conectivtyManager.getActiveNetworkInfo().isConnected()) {
            conectado = true;
        } else {
            conectado = false;
        }
        return conectado;
    }
}
