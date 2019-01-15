package GUI;


import javafx.scene.Scene;


public class gui

{
	private Scene mainScene;
	private mainScene paneCentrum;


	public gui()
	{
		crateVisu();
	}

	private void crateVisu()
	{
		
		paneCentrum = new mainScene();	
		mainScene = new Scene(paneCentrum.getPaneCentrum(), 600, 600);		
	}

	public Scene getMainScene()
	{
		return mainScene;
	}

}
