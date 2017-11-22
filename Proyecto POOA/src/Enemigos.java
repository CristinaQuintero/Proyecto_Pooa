import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Enemigos extends JPanel implements Runnable {

	int x = 810;
	Thread hilo;

	public Enemigos() {
		setBackground(Color.DARK_GRAY);
		hilo = new Thread(this);
		hilo.start();
	}

	public void render(Graphics g) {

		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		Image imagen = new ImageIcon(Enemigos.class.getResource("/imagenes/enemigo12.png")).getImage();
		g.drawImage(imagen, x, 210, this);

	}

	public void run() {

		try {
			while (true) {
				/*
				 * MOVIMIENTO DE ENEMIGO EN EL CAMPO SIN DESAPARECER x tiene el
				 * valor del tamano de la ventana, al iniciar el valor de x va
				 * disminuyendo el cual la imagen va recorriendose ala derecha
				 * hasta que tope con el marco. Al llegar a x=0 , se ejecutara
				 * la siguiente condicion
				 */
				while (x > 10) {
					Thread.sleep(150);
					x -= 10;
					repaint();
					// System.out.print("derecha" + x);
				}
				while (x < 800) {
					Thread.sleep(150);
					x += 10;
					repaint();
					// System.out.print("izq\n" + x);
				}

			}
		} catch (Exception e) {
			System.out.println("Sucedio un error" + e.getMessage());
		}

	}

}// FIN DE LA CLASE ENEMIGO