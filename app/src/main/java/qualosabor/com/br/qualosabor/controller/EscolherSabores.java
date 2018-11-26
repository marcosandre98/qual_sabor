package qualosabor.com.br.qualosabor.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import qualosabor.com.br.qualosabor.R;
import qualosabor.com.br.qualosabor.adapter.EmpresaAdapter;
import qualosabor.com.br.qualosabor.dao.CadastroPedidoDAO;
import qualosabor.com.br.qualosabor.models.Empresa;
import qualosabor.com.br.qualosabor.models.Pedido;

public class EscolherSabores extends AppCompatActivity {

    private ListView listaSabores;
    private ArrayList<Empresa> listarSabores = new ArrayList<>();
    private ArrayAdapter adapterLista;
    private String nomeAux = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_sabores);

        listaSabores = (ListView) findViewById(R.id.listSabores);

        Intent it = getIntent();
        String cliente = it.getStringExtra("NomeCliente");
        TextView label = findViewById(R.id.txtBuscaSabor);
        label.setText("Bem Vindo, "+cliente+"! Escolha o(s) sabor(es) que deseja:");
        nomeAux = cliente;

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
        abrePedido.putExtra("NomeCliente", nomeAux);
        startActivity(abrePedido);
    }
}
