package uqbar.android.planificadorhorarios.horarios.storage;

import android.content.Context;
import android.content.SharedPreferences;

import uqbar.android.planificadorhorarios.horarios.R;
import uqbar.android.planificadorhorarios.horarios.models.MiCuentaModel;

public class SharedPreferencesHandler {
    private final SharedPreferences sharedPref;
    private final Context context;

    public SharedPreferencesHandler(Context context) {
        this.context = context;
        sharedPref = context.getSharedPreferences(
                context.getString(R.string.shared_preferences_cuenta), Context.MODE_PRIVATE);
    }

    public SharedPreferencesHandler saveLegajo(Integer legajo){
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(context.getString(R.string.legajo), legajo);
        editor.commit();
        return this;
    }

    public Integer retrieveLegajo(){
        String legajoLabel = context.getString(R.string.legajo);
        return sharedPref.getInt(legajoLabel, MiCuentaModel.LEGAJO_NO_SETEADO);
    }
}
