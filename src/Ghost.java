
public class Ghost extends GameObject {
	private int direcaoGhost;

	public Ghost() {
	}

	public Ghost(int posicaoX, int posicaoY, int direcao) {
		super(posicaoX, posicaoY);
		direcaoGhost = direcao;
	}

	public boolean podeSeMover() {
		int x = novoX();
		int y = novoY();
		if (x >= 0 && x <= getTelaX() && y >= 0 && y <= getTelaY()) {
			return true;
		}
		return false;

	}

	private int novoX() {
		int novoXGhost = this.getPosicaoX();

		if (direcaoGhost <= 90 && direcaoGhost >= 0) {
			novoXGhost += 10;
		}
		if (direcaoGhost <= 270 && direcaoGhost > 180) {
			novoXGhost -= 10;
		}
		return novoXGhost;
	}

	private int novoY() {
		int novoYGhost = this.getPosicaoY();

		if (direcaoGhost <= 180 && direcaoGhost > 90) {
			novoYGhost -= 10;
		}
		if (direcaoGhost <= 360 && direcaoGhost > 270) {
			novoYGhost += 10;
		}
		return novoYGhost;
	}

	public void movimentaGhost() {

		int direcaoAleatoria = (int) (360 * Math.random());
		this.setDirecaoGhost(direcaoAleatoria);

		if (podeSeMover()) {
			this.setPosicaoX(novoX());
			this.setPosicaoY(novoY());
		}
	}

	public int getDirecaoGhost() {
		return direcaoGhost;
	}

	public void setDirecaoGhost(int direcaoGhost) {
		if (direcaoGhost < 0) {
			System.out.println("Direção inválida.");
		}
		this.direcaoGhost = direcaoGhost;
	}
}
