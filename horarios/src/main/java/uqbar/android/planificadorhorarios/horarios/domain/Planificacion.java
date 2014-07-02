package uqbar.android.planificadorhorarios.horarios.domain;

import android.text.format.Time;

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

    public boolean estaEntre(Time desde, Time hasta) {
        return fecha.after(new Date(desde.toMillis(true))) && fecha.before(new Date(hasta.toMillis(true)));
    }

    public static class List extends ArrayList<Planificacion> {
    }
}
