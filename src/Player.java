public class Player extends GameObject {
	private int direcao;
	private int qtdeVidas;
	private boolean invencivel = false;

	public Player() {
	}

	public Player(int direcao, int qtdeVidas, boolean invencivel) {
		super();
		if (direcao < 0 || direcao > 360) {
			System.out.println("Direção inválida.");
		}
		this.direcao = direcao;
		if (qtdeVidas <= 0) {
			System.out.println("Quantidade de vidas inválida");
		}
		this.qtdeVidas = qtdeVidas;
		this.invencivel = invencivel;
	}

	public Player(int getPosicaoX, int getPosicaoY, int direcao) {
		if (direcao < 0 || direcao > 360) {
			System.out.println("Direção inválida.");
			this.direcao = direcao;
		}
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
		int novoXPlayer = this.getPosicaoX();

		if (direcao < 90 && direcao >= 0) {
			novoXPlayer += 10;
		}
		if (direcao < 270 && direcao >= 180) {
			novoXPlayer -= 10;
		}
		return novoXPlayer;
	}

	private int novoY() {
		int novoYPlayer = this.getPosicaoY();

		if (direcao < 180 && direcao >= 90) {
			novoYPlayer -= 10;
		}
		if (direcao < 360 && direcao >= 270) {
			novoYPlayer += 10;
		}
		return novoYPlayer;
	}

	public void movimentaPlayer() {

		if (podeSeMover()) {
			this.setPosicaoX(novoX());
			this.setPosicaoY(novoY());
		}
	}

	public int getDirecao() {
		return direcao;
	}

	public void setDirecao(int direcao) {
		this.direcao = direcao;
	}

	public int getQtdeVidas() {
		return qtdeVidas;
	}

	public void setQtdeVidas(int qtdeVidas) {
		this.qtdeVidas = qtdeVidas;
	}

	public boolean isInvencivel() {
		return invencivel;
	}

	public void setInvencivel(boolean invencivel) {
		this.invencivel = invencivel;
	}

}
