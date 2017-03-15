package ajedrezgithub;


public class Alfil extends Pieza{
	
	public Alfil(boolean color){
		super(color);
		valor=(float)3.5;
	}
	public float getValor(){
		return valor;
	}
	
	@Override
	public void pintarPieza() {
		if(super.color==true){
			System.out.print("Ab");
		}else if(super.color==false){
			System.out.print("An");
		}
	}

	@Override
	public boolean validoMovimiento(Movimiento movimiento, Tablero tablero) {
		boolean esValido=false;
		if(movimiento.esDiagonal(movimiento)==true){
			esValido=true;
		}
		return esValido;		
	}


}
