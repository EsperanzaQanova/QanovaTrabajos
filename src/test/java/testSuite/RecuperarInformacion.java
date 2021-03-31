package testSuite;

import Utils.DriverContext;
import Utils.Constants.Navegador;
import Utils.ReadProperties;

import Utils.Reporte.PdfQaNovaReports;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testClases.DevolverMensaje;
import testClases.Ingresar;
import testClases.RecuperarDatosMatriz;
import testClases.Validacion;


public class RecuperarInformacion {

    String url = ReadProperties.readFromConfig("propiedades.properties").getProperty("url");
    String Usuario = ReadProperties.readFromConfig("propiedades.properties").getProperty("usuario");
    String Clave = ReadProperties.readFromConfig("propiedades.properties").getProperty("clave");

    @Test
    public void buscarColor() {
    }

    @BeforeTest
    public void setUp() {
        DriverContext.setUp(Navegador.Chrome, url);
        PdfQaNovaReports.createPDF();
    }

    @AfterTest
    public void end() {
        DriverContext.closeDriver();
    }

    @Test
    public void login() throws InterruptedException {
        Ingresar ingresar = new Ingresar();
        ingresar.inicio(Usuario, Clave);
        PdfQaNovaReports.closePDF();
    }

    @Test
    public void RecuperarCampo() throws InterruptedException {
        DevolverMensaje devolverMensaje = new DevolverMensaje();
        devolverMensaje.Rellenar();
        PdfQaNovaReports.closePDF();
    }

    @Test
    public void llenar() throws InterruptedException {
        Ingresar ingresar = new Ingresar();
        ingresar.inicio(Usuario, Clave);
        Validacion validacion = new Validacion();
        validacion.ValidacionPagina("cualquier cosa", "22/03/2021", "reyes.esperanza@hotmail.cl");
        PdfQaNovaReports.closePDF();
    }

    @Test
    public void nombre() throws InterruptedException {
        Ingresar ingresar = new Ingresar();
        ingresar.inicio(Usuario, Clave);
        Espera.esperar("//*[@id=\\\"imMnMnNode4\\\"]/a/span/span/span[2]\"");
        RecuperarDatosMatriz recuperarDatosMatriz = new RecuperarDatosMatriz();
        recuperarDatosMatriz.TablaDatos();
        PdfQaNovaReports.closePDF();
    }


}