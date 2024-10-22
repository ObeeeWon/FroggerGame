import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
//import javax.swing.JButton; not necessary now
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frogger_GamePrep extends JFrame implements KeyListener, ActionListener {

	//declare copies of our character
	private Character1 frog;
	private Character2 car;//car setup
	private Character2 loggie;
	private Character1 bgd;
	
	//GUI variables
	private Container content;
	private JLabel frogLabel, carLabel, loggieLabel, bgdLabel;
	private ImageIcon frogImage, carImage, loggieImage, bgdImage;
	
	//2 buttons
//	private JButton startButton, visibilityButton;
	
	//GUI setup
	public Frogger_GamePrep() {
		super("Doctor Demo");
		frog = new Character1(100, 200, 77, 71, "froggie.png");
		bgd = new Character1(0, 0, 1551, 700, "bgd_fullscreen.png");
		car = new Character2(0, 0, 122, 70, "car.jpeg");
		loggie = new Character2(0, 0, 120, 200, "loggie.jpeg");
		
		
		//set up screen
		setSize(GameProperties.SCREEN_WIDTH, 
				     GameProperties.SCREEN_HEIGHT);
		content = getContentPane();
		content.setBackground(Color.gray);
		setLayout(null);
		
		//frog setup
		frog.setX(100);
		frog.setY(450);
		frog.setWidth(77);
		frog.setHeight(71);
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

		//Car setup
		car.setX(0);
		car.setY(250);
		car.setWidth(122);
		car.setHeight(70);
		car.setImage("car.jpeg");
		car.setCharacter1(frog);
				
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
		
		//carLabel HAS a memory address 
		car.setCharacter2Label(carLabel);
		car.setCharacter1Label(frogLabel);	
//		car.startThread();
		
//===============  down here for loggie setting ==============
		
		//loggie setup
		loggie.setX(0);
		loggie.setY(0);
		loggie.setWidth(120);
		loggie.setHeight(200);
		loggie.setImage("loggie.jpeg");
		loggie.setCharacter1(frog);
				
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
		
		//loggieLabel HAS a memory address, using function from car
		loggie.setChara_loggieLabel(loggieLabel);
		loggie.setCharacter1Label(frogLabel);
//		loggie.startThread();

		
		//background setup
		bgd.setX(0);
		bgd.setY(0);
		bgd.setWidth(1551);
		bgd.setHeight(678);
		bgd.setImage("bgd_fullscreen.png");
				
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

//		System.out.println("loggieLabel initialized: " + (loggieLabel != null));

		//sometimes the car will show null pointer exception for some reasons
//		if (loggieLabel != null) {
//			loggie.setCharacter2Label(loggieLabel);
//			loggie.setCharacter1Label(frogLabel);
//		} else {
//			System.out.println("====memory has nnot set yet! =====");
//		}
//		
		
//===============  up here for log setting ==============
		
		//set up visibility button
//		visibilityButton = new JButton("Hide");
//		visibilityButton.setSize(100, 50);
//		visibilityButton.setLocation(
//				GameProperties.SCREEN_WIDTH - 100, 
//				GameProperties.SCREEN_HEIGHT - 100);
//		visibilityButton.setFocusable(false);
//		visibilityButton.addActionListener(this);
//		car.setVisibilityButton(visibilityButton);
//		loggie.setVisibilityButton(visibilityButton);


		//move button
//		startButton = new JButton("Run");
//		startButton.setSize(100, 100);
//		startButton.setLocation(
//				GameProperties.SCREEN_WIDTH - 100, 
//				GameProperties.SCREEN_HEIGHT - 200);
//		startButton.setFocusable(false);
//		startButton.addActionListener(this);
//		car.setStartButton(startButton);
//		//and the log so that log can run together
//		loggie.setStartButton(startButton);
		
//		add(visibilityButton);
//		add(startButton);
		add(frogLabel);
		add(carLabel);
		add(loggieLabel);
		add(bgdLabel);
		
		content.addKeyListener(this);
		content.setFocusable(true);

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public static void main(String[] args) {
		Frogger_GamePrep myGame = new Frogger_GamePrep();
		myGame.setVisible(true);
		myGame.KeepMoving();
		myGame.DetectCollision();

	}
	
	public void KeepMoving() {
		
		if (car.getMoving()) {
			System.out.println("Car is moving");
		} else {
			car.startThread();
		}
		if (loggie.getMoving()) {
			System.out.println("Log is moving");
		} else {
			loggie.startThread();
		}
	}
	
	public void DetectCollision() {
		
//		car.detectCollision();
//		loggie.detectCollision();
	
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
		
		this.DetectCollision();
		
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
		
//		if ( e.getSource() == visibilityButton ) {
//			
//			System.out.println("visibilityButton pressed");	
//			
////			if ( car.getVisible() ) {
////				car.hide();
////			} else {
////				car.show();
////			}
//		
//		} else if ( e.getSource() == startButton ) {
//			
//			System.out.println("startButton pressed");	
			
//			if ( car.getMoving() ) {
//				car.stopThread();
//			} else {
//
//				car.startThread();
//			}
		
//		}
		
	}

}
