package uqbar.android.planificadorhorarios.horarios;

import android.app.Activity;
import android.app.Fragment;

public class CustomFragment<T extends Activity> extends Fragment {

    public T getParentActivity(){
        return (T)this.getActivity();
    }
}
