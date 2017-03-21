package ahorcado;

import java.io.IOException;
import java.util.Scanner;

public class Ahorcado {
    
    public static void main(String[] args) throws IOException {
        
        Juego miJuego = new Juego();
        Jugador miJugador = miJuego.nuevoJugador();
        Tablero miTablero = new Tablero(miJuego.elegirDificultad());
        
        Scanner teclado = new Scanner(System.in);
        char letra;
        
        miTablero.pintarTablero();
        do{
            miJugador.getFallos();
            System.out.print("Introduzca letra: ");
            letra = (char) System.in.read();
            System.in.read();
            if(miTablero.buscarLetra(letra)){
                miTablero.mostrarLetra(letra);
            }else{
                System.out.println("Esa letra no se encuentra en la palabra");
                miJugador.setVidas();
                miJugador.setFallos(letra);
            }
            System.out.println("Te quedan "+miJugador.getVidas()+" vidas, "+miJugador.getNombre());
        }while(miJugador.getVidas()>0);
    }
    
}
