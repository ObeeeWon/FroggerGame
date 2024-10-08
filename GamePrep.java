import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GamePrep extends JFrame implements KeyListener, ActionListener {

	//declare copies of our character
	private Character1 character1;
	private Character2 character2;
	
	//GUI variables
	private Container content;
	private JLabel character1Label, character2Label;
	private ImageIcon character1Image, character2Image;
	
	//2 buttons
	private JButton startButton, visibilityButton;
	
	//GUI setup
	public GamePrep() {
		super("Doctor Demo");
		character1 = new Character1(100, 200, 120, 200, "dw12.png");
		character2 = new Character2(0, 0, 120, 200, "tardis.png");
		
		//set up screen
		setSize(GameProperties.SCREEN_WIDTH, 
				     GameProperties.SCREEN_HEIGHT);
		content = getContentPane();
		content.setBackground(Color.gray);
		setLayout(null);
		
		//character1 setup
		character1.setX(100);
		character1.setY(250);
		character1.setWidth(100);
		character1.setHeight(200);
		character1.setImage("dw12.png");
		
		character1Label = new JLabel();
		character1Image = new ImageIcon(
	getClass().getResource("images/" + character1.getImage()
		));
		character1Label.setIcon(character1Image);
		character1Label.setSize(
				character1.getWidth(),
				character1.getHeight()
		);
		character1Label.setLocation(
				character1.getX(), character1.getY() );

		//character2 setup
		character2.setX(0);
		character2.setY(0);
		character2.setWidth(120);
		character2.setHeight(200);
		character2.setImage("tardis.png");
				
		character2Label = new JLabel();
		character2Image = new ImageIcon(
			getClass().getResource("images/" + character2.getImage()
				));
		character2Label.setIcon(character2Image);
		character2Label.setSize(
						character2.getWidth(),
						character2.getHeight()
				);
		character2Label.setLocation(
						character2.getX(), character2.getY() );
		
		
		
		
		
		//set up visibility button
		visibilityButton = new JButton("Hide");
		visibilityButton.setSize(100, 50);
		visibilityButton.setLocation(
				GameProperties.SCREEN_WIDTH - 100, 
				GameProperties.SCREEN_HEIGHT - 100);
		visibilityButton.setFocusable(false);
		visibilityButton.addActionListener(this);
		
		//move button
		startButton = new JButton("Run");
		startButton.setSize(100, 100);
		startButton.setLocation(
				GameProperties.SCREEN_WIDTH - 100, 
				GameProperties.SCREEN_HEIGHT - 200);
		startButton.setFocusable(false);
		startButton.addActionListener(this);
		
		
		add(visibilityButton);
		add(startButton);
		add(character1Label);
		add(character2Label);
		
		content.addKeyListener(this);
		content.setFocusable(true);

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public static void main(String[] args) {
		GamePrep myGame = new GamePrep();
		myGame.setVisible(true);
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		//get current position
		int x = character1.getX();
		int y = character1.getY();
		
		//detect direction
		if ( e.getKeyCode() == KeyEvent.VK_UP ) {
			
			y -= GameProperties.CHARACTER_STEP;
			
			if ( y + character1.getHeight() <=  0) {

				y = GameProperties.SCREEN_HEIGHT;

			}
			
		} else if ( e.getKeyCode() == KeyEvent.VK_DOWN ) {
			
			y += GameProperties.CHARACTER_STEP;
			
			if ( y >= GameProperties.SCREEN_HEIGHT) {
				
				y = -1 * character1.getHeight();
				
			}
			
		} else if ( e.getKeyCode() == KeyEvent.VK_LEFT ) {
			
			x -= GameProperties.CHARACTER_STEP;
			
			if (x + character1.getWidth() <= 0) {

				x = GameProperties.SCREEN_WIDTH;

			}
			
		}  else if ( e.getKeyCode() == KeyEvent.VK_RIGHT ) {
			
			x += GameProperties.CHARACTER_STEP;
			
			if ( x >= GameProperties.SCREEN_WIDTH ) {

				x = -1 * character1.getWidth();

			}
			
		} 
		
		//update character1
		character1.setX(x);
		character1.setY(y);
		
		//move label
		character1Label.setLocation(
				character1.getX(), character1.getY() );
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if ( e.getSource() == visibilityButton ) {
			System.out.println("visibilityButton pressed");			
		} else if ( e.getSource() == startButton ) {
			System.out.println("startButton pressed");			
		}
		
	}

}
