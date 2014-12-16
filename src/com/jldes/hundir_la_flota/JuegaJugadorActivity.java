package com.jldes.hundir_la_flota;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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

public class JuegaJugadorActivity extends Activity {
	int barcos;	
    @Override
    protected void onResume() {
    	super.onResume();
    	final Button casilla[][] = new Button[6][6]; //
		casilla[0][0]=(Button)findViewById(R.id.ButtonA1);
		casilla[0][1]=(Button)findViewById(R.id.ButtonB1);
		casilla[0][2]=(Button)findViewById(R.id.ButtonC1);
		casilla[0][3]=(Button)findViewById(R.id.ButtonD1);
		casilla[0][4]=(Button)findViewById(R.id.ButtonE1);
		casilla[0][5]=(Button)findViewById(R.id.ButtonF1);
		casilla[1][0]=(Button)findViewById(R.id.ButtonA2);
		casilla[1][1]=(Button)findViewById(R.id.ButtonB2);
		casilla[1][2]=(Button)findViewById(R.id.ButtonC2);
		casilla[1][3]=(Button)findViewById(R.id.ButtonD2);
		casilla[1][4]=(Button)findViewById(R.id.ButtonE2);
		casilla[1][5]=(Button)findViewById(R.id.ButtonF2);
		casilla[2][0]=(Button)findViewById(R.id.ButtonA3);
		casilla[2][1]=(Button)findViewById(R.id.ButtonB3);
		casilla[2][2]=(Button)findViewById(R.id.ButtonC3);
		casilla[2][3]=(Button)findViewById(R.id.ButtonD3);
		casilla[2][4]=(Button)findViewById(R.id.ButtonE3);
		casilla[2][5]=(Button)findViewById(R.id.ButtonF3);
		casilla[3][0]=(Button)findViewById(R.id.ButtonA4);		
		casilla[3][1]=(Button)findViewById(R.id.ButtonB4);
		casilla[3][2]=(Button)findViewById(R.id.ButtonC4);
		casilla[3][3]=(Button)findViewById(R.id.ButtonD4);
		casilla[3][4]=(Button)findViewById(R.id.ButtonE4);
		casilla[3][5]=(Button)findViewById(R.id.ButtonF4);
		casilla[4][0]=(Button)findViewById(R.id.ButtonA5);
		casilla[4][1]=(Button)findViewById(R.id.ButtonB5);
		casilla[4][2]=(Button)findViewById(R.id.ButtonC5);
		casilla[4][3]=(Button)findViewById(R.id.ButtonD5);
		casilla[4][4]=(Button)findViewById(R.id.ButtonE5);
		casilla[4][5]=(Button)findViewById(R.id.ButtonF5);
		casilla[5][0]=(Button)findViewById(R.id.ButtonA6);
		casilla[5][1]=(Button)findViewById(R.id.ButtonB6);
		casilla[5][2]=(Button)findViewById(R.id.ButtonC6);
		casilla[5][3]=(Button)findViewById(R.id.ButtonD6);
		casilla[5][4]=(Button)findViewById(R.id.ButtonE6);
		casilla[5][5]=(Button)findViewById(R.id.ButtonF6);
    	int fil,col;
    	TextView x1 =(TextView)findViewById(R.id.Barco1);
    	TextView x2 =(TextView)findViewById(R.id.Barco2);
    	TextView x3 =(TextView)findViewById(R.id.Barco3);
    	BufferedReader fichero;
    	String linea;
    	int numero,a,b,c;
    	try {
    		fichero = new BufferedReader(new FileReader(
    				getFilesDir()+"/tablcpu.txt"));
    		for(fil=3;fil<9;fil++){
    			for(col=3;col<9;col++){
    				linea = fichero.readLine();
    				numero=Integer.parseInt(linea);
    				a= numero/100;
    				b= (numero-100*a)/10;
    				c= (numero-a*100-b*10);
    	    		Tablero.tablcpu[fil][col][0]=a;
    	    		Tablero.tablcpu[fil][col][1]=b;
    	    		Tablero.tablcpu[fil][col][2]=c;
        		}
    		}
    		barcos=Integer.parseInt(fichero.readLine());
    		x1.setText(fichero.readLine());
    		x2.setText(fichero.readLine());
    		x3.setText(fichero.readLine());
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	for(fil=3;fil<9;fil++){
			for(col=3;col<9;col++){
				if(Tablero.tablcpu[fil][col][1]==1){
					casilla[fil-3][col-3].setEnabled(false);
					switch (Tablero.tablcpu[fil][col][0]) {
					case 0:
						casilla[fil-3][col-3].setText("A");
						break;
					default:
						switch (Tablero.tablcpu[fil][col][2]) {
						case 1:
							casilla[fil-3][col-3].setText("H");
							break;
						case 2:
							if ((Tablero.tablcpu[fil+1][col][1]==1&&Tablero.tablcpu[fil+1][col][2]==2)||
									(Tablero.tablcpu[fil-1][col][1]==1&&Tablero.tablcpu[fil-1][col][2]==2)||
									(Tablero.tablcpu[fil][col+1][1]==1&&Tablero.tablcpu[fil][col+1][2]==2)||
									(Tablero.tablcpu[fil][col-1][1]==1&&Tablero.tablcpu[fil][col-1][2]==2)) {
								casilla[fil-3][col-3].setText("H");	
							} else {
								casilla[fil-3][col-3].setText("T");
							}
							break;
						case 3:
							if (((Tablero.tablcpu[fil+1][col][1]==1&&Tablero.tablcpu[fil-1][col][1]==1)&&
										(Tablero.tablcpu[fil+1][col][2]==3||Tablero.tablcpu[fil-1][col][2]==3))
									||(Tablero.tablcpu[fil+1][col][1]==1&&Tablero.tablcpu[fil+2][col][1]==1&&Tablero.tablcpu[fil+2][col][2]==3)
									||(Tablero.tablcpu[fil-1][col][1]==1&&Tablero.tablcpu[fil-2][col][1]==1&&Tablero.tablcpu[fil-2][col][2]==3)
									||((Tablero.tablcpu[fil][col+1][1]==1&&Tablero.tablcpu[fil][col-1][1]==1)&&
										(Tablero.tablcpu[fil][col+1][2]==3||Tablero.tablcpu[fil][col-1][2]==3))
									||(Tablero.tablcpu[fil][col+1][1]==1&&Tablero.tablcpu[fil][col+2][1]==1&&Tablero.tablcpu[fil][col+2][2]==3)
									||(Tablero.tablcpu[fil][col-1][1]==1&&Tablero.tablcpu[fil][col-2][1]==1&&Tablero.tablcpu[fil][col-2][2]==3)) {
								casilla[fil-3][col-3].setText("H");	
							} else {
								casilla[fil-3][col-3].setText("T");
							}
							break;
						}
						break;
					}
				}
			}
    	}
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jugar_partida);
        barcos=6;
        final Button cont = (Button)findViewById(R.id.continuar);
        final Button casilla[][] = new Button[6][6];
		casilla[0][0]=(Button)findViewById(R.id.ButtonA1);
		casilla[0][1]=(Button)findViewById(R.id.ButtonB1);
		casilla[0][2]=(Button)findViewById(R.id.ButtonC1);
		casilla[0][3]=(Button)findViewById(R.id.ButtonD1);
		casilla[0][4]=(Button)findViewById(R.id.ButtonE1);
		casilla[0][5]=(Button)findViewById(R.id.ButtonF1);
		casilla[1][0]=(Button)findViewById(R.id.ButtonA2);
		casilla[1][1]=(Button)findViewById(R.id.ButtonB2);
		casilla[1][2]=(Button)findViewById(R.id.ButtonC2);
		casilla[1][3]=(Button)findViewById(R.id.ButtonD2);
		casilla[1][4]=(Button)findViewById(R.id.ButtonE2);
		casilla[1][5]=(Button)findViewById(R.id.ButtonF2);
		casilla[2][0]=(Button)findViewById(R.id.ButtonA3);
		casilla[2][1]=(Button)findViewById(R.id.ButtonB3);
		casilla[2][2]=(Button)findViewById(R.id.ButtonC3);
		casilla[2][3]=(Button)findViewById(R.id.ButtonD3);
		casilla[2][4]=(Button)findViewById(R.id.ButtonE3);
		casilla[2][5]=(Button)findViewById(R.id.ButtonF3);
		casilla[3][0]=(Button)findViewById(R.id.ButtonA4);		
		casilla[3][1]=(Button)findViewById(R.id.ButtonB4);
		casilla[3][2]=(Button)findViewById(R.id.ButtonC4);
		casilla[3][3]=(Button)findViewById(R.id.ButtonD4);
		casilla[3][4]=(Button)findViewById(R.id.ButtonE4);
		casilla[3][5]=(Button)findViewById(R.id.ButtonF4);
		casilla[4][0]=(Button)findViewById(R.id.ButtonA5);
		casilla[4][1]=(Button)findViewById(R.id.ButtonB5);
		casilla[4][2]=(Button)findViewById(R.id.ButtonC5);
		casilla[4][3]=(Button)findViewById(R.id.ButtonD5);
		casilla[4][4]=(Button)findViewById(R.id.ButtonE5);
		casilla[4][5]=(Button)findViewById(R.id.ButtonF5);
		casilla[5][0]=(Button)findViewById(R.id.ButtonA6);
		casilla[5][1]=(Button)findViewById(R.id.ButtonB6);
		casilla[5][2]=(Button)findViewById(R.id.ButtonC6);
		casilla[5][3]=(Button)findViewById(R.id.ButtonD6);
		casilla[5][4]=(Button)findViewById(R.id.ButtonE6);
		casilla[5][5]=(Button)findViewById(R.id.ButtonF6);
		int fil;
		int col;
		cont.setEnabled(false);
		BufferedWriter fichturno;
		try {
		fichturno = new BufferedWriter(new FileWriter(
		getFilesDir()+"/turno.txt"));
		fichturno.write("0");
		fichturno.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		for (fil=0;fil<6;fil++)
		{
			for (col=0;col<6;col++)
			{
				final int fil2=fil+3;
				final int col2=col+3;

				casilla[fil][col].setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						Tablero.tablcpu[fil2][col2][1]=1;
						comprobar(fil2,col2);
						casilla[fil2-3][col2-3].setEnabled(false);
					}
				});
			}
		}
		
    
    }
    
    



    
    public void comprobar(final int x,final int y){
    	final TextView texto = (TextView)findViewById(R.id.estado);
    	final Button casilla[][] = new Button[6][6];
		casilla[0][0]=(Button)findViewById(R.id.ButtonA1);
		casilla[0][1]=(Button)findViewById(R.id.ButtonB1);
		casilla[0][2]=(Button)findViewById(R.id.ButtonC1);
		casilla[0][3]=(Button)findViewById(R.id.ButtonD1);
		casilla[0][4]=(Button)findViewById(R.id.ButtonE1);
		casilla[0][5]=(Button)findViewById(R.id.ButtonF1);
		casilla[1][0]=(Button)findViewById(R.id.ButtonA2);
		casilla[1][1]=(Button)findViewById(R.id.ButtonB2);
		casilla[1][2]=(Button)findViewById(R.id.ButtonC2);
		casilla[1][3]=(Button)findViewById(R.id.ButtonD2);
		casilla[1][4]=(Button)findViewById(R.id.ButtonE2);
		casilla[1][5]=(Button)findViewById(R.id.ButtonF2);
		casilla[2][0]=(Button)findViewById(R.id.ButtonA3);
		casilla[2][1]=(Button)findViewById(R.id.ButtonB3);
		casilla[2][2]=(Button)findViewById(R.id.ButtonC3);
		casilla[2][3]=(Button)findViewById(R.id.ButtonD3);
		casilla[2][4]=(Button)findViewById(R.id.ButtonE3);
		casilla[2][5]=(Button)findViewById(R.id.ButtonF3);
		casilla[3][0]=(Button)findViewById(R.id.ButtonA4);		
		casilla[3][1]=(Button)findViewById(R.id.ButtonB4);
		casilla[3][2]=(Button)findViewById(R.id.ButtonC4);
		casilla[3][3]=(Button)findViewById(R.id.ButtonD4);
		casilla[3][4]=(Button)findViewById(R.id.ButtonE4);
		casilla[3][5]=(Button)findViewById(R.id.ButtonF4);
		casilla[4][0]=(Button)findViewById(R.id.ButtonA5);
		casilla[4][1]=(Button)findViewById(R.id.ButtonB5);
		casilla[4][2]=(Button)findViewById(R.id.ButtonC5);
		casilla[4][3]=(Button)findViewById(R.id.ButtonD5);
		casilla[4][4]=(Button)findViewById(R.id.ButtonE5);
		casilla[4][5]=(Button)findViewById(R.id.ButtonF5);
		casilla[5][0]=(Button)findViewById(R.id.ButtonA6);
		casilla[5][1]=(Button)findViewById(R.id.ButtonB6);
		casilla[5][2]=(Button)findViewById(R.id.ButtonC6);
		casilla[5][3]=(Button)findViewById(R.id.ButtonD6);
		casilla[5][4]=(Button)findViewById(R.id.ButtonE6);
		casilla[5][5]=(Button)findViewById(R.id.ButtonF6);
    	final Button cont = (Button)findViewById(R.id.continuar);
    	Tablero.tablcpu[x][y][1]=1;
    	if (Tablero.tablcpu[x][y][0]==0){
    		   		
    		texto.setText("Agua");
    		casilla[x-3][y-3].setText("A");
    		for (int f=0;f<6;f++)
    		{
    			for (int c=0;c<6;c++)
    			{
    					casilla[f][c].setClickable(false);
    			}
    		}
    		do{
    		}while(casilla[x-3][y-3].getText()!="A");
    		cont.setEnabled(true);
    		cont.setOnClickListener(new OnClickListener() {
    			public void onClick(View v) {
    				cont.setEnabled(false);
    				Intent intent = new Intent(JuegaJugadorActivity.this, JuegaCpuActivity.class);	
    				startActivity(intent);
    				finish();
    			}
    		});
    	}else {
    		tocadoOhundido(x,y, texto);
    	}
    }    
    public void tocadoOhundido(int x,int y, TextView texto){
    	final Button casilla[][] = new Button[6][6];
		casilla[0][0]=(Button)findViewById(R.id.ButtonA1);
		casilla[0][1]=(Button)findViewById(R.id.ButtonB1);
		casilla[0][2]=(Button)findViewById(R.id.ButtonC1);
		casilla[0][3]=(Button)findViewById(R.id.ButtonD1);
		casilla[0][4]=(Button)findViewById(R.id.ButtonE1);
		casilla[0][5]=(Button)findViewById(R.id.ButtonF1);
		casilla[1][0]=(Button)findViewById(R.id.ButtonA2);
		casilla[1][1]=(Button)findViewById(R.id.ButtonB2);
		casilla[1][2]=(Button)findViewById(R.id.ButtonC2);
		casilla[1][3]=(Button)findViewById(R.id.ButtonD2);
		casilla[1][4]=(Button)findViewById(R.id.ButtonE2);
		casilla[1][5]=(Button)findViewById(R.id.ButtonF2);
		casilla[2][0]=(Button)findViewById(R.id.ButtonA3);
		casilla[2][1]=(Button)findViewById(R.id.ButtonB3);
		casilla[2][2]=(Button)findViewById(R.id.ButtonC3);
		casilla[2][3]=(Button)findViewById(R.id.ButtonD3);
		casilla[2][4]=(Button)findViewById(R.id.ButtonE3);
		casilla[2][5]=(Button)findViewById(R.id.ButtonF3);
		casilla[3][0]=(Button)findViewById(R.id.ButtonA4);		
		casilla[3][1]=(Button)findViewById(R.id.ButtonB4);
		casilla[3][2]=(Button)findViewById(R.id.ButtonC4);
		casilla[3][3]=(Button)findViewById(R.id.ButtonD4);
		casilla[3][4]=(Button)findViewById(R.id.ButtonE4);
		casilla[3][5]=(Button)findViewById(R.id.ButtonF4);
		casilla[4][0]=(Button)findViewById(R.id.ButtonA5);
		casilla[4][1]=(Button)findViewById(R.id.ButtonB5);
		casilla[4][2]=(Button)findViewById(R.id.ButtonC5);
		casilla[4][3]=(Button)findViewById(R.id.ButtonD5);
		casilla[4][4]=(Button)findViewById(R.id.ButtonE5);
		casilla[4][5]=(Button)findViewById(R.id.ButtonF5);
		casilla[5][0]=(Button)findViewById(R.id.ButtonA6);
		casilla[5][1]=(Button)findViewById(R.id.ButtonB6);
		casilla[5][2]=(Button)findViewById(R.id.ButtonC6);
		casilla[5][3]=(Button)findViewById(R.id.ButtonD6);
		casilla[5][4]=(Button)findViewById(R.id.ButtonE6);
		casilla[5][5]=(Button)findViewById(R.id.ButtonF6);
		int i=1;
		int tocado=0;    	
    	switch (Tablero.tablcpu[x][y][2]) {
    	case 1:
    		casilla[x-3][y-3].setText("H");
    		hundido(x,y);
    		break;
    	
    	case 2:
    	
    		if ((Tablero.tablcpu[x+1][y][1]==1 && Tablero.tablcpu[x+1][y][0]==1 )||(Tablero.tablcpu[x-1][y][1]==1 && Tablero.tablcpu[x-1][y][0]==1 )||(Tablero.tablcpu[x][y+1][1]==1 && Tablero.tablcpu[x][y+1][0]==1 )||(Tablero.tablcpu[x][y-1][1]==1 && Tablero.tablcpu[x][y-1][0]==1 )){
    			casilla[x-3][y-3].setText("H");
    			hundido(x,y);
    		} else {
				texto.setText("Tocado  "+Tablero.tablcpu[x][y][2]);
				casilla[x-3][y-3].setText("T");
			}
    		break;
    	
    	case 3:

    		while(i<3&&tocado==0) {
    			
    			if (((Tablero.tablcpu[x+i][y][0]==0 || Tablero.tablcpu[x+i][y][1]==0) || Tablero.tablcpu[x+i][y][2]!=3)
    				&&((Tablero.tablcpu[x-i][y][0]==0 || Tablero.tablcpu[x-i][y][1]==0)|| Tablero.tablcpu[x-i][y][2]!=3 )
    				&&((Tablero.tablcpu[x][y+i][0]==0 || Tablero.tablcpu[x][y+i][1]==0) || Tablero.tablcpu[x][y+i][2]!=3)
    				&&((Tablero.tablcpu[x][y-i][0]==0 || Tablero.tablcpu[x][y-i][1]==0) || Tablero.tablcpu[x][y-i][2]!=3))
    			{
        			tocado=1;
       			}else {
        			tocado=0;}
    			i++;
    		}
    		if (tocado==1){
    			texto.setText("Tocado  "+Tablero.tablcpu[x][y][2]);
    			casilla[x-3][y-3].setText("T");
    		}else {
    			casilla[x-3][y-3].setText("H");
    			hundido(x,y);
			}
    		break;
    	
    	}
    	
    }
    public void hundido(int x, int y){
    	TextView x1 =(TextView)findViewById(R.id.Barco1);
    	TextView x2 =(TextView)findViewById(R.id.Barco2);
    	TextView x3 =(TextView)findViewById(R.id.Barco3);
    	TextView texto = (TextView)findViewById(R.id.estado);
		//barco1.setText("");
		texto.setText("Tocado y ¡¡¡HUNDIDO!!!");
		switch (Tablero.tablcpu[x][y][2]) {
		case 1:
			String num1=(String)x1.getText();
			int a = Integer.parseInt(num1);
			a=a-1;
			x1.setText(""+a+"");
			break;
		case 2:
			String num2=(String)x2.getText();
			int b = Integer.parseInt(num2);
			b=b-1;
			x2.setText(""+b+"");
			break;
		case 3:
			String num3=(String)x3.getText();
			int c = Integer.parseInt(num3);
			c=c-1;
			x3.setText(""+c+"");
			break;
		}
		barcos--;
	 
		if(barcos==0){
			Toast toast =Toast.makeText(getApplicationContext(), "¡HAS GANADO!", Toast.LENGTH_LONG);
			toast.show();
			Intent a = new Intent(JuegaJugadorActivity.this, HundirLaFlotaActivity.class);
			startActivity(a);
			finish();
		}else{
			return;
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
    @Override
    protected void onPause() {
    	super.onPause();
    	TextView x1 =(TextView)findViewById(R.id.Barco1);
    	TextView x2 =(TextView)findViewById(R.id.Barco2);
    	TextView x3 =(TextView)findViewById(R.id.Barco3);
    	BufferedWriter fichero;
    	try {
    		fichero = new BufferedWriter(new FileWriter(
    			getFilesDir()+"/tablcpu.txt"));
    		int fil,col,pos;
    		for (fil=3;fil<9;fil++)
    		{
    			for (col=3;col<9;col++)
    			{
    				for (pos=0;pos<3;pos++)
    				{
    					String numero = ""+Tablero.tablcpu[fil][col][pos];
    					fichero.write((String)numero);
    				}
    				fichero.newLine();
    			}
    		}
    		String a=""+barcos;
    		fichero.write((String)a);
    		fichero.newLine();
    		fichero.write((String) x1.getText());
    		fichero.newLine();
    		fichero.write((String) x2.getText());
    		fichero.newLine();
    		fichero.write((String) x3.getText());
    		fichero.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    
    
    public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		if (keyCode==KeyEvent.KEYCODE_BACK) {
		 
			showDialog(0);
			return true;
		}else{
			return super.onKeyDown(keyCode, event);
		}
		
	}
    
    protected Dialog onCreateDialog(int id){
    	Dialog dialog;
    	switch (id) {
		case 0:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("¿Está seguro que quiere salir?").setCancelable(false).setPositiveButton("Sí", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					startActivity(new Intent(JuegaJugadorActivity.this,HundirLaFlotaActivity.class));
					finish();
				}
			}).setNegativeButton("No", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					dialog.cancel();
				}
			});
			dialog=builder.create();
			break;
		default:
			dialog=null;
			break;
		}
    	return dialog;
    }
   
}
