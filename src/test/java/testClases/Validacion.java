package testClases;

import page.MensajeDeError;
import page.ValidacionDeOpciones;

public class Validacion {
    ValidacionDeOpciones validacionDeOpciones;
    public void ValidacionPagina(String texto, String fecha, String email) throws InterruptedException {
        ValidacionDeOpciones validacionDeOpciones = new ValidacionDeOpciones();
        validacionDeOpciones.llenarCampos(texto, fecha, email);




    }
}

