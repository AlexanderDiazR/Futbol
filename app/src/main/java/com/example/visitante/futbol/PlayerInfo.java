package com.example.visitante.futbol;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlayerInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent i = getIntent();
        ArrayList<String> ll = new ArrayList<>();
        ArrayList<String> lis = new ArrayList<>();
        ArrayList<String> edad = new ArrayList<>();
        ll = i.getStringArrayListExtra("ll");
        lis = i.getStringArrayListExtra("lis");
        edad = i.getStringArrayListExtra("edad");
        //SortList(ll);
        final ArrayList<String> lol = new ArrayList<>();
        int p = i.getIntExtra("pos", 0);
        for(int e = p*4;e<p*4+4;e++){
            lol.add(ll.get(e));
        }
        lol.add(edad.get(p));
        final ListView loglista = (ListView)findViewById(R.id.listaa);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lol);
        loglista.setAdapter(adapter);

        loglista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Object listItem = loglista.getItemAtPosition(position);
                if(position!=0 && position%3==0){
                    AlertDialog.Builder b = new AlertDialog.Builder(PlayerInfo.this);
                    b.setTitle("Estado");
                    b.setMessage("Cambiar Estado?");
                    b.setPositiveButton(getString(android.R.string.ok), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (lol.get(position).equals("Estado: On ")){
                                lol.add(position, "Estado: Off ");
                            }else{
                                lol.add(position, "Estado: On ");
                            }
                            recreate();
                            Toast.makeText(PlayerInfo.this, "Estado Cambiado", Toast.LENGTH_SHORT).show();
                        }
                    });
                    b.setNegativeButton(getString(android.R.string.cancel), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(PlayerInfo.this, "Cancelado", Toast.LENGTH_SHORT).show();
                        }
                    });
                    AlertDialog di = b.create();
                    di.show();
                }
            }
        });

    }

    public void backtoMain(View view) {
        Intent j = new Intent (this, MainActivity.class);
        startActivity(j);
    }

    void SortList(ArrayList l){
        for(int i = 0;i<l.size()-1;i++){
            String ne = l.get(i).toString().concat(l.get(i+1).toString());
            l.add(i, ne);
            l.remove(i+1);
            l.remove(i+1);
        }
    }
}
