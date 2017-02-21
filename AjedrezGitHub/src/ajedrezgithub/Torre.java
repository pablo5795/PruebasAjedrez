package ajedrezgithub;


public class Torre extends Pieza{

	public Torre(boolean color){
		super(color);
		valor=(float)5.5;
	}
	public float getValor(){
		return valor;
	}
	
	@Override
	public void pintarPieza() {
		if(super.color==true){
			System.out.print("Tb");
		}else if(super.color==false){
			System.out.print("Tn");
		}
	}

	@Override
	public boolean validoMovimiento(Movimiento movimiento, Tablero tablero) {
		boolean esValido=false;
		if(movimiento.esHorizontal(movimiento)==true || movimiento.esVertical(movimiento)==true){
			esValido=true;
		}
		return esValido;
	}


}
