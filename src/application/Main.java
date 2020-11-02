package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {
	Board board;
	
	@Override
	public void start(Stage primaryStage) {
		
		Label playerNum = new Label("How many Players?(2 to 4)");
		Label playerName = new Label("Type each players name. No speical letter allowed");
		playerNum.setStyle("-fx-font-size: 30");
		playerNum.setLayoutX(650);
		playerNum.setLayoutY(300);
		playerName.setStyle("-fx-font-size: 30");

		TextField tfPlayerNum = new TextField();
		tfPlayerNum.setMaxSize(30, 30);
		tfPlayerNum.setLayoutX(650);
		tfPlayerNum.setLayoutY(330);
		

		Image image = new Image("file:playing yut.jpg");
		ImageView iv = new ImageView();
		iv.setImage(image);
		iv.setFitWidth(1500);
		iv.setFitHeight(1000);
		
		Button btStart = new Button();
		btStart.setText("Start The Game");
		btStart.setStyle("-fx-font-size: 30");


		
		
		pane.getChildren().add(iv);
			pane.getChildren().add(btStart);
			pane.getChildren().add(playerNum);
			pane.getChildren().add(tfPlayerNum);
			
		
		
			btStart.setOnAction(e-> {
				
				String[] PlayerName = new String[4];
				isInt(tfPlayerNum, tfPlayerNum.getText());
				for (int i = 0; i < PlayerName.length; i++) 
					
				{
				}
			
				
			});
			
			
			Scene scene = new Scene(pane,1500,1000);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		
			
	}
	
	private boolean isInt(TextField input, String message) {
		try {
			int num = Integer.parseInt(input.getText());
		return true;
			
		}catch(NumberFormatException e) {
			System.out.println("Error:" + message + " is not number");
		return false;
		}
		
	}
	
	private int StringConvertInt(TextField input) {
		int num = Integer.parseInt(input.getText());
		return num;
	}
		
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
