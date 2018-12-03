package qualosabor.com.br.qualosabor.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import qualosabor.com.br.qualosabor.R;
import qualosabor.com.br.qualosabor.models.Pedido;

public class ListaSaboresMaisPedidos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_sabores_mais_pedidos);

        ListView listview = (ListView) findViewById(R.id.listaSaboresMaisPedidos);

        List<Pedido> pedidos = Pedido.listAll(Pedido.class);

        ArrayAdapter<Pedido> adapter;
        adapter = new ArrayAdapter<Pedido>(this, android.R.layout.simple_list_item_1, pedidos);
        listview.setAdapter(adapter);
    }

}
