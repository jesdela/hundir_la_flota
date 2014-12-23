package com.jldes.hundir_la_flota;

import java.util.ArrayList;

public class Barco {
	int tamaño;
	ArrayList<Casilla> casillas = new ArrayList<Casilla>();
	boolean hundido;
	public Barco(int tam) {
		tamaño = tam;
	}
	void add_casilla(Casilla casilla){
		casillas.add(casilla);
	}
}
