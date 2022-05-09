package graficos;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class HojaSprites {
    private final int ancho;
    private final int alto;
    public final int [] pixeles;

    //Hojas de Sprites
    public static HojaSprites desierto = new HojaSprites("/texturas/desierto.png", 320 , 320 );


    //fin Hoja de Sprites

    public HojaSprites(final String ruta, final  int ancho, final int alto){

        this.ancho = ancho;
        this.alto = alto;

        pixeles = new int[ancho * alto];

        BufferedImage imagen = null;
        try {
            //crea imagen y le da el valor de la ruta
            imagen = ImageIO.read(HojaSprites.class.getResource(ruta));
            // atribuye el color de cada pixel corespondiente
            imagen.getRGB(0,0, ancho,alto,pixeles, 0 ,ancho);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     public int obtenAncho(){
        return ancho;
     }
}
