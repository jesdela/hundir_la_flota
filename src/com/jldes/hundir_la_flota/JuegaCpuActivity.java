package com.jldes.hundir_la_flota;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.jldes.hundir_la_flota.R;

public class JuegaCpuActivity extends Activity {
	int x, y, sigposx, sigposy, ultimapos, numbarcosjug, estado;
	Random r = new Random();
	boolean confirm = false;

	public void LeerFichero() {
		final Button casilla[][] = new Button[6][6];
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
		TextView numbarcos1 = (TextView) findViewById(R.id.Barco1);
		TextView numbarcos2 = (TextView) findViewById(R.id.Barco2);
		TextView numbarcos3 = (TextView) findViewById(R.id.Barco3);
		BufferedReader fichtabljug;
		String linea;
		int fil, col;
		int numero, pos1, pos2, pos3;
		try {
			fichtabljug = new BufferedReader(new FileReader(getFilesDir()
					+ "/tabljug.txt"));
			for (fil = 3; fil < 9; fil++) {
				for (col = 3; col < 9; col++) {
					linea = fichtabljug.readLine(); // leemos la linea del
													// fichero para
					// introducir los valores en la tabla
					numero = Integer.parseInt(linea); // lo convertimos a un
														// valor entero para
														// descomponerlo en lo
														// tres
														// valores de la tabla
					pos1 = numero / 100; // obtengo el valor de
											// Tablero.tabljug[fil][col][0]
					pos2 = (numero - 100 * pos1) / 10; // obtengo el valor de
														// Tablero.tabljug[fil][col][1]
					pos3 = (numero - pos1 * 100 - pos2 * 10);// obtengo el valor
																// de
																// Tablero.tabljug[fil][col][2]
					Tablero.tabljug[fil][col][0] = pos1;
					Tablero.tabljug[fil][col][1] = pos2;
					Tablero.tabljug[fil][col][2] = pos3;
				}
			}
			numbarcosjug = Integer.parseInt(fichtabljug.readLine()); // guardamos
																		// el nº
																		// de
																		// barcos
																		// que
																		// quedan
			numbarcos1.setText(fichtabljug.readLine()); // guardamos el nº de
														// barcos que quedan de
														// tamaño 1
			numbarcos2.setText(fichtabljug.readLine()); // guardamos el nº de
														// barcos que quedan de
														// tamaño 2
			numbarcos3.setText(fichtabljug.readLine()); // guardamos el nº de
														// barcos que quedan de
														// tamaño 3
			x = Integer.parseInt(fichtabljug.readLine()); // guardamos el nº de
															// fila de la
															// primera posicion
			y = Integer.parseInt(fichtabljug.readLine()); // guardamos el nº de
															// columna de la
															// primera posicion
			sigposx = Integer.parseInt(fichtabljug.readLine()); // guardamos el
																// nº de fila de
																// la segunda
																// posicion
			sigposy = Integer.parseInt(fichtabljug.readLine()); // guardamos el
																// nº de columna
																// de la segunda
																// posicion
			Tablero.situacion = Integer.parseInt(fichtabljug.readLine()); // guardamos
																			// el
																			// nº
																			// de
																			// la
																			// situacion
																			// en
																			// la
																			// que
																			// nos
																			// encontramos

		} catch (Exception e) {
			e.printStackTrace();
		}
		for (fil = 3; fil < 9; fil++) {
			for (col = 3; col < 9; col++) {
				if (Tablero.tabljug[fil][col][1] != 0) { // ha sido llamado
					casilla[fil - 3][col - 3].setEnabled(false); // no dejamos
																	// que
																	// vuelva a
																	// pulsarse
					switch (Tablero.tabljug[fil][col][1]) { // modificamos el
															// texto de los
															// botones pulsados
					case 1:
						casilla[fil - 3][col - 3].setText("A");
						break;
					case 2:
						casilla[fil - 3][col - 3].setText("T");
						break;
					case 3:
						casilla[fil - 3][col - 3].setText("H");
						break;
					}
				}
			}
		}
		confirm = true;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tablero_cpu);
		View cont = (View) findViewById(R.id.continuar);
		BufferedWriter fichero;
		try {
			fichero = new BufferedWriter(new FileWriter(getFilesDir()
					+ "/turno.txt"));
			fichero.write("1");
			fichero.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		cont.setClickable(false);
		LeerFichero();
		while (!confirm) {
		}
		switch (Tablero.situacion) {
		case 1:
			Jugar();
			break;
		case 2:
			SigPos();
			break;
		case 3:
			SigPos2();
			break;
		}

	}

