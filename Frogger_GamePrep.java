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
	
	private Character2 carArrays[];
	private JLabel carLabels[];
	private Character2 carArrays2[];
	private JLabel carLabels2[];
	
	private Character2 logArrays[];
	private JLabel logLabels[];
	
	//GUI variables
	private Container content;
	private JLabel frogLabel, carLabel, loggieLabel, bgdLabel;
	private ImageIcon frogImage, carImage, loggieImage, bgdImage;
	
	//2 buttons
//	private JButton startButton, visibilityButton;
	//GUI setup
	public Frogger_GamePrep() {
		super("Doctor Demo");
		frog = new Character1(100, 200, 51, 55, "nobgd_grogu.png");
		bgd = new Character1(0, 0, 1551, 700, "bgd_fullscreen_1.png");
		car = new Character2(0, 0, 100, 57, "nobgd_car.png");
		loggie = new Character2(0, 0, 65, 119, "nobgd_loggie.png");
		
		
		
		//set up screen
		setSize(GameProperties.SCREEN_WIDTH, 
				     GameProperties.SCREEN_HEIGHT);
		content = getContentPane();
		content.setBackground(Color.gray);
		setLayout(null);
		
		//frog setup
		frog.setX(600);
		frog.setY(640);
		frog.setWidth(51);
		frog.setHeight(55);
		frog.setImage("nobgd_grogu.png");
		
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

		
		//car loop labels array setup
		int carCount = 5;
		carArrays = new Character2[carCount];
		carLabels = new JLabel[carCount]; 
		
		//start a loop to initiate more cars
		for(int i=0; i < carCount; i++) {
			if (carArrays[i] == null) {//just in case it's null again
				
				carArrays[i] = new Character2(0 + (i * 550), 380, 57, 100, "nobgd_car.png");
				carLabels[i] = new JLabel();
				carImage = new ImageIcon(
						getClass().getResource("images/" + car.getImage()
							));
				carLabels[i].setIcon(carImage);
				carLabels[i].setSize(
						carArrays[i].getWidth(),
						carArrays[i].getHeight()
				);
				carLabels[i].setLocation(
						carArrays[i].getX(), carArrays[i].getY() );
				
				carArrays[i].setCharacter1(frog);
				//set car labels collision inside loop
				carArrays[i].setCharacter2Label(carLabels[i]);
				carArrays[i].setCharacter1Label(frogLabel);	
				
				add(carLabels[i]);
			}
		}
//		car.setCharacter1Label(frogLabel);	
		//car loop labels array setup
		int carCount2 = 5;
		carArrays2 = new Character2[carCount2];
		carLabels2 = new JLabel[carCount2]; 
		
		//start a loop to initiate more cars
		for(int i=0; i < carCount; i++) {
			if (carArrays2[i] == null) {//just in case it's null again
				
				carArrays2[i] = new Character2(350 + (i * 550), 440, 57, 100, "nobgd_car.png");
				carLabels2[i] = new JLabel();
				carImage = new ImageIcon(
						getClass().getResource("images/" + car.getImage()
							));
				carLabels2[i].setIcon(carImage);
				carLabels2[i].setSize(
						carArrays2[i].getWidth(),
						carArrays2[i].getHeight()
				);
				carLabels2[i].setLocation(
						carArrays2[i].getX(), carArrays2[i].getY() );
				
				carArrays2[i].setCharacter1(frog);
				//set car labels collision inside loop
				carArrays2[i].setCharacter2Label(carLabels2[i]);
				carArrays2[i].setCharacter1Label(frogLabel);	
				
				add(carLabels2[i]);
			}
		}
		
//===============  down here for loggie setting ==============
//		loggieLabel = new JLabel();
//		loggieImage = new ImageIcon(
//			getClass().getResource("images/" + loggie.getImage()
//				));
//		loggieLabel.setIcon(loggieImage);
//		loggieLabel.setSize(
//						loggie.getWidth(),
//						loggie.getHeight()
//				);
//		loggieLabel.setLocation(
//						loggie.getX(), loggie.getY() );
		
		//loggieLabel HAS a memory address, using function from car
//		loggie.setChara_loggieLabel(loggieLabel);
//		loggie.setCharacter1Label(frogLabel);
//		loggie.startThread();
		
		//car loop labels array setup
		int logCount = 6;
		logArrays = new Character2[logCount];
		logLabels = new JLabel[logCount]; 
		
		//start a loop to initiate more logs
		for(int i=0; i < logCount; i++) {
			if (logArrays[i] == null) {//just in case it's null again
				
				logArrays[i] = new Character2(0 + (i * 350), 75, 65, 119, "nobgd_loggie.png");
				logLabels[i] = new JLabel();
				loggieImage = new ImageIcon(
						getClass().getResource("images/" + loggie.getImage()
							));
				logLabels[i].setIcon(loggieImage);
				logLabels[i].setSize(
						logArrays[i].getWidth(),
						logArrays[i].getHeight()
				);
				logLabels[i].setLocation(
						logArrays[i].getX(), logArrays[i].getY() );
				
				logArrays[i].setCharacter1(frog);
				//set log labels collision inside loop
				logArrays[i].setCharacter2Label(logLabels[i]);
				logArrays[i].setCharacter1Label(frogLabel);	
				
				add(logLabels[i]);
			}
		}
		//background setup
		bgd.setX(0);
		bgd.setY(0);
		bgd.setWidth(1551);
		bgd.setHeight(678);
		bgd.setImage("bgd_fullscreen_1.png");
				
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
//		add(carLabel);
		add(frogLabel);
//		add(loggieLabel);
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
		
//		if (carArray.getMoving()) {
//			System.out.println("Car is moving");
//		} else {
//			car.startThread();
//		}
		for (int i = 0; i < carArrays.length; i++) {
			if (carArrays[i] != null) {
				
				carArrays[i].startThread();
				carArrays2[i].startThread();
//				System.out.println("car array is moving...");
//				System.out.println("Car no." + i + " is moving.");
			}
		}
		
		
		for (int i = 0; i < logArrays.length; i++) {
			if (logArrays[i] != null) {
				
				logArrays[i].startThread();
//				System.out.println("log array is moving...");
//				System.out.println("Log no." + i + " is moving.");
			}
		}
	}
	
	public void DetectCollision() {
		
//		car.detectCollision();
//		loggie.detectCollision();
		for (int i = 0; i < carArrays.length; i++) {
			if (carArrays[i] != null) {
				carArrays[i].detectCollision();
			}
		}
		
		for (int i = 0; i < logArrays.length; i++) {
			if (logArrays[i] != null) {
				logArrays[i].detectCollision();
			}
		}
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
