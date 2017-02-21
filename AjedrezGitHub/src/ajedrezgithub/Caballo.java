package ajedrezgithub;


public class Caballo extends Pieza{
	
	public Caballo(boolean color){
		super(color);
		valor=(float)3;
	}
	public float getValor(){
		return valor;
	}

	@Override
	public void pintarPieza() {
		if(super.color==true){
			System.out.print("Cb");
		}else if(super.color==false){
			System.out.print("Cn");
		}
	}

	@Override
	public boolean validoMovimiento(Movimiento movimiento, Tablero tablero) {
		boolean esValido=false;
		if((movimiento.saltoHorizontal(movimiento)==2 && movimiento.saltoVertical(movimiento)==1) || (movimiento.saltoHorizontal(movimiento)==1 && movimiento.saltoVertical(movimiento)==2)){
			esValido=true;
		}
		return esValido;
	}


}
