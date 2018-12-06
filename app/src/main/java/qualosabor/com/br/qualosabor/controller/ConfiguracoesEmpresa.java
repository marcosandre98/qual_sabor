package qualosabor.com.br.qualosabor.controller;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

import qualosabor.com.br.qualosabor.R;

public class ConfiguracoesEmpresa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes_empresa);
    }

    @Override
    public void onBackPressed() {
        Intent voltaMenu = new Intent(this, MenuEmpresa.class);
        startActivity(voltaMenu);
    }

    public void gerar(View v){
        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();
            if (sd.canWrite()) {
                String currentDBPath = "data//" + "qualosabor.com.br.qualosabor"
                        + "//databases//" + "qualsabor.db";
                String backupDBPath = "Download/backupqualsabor.db";
                File currentDB = new File(data, currentDBPath);

                File backupDB = new File(sd, backupDBPath);

                FileChannel src = new FileInputStream(currentDB).getChannel();
                Log.i("carollo","exportando o banco de dados");
                FileChannel dst = new FileOutputStream(backupDB).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();
                Log.i("carollo", "Realizado com sucesso");
                Toast.makeText(this, "Backup realizado com sucesso!", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Log.i("carollo","Erro ao exportar : " + e.getMessage() );
            Toast.makeText(this, "Falha ao realizar backup", Toast.LENGTH_SHORT).show();
        }
    }
}
