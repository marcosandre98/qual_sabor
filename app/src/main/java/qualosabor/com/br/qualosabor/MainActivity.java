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

    private DataBase dataBase;
    private SQLiteDatabase conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEmpresa = (Button) findViewById(R.id.btnEmpresa);

        dataBase = new DataBase(this);
        conn = dataBase.getWritableDatabase();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Tela Principal");



    }

    public void mostrar(View view){
        Intent abreLoginEmpresa = new Intent(this, LoginEmpresa.class);
        startActivity(abreLoginEmpresa);
    }
}
