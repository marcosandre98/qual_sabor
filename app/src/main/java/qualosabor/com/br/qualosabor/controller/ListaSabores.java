//package qualosabor.com.br.qualosabor.controller;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import qualosabor.com.br.qualosabor.R;
//import qualosabor.com.br.qualosabor.adapter.EmpresaAdapter;
//import qualosabor.com.br.qualosabor.adapter.SaborAdapter;
//import qualosabor.com.br.qualosabor.models.Empresa;
//import qualosabor.com.br.qualosabor.models.Sabor;
//
//public class ListarSabores extends AppCompatActivity {
//
//    private ListView listaSaboresCadastrados;
//    private ArrayList<Sabor> listarSaboresCadastrados = new ArrayList<>();
//    private ArrayAdapter adapterLista;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_lista_sabores);
//
//        listaSaboresCadastrados = (ListView) findViewById(R.id.listSaboresCadastrados);
//
//        this.buscaSaborCadastrado();
//    }
//
//    public void buscaSaborCadastrado() {
//        List<Sabor> sabores = Sabor.listAll(Sabor.class);
//        adapterLista = new SaborAdapter(this, sabores);
//        listaSaboresCadastrados.setAdapter(adapterLista);
//    }
//}

package qualosabor.com.br.qualosabor.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import qualosabor.com.br.qualosabor.R;
import qualosabor.com.br.qualosabor.adapter.SaborAdapter;
import qualosabor.com.br.qualosabor.models.Sabor;

public class ListaSabores extends AppCompatActivity {

    String[] dados = new String[] { "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread",
            "Honeycomb", "Ice Cream Sandwich", "Jelly Bean",
            "KitKat", "Lollipop", "Marshmallow", "Nougat" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_sabores);

        ListView listview = (ListView) findViewById(R.id.listview);

        List<Sabor> sabores = Sabor.listAll(Sabor.class);

        String dados = "";
        for (Sabor sabor : sabores) {
            if (dados.trim().isEmpty()) {
                dados = sabor.getNomeSabor() + "-" + sabor.getIngredientes();
            } else {
                dados = sabor.getNomeSabor() + "-" + sabor.getIngredientes();
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Collections.singletonList(dados));
        listview.setAdapter(adapter);
    }

//    public void buscaSaborCadastrado() {
//        List<Sabor> sabores = Sabor.listAll(Sabor.class);
//        adapterLista = new SaborAdapter(this, sabores);
//        listaSaboresCadastrados.setAdapter(adapterLista);
//    }
}
