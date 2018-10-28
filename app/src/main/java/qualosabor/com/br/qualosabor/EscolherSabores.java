package qualosabor.com.br.qualosabor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

import qualosabor.com.br.qualosabor.adapter.EmpresaAdapter;
import qualosabor.com.br.qualosabor.dominioCRUD.entidades.Empresa;

public class EscolherSabores extends AppCompatActivity {

    private ListView listaSabores;
    private ArrayList<Empresa> listarSabores = new ArrayList<>();
    private ArrayAdapter adapterLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_sabores);

        listaSabores = (ListView) findViewById(R.id.listSabores);

        this.buscaSabor();
    }

    public void buscaSabor(){
//        CadastroEmpresaDAO cadastroEmpresaDAO = new CadastroEmpresaDAO(getApplicationContext());
  //      listarSabores = cadastroEmpresaDAO.buscaEmpresas(this);
        adapterLista = new EmpresaAdapter(this, listarSabores);
        listaSabores.setAdapter(adapterLista);
    }

    public void avancar(View view){
        Intent abrePedido = new Intent(this, ConfirmacaoPedido.class);
        startActivity(abrePedido);
    }
}
