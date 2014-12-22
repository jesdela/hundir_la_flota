package com.jldes.hundir_la_flota;

import java.io.BufferedWriter;
import java.io.FileWriter;

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
import android.widget.TextView;
import android.widget.Toast;

import com.jldes.hundir_la_flota.R;

public class CopyOfCrearTableroJugadorActivity extends Activity{
	static int i;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_partida);
        final Button boton1 = (Button)findViewById(R.id.b1);
        final Button boton2 = (Button)findViewById(R.id.b2);
        final Button boton3 = (Button)findViewById(R.id.b3);
        final Button continuar=(Button)findViewById(R.id.Continuar);
        final TextView texto1 = (TextView)findViewById(R.id.Barco1);
        final TextView texto2 = (TextView)findViewById(R.id.Barco2);
        final TextView texto3 = (TextView)findViewById(R.id.Barco3);
        
        continuar.setEnabled(false);
        
        for (int i=0;i<12;i++){
        	for(int j=0;j<12;j++){
        		for(int k=0;k<3;k++){
        			Tablero.tablcpu[i][j][k]=0;
        			Tablero.tabljug[i][j][k]=0;
        		}
        	}
        }
        boton1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
					clickable();
					i=1;
					creartablero(1);		
					String x1 = (String)texto1.getText();
					int a = Integer.parseInt(x1);
					a=a-1;
					
					texto1.setText(""+a+"");
				
					if (a < 1)
						v.setEnabled(false);
					
			}			
		});
        
        boton2.setOnClickListener(new OnClickListener() {
			
        	public void onClick(View w) {
        			clickable();
        			i=1;
        			creartablero(2);
					String x2 = (String)texto2.getText();
					int b = Integer.parseInt(x2);
					b=b-1;
					texto2.setText(""+b+"");
					if (b < 1)
						w.setEnabled(false);
					
        	}			
		});
        
        boton3.setOnClickListener(new OnClickListener() {
			
        	public void onClick(View z) {
        			clickable();
        			i=1;
        			creartablero(3);
        			creartablero(3);
        			creartablero(3);
        			String x3 = (String)texto3.getText();
					int c = Integer.parseInt(x3);
					c=c-1;
					texto3.setText(""+c+"");
					if (c < 1)
						z.setEnabled(false);
					
        	}			
		});
       
		continuar.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				CrearTableroCpu.tableroCpu();
				Toast toast =Toast.makeText(getApplicationContext(), "La CPU está creando su tablero. \n		Espere por favor... ", Toast.LENGTH_LONG);
				toast.show();
				SharedPreferences prefs =
					     getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);
				SharedPreferences.Editor editor = prefs.edit();
				editor.putBoolean("continuar", true);
				editor.commit();
				toast.show();
	    		Intent b =new Intent(CopyOfCrearTableroJugadorActivity.this, JuegaJugadorActivity.class);
				startActivity(b);
				finish();
			}
		});
        	
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    	BufferedWriter fichtablcpu,fichtabljug;
		int fil,col,pos;
    	try {
    		fichtablcpu = new BufferedWriter(new FileWriter(
    			getFilesDir()+"/tablcpu.txt"));
    		for (fil=3;fil<9;fil++)
    		{
    			for (col=3;col<9;col++)
    			{
    				for (pos=0;pos<3;pos++)
    				{
    					String numero = ""+Tablero.tablcpu[fil][col][pos];
    					fichtablcpu.write((String)numero);
    				}
    				fichtablcpu.newLine();
    			}
    		}
    		String a="6";
    		fichtablcpu.write((String)a);
    		fichtablcpu.newLine();
    		a="3";
    		fichtablcpu.write((String) a);
    		fichtablcpu.newLine();
    		a="2";
    		fichtablcpu.write((String) a);
    		fichtablcpu.newLine();
    		a="1";
    		fichtablcpu.write((String) a);
    		fichtablcpu.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}try {
    		fichtabljug = new BufferedWriter(new FileWriter(
        			getFilesDir()+"/tabljug.txt"));
        		for (fil=3;fil<9;fil++)
        		{
        			for (col=3;col<9;col++)
        			{
        				for (pos=0;pos<3;pos++)
        				{
        					String numero = ""+Tablero.tabljug[fil][col][pos];
        					fichtabljug.write((String)numero);
        				}
        				fichtabljug.newLine();
        			}
        		}
        		String a="6";
        		fichtabljug.write("6");
        		fichtabljug.newLine();
        		a="3";
        		fichtabljug.write((String) a);
        		fichtabljug.newLine();
        		a="2";
        		fichtabljug.write((String) a);
        		fichtabljug.newLine();
        		a="1";
        		fichtabljug.write((String) a);
        		for(int i=0;i<4;i++){
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
    public void creartablero(final int numb ){
    	final Button continuar=(Button)findViewById(R.id.Continuar);
    	final Button boton1 = (Button)findViewById(R.id.b1);
        final Button boton2 = (Button)findViewById(R.id.b2);
        final Button boton3 = (Button)findViewById(R.id.b3);
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
		
		for (fil=3;fil<9;fil++)
		{
			for (col=3;col<9;col++)
			{
				final int fil2=fil;
				final int col2=col;
				if(!(Tablero.tabljug[fil+1][col][0]==1||Tablero.tabljug[fil-1][col][0]==1||Tablero.tabljug[fil][col+1][0]==1||Tablero.tabljug[fil][col-1][0]==1))
				casilla[fil-3][col-3].setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						Tablero.tabljug[fil2][col2][0]=1;
						Tablero.tabljug[fil2][col2][2]=numb;
						v.setEnabled(false);
						v.setBackgroundResource(R.drawable.radar);
					
						if(i==numb){
							for (int f=0;f<6;f++)
							{
								for (int c=0;c<6;c++)
								{
									if ((f!=fil2-3)||(c!=col2-3)){
										casilla[f][c].setClickable(false);
									}
								}
							}
							clickable();
							if(!(boton1.isEnabled()||boton2.isEnabled()||
									boton3.isEnabled())){continuar.setEnabled(true);}
						}
						i++;
						return;
					}
				});
			}
		}
    }
 

 public void clickable(){
			
			
			Button boton1 = (Button)findViewById(R.id.b1);
	        Button boton2 = (Button)findViewById(R.id.b2);
	        Button boton3 = (Button)findViewById(R.id.b3);
			if (boton1.isClickable()==false){
				boton1.setClickable(true);
				boton2.setClickable(true);
				boton3.setClickable(true);
			}else {
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
			startActivity(new Intent(this, CopyOfCrearTableroJugadorActivity.class));
			finish();
			return true;
		
		case R.id.ayuda:
			startActivity(new Intent(this, AyudaActivity.class));
			return true;
		}
    	return false;
	}
}
  