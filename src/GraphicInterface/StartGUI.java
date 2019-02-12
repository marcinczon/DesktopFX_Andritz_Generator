package GraphicInterface;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class StartGUI extends Application
{

	public static void main(String[] args)
	{
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		//Scene scene1 = new Scene();

		//primaryStage.setScene(scene1);
		primaryStage.setResizable(false);
		primaryStage.setTitle("");
		primaryStage.setOnCloseRequest((WindowEvent event) ->
		{
			Platform.exit();
			System.exit(0);
		});
		primaryStage.show();
	}

}
