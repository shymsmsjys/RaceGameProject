/* Name: Seongkwan Son
 * Section: 01 DB
 * Date Created: Nov 2nd, 2020
 * Date Modifed: Nov 13th, 2020
 */
package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application{
	Stage mStage;
	
	Pane firstPane = new Pane();
	private int playerNum;

	TextField Player1;
	TextField Player2;
	TextField Player3;
	TextField Player4;
	String[] playerName;
	Image image = new Image("file:playing yut.jpg");
	
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
		
		ImageView iv = new ImageView();
		iv.setImage(image);
		iv.setFitHeight(1000);
		iv.setFitWidth(1000);
		firstPane.getChildren().add(iv);
		
		Text text = new Text("How many players play the game?");
		text.setLayoutX(250);
		text.setLayoutY(150);
		text.setStyle("-fx-font-size: 35;");
		firstPane.getChildren().add(text);
		
		Button bt1 = new Button("Two");
		bt1.setLayoutX(250);
		bt1.setLayoutY(200);
		bt1.setStyle("-fx-font-size: 30");
		bt1.setOnAction(e-> {
			playerNum = 2;
			typeName();
		});
		firstPane.getChildren().add(bt1);
		Button bt2 = new Button("Three");
		bt2.setLayoutX(450);
		bt2.setLayoutY(200);
		bt2.setStyle("-fx-font-size: 30");
		bt2.setOnAction(e-> {
			playerNum = 3;
			typeName();
		});
		firstPane.getChildren().add(bt2);
		Button bt3 = new Button("Four");
		firstPane.getChildren().add(bt3);
		bt3.setLayoutX(650);
		bt3.setLayoutY(200);
		bt3.setStyle("-fx-font-size: 30");
		bt3.setOnAction(e-> {
			playerNum = 4;
			typeName();
		});
		
		Button help = new Button("Descripion");
		help.setStyle("-fx-font-size: 20");
		help.setLayoutX(440);
		help.setLayoutY(300);
		help.setOnAction(e -> {

			String Description = "Boost tile: move the horse extra tiles" +"\n"+
							  "Obstacle: Skip one turn to roll the dice"+"\n"+
					          "Caught by other horses: Go to starting line(Be careful!)"+"\n"+
							  "RocketMan skill: move extra 1.5times of boost tile."+"\n"+
					          "Invisible: Never get caught by others"+"\n"+
							  "Unstoppalbe: Obstacle can't stop your horse. ";

			Alert popup = new Alert(Alert.AlertType.INFORMATION, Description, ButtonType.OK);

			popup.setHeaderText("Description");
			popup.setTitle("Help");
			popup.showAndWait();

		});
		firstPane.getChildren().add(help);
		
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public void typeName() {
		firstPane.getChildren().clear();
		Text textName = new Text("Type names in English only");
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

			firstPane.getChildren().add(Player1);
			firstPane.getChildren().add(Player2);
			
			Player1.setLayoutX(250);
			Player1.setLayoutY(200);
			Player2.setLayoutX(450);
			Player2.setLayoutY(200);
			
		}
		else if (playerNum == 3) {
			
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
		
		Button btStart = new Button("Start");
		firstPane.getChildren().add(btStart);
		btStart.setLayoutX(450);
		btStart.setLayoutY(450);
		btStart.setStyle("-fx-font-size: 30");
		btStart.setOnAction(e-> {
			
			playerName[0] = Player1.getText();
			playerName[1] = Player2.getText();
			playerName[2] = Player3.getText();
			playerName[3] = Player4.getText();
			
			try {
				checkSpell(playerName[0]);
				checkSpell(playerName[1]);
				checkSpell(playerName[2]);
				checkSpell(playerName[3]);
			} catch (Exception e1) {
				String Text = " Type Player's names only in English and numerical value.(Don't use #,!,~,*)";
				
				Alert Direction = new Alert(Alert.AlertType.INFORMATION, Text, ButtonType.OK);
				Direction.setTitle("Direction");
				Direction.showAndWait();
				return;
			}
			
			GameManager gm = new GameManager (playerNum, playerName);
			
			gm.start();
			
			Board board = new Board(gm);
			Scene scene = new Scene(board, 1000, 1000);
			mStage.setScene(scene);
			mStage.show();
			
		});
		
	}
	public int getPlayerNum() {
		System.out.println("getPlayerNum() = " + playerNum);
		return playerNum;
	}
	
	private void checkSpell(String str) throws Exception {
		if (str.contains("#")
				|| str.contains("!")
				|| str.contains("~")
				|| str.contains("*")
				) {
			throw new Exception();
		}
	}
}