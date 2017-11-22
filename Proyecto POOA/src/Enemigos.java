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
				 * MOVIMIENTO DE ENEMIGO X es una constante fija: Es el valor
				 * del tamano dela ventana, las condiciones siguientes, se
				 * ejecutaran hasta que el valor de x cambie consecutivamente y
				 * cumpla la condicion; Es decir al llegar al marco contrario
				 * cambiara de direccion (izquierda derecha).
				 * 
				 */
				while (x > 10) {
					Thread.sleep(150);
					x -= 10;
					repaint();
					// System.out.print("izq" + x);
				}
				while (x < 800) {
					Thread.sleep(150);
					x += 10;
					repaint();
					// System.out.print("derecha\n" + x);
				}

			}
		} catch (Exception e) {
			System.out.println("Sucedio un error" + e.getMessage());
		}

	}

}// FIN DE LA CLASE ENEMIGO