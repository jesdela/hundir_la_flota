package com.jldes.hundir_la_flota2;

public class Tablero {

	public static int tabljug[][][] = new int[12][12][3];
	public static int tablcpu[][][] = new int[12][12][3];
	// Tanto en tabljug y tablcpu, [x][y][0] es 0 cuando no hay barco y 1 cuando
	// sí hay barco, [x][y][1] es 0 cuando la casilla no ha sido elegida,
	// 1 cuando ha sido elegida y es agua, 2 cuando ha sido elegida y es tocado
	// y 3 cuando ha sido elegida y es hundido, y [x][y][2] indica el tamaño del
	// barco
	public static int situacion = 1; // indica la situacion a la que tiene que
										// ir la CPU en JuegaCpuActivity

}
