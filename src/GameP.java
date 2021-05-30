
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class GameP extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private Player player = new Player(50, 50, 180);
	private Ghost ghost1 = new Ghost(200, 200, 0);
	private Ghost ghost2 = new Ghost(500, 0, 0);
	private Ghost ghost3 = new Ghost(0, 500, 0);
	private Ghost ghost4 = new Ghost(500, 500, 0);
	private Bomb bomb = new Bomb(100, 200, 20);
	private Booster booster = new Booster(100, 100, 5);

	private JLabel imgPlayer = new JLabel(new ImageIcon("src/images/pacman.png"));
	private JLabel imgGhost1 = new JLabel(new ImageIcon("src/images/ghost.png"));
	private JLabel imgGhost2 = new JLabel(new ImageIcon("src/images/ghost.png"));
	private JLabel imgGhost3 = new JLabel(new ImageIcon("src/images/ghost.png"));
	private JLabel imgGhost4 = new JLabel(new ImageIcon("src/images/ghost.png"));
	private JLabel imgBomb = new JLabel(new ImageIcon("src/images/bomb.png"));
	private JLabel imgBooster = new JLabel(new ImageIcon("src/images/booster.png"));

	private final int SCREENSIZE = 600;
	private int speed = 50;
	private int turno = 0;

	public static void main(String[] args) {
		new GameP().init();
	}

	private void init() {
		setLayout(null);
		player.setTelaX(SCREENSIZE);
		player.setTelaY(SCREENSIZE);
		player.setQtdeVidas(10);

		ghost1.setTelaX(SCREENSIZE);
		ghost1.setTelaY(SCREENSIZE);
		ghost1.setDirecaoGhost(SCREENSIZE);

		ghost2.setTelaX(SCREENSIZE);
		ghost2.setTelaY(SCREENSIZE);
		ghost2.setDirecaoGhost(SCREENSIZE);

		ghost3.setTelaX(SCREENSIZE);
		ghost3.setTelaY(SCREENSIZE);
		ghost3.setDirecaoGhost(SCREENSIZE);

		ghost4.setTelaX(SCREENSIZE);
		ghost4.setTelaY(SCREENSIZE);
		ghost4.setDirecaoGhost(SCREENSIZE);

		booster.setTelaX(SCREENSIZE);
		booster.setTelaY(SCREENSIZE);
		booster.setDuracaoBooster(15);
		booster.setVisivel(true);

		bomb.setTelaX(SCREENSIZE);
		bomb.setTelaY(SCREENSIZE);
		bomb.setRemoveVidas(-1);
		bomb.setVisivel(true);

		add(imgPlayer);
		add(imgGhost1);
		add(imgGhost2);
		add(imgGhost3);
		add(imgGhost4);
		add(imgBomb);
		add(imgBooster);

		render();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(SCREENSIZE + 100, SCREENSIZE + 100);
		setVisible(true);
		addKeyListener(this);

		run();
	}

	private void render() {

		updateLocation(imgPlayer, player);
		updateLocation(imgGhost1, ghost1);
		updateLocation(imgGhost2, ghost2);
		updateLocation(imgGhost3, ghost3);
		updateLocation(imgGhost4, ghost4);
		updateLocation(imgBomb, bomb);
		updateLocation(imgBooster, booster);
		setTitle("Life: " + player.getQtdeVidas());
		if (bomb.isVisivel() == false) {
			this.remove(imgBomb);
		}
		if (bomb.isVisivel() == true) {
			this.add(imgBomb);
		}
		if (booster.isVisivel() == false) {
			this.remove(imgBooster);
		}
		if (booster.isVisivel() == true) {
			this.add(imgBooster);
		}
		SwingUtilities.updateComponentTreeUI(this);

	}

	private void updateLocation(JLabel label, GameObject object) {
		label.setBounds(object.getPosicaoX(), object.getPosicaoY(), 50, 50);
		ImageIcon myImage = (ImageIcon) label.getIcon();
		Image img = myImage.getImage();
		Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		label.setIcon(new ImageIcon(newImg));
	}

	private void run() {
		int desligarInvencibilidade = 0;
		
		while (player.getQtdeVidas() > 0) {
			turno++;
			
			player.movimentaPlayer();
			ghost1.movimentaGhost();
			ghost2.movimentaGhost();
			ghost3.movimentaGhost();
			ghost4.movimentaGhost();
			booster.dropaBooster();
			bomb.dropaBomb();

			if (player.getPosicaoX() == booster.getPosicaoX() && player.getPosicaoY() == booster.getPosicaoY()) {
				desligarInvencibilidade = turno + booster.getDuracaoBooster();
				booster.setVisivel(false);
				player.setInvencivel(true);
				System.out.println("Está invencível!");
			}
			
			if (desligarInvencibilidade == turno) {
				player.setInvencivel(false);
				double aleatorio = (Math.random()* booster.getTelaX());
				booster.setPosicaoX((int) (aleatorio / 10) * 10);
				booster.setPosicaoY((int) (aleatorio / 10) * 10);
				booster.setVisivel(true);
				System.out.println("Não está mais invencível");
			}
			

			if (player.getPosicaoX() == bomb.getPosicaoX() && player.getPosicaoY() == bomb.getPosicaoY()) {
				int perdeuVida = player.getQtdeVidas() - 1;
				player.setQtdeVidas(perdeuVida);
				bomb.setVisivel(false);
				System.out.println("Perdeu uma vida!");
			}
			
			
			if (player.getPosicaoX() == ghost1.getPosicaoX() && player.getPosicaoY() == ghost1.getPosicaoY()) {
				int perdeuVida = player.getQtdeVidas() - 1;
				player.setQtdeVidas(perdeuVida);
				System.out.println("Ghost1 te deu um tapa!");
			}
			if (player.getPosicaoX() == ghost2.getPosicaoX() && player.getPosicaoY() == ghost2.getPosicaoY()) {
				int perdeuVida = player.getQtdeVidas() - 1;
				player.setQtdeVidas(perdeuVida);
				System.out.println("Ghost2 te deu um tapa!");
			}
			if (player.getPosicaoX() == ghost3.getPosicaoX() && player.getPosicaoY() == ghost3.getPosicaoY()) {
				int perdeuVida = player.getQtdeVidas() - 1;
				player.setQtdeVidas(perdeuVida);
				System.out.println("Ghost3 te deu um tapa!");
			}
			if (player.getPosicaoX() == ghost4.getPosicaoX() && player.getPosicaoY() == ghost4.getPosicaoY()) {
				int perdeuVida = player.getQtdeVidas() - 1;
				player.setQtdeVidas(perdeuVida);
				System.out.println("Ghost4 te deu um tapa!");
			}

			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			render();

		}
		JOptionPane.showMessageDialog(this,"Parabéns! Você conseguiu sobreviver por " + turno + " turnos");

	}

	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if (c == '8' || c == 'w')
			player.setDirecao(90);
		if (c == '6' || c == 'd')
			player.setDirecao(0);
		if (c == '2' || c == 's')
			player.setDirecao(270);
		if (c == '4' || c == 'a')
			player.setDirecao(180);
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
