package qualosabor.com.br.qualosabor.controller;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import qualosabor.com.br.qualosabor.R;
import qualosabor.com.br.qualosabor.dao.CadastroSaborDAO;
import qualosabor.com.br.qualosabor.models.Sabor;

public class QRCode extends AppCompatActivity {

    private EditText txtQRcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        txtQRcode = (EditText) QRCode.this.findViewById(R.id.txtQRcode);
    }

    public void gerarQRCode(View view){ // View V serve para ação de CLICK
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://chart.googleapis.com/chart?chs=500x500&cht=qr&chl=Mesa:"+txtQRcode.getText().toString()+"Empresa:"));
        startActivity(intent);
        Toast.makeText(this, "QR Code gerado com sucesso!", Toast.LENGTH_SHORT).show();
    }

    public void voltar(View view){
        Intent abreMenuEmpresa = new Intent(this, MenuEmpresa.class);
        startActivity(abreMenuEmpresa);
    }
}
