
public class Booster extends Item {
	private int duracaoBooster;

	public Booster() {
	}

	public Booster(int posicaoX, int posicaoY, int duracaoBooster) {
		super(posicaoX, posicaoY);
		this.duracaoBooster = duracaoBooster;
	}

	public void dropaBooster() {
		this.setPosicaoX(getPosicaoX());
		this.setPosicaoY(getPosicaoY());
		this.setDuracaoBooster(duracaoBooster);
	}

	public int getDuracaoBooster() {
		return duracaoBooster;
	}

	public void setDuracaoBooster(int duracaoBooster) {
		this.duracaoBooster = duracaoBooster;
	}

}
