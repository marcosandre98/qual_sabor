package qualosabor.com.br.qualosabor.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import qualosabor.com.br.qualosabor.R;

public class CadastroSabor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_sabor);
    }

    public void cadastroSabor (View view){ // View V serve para ação de CLICK
            this.voltar(view);
    }

    public void voltar(View view){
        Intent abreMenuEmpresa = new Intent(this, MenuEmpresa.class);
        startActivity(abreMenuEmpresa);
    }
}
