package uqbar.android.planificadorhorarios.horarios.services;

import retrofit.http.GET;
import uqbar.android.planificadorhorarios.horarios.domain.Planificacion;

public interface Planificador {
    @GET("/planificaciones")
    Planificacion.List getPlanificaciones();
}
