package application;

import javafx.scene.layout.Pane;

public class Barod extends Pane {
	
	GameManager mGm;

	public Barod(GameManager mGm) {
		super();
		this.mGm = mGm;
	}
	
	public void getHorseLocation(int id) {
		int location = mGm.getPlayers()[id].getHorse().getLocation();
	}

	// gamemanager РќДо
	// 
}
