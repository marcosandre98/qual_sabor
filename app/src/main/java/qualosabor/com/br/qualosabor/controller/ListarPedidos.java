package qualosabor.com.br.qualosabor.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import qualosabor.com.br.qualosabor.R;
import qualosabor.com.br.qualosabor.models.Pedido;
import qualosabor.com.br.qualosabor.models.Sabor;

public class ListarPedidos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_pedidos);

        ListView listview = (ListView) findViewById(R.id.listPedidos);

        List<Pedido> pedidos = Pedido.listAll(Pedido.class);

        ArrayAdapter<Pedido> adapter;
        adapter = new ArrayAdapter<Pedido>(this, android.R.layout.simple_list_item_1, pedidos);
        listview.setAdapter(adapter);
    }

}