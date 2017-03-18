package com.example.usuarioupt.fragmento;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by USUARIOUPT on 18/03/2017.
 */

public class ParrafoFragment extends Fragment {


    final static String ARG_POSITION = "POSITION";
    int mCurrentPosition = -1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        if (savedInstanceState !=null){
            mCurrentPosition=savedInstanceState.getInt(ARG_POSITION);
        }
        return inflater.inflate(R.layout.fregment_parrafo,container,false);



    }


    public void updateParrafoView(int position) {
        TextView parrafo = (TextView)getActivity().findViewById(R.id.txt_fragmento);
        parrafo.setText(Cotenido.Parrafos[position]);
        mCurrentPosition = position;
    }

    @Override
    public void onStart(){
        super.onStart();
        Bundle args = getArguments();
        if (args!=null){
            updateParrafoView(args.getInt(ARG_POSITION));

        }
        else if(mCurrentPosition != -1){
            updateParrafoView(mCurrentPosition);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION,mCurrentPosition);
    }




}
