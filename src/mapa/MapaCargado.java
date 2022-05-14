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
				case 0xffff9000:
						cuadrosCatalogo[i] = Cuadro.AUSTRAL1;
						continue;
				case 0xff930000:
					cuadrosCatalogo[i] = Cuadro.AUSTRAL2;
					continue;
				case 0xfffc1000:
					cuadrosCatalogo[i] = Cuadro.AUSTRAL3;
					continue;
				case 0xfffc0000:
					cuadrosCatalogo[i] = Cuadro.AUSTRAL4;
					continue;
				case 0xfffc4200:
					cuadrosCatalogo[i] = Cuadro.AUSTRAL5;
					continue;
				case 0xffffe647:
					cuadrosCatalogo[i]= Cuadro.AUSTRAL6;
					continue;
				case 0xffFF8707:
					cuadrosCatalogo[i] = Cuadro.AUSTRAL7;
					continue;
				case 0xfffc6900:
					cuadrosCatalogo[i] = Cuadro.AUSTRAL8;
					continue;
				case 0xfffc7C00:
					cuadrosCatalogo[i] = Cuadro.AUSTRAL9;
					continue;
				case 0xfffc9f00:
					cuadrosCatalogo[i] = Cuadro.AUSTRAL10;
					continue;
				case 0xfffccd00:
					cuadrosCatalogo[i] = Cuadro.AUSTRAL11;
					continue;
				case 0xffF7FF2B:
					cuadrosCatalogo[i] = Cuadro.AUSTRAL12;
					continue;
				case 0xffFF7700:
					cuadrosCatalogo[i] = Cuadro.AUSTRAL13;
					continue;
				case 0xffFF6A00:
					cuadrosCatalogo[i] = Cuadro.AUSTRAL14;
				case 0xffFFC802:
					cuadrosCatalogo[i] = Cuadro.AUSTRAL15;
					continue;
				case 0xffFFEE00:
					cuadrosCatalogo[i] =Cuadro.AUSTRAL16;
					continue;
				case 0xffFFFA00:
					cuadrosCatalogo[i] = Cuadro.AUSTRAL17;
					continue;
				case 0xffE7FF14:
					cuadrosCatalogo[i] = Cuadro.AUSTRAL18;
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
                case 0xff051EFF:
                    cuadrosCatalogo[i] = Cuadro.CRUCEROTADO;
					continue;
				case 0xff6393C2:
					cuadrosCatalogo[i] = Cuadro.ENEMIGO;
					continue;
				default:
					cuadrosCatalogo[i] = Cuadro.Vacio;
					
				
					
				}
			}
		}
	}
	


