import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Jugador {
	
	private int x;
	private int y;
	private int dx;
	private int dy;
	private SpriteManager sm;
	private BufferedImage imagen;
	private boolean moveLeft;
	private boolean moveRight;
	private boolean moveUp;
	private boolean moveDown;
	private boolean noMovement;
	public static BufferedImage[] jugadorIzquierda;
	public static BufferedImage[] jugadorDerecha;
	public static BufferedImage[] jugadorUp;
	public static BufferedImage[] jugadorDown;
	private Animacion jugadorIzq;
	private Animacion jugadorDer;
	private Animacion jugadorUpp;
	private Animacion jugadorDownn;
	
	public Jugador(int x, int y){
		
		this.x = x;
		this.y = y;
		dx = 1;
		dy = 1;
		moveLeft = false;
		moveRight = false;
		moveUp = false;
		moveDown = false;
		sm = new SpriteManager("/imagenes/soldierSpray.png");
		//imagen = sm.subImage(0, 45, 50, 60);
		imagen = sm.subImage(0, 0, 53, 61);
		//imagen = ImageManager.cargarImagen("/imagenes/soldier.jpg");
		jugadorIzquierda=new BufferedImage[3];
		jugadorDerecha=new BufferedImage[3];
		jugadorDown=new BufferedImage[3];
		jugadorUp=new BufferedImage[3];
		
		jugadorIzquierda[0]=sm.subImage(0,60, 53, 61);
		jugadorIzquierda[1]=sm.subImage(87, 60, 53, 61);
		jugadorIzquierda[2]=sm.subImage(167, 60, 53, 61);
		
		jugadorDerecha[0]=sm.subImage(0, 105, 53, 61);
		jugadorDerecha[1]=sm.subImage(87, 105, 53, 61);
		jugadorDerecha[2]=sm.subImage(167, 105, 53, 61);
		
		jugadorUp[0]=sm.subImage(0, 150, 53, 61);
		jugadorUp[1]=sm.subImage(87, 150, 53, 61);
		jugadorUp[2]=sm.subImage(167, 150, 53, 61);
		
		jugadorDown[0]=sm.subImage(0, 0, 53, 61);
		jugadorDown[1]=sm.subImage(87, 0, 53, 61);
		jugadorDown[2]=sm.subImage(167, 0, 53, 61);
		
		jugadorIzq=new Animacion(100, jugadorIzquierda);
		jugadorDer=new Animacion(100, jugadorDerecha);
		jugadorDownn=new Animacion(100, jugadorDown);
		jugadorUpp=new Animacion(100, jugadorUp);
	}
	
	/*public void render(Graphics g){
		
		g.drawImage(imagen, x, y, null);
		
	}*/
	
	public void update(){
		
		if(moveUp){
			y -= dy;
		}
		jugadorUpp.start();
		
		if(moveDown){
			y += dy;
		}
		jugadorDownn.start();
		
		if(moveRight){
			x += dx;
			
		}
		jugadorDer.start();
		
		if(moveLeft){
			x -= dx;
		}
		jugadorIzq.start();
	}

	public boolean isMoveLeft() {
		return moveLeft;
	}

	public void setMoveLeft(boolean moveLeft) {
		this.moveLeft = moveLeft;
	}

	public boolean isMoveRight() {
		return moveRight;
	}

	public void setMoveRight(boolean moveRight) {
		this.moveRight = moveRight;
	}

	public boolean isMoveUp() {
		return moveUp;
	}

	public void setMoveUp(boolean moveUp) {
		this.moveUp = moveUp;
	}

	public boolean isMoveDown() {
		return moveDown;
	}

	public void setMoveDown(boolean moveDown) {
		this.moveDown = moveDown;
	}
	
	public void render(Graphics g){
		g.drawImage(currentFrame(), x, y, null);
		//g.dispose();
	}
	
	public BufferedImage currentFrame(){
		if(isMoveRight()){
			return jugadorDer.currentFrame();
		}
		else if(isMoveLeft()){
			return jugadorIzq.currentFrame();
		}
		else if(isMoveDown()){
			return jugadorDownn.currentFrame();
		}
		else if(isMoveUp()){
			return jugadorUpp.currentFrame();
		}
		else 
			return imagen;
	}
	
}
