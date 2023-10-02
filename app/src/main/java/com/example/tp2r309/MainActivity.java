package com.example.tp2r309;

import static android.app.ProgressDialog.show;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private EditText Film;
ArrayAdapter<String>myadapter;

public ArrayList<String> LFilm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Film = (EditText) findViewById(R.id.Film_id);
        LFilm=new ArrayList<String>();
        myadapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,LFilm);
        ListView ListeFilm=(ListView)findViewById(R.id.ListFilm);
        ListeFilm.setAdapter(myadapter);
        ListeFilm.setOnItemClickListener(this::onItemClick);
        registerForContextMenu(ListeFilm);

    }
    public void Ajouterfilm(View v){
        String vf=Film.getText().toString();
        if (vf.isEmpty()){
            Toast.makeText(getApplicationContext(),"indiquez un FIlm",Toast.LENGTH_SHORT).show();
        }
        LFilm.add(vf);
        myadapter.notifyDataSetChanged();
        Film.setText("");
    }
    public void onItemClick(AdapterView<?> p, View v, int pos, long id) {
        Intent intent=new Intent(this,infoFilm.class);
        intent.putExtra("Titre", LFilm.get(pos));
        startActivity(intent);
    }
    public void onCreateContextMenu(ContextMenu m, View v, ContextMenu.ContextMenuInfo i) {
        m.setHeaderTitle("Actions");
        m.add(Menu.NONE,v.getId(),1,"Supprimer");
        m.add(Menu.NONE,v.getId(),2,"Modifier");

    }
    public boolean onContextItemSelected (MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if (item.getTitle() == "Supprimer") {
            LFilm.remove(info.position);
            myadapter.notifyDataSetChanged();
            return true;
        }
       if (item.getTitle() == "Modifier") {
            String modifier=LFilm.get(info.position);
            LFilm.remove(info.position);
            myadapter.notifyDataSetChanged();
            Film.setText(modifier);

        return true;
        }
    return true;
    }
}