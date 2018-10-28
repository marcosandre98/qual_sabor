package qualosabor.com.br.qualosabor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuEmpresa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_empresa);
    }

    public void avancarCadastrar(View view){
        Intent abreConfirmacaoEmpresa = new Intent(this, CadastrarSabores.class);
        startActivity(abreConfirmacaoEmpresa);
    }

    public void avancarListar(View view){
        Intent abreConfirmacaoEmpresa = new Intent(this, ListarSabores.class);
        startActivity(abreConfirmacaoEmpresa);
    }
}
