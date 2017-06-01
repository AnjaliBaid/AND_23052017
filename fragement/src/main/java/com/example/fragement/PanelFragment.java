package com.example.fragement;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class PanelFragment extends Fragment {


    public PanelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_panel, container, false);

        final  MainActivity activity = (MainActivity) getActivity();

        rootView.findViewById(R.id.btnone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Bundle bundle = new Bundle();
//                bundle.putInt(FirstFragment.KEY_FRAG_NUM,R.drawable.ic_looks_one_black_24dp);
//                FirstFragment fragment = new FirstFragment();
//                fragment.setArguments(bundle);

                activity.LoadFragement(FirstFragment.getInstance(R.drawable.ic_looks_one_black_24dp));

                //activity.LoadFragement(fragment);
            }

        });


        rootView.findViewById(R.id.btntwo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.LoadFragement(FirstFragment.getInstance(R.drawable.ic_looks_two_black_24dp));
            }
        });

        rootView.findViewById(R.id.btnthree).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.LoadFragement(FirstFragment.getInstance(R.drawable.ic_looks_3_black_24dp));
            }
        });

        return rootView;
    }

}
