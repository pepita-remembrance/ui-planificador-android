package uqbar.android.planificadorhorarios.horarios;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import uqbar.android.planificadorhorarios.horarios.domain.Empleado;
import uqbar.android.planificadorhorarios.horarios.domain.ListadoAsignaciones;
import uqbar.android.planificadorhorarios.horarios.domain.Planificacion;
import uqbar.android.planificadorhorarios.horarios.render.AsignacionRender;
import uqbar.android.ui.list.ItemListAdapter;
import uqbar.android.ui.list.ItemSelectionListener;

public class PlanificacionDetailFragment extends Fragment implements ItemSelectionListener<Empleado> {
    private ListadoAsignaciones model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        return inflater.inflate(R.layout.fragment_planificaciones, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ListView listView = (ListView) getView().findViewById(R.id.planificacionesListView);

        ItemListAdapter<Empleado> adapter = new ItemListAdapter<Empleado>(getActivity(), model.getAsignaciones(), new AsignacionRender(), this);
        listView.setAdapter(adapter);
    }

    public void setPlanificacion(Planificacion model) {
        this.model = new ListadoAsignaciones(model);
    }

    @Override
    public void onSelect(Empleado item, View view) {
    }
}
