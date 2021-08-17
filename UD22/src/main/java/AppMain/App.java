package AppMain;

import controller.Controlador;
import model.Modelo;
import view.Vista;

public class App 
{
    public static void main( String[] args )
    {
        Modelo modelo = new Modelo();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(modelo, vista);
        controlador.arrancar();
    }
}
