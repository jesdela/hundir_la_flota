package com.jldes.hundir_la_flota;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.jldes.hundir_la_flota.R;

public class HundirLaFlotaActivity extends Activity {
	final static int ACTIVITY_PREFERENCES = 1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
		Button jugar = (Button) findViewById(R.id.jugar);
		Button ayuda = (Button) findViewById(R.id.ayuda);
//		startService(new Intent(this, Servicio.class));
		jugar.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(HundirLaFlotaActivity.this,
						JugarActivity.class);
				startActivity(intent);
			}
		});

		ayuda.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				Intent irayuda = new Intent(HundirLaFlotaActivity.this,
						AyudaActivity.class);
				startActivity(irayuda);

			}
		});

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

	@Override
	public void onDestroy() {
		super.onDestroy();
		stopService(new Intent(this, Servicio.class));
	}
}