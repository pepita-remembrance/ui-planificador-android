package uqbar.android.mvc.binding;

import android.app.Fragment;
import android.view.View;

public class FragmentContainer implements Container{

	private Fragment fragment;

	public FragmentContainer(Fragment fragment) {
		this.fragment = fragment;
	}


    @Override
    public View findViewById(int id) {
        return this.fragment.getActivity().findViewById(id);
    }

    @Override
    public Object getContenido() {
        return fragment;
    }
}
