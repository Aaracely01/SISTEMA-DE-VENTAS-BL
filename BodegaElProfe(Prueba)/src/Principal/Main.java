package Principal;

import Proceso.ProcesosUsuario;
import Vista.FormLogin;

public class Main {

    public static void main(String[] args) {
        FormLogin fl = new FormLogin();
        ProcesosUsuario.Presentacion(fl);
    }
    
}
