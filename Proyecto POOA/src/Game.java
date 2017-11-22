import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JPanel;

public class Game extends JPanel implements Runnable {

	private Display ventana;
	private int ancho;
	private int alto;
	private boolean activo;
	private Thread t;
	private BufferStrategy bs;
	private Graphics g;
	private Escenario escenario;
	private Jugador jugador;
	private Enemigos enemigo;// se agrego
	private JPanel contentPane;

	public Game(int ancho, int alto) {

		super();
		this.ancho = ancho;
		this.alto = alto;

	}

	public void init() {
		escenario = new Escenario();
		jugador = new Jugador(0, 210);
		enemigo = new Enemigos();// se agrego
		ventana = new Display(ancho, alto, jugador);
		ventana.getCanvas().setFocusable(true);

	}

	public synchronized void start() {
		if (activo)
			return;
		activo = true;
		t = new Thread(this);
		t.start();
	}

	public synchronized void stop() {
		if (!activo)
			return;

		activo = false;
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void update() {
		escenario.update();
		jugador.update();
	}

	public void render() {
		bs = ventana.getCanvas().getBufferStrategy();
		if (bs == null) {
			ventana.getCanvas().createBufferStrategy(3);
			return;
		}

		g = bs.getDrawGraphics();
		g.clearRect(0, 0, ancho, alto);//
		// PINTAR ELEMENTOS

		escenario.render(g);
		jugador.render(g);
		enemigo.render(g);

		// FIN DEL PINTADO

		bs.show();
		g.dispose();

	}

	public void run() {

		init();// INICIALIZAR JUEGO
		int fps = 60;
		double nanoPerFrame = 1000000000 / fps;
		long nuevo;
		long pasado = System.nanoTime();
		double delta = 0;
		long time = 0;
		int ticks = 0;

		while (activo) {

			nuevo = System.nanoTime();
			time += nuevo - pasado;
			delta += (nuevo - pasado) / nanoPerFrame;
			pasado = nuevo;
			if (delta >= 1) {
				update();// actualizacion de las variables
				render();// repintado
				delta--;
				ticks++;
			}

			if (time >= 1000000000) {

				System.out.println("Frames por segundo " + ticks);
				ticks = 0;
				time = 0;

			}
		}
	}

}
