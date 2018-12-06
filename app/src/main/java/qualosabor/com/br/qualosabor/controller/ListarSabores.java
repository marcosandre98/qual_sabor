package qualosabor.com.br.qualosabor.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import qualosabor.com.br.qualosabor.R;
import qualosabor.com.br.qualosabor.adapter.SaborAdapter;
import qualosabor.com.br.qualosabor.models.Sabor;

public class ListarSabores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_sabores);

        ListView listview = (ListView) findViewById(R.id.listSaboresCadastrados);

        List<Sabor> sabores = Sabor.listAll(Sabor.class);

        ArrayAdapter<Sabor> adapter;
        adapter = new ArrayAdapter<Sabor>(this, android.R.layout.simple_list_item_1, sabores);
        listview.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Intent voltaMenu = new Intent(this, MenuEmpresa.class);
        startActivity(voltaMenu);
    }

    public void adicionarSabor(View view) {
        Intent abreAdicionaSabor = new Intent(this, CadastroSabor.class);
        startActivity(abreAdicionaSabor);
    }
}
