package uqbar.android.planificadorhorarios.horarios.domain;

import java.util.ArrayList;
import java.util.Date;

public class Planificacion {
    public Date fecha;
    public boolean estaPlanificado;

    public static class List extends ArrayList<Planificacion> {
    }
}
