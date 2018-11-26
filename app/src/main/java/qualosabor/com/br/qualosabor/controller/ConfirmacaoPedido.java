package qualosabor.com.br.qualosabor.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import qualosabor.com.br.qualosabor.R;
import qualosabor.com.br.qualosabor.dao.CadastroPedidoDAO;
import qualosabor.com.br.qualosabor.models.Pedido;

public class ConfirmacaoPedido extends AppCompatActivity {

    private String nomeAux = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao_pedido);
        Intent it = getIntent();
        String cliente = it.getStringExtra("NomeCliente");
        nomeAux = cliente;
    }

    public void retornar(View view){
        Intent abreSabores = new Intent(this, EscolherSabores.class);
        abreSabores.putExtra("NomeCliente", nomeAux);
        startActivity(abreSabores);
    }
}
