package entes.criaturas;

import control.Teclado;
import graficos.Pantalla;
import graficos.Sprite;

public class Jugardor extends Criatura {

    private Teclado teclado;
    public Jugardor (Teclado teclado, Sprite sprite){
        this.teclado = teclado;
        this.sprite = sprite;
    }
    public Jugardor (Teclado teclado,Sprite sprite, int posicionX , int posicionY){
        this.teclado= teclado;
        this.sprite = sprite;
        this.x = posicionX;
        this.y = posicionY;
    }
    public void actualizar(){
        int desplazamientoX = 0;
        int desplazamientoY = 0;

        if (teclado.arriba){
            desplazamientoY--;
        }
        if (teclado.abajo){
            desplazamientoY++;
        }
        if (teclado.izquierda){
            desplazamientoX--;
        }
        if (teclado.derecha){
            desplazamientoX++;
        }
        if (desplazamientoX != 0 || desplazamientoY != 0){
            if (direccion=='n'){
                sprite= Sprite.ARRIBA0;
            }
            if (direccion=='s'){
                sprite= Sprite.ABAJO0;
            }
            if (direccion=='o'){
                sprite= Sprite.IZQUIERDA0;
            }
            if (direccion=='e'){
                sprite= Sprite.DERECHA0;
            }
            mover(desplazamientoX,desplazamientoY);
        }
    }
    public void mostrar (Pantalla pantalla){
        pantalla.mostrarJugador(x,y,this);

    }


}
