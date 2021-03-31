package testClases;

import Utils.ReadProperties;
import Utils.Reporte.PdfQaNovaReports;
import page.MensajeDeError;

public class DevolverMensaje {
    String Usuario = ReadProperties.readFromConfig("propiedades.properties").getProperty("usuario");
    String pass = ReadProperties.readFromConfig("propiedades.properties").getProperty("incorrecta");
    public void Rellenar() throws InterruptedException{
        MensajeDeError mensajeDeError= new MensajeDeError();
        mensajeDeError.recuperarMensaje(Usuario, pass);

    }
}
