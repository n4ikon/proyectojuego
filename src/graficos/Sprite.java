package graficos;

public final class Sprite {
    private final int lado;

    private int x;
    private int y;

    public int[] pixeles;

    private HojaSprites hoja;
    //Sprites jugador
    public static final Sprite ABAJO0 = new Sprite (32,0,0,0,HojaSprites.jugador);
    public static final Sprite ABAJO1 = new Sprite (32,0,1,0,HojaSprites.jugador);
    public static final Sprite ABAJO2 = new Sprite (32,0,2,0,HojaSprites.jugador);
    public static final Sprite ARRIBA0 = new Sprite (32,1,0,0,HojaSprites.jugador);
    public static final Sprite ARRIBA1 = new Sprite (32,1,1,0,HojaSprites.jugador);
    public static final Sprite ARRIBA2 = new Sprite (32,1,2,0,HojaSprites.jugador);
    public static final Sprite DERECHA0 = new Sprite (32,2,0,0,HojaSprites.jugador);
    public static final Sprite DERECHA1 = new Sprite (32,2,1,0,HojaSprites.jugador);
    public static final Sprite DERECHA2 = new Sprite (32,2,2,0,HojaSprites.jugador);
    public static final Sprite IZQUIERDA0 = new Sprite (32,3,0,0,HojaSprites.jugador);
    public static final Sprite IZQUIERDA1 = new Sprite (32,3,1,0,HojaSprites.jugador);
    public static final Sprite IZQUIERDA2 = new Sprite (32,3,2,0,HojaSprites.jugador);

    //fin jugador

    // Sprites mapa
    public static final Sprite VACIO = new Sprite(32, 0);
    public static final Sprite CRUCE = new Sprite(32, 0, 0, 0, HojaSprites.desierto);
    public static final Sprite ASFALTO = new Sprite(32, 1, 0, 0, HojaSprites.desierto);
    public static final Sprite CRUCEROTADO = new Sprite(32, 0, 0, 4, HojaSprites.desierto);
    public static final Sprite ARBOL = new Sprite(32, 2, 0, 0, HojaSprites.desierto);
    public static final Sprite PARED1 = new Sprite(32, 3, 0, 0, HojaSprites.desierto);
    public static final Sprite AUTO = new Sprite(32, 1, 1, 0, HojaSprites.desierto);
    public static final Sprite AUSTRAL1 = new Sprite(32, 4, 0, 0, HojaSprites.desierto);
    public static final Sprite AUSTRAL2 = new Sprite(32, 5, 0, 0, HojaSprites.desierto);
    public static final Sprite AUSTRAL3 = new Sprite(32, 6, 0, 0, HojaSprites.desierto);
    public static final Sprite AUSTRAL4 = new Sprite(32, 7, 0, 0, HojaSprites.desierto);
    public static final Sprite AUSTRAL5 = new Sprite(32, 8, 0, 0, HojaSprites.desierto);
    public static final Sprite AUSTRAL6 = new Sprite(32, 9, 0, 0, HojaSprites.desierto);
    public static final Sprite AUSTRAL7 = new Sprite(32, 4, 1, 0, HojaSprites.desierto);
    public static final Sprite AUSTRAL8 = new Sprite(32, 5, 1, 0, HojaSprites.desierto);
    public static final Sprite AUSTRAL9 = new Sprite(32, 6, 1, 0, HojaSprites.desierto);
    public static final Sprite AUSTRAL10 = new Sprite(32, 7, 1, 0, HojaSprites.desierto);
    public static final Sprite AUSTRAL11 = new Sprite(32, 8, 1, 0, HojaSprites.desierto);
    public static final Sprite AUSTRAL12 = new Sprite(32, 9, 1, 0, HojaSprites.desierto);
    public static final Sprite AUSTRAL13 = new Sprite(32, 4, 2, 0, HojaSprites.desierto);
    public static final Sprite AUSTRAL14 = new Sprite(32, 5, 2, 0, HojaSprites.desierto);
    public static final Sprite AUSTRAL15 = new Sprite(32, 6, 2, 0, HojaSprites.desierto);
    public static final Sprite AUSTRAL16 = new Sprite(32, 7, 2, 0, HojaSprites.desierto);
    public static final Sprite AUSTRAL17 = new Sprite(32, 8, 2, 0, HojaSprites.desierto);
    public static final Sprite AUSTRAL18 = new Sprite(32, 9, 2, 0, HojaSprites.desierto);
    public static final Sprite PISO1 = new Sprite(32, 0, 1, 0, HojaSprites.desierto);
    public static final Sprite PUPI = new Sprite(32, 2, 1, 0, HojaSprites.desierto);
    public static final Sprite ENEMIGO = new Sprite(32, 3, 1, 0, HojaSprites.desierto);


