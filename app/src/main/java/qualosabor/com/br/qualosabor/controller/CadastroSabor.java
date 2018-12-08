package qualosabor.com.br.qualosabor.controller;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import qualosabor.com.br.qualosabor.R;
import qualosabor.com.br.qualosabor.dao.CadastroSaborDAO;
import qualosabor.com.br.qualosabor.dao.CadastroUsuarioDAO;
import qualosabor.com.br.qualosabor.models.Sabor;
import qualosabor.com.br.qualosabor.models.Usuario;

public class CadastroSabor extends AppCompatActivity {

    private EditText txtNomeSabor;
    private EditText txtIngre;
    private ImageView imagem;
    private Bitmap imageBitmap;
    private final int GALERIA_IMAGENS = 1;
    private  final int PERMISSAO_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_sabor);

        txtNomeSabor = (EditText) CadastroSabor.this.findViewById(R.id.txtNomeSabor);
        txtIngre = (EditText) CadastroSabor.this.findViewById(R.id.txtIngre);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSAO_REQUEST);
            }
        }

        imagem = (ImageView) findViewById(R.id.ivImagemSabor);
        Button galeria = (Button) findViewById(R.id.btnGaleria);
        galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, GALERIA_IMAGENS);
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Cadastrar Sabor");
    }

    @Override
    public void onBackPressed() {
        Intent voltaMenu = new Intent(this, ListarSabores.class);
        startActivity(voltaMenu);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == GALERIA_IMAGENS) {
            Uri selectedImage = data.getData();
            String [] filePath = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePath[0]);
            String picturePath = c.getString(columnIndex);
            c.close();
            Bitmap imagemGaleria = (BitmapFactory.decodeFile(picturePath));
            imagem.setImageBitmap(imagemGaleria);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == PERMISSAO_REQUEST) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            } else {

            }
            return;
        }
    }

    public void cadastrarSabor(View view) { // View V serve para ação de CLICK

        Bitmap bitmap = ((BitmapDrawable)imagem.getDrawable()).getBitmap();
        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,saida);
        byte[] imagemBytes = saida.toByteArray();

        Sabor sabor = new Sabor(txtNomeSabor.getText().toString(), txtIngre.getText().toString(), imagemBytes, 1);
        CadastroSaborDAO cadastroSaborDAO = new CadastroSaborDAO();

        String erros_sabor = validarSabor();

        if (erros_sabor.equals("")) {
            if (cadastroSaborDAO.insert(sabor)) {
                Toast.makeText(this, "Sabor cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                this.voltar(view);
            } else {
                Toast.makeText(this, "Erro ao inserir sabor", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(CadastroSabor.this, "Verifique os erros: "+erros_sabor, Toast.LENGTH_SHORT).show();
        }

    }

    public void voltar(View view){
        Intent abreSabores = new Intent(this, ListarSabores.class);
        startActivity(abreSabores);
    }

    public String validarSabor() {
        String errosSabor = "";

        if(txtNomeSabor.getText().toString().equals("")){
            errosSabor = "Os campos marcados em vermelho estão sem informação ou incorretos";
            txtNomeSabor.setError("Esse campo é obrigatório");
        }
        if(txtIngre.getText().toString().equals("")){
            errosSabor = "Os campos marcados em vermelho estão sem informação ou incorretos";
            txtIngre.setError("Esse campo é obrigatório");
        }

        return errosSabor;
    }

}
