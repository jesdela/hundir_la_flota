package com.jldes.hundir_la_flota2;

import java.io.BufferedReader;
import java.io.FileReader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class JugarActivity extends Activity {
	String turno="0";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jugar);
        
        Button nueva = (Button)findViewById(R.id.nueva_partida);
        
        nueva.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
			Intent intent = new Intent(JugarActivity.this, CrearTableroJugadorActivity.class);	
			startActivity(intent);
			finish();
			}
		});
        
        Button continuar = (Button)findViewById(R.id.continuar);
        SharedPreferences prefs =
       	     getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);
       if (prefs.getBoolean("continuar", false)) {
       	continuar.setEnabled(true);
		} else {
       	continuar.setEnabled(false);
		}
        continuar.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				leerficheroturno();
				if(turno.equals("0")){
					Intent turnojug = new Intent(JugarActivity.this, JuegaJugadorActivity.class);	
					startActivity(turnojug);	
					finish();
				}else{
					Intent turnocpu = new Intent(JugarActivity.this, JuegaCpuActivity.class);	
					startActivity(turnocpu);
					finish();
				}
		
			}
		});
    
    }
    public void leerficheroturno() {
    	BufferedReader fichturno;
    	try {
    		fichturno = new BufferedReader(new FileReader(
    				getFilesDir()+"/turno.txt"));
    		turno=fichturno.readLine();
    		
    	
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
	}    
    public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}
    public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.nueva_partida:
			startActivity(new Intent(this, CrearTableroJugadorActivity.class));
			finish();
			return true;
		
		case R.id.ayuda:
			startActivity(new Intent(this, AyudaActivity.class));
			return true;
		}
    	return false;
	}
}