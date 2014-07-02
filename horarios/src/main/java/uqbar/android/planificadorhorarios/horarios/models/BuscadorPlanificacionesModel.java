package uqbar.android.planificadorhorarios.horarios.models;

import android.text.format.Time;

import uqbar.android.mvc.binding.BusinessEvent;
import uqbar.android.mvc.binding.ObservableObject;

public class BuscadorPlanificacionesModel extends ObservableObject {
    public enum Events implements BusinessEvent {
        BUSCAR_PLANIFICACIONES
    }

    private Time desde = new Time();
    private Time hasta = new Time();

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

    public void setDesde(int dia, int mes, int anio){
        setTime(desde, dia, mes, anio);
    }

    public void setHasta(int dia, int mes, int anio){
        setTime(hasta, dia, mes, anio);
    }

    public void setTime(Time aTime, int dia, int mes, int anio){
        aTime.monthDay = dia;
        aTime.month = mes;
        aTime.year = anio;
    }

}
