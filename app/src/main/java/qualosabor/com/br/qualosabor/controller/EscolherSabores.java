package qualosabor.com.br.qualosabor.controller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import qualosabor.com.br.qualosabor.R;
import qualosabor.com.br.qualosabor.adapter.EmpresaAdapter;
import qualosabor.com.br.qualosabor.adapter.SaborAdapter;
import qualosabor.com.br.qualosabor.dao.CadastroEmpresaDAO;
import qualosabor.com.br.qualosabor.dao.CadastroPedidoDAO;
import qualosabor.com.br.qualosabor.models.Empresa;
import qualosabor.com.br.qualosabor.models.Pedido;
import qualosabor.com.br.qualosabor.models.Sabor;

public class EscolherSabores extends AppCompatActivity {

    private String nomeAux = "";
    String idCliente = "";
    String mesa = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_sabores);

        Intent it = getIntent();
        String cliente = it.getStringExtra("NomeCliente");
        idCliente = it.getStringExtra("idCliente");
        mesa = it.getStringExtra("numeroMesa");
        TextView label = findViewById(R.id.txtBuscaSabor);
        label.setText("Bem Vindo, " + cliente + "! Escolha o(s) sabor(es) que deseja:");
        nomeAux = cliente;

        ListView listview = (ListView) findViewById(R.id.listEscolherSaboresCliente);
        List<Sabor> sabores = Sabor.listAll(Sabor.class);
        ArrayAdapter adapter = new SaborAdapter(this, this.arrayListSabor(sabores));
        listview.setAdapter(adapter);

        this.buscaSabor();
    }

    private ArrayList<Sabor> arrayListSabor(List listSabores) {
        ArrayList<Sabor> arraySabores = new ArrayList<Sabor>(listSabores);
        return arraySabores;
    }

    @Override
    public void onBackPressed() {
        confimarSaida();
    }

    public void buscaSabor(){
//        CadastroEmpresaDAO cadastroEmpresaDAO = new CadastroEmpresaDAO(getApplicationContext());
  //      listarSabores = cadastroEmpresaDAO.buscaEmpresas(this);
//        adapterLista = new EmpresaAdapter(this, listarSabores);
//        listaSabores.setAdapter(adapterLista);
    }

    public void avancar(View view) {
        Pedido pedido = new Pedido(Integer.parseInt(mesa), 8, Integer.parseInt(idCliente), 1, 1);
        CadastroPedidoDAO cadastroPedidoDAO = new CadastroPedidoDAO();
        if (cadastroPedidoDAO.insert(pedido)) {
            Intent abrePedido = new Intent(this, ConfirmacaoPedido.class);
            abrePedido.putExtra("NomeCliente", nomeAux);
            startActivity(abrePedido);
            Toast.makeText(this, "Pedido enviado com sucesso", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Erro ao fazer o pedido! Tente novamente!", Toast.LENGTH_SHORT).show();
        }
    }

    private void confimarSaida() {
        AlertDialog alerta;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ALERTA");
        builder.setMessage("Você realmente deseja sair?");

        builder.setPositiveButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });

        builder.setNegativeButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                voltarInicio();
            }
        });

        alerta = builder.create();
        alerta.show();
    }

    public void voltarInicio(){
        Intent voltaLogin = new Intent(this, LoginUsuario.class);
        startActivity(voltaLogin);
    }
}
