package ahorcado;

public class Tablero {
    
    private String [] nivelFacil = {"Agua","Cocina","Teclado","Silla","Perro"};
    private String [] nivelMedio = {"Murcielago","Microprocesador","Sistema Informatico"};
    private String [] nivelDificil = {"Memoria Volatil","Gestion de usuarios","Disco extraible"};
    private String palabra;
    private String palabra2;
    
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
        char aux[]=new char [palabra.length()];
        for(int i=0; i<palabra.length();i++){
            if((palabra.charAt(i)>='A' && palabra.charAt(i)<='Z') || (palabra.charAt(i)>='a' && palabra.charAt(i)<='z'))
                aux[i]='_';
            else
                aux[i]=' ';
        }
        palabra2=String.valueOf(aux);
    }
    
    public void setPalabra2(int pos, char letra){
        char aux2[]=new char [palabra2.length()];
        aux2=palabra2.toCharArray();
        for(int i=0; i<palabra.length(); i++){
            aux2[i]=palabra2.charAt(i);
            if(i==pos){
                aux2[i]=letra;
            }
        }
        palabra2=String.valueOf(aux2);
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
        System.out.println("");
    }
    
    public boolean buscarLetra(char letra){
        boolean hayLetra=false;
        if(letra>='a' && letra<='z'){
            letra=(char) ((int)letra-32);
        }
        char aux[];
        palabra=palabra.toUpperCase();
        aux=palabra.toCharArray();
        for(int i=0;i<aux.length && hayLetra==false;i++){
            if(aux[i]==letra){
                hayLetra=true;
            }
        }
        return hayLetra;
    }
    
    public void mostrarLetra(char letra){
        char aux[];
        palabra=palabra.toUpperCase();
        aux=palabra.toCharArray();
        if(letra>='a' && letra<='z'){
            letra=(char) ((int)letra-32);
        }
        for(int i=0;i<aux.length;i++){
            if(aux[i]>='A' && aux[i]<='Z'){
                if(aux[i]==letra){
                    setPalabra2(i, letra);
                }
            }else{
                System.out.print("  ");
            }
        }
        
        for(int i=0; i<palabra2.length();i++){
            System.out.print(palabra2.charAt(i)+" ");
        }
        System.out.println("");
    }
    
    public boolean verFinal(){
        boolean fin=false;
        if(palabra2.equalsIgnoreCase(palabra)){
            fin=true;
        }
        return fin;
    }
}
