package uqbar.android.planificadorhorarios.horarios.domain;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Planificacion {
    public Date fecha;
    public boolean estaPlanificado;

    public String getFechaUserFriendly() {
        return DateFormat.getDateInstance().format(fecha);
    }

    public String getEstado() {
        return estaPlanificado ? "Planificado" : "Sin Planificar";
    }

    public static class List extends ArrayList<Planificacion> {
    }
}
