package com.example.yournight10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar; // Importar la clase correcta
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class principal1 extends AppCompatActivity {
    List<locales> lst;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal1);

        listView = findViewById(R.id.listviewL);

        customAdapter s = new customAdapter( this, GetData());
        listView.setAdapter(s);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                locales a = lst.get(i);
                Toast.makeText(getApplicationContext(), a.nombreL, Toast.LENGTH_SHORT).show();
            }
        });





    Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        //menu lateral
        NavigationView nav = (NavigationView) findViewById(R.id.nav);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id==R.id.op1){
                    Perfil p = new Perfil();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,p).commit();
                    Toast.makeText(getApplicationContext(),"vas al Perfil", Toast.LENGTH_SHORT).show();
                }
                else if (id==R.id.op2){
                    Reservas v = new Reservas();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,v).commit();
                    Toast.makeText(getApplicationContext(),"vas a las Reservas", Toast.LENGTH_SHORT).show();
                }
                else if (id==R.id.op3){
                    Historial h = new Historial();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,h).commit();
                    Toast.makeText(getApplicationContext(),"vas al Historial", Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.op4){
                    Configuracion c = new Configuracion();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,c).commit();
                    Toast.makeText(getApplicationContext(),"vas a las Configuraciones", Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.op5){
                    SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = datos.edit();
                    editor.remove("correo");
                    editor.apply();
                    finish();

                }


                return false;
            }

        });
        DrawerLayout dl =(DrawerLayout) findViewById(R.id.principal);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(
                this,
                dl,
                R.string.abrir_drawer,
                R.string.cerrar_drawer
        );
        dl.addDrawerListener(toggle);
        toggle.syncState();

        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dl.isDrawerOpen(GravityCompat.START)){
                    dl.closeDrawer(GravityCompat.START);
                }
                else{
                    dl.openDrawer((int) Gravity.START);
                }
            }
        });
    }

    private List<locales> GetData() {
        lst = new ArrayList<>();
        lst.add(new locales(1,R.drawable.perfil,"ARTEPUBRESTOBAR", "Dirección: Maipú 641, 1530000 Copiapó, Atacama",2));
        lst.add(new locales(2,R.drawable.perfil,"Pub La Torre", "Dirección: Atacama 109, 1530000 Copiapó, Atacama",2));
        lst.add(new locales(3,R.drawable.perfil,"Bar Copiapo Matanza", "Dirección: Atacama 19, 1530554 Copiapó, Atacama",2));
        lst.add(new locales(4,R.drawable.perfil,"Toros y Toreros", "Los Carrera 836, 1530441 Copiapó, Atacama",2));
        lst.add(new locales(1,R.drawable.perfil,"Lupulos Bar Copiapo", "Dirección: Juan godoy 46 alameda Copiapó, 1530000 Atacama",2));
        lst.add(new locales(2,R.drawable.perfil,"Lagerhaus Bar Copiapo", "Dirección: Bernardo O'Higgins 150, 1530000 Copiapó, Atacama",2));
        lst.add(new locales(3,R.drawable.perfil,"Lolitas Shoperia", "Dirección: Chacabuco 157, 1530652 Copiapó, Atacama",2));
        lst.add(new locales(4,R.drawable.perfil,"Pepe Bar y Cantina", "Dirección: Atacama 266, 1530610 Copiapó, Atacama",2));
        lst.add(new locales(1,R.drawable.perfil,"piscologia", "Dirección: José M. Infante 861, Copiapo; 522354450",2));
        lst.add(new locales(2,R.drawable.perfil,"Copayapu Brew Hause", "Dirección: José M. Infante 631, 1580000 Copiapó, Atacama",2));
        lst.add(new locales(3,R.drawable.perfil,"Fraga", "Dirección:Alameda 281, Copiapó, Atacama",2));
        lst.add(new locales(4,R.drawable.perfil,"KAYA Social Club", "Dirección: Atacama 10, Copiapó, Atacama",2));
        lst.add(new locales(1,R.drawable.perfil,"Club Copacabana Pub DISCOTKE", "Dirección: Maipú 279, 1530642 Copiapó, Atacama",2));

        return lst;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Incorporar el menú en la actividad
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.op1) {
            Toast.makeText(this, "Vas a la info", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }


}
