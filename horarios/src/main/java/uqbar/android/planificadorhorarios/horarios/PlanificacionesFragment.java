package uqbar.android.planificadorhorarios.horarios;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;
import uqbar.android.mvc.binding.ModelBinder;
import uqbar.android.planificadorhorarios.horarios.domain.ListadoPlanificacionModel;
import uqbar.android.planificadorhorarios.horarios.domain.Planificacion;
import uqbar.android.planificadorhorarios.horarios.models.BuscadorPlanificacionesModel;
import uqbar.android.ui.list.ItemListAdapter;
import uqbar.android.ui.list.ItemSelectionListener;

public class PlanificacionesFragment extends Fragment implements ItemSelectionListener<Planificacion> {
    private ListView planificacionesListView;
    private ListadoPlanificacionModel model;
    private BuscadorPlanificacionesModel buscador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        return inflater.inflate(R.layout.fragment_planificaciones, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.model = new ListadoPlanificacionModel(((MainActivity) getActivity()).getSpiceManager());
        planificacionesListView = (ListView) getView().findViewById(R.id.planificacionesListView);

        new ModelBinder(this, model)
            .when(ListadoPlanificacionModel.Events.BusquedaFinalizada, "actualizarResultados");

        model.buscar(buscador.getDesde(), buscador.getHasta());
    }

    public void actualizarResultados() {
        ItemListAdapter<Planificacion> adapter = new ItemListAdapter<Planificacion>(getActivity(), model.getPlanificaciones(), new PlanificacionRender(), this);
        planificacionesListView.setAdapter(adapter);
    }

    @Override
    public void onSelect(Planificacion item, View view) {
        Toast.makeText(getActivity(), item.getEstado(), Toast.LENGTH_SHORT).show();
    }

    public PlanificacionesFragment setBuscador(BuscadorPlanificacionesModel buscador) {
        this.buscador = buscador;
        return this;
    }
}
