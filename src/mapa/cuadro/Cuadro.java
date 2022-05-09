package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

public  class Cuadro {
	public int x;
	public int y;
	
    public Sprite sprite;
    
    public static final int LADO = 32; 
    //cuadros
    public static final Cuadro Vacio = new Cuadro(Sprite.VACIO);
    public static final Cuadro CRUCE = new Cuadro(Sprite.CRUCE);
    public static final Cuadro ASFALTO = new Cuadro(Sprite.ASFALTO);
    public static final Cuadro ARBOL = new Cuadro(Sprite.ARBOL);
    public static final Cuadro PARED1 = new Cuadro(Sprite.PARED1);
    public static final Cuadro AUTO = new Cuadro(Sprite.AUTO);
    public static final Cuadro AUSTRAL1 = new Cuadro(Sprite.AUSTRAL1);
    public static final Cuadro AUSTRAL2 = new Cuadro(Sprite.AUSTRAL2);
    public static final Cuadro AUSTRAL3 = new Cuadro(Sprite.AUSTRAL3);
    public static final Cuadro AUSTRAL4 = new Cuadro(Sprite.AUSTRAL4);
    public static final Cuadro AUSTRAL5 = new Cuadro(Sprite.AUSTRAL5);
    public static final Cuadro AUSTRAL6 = new Cuadro(Sprite.AUSTRAL6);
    public static final Cuadro AUSTRAL7 = new Cuadro(Sprite.AUSTRAL7);
    public static final Cuadro AUSTRAL8 = new Cuadro(Sprite.AUSTRAL8);
    public static final Cuadro PISO1 = new Cuadro(Sprite.PISO1);
    public static final Cuadro PUPI = new Cuadro(Sprite.PUPI);
    
    
    
    
    //fin cuadros
    public Cuadro (Sprite sprite) {
    	this.sprite = sprite;
    }
    
    public void mostrar(int x , int y, Pantalla pantalla) {
    	pantalla.mostrarCuadro(x << 5, y << 5, this);
    	
    }
    public boolean solido() {
    	return false;
    }
}
