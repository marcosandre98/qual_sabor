package qualosabor.com.br.qualosabor.controller;

import android.content.Context;
import java.util.Date;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class Mail extends AppCompatActivity {

    public void enviarEmail(){

        if(!isOnline()) {
            Toast.makeText(getApplicationContext(), "Não estava online para enviar e-mail!", Toast.LENGTH_SHORT).show();
        }

        new Thread(new Runnable(){
            @Override
            public void run() {
                final String destEmail = "guilhermeschneider@unochapeco.edu.br";
                final String remetEmail = "pizzaqualeosabor@gmail.com"; //caso queira enviar em nome de outro
                final String subject = "Confirmação de Cadastro";
                final String body = "O código de ativação é: MARCOSVIADO";

                try {
                    Properties props = new Properties();
                    props.put("mail.smtp.host", "smtp.gmail.com");
                    props.put("mail.smtp.port", "587");
                    Session session = Session.getInstance(props);
                    MimeMessage msg = new MimeMessage(session);
                    msg.setFrom(new InternetAddress(remetEmail));

                    msg.setRecipients(MimeMessage.RecipientType.TO, destEmail);

                    msg.setSubject(subject);
                    msg.setSentDate(new Date());

                    // corpo da mensagem
                    BodyPart messageBodyPart = new MimeBodyPart();
                    messageBodyPart.setText(body);

                    // envia o email
                    Transport.send(msg);
                }
                catch(RuntimeException rex){ }//erro ignorado
                catch(Exception e) {
                    e.printStackTrace();
                    System.exit(0);
                }

                Toast.makeText(getApplicationContext(), "Email enviado!", Toast.LENGTH_SHORT).show();
            }
        }).start();
    }

    public boolean isOnline() {
        try {
            ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            return netInfo != null && netInfo.isConnectedOrConnecting();
        }
        catch(Exception ex){
            Toast.makeText(getApplicationContext(), "Erro ao verificar se estava online! (" + ex.getMessage() + ")", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
