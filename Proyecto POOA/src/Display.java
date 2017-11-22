import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Window.Type;

public class Display extends JFrame {

	private int alto;
	private int ancho;
	private Canvas canvas;
	private JButton up, down, left, right;
	private Jugador jugador;

	public Display(int ancho, int alto, Jugador jugador) {
		setAlwaysOnTop(true);

		this.alto = alto;
		this.ancho = ancho;
		this.jugador = jugador;
		this.init();

	}

	public void init() {

		setSize(ancho, alto);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		// getContentPane().setLayout(null);

		up = new JButton("");
		up.setBounds(67, 310, 33, 37);
		getContentPane().add(up);
		up.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				jugador.setMoveUp(true);
			}

			public void mouseExited(MouseEvent e) {
				jugador.setMoveUp(false);
			}

		});

		down = new JButton("");
		down.setBounds(67, 375, 33, 37);
		down.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				jugador.setMoveDown(true);
			}

			public void mouseExited(MouseEvent e) {
				jugador.setMoveDown(false);
			}
		});
		getContentPane().add(down);

		left = new JButton("");
		left.setBounds(10, 350, 40, 37);
		left.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				jugador.setMoveLeft(true);
			}

			public void mouseExited(MouseEvent e) {
				jugador.setMoveLeft(false);
			}
		});
		getContentPane().add(left);

		right = new JButton("");
		right.setBounds(110, 350, 40, 32);
		right.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				jugador.setMoveRight(true);
			}

			public void mouseExited(MouseEvent e) {
				jugador.setMoveRight(false);
			}
		});
		getContentPane().add(right);

		canvas = new Canvas();
		canvas.setLocation(0, 0);
		canvas.setSize(825, 450);
		getContentPane().add(canvas);
		getContentPane()
				.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { up, down, left, right, canvas }));
		pack();

	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

}
