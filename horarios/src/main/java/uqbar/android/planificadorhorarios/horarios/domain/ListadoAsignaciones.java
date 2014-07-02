package uqbar.android.planificadorhorarios.horarios.domain;

import uqbar.android.mvc.binding.ObservableObject;

import java.util.List;

public class ListadoAsignaciones extends ObservableObject {
    private Planificacion planificacion;

    public ListadoAsignaciones(Planificacion planificacion) {
        this.planificacion = planificacion;
    }

    public List<Empleado> getAsignaciones() {
        return planificacion.empleados;
    }
}
