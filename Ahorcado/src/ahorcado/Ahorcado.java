package ahorcado;

public class Ahorcado {
    
    public static void main(String[] args) {
        
        Juego miJuego = new Juego();
        Tablero miTablero = new Tablero(miJuego.elegirDificultad());
        
        miTablero.pintarTablero();
    }
    
}
