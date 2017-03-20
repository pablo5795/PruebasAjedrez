package ahorcado;

public class Jugador {
    private String nombre;
    private int vidas;
    
    public Jugador(String nombre){
        this.nombre=nombre;
        vidas=6;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getVidas(){
        return vidas;
    }
    public void setVidas(){
        vidas-=1;
    }
    
}