	public void Jugar() {
		final Button casilla[][] = new Button[6][6];
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
		final TextView texto = (TextView) findViewById(R.id.estado2);
		do { // CPU elige dos valores aleatorios para elegir posición
			x = r.nextInt(6) + 3;
			y = r.nextInt(6) + 3;
		} while (Tablero.tabljug[x][y][1] != 0); // que no haya sido elegido ya
													// antes
		casilla[x - 3][y - 3].setEnabled(false); // desmarcamos la casilla
		Tablero.situacion = 1; // necesitamos que valga 1 para despues llamar al
								// procedimiento continuar
								// y saber que estabamos en el procedimiento
								// jugar
		if (Tablero.tabljug[x][y][0] == 0) { // si es agua
			texto.setText(/* "La CPU ha elegido: "+x+y+ ". */"Agua ");
			Tablero.tabljug[x][y][1] = 1; // ha sido llamado y es agua
			casilla[x - 3][y - 3].setText("A");
			estado = 1; // para saber en continuar que ha sido agua
			continuar();
		} else { // si es tocado
			switch (Tablero.tabljug[x][y][2]) {
			case 1: // si el barco es de longitud 1
				casilla[x - 3][y - 3].setText("H");
				Tablero.tabljug[x][y][1] = 3; // ha sido llamado y es tocado y
												// hundido
				Hundido();
				break;

			default: // el barco es de longitud 2 ó 3
				casilla[x - 3][y - 3].setText("T");
				Tablero.tabljug[x][y][1] = 2; // ha sido llamado y es tocado
				Tocado();
				break;
			}
		}
	}

	public void Hundido() {
		final TextView texto = (TextView) findViewById(R.id.estado2);
		texto.setText(/* "La CPU ha elegido: "+x+y+ ". */"Tocado y ¡¡¡HUNDIDO!!!");
		numbarcosjug--;
		switch (Tablero.tabljug[x][y][2]) {
		case 1:
			TextView numbarcos1 = (TextView) findViewById(R.id.Barco1);
			int num1 = Integer.parseInt((String) numbarcos1.getText());
			num1--;
			numbarcos1.setText("" + num1 + "");
			break;
		case 2:
			TextView numbarcos2 = (TextView) findViewById(R.id.Barco2);
			int num2 = Integer.parseInt((String) numbarcos2.getText());
			num2--;
			numbarcos2.setText("" + num2 + "");
			break;
		case 3:
			TextView numbarcos3 = (TextView) findViewById(R.id.Barco3);
			int num3 = Integer.parseInt((String) numbarcos3.getText());
			num3--;
			numbarcos3.setText("" + num3 + "");
			break;
		}
		estado = 3; // para saber en continuar que ha sido hundido
		continuar();
	}

	public void Tocado() {
		final TextView texto = (TextView) findViewById(R.id.estado2);
		texto.setText(/* "La CPU ha elegido: "+x+y+ ". */"¡Tocado!");
		estado = 2; // para saber en continuar que ha sido tocado
		continuar();
		return;
	}

