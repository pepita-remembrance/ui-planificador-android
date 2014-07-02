package uqbar.android.planificadorhorarios.horarios.domain;

import android.text.format.Time;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;
import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;
import uqbar.android.mvc.binding.BusinessEvent;
import uqbar.android.mvc.binding.ObservableObject;
import uqbar.android.planificadorhorarios.horarios.services.Planificador;

import java.util.List;

public class ListadoPlanificacionModel extends ObservableObject {
    private SpiceManager spiceManager;
    private List<Planificacion> planificaciones;

    public List<Planificacion> getPlanificaciones() {
        return planificaciones;
    }

    public enum Events implements BusinessEvent {
        BusquedaFinalizada,
    }

    public ListadoPlanificacionModel(SpiceManager spiceManager) {
        this.spiceManager = spiceManager;
    }

    public void buscar(Time desde, Time hasta) {
        RetrofitSpiceRequest<Planificacion.List, Planificador> request = new RetrofitSpiceRequest<Planificacion.List, Planificador>(Planificacion.List.class, Planificador.class) {
            @Override
            public Planificacion.List loadDataFromNetwork() throws Exception {
                return getService().getPlanificaciones();
            }
        };

        getSpiceManager().execute(request, new PlanificacionesRequestListener(desde, hasta));
    }

    public void setPlanificaciones(List<Planificacion> planificaciones) {
        this.planificaciones = planificaciones;
        fireEvent(Events.BusquedaFinalizada);
    }

    private SpiceManager getSpiceManager() {
        return spiceManager;
    }

    public final class PlanificacionesRequestListener implements RequestListener<Planificacion.List> {
        private final Time desde;
        private final Time hasta;

        public PlanificacionesRequestListener(Time desde, Time hasta) {
            this.desde = desde;
            this.hasta = hasta;
        }

        @Override
        public void onRequestFailure(SpiceException spiceException) {
        }

        @Override
        public void onRequestSuccess(Planificacion.List planificaciones) {
            setPlanificaciones(Lists.newArrayList(Iterables.filter(planificaciones, new Predicate<Planificacion>() {
                @Override
                public boolean apply(Planificacion input) {
                    return input.estaEntre(desde, hasta);
                }
            })));
        }
    }
}
