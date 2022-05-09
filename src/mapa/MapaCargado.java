package mapa;
import javax.imageio.ImageIO;

import mapa.cuadro.Cuadro;

import java.awt.image.BufferedImage;
import java.io.IOException;


public class MapaCargado extends Mapa{
	private int[] pixeles;

	public MapaCargado(String ruta) {
		super(ruta);
		
	}
	protected void cargarMapa(String ruta) {
		try { BufferedImage imagen = ImageIO.read(MapaCargado.class.getResource(ruta));
		
			ancho = imagen.getWidth();
			alto = imagen.getHeight();
			
			cuadrosCatalogo = new Cuadro[ancho * alto];
			pixeles = new int[ancho * alto];
			
			imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
			
		}catch ( IOException e) {
			e.printStackTrace(); 
			
		}
		
	}
		protected void generarMapa() {
			for (int i = 0; i < pixeles.length; i++) {
				switch ( pixeles[i] ) {
				case  0xff959595:
				     cuadrosCatalogo[i] = Cuadro.PISO1;
				    continue;			    
				case 0xff930000:
					cuadrosCatalogo[i] = Cuadro.AUSTRAL1;
					continue;
				case 0xfffc1000:
					cuadrosCatalogo[i] = Cuadro.AUSTRAL2;
					continue;
				case 0xfffc0000:
					cuadrosCatalogo[i] = Cuadro.AUSTRAL3;
					continue;
				case 0xfffc4200:
					cuadrosCatalogo[i] = Cuadro.AUSTRAL4;
					continue;
				case 0xfffc6900:
					cuadrosCatalogo[i]= Cuadro.AUSTRAL5;
					continue;
				case 0xfffc7c00:
					cuadrosCatalogo[i] = Cuadro.AUSTRAL6;
					continue;
				case 0xfffc9f00:
					cuadrosCatalogo[i] = Cuadro.AUSTRAL7;
					continue;
				case 0xfffccd00:
					cuadrosCatalogo[i] = Cuadro.AUSTRAL8;
					continue;
				case 0xff14009f:
					cuadrosCatalogo[i] = Cuadro.ASFALTO;
					continue;
				case 0xff1400f9:
					cuadrosCatalogo[i]= Cuadro.CRUCE;
					continue;
				case 0xff14003A:
					cuadrosCatalogo[i] = Cuadro.PUPI;
					continue;
				case 0xff14ff3A:
					cuadrosCatalogo[i] = Cuadro.AUTO;
					continue;
				case 0xff2AF74C:
					cuadrosCatalogo[i] = Cuadro.ARBOL;
					continue;
				default:
					cuadrosCatalogo[i] = Cuadro.Vacio;
					
				
					
				}
			}
		}
	}
	