	public void SigPos() {
		final Button casilla[][] = new Button[6][6];
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
		final TextView texto = (TextView) findViewById(R.id.estado2);
		do { // CPU elige otro valor aleatorio alrededor de la casilla del barco
				// tocado
			sigposx = r.nextInt(3) - 1;
			switch (sigposx) {
			case -1:
				sigposy = 0;
				break;
			case 0:
				do {
					sigposy = r.nextInt(3) - 1;
				} while (sigposy == 0);
				break;
			case 1:
				sigposy = 0;
				break;
			}
		} while ((Tablero.tabljug[x + sigposx][y + sigposy][1] != 0)
				|| ((x + sigposx) > 8) || ((y + sigposy) > 8)
				|| ((x + sigposx) < 3) || ((y + sigposy) < 3)); // que no haya
																// sido elegido
																// ya antes y
																// esté dentro
																// del tablero
		casilla[(x + sigposx) - 3][(y + sigposy) - 3].setEnabled(false); // desmarcamos
																			// la
																			// casilla
																			// que
																			// elige
		Tablero.situacion = 2; // necesitamos que valga 2 para despues llamar al
								// procedimiento continuar
		// y saber que estabamos en el procedimiento SigPos
		// o para que en el proximo turno vuelva a este procedimiento
		// si no hundio el barco
		if (Tablero.tabljug[x + sigposx][y + sigposy][0] == 0) { // es agua
			texto.setText(/* "La CPU ha elegido: "+x+y+ ". */"Agua");
			Tablero.tabljug[x + sigposx][y + sigposy][1] = 1; // ha sido llamado
																// y es agua
			casilla[(x + sigposx) - 3][(y + sigposy) - 3].setText("A");
			estado = 1;
			continuar();
		} else { // tocado
			switch (Tablero.tabljug[x][y][2]) {
			case 2: // el barco es de longitud 2
				casilla[x - 3][y - 3].setText("H");
				casilla[(x + sigposx) - 3][(y + sigposy) - 3].setText("H");
				Tablero.tabljug[x][y][1] = 3; // ha sido llamado y es hundido
				Tablero.tabljug[x + sigposx][y + sigposy][1] = 3; // ha sido
																	// llamado y
																	// es
																	// hundido
				Hundido();
				break;

			default: // el barco es de longitud 3
				casilla[(x + sigposx) - 3][(y + sigposy) - 3].setText("T");
				Tablero.tabljug[x + sigposx][y + sigposy][1] = 2;// ha sido
																	// llamado y
																	// es tocado
				Tocado();
				break;
			}
		}
	}

	public void SigPos2() {
		final Button casilla[][] = new Button[6][6];
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
		final TextView texto = (TextView) findViewById(R.id.estado2);
		do {
			do { // CPU elige otro valor aleatorio
				ultimapos = r.nextInt(4) - 1;
			} while ((ultimapos != -1) && (ultimapos != 2)); // si c=2 mira la
																// siguiente
																// posicion a la
																// ultima
																// posicion
																// tocada
																// si c=-1 mira
																// la anterior
																// posicion a la
																// primera
																// posicion
																// tocada
		} while (Tablero.tabljug[x + sigposx * ultimapos][y + sigposy
				* ultimapos][1] != 0
				|| (x + sigposx * ultimapos) < 3
				|| (y + sigposy * ultimapos) < 3
				|| (x + sigposx * ultimapos) > 8
				|| (y + sigposy * ultimapos) > 8); // no queremos que haya sido
													// elegida antes
													// y que esté dentro del
													// tablero
		casilla[x + sigposx * ultimapos - 3][y + sigposy * ultimapos - 3]
				.setEnabled(false); // desmarcamos la casilla
		Tablero.situacion = 3; // necesitamos que valga 3 para despues llamar al
								// procedimiento continuar
		// y saber que estabamos en el procedimiento SigPos2
		// o para que en el proximo turno vuelva a este procedimiento
		// si no hundio el barco
		if (Tablero.tabljug[x + sigposx * ultimapos][y + sigposy * ultimapos][0] == 0) { // es
																							// agua
			texto.setText(/*
						 * "La CPU ha elegido: "+(x+sigposx*ultimapos)+(y+sigposy
						 * *ultimapos)+ ".
						 */"Agua");
			casilla[(x + sigposx * ultimapos) - 3][(y + sigposy * ultimapos) - 3]
					.setText("A");
			Tablero.tabljug[x + sigposx * ultimapos][y + sigposy * ultimapos][1] = 1;
			estado = 1;
			continuar();
		} else { // es tocado y hundido
			casilla[x - 3][y - 3].setText("H");
			casilla[(x + sigposx) - 3][(y + sigposy) - 3].setText("H");
			casilla[(x + sigposx * ultimapos) - 3][(y + sigposy * ultimapos) - 3]
					.setText("H");
			Tablero.tabljug[x][y][1] = 3;// ha sido llamado y es hundido
			Tablero.tabljug[x + sigposx][y + sigposy][1] = 3;// ha sido llamado
																// y es hundido
			Tablero.tabljug[x + sigposx * ultimapos][y + sigposy * ultimapos][1] = 3;// ha
																						// sido
																						// llamado
																						// y
																						// es
																						// hundido
			Hundido();
		}
	}

