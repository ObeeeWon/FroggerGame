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
	private Character1 bgd;
	private Character1 frog;
	
//	private Character2 car;//car setup
	private Character2 carArrays[];
	private JLabel carLabels[];

	private Character2 carArrays2[];
	private JLabel carLabels2[];
	
	private Character2 carArrays3[];
	private JLabel carLabels3[];

//	private Character3 loggie;
	private Character3 logArrays[];
	private JLabel logLabels[];
	
	private Character3 logArrays2[];
	private JLabel logLabels2[];
	
	private Character3 logArrays3[];
	private JLabel logLabels3[];
	
	private int scorePoint = 0;
	private Character1 scorekeeper;// R2D2 and CP3
	private Character2 scoreSender;
	
	//GUI variables
	private Container content;
	private JLabel frogLabel, bgdLabel, scorekeeperLabel, scoreLabel;
	private ImageIcon frogImage, carImage, loggieImage, bgdImage, scorekeeperImage;
	
	// Next Version: 
	// Background Music -  STAR WARS
	//GUI setup
	public Frogger_GamePrep() {
		super("Doctor Demo");
		frog = new Character1(100, 200, 51, 55, "nobgd_grogu.png");
		bgd = new Character1(0, 0, 1551, 700, "bgd_fullscreen_1.png");
		scorekeeper = new Character1(200,200,92,55,"scorekeeper.png");
//		car = new Character2(0, 0, 100, 57, "nobgd_car.png");
//		loggie = new Character3(0, 0, 65, 119, "nobg_x-wing.png");

		
		//set up screen
		setSize(GameProperties.SCREEN_WIDTH, 
				     GameProperties.SCREEN_HEIGHT);
		content = getContentPane();
		content.setBackground(Color.gray);
		setLayout(null);
		
		//score keeper R2D2 and CP3
		scorekeeper.setX(130);
		scorekeeper.setY(8);
		scorekeeper.setWidth(40);
		scorekeeper.setHeight(67);
		scorekeeper.setImage("scorekeeper.png");
		
		scorekeeperLabel = new JLabel();
		scorekeeperImage = new ImageIcon(
	getClass().getResource("images/" + scorekeeper.getImage()
		));
		scorekeeperLabel.setIcon(scorekeeperImage);
		scorekeeperLabel.setSize(
				scorekeeper.getWidth(),
				scorekeeper.getHeight()
		);
		scorekeeperLabel.setLocation(
				scorekeeper.getX(), scorekeeper.getY() );
		
		//score of the game
		//https://stackoverflow.com/questions/20999071/how-to-set-value-to-label-text
		scoreLabel = new JLabel();
		scoreLabel.setSize(80, 50);
		scoreLabel.setLocation(180, 20);
		//set font color
		//https://stackoverflow.com/questions/2966334/how-do-i-set-the-colour-of-a-label-coloured-text-in-java
		scoreLabel.setForeground(Color.BLACK);
		
		//set scoreJLabel after collision from character2
		scoreLabel.setText("Score: " + scorePoint);
		scoreSender = new Character2();
		scoreSender.setScoreLabel(scoreLabel);		
		
		add(scoreLabel);
		
		//frog setup
		frog.setX(600);
		frog.setY(620);
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

		//car loop 1st lane
		int carCount = 4;
		carArrays = new Character2[carCount];
		carLabels = new JLabel[carCount]; 
		
		//start a loop to initiate more than one car in the same lane
		//https://stackoverflow.com/questions/44339372/print-to-java-gui-with-for-loop
		for(int i=0; i < carCount; i++) {
			if (carArrays[i] == null) {//just in case it's null 
				
				carArrays[i] = new Character2(0 + (i * 650), 390, 68, 121, "nobgd_car.png");
				carLabels[i] = new JLabel();
				carImage = new ImageIcon(
		getClass().getResource("images/" + carArrays[i].getImage()
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
		
		//car loop 2nd lane
		int carCount2 = 4;
		carArrays2 = new Character2[carCount2];
		carLabels2 = new JLabel[carCount2]; 
		
		//start a loop to initiate more than one car in the same lane
		for(int i=0; i < carCount2; i++) {
			if (carArrays2[i] == null) {//just in case it's null again
				
				carArrays2[i] = new Character2(350 + (i * 550), 460, 68, 121, "nobgd_car.png");
				carLabels2[i] = new JLabel();
				carImage = new ImageIcon(
		getClass().getResource("images/" + carArrays[i].getImage()
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
			
		//car loop 3rd lane
		int carCount3 = 4;
		carArrays3 = new Character2[carCount3];
		carLabels3 = new JLabel[carCount3]; 
		
		//start a loop to initiate more than one car in the same lane
		for(int i=0; i < carCount3; i++) {
			if (carArrays3[i] == null) {//just in case it's null again
				
				carArrays3[i] = new Character2(0 + (i * 550), 540, 68, 121, "nobgd_car.png");
				carLabels3[i] = new JLabel();
				carImage = new ImageIcon(
		getClass().getResource("images/" + carArrays[i].getImage()
			));
				carLabels3[i].setIcon(carImage);
				carLabels3[i].setSize(
						carArrays3[i].getWidth(),
						carArrays3[i].getHeight()
				);
				carLabels3[i].setLocation(
						carArrays3[i].getX(), carArrays3[i].getY() );
				
				carArrays3[i].setCharacter1(frog);
				//set car labels collision inside loop
				carArrays3[i].setCharacter2Label(carLabels3[i]);
				carArrays3[i].setCharacter1Label(frogLabel);	
				
				add(carLabels3[i]);
			}
		}
		
		
		//log loop 1st lane
		int logCount = 4;
		logArrays = new Character3[logCount];
		logLabels = new JLabel[logCount]; 
		
		//start a loop to initiate more logs
		for(int i=0; i < logCount; i++) {
			if (logArrays[i] == null) {//just in case it's null again
				logArrays[i] = new Character3(0 + (i * 350), 85, 54, 68, "nobg_x-wing.png");
				logLabels[i] = new JLabel();
				loggieImage = new ImageIcon(
		getClass().getResource("images/" + logArrays[i].getImage()
			));
				logLabels[i].setIcon(loggieImage);
				logLabels[i].setSize(
						logArrays[i].getWidth(),
						logArrays[i].getHeight()
				);
				logLabels[i].setLocation(
						logArrays[i].getX(), logArrays[i].getY() );
				
				logArrays[i].setCharacter1(frog);
				
				//drag the log labels collision inside loop
				logArrays[i].setCharacter3Label(logLabels[i]);
				logArrays[i].setCharacter1Label(frogLabel);	
				logArrays[i].setLogArrays(logArrays);
				
				add(logLabels[i]);
			}
		}
		
		//log loop 2nd lane
		int logCount2 = 4;
		logArrays2 = new Character3[logCount2];
		logLabels2 = new JLabel[logCount2]; 
		
		//start a loop to initiate more logs
		for(int i=0; i < logCount2; i++) {
			if (logArrays2[i] == null) {//just in case it's null again
				
				logArrays2[i] = new Character3(300 + (i * 300), 165, 54, 68, "nobg_x-wing.png");
				logLabels2[i] = new JLabel();
				loggieImage = new ImageIcon(
		getClass().getResource("images/" + logArrays2[i].getImage()
			));
				logLabels2[i].setIcon(loggieImage);
				logLabels2[i].setSize(
						logArrays2[i].getWidth(),
						logArrays2[i].getHeight()
				);
				logLabels2[i].setLocation(
						logArrays2[i].getX(), logArrays2[i].getY() );
				
				logArrays2[i].setCharacter1(frog);
				
				//drag the log labels collision inside loop
				logArrays2[i].setCharacter3Label(logLabels2[i]);
				logArrays2[i].setCharacter1Label(frogLabel);	
				logArrays2[i].setLogArrays(logArrays2);
				
				add(logLabels2[i]);
			}
		}
		
		//log loop 3rd lane
		int logCount3 = 4;
		logArrays3 = new Character3[logCount3];
		logLabels3 = new JLabel[logCount3]; 
		
		//start a loop to initiate more logs
		for(int i=0; i < logCount3; i++) {
			if (logArrays3[i] == null) {//just in case it's null again
				
				logArrays3[i] = new Character3(0 + (i * 350), 250, 54, 68, "nobg_x-wing.png");
				logLabels3[i] = new JLabel();
				loggieImage = new ImageIcon(
		getClass().getResource("images/" + logArrays3[i].getImage()
			));
				logLabels3[i].setIcon(loggieImage);
				logLabels3[i].setSize(
						logArrays3[i].getWidth(),
						logArrays3[i].getHeight()
				);
				logLabels3[i].setLocation(
						logArrays3[i].getX(), logArrays3[i].getY() );
				
				logArrays3[i].setCharacter1(frog);
				
				//drag the log labels collision inside loop
				logArrays3[i].setCharacter3Label(logLabels3[i]);
				logArrays3[i].setCharacter1Label(frogLabel);	
				logArrays3[i].setLogArrays(logArrays3);
				
				add(logLabels3[i]);
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

		add(frogLabel);
		add(scorekeeperLabel);
		add(bgdLabel);
		//car and log has already added inside loop so
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
	
	void winScorePoint() {
		scorePoint = scorePoint + 50;
		scoreLabel.setText("Score: " + scorePoint);
	}
	
//	void loseScorePoint() {
//		scorePoint = scorePoint - 50;
//		scoreLabel.setText("Score: " + scorePoint);
//	}
	
	void detectDestination() {
		if (frog.getY() <= 40) {
			System.out.println("Welcome home, Master Grogu!");
			winScorePoint(); // we won! add 50 points
			sendMrfrogBackHome();
		}
	}
	
	//send Mr. Frog back to original position safely
	public void sendMrfrogBackHome() {
		
		frog.setX(600);// Grogu blink!
		frog.setY(640);// Grogu blink!
		frogLabel.setLocation(600, 640);// Grogu blink!
		frog.setImage("nobgd_grogu.png");
	frogLabel.setIcon(new ImageIcon(
			getClass().getResource("images/" + frog.getImage()
	)));
		
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
				carArrays3[i].startThread();
//				System.out.println("car array is moving...");
//				System.out.println("Car no." + i + " is moving.");
			}
		}
		
		
		for (int i = 0; i < logArrays.length; i++) {
			if (logArrays[i] != null) {
				
				logArrays[i].startThread();
				logArrays2[i].startThread();
				logArrays3[i].startThread();
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
	public void DetectDestination() {
		detectDestination();
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
		
		detectDestination();
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
//		detectDestination();
		
	}

}
