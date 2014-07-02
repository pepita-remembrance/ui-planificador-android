package uqbar.android.planificadorhorarios.horarios.render;

import android.view.View;
import android.widget.TextView;
import uqbar.android.planificadorhorarios.horarios.R;
import uqbar.android.planificadorhorarios.horarios.domain.Empleado;
import uqbar.android.ui.list.ItemRender;

public class AsignacionRender implements ItemRender<Empleado> {
    @Override
    public int getLayout() {
        return R.layout.planificacion_render;
    }

    @Override
    public void draw(View view, Empleado empleado) {
        ((TextView) view.findViewById(R.id.planificacion_fecha)).setText(empleado.nombre);
        ((TextView) view.findViewById(R.id.planificacion_estado)).setText(empleado.getAsignacion());
    }
}
