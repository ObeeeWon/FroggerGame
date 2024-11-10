import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

//Character3 is used for loggie
public class Character3 extends Frogger_Sprite implements Runnable {
	
//	private Boolean visible;
	private Boolean moving;
	private Thread t;
	
	//declare the label from the main program
	//DO NOT INSTANTIATE IT!!!!!!!!!!!!!!!!! (no = new JLabel)
	private JLabel carLabel, loggieLabel;	
	private JButton startButton, visibiltyButton;
	
	private Character1 frog;
	private JLabel frogLabel;
	
	private Character3 logArrays[];
	
	public void setCharacter1 (Character1 temp) {
		frog = temp;
	}
	
	public void setCharacter1Label(JLabel temp) {
		frogLabel = temp;
	}
	
	public void setCharacter3Label(JLabel temp) {
		carLabel = temp;
	}
	
	public void setChara_loggieLabel(JLabel temp) {
		loggieLabel = temp;
	}

	public void setStartButton(JButton temp) {
		startButton = temp;
	}

	public void setVisibilityButton(JButton temp) {
		visibiltyButton = temp;
	}

	public Boolean getMoving() {
		return moving;
	}

	public void setMoving(Boolean moving) {
		this.moving = moving;
	}
	
	public void setLogArrays(Character3 logArrays[]) {
		this.logArrays = logArrays;
	}

	public Character3() {
		super();
		// TODO Auto-generated constructor stub
		this.moving = false;
//		this.visible = true;
	}

	public Character3(int x, int y, int height, int width, String image) {
		super(x, y, height, width, image);
		// TODO Auto-generated constructor stub
		this.moving = false;
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
			t = new Thread(this, "Character3 thread");
			t.start(); //automatic call to the run method
		}
		
	}
	
	public void stopThread() {
		//will end the thread on next repeated cycle
		if (this.moving) {
			this.moving = false;
//			startButton.setText("Run");
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		System.out.println("run triggered");
		
//		if (loggieLabel == null) {
//		    System.out.println("loggieLabel is null before starting the thread!");
//		} else {
//		    System.out.println("loggieLabel is set correctly.");
//		}
		
		// set x position for both cars and logs
		int x = this.x;

		while (this.moving) {
			
			x += GameProperties.CHARACTER_STEP;
			
			if ( x >= GameProperties.SCREEN_WIDTH) {
				x = -1 * this.width;			
			}
			
			this.setX(x); //rectangle doesn't update
			carLabel.setLocation(x, this.y);
			
			//loggieLabel is moving at here !!!!!
			if (loggieLabel == null 
					) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e){
					e.printStackTrace();
				}
			} else {
				loggieLabel.setLocation(x, this.y);
			}
			
			
			//detect if on board between frog and log
			this.detectOnBoard();
			
			System.out.println("x, y: " + this.x + " " + this.y);
			
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println("Thread Stopped");
		
		
	}
	
	void detectOnBoard() {	
		for (int i = 0; i < logArrays.length; i++) {
			if ( this.r.intersects( frog.getRectangle() ) ) { 
			//On board detected : )
				System.out.println("Welcome board, Master Grogu!");
			//move frog with log
				frog.setX(this.x);
				//frog is not going with log at here
				//it's taking the last log's x location
				frogLabel.setLocation(frog.getX(), frog.getY());
		}
	}
}
	
	//send Mr. Frog back to original position safely
	void sendMrfrogBackHome() {
		
		frog.setX(600);// Grogu blink!
		frog.setY(640);// Grogu blink!
		frogLabel.setLocation(600, 640);// Grogu blink!
		frog.setImage("nobgd_grogu.png");
	frogLabel.setIcon(new ImageIcon(
			getClass().getResource("images/" + frog.getImage()
	)));
		
	}

}
