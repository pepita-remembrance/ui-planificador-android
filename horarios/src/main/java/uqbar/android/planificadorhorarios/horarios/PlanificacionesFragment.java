package uqbar.android.planificadorhorarios.horarios;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;
import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;
import uqbar.android.planificadorhorarios.horarios.domain.Planificacion;
import uqbar.android.planificadorhorarios.horarios.services.Planificador;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public class PlanificacionesFragment extends Fragment {
    private ListView planificacionesListView;
    private List<Planificacion> planificaciones = new ArrayList<Planificacion>();
    private ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        return inflater.inflate(R.layout.fragment_planificaciones, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupListView();
        loadPlanificaciones();
    }

    private void setupListView() {
        planificacionesListView = (ListView) getView().findViewById(R.id.planificacionesListView);
        adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_expandable_list_item_1, getPlanificacionesAsString());

        planificacionesListView.setAdapter(adapter);
    }

    private List<String> getPlanificacionesAsString() {
        return Lists.newArrayList(Iterables.transform(getPlanificaciones(), new Function<Planificacion, String>() {
            @Override
            public String apply(Planificacion input) {
                return DateFormat.getDateInstance().format(input.fecha) + " - " + (input.estaPlanificado ? "Planificado" : "Sin Planificar");
            }
        }));
    }

    private void loadPlanificaciones() {
        RetrofitSpiceRequest<Planificacion.List, Planificador> request = new RetrofitSpiceRequest<Planificacion.List, Planificador>(Planificacion.List.class, Planificador.class) {
            @Override
            public Planificacion.List loadDataFromNetwork() throws Exception {
                return getService().getPlanificaciones();
            }
        };

        ((MainActivity) getActivity()).getSpiceManager().execute(request, new PlanificacionesRequestListener());
    }

    public void setPlanificaciones(Planificacion.List planificaciones) {
        this.planificaciones = planificaciones;

        adapter.clear();
        adapter.addAll(getPlanificacionesAsString());
    }

    public List<Planificacion> getPlanificaciones() {
        return planificaciones;
    }

    public final class PlanificacionesRequestListener implements RequestListener<Planificacion.List> {
        @Override
        public void onRequestFailure(SpiceException spiceException) {
            Toast.makeText(getActivity(), "Ups! No pudimos conectar con el backend: " + spiceException.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onRequestSuccess(Planificacion.List planificaciones) {
            PlanificacionesFragment.this.setPlanificaciones(planificaciones);
        }
    }
}
