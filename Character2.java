import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Character2 extends Sprite implements Runnable {
	
	private Boolean visible, moving;
	private Thread t;
	
	//declare the label from the main program
	//DO NOT INSTANTIATE IT!!!!!!!!!!!!!!!!! (no = new JLabel)
	private JLabel character2Label, chara_loggieLabel;	
	private JButton startButton, visibiltyButton;
	
	private Character1 character1;
	private JLabel character1Label;
	
	public void setCharacter1 (Character1 temp) {
		character1 = temp;
	}
	
	public void setCharacter1Label(JLabel temp) {
		character1Label = temp;
	}
	
	public void setCharacter2Label(JLabel temp) {
		character2Label = temp;
	}
	
	public void setChara_loggieLabel(JLabel temp) {
		chara_loggieLabel = temp;
	}

	public void setStartButton(JButton temp) {
		startButton = temp;
	}

	public void setVisibilityButton(JButton temp) {
		visibiltyButton = temp;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

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
		this.visible = true;
	}

	public Character2(int x, int y, int height, int width, String image) {
		super(x, y, height, width, image);
		// TODO Auto-generated constructor stub
		this.moving = false;
		this.visible = true;
	}
	
	public void startThread() {
		//run will be triggered
		System.out.println("Current moving: " + this.moving);
		
		//detect the null pointer
		if (chara_loggieLabel == null) {
			System.out.println("=======check station 1: chara_loggieLabel is null=======");
//		return;
		}
		
		//if already moving, do not start again
		if ( !this.moving ) {
			this.moving = true;
			
			startButton.setText("Stop");
			
			this.setImage("car.jpeg");
character2Label.setIcon(new ImageIcon(
		getClass().getResource("images/" + this.getImage()
)));

			character1.setImage("froggie.png");
character1Label.setIcon(new ImageIcon(
		getClass().getResource("images/" + character1.getImage()
)));
		//detect the null pointer
		if (chara_loggieLabel == null) {
			System.out.println("=======check station 2: chara_loggieLabel is null=======");
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//detect the null pointer
		if (chara_loggieLabel == null) {
			System.out.println("=======check station 3: chara_loggieLabel is null=======");
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
			startButton.setText("Run");
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (chara_loggieLabel == null) {
		    System.out.println("chara_loggieLabel is null before starting the thread!");
		} else {
		    System.out.println("chara_loggieLabel is set correctly.");
		}
		System.out.println("run triggered");
		
		while (this.moving) {
			
			int x = this.x;
			
			x += GameProperties.CHARACTER_STEP;
			
			if ( x >= GameProperties.SCREEN_WIDTH) {
				x = -1 * this.width;
			}
			
			this.setX(x); //this.x = x; //rectangle doesn't update
			
			character2Label.setLocation(this.x, this.y);

			//detect collisions between character1 r and char2
			if (this.visible) this.detectCollision();
			
			System.out.println("x, y: " + this.x + " " + this.y);
			
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		while (this.moving) {
			
			int x = this.x;
			
			x += GameProperties.CHARACTER_STEP;
			
			if ( x >= GameProperties.SCREEN_WIDTH) {
				x = -1 * this.width;
			}
			
			this.setX(x); //this.x = x; //rectangle doesn't update
			
			//add loggie here to see what would happen
			chara_loggieLabel.setLocation(this.x, this.y);

			//detect collisions between character1 r and char2
			if (this.visible) this.detectCollision();
			
			System.out.println("x, y: " + this.x + " " + this.y);
			
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println("Thread Stopped");
		
	}
	
	private void detectCollision() {
		if ( this.r.intersects( character1.getRectangle() ) ) {
			//collision detected
			System.out.println("BOOM!");
			this.stopThread();
			
			this.setImage("car.jpeg");
character2Label.setIcon(new ImageIcon(
		getClass().getResource("images/" + this.getImage()
)));

			character1.setImage("froggie.png");
character1Label.setIcon(new ImageIcon(
		getClass().getResource("images/" + character1.getImage()
)));


		}
	}
	
	public void hide() {
		this.visible = false;
		character2Label.setVisible(this.visible);
		visibiltyButton.setText("Show");
	}

	public void show() {
		this.visible = true;
		character2Label.setVisible(this.visible);
		visibiltyButton.setText("Hide");
	}

}
