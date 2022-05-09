package graficos;

public final class Sprite {
    private final int lado;

    private int x;
    private int y;

    public int [] pixeles;

    private  HojaSprites hoja;

    // Sprites
    public static final Sprite VACIO = new Sprite(32, 0);
    public static final Sprite CRUCE = new Sprite(32, 0, 0, HojaSprites.desierto);
    public static final Sprite ASFALTO = new Sprite(32, 1, 0, HojaSprites.desierto);
    public static final Sprite ARBOL = new Sprite (32,2,0, HojaSprites.desierto);
    public static final Sprite PARED1 = new Sprite (32,3,0, HojaSprites.desierto);
    public static final Sprite AUTO = new Sprite (32,4,0, HojaSprites.desierto);
    public static final Sprite AUSTRAL1 = new Sprite (32,5,0, HojaSprites.desierto);
    public static final Sprite AUSTRAL2 = new Sprite (32,6,0, HojaSprites.desierto);
    public static final Sprite AUSTRAL3 = new Sprite (32,7,0, HojaSprites.desierto);
    public static final Sprite AUSTRAL4 = new Sprite (32,8,0, HojaSprites.desierto);
    public static final Sprite AUSTRAL5 = new Sprite (32,5,1, HojaSprites.desierto);
    public static final Sprite AUSTRAL6 = new Sprite (32,6,1, HojaSprites.desierto);
    public static final Sprite AUSTRAL7 = new Sprite (32,7,1, HojaSprites.desierto);
    public static final Sprite AUSTRAL8 = new Sprite (32,8,1, HojaSprites.desierto);
    public static final Sprite PISO1 = new Sprite (32,0,1, HojaSprites.desierto);
    public static final Sprite PUPI = new Sprite (32,9,0, HojaSprites.desierto);
    
    

    //fin Sprites

    public Sprite(final int lado , final int columna, final int fila, final HojaSprites hoja){

        this.lado = lado;
        pixeles = new int[lado * lado];
        this.x = columna * lado;
        this.y = fila * lado;
        this.hoja = hoja;

        for (int y =0; y<lado; y++){
            for (int x = 0; x<lado; x++){
                pixeles[x + y * lado] = hoja.pixeles[(x +this.x ) + (y + this.y) * hoja.obtenAncho()];

            }
        }

    }
    public Sprite(final int lado , final int color) {
    	this.lado = lado;
    	pixeles = new int[lado * lado];
    	for (int i = 0; i < pixeles.length; i++) {
    		pixeles[i] = color;
    	}
    }
    public int obtenLado() {
    	return lado;
    }
}
