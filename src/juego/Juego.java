package juego;

import control.Teclado;
import graficos.Pantalla;
import mapa.Mapa;
import mapa.MapaCargado;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;


//para utilizar un nuevo Thread debemos implementar la interfaz Runnable lo que nos obligara a implementar el metodo run
public class Juego extends Canvas implements Runnable{


    private static final long serialVersionUID =1L;

    private static final int ANCHO = 800;

    private static final int ALTO = 600;

    //booleano que controla que la aplicacion este funcionando con volatile no puede ser utilizada en forma simultanea por los 2 Thread
    private static volatile boolean enFuncionamiento = false;

    private static final String NOMBRE = "Apocalipsis T.U.P.";
    
    private static String CONTADOR_FPS="";
    private static String CONTADOR_APS="";

    private static int aps = 0;
    private static int fps = 0;

    private static int x = 0;
    private static int y = 0;

    private static JFrame ventana;

    private static Thread thread;

    private static Teclado teclado;

    private static Pantalla pantalla;
    
    private static Mapa mapa;

    private static BufferedImage image = new BufferedImage(ANCHO, ALTO , BufferedImage.TYPE_INT_RGB);

    private static int [] pixeles =((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    private static final ImageIcon icono = new ImageIcon(Juego.class.getResource("/icono/icono.png"));
    
    private Juego(){
        //fija el tamaño de la ventana
        setPreferredSize(new Dimension(ANCHO,ALTO));

        pantalla = new Pantalla(ANCHO,ALTO);
        
       // mapa = new MapaGenerado(128, 128);
        mapa = new MapaCargado("/mapas/mapa1.png");
        
        teclado = new Teclado();
        addKeyListener(teclado);

         //crea la ventana
        ventana = new JFrame(NOMBRE);
        // finaliza la aplicacion cuando se cierra la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // no permite cambiar el tamaño de la ventana
        ventana.setResizable(false);
        //ventana sin bordes
        ventana.setUndecorated(true);
        
        ventana.setIconImage(icono.getImage());
        
        //Diseño y gestor de la ventana
        ventana.setLayout(new BorderLayout());
        // añadde a la ventana nuestra clase
        ventana.add(this,BorderLayout.CENTER);
        // evita que la venta se abra con oto tamaño
        ventana.pack();
        // centra la ventana
        ventana.setLocationRelativeTo(null);
        // hace visible la ventana
        ventana.setVisible(true);

    }

    public static void main(String[] args) {

        Juego juego = new Juego();
        juego.iniciar();

    }

    private  void iniciar(){
        enFuncionamiento =  true;
        //pasamos la clases desde donde lo vamos a implementar
        thread = new Thread(this, "Graficos");
        // debemos ponerlo en marcha y ejecutara el codigo dentro de run
        thread.start();
    }
     // synchronized se asegura que los metodos no puedan modificar de forma simultanea la variable
    private synchronized void detener(){
        enFuncionamiento =false;

        try {
            //.join espera que el Thread acaba de ejecutar y despues lo detiene
            thread.join();
        } catch (InterruptedException e){
                e.printStackTrace();
        }
    }

    //actualiza las variables del juego
    private void actualizar (){
        teclado.actualizar();

        if(teclado.arriba){
            y--;
        }
        if(teclado.abajo){
            y++;
        }
        if(teclado.izquierda){
            x--;
        }
        if(teclado.derecha){
           x++;
        }
        if(teclado.salir) {
        	System.exit(0);
        }

        aps++;
    }
    //redibja graficos
    private void mostrar(){
        BufferStrategy estrategia = getBufferStrategy();
        if(estrategia == null){
            createBufferStrategy(3);
            return;
        }
        pantalla.limpiar();
        mapa.mostrar(x, y, pantalla);
        

        System.arraycopy(pantalla.pixeles,0 , pixeles, 0 , pixeles.length);
        
        
        Graphics g = estrategia.getDrawGraphics();
        g.drawImage(image, 0 ,0, getWidth(),getHeight(), null);
        //temporal
        g.setColor(Color.green);
        g.fillRect(ANCHO / 2, ALTO / 2 , 32, 32);
        //temporal
        g.drawString(CONTADOR_APS, 10, 20);
        g.drawString(CONTADOR_FPS, 10, 35);
        g.dispose();

        estrategia.show();

        fps++;
    }
    public synchronized void run() {
        // equivalencia ns por s
        final int NS_POR_SEGUNDO = 1000000000;
        //actualizaciones por segundo
        final byte APS_OBJETIVO= 60;
        //cuantos  ns transcurre por actualizacion
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;

        long referenciaActualizacion = System.nanoTime();

        long referenciaContador = System.nanoTime();

        double  tiempoTranscurrido;
        // cantidad de tiempo que transcurre hasta la actualizacion
        double delta = 0;
        //hace que la ventana sea el foco
        requestFocus();

        while (enFuncionamiento){
            //reinica el tiempo
            final long inicioBucle = System.nanoTime();
            //mide el tiempo que transcurrio entre las variables
            tiempoTranscurrido = inicioBucle - referenciaActualizacion;
            //se le da el valor del tiempo de cuando inicio el bucle
            referenciaActualizacion = inicioBucle;
            //almacena la cantidad de tiempo transcurrido
            delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;
            // cada vez que delta llegue a 1+ se actualiza
            while (delta >=1) {
                actualizar();
                delta --;
            }
            mostrar();
            if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO){
               CONTADOR_APS = "APS:" +aps;
               CONTADOR_FPS = "FPS" + fps;
                aps = 0;
                fps = 0;
                referenciaContador  = System.nanoTime();

            }
        }
    }
    
    
}
