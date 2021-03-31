package page;

import Utils.DriverContext;
import Utils.ReadProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class DescargarArchivo {
    @FindBy (xpath = "//*[@id=\"content\"]/div/a[36]")
    WebElement DescargarArchivo;

    public DescargarArchivo(){
        PageFactory.initElements(DriverContext.getDriver(), this);
    }
    public void DescargarArchivos() throws InterruptedException{

        DescargarArchivo.click();


    }
    public void EliminarArchivo() {
        File Carpeta = new File(ReadProperties.readFromConfig("propiedades.properties").getProperty("Ruta"));
        String[] Archivos = Carpeta.list();
        for (int i=0; i< Archivos.length; i++){
            if (Archivos[i].equals("Archivo.txt")) {
                File Archivo = new File(ReadProperties.readFromConfig("propiedades.properties").getProperty("Ruta")+"Archivo.txt");
                Archivo.delete();

            }
        }
    }
}
