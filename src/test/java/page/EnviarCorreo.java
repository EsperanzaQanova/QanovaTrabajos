package page;

import Utils.ReadProperties;
import Utils.Reporte.PdfQaNovaReports;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EnviarCorreo {

    private void Correo() throws InterruptedException {
        Properties propiedad = new Properties();
        propiedad.put("mail.smtp.host","smtp.gmail.com");
        propiedad.put("mail smtp starttls enable", "true");
        propiedad.put("mail.smtp.port", 587);
        propiedad.put("mail.smtp.auth", "true");

        Session sesion = Session.getDefaultInstance(propiedad);

        String correoEnvia = ReadProperties.readFromConfig("propiedades.properties").getProperty("CorreoEnvia");
        String contrasena = ReadProperties.readFromConfig("propiedades.properties").getProperty("contrasena");
        String destinatario = ReadProperties.readFromConfig("propiedades.properties").getProperty("destinatario");
        String asunto = ReadProperties.readFromConfig("propiedades.properties").getProperty("asunto");
        String mensaje = ReadProperties.readFromConfig("propiedades.properties").getProperty("mensaje");


        MimeMessage mail = new MimeMessage(sesion);

        try {
            mail.setFrom(new InternetAddress(correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress (destinatario));
            mail.setSubject(asunto);
            mail.setText(mensaje);


            Transport transport = sesion.getTransport("smtp");
            transport.connect(correoEnvia,contrasena);
            transport.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transport.close();



        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }


}
