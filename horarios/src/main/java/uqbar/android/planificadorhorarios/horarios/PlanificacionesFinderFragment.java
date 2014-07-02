package uqbar.android.planificadorhorarios.horarios;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uqbar.android.mvc.binding.ModelBinder;
import uqbar.android.planificadorhorarios.horarios.models.BuscadorPlanificacionesModel;

public class PlanificacionesFinderFragment extends CustomFragment<MainActivity> {
    private ModelBinder binder;
    private BuscadorPlanificacionesModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        return inflater.inflate(R.layout.fragment_planificaciones_finder, container, false);
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.model = new BuscadorPlanificacionesModel();
        this.binder = new ModelBinder(this, this.model)
                .action(R.id.buscar_button, "buscarPlanificaciones")
                .when(BuscadorPlanificacionesModel.Events.BUSCAR_PLANIFICACIONES, "search")
                .updateView();
    }

    public void search(){
        this.getParentActivity().changeFragment(new PlanificacionesFragment());
    }
}
