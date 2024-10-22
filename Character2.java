import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Character2 extends Sprite implements Runnable {
	
//	private Boolean visible;
	private Boolean moving;
	private Thread t;
	
	//declare the label from the main program
	//DO NOT INSTANTIATE IT!!!!!!!!!!!!!!!!! (no = new JLabel)
	private JLabel carLabel, loggieLabel;	
	private JButton startButton, visibiltyButton;
	
	private Character1 frog;
	private JLabel frogLabel;
	
	public void setCharacter1 (Character1 temp) {
		frog = temp;
	}
	
	public void setCharacter1Label(JLabel temp) {
		frogLabel = temp;
	}
	
	public void setCharacter2Label(JLabel temp) {
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

//	public Boolean getVisible() {
//		return visible;
//	}

//	public void setVisible(Boolean visible) {
//		this.visible = visible;
//	}

	public Boolean getMoving() {
		return moving;
	}

	public void setMoving(Boolean moving) {
		this.moving = moving;
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
		
		//detect the null pointer
		if (carLabel == null) {
			System.out.println("=======check station 1: carLabel is null=======");
//		return;
		}

		//if already moving, do not start again
		if ( !this.moving ) {
			this.moving = true;
			
//			startButton.setText("Stop");
			
			this.setImage("car.jpeg");
			
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

		//detect the null pointer
		if (carLabel == null) {
			System.out.println("=======check station 2: carLabel is null=======");
		}
			frog.setImage("froggie.png");
frogLabel.setIcon(new ImageIcon(
		getClass().getResource("images/" + frog.getImage()
)));
		//detect the null pointer
		if (carLabel == null) {
			System.out.println("=======check station 3: carLabel is null=======");
		}

			System.out.println("Starting thread");
			t = new Thread(this, "Character2 thread");
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
		if (loggieLabel == null) {
		    System.out.println("loggieLabel is null before starting the thread!");
		} else {
		    System.out.println("loggieLabel is set correctly.");
		}
		System.out.println("run triggered");
		
		//==== these have to be outside loop or it will be reset
		// ===== and go nowhere ===
		int x = this.x;
		int x2 = this.x;
		// ===================
		while (this.moving) {
			
			x += GameProperties.CHARACTER_STEP;
			x2 -= GameProperties.CHARACTER_STEP;
			
			if ( x >= GameProperties.SCREEN_WIDTH) {
				x = -1 * this.width;
				
			}
			if ( x2 <= -1 * this.width) {//if position goes off-screen
				x2 = GameProperties.SCREEN_WIDTH;
				
			}
			this.setX(x); //this.x = x; //rectangle doesn't update
			
			//is it here? yes it is lol
			//wait until not null
			if (carLabel == null
					) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e){
					e.printStackTrace();
				}
			} else {
				carLabel.setLocation(x, this.y);
			}
			
			//loggieLabel is moving at here !!!!!
			if (loggieLabel == null 
					) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e){
					e.printStackTrace();
				}
			} else {
				loggieLabel.setLocation(x2, this.y);
			}
			
			
			//detect collisions between frog r and char2
//			if (this.visible) this.detectCollision();
			this.detectCollision();
			
			System.out.println("x, y: " + this.x + " " + this.y);
			
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		// it wont work for now try into one loop
//		while (this.moving) {
//			
//			int x = this.x;
//			
//			x -= GameProperties.CHARACTER_STEP;
//			
//			if ( x >= GameProperties.SCREEN_WIDTH) {
//				x = -1 * this.width;
//			}
//			
//			this.setX(x); //this.x = x; //rectangle doesn't update
//			
//			//add loggie here to see what would happen
//			loggieLabel.setLocation(this.x, this.y);
//
//			//detect collisions between frog r and char2
//			if (this.visible) this.detectCollision();
//			
//			System.out.println("x, y: " + this.x + " " + this.y);
//			
//			try {
//				Thread.sleep(200);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//		}
		
		System.out.println("Thread Stopped");
		
	}
	
	void detectCollision() {
	//====  make sure carLabel is not null ===
		if (carLabel == null 
				) {
			try {
				Thread.sleep(800);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
	//====  make sure carLabel is not null ===

		} else {
			
			if ( this.r.intersects( frog.getRectangle() ) ) {
				//collision detected

				this.stopThread();
				System.out.println("BOOM!");

				
				this.setImage("car.jpeg");
			carLabel.setIcon(new ImageIcon(
					getClass().getResource("images/" + this.getImage()
			)));

				frog.setImage("froggie.png");
			frogLabel.setIcon(new ImageIcon(
					getClass().getResource("images/" + frog.getImage()
			)));

			}
		}
	}
	
//	public void hide() {
//		this.visible = false;
//		carLabel.setVisible(this.visible);
//		visibiltyButton.setText("Show");
//	}
//
//	public void show() {
//		this.visible = true;
//		carLabel.setVisible(this.visible);
//		visibiltyButton.setText("Hide");
//	}

}
