package uqbar.android.planificadorhorarios.horarios.models;

import android.text.format.Time;

import uqbar.android.mvc.binding.BusinessEvent;
import uqbar.android.mvc.binding.ObservableObject;

public class BuscadorPlanificacionesModel extends ObservableObject {
    public enum Events implements BusinessEvent {
        BUSCAR_PLANIFICACIONES
    }

    private Time desde;
    private Time hasta;

    public Time getDesde() {
        return desde;
    }

    public void setDesde(Time desde) {
        this.desde = desde;
    }

    public Time getHasta() {
        return hasta;
    }

    public void setHasta(Time hasta) {
        this.hasta = hasta;
    }

    public void buscarPlanificaciones(){
        fireEvent(Events.BUSCAR_PLANIFICACIONES);
    }

}
