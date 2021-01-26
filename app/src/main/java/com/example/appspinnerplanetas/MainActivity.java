package com.example.appspinnerplanetas;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Programação para Dispositivos Móveis I.
 * INTERFACE DO USUÁRIO
 * Material de apoio: https://fagno.github.io/des-movel-i-ifto/activity/#_spinner
 * <p>
 * Crie um aplicativo que utilize Spinner para listar os nomes dos planetas.
 * Ao selecionar o planeta de acordo um nome da lista, uma imagem do planeta
 * deve ser apresentada em um ImageView.
 */

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String[] planetas = new String[]{
            "Mercury", "Venus", "Earth", "Mars",
            "Jupiter", "Saturn", "Uranus", "Neptune"
    };
    private int[] planetasImagens = {R.drawable.mercury, R.drawable.venus,
            R.drawable.earth, R.drawable.mars, R.drawable.jupiter,
            R.drawable.saturn, R.drawable.uranus, R.drawable.netuno};

    private Spinner spinner;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, planetas);
        //Set para definir o elemento view que vai mostrar o spinner
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        imageView = findViewById(R.id.imageView);

        spinner = findViewById(R.id.planets_spinner);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Estou adicioando a imagem ao imagemView quando o elemento for selecionado.
        imageView.setImageResource(planetasImagens[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}