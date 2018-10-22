package qualosabor.com.br.qualosabor;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import qualosabor.com.br.qualosabor.database.DataBase;

public class MainActivity extends AppCompatActivity {

    private Button btnEmpresa;
    private Button btnUsuario;

    private DataBase dataBase;
    private SQLiteDatabase conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEmpresa = (Button) findViewById(R.id.btnEmpresa);
        btnUsuario = (Button) findViewById(R.id.btnUsuario);

        dataBase = new DataBase(this);
        conn = dataBase.getWritableDatabase();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Qual é o Sabor?");



    }


    public void mostrar(View view){
        if(view.equals(btnEmpresa)) {
            Intent abreLoginEmpresa = new Intent(this, LoginEmpresa.class);
            startActivity(abreLoginEmpresa);
        } if(view.equals(btnUsuario)) {
            Intent abreLoginUsuario = new Intent(this, LoginUsuario.class);
            startActivity(abreLoginUsuario);
        }
    }
}
