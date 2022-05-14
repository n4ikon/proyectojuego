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
    public static final Cuadro CRUCEROTADO = new Cuadro(Sprite.CRUCEROTADO);
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
    public static final Cuadro AUSTRAL9 = new Cuadro(Sprite.AUSTRAL9);
    public static final Cuadro AUSTRAL10 = new Cuadro(Sprite.AUSTRAL10);
    public static final Cuadro AUSTRAL11 = new Cuadro(Sprite.AUSTRAL11);
    public static final Cuadro AUSTRAL12 = new Cuadro(Sprite.AUSTRAL12);
    public static final Cuadro AUSTRAL13 = new Cuadro(Sprite.AUSTRAL13);
    public static final Cuadro AUSTRAL14 = new Cuadro(Sprite.AUSTRAL14);
    public static final Cuadro AUSTRAL15 = new Cuadro(Sprite.AUSTRAL15);
    public static final Cuadro AUSTRAL16 = new Cuadro(Sprite.AUSTRAL16);
    public static final Cuadro AUSTRAL17 = new Cuadro(Sprite.AUSTRAL17);
    public static final Cuadro AUSTRAL18 = new Cuadro(Sprite.AUSTRAL18);
    public static final Cuadro PISO1 = new Cuadro(Sprite.PISO1);
    public static final Cuadro PUPI = new Cuadro(Sprite.PUPI);
    public static final Cuadro ENEMIGO = new Cuadro(Sprite.ENEMIGO);
    
    
    
    
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
