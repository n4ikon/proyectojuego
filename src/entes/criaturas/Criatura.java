package entes.criaturas;

import entes.Ente;
import graficos.Sprite;

public abstract class Criatura extends Ente {
    protected Sprite sprite;
    protected char direccion ='n';
    protected boolean enMovimiento = false;


   public void actualizar(){

   }
   public void mostrar(){

   }
   public void mover (int desplazamientoX, int desplazamientoY){
       if(desplazamientoX > 0){
           direccion = 'e';
       }
       if (desplazamientoX < 0){
           direccion = 'o';
       }
       if (desplazamientoY > 0){
           direccion ='s';
       }
       if (desplazamientoY < 0){
           direccion = 'n';
       }
       if (!estaEliminado()){
           modificarposicionX(desplazamientoX);
           modificarposicionY(desplazamientoY);
       }
   }
   private boolean enColision (){
       return false;
   }
   public Sprite obtenSprites(){
       return sprite;
   }
}
