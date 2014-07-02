package uqbar.android.planificadorhorarios.horarios.models;

import android.content.Context;

import uqbar.android.mvc.binding.ObservableObject;
import uqbar.android.planificadorhorarios.horarios.storage.SharedPreferencesHandler;

public class MiCuentaModel extends ObservableObject {
    public static final int LEGAJO_NO_SETEADO = -1;

    private String legajo;
    private final SharedPreferencesHandler preferencesHandler;

    public MiCuentaModel(Context context) {
        this.preferencesHandler = new SharedPreferencesHandler(context);
        this.legajo = preferencesHandler.retrieveLegajo().toString();
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public void guardarLegajo(){
        this.preferencesHandler.saveLegajo(Integer.parseInt(this.legajo));
    }
}
