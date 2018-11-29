package qualosabor.com.br.qualosabor.controller;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import qualosabor.com.br.qualosabor.MainActivity;
import qualosabor.com.br.qualosabor.R;

public class ConfirmaCadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma_cadastro);
    }

    public void avancar(View view){
        Toast.makeText(this,"Empresa confirmada com sucesso!", Toast.LENGTH_SHORT).show();
        Intent abreCadastroUsuario = new Intent(this, CadastroUsuario.class);
        startActivity(abreCadastroUsuario);
    }
}
