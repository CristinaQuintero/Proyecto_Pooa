import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Portada extends JPanel {

	public Portada() {

	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Image imagen = new ImageIcon(Portada.class.getResource("/imagenes/portada4.jpg")).getImage();
		int x = getWidth() / 2 - imagen.getWidth(this) / 2;
		int y = getHeight() / 2 - imagen.getHeight(this) / 2;
		g.drawImage(imagen, x, y, this);
	}
}// FIN DE LA CLASE PORTADA
