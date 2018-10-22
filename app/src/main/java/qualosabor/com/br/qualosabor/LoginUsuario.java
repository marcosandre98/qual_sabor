package qualosabor.com.br.qualosabor;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class LoginUsuario extends AppCompatActivity {

    private ImageButton imgBtnCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_usuario);


        imgBtnCamera = (ImageButton) LoginUsuario.this.findViewById(R.id.imgBtnCamera);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Login Usuário");

    }
}
