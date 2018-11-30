package qualosabor.com.br.qualosabor.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import qualosabor.com.br.qualosabor.R;
import qualosabor.com.br.qualosabor.models.CodigoVerificacao;

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

		//List<CodigoVerificacao> codigo = CodigoVerificacao.find(CodigoVerificacao.class, "codigo = ?", codigoConfirmacao);
		//int codigoBanco = Integer.parseInt(String.valueOf(codigo));
		//int codigoPassado = Integer.parseInt(codigoConfirmacao);

		/*if (codigoPassado == codigoBanco) {
			return true;
		} else {
			return false;
		}*/
		return true;
	}
}
