package entes;

import mapa.Mapa;

public abstract class Ente {
    protected int y;
    protected int x;
    private boolean eliminado = false;

    protected Mapa mapa;

    public void actualizar(){

    }
    public void mostrar (){

    }
    public void eliminar(){
        eliminado = true;
    }
    public int obtenerposicionX(){
        return x;
    }
    public int obtenerposicionY(){
        return y;
    }
    public void modificarposicionX(int desplazamientoX){
        x +=desplazamientoX;

    }
    public void modificarposicionY(int desplazamientoY){
        y += desplazamientoY;

    }
    public boolean estaEliminado (){
        return eliminado;
    }

}
