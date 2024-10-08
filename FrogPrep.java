import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrogPrep extends JFrame implements KeyListener, ActionListener {

	//declare copies of our character
	private Frog frog;
	private Car car;
	private Loggie loggie;
	private Background bgd;
	
	//GUI variables
	private Container content;
	private JLabel frogLabel, carLabel, loggieLabel, bgdLabel;
	private ImageIcon frogImage, carImage, loggieImage, bgdImage;
	
	//2 buttons
//	private JButton startButton, visibilityButton;
	
	//GUI setup
	public FrogPrep() {
		super("Frogger Demo");
		frog = new Frog(0, 0, 108, 99, "froggie.png");//picture size: 108 * 99
		car = new Car(0, 0, 227, 128, "car.jpeg");// 227 * 128
		loggie = new Loggie(0, 0, 142, 77, "loggie.jpeg");// 142 * 77
		bgd = new Background(0, 0, 600, 850, "background.png");//picture size: 600 × 850
				
		//set up screen
		setSize(GameProperties.SCREEN_WIDTH, 
				     GameProperties.SCREEN_HEIGHT);
		content = getContentPane();
		content.setBackground(Color.gray);
		setLayout(null);
		
		//frog setup
		frog.setX(200);
		frog.setY(650);
		frog.setWidth(108);
		frog.setHeight(99);
		frog.setImage("froggie.png");
		
		frogLabel = new JLabel();
		frogImage = new ImageIcon(
	getClass().getResource("images/" + frog.getImage()
		));
		frogLabel.setIcon(frogImage);
		frogLabel.setSize(
				frog.getWidth(),
				frog.getHeight()
		);
		frogLabel.setLocation(
				frog.getX(), frog.getY() );

		//car setup
		car.setX(0);
		car.setY(450);
		car.setWidth(227);
		car.setHeight(128);
		car.setImage("car.jpeg");
				
		carLabel = new JLabel();
		carImage = new ImageIcon(
			getClass().getResource("images/" + car.getImage()
				));
		carLabel.setIcon(carImage);
		carLabel.setSize(
					car.getWidth(),
					car.getHeight()
				);
		carLabel.setLocation(
				car.getX(), car.getY() );
		
		//Log setup
		loggie.setX(0);
		loggie.setY(100);
		loggie.setWidth(142);
		loggie.setHeight(77);
		loggie.setImage("loggie.jpeg");
				
		loggieLabel = new JLabel();
		loggieImage = new ImageIcon(
			getClass().getResource("images/" + loggie.getImage()
				));
		loggieLabel.setIcon(loggieImage);
		loggieLabel.setSize(
				loggie.getWidth(),
				loggie.getHeight()
				);
		loggieLabel.setLocation(
				loggie.getX(), loggie.getY() );
		
		// Background setup
		bgd.setX(0);
		bgd.setY(0);
		bgd.setWidth(600);
		bgd.setHeight(850);
		bgd.setImage("background.png");
		
		bgdLabel = new JLabel();
		bgdImage = new ImageIcon(
	getClass().getResource("images/" + bgd.getImage()
		));
		bgdLabel.setIcon(bgdImage);
		bgdLabel.setSize(
				bgd.getWidth(),
				bgd.getHeight()
		);
		bgdLabel.setLocation(
				bgd.getX(), bgd.getY() );
		
		//set up visibility button
//		visibilityButton = new JButton("Hide");
//		visibilityButton.setSize(100, 50);
//		visibilityButton.setLocation(
//				GameProperties.SCREEN_WIDTH - 100, 
//				GameProperties.SCREEN_HEIGHT - 100);
//		visibilityButton.setFocusable(false);
//		visibilityButton.addActionListener(this);
		
//		//move button
//		startButton = new JButton("Run");
//		startButton.setSize(100, 100);
//		startButton.setLocation(
//				GameProperties.SCREEN_WIDTH - 100, 
//				GameProperties.SCREEN_HEIGHT - 200);
//		startButton.setFocusable(false);
//		startButton.addActionListener(this);
		
//		add(visibilityButton);
//		add(startButton);
		add(frogLabel);
		add(carLabel);
		add(loggieLabel);
		add(bgdLabel);
		//set the bgd label at the end
		//or it will cover all labels
		
		content.addKeyListener(this);
		content.setFocusable(true);

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public static void main(String[] args) {
		FrogPrep myGame = new FrogPrep();
		myGame.setVisible(true);
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		//get current position
		int x = frog.getX();
		int y = frog.getY();
		
		//detect direction
		if ( e.getKeyCode() == KeyEvent.VK_UP ) {
			
			y -= GameProperties.CHARACTER_STEP;
			
			if ( y + frog.getHeight() <=  0) {

				y = GameProperties.SCREEN_HEIGHT;

			}
			
		} else if ( e.getKeyCode() == KeyEvent.VK_DOWN ) {
			
			y += GameProperties.CHARACTER_STEP;
			
			if ( y >= GameProperties.SCREEN_HEIGHT) {
				
				y = -1 * frog.getHeight();
				
			}
			
		} else if ( e.getKeyCode() == KeyEvent.VK_LEFT ) {
			
			x -= GameProperties.CHARACTER_STEP;
			
			if (x + frog.getWidth() <= 0) {

				x = GameProperties.SCREEN_WIDTH;

			}
			
		}  else if ( e.getKeyCode() == KeyEvent.VK_RIGHT ) {
			
			x += GameProperties.CHARACTER_STEP;
			
			if ( x >= GameProperties.SCREEN_WIDTH ) {

				x = -1 * frog.getWidth();

			}
			
		} 
		
		//update frog
		frog.setX(x);
		frog.setY(y);
		
		//move label
		frogLabel.setLocation(
				frog.getX(), frog.getY() );
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


//	@Override
//	public void actionPerformed(ActionEvent e) {
//		
//		if ( e.getSource() == visibilityButton ) {
//			System.out.println("visibilityButton pressed");			
//		} else if ( e.getSource() == startButton ) {
//			System.out.println("startButton pressed");			
//		}
//		
//	}

}