    //fin Sprites

    public Sprite(final int lado, final int columna, final int fila, final int version, final HojaSprites hoja) {

        this.lado = lado;
        pixeles = new int[lado * lado];
        this.x = columna * lado;
        this.y = fila * lado;
        this.hoja = hoja;

        cargarSprite(version);


    }

    public Sprite(final int lado, final int color) {
        this.lado = lado;
        pixeles = new int[lado * lado];
        for (int i = 0; i < pixeles.length; i++) {
            pixeles[i] = color;
        }
    }

    public int obtenLado() {
        return lado;
    }

    private void cargarSprite(int version) {
        if (version == 0) {
            cargarNormal();
        } else {
            cargaManipulada(version);
        }
    }

    private void cargarNormal() {
        for (int y = 0; y < lado; y++) {
            for (int x = 0; x < lado; x++) {
                pixeles[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.obtenAncho()];

            }
        }
    }

    private void cargaManipulada(int version) {
        int[] pixelesTemporales = iniciarPixelesTemporales();
        switch (version) {
            case 1:
                invertirX(pixelesTemporales);
                break;
            case 2:
                invertirY(pixelesTemporales);
                break;
            case 3:
                invertirXY(pixelesTemporales);
                break;
            case 4:
                rotar90I(pixelesTemporales);
                break;
            case 5:
                rotar90D(pixelesTemporales);
                break;
            case 6:
                rotar90IYinvertido(pixelesTemporales);
                break;
            case 7:
                rotar90DYinvetido(pixelesTemporales);
                break;
            default:
                cargarNormal();
        }
    }

    private int[] iniciarPixelesTemporales() {
        int[] pixelesTemporales = new int[lado * lado];
        for (int y = 0; y < lado; y++) {
            for (int x = 0; x < lado; x++) {
                pixelesTemporales[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.obtenAncho()];

            }
        }
        return pixelesTemporales;
    }

    private void invertirX(int[] pixelesTemporales) {
        int i = 0 ;
        for (int y = 0; y < lado ; y++) {
            for (int x = lado -1; x >-1 ; x--) {
                pixeles[i] = pixelesTemporales[x + y * lado];
                i++;

            }
            
        }

    }

    private void invertirY(int[] pixelesTemporales) {
        int i = 0 ;
        for (int y = lado - 1 ; y >-1 ; y--) {
            for (int x = 0 ; x <lado ; x++) {
                pixeles[i] = pixelesTemporales[x + y * lado];
                i++;

            }

        }

    }

    private void invertirXY(int[] pixelesTemporales) {
        for (int i = 0; i < pixeles.length; i++) {
            pixeles[i] =pixelesTemporales[pixelesTemporales.length -1 -i];
            
        }

    }

    private void rotar90I(int[] pixelesTemporales) {
        int i = 0 ;
        for (int x = lado-1; x > -1  ; x--) {
            for (int y = 0 ; y < lado ; y++) {
                pixeles[i] = pixelesTemporales[x + y * lado];
                i++;

            }

        }

    }

    private void rotar90D(int[] pixelesTemporales) {
        int i = 0;
        for (int x =0 ; x < lado  ; x++) {
            for (int y = lado - 1 ; y > -1  ; y--) {
                pixeles[i] = pixelesTemporales[x + y * lado];
                i++;

            }

        }

    }

    private void rotar90IYinvertido(int[] pixelesTemporales) {
        int i = 0;
        for (int x =0 ; x < lado  ; x++) {
            for (int y = 0 ; y <lado   ; y++) {
                pixeles[i] = pixelesTemporales[x + y * lado];
                i++;

            }

        }

    }

    private void rotar90DYinvetido(int[] pixelesTemporales) {
        int i = 0;
        for (int x =lado-1 ; x > -1  ; x--) {
            for (int y = lado -1 ; y > -1   ; y--) {
                pixeles[i] = pixelesTemporales[x + y * lado];
                i++;

            }

        }
    }

}
