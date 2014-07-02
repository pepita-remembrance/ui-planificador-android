package uqbar.android.planificadorhorarios.horarios.domain;

public class Empleado {
    public String nombre;
    public Integer entrada;
    public Integer salida;

    public String getAsignacion() {
        return String.format("(%1$d - %2$d)", entrada, salida);
    }
}
