import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class ZombieAttack extends JFrame {

	private JPanel contentPane;
	private JPanel pnlJugar;
	private Enemigos enemigo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZombieAttack frame = new ZombieAttack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ZombieAttack() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ZombieAttack.class.getResource("/Imagenes/Zombie-icon.png")));
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Z o m b i e _ A t t a c k ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 825, 378);// dimension de la ventana-825x378 tamano
										// de la Portada
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		final JPanel panelJuego = new JPanel();
		contentPane.add(panelJuego, BorderLayout.CENTER);
		panelJuego.setLayout(new CardLayout(0, 0));

		Portada pnlPresentacion = new Portada();
		panelJuego.add(pnlPresentacion, "Portada");
		pnlPresentacion.setLayout(null);

		Game pnlJugar = new Game(825, 450);
		panelJuego.add(pnlJugar, "Juego");
		pnlJugar.setLayout(null);

		JButton btnJugar = new JButton("J U G A R");
		btnJugar.setForeground(new Color(255, 140, 0));
		btnJugar.setBackground(new Color(0, 0, 0));
		btnJugar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnJugar.setBounds(327, 296, 143, 23);

		pnlPresentacion.add(btnJugar);
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlJugar.start();// inicia el juego
				setVisible(false);// ventana principal desaparece

			}
		});

	}
}// FIN DE LA CLASE PRINCIPAL
