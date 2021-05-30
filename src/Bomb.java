
public class Bomb extends Item {
	private int removeVidas = -1;

	public Bomb() {

	}

	public Bomb(int posicaoX, int posicaoY, int removeVidas) {
		super(posicaoX, posicaoY);
		this.removeVidas = removeVidas;
	}

	public void dropaBomb() {
		this.setPosicaoX(getPosicaoX());
		this.setPosicaoY(getPosicaoY());
	}

	public int getRemoveVidas() {
		return removeVidas;
	}

	public void setRemoveVidas(int removeVidas) {
		this.removeVidas = removeVidas;
	}

}
