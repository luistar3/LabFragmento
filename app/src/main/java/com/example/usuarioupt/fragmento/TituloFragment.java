package com.example.usuarioupt.fragmento;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by USUARIOUPT on 18/03/2017.
 */

public class TituloFragment extends ListFragment{

    OnTituloSelectedListener mCallBack;
    public interface OnTituloSelectedListener {
        public void onTituloSelected(int position);

    }
    @Override
    public void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                R.layout.support_simple_spinner_dropdown_item,Cotenido.Titulos));
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        try{
            Activity activity = (Activity)context;
            mCallBack = (OnTituloSelectedListener) activity;


        }catch (ClassCastException e){
            try {
                throw  new PendingIntent.CanceledException(getActivity().toString()+ "debe ipplmentar el metodo OntitulosSelectedListener");
            } catch (PendingIntent.CanceledException e1) {
                e1.printStackTrace();
            }
        }
    }


    public void onListItemClick(ListView listView, View view,int position , long id){
        mCallBack.onTituloSelected(position);
        getListView().setItemChecked(position,true);
    }

    @Override

    public void onStart(){
        super.onStart();
        if (getFragmentManager().findFragmentById(R.id.fgm_parrafo) != null){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_titulo,container,false);
    }
}
