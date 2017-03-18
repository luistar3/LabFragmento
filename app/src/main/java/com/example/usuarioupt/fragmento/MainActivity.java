package com.example.usuarioupt.fragmento;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements TituloFragment.OnTituloSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.fragment_container) != null){
            if (savedInstanceState != null){
                return;
            }
            //_Crear un nuevo fragmento
            TituloFragment tituloFragment = new TituloFragment();
            //_Agregar extras si Existen
            tituloFragment.setArguments(getIntent().getExtras());
            //_Lanzar la vista
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,tituloFragment).commit();
        }
    }

    @Override
    public void onTituloSelected(int position) {
        ParrafoFragment parrafoFragment = (ParrafoFragment)getSupportFragmentManager().findFragmentById(R.id.fgm_parrafo);

        if (parrafoFragment != null){
            parrafoFragment.updateParrafoView(position);
        }else{
            ParrafoFragment fragmentoNuevo = new ParrafoFragment();
            Bundle args = new Bundle();
            args.putInt(ParrafoFragment.ARG_POSITION,position);
            fragmentoNuevo.setArguments(args);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragmentoNuevo);
            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();

        }
    }
}
