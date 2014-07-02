package uqbar.android.planificadorhorarios.horarios;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uqbar.android.mvc.binding.Container;
import uqbar.android.mvc.binding.ModelBinder;
import uqbar.android.planificadorhorarios.horarios.models.MiCuentaModel;

public class MiCuentaFragment extends Fragment {

    private MiCuentaModel model;
    private ModelBinder binder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new MiCuentaModel(this.getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {

        return inflater.inflate(R.layout.fragment_mi_cuenta, container, false);
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.binder = new ModelBinder(this.getActivity(), this.model)
                .property(R.id.input_legajo, "legajo")//
                .action(R.id.save_cuenta, "guardarLegajo").
                updateView();

    }
}
