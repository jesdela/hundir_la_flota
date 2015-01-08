package com.jldes.hundir_la_flota2;

import java.util.Random;

public class CrearTableroCpu {
	static int x;
	static int y;
	static Random r = new Random();

	public static void tableroCpu() {
		for (int i = 1; i < 4; i++) {
			switch (i) {
			case 1: // CPU coloca un barco de tamaño 3
				aleatorio();
				barco3();
				break;
			case 2: // CPU coloca dos barcos de tamaño 2
				for (int j = 0; j < 2; j++) {
					aleatorio();
					barco2();
				}
				break;
			case 3: // CPU coloca tres barcos de tamaño 1
				for (int j = 0; j < 3; j++) {
					do {
						aleatorio(); // cogemos un valor aleatorio mientras
										// haya barco en las casillas de
										// alrededor
					} while (Tablero.tablcpu[x + 1][y][0] == 1
							|| Tablero.tablcpu[x - 1][y][0] == 1
							|| Tablero.tablcpu[x][y + 1][0] == 1
							|| Tablero.tablcpu[x][y - 1][0] == 1);
					Tablero.tablcpu[x][y][0] = 1; // ponemos el barco
					Tablero.tablcpu[x][y][2] = 1;
				}
				break;
			}
		}
		return;
	}

	public static void aleatorio() { // Cogemos un valor aleatorio
		do {
			x = r.nextInt(5) + 3;
			y = r.nextInt(5) + 3;
		} while (Tablero.tablcpu[x][y][0] == 1);
	}

	public static void barco3() { // Buscamos un lugar adecuado para poner el
									// barco de tamaño 3
		if (y - 1 < 3) { // no hay tablero arriba
			if (x + 1 > 8) { // no hay tablero a la derecha
				int a = r.nextInt(1);
				switch (a) {
				case 0:
					izq();
					break;

				default:
					abaj();
					break;
				}
			} else if (x - 1 < 3) { // no hay tablero a la izquierda
				int a = r.nextInt(1);
				switch (a) {
				case 0:
					dcha();
					break;

				default:
					abaj();
					break;
				}
			} else {
				int a = r.nextInt(2);
				switch (a) {
				case 0:
					ntbdcha();
					break;

				case 1:
					ntbizq();
					break;

				default:
					abaj();
					break;
				}
			}
		} else if (y + 1 > 8) { // no hay tablero debajo
			if (x + 1 > 8) { // no hay tablero a la derecha
				int a = r.nextInt(1);
				switch (a) {
				case 0:
					izq();
					break;

				default:
					arrib();
					break;
				}
			} else if (x - 1 < 3) {// no tablero a la izquierda
				int a = r.nextInt(1);
				switch (a) {
				case 0:
					dcha();
					break;

				default:
					arrib();
					break;
				}
			} else {
				int a = r.nextInt(2);
				switch (a) {
				case 0:
					ntbdcha();
					break;

				case 1:
					ntbizq();
					break;

				default:
					arrib();
					break;
				}

			}

		} else if (x - 1 < 3) { // no hay tablero a la izquierda
			int a = r.nextInt(2);
			switch (a) {
			case 0:
				ntbarrib();
				break;
			case 1:
				ntbabaj();
				break;

			default:
				dcha();
				break;
			}
		} else if (x + 1 > 8) { // no hay tablero a la derecha
			int a = r.nextInt(2);
			switch (a) {
			case 0:
				ntbarrib();
				break;

			case 1:
				ntbabaj();
				break;

			default:
				izq();
				break;
			}
		} else {
			int a = r.nextInt(3);
			switch (a) {
			case 0:
				ntbarrib();
				break;

			case 1:
				ntbdcha();
				break;

			case 2:
				ntbabaj();
				break;

			default:
				ntbizq();
			}
		}
	}

	public static void izq() { // pone el barco hacia la izquierda
		Tablero.tablcpu[x][y][0] = 1;
		Tablero.tablcpu[x][y][2] = 3;
		Tablero.tablcpu[x - 1][y][0] = 1;
		Tablero.tablcpu[x - 1][y][2] = 3;
		Tablero.tablcpu[x - 2][y][0] = 1;
		Tablero.tablcpu[x - 2][y][2] = 3;
	}

	public static void dcha() { // pone el barco hacia la derecha
		Tablero.tablcpu[x][y][0] = 1;
		Tablero.tablcpu[x][y][2] = 3;
		Tablero.tablcpu[x + 1][y][0] = 1;
		Tablero.tablcpu[x + 1][y][2] = 3;
		Tablero.tablcpu[x + 2][y][0] = 1;
		Tablero.tablcpu[x + 2][y][2] = 3;
	}

	public static void abaj() { // pone el barco hacia abajo
		Tablero.tablcpu[x][y][0] = 1;
		Tablero.tablcpu[x][y][2] = 3;
		Tablero.tablcpu[x][y + 1][0] = 1;
		Tablero.tablcpu[x][y + 1][2] = 3;
		Tablero.tablcpu[x][y + 2][0] = 1;
		Tablero.tablcpu[x][y + 2][2] = 3;
	}

	public static void arrib() { // pone el barco hacia arriba
		Tablero.tablcpu[x][y][0] = 1;
		Tablero.tablcpu[x][y][2] = 3;
		Tablero.tablcpu[x][y - 1][0] = 1;
		Tablero.tablcpu[x][y - 1][2] = 3;
		Tablero.tablcpu[x][y - 2][0] = 1;
		Tablero.tablcpu[x][y - 2][2] = 3;
	}

	public static void ntbdcha() {
		if (x + 2 > 8) { // pone el barco centrado y horizontal
			Tablero.tablcpu[x][y][0] = 1;
			Tablero.tablcpu[x][y][2] = 3;
			Tablero.tablcpu[x + 1][y][0] = 1;
			Tablero.tablcpu[x + 1][y][2] = 3;
			Tablero.tablcpu[x - 1][y][0] = 1;
			Tablero.tablcpu[x - 1][y][2] = 3;
		} else {
			dcha();
		}
	}

	public static void ntbizq() {
		if (x - 2 < 3) { // pone el barco centrado y horizontal
			Tablero.tablcpu[x][y][0] = 1;
			Tablero.tablcpu[x][y][2] = 3;
			Tablero.tablcpu[x + 1][y][0] = 1;
			Tablero.tablcpu[x + 1][y][2] = 3;
			Tablero.tablcpu[x - 1][y][0] = 1;
			Tablero.tablcpu[x - 1][y][2] = 3;
		} else {
			izq();
		}
	}

	public static void ntbarrib() {
		if (y - 2 < 3) { // pone el barco centrado y vertical
			Tablero.tablcpu[x][y][0] = 1;
			Tablero.tablcpu[x][y][2] = 3;
			Tablero.tablcpu[x][y - 1][0] = 1;
			Tablero.tablcpu[x][y - 1][2] = 3;
			Tablero.tablcpu[x][y + 1][0] = 1;
			Tablero.tablcpu[x][y + 1][2] = 3;
		} else {
			arrib();
		}
	}

	public static void ntbabaj() {
		if (y + 2 > 8) { // pone el barco centrado y vertical
			Tablero.tablcpu[x][y][0] = 1;
			Tablero.tablcpu[x][y][2] = 3;
			Tablero.tablcpu[x][y - 1][0] = 1;
			Tablero.tablcpu[x][y - 1][2] = 3;
			Tablero.tablcpu[x][y + 1][0] = 1;
			Tablero.tablcpu[x][y + 1][2] = 3;
		} else {
			abaj();
		}
	}

