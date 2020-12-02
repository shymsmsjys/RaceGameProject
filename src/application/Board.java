package application;

import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Board extends Pane {
	
	int[] horsePosition;
	Player [] players;
	GameManager mGm;
	Button roll;
	int posX[/*path*/][/*index*/];
	int posY[][];

	public Board(GameManager mGm) {
		super();
		this.mGm = mGm;
		init();
	}
	
	private void init() {
		players = mGm.getPlayers();
		Image imgBg = new Image("file:Board.png");
		ImageView ivBg = new ImageView();
		ivBg.setImage(imgBg);
		getChildren().add(ivBg);
		
		// start 300, 300
		initPosition();
		posX[0] = 300;
		posY[0] = 300;
	}
	
	public void getHorseLocation(int id) {
		int location = mGm.getPlayers()[id].getHorse().getLocation();
	}
	
	roll.setOnAction(e-> {
		mGm.nextDice();
		
		// update horse's graphical location 
		image1.setLayoutX(posX[/*player's path*/][22]);
		image1.setLayoutX(posY[/*player's path*/][22]);
		
		
	});
	
	private void initPosition() {
		posX[0][0] = 300;
		posY[0][0] = 300;
		posX[0][1] = 300;
		posY[0][1] = 300 -20;
		
		// if path is 1
		posX[1][0] = 300;
		posY[1][0] = 300;

		

		
	}

	// gamemanager РќДо
	// 
}
