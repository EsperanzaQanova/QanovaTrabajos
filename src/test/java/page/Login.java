package page;

import Utils.DriverContext;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import testSuite.Espera;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    @FindBy (id="imUname")
    WebElement txtUsuario;

    @FindBy(id="imPwd")
    WebElement txtClave;

    @FindBy(xpath="//*[@id=\"imLogin\"]/form/div[3]/input")
    WebElement btnIngresar;

    public Login() { PageFactory.initElements(DriverContext.getDriver(),this );}


    public void ingresarUsuario(String usuario, String clave) throws InterruptedException{
        Espera.esperar("//*[@id=\"imLogin\"]/form/div[3]/input");

        PdfQaNovaReports.addWebReportImage("Inicio de la pagina","El ingreso a la pagina ", EstadoPrueba.DONE,false);
        txtUsuario.sendKeys(usuario);
        txtClave.sendKeys(clave);
        PdfQaNovaReports.addWebReportImage("Credenciales","Se añade las credenciales "+usuario+","+clave,EstadoPrueba.PASSED,false);
        btnIngresar.click();
        Thread.sleep(1000);
        PdfQaNovaReports.addWebReportImage("Ingresar pagina","Ingreso de pagina de inicio exitosamente",EstadoPrueba.PASSED,false);

    }

}


