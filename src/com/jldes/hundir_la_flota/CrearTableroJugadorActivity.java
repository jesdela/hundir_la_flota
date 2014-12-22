package com.jldes.hundir_la_flota;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CrearTableroJugadorActivity extends Activity {
	static int i;
	Button casilla[][] = new Button[6][6];
	ArrayList<Casilla> arrayList = new ArrayList<Casilla>();
	int fila, columna;
	protected boolean seguir1 = false;
	protected boolean seguir3 = false;
	protected boolean seguir2 = false;
	Button continuar; 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.crear_partida);
		final Button boton1 = (Button) findViewById(R.id.b1);
		final Button boton2 = (Button) findViewById(R.id.b2);
		final Button boton3 = (Button) findViewById(R.id.b3);
		continuar= (Button) findViewById(R.id.Continuar);
		final TextView texto1 = (TextView) findViewById(R.id.Barco1);
		final TextView texto2 = (TextView) findViewById(R.id.Barco2);
		final TextView texto3 = (TextView) findViewById(R.id.Barco3);
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
		for (fila = 0; fila < 6; fila++) {
			for (columna = 0; columna < 6; columna++) {
				casilla[columna][fila].setEnabled(false);
			}
		}
		continuar.setEnabled(false);

		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				for (int k = 0; k < 3; k++) {
					Tablero.tablcpu[i][j][k] = 0;
					Tablero.tabljug[i][j][k] = 0;
				}
			}
		}
		boton1.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				clickable();
				i = 1;
				creartablero(1, 1);
				String x1 = (String) texto1.getText();
				int a = Integer.parseInt(x1);
				a = a - 1;

				texto1.setText("" + a + "");

				if (a < 1) {
					v.setEnabled(false);
					seguir1 = true;
				}

			}
		});

		boton2.setOnClickListener(new OnClickListener() {

			public void onClick(View w) {
				clickable();
				i = 1;
				creartablero(2, 1);
				String x2 = (String) texto2.getText();
				int b = Integer.parseInt(x2);
				b = b - 1;
				texto2.setText("" + b + "");
				if (b < 1) {
					w.setEnabled(false);
					seguir2 = true;
				}
			}
		});

		boton3.setOnClickListener(new OnClickListener() {

			public void onClick(View z) {
				clickable();
				i = 1;
				creartablero(3, 1);
				String x3 = (String) texto3.getText();
				int c = Integer.parseInt(x3);
				c = c - 1;
				texto3.setText("" + c + "");
				if (c < 1) {
					z.setEnabled(false);
					seguir3 = true;
				}
			}
		});

		continuar.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				CrearTableroCpu.tableroCpu();
				Toast toast = Toast
						.makeText(
								getApplicationContext(),
								"La CPU está creando su tablero. \n		Espere por favor... ",
								Toast.LENGTH_LONG);
				toast.show();
				SharedPreferences prefs = getSharedPreferences(
						"MisPreferencias", Context.MODE_PRIVATE);
				SharedPreferences.Editor editor = prefs.edit();
				editor.putBoolean("continuar", true);
				editor.commit();
				toast.show();
				Intent b = new Intent(CrearTableroJugadorActivity.this,
						JuegaJugadorActivity.class);
				startActivity(b);
				finish();
			}
		});

	}

	@Override
	protected void onPause() {
		super.onPause();
		BufferedWriter fichtablcpu, fichtabljug;
		int fil, col, pos;
		try {
			fichtablcpu = new BufferedWriter(new FileWriter(getFilesDir()
					+ "/tablcpu.txt"));
			for (fil = 3; fil < 9; fil++) {
				for (col = 3; col < 9; col++) {
					for (pos = 0; pos < 3; pos++) {
						String numero = "" + Tablero.tablcpu[fil][col][pos];
						fichtablcpu.write((String) numero);
					}
					fichtablcpu.newLine();
				}
			}
			String a = "6";
			fichtablcpu.write((String) a);
			fichtablcpu.newLine();
			a = "3";
			fichtablcpu.write((String) a);
			fichtablcpu.newLine();
			a = "2";
			fichtablcpu.write((String) a);
			fichtablcpu.newLine();
			a = "1";
			fichtablcpu.write((String) a);
			fichtablcpu.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			fichtabljug = new BufferedWriter(new FileWriter(getFilesDir()
					+ "/tabljug.txt"));
			for (fil = 3; fil < 9; fil++) {
				for (col = 3; col < 9; col++) {
					for (pos = 0; pos < 3; pos++) {
						String numero = "" + Tablero.tabljug[fil][col][pos];
						fichtabljug.write((String) numero);
					}
					fichtabljug.newLine();
				}
			}
			String a = "6";
			fichtabljug.write("6");
			fichtabljug.newLine();
			a = "3";
			fichtabljug.write((String) a);
			fichtabljug.newLine();
			a = "2";
			fichtabljug.write((String) a);
			fichtabljug.newLine();
			a = "1";
			fichtabljug.write((String) a);
			for (int i = 0; i < 4; i++) {
				fichtabljug.newLine();
				fichtabljug.write("0");
			}
			fichtabljug.newLine();
			fichtabljug.write("1");
			fichtabljug.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void creartablero(final int numb, final int estado) {
		for (columna = 0; columna < 6; columna++) {
			for (fila = 0; fila < 6; fila++) {
				casilla[columna][fila].setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						// TODO Auto-generated method stub
						v.setBackgroundResource(R.drawable.radar);
						Casilla posicion = new Casilla();
						posicion.barco=numb;
						for (int columna2 = 0; columna2 < 6; columna2++) {
							for (int fila2 = 0; fila2 < 6; fila2++) {
								if(casilla[columna2][fila2].equals(v)){
									Tablero.tabljug[columna2 + 3][fila2 + 3][0] = 1;
									Tablero.tabljug[columna2 + 3][fila2 + 3][2] = numb;
									posicion.x=columna2;
									posicion.y=fila2;
								}
							}
						}
						arrayList.add(posicion);
						for (int columna2 = 0; columna2 < 6; columna2++) {
							for (int fila2 = 0; fila2 < 6; fila2++) {
								Log.d("Prueba", "posicion "+columna2+" "+fila2);
								casilla[columna2][fila2].setEnabled(false);
							}
						}
						if (estado==numb) {
							if (seguir1 && seguir2 && seguir3) {
								continuar.setEnabled(true);
							} else {
								clickable();
							}
						} else {
							creartablero(numb, estado+1);
						}
						
					}
				});
			}
		}
		Log.d("Prueba", ""+estado);
		switch (estado) {
		case 1:
			for (columna = 0; columna < 6; columna++) {
				for (fila = 0; fila < 6; fila++) {
					casilla[columna][fila].setEnabled(true);
				}
			}

			for (Casilla posicion : arrayList) {
				casilla[posicion.x][posicion.y].setEnabled(false);
				if (posicion.x > 0) {
					casilla[posicion.x - 1][posicion.y].setEnabled(false);
				}
				if (posicion.y > 0) {
					casilla[posicion.x][posicion.y - 1].setEnabled(false);
				}
				if (posicion.x < 5) {
					casilla[posicion.x + 1][posicion.y].setEnabled(false);
				}
				if (posicion.y < 5) {
					casilla[posicion.x][posicion.y + 1].setEnabled(false);
				}
			}
			break;

		case 2:
			if (arrayList.get(arrayList.size() - 1).x > 0) {
				casilla[arrayList.get(arrayList.size() - 1).x - 1][arrayList
						.get(arrayList.size() - 1).y].setEnabled(true);
			}
			if (arrayList.get(arrayList.size() - 1).y > 0) {
				casilla[arrayList.get(arrayList.size() - 1).x][arrayList
						.get(arrayList.size() - 1).y - 1].setEnabled(true);
			}
			if (arrayList.get(arrayList.size() - 1).x < 5) {
				casilla[arrayList.get(arrayList.size() - 1).x + 1][arrayList
						.get(arrayList.size() - 1).y].setEnabled(true);
			}
			if (arrayList.get(arrayList.size() - 1).y < 5) {
				casilla[arrayList.get(arrayList.size() - 1).x][arrayList
						.get(arrayList.size() - 1).y + 1].setEnabled(true);
			}
			ArrayList<Casilla> arrayList2 = new ArrayList<Casilla>();
			for (Casilla posicion : arrayList) {
				arrayList2.add(posicion);
			}
			arrayList2.remove(arrayList2.size() - 1);
			for (Casilla posicion : arrayList2) {
				casilla[posicion.x][posicion.y].setEnabled(false);
				if (posicion.x > 0) {
					casilla[posicion.x - 1][posicion.y].setEnabled(false);
				}
				if (posicion.y > 0) {
					casilla[posicion.x][posicion.y - 1].setEnabled(false);
				}
				if (posicion.x < 5) {
					casilla[posicion.x + 1][posicion.y].setEnabled(false);
				}
				if (posicion.y < 5) {
					casilla[posicion.x][posicion.y + 1].setEnabled(false);
				}
			}
			arrayList2.clear();
			break;
		case 3:
			Log.d("Prueba", "size "+arrayList.size());
			if (((0 <= ((2 * arrayList.get(arrayList.size() - 1).x) - arrayList
					.get(arrayList.size() - 2).x)) && (((2 * arrayList
					.get(arrayList.size() - 1).x) - arrayList.get(arrayList
					.size() - 2).x) <= 5))
					&& ((0 < ((2 * arrayList.get(arrayList.size() - 1).y) - arrayList
							.get(arrayList.size() - 2).y)) && (((2 * arrayList
							.get(arrayList.size() - 1).y) - arrayList
							.get(arrayList.size() - 2).y) <= 5))) {
				casilla[(2 * arrayList.get(arrayList.size() - 1).x) - arrayList
						.get(arrayList.size() - 2).x][(2 * arrayList.get(arrayList.size() - 1).y) - arrayList
						  							.get(arrayList.size() - 2).y].setEnabled(true);
			}
			if (((0 <= ((2 * arrayList.get(arrayList.size() - 2).x) - arrayList
					.get(arrayList.size() - 1).x)) && (((2 * arrayList
					.get(arrayList.size() - 2).x) - arrayList.get(arrayList
					.size() - 1).x) <= 5))
					&& ((0 <= ((2 * arrayList.get(arrayList.size() - 2).y) - arrayList
							.get(arrayList.size() - 1).y)) && (((2 * arrayList
							.get(arrayList.size() - 2).y) - arrayList
							.get(arrayList.size() - 1).y) <= 5))) {
				casilla[(2 * arrayList.get(arrayList.size() - 2).x) - arrayList
						.get(arrayList.size() - 1).x][(2 * arrayList.get(arrayList.size() - 2).y) - arrayList
						  							.get(arrayList.size() - 1).y].setEnabled(true);
			}

			ArrayList<Casilla> arrayList3 = new ArrayList<Casilla>();
			for (Casilla posicion : arrayList) {
				arrayList3.add(posicion);
			}
			arrayList3.remove(arrayList3.size() - 1);
			arrayList3.remove(arrayList3.size() - 1);
			for (Casilla posicion : arrayList3) {
				casilla[posicion.x][posicion.y].setEnabled(false);
				if (posicion.x > 0) {
					casilla[posicion.x - 1][posicion.y].setEnabled(false);
				}
				if (posicion.y > 0) {
					casilla[posicion.x][posicion.y - 1].setEnabled(false);
				}
				if (posicion.x < 5) {
					casilla[posicion.x + 1][posicion.y].setEnabled(false);
				}
				if (posicion.y < 5) {
					casilla[posicion.x][posicion.y + 1].setEnabled(false);
				}
			}
			arrayList3.clear();
			break;
		}
	}

	public void clickable() {

		Button boton1 = (Button) findViewById(R.id.b1);
		Button boton2 = (Button) findViewById(R.id.b2);
		Button boton3 = (Button) findViewById(R.id.b3);
		if (boton1.isClickable() == false) {
			boton1.setClickable(true);
			boton2.setClickable(true);
			boton3.setClickable(true);
		} else {
			boton1.setClickable(false);
			boton2.setClickable(false);
			boton3.setClickable(false);
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
