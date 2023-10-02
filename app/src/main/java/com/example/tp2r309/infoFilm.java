package com.example.tp2r309;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Hashtable;

public class infoFilm extends AppCompatActivity {
private String Titref;
private TextView Titre;
private TextView Resume;
private ImageView Illu;
public Hashtable<String,String> listres;
public Hashtable<String,Integer> listimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_film);
        Intent i= getIntent();
        Titref=i.getStringExtra("Titre");
        Titre=(TextView) findViewById(R.id.Titre_id);
        Titre.setText(Titref);
        listres=new Hashtable<String,String>();
        listimg=new Hashtable<String,Integer>();
        Resume=(TextView) findViewById(R.id.Resum_id);
        Illu=(ImageView) findViewById(R.id.Illu_id);
        listres.put("Rush","Le film évoque la rivalité, durant les années 1970, opposant les pilotes " +
                "de course automobile James Hunt (interprété par Chris Hemsworth) et Niki Lauda (joué par Daniel Brühl), " +
                "qui atteint son paroxysme, titre mondial en jeu, lors de la saison de Formule 1 de 1976.") ;
        listres.put("Dune","Paul Atreides, un jeune homme brillant et doué au destin plus grand que lui-même, doit se rendre sur la planète la plus dangereuse de l'univers afin d'assurer l'avenir de sa famille et de son peuple. Cette planète est la source exclusive" +
                " de la ressource la plus précieuse qui soit pour laquelle des forces sinistres déclenchent un conflit dont " +
                "seuls ceux sachant maîtriser leurs peurs survivront");
        Resume.setText(listres.get(Titref));
        listimg.put("Rush",R.drawable.rush);
        listimg.put("Dune",R.drawable.dune);
        if(listimg.get(Titref)!=null){
            Illu.setImageResource(listimg.get(Titref));}



    }
}