package mapa;

import graficos.Pantalla;
import mapa.cuadro.Cuadro;

public abstract class Mapa {
	protected int ancho;
	protected int alto;
	
	protected int[] cuadros;
	protected Cuadro[] cuadrosCatalogo;
	
	
	public Mapa (int ancho , int alto) {
		this.ancho = ancho;
		this.alto = alto ;
		
		cuadros = new int [ancho * alto];
		generarMapa();
	}
	public Mapa(String ruta) {
		cargarMapa(ruta);
		generarMapa();
	}
	
	protected void generarMapa() {
		
	}
	protected void cargarMapa(String ruta) {
		
	}
	public void actualizar () {
		
	}
	
	public void mostrar (int compensacionX , int compensacionY , Pantalla pantalla) {
		pantalla.establecerDiferencia(compensacionX, compensacionY);
		int oeste = compensacionX >> 5;
		int este = (compensacionX + pantalla.obtenAncho() + Cuadro.LADO) >> 5 ;
		int norte = compensacionY >> 5 ;
		int sur = (compensacionY + pantalla.obtenAlto() + Cuadro.LADO) >> 5;;
		for (int y = norte; y < sur;y++) {
			for(int x = oeste; x < este; x++) {
				//obtenCuadro(x,y).mostrar(x, y, pantalla);
				if (x < 0 || y < 0 || x >= ancho || y >= alto) {
					Cuadro.Vacio.mostrar(x,y, pantalla); 
					}
				else {
					 cuadrosCatalogo[x + y * ancho].mostrar(x , y, pantalla);
				}			
				
			}
		}
		
	}
	public Cuadro obtenCuadro(final int x, final int y) {
		if (x<0 || y < 0 || x >= ancho || y >= alto) {
		return Cuadro.Vacio ;
		}
		switch(cuadros[x + y * ancho]) {
		case 0:
			return Cuadro.CRUCE;
		case 1: 
			return Cuadro.ASFALTO;
		case 2:
			return Cuadro.ARBOL;
		case 3:
			return Cuadro.AUTO;
		case 4: 
			return Cuadro.AUSTRAL1;
		case 5 :
			return Cuadro.AUSTRAL2;
		case 6 :
			return Cuadro.AUSTRAL3;
		case 7 :
			return Cuadro.AUSTRAL4;
		case 8:
			return Cuadro.AUSTRAL5;
		case 9:
			return Cuadro.AUSTRAL6;
		case 10:
			return Cuadro.AUSTRAL7;
		case 11:
			return Cuadro.AUSTRAL8;
		case 12:
			return Cuadro.PARED1;
		case 13:
			return Cuadro.PISO1;
		case 14:
			return Cuadro.PUPI;
			default:
				return Cuadro.Vacio;
		}
		
		
	}

}
