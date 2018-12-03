package qualosabor.com.br.qualosabor.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.view.Gravity;

import java.util.List;

import qualosabor.com.br.qualosabor.R;
import qualosabor.com.br.qualosabor.models.Pedido;

public class MenuEmpresa extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_empresa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ListView listview = (ListView) findViewById(R.id.listaSabores);

        List<Pedido> pedidos = Pedido.listAll(Pedido.class);

        ArrayAdapter<Pedido> adapter;
        adapter = new ArrayAdapter<Pedido>(this, android.R.layout.simple_list_item_1, pedidos);
        listview.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.cad_sabor) {
            Intent abreCadastrarSabores = new Intent(this, CadastroSabor.class);
            startActivity(abreCadastrarSabores);
        } else if (id == R.id.list_sabor) {
            Intent abreListarSabores = new Intent(this, ListarSabores.class);
            startActivity(abreListarSabores);
        } else if (id == R.id.config_empresa) {
            Intent abreCadastraQRCode = new Intent(this, ConfiguracoesEmpresa.class);
            startActivity(abreCadastraQRCode);
        } else if (id == R.id.cadas_qrcode) {
            Intent abreCadastraQRCode = new Intent(this, QRCode.class);
            startActivity(abreCadastraQRCode);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void listarPedidos(View view) {
        Intent abrePedidos = new Intent(this, ListarPedidos.class);
        startActivity(abrePedidos);
    }

    public void listarSaboresMaisPedidos(View view) {
        Intent abreSaboresMaisPedidos = new Intent(this, ListaSaboresMaisPedidos.class);
        startActivity(abreSaboresMaisPedidos);
    }

    public void confirmarPedido(View view){
        Toast toast = Toast.makeText(this, "Pedidos Finalizados!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 520);
        toast.show();
    }
}
