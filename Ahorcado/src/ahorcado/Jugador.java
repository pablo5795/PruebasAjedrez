package ahorcado;

public class Jugador {
    private String nombre;
    private int vidas;
    private String fallos;
    
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
    
    public void getFallos(){
        System.out.print("Letras falladas: ");
        if(fallos==null){
            System.out.println(" ");
        }else{
            System.out.println(fallos);
        }
    }
    public void setFallos(char letra){
        if(fallos==null){
            fallos=""+letra;
        }else{
            fallos=fallos+" "+letra;
        }
    }
}
