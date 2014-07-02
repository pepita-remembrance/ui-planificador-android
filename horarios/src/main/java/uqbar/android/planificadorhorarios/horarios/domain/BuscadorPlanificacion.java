package uqbar.android.planificadorhorarios.horarios.domain;

import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;
import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;
import uqbar.android.mvc.binding.BusinessEvent;
import uqbar.android.mvc.binding.ObservableObject;
import uqbar.android.planificadorhorarios.horarios.services.Planificador;

import java.util.List;

public class BuscadorPlanificacion extends ObservableObject {
    private SpiceManager spiceManager;
    private List<Planificacion> planificaciones;

    public List<Planificacion> getPlanificaciones() {
        return planificaciones;
    }

    public enum Events implements BusinessEvent {
        BusquedaFinalizada,
    }

    public BuscadorPlanificacion(SpiceManager spiceManager) {
        this.spiceManager = spiceManager;
    }

    public void buscar() {
        RetrofitSpiceRequest<Planificacion.List, Planificador> request = new RetrofitSpiceRequest<Planificacion.List, Planificador>(Planificacion.List.class, Planificador.class) {
            @Override
            public Planificacion.List loadDataFromNetwork() throws Exception {
                return getService().getPlanificaciones();
            }
        };

        getSpiceManager().execute(request, new PlanificacionesRequestListener());
    }

    public void setPlanificaciones(List<Planificacion> planificaciones) {
        this.planificaciones = planificaciones;
        fireEvent(Events.BusquedaFinalizada);
    }

    private SpiceManager getSpiceManager() {
        return spiceManager;
    }

    public final class PlanificacionesRequestListener implements RequestListener<Planificacion.List> {
        @Override
        public void onRequestFailure(SpiceException spiceException) {
        }

        @Override
        public void onRequestSuccess(Planificacion.List planificaciones) {
            setPlanificaciones(planificaciones);
        }
    }
}