	public static void barco2() { // Buscamos un lugar adecuado para poner un
									// barco de tamaño 2
		if (Tablero.tablcpu[x + 1][y][0] == 1
				|| Tablero.tablcpu[x - 1][y][0] == 1
				|| Tablero.tablcpu[x][y + 1][0] == 1
				|| Tablero.tablcpu[x][y - 1][0] == 1) {
			// si alrededor hay barco cogemos otro valor aleatorio
			aleatorio();
			barco2();
		} else if (Tablero.tablcpu[x + 1][y + 1][0] == 1) {
			if (Tablero.tablcpu[x - 1][y - 1][0] == 1) {
				aleatorio();
				barco2();
			} else if (Tablero.tablcpu[x + 1][y - 1][0] == 1) {
				if (x - 1 < 3) {
					aleatorio();
					barco2();
				} else if (Tablero.tablcpu[x - 1][y + 1][0] == 1) {
					aleatorio();
					barco2();
				} else if (Tablero.tablcpu[x - 2][y][0] == 1) {
					aleatorio();
					barco2();
				} else {
					bxy8();
					return;
				}
			} else if (Tablero.tablcpu[x - 1][y + 1][0] == 1) {
				if (y - 1 < 3) {
					aleatorio();
					barco2();
				} else if (Tablero.tablcpu[x][y - 2][0] == 1) {
					aleatorio();
					barco2();
				} else {
					bxy2();
					return;
				}
			} else if (y - 1 < 3) {
				if (x - 1 < 3) {
					aleatorio();
					barco2();
				} else if (Tablero.tablcpu[x - 2][y][0] == 1) {
					aleatorio();
					barco2();
				} else {
					bxy8();
				}
			} else if (x - 1 < 3) {
				if (Tablero.tablcpu[x][y - 2][0] == 1) {
					aleatorio();
					barco2();
				} else {
					bxy2();
				}
			} else if (Tablero.tablcpu[x - 2][y][0] == 1) {
				if (Tablero.tablcpu[x][y - 2][0] == 1) {
					aleatorio();
					barco2();
				} else {
					bxy2();
				}
			} else if (Tablero.tablcpu[x][y - 2][0] == 1) {
				bxy8();
			} else {
				int a = r.nextInt(1);
				switch (a) {
				case 0:
					bxy2();
					break;

				default:
					bxy8();
					break;
				}
				return;
			}
		} else if (Tablero.tablcpu[x - 1][y + 1][0] == 1) {
			if (Tablero.tablcpu[x + 1][y - 1][0] == 1) {
				aleatorio();
				barco2();
			} else if (Tablero.tablcpu[x - 1][y - 1][0] == 1) {
				if (x + 1 > 8) {
					aleatorio();
					barco2();
				} else if (Tablero.tablcpu[x + 2][y][0] == 1) {
					aleatorio();
					barco2();
				} else {
					bxy4();
				}
			} else if (y - 1 < 3) {
				if (x + 1 > 8) {
					aleatorio();
					barco2();
				} else if (Tablero.tablcpu[x + 2][y][0] == 1) {
					aleatorio();
					barco2();
				} else {
					bxy4();
				}
			} else if (x + 1 > 8) {
				if (Tablero.tablcpu[x][y - 2][0] == 1) {
					aleatorio();
					barco2();
				} else {
					bxy2();
				}
			} else if (Tablero.tablcpu[x][y - 2][0] == 1) {
				if (Tablero.tablcpu[x + 2][y][0] == 1) {
					aleatorio();
					barco2();
				} else {
					bxy4();
				}
			} else if (Tablero.tablcpu[x + 2][y][0] == 1) {
				bxy2();
			} else {
				int a = r.nextInt(1);
				switch (a) {
				case 0:
					bxy2();
					break;

				default:
					bxy4();
					break;
				}
				return;
			}
		} else if (Tablero.tablcpu[x - 1][y - 1][0] == 1) {
			if (Tablero.tablcpu[x + 1][y - 1][0] == 1) {
				if (y + 1 > 8) {
					aleatorio();
					barco2();
				} else if (Tablero.tablcpu[x][y + 2][0] == 1) {
					aleatorio();
					barco2();
				} else {
					bxy6();
				}
			} else if (x + 1 > 8) {
				if (y + 1 > 8) {
					aleatorio();
					barco2();
				} else if (Tablero.tablcpu[x][y + 2][0] == 1) {
					aleatorio();
					barco2();
				} else {
					bxy6();
				}
			} else if (y + 1 > 8) {
				if (Tablero.tablcpu[x + 2][y][0] == 1) {
					aleatorio();
					barco2();
				} else {
					bxy4();
				}
			} else if (Tablero.tablcpu[x + 2][y][0] == 1) {
				if (Tablero.tablcpu[x][y + 2][0] == 1) {
					aleatorio();
					barco2();
				} else {
					bxy6();
				}
			} else {
				int a = r.nextInt(1);
				switch (a) {
				case 0:
					bxy4();
					break;

				default:
					bxy6();
					break;
				}
				return;
			}
		} else if (Tablero.tablcpu[x + 1][y - 1][0] == 1) {
			if (x - 1 < 3) {
				if (y + 1 > 8) {
					aleatorio();
					barco2();
				} else if (Tablero.tablcpu[x][y + 2][0] == 1) {
					aleatorio();
					barco2();
				} else {
					bxy6();
				}
			} else if (y + 1 > 8) {
				if (Tablero.tablcpu[x - 2][y][0] == 1) {
					aleatorio();
					barco2();
				} else {
					bxy8();
				}
			} else if (Tablero.tablcpu[x - 2][y][0] == 1) {
				if (Tablero.tablcpu[x][y + 2][0] == 1) {
					aleatorio();
					barco2();
				} else {
					bxy6();
				}
			} else if (Tablero.tablcpu[x][y + 2][0] == 1) {
				bxy8();
			} else {
				int a = r.nextInt(1);
				switch (a) {
				case 0:
					bxy6();
					break;

				default:
					bxy8();
					break;
				}
				return;
			}
		} else if (y - 1 < 3) {
			if (x + 1 > 8) {
				if (Tablero.tablcpu[x - 2][y][0] == 1) {
					if (Tablero.tablcpu[x][y + 2][0] == 1) {
						aleatorio();
						barco2();
					} else {
						bxy6();
					}
				} else if (Tablero.tablcpu[x][y + 2][0] == 1) {
					bxy8();
				} else {
					int a = r.nextInt(1);
					switch (a) {
					case 0:
						bxy6();
						break;

					default:
						bxy8();
						break;
					}
					return;
				}
			} else if (x - 1 < 3) {
				if (Tablero.tablcpu[x + 2][y][0] == 1) {
					if (Tablero.tablcpu[x][y + 2][0] == 1) {
						aleatorio();
						barco2();
					} else {
						bxy6();
					}
				} else if (Tablero.tablcpu[x][y + 2][0] == 1) {
					bxy4();
				} else {
					int a = r.nextInt(1);
					switch (a) {
					case 0:
						bxy4();
						break;

					default:
						bxy6();
						break;
					}
					return;
				}
			} else if (Tablero.tablcpu[x - 2][y][0] == 1) {
				if (Tablero.tablcpu[x + 2][y][0] == 1) {
					if (Tablero.tablcpu[x][y + 2][0] == 1) {
						aleatorio();
						barco2();
					} else {
						bxy6();
					}
				} else if (Tablero.tablcpu[x][y + 2][0] == 1) {
					bxy4();
				} else {
					int a = r.nextInt(1);
					switch (a) {
					case 0:
						bxy4();
						break;

					default:
						bxy6();
						break;
					}
					return;
				}
			} else if (Tablero.tablcpu[x + 2][y][0] == 1) {
				if (Tablero.tablcpu[x][y + 2][0] == 1) {
					bxy8();
				} else {
					int a = r.nextInt(1);
					switch (a) {
					case 0:
						bxy6();
						break;

					default:
						bxy8();
						break;
					}
					return;
				}
			} else if (Tablero.tablcpu[x][y + 2][0] == 1) {
				int a = r.nextInt(1);
				switch (a) {
				case 0:
					bxy4();
					break;

				default:
					bxy8();
					break;
				}
				return;
			} else {
				int a = r.nextInt(2);
				switch (a) {
				case 0:
					bxy4();
					break;

				case 1:
					bxy6();
					break;

				default:
					bxy8();
					break;
				}
				return;
			}
		} else if (y + 1 > 8) {
			if (x + 1 > 8) {
				if (Tablero.tablcpu[x - 2][y][0] == 1) {
					if (Tablero.tablcpu[x][y - 2][0] == 1) {
						aleatorio();
						barco2();
					} else {
						bxy2();
					}
				} else if (Tablero.tablcpu[x][y - 2][0] == 1) {
					bxy8();
				} else {
					int a = r.nextInt(1);
					switch (a) {
					case 0:
						bxy2();
						break;

					default:
						bxy8();
						break;
					}
					return;
				}
			} else if (x - 1 < 3) {
				if (Tablero.tablcpu[x][y - 2][0] == 1) {
					if (Tablero.tablcpu[x + 2][y][0] == 1) {
						aleatorio();
						barco2();
					} else {
						bxy4();
					}
				} else if (Tablero.tablcpu[x + 2][y][0] == 1) {
					bxy2();
				} else {
					int a = r.nextInt(1);
					switch (a) {
					case 0:
						bxy2();
						break;

					default:
						bxy4();
						break;
					}
					return;
				}
			} else if (Tablero.tablcpu[x - 2][y][0] == 1) {
				if (Tablero.tablcpu[x][y - 2][0] == 1) {
					if (Tablero.tablcpu[x + 2][y][0] == 1) {
						aleatorio();
						barco2();
					} else {
						bxy4();
					}
				} else if (Tablero.tablcpu[x + 2][y][0] == 1) {
					bxy2();
				} else {
					int a = r.nextInt(1);
					switch (a) {
					case 0:
						bxy2();
						break;

					default:
						bxy4();
						break;
					}
					return;
				}
			} else if (Tablero.tablcpu[x][y - 2][0] == 1) {
				if (Tablero.tablcpu[x + 2][y][0] == 1) {
					bxy8();
				} else {
					int a = r.nextInt(1);
					switch (a) {
					case 0:
						bxy4();
						break;

					default:
						bxy8();
						break;
					}
					return;
				}
			} else if (Tablero.tablcpu[x + 2][y][0] == 1) {
				int a = r.nextInt(1);
				switch (a) {
				case 0:
					bxy2();
					break;

				default:
					bxy8();
					break;
				}
				return;
			} else {
				int a = r.nextInt(2);
				;
				switch (a) {
				case 0:
					bxy2();
					break;

				case 1:
					bxy4();
					break;

				default:
					bxy8();
					break;
				}
				return;
			}
		} else if (x - 1 < 3) {
			if (Tablero.tablcpu[x][y - 2][0] == 1) {
				if (Tablero.tablcpu[x + 2][y][0] == 1) {
					if (Tablero.tablcpu[x][y + 2][0] == 1) {
						aleatorio();
						barco2();
					} else {
						bxy6();
					}
				} else if (Tablero.tablcpu[x][y + 2][0] == 1) {
					bxy4();
				} else {
					int a = r.nextInt(1);
					switch (a) {
					case 0:
						bxy4();
						break;

					default:
						bxy6();
						break;
					}
					return;
				}
			} else if (Tablero.tablcpu[x + 2][y][0] == 1) {
				if (Tablero.tablcpu[x][y + 2][0] == 1) {
					bxy2();
				} else {
					int a = r.nextInt(1);
					switch (a) {
					case 0:
						bxy2();
						break;

					default:
						bxy6();
						break;
					}
					return;
				}
			} else if (Tablero.tablcpu[x][y + 2][0] == 1) {
				int a = r.nextInt(1);
				switch (a) {
				case 0:
					bxy2();
					break;

				default:
					bxy4();
					break;
				}
				return;
			} else {
				int a = r.nextInt(2);
				switch (a) {
				case 0:
					bxy2();
					break;

				case 1:
					bxy4();
					break;

				default:
					bxy6();
					break;
				}
				return;
			}
		} else if (x + 1 > 8) {
			if (Tablero.tablcpu[x - 2][y][0] == 1) {
				if (Tablero.tablcpu[x][y - 2][0] == 1) {
					if (Tablero.tablcpu[x][y + 2][0] == 1) {
						aleatorio();
						barco2();
					} else {
						bxy6();
					}
				} else if (Tablero.tablcpu[x][y + 2][0] == 1) {
					bxy2();
				} else {
					int a = r.nextInt(1);
					switch (a) {
					case 0:
						bxy2();
						break;

					default:
						bxy6();
						break;
					}
					return;
				}
			} else if (Tablero.tablcpu[x][y - 2][0] == 1) {
				if (Tablero.tablcpu[x][y + 2][0] == 1) {
					bxy8();
				} else {
					int a = r.nextInt(1);
					switch (a) {
					case 0:
						bxy6();
						break;

					default:
						bxy8();
						break;
					}
					return;
				}
			} else if (Tablero.tablcpu[x][y + 2][0] == 1) {
				int a = r.nextInt(1);
				switch (a) {
				case 0:
					bxy2();
					break;

				default:
					bxy8();
					break;
				}
				return;
			} else {
				int a = r.nextInt(2);
				switch (a) {
				case 0:
					bxy2();
					break;

				case 1:
					bxy6();
					break;

				default:
					bxy8();
					break;
				}
				return;
			}
		} else if (Tablero.tablcpu[x - 2][y][0] == 1) {
			if (Tablero.tablcpu[x][y - 2][0] == 1) {
				if (Tablero.tablcpu[x + 2][y][0] == 1) {
					if (Tablero.tablcpu[x][y + 2][0] == 1) {
						aleatorio();
						barco2();
					} else {
						bxy6();
					}
				} else if (Tablero.tablcpu[x][y + 2][0] == 1) {
					bxy4();
				} else {
					int a = r.nextInt(1);
					switch (a) {
					case 0:
						bxy4();
						break;

					default:
						bxy6();
						break;
					}
					return;
				}
			} else if (Tablero.tablcpu[x + 2][y][0] == 1) {
				if (Tablero.tablcpu[x][y + 2][0] == 1) {
					bxy2();
				} else {
					int a = r.nextInt(1);
					switch (a) {
					case 0:
						bxy2();
						break;

					default:
						bxy6();
						break;
					}
					return;
				}
			} else if (Tablero.tablcpu[x][y + 2][0] == 1) {
				int a = r.nextInt(1);
				switch (a) {
				case 0:
					bxy2();
					break;

				default:
					bxy4();
					break;
				}
				return;
			} else {
				int a = r.nextInt(2);
				switch (a) {
				case 0:
					bxy2();
					break;

				case 1:
					bxy4();
					break;

				default:
					bxy6();
					break;
				}
				return;
			}
		} else if (Tablero.tablcpu[x][y - 2][0] == 1) {
			if (Tablero.tablcpu[x + 2][y][0] == 1) {
				if (Tablero.tablcpu[x][y + 2][0] == 1) {
					bxy8();
				} else {
					int a = r.nextInt(1);
					switch (a) {
					case 0:
						bxy6();
						break;

					default:
						bxy8();
						break;
					}
					return;
				}
			} else if (Tablero.tablcpu[x][y + 2][0] == 1) {
				int a = r.nextInt(1);
				switch (a) {
				case 0:
					bxy4();
					break;

				default:
					bxy8();
					break;
				}
				return;
			} else {
				int a = r.nextInt(2);
				switch (a) {
				case 0:
					bxy4();
					break;

				case 1:
					bxy6();
					break;

				default:
					bxy8();
					break;
				}
				return;
			}
		} else if (Tablero.tablcpu[x + 2][y][0] == 1) {
			if (Tablero.tablcpu[x][y + 2][0] == 1) {
				int a = r.nextInt(1);
				switch (a) {
				case 0:
					bxy2();
					break;

				default:
					bxy8();
					break;
				}
				return;
			} else {
				int a = r.nextInt(2);
				switch (a) {
				case 0:
					bxy2();
					break;

				case 1:
					bxy6();
					break;

				default:
					bxy8();
					break;
				}
				return;
			}
		} else if (Tablero.tablcpu[x][y + 2][0] == 1) {
			int a = r.nextInt(2);
			switch (a) {
			case 0:
				bxy2();
				break;

			case 1:
				bxy4();
				break;

			default:
				bxy8();
				break;
			}
			return;
		} else {
			int a = r.nextInt(3);
			switch (a) {
			case 0:
				bxy2();
				break;

			case 1:
				bxy4();
				break;

			case 2:
				bxy6();
				break;

			default:
				bxy8();
				break;
			}
			return;
		}
	}

	public static void bxy2() { // pone el barco hacia arriba
		Tablero.tablcpu[x][y][0] = 1;
		Tablero.tablcpu[x][y][2] = 2;
		Tablero.tablcpu[x][y - 1][0] = 1;
		Tablero.tablcpu[x][y - 1][2] = 2;
	}

	public static void bxy4() { // pone el barco hacia la derecha
		Tablero.tablcpu[x][y][0] = 1;
		Tablero.tablcpu[x][y][2] = 2;
		Tablero.tablcpu[x + 1][y][0] = 1;
		Tablero.tablcpu[x + 1][y][2] = 2;
	}

	public static void bxy6() { // pone el barco hacia abajo
		Tablero.tablcpu[x][y][0] = 1;
		Tablero.tablcpu[x][y][2] = 2;
		Tablero.tablcpu[x][y + 1][0] = 1;
		Tablero.tablcpu[x][y + 1][2] = 2;
	}

	public static void bxy8() { // pone el barco hacia la izquierda
		Tablero.tablcpu[x][y][0] = 1;
		Tablero.tablcpu[x][y][2] = 2;
		Tablero.tablcpu[x - 1][y][0] = 1;
		Tablero.tablcpu[x - 1][y][2] = 2;
	}

}