package qualosabor.com.br.qualosabor.controller;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import qualosabor.com.br.qualosabor.MainActivity;
import qualosabor.com.br.qualosabor.R;

public class ConfirmaCadastro extends AppCompatActivity {

	private EditText txtCodConfirmacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma_cadastro);
		
		txtCodConfirmacao = (EditText) ConfirmaCadastro.this.findViewById(R.id.txtCodConfirmacao);
    }

    public void avancar(View view) {
		if ( this.verificaCodigo(txtCodConfirmacao.getText().toString()) ) {
			Intent abreCadastroUsuario = new Intent(this, CadastroUsuario.class);
			startActivity(abreCadastroUsuario);
		} else {
			Toast.makeText(this,"Código de verificação da empresa está incorreto! Tente novamente!", Toast.LENGTH_SHORT).show();
		}
    }
	
	private boolean verificaCodigo(String codigoConfirmacao) {
		if (codigoConfirmacao.equals("ADF123")) {
			return true;
		} else {
			return false;
		}
	}
}
