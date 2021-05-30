
public class GameObject {
	private int posicaoX;
	private int posicaoY;
	
	private int telaX = 100;
	private int telaY = 100;
	private int telaTotal = telaX * telaY;
	
	
	

	public GameObject() {	
	}
	
	public GameObject(int posicaoX, int posicaoY) {
		super();
		if (posicaoX < 0 || posicaoY < 0) {
			System.out.println("Posição inválida");
			
		}
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
	}

	
	public int getPosicaoX() {
		return posicaoX;
	}

	public void setPosicaoX(int posicaoX) {
		if (posicaoX < 0) {
			System.out.println("Posição inválida");
			this.posicaoX = 0;
		}
		this.posicaoX = posicaoX;
	}

	public int getPosicaoY() {
		return posicaoY;
	}

	public void setPosicaoY(int posicaoY) {
		if (posicaoY < 0) {
			System.out.println("Posição inválida");
			this.posicaoY = 0;
		}
		this.posicaoY = posicaoY;
	}

	public int getTelaX() {
		return telaX;
	}

	public void setTelaX(int telaX) {
		if (telaX < 0) {
			System.out.println("Posição inválida");
			this.telaX = 0;
		}
		this.telaX = telaX;
	}

	public int getTelaY() {
		return telaY;
	}

	public void setTelaY(int telaY) {
		if (telaY < 0) {
			System.out.println("Posição inválida");
			this.telaY = 0;
		}
		this.telaY = telaY;
	}
	
	public int getTelaTotal() {
		return telaTotal;
	}
	
	public void setTelaTotal(int telaTotal) {
		this.telaTotal = telaTotal;
	}
	

	
	
}
