package pt.sali.sali.fragments;


import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import pt.sali.sali.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragMyProfile extends Fragment {

    TextView tvNome, tvCedula, tvProf, tvEsp;
    ImageView ivImagem;
    Toolbar toolbar;


    public FragMyProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Perfil");
        View v = inflater.inflate(R.layout.fragment_frag_my_profile, container, false);
        tvNome = v.findViewById(R.id.tv_profile_nome);
        tvCedula = v.findViewById(R.id.tv_profile_id);
        tvProf = v.findViewById(R.id.tv_profile_prof);
        tvEsp = v.findViewById(R.id.tv_profile_esp);
        ivImagem = v.findViewById(R.id.iv_profile_image);
        Picasso.get().load("https://api.adorable.io/avatars/128/ola+adeus").into(ivImagem);

        toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.getMenu().clear();
        return v;
    }

}