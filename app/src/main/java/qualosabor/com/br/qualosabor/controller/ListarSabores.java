package qualosabor.com.br.qualosabor.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.lang.reflect.Array;
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

//        ArrayAdapter<Sabor> adapter = new ArrayAdapter<Sabor>(this, android.R.layout.simple_list_item_1, adiconaSabor());

        List<Sabor> sabores = Sabor.listAll(Sabor.class);
//        ArrayAdapter adapter = new SaborAdapter(this, sabores);
        ArrayAdapter<Sabor> adapter;
        adapter = new ArrayAdapter<Sabor>(this, android.R.layout.simple_list_item_1, sabores);
        listview.setAdapter(adapter);
    }

    private ArrayList<Sabor> adiconaSabor() {
        ArrayList<Sabor> sabores = new ArrayList<>();
        Sabor s = new Sabor("Calabreza", "calabreza, queijo, oregano", null, 1);
        sabores.add(s);
        Sabor s1 = new Sabor("ASDDSSSS", "calabreza, queijo, oregano", null, 1);
        sabores.add(s1);
        return sabores;
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
