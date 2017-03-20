package ahorcado;

public class Tablero {
    
    private String [] nivelFacil = {"Agua","Cocina","Teclado","Silla","Perro"};
    private String [] nivelMedio = {"Murcielago","Microprocesador","Sistema Informatico"};
    private String [] nivelDificil = {"Memoria Volatil","Gestion de usuarios","Disco extraible"};
    private String palabra;
    
    public Tablero(int opc){
        switch (opc){
            case 1:
                palabra=nivelFacil[(int)(Math.random()*(5-1))];
                break;
            case 2:
                palabra=nivelMedio[(int)(Math.random()*(3-1))];
                break;
            case 3:
                palabra=nivelDificil[(int)(Math.random()*(3-1))];
        }
    }
    
    public void pintarTablero(){
        char aux[];
        palabra=palabra.toUpperCase();
        aux=palabra.toCharArray();
        for(int i=0; i<aux.length;i++){
            if(aux[i]>='A' && aux[i]<='Z'){
                System.out.print("_ ");
            }else{
                System.out.print("  ");
            }
        }
    }
}
