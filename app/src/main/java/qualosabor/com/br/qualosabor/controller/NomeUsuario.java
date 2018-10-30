package qualosabor.com.br.qualosabor.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import qualosabor.com.br.qualosabor.R;

public class NomeUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nome_usuario);
    }

    public void avancar(View view){
        Intent abreSabores = new Intent(this, EscolherSabores.class);
        startActivity(abreSabores);
    }
}
