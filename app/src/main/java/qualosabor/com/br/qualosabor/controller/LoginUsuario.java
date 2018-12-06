package qualosabor.com.br.qualosabor.controller;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast; // Não remover, é para retornar as mensagens do leitor
import com.google.zxing.integration.android.IntentIntegrator; // Não remover, é utilizado para ler o QR CODE
import com.google.zxing.integration.android.IntentResult; // Não remover, é utilizado para ler o QR CODE

import qualosabor.com.br.qualosabor.R;

public class LoginUsuario extends AppCompatActivity {

    private ImageButton imgBtnCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_usuario);


        imgBtnCamera = (ImageButton) LoginUsuario.this.findViewById(R.id.imgBtnCamera);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Identificação de usuário");

        final Activity activity = this;

        imgBtnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents()== null){
                Toast.makeText(this, "Você cancelou a leitura!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                if (result.toString().contains("Empresa") && result.toString().contains("Mesa")){
                    Intent abreNomeUsuario = new Intent(this, NomeUsuario.class);
                    abreNomeUsuario.putExtra("NumeroMesa", result.getContents().toString());
                    startActivity(abreNomeUsuario);
                } else {
                    Toast.makeText(this, "QR Code inválido", Toast.LENGTH_LONG).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
