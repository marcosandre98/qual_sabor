package qualosabor.com.br.qualosabor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import qualosabor.com.br.qualosabor.adapter.EmpresaAdapter;
import qualosabor.com.br.qualosabor.dominioCRUD.entidades.Empresa;

public class ListarSabores extends AppCompatActivity {

    private ListView listaSaboresCadastrados;
    private ArrayList<Empresa> listarSaboresCadastrados = new ArrayList<>();
    private ArrayAdapter adapterLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_sabores);

        listaSaboresCadastrados = (ListView) findViewById(R.id.listSaboresCadastrados);

        this.buscaSaborCadastrado();
    }

    public void buscaSaborCadastrado(){
//        CadastroEmpresaDAO cadastroEmpresaDAO = new CadastroEmpresaDAO(getApplicationContext());
  //      listarSaboresCadastrados = cadastroEmpresaDAO.buscaEmpresas(this);
        adapterLista = new EmpresaAdapter(this, listarSaboresCadastrados);
        listaSaboresCadastrados.setAdapter(adapterLista);
    }
}
