package qualosabor.com.br.qualosabor.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import qualosabor.com.br.qualosabor.R;
import qualosabor.com.br.qualosabor.models.Empresa;

public class ListarEmpresas extends AppCompatActivity {

    private ListView listaEmpresas;
    private ArrayList<Empresa> listarEmpresas = new ArrayList<>();
    private ArrayAdapter adapterLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_empresas);

        listaEmpresas = (ListView) findViewById(R.id.listEmpresas);

        this.buscaEmpresa();
    }

    public void buscaEmpresa(){
//            CadastroEmpresaDAO cadastroEmpresaDAO = new CadastroEmpresaDAO(getApplicationContext());
//            listarEmpresas = cadastroEmpresaDAO.buscaEmpresas(this);
//            adapterLista = new EmpresaAdapter(this, listarEmpresas);
//            listaEmpresas.setAdapter(adapterLista);
    }
}