	public void continuar() {// espera a que el jugador seleccione continuar
								// para seguir con la partida
		final Button cont = (Button) findViewById(R.id.continuar);
		cont.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				cont.setClickable(false);
				switch (estado) {
				case 1: // ha sido agua
					Escribirfichero();
					Intent irajuegajug = new Intent(JuegaCpuActivity.this,
							JuegaJugadorActivity.class);
					startActivity(irajuegajug);
					finish();
					break;

				case 2: // ha sido tocado
					switch (Tablero.situacion) {
					case 1: // vengo de Jugar
						SigPos();
						break;

					case 2: // vengo de SigPos()
						SigPos2();
						break;
					}
					break;

				case 3: // ha sido hundido
					if (numbarcosjug == 0) {
						Toast toast = Toast.makeText(getApplicationContext(),
								"¡HAS PERDIDO!", Toast.LENGTH_LONG);
						toast.show();
						Intent irahundir = new Intent(JuegaCpuActivity.this,
								HundirLaFlotaActivity.class);
						startActivity(irahundir);
						finish();
					} else {
						Jugar();
					}
					break;
				}
			}
		});
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

	public void Escribirfichero() {
		TextView numbarcos1 = (TextView) findViewById(R.id.Barco1);
		TextView numbarcos2 = (TextView) findViewById(R.id.Barco2);
		TextView numbarcos3 = (TextView) findViewById(R.id.Barco3);
		View cont = (View) findViewById(R.id.continuar);
		int fil, col, pos;
		String a;
		BufferedWriter fichero;
		try {
			fichero = new BufferedWriter(new FileWriter(getFilesDir()
					+ "/tabljug.txt"));
			for (fil = 3; fil < 9; fil++) {
				for (col = 3; col < 9; col++) {
					for (pos = 0; pos < 3; pos++) {
						String numero = "" + Tablero.tabljug[fil][col][pos];
						fichero.write((String) numero); // escribimos los
														// valores de la tabla
														// en el fichero
					}
					fichero.newLine();
				}
			}
			a = "" + numbarcosjug;
			fichero.write((String) a);
			fichero.newLine();
			fichero.write((String) numbarcos1.getText());
			fichero.newLine();
			fichero.write((String) numbarcos2.getText());
			fichero.newLine();
			fichero.write((String) numbarcos3.getText());
			fichero.newLine();
			a = "" + x;
			fichero.write((String) a);
			fichero.newLine();
			a = "" + y;
			fichero.write((String) a);
			fichero.newLine();
			a = "" + sigposx;
			fichero.write((String) a);
			fichero.newLine();
			a = "" + sigposy;
			fichero.write((String) a);
			fichero.newLine();
			a = "" + Tablero.situacion;
			fichero.write((String) a);
			fichero.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		cont.setClickable(true);
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {

			showDialog(0);
			return true;
		} else {
			return super.onKeyDown(keyCode, event);
		}

	}

	protected Dialog onCreateDialog(int id) {
		Dialog dialog;
		switch (id) {
		case 0:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("¿Está seguro que quiere salir?")
					.setCancelable(false)
					.setPositiveButton("Sí",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									startActivity(new Intent(
											JuegaCpuActivity.this,
											HundirLaFlotaActivity.class));
									finish();
								}
							})
					.setNegativeButton("No",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									dialog.cancel();
								}
							});
			dialog = builder.create();
			break;
		default:
			dialog = null;
			break;
		}
		return dialog;
	}

}
