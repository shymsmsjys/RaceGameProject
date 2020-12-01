/* Name: Seongkwan Son
 * Section: 01 DB
 * Date Created: Nov 2nd, 2020
 * Date Modifed: Nov 13th, 2020
 */
package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application{
	Stage mStage;
	
	Pane firstPane = new Pane();
	Pane secondPane = new Pane();
	private int playerNum;
	
	TextField Player1;
	TextField Player2;
	TextField Player3;
	TextField Player4;
	String[] playerName;

	
	public static void main(String[] args) {
		Main main = new Main();
		launch(args);
	}
	
	public Main() {
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		mStage = primaryStage;
		Scene scene = new Scene(firstPane,1000,1000);
		
		Text text = new Text("How many players play the game?");
		text.setLayoutX(280);
		text.setLayoutY(100);
		text.setStyle("-fx-font-size: 30;");
		firstPane.getChildren().add(text);
		
		Button bt1 = new Button("Two");
		bt1.setLayoutX(250);
		bt1.setLayoutY(200);
		bt1.setStyle("-fx-font-size: 30");
		bt1.setOnAction(e-> {
			playerNum = 2;
//			GameManager gm = new GameManager(playerNum);
//			gm.start();
			typeName();
		});
		firstPane.getChildren().add(bt1);
		Button bt2 = new Button("Three");
		bt2.setLayoutX(450);
		bt2.setLayoutY(200);
		bt2.setStyle("-fx-font-size: 30");
		bt2.setOnAction(e-> {
			playerNum = 3;
			//GameManager gm = new GameManager(playerNum);
			//gm.start();
			changeToBoard(3);
		});
		firstPane.getChildren().add(bt2);
		Button bt3 = new Button("Four");
		firstPane.getChildren().add(bt3);
		bt3.setLayoutX(650);
		bt3.setLayoutY(200);
		bt3.setStyle("-fx-font-size: 30");
		bt3.setOnAction(e-> {
			playerNum = 4;
//			GameManager gm = new GameManager(playerNum);
//			gm.start();
			typeName();
		});
		
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	private void changeToBoard(int playerNum) {
		GameManager gm = new GameManager(3);
		gm.start();
		Barod board = new Barod(gm);
		Scene scene = new Scene(board, 1000, 1000);
		mStage.setScene(scene);
		mStage.show();
	}
	
	public void typeName() {
		firstPane.getChildren().clear();
		Text textName = new Text("Type the name in English only");
		textName.setStyle("-fx-font-size: 30;");
		textName.setLayoutX(280);
		textName.setLayoutY(100);
		firstPane.getChildren().add(textName);
		
		Player1 = new TextField("Player1");
		Player2 = new TextField("Player2");
		Player3 = new TextField("Player3");
		Player4 = new TextField("Player4");
		playerName = new String[4];
		
		if(playerNum == 2) {
//			TextField Player1 = new TextField("Player1");
//			TextField Player2 = new TextField("Player2");
			firstPane.getChildren().add(Player1);
			firstPane.getChildren().add(Player2);
			Player1.setLayoutX(250);
			Player1.setLayoutY(200);
			Player2.setLayoutX(450);
			Player2.setLayoutY(200);
			
		}
		else if (playerNum == 3) {
//			TextField Player1 = new TextField("Player1");
//			TextField Player2 = new TextField("Player2");
//			TextField Player3 = new TextField("Player3");
			firstPane.getChildren().add(Player1);
			firstPane.getChildren().add(Player2);
			firstPane.getChildren().add(Player3);
			Player1.setLayoutX(250);
			Player1.setLayoutY(200);
			Player2.setLayoutX(450);
			Player2.setLayoutY(200);
			Player3.setLayoutX(650);
			Player3.setLayoutY(200);
		}
		else if (playerNum == 4) {
//			TextField Player1 = new TextField("Player1");
//			TextField Player2 = new TextField("Player2");
//			TextField Player3 = new TextField("Player3");
//			TextField Player4 = new TextField("Player4");
			firstPane.getChildren().add(Player1);
			firstPane.getChildren().add(Player2);
			firstPane.getChildren().add(Player3);
			firstPane.getChildren().add(Player4);
			Player1.setLayoutX(150);
			Player1.setLayoutY(200);
			Player2.setLayoutX(350);
			Player2.setLayoutY(200);
			Player3.setLayoutX(550);
			Player3.setLayoutY(200);
			Player4.setLayoutX(750);
			Player4.setLayoutY(200);
		}
		
		Button btnStart = new Button("Start");
		firstPane.getChildren().add(btnStart);
		btnStart.setLayoutX(450);
		btnStart.setLayoutY(450);
		btnStart.setStyle("-fx-font-size: 30");
		btnStart.setOnAction(e-> {
			playerName[0] = Player1.getText();
			playerName[1] = Player2.getText();
			playerName[2] = Player3.getText();
			playerName[3] = Player4.getText();
			
			GameManager gm = new GameManager(playerNum, playerName);
			gm.start();
			
		});

	}
	public int getPlayerNum() {
		System.out.println("getPlayerNum() = " + playerNum);
		return playerNum;
	}
}