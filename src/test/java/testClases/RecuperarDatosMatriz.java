package testClases;

import Utils.ReadProperties;
import page.Tabla;

public class RecuperarDatosMatriz {
    public void TablaDatos() throws InterruptedException{
        String Datos = ReadProperties.readFromConfig("propiedades.properties").getProperty("Datos");
        Tabla tabla = new Tabla();
        tabla.BuscarDtos(Datos);
    }
}
