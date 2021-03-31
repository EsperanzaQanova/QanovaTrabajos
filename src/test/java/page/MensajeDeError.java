package page;

import Utils.DriverContext;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MensajeDeError {

    @FindBy(xpath= "//*[@id=\"imLoginPage\"]/div[3]/div")
    WebElement msnError;
    @FindBy (xpath = "//*[@id=\"imLogin\"]/form/div[3]/input")
    WebElement Ingresar;
    @FindBy (id="imUname")
    WebElement txtUsuario;
    @FindBy(id="imPwd")
    WebElement txtClave;

    public MensajeDeError() { PageFactory.initElements(DriverContext.getDriver(),this );}
    public void recuperarMensaje(String usuario, String clave) throws InterruptedException{

        PdfQaNovaReports.addWebReportImage("Inicio de pagina Qanova","Se despliega la pagina qanova y se visualizan los textbox, el boton y el link", EstadoPrueba.PASSED,false);
        txtUsuario.sendKeys(usuario);
        txtClave.sendKeys(clave);
        PdfQaNovaReports.addWebReportImage("Credenciales","Se añade las credenciales "+usuario+","+clave,EstadoPrueba.PASSED,false);
        Ingresar.click();
        PdfQaNovaReports.addWebReportImage("mensajeErroneo","luego de ingresar una clave erronea y hacer clic en enviar aparece en un recuadro rojo Nombre y/o password incorrecto",EstadoPrueba.PASSED,false);
        msnError.getText();
        msnError.getCssValue("color");
        System.out.println(msnError.getCssValue("color"));
        System.out.println(msnError.getText());


    }

}
