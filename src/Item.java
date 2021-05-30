
public class Item extends GameObject {
	private boolean visivel;

	public Item() {

	}
	
	public Item(int posicaoX, int posicaoY) {
		super(posicaoX, posicaoY);
		
	}

	public Item(int posicaoX, int posicaoY, boolean visivel) {
		super(posicaoX, posicaoY);
		this.visivel = visivel;
	}

	public boolean isVisivel() {
		return visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

}
