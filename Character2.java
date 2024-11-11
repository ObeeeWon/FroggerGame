import javax.swing.ImageIcon;
import javax.swing.JLabel;

//Character is used for car
public class Character2 extends Frogger_Sprite implements Runnable {
	
//	private Boolean visible;
	private Boolean moving;
	private Thread t;
	
	//declare the label from the main program
	//DO NOT INSTANTIATE IT!!!!!!!!!!!!!!!!! (no = new JLabel)
	private JLabel carLabel;	
	private Character1 frog;
	private JLabel frogLabel;
	private JLabel scoreLabel;
	private int scorePoint = 0;

	
	public void setCharacter1 (Character1 temp) {
		frog = temp;
	}
	
	public void setCharacter1Label(JLabel temp) {
		frogLabel = temp;
	}
	
	public void setCharacter2Label(JLabel temp) {
		carLabel = temp;
	}

	public Boolean getMoving() {
		return moving;
	}

	public void setMoving(Boolean moving) {
		this.moving = moving;
	}
	
	public void setScoreLabel(JLabel scoreLabel) {
		this.scoreLabel = scoreLabel;
	}

	public Character2() {
		super();
		// TODO Auto-generated constructor stub
		this.moving = false;
//		this.visible = true;
	}

	public Character2(int x, int y, int height, int width, String image) {
		super(x, y, height, width, image);
		// TODO Auto-generated constructor stub
		this.moving = false;
//		this.visible = true;
	}
	
	public void startThread() {
		//run will be triggered
		System.out.println("Current moving: " + this.moving);

		//if already moving, do not start again
		if ( !this.moving ) {
			this.moving = true;
			
			//is it here?
			//wait until not null
			if (carLabel == null) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e){
					e.printStackTrace();
				}
			} else {
				carLabel.setIcon(new ImageIcon(
						getClass().getResource("images/" + this.getImage()
				)));
			}

			frog.setImage("nobgd_grogu.png");
frogLabel.setIcon(new ImageIcon(
		getClass().getResource("images/" + frog.getImage()
)));

			System.out.println("Starting thread");
			t = new Thread(this, "Character2 thread");
			t.start(); //automatic call to the run method
		}
		
	}
	
	public void stopThread() {
		//will end the thread on next repeated cycle
		if (this.moving) {
			this.moving = false;
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// set x position for both cars and logs
		int x = this.x;
		int x2 = this.x;
		
		while (this.moving) {
			
			x += GameProperties.CHARACTER_STEP;
			x2 -= GameProperties.CHARACTER_STEP;
			
			if ( x >= GameProperties.SCREEN_WIDTH) {
				x = -1 * this.width;
				
			}
			if ( x2 <= -1 * this.width) {//if position goes off-screen
				x2 = GameProperties.SCREEN_WIDTH;
				
			}
			
			//just make sure cars moving from opposite direction
			if (this.y == 460 ) {
				carLabel.setLocation(x2, this.y);
				this.setX(x2); 

			} else {
				carLabel.setLocation(x, this.y);
				this.setX(x); 

			}
			
			//detect collisions between frog and char2
			this.detectCollision();
			
			System.out.println("x, y: " + this.x + " " + this.y);
			//cars take a break and refill some gas here
			try {
				Thread.sleep(800);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println("Thread Stopped");
	}
	
	void loseScorePoint() {
		scorePoint = scorePoint - 50;
		System.out.println("hit a car, score -50");
	        if (scoreLabel != null) {
	            scoreLabel.setText("Score: " + scorePoint);
	    }	
    }//still can not pass to prep lol
	
	void detectCollision() {
			

	if ( this.r.intersects( frog.getRectangle() ) ) {
	//collision detected

//	this.stopThread();
	System.out.println("BOOM!");
	loseScorePoint();
	sendMrfrogBackHome();
	
	this.setImage("nobgd_car.png");
carLabel.setIcon(new ImageIcon(
		getClass().getResource("images/" + this.getImage()
)));
	}
}
	
	//send Mr. Frog back to original position safely
	void sendMrfrogBackHome() {
		
		frog.setX(600);// Grogu blink! Bit me!
		frog.setY(640);// Grogu blink! Bit me!
		frogLabel.setLocation(600, 640);// Grogu blink! Bit me!
		frog.setImage("nobgd_grogu.png");
	frogLabel.setIcon(new ImageIcon(
			getClass().getResource("images/" + frog.getImage()
	)));
		
	}
	
}
