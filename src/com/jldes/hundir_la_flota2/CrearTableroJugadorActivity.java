package com.jldes.hundir_la_flota2;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Button;
import android.widget.TextView;

public class CrearTableroJugadorActivity extends Activity {
	Button boton1;
	Button boton2;
	Button boton3;
	Button continuar;
	TextView num_barcos1;
	TextView num_barcos2;
	TextView num_barcos3;
	ArrayList<Barco> barcos = new ArrayList<Barco>();
	Button casilla[][] = new Button[6][6];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.crear_partida);
		boton1 = (Button)findViewById(R.id.b1);
		boton2 = (Button)findViewById(R.id.b2);
		boton3 = (Button)findViewById(R.id.b3);
		continuar = (Button)findViewById(R.id.continuar);
		continuar.setEnabled(false);
		num_barcos1 = (TextView) findViewById(R.id.Barco1);
		num_barcos2 = (TextView) findViewById(R.id.Barco2);
		num_barcos3 = (TextView) findViewById(R.id.Barco3);

		casilla[0][0] = (Button) findViewById(R.id.ButtonA1);
		casilla[0][1] = (Button) findViewById(R.id.ButtonB1);
		casilla[0][2] = (Button) findViewById(R.id.ButtonC1);
		casilla[0][3] = (Button) findViewById(R.id.ButtonD1);
		casilla[0][4] = (Button) findViewById(R.id.ButtonE1);
		casilla[0][5] = (Button) findViewById(R.id.ButtonF1);
		casilla[1][0] = (Button) findViewById(R.id.ButtonA2);
		casilla[1][1] = (Button) findViewById(R.id.ButtonB2);
		casilla[1][2] = (Button) findViewById(R.id.ButtonC2);
		casilla[1][3] = (Button) findViewById(R.id.ButtonD2);
		casilla[1][4] = (Button) findViewById(R.id.ButtonE2);
		casilla[1][5] = (Button) findViewById(R.id.ButtonF2);
		casilla[2][0] = (Button) findViewById(R.id.ButtonA3);
		casilla[2][1] = (Button) findViewById(R.id.ButtonB3);
		casilla[2][2] = (Button) findViewById(R.id.ButtonC3);
		casilla[2][3] = (Button) findViewById(R.id.ButtonD3);
		casilla[2][4] = (Button) findViewById(R.id.ButtonE3);
		casilla[2][5] = (Button) findViewById(R.id.ButtonF3);
		casilla[3][0] = (Button) findViewById(R.id.ButtonA4);
		casilla[3][1] = (Button) findViewById(R.id.ButtonB4);
		casilla[3][2] = (Button) findViewById(R.id.ButtonC4);
		casilla[3][3] = (Button) findViewById(R.id.ButtonD4);
		casilla[3][4] = (Button) findViewById(R.id.ButtonE4);
		casilla[3][5] = (Button) findViewById(R.id.ButtonF4);
		casilla[4][0] = (Button) findViewById(R.id.ButtonA5);
		casilla[4][1] = (Button) findViewById(R.id.ButtonB5);
		casilla[4][2] = (Button) findViewById(R.id.ButtonC5);
		casilla[4][3] = (Button) findViewById(R.id.ButtonD5);
		casilla[4][4] = (Button) findViewById(R.id.ButtonE5);
		casilla[4][5] = (Button) findViewById(R.id.ButtonF5);
		casilla[5][0] = (Button) findViewById(R.id.ButtonA6);
		casilla[5][1] = (Button) findViewById(R.id.ButtonB6);
		casilla[5][2] = (Button) findViewById(R.id.ButtonC6);
		casilla[5][3] = (Button) findViewById(R.id.ButtonD6);
		casilla[5][4] = (Button) findViewById(R.id.ButtonE6);
		casilla[5][5] = (Button) findViewById(R.id.ButtonF6);
		for (Button[] buttons : casilla) {
			for (Button button : buttons) {
				button.setEnabled(false);
			}
		}
	}
}
