package qualosabor.com.br.qualosabor.controller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;

import com.creativityapps.gmailbackgroundlibrary.BackgroundMail;

import qualosabor.com.br.qualosabor.R;
import qualosabor.com.br.qualosabor.dao.CadastroEmpresaDAO;
import qualosabor.com.br.qualosabor.dao.GravaCodigoDAO;
import qualosabor.com.br.qualosabor.models.CodigoVerificacao;
import qualosabor.com.br.qualosabor.models.Empresa;

public class CadastroEmpresa extends AppCompatActivity {

    private EditText txtRazaoSocial;
    private EditText txtNomeFantasia;
    private EditText txtCnpj;
    private EditText txtCep;
    private EditText txtUf;
    private EditText txtMunicipio;
    private EditText txtEmail;
    private Button btnCadastrarEmpresa;
    public Long idEmpresa;
    int number;
    Random myRandom = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_empresa);

        txtRazaoSocial = (EditText) CadastroEmpresa.this.findViewById(R.id.txtRazaoSocial);
        txtNomeFantasia = (EditText) CadastroEmpresa.this.findViewById(R.id.txtNomeFantasia);
        txtCnpj = (EditText) CadastroEmpresa.this.findViewById(R.id.txtCnpj);
        txtCep = (EditText) CadastroEmpresa.this.findViewById(R.id.txtCep);
        txtUf = (EditText) CadastroEmpresa.this.findViewById(R.id.txtUf);
        txtMunicipio = (EditText) CadastroEmpresa.this.findViewById(R.id.txtMunicipio);
        txtEmail = (EditText) CadastroEmpresa.this.findViewById(R.id.txtEmail);
        btnCadastrarEmpresa = (Button) findViewById(R.id.btnCadastrarEmpresa);
    }

    @Override
    public void onBackPressed() {
        confimarSaida();
    }

    private void confimarSaida() {
        AlertDialog alerta;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ALERTA");
        builder.setMessage("Você realmente deseja cancelar o cadastro?");

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
        Intent voltaLogin = new Intent(this, LoginEmpresa.class);
        startActivity(voltaLogin);
    }

//    public Empresa recuperaCampos(Empresa) {
//        Empresa empresa = new Empresa();
//        empresa.setRazaoSocial(txtRazaoSocial.getText().toString());
//        empresa.setNomeFantasia(txtNomeFantasia.getText().toString());
//        empresa.setCnpj(txtCnpj.getText().toString());
//        empresa.setCep(txtCep.getText().toString());
//        empresa.setUf(txtUf.getText().toString());
//        empresa.setMunicipio(txtMunicipio.getText().toString());
//        return empresa;
//    }

    public void cadastrarEmpresa(View view) {
        Empresa empresa = new Empresa(txtRazaoSocial.getText().toString(), txtNomeFantasia.getText().toString(), txtCnpj.getText().toString(),
                txtCep.getText().toString(), txtUf.getText().toString(), txtMunicipio.getText().toString(), txtEmail.getText().toString());

        String erros_totais = validar();

        if(erros_totais.equals("")) {
            CadastroEmpresaDAO cadastroEmpresaDAO = new CadastroEmpresaDAO();
            if (cadastroEmpresaDAO.insert(empresa)) {
                Toast.makeText(this, "Empresa cadastrada com sucesso", Toast.LENGTH_SHORT).show();
                this.idEmpresa = empresa.getId();
                this.avancar(view);
                this.enviaEmail(txtEmail.getText().toString()); //txtEmail.getText().toString()
            }
        }else {
            Toast.makeText(CadastroEmpresa.this, "Verifique os erros: "+erros_totais, Toast.LENGTH_SHORT).show();
        }
    }

    //private void limparCampos(){
      //  txtRazaoSocial.setText(null);
        //txtCnpj.setText(null);
    //}

    public void avancar(View view){
        Intent abreConfirmacaoEmpresa = new Intent(this, ConfirmaCadastro.class);
        startActivity(abreConfirmacaoEmpresa);
    }

    public void enviaEmail(String dest) {

        number =  myRandom.nextInt(152) * myRandom.nextInt(123) * myRandom.nextInt(526);

        CodigoVerificacao codigo = new CodigoVerificacao(number);
        GravaCodigoDAO gravaCodigoDAO = new GravaCodigoDAO();

        if (gravaCodigoDAO.insert(codigo)) {

            BackgroundMail.newBuilder(this).withUsername("pizzaqualeosabor@gmail.com").withPassword("qualesabor123").withMailto(dest).withType(BackgroundMail.TYPE_PLAIN)
            .withSubject("Confirmação de Cadastro").withBody("Código de confirmação: "+number).withOnSuccessCallback(new BackgroundMail.OnSuccessCallback() {
                @Override
                public void onSuccess() {
                    Toast.makeText(CadastroEmpresa.this, "E-mail enviado com sucesso", Toast.LENGTH_SHORT).show();
                }
            }).withOnFailCallback(new BackgroundMail.OnFailCallback() {
                        @Override
               public void onFail() {
                    Toast.makeText(CadastroEmpresa.this, "Falha no envio do E-mail", Toast.LENGTH_SHORT).show();

               }
            }).send();

        } else {
            Toast.makeText(this,"Erro ao gerar seu código de verificação, por favor entre em contato com o suporte", Toast.LENGTH_SHORT).show();
        }
    }

    public String validar(){
        String erros = "";

        if(txtRazaoSocial.getText().toString().equals("")){
            erros = "Os campos marcados em vermelho estão sem informação ou incorretos";
            txtRazaoSocial.setError("Esse campo é obrigatório");
        }
        if(txtNomeFantasia.getText().toString().equals("")){
            erros = "Os campos marcados em vermelho estão sem informação ou incorretos";
            txtNomeFantasia.setError("Esse campo é obrigatório");
        }
        if(txtCnpj.getText().toString().equals("")){
            erros = "Os campos marcados em vermelho estão sem informação ou incorretos";
            txtCnpj.setError("Esse campo é obrigatório");
        }
        if(txtCep.getText().toString().equals("")){
            erros = "Os campos marcados em vermelho estão sem informação ou incorretos";
            txtCep.setError("Esse campo é obrigatório");
        }
        if(txtUf.getText().toString().equals("")){
            erros = "Os campos marcados em vermelho estão sem informação ou incorretos";
            txtUf.setError("Esse campo é obrigatório");
        }
        if(txtMunicipio.getText().toString().equals("")){
            erros = "Os campos marcados em vermelho estão sem informação ou incorretos";
            txtMunicipio.setError("Esse campo é obrigatório");
        }
        if(!txtEmail.getText().toString().contains("@")){
            erros = "Os campos marcados em vermelho estão sem informação ou incorretos";
            txtEmail.setError("E-mail inválido");
        }

        return erros;
    }

}
