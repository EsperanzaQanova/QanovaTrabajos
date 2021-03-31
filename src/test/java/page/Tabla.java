package page;

import Utils.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tabla {

    public Tabla(){ PageFactory.initElements(DriverContext.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"imMnMnNode4\"]/a/span/span/span[2]")
    WebElement Matriz;
    @FindBy(xpath = "//*[@id=\"pluginAppObj_4_01_filter_field\"]")
    WebElement IngresarDatos;
    @FindBy(xpath = "//*[@id=\"pluginAppObj_4_01_filter_button\"]")
    WebElement BuscarDatos;
    @FindBy(xpath = "//*[@id=\"pluginAppObj_4_01_jtable\"]/div/table/tbody")
    WebElement Tabla;

    public void BuscarDtos(String nombre)throws InterruptedException{
        Matriz.click();
        IngresarDatos.sendKeys(nombre);
        BuscarDatos.click();

    }




}
