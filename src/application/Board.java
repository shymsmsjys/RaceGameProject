package application;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.TriangleMesh;

public class Board extends Pane {
	
	int[] horsePosition;
	Player [] players;
	GameManager mGm;
	Button rollbt = new Button("Roll");
	int posX[][];
	int posY[][];
	
	
	public Board(GameManager mGm) {
		super();
		this.mGm = mGm;
		init();
	}
	
	private void init() {
		posX = new int [4][61];
		posY = new int [4][61];
		
		players = mGm.getPlayers();
		Image imgBg = new Image("file:Board.png");
		ImageView ivBg = new ImageView();
		ivBg.setImage(imgBg);
		getChildren().add(ivBg);
		
		rollbt.setStyle("-fx-font-size: 30");
		rollbt.setLayoutX(350);
		rollbt.setLayoutY(900);
		getChildren().add(rollbt);
		
		Rectangle horse1 = new Rectangle();
		horse1.setFill(Color.BLUE);
		horse1.setWidth(15);
		horse1.setHeight(15);
		horse1.setLayoutX(720);
		horse1.setLayoutY(730);
		getChildren().add(horse1);
		
		Rectangle horse2 = new Rectangle();
		horse2.setFill(Color.WHITE);
		horse2.setWidth(15);
		horse2.setHeight(15);
		horse2.setLayoutX(730);
		horse2.setLayoutY(730);
		getChildren().add(horse2);
		
		Rectangle horse3 = new Rectangle();
		horse3.setFill(Color.SILVER);
		horse3.setWidth(15);
		horse3.setHeight(15);
		horse3.setLayoutX(740);
		horse3.setLayoutY(730);
		getChildren().add(horse3);
		
		Rectangle horse4 = new Rectangle();
		horse4.setFill(Color.GOLD);
		horse4.setWidth(15);
		horse4.setHeight(15);
		horse4.setLayoutX(750);
		horse4.setLayoutY(730);
		getChildren().add(horse4);
		/*
		Circle [] obstacle = new Circle [8];
		for (int i = 0; i < obstacle.length; i++) {
			obstacle[i].setFill(Color.GREEN);
			obstacle[i].setStrokeWidth(10);
			//obstacle[i].setLayoutX(posX[0][0]);
			//obstacle[i].setLayoutY(posY[0][0]);
		}
		
		Ellipse [] boostTile = new Ellipse [8];
		for (int i = 0; i < boostTile.length; i++) {
			boostTile[i].setFill(Color.YELLOW);
			boostTile[i].setStroke(Color.RED);
			boostTile[i].setStrokeWidth(10);
		//	boostTile[i].setLayoutX(posX[0][0]);
			//boostTile[i].setLayoutY(posY[0][0]);
		}
		
		
		/*
		Text nameList = new Text(players[0].getName() + "'s horse is blue" + "\n"
								+players[1].getName() + "'s horse is white" + "\n" +
								 players[2].getName() + "'s horse is silver" + "\n" +
								 players[3].getName() + "'s horse is gold");
		nameList.setStyle("-fx-font-size: 15");
		nameList.setLayoutX(800);
		nameList.setLayoutY(30);
		getChildren().add(nameList);
		*/
		
		rollbt.setOnAction(e-> {
			
				mGm.nextDice();
				
			
			
			// update horse's graphical location 
			Player player = mGm.getCurrentPlayer();
			int horseLocation = player.getHorse().getLocation();
			horse1.setLayoutX(posX[player.getPath()][players[0].getHorse().getLocation()]);
			horse1.setLayoutY(posY[player.getPath()][players[0].getHorse().getLocation()]);
			horse2.setLayoutX(posX[player.getPath()][players[1].getHorse().getLocation()]);
			horse2.setLayoutY(posY[player.getPath()][players[1].getHorse().getLocation()]);
			
			if (players.length >= 3) {
				horse3.setLayoutX(posX[player.getPath()][players[2].getHorse().getLocation()]);
				horse3.setLayoutY(posY[player.getPath()][players[2].getHorse().getLocation()]);
			}
			
			if (players.length >= 4) {
				horse4.setLayoutX(posX[player.getPath()][players[3].getHorse().getLocation()]);
				horse4.setLayoutY(posY[player.getPath()][players[3].getHorse().getLocation()]);
			}
			
			
		});
		
		// start 730, 730
		//initPosition();
		// PATH 0 ¿œ∂ß
		posX[0][0] = 730;
		posY[0][0] = 730;
		posX[0][1] = 730;
		posY[0][1] = 670;
		posX[0][2] = 730;
		posY[0][2] = 630;
		posX[0][3] = 730;
		posY[0][3] = 580;
		posX[0][4] = 730;
		posY[0][4] = 530;
		posX[0][5] = 730;
		posY[0][5] = 490;
		posX[0][6] = 730;
		posY[0][6] = 450;
		posX[0][7] = 730;
		posY[0][7] = 400;
		posX[0][8] = 730;
		posY[0][8] = 350;
		posX[0][9] = 730;
		posY[0][9] = 300;
		posX[0][10] = 730;
		posY[0][10] = 250;
		posX[0][11] = 730;
		posY[0][11] = 200;
		posX[0][12] = 730;
		posY[0][12] = 160;
		posX[0][13] = 730;
		posY[0][13] = 110;
		posX[0][14] = 730;
		posY[0][14] = 70;
		posX[0][15] = 730;
		posY[0][15] = 20;
		posX[0][16] = 680;
		posY[0][16] = 20;
		posX[0][17] = 630;
		posY[0][17] = 20;
		posX[0][18] = 590;
		posY[0][18] = 20;
		posX[0][19] = 550;
		posY[0][19] = 20;
		posX[0][20] = 500;
		posY[0][20] = 20;
		posX[0][21] = 450;
		posY[0][21] = 20;
		posX[0][22] = 400;
		posY[0][22] = 20;
		posX[0][23] = 350;
		posY[0][23] = 20;
		posX[0][24] = 300;
		posY[0][24] = 20;
		posX[0][25] = 250;
		posY[0][25] = 20;
		posX[0][26] = 200;
		posY[0][26] = 20;
		posX[0][27] = 150;
		posY[0][27] = 20;
		posX[0][28] = 110;
		posY[0][28] = 20;
		posX[0][29] = 70;
		posY[0][29] = 20;
		posX[0][30] = 20;
		posY[0][30] = 20;
		posX[0][31] = 20;
		posY[0][31] = 70;
		posX[0][32] = 20;
		posY[0][32] = 110;
		posX[0][33] = 20;
		posY[0][33] = 150;
		posX[0][34] = 20;
		posY[0][34] = 200;
		posX[0][35] = 20;
		posY[0][35] = 240;
		posX[0][36] = 20;
		posY[0][36] = 290;
		posX[0][37] = 20;
		posY[0][37] = 330;
		posX[0][38] = 20;
		posY[0][38] = 380;
		posX[0][39] = 20;
		posY[0][39] = 420;
		posX[0][40] = 20;
		posY[0][40] = 470;
		posX[0][41] = 20;
		posY[0][41] = 520;
		posX[0][42] = 20;
		posY[0][42] = 570;
		posX[0][43] = 20;
		posY[0][43] = 610;
		posX[0][44] = 20;
		posY[0][44] = 670;
		posX[0][45] = 20;
		posY[0][45] = 735;
		posX[0][46] = 70;
		posY[0][46] = 735;
		posX[0][47] = 120;
		posY[0][47] = 735;
		posX[0][48] = 170;
		posY[0][48] = 735;
		posX[0][49] = 220;
		posY[0][49] = 735;
		posX[0][50] = 270;
		posY[0][50] = 735;
		posX[0][51] = 320;
		posY[0][51] = 735;
		posX[0][52] = 360;
		posY[0][52] = 735;
		posX[0][53] = 410;
		posY[0][53] = 735;
		posX[0][54] = 460;
		posY[0][54] = 735;
		posX[0][55] = 510;
		posY[0][55] = 735;
		posX[0][56] = 560;
		posY[0][56] = 735;
		posX[0][57] = 610;
		posY[0][57] = 735;
		posX[0][58] = 650;
		posY[0][58] = 735;
		posX[0][59] = 690;
		posY[0][59] = 735;
		posX[0][60] = 740;
		posY[0][60] = 735;
		
		//PATH 1
		posX[1][0] = 730;
		posY[1][0] = 730;
		posX[1][1] = 730;
		posY[1][1] = 670;
		posX[1][2] = 730;
		posY[1][2] = 630;
		posX[1][3] = 730;
		posY[1][3] = 580;
		posX[1][4] = 730;
		posY[1][4] = 530;
		posX[1][5] = 730;
		posY[1][5] = 490;
		posX[1][6] = 730;
		posY[1][6] = 450;
		posX[1][7] = 730;
		posY[1][7] = 400;
		posX[1][8] = 730;
		posY[1][8] = 350;
		posX[1][9] = 730;
		posY[1][9] = 300;
		posX[1][10] = 730;
		posY[1][10] = 250;
		posX[1][11] = 730;
		posY[1][11] = 200;
		posX[1][12] = 730;
		posY[1][12] = 160;
		posX[1][13] = 730;
		posY[1][13] = 110;
		posX[1][14] = 730;
		posY[1][14] = 70;
		posX[1][15] = 730;
		posY[1][15] = 20;
		posX[1][16] = 685;
		posY[1][16] = 70;
		posX[1][17] = 645;
		posY[1][17] = 105;
		posX[1][18] = 605;
		posY[1][18] = 150;
		posX[1][19] = 555;
		posY[1][19] = 200;
		posX[1][20] = 505;
		posY[1][20] = 250;
		posX[1][21] = 465;
		posY[1][21] = 295;
		posX[1][22] = 420;
		posY[1][22] = 330;
		posX[1][23] = 380;
		posY[1][23] = 375;
		posX[1][24] = 340;
		posY[1][24] = 420;
		posX[1][25] = 300;
		posY[1][25] = 460;
		posX[1][26] = 255;
		posY[1][26] = 495;
		posX[1][27] = 215;
		posY[1][27] = 535;
		posX[1][28] = 175;
		posY[1][28] = 585;
		posX[1][29] = 125;
		posY[1][29] = 625;
		posX[1][30] = 80;
		posY[1][30] = 675;
		posX[1][31] = 20;
		posY[1][31] = 735;
		posX[1][32] = 70;
		posY[1][32] = 735;
		posX[1][33] = 120;
		posY[1][33] = 735;
		posX[1][34] = 170;
		posY[1][34] = 735;
		posX[1][35] = 220;
		posY[1][35] = 735;
		posX[1][36] = 270;
		posY[1][36] = 735;
		posX[1][37] = 320;
		posY[1][37] = 735;
		posX[1][38] = 360;
		posY[1][38] = 735;
		posX[1][39] = 410;
		posY[1][39] = 735;
		posX[1][40] = 460;
		posY[1][40] = 735;
		posX[1][41] = 510;
		posY[1][41] = 735;
		posX[1][42] = 560;
		posY[1][42] = 735;
		posX[1][43] = 610;
		posY[1][43] = 735;
		posX[1][44] = 650;
		posY[1][44] = 735;
		posX[1][45] = 690;
		posY[1][45] = 735;
		posX[1][46] = 740;
		posY[1][46] = 735;
		
		//PATH 2 
		posX[2][0] = 730;
		posY[2][0] = 730;
		posX[2][1] = 730;
		posY[2][1] = 670;
		posX[2][2] = 730;
		posY[2][2] = 630;
		posX[2][3] = 730;
		posY[2][3] = 580;
		posX[2][4] = 730;
		posY[2][4] = 530;
		posX[2][5] = 730;
		posY[2][5] = 490;
		posX[2][6] = 730;
		posY[2][6] = 450;
		posX[2][7] = 730;
		posY[2][7] = 400;
		posX[2][8] = 730;
		posY[2][8] = 350;
		posX[2][9] = 730;
		posY[2][9] = 300;
		posX[2][10] = 730;
		posY[2][10] = 250;
		posX[2][11] = 730;
		posY[2][11] = 200;
		posX[2][12] = 730;
		posY[2][12] = 160;
		posX[2][13] = 730;
		posY[2][13] = 110;
		posX[2][14] = 730;
		posY[2][14] = 70;
		posX[2][15] = 730;
		posY[2][15] = 20;
		posX[2][16] = 685;
		posY[2][16] = 70;
		posX[2][17] = 645;
		posY[2][17] = 105;
		posX[2][18] = 605;
		posY[2][18] = 150;
		posX[2][19] = 555;
		posY[2][19] = 200;
		posX[2][20] = 505;
		posY[2][20] = 250;
		posX[2][21] = 465;
		posY[2][21] = 295;
		posX[2][22] = 420;
		posY[2][22] = 330;
		posX[2][23] = 380;
		posY[2][23] = 375;
		posX[2][24] = 425;
		posY[2][24] = 425;
		posX[2][25] = 465;
		posY[2][25] = 465;
		posX[2][26] = 505;
		posY[2][26] = 505;
		posX[2][27] = 545;
		posY[2][27] = 545;
		posX[2][28] = 585;
		posY[2][28] = 585;
		posX[2][29] = 635;
		posY[2][29] = 635;
		posX[2][30] = 685;
		posY[2][30] = 685;
		posX[2][31] = 740;
		posY[2][31] = 735;
		
		//PATH 3 
		posX[3][0] = 730;
		posY[3][0] = 730;
		posX[3][1] = 730;
		posY[3][1] = 670;
		posX[3][2] = 730;
		posY[3][2] = 630;
		posX[3][3] = 730;
		posY[3][3] = 580;
		posX[3][4] = 730;
		posY[3][4] = 530;
		posX[3][5] = 730;
		posY[3][5] = 490;
		posX[3][6] = 730;
		posY[3][6] = 450;
		posX[3][7] = 730;
		posY[3][7] = 400;
		posX[3][8] = 730;
		posY[3][8] = 350;
		posX[3][9] = 730;
		posY[3][9] = 300;
		posX[3][10] = 730;
		posY[3][10] = 250;
		posX[3][11] = 730;
		posY[3][11] = 200;
		posX[3][12] = 730;
		posY[3][12] = 160;
		posX[3][13] = 730;
		posY[3][13] = 110;
		posX[3][14] = 730;
		posY[3][14] = 70;
		posX[3][15] = 730;
		posY[3][15] = 20;
		posX[3][16] = 680;
		posY[3][16] = 20;
		posX[3][17] = 630;
		posY[3][17] = 20;
		posX[3][18] = 590;
		posY[3][18] = 20;
		posX[3][19] = 550;
		posY[3][19] = 20;
		posX[3][20] = 500;
		posY[3][20] = 20;
		posX[3][21] = 450;
		posY[3][21] = 20;
		posX[3][22] = 400;
		posY[3][22] = 20;
		posX[3][23] = 350;
		posY[3][23] = 20;
		posX[3][24] = 300;
		posY[3][24] = 20;
		posX[3][25] = 250;
		posY[3][25] = 20;
		posX[3][26] = 200;
		posY[3][26] = 20;
		posX[3][27] = 150;
		posY[3][27] = 20;
		posX[3][28] = 110;
		posY[3][28] = 20;
		posX[3][29] = 70;
		posY[3][29] = 20;
		posX[3][30] = 20;
		posY[3][30] = 20;
		posX[3][31] = 70;
		posY[3][31] = 70;
		posX[3][32] = 110;
		posY[3][32] = 110;
		posX[3][33] = 155;
		posY[3][33] = 155;
		posX[3][34] = 205;
		posY[3][34] = 200;
		posX[3][35] = 250;
		posY[3][35] = 250;
		posX[3][36] = 290;
		posY[3][36] = 290;
		posX[3][37] = 335;
		posY[3][37] = 335;
		posX[3][38] = 380;
		posY[3][38] = 375;
		posX[3][39] = 425;
		posY[3][39] = 425;
		posX[3][40] = 465;
		posY[3][40] = 465;
		posX[3][41] = 505;
		posY[3][41] = 505;
		posX[3][42] = 545;
		posY[3][42] = 545;
		posX[3][43] = 585;
		posY[3][43] = 585;
		posX[3][44] = 635;
		posY[3][44] = 635;
		posX[3][45] = 685;
		posY[3][45] = 685;
		posX[3][46] = 740;
		posY[3][46] = 735;
	}
	
	public void getHorseLocation(int id) {
		int location = mGm.getPlayers()[id].getHorse().getLocation();
	}
	
	
}
