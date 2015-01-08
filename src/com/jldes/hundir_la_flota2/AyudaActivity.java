package com.jldes.hundir_la_flota2;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

import com.jldes.hundir_la_flota2.R;

public class AyudaActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ayuda);
		// Distribuimos los elementos por pestañas
		Resources res = getResources();
		// Contenedor principal del conjunto de pestañas
		TabHost tabs = (TabHost) findViewById(android.R.id.tabhost);
		tabs.setup();

		TabHost.TabSpec spec = tabs.newTabSpec("tabjuego");
		spec.setContent(R.id.Juego); // Pestaña Juego
		spec.setIndicator("JUEGO",
				res.getDrawable(android.R.drawable.ic_media_play));
		tabs.addTab(spec);

		spec = tabs.newTabSpec("tabinstrucciones");
		spec.setContent(R.id.Normas); // Pestaña Instrucciones
		spec.setIndicator("INSTRUCCIONES",
				res.getDrawable(android.R.drawable.ic_menu_agenda));
		tabs.addTab(spec);

		tabs.setCurrentTab(0);
	}
}