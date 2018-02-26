package com.example.visitante.futbol;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> lis = new ArrayList<>();
    ArrayList<String> ll = new ArrayList<>();
    ArrayList<String> edad = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lis.add("Nombre: ");
        lis.add("Juan ");
        lis.add("Apellido: ");
        lis.add("Perez ");
        lis.add("\nPosición: ");
        lis.add("Delantero ");
        lis.add("Estado: ");
        lis.add("On ");
        edad.add("Edad: 21");
        lis.add("Nombre: ");
        lis.add("Pedro ");
        lis.add("Apellido: ");
        lis.add("Torres ");
        lis.add("\nPosición: ");
        lis.add("Portero ");
        lis.add("Estado: ");
        lis.add("Off ");
        edad.add("Edad: 20");
        lis.add("Nombre: ");
        lis.add("Jairo ");
        lis.add("Apellido: ");
        lis.add("Padilla ");
        lis.add("\nPosición: ");
        lis.add("Volante ");
        lis.add("Estado: ");
        lis.add("On ");
        edad.add("Edad: 22");
        lis.add("Nombre: ");
        lis.add("Ramiro ");
        lis.add("Apellido: ");
        lis.add("Sánchez ");
        lis.add("\nPosición: ");
        lis.add("Delantero ");
        lis.add("Estado: ");
        lis.add("On ");
        edad.add("Edad: 20");
        ll.addAll(lis);
        SortList(ll);
        SortList(lis);
        SortList(lis);
        SortList(lis);
        final ListView loglista = (ListView)findViewById(R.id.Lista);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lis);
        loglista.setAdapter(adapter);

        loglista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object listItem = loglista.getItemAtPosition(position);
                /*AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                b.setTitle("Info");
                b.setMessage(lis.get(position).concat("\n").concat(edad.get(position)));
                b.setPositiveButton(getString(android.R.string.ok),null);
                b.setNegativeButton(getString(android.R.string.cancel), null);
                AlertDialog di = b.create();
                di.show();*/
                clickLog(view, position);
            }
            /*public void clickLog(View view){
                Intent i = new Intent(MainActivity.this, PlayerInfo.class);
                i.putExtra("lis",lis);
                i.putExtra("ll",ll);
                startActivity(i);
            }*/
        });
    }

    public void clickLog(View view, int pos) {
        Intent i = new Intent (this, PlayerInfo.class);
        i.putExtra("lis",lis);
        i.putExtra("ll",ll);
        i.putExtra("edad", edad);
        i.putExtra("pos", pos);
        startActivity(i);
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
