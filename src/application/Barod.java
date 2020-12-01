package application;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Barod extends Pane {
	
	int[] horsePosition;
	Player[] players;
	GameManager mGm;

	public Barod(GameManager gm) {
		super();
		mGm = gm;
		init();
	}
	
	private void init() {
		players = mGm.getPlayers();
		Image imgBg= new Image("file:res/img_board.jpg");
		ImageView ivBg = new ImageView();
		ivBg.setImage(imgBg);
		getChildren().add(ivBg);
	}
	
	public void getHorseLocation(int id) {
		int location = mGm.getPlayers()[id].getHorse().getLocation();
	}

	// gamemanager РќДо
	// 
}
