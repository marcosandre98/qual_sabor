package qualosabor.com.br.qualosabor.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

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

        final ListView listview = (ListView) findViewById(R.id.listSaboresCadastrados);
        List<Sabor> sabores = Sabor.listAll(Sabor.class);
        ArrayAdapter adapter = new SaborAdapter(this, this.arrayListSabor(sabores));
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int posicao, long id) {
                 final Sabor sabor = (Sabor) adapter.getAdapter().getItem(posicao);
                final CharSequence[] itens = {getString(R.string.alterar), getString(R.string.excluir), getString(R.string.cancelar)};
                AlertDialog.Builder opcoes = new AlertDialog.Builder(ListarSabores.this);
                opcoes.setItems(itens, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String opcao = (String) itens[which];

                        if (opcao.equals(getString(R.string.alterar))) {
                            Toast.makeText(ListarSabores.this, "Alterou", Toast.LENGTH_LONG).show();
                        } else if (opcao.equals(getString(R.string.excluir))) {
                            mostrarSimNao(sabor);
                            //Toast.makeText(ListarSabores.this, "Excruriurrui", Toast.LENGTH_LONG).show();
                        } else if (opcao.equals(getString(R.string.cancelar))) {
                            dialog.cancel();
                        }
                    }
                });

                opcoes.setTitle(R.string.opcoes);
                AlertDialog alerta = opcoes.create();
                alerta.show();
            }
        });

    }
    private void mostrarSimNao(Sabor sabor){
        AlertDialog.Builder mensagens = new AlertDialog.Builder(ListarSabores.this);
        mensagens.setMessage(getString(R.string.confExcluir));
        mensagens.setPositiveButton(getString(R.string.sim), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        mensagens.setNegativeButton(getString(R.string.nao), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        mensagens.create().show();

    }

    private ArrayList<Sabor> arrayListSabor(List listSabores) {
        ArrayList<Sabor> arraySabores = new ArrayList<Sabor>(listSabores);
        return arraySabores;
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
