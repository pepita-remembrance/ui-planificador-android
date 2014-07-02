package uqbar.android.planificadorhorarios.horarios;

import android.view.View;
import android.widget.TextView;
import uqbar.android.planificadorhorarios.horarios.domain.Planificacion;
import uqbar.android.ui.list.ItemRender;

public class PlanificacionRender implements ItemRender<Planificacion> {
    @Override
    public int getLayout() {
        return R.layout.planificacion_render;
    }

    @Override
    public void draw(View view, Planificacion planificacion) {
        ((TextView) view.findViewById(R.id.planificacion_fecha)).setText(planificacion.getFechaUserFriendly());
        ((TextView) view.findViewById(R.id.planificacion_estado)).setText(planificacion.getEstado());
    }
}
