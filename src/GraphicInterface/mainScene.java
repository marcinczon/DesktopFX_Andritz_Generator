package GraphicInterface;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;

public class mainScene
{
	static Pane mainPane;
	private Button buttonChoose;
	private Button buttonCreate;
	private TextField tfFolderName;
	private String masterPath;

	public mainScene()
	{

		mainPane = new Pane();
		mainPane.setPrefSize(500, 500);
		mainPane.setLayoutX(0);
		mainPane.setLayoutY(0);

		createButtons();
		createTextFields();
		runEvents();

		mainPane.getChildren().add(buttonCreate);
		mainPane.getChildren().add(buttonChoose);
		mainPane.getChildren().add(tfFolderName);

	}

	private void createButtons()
	{
		buttonCreate = new Button("Create");
		buttonCreate.setPrefSize(100, 15);
		buttonCreate.setLayoutX(10);
		buttonCreate.setLayoutY(10);

		buttonChoose = new Button("Choose");
		buttonChoose.setPrefSize(100, 15);
		buttonChoose.setLayoutX(120);
		buttonChoose.setLayoutY(10);
	}

	private void createTextFields()
	{
		tfFolderName = new TextField("FolderName");
		tfFolderName.setLayoutX(10);
		tfFolderName.setLayoutY(50);
		tfFolderName.setPrefSize(210, 15);

	}

	private void runEvents()
	{
		buttonChoose.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent buttonWybierzEvent)
			{
				fileChooser();
			}
		});
		buttonCreate.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent buttonUtworzEvent)
			{

			}
		});
	}
	private void fileChooser()
	{
		DirectoryChooser directoryChooser = new DirectoryChooser();
		File selectedDirectory = directoryChooser.showDialog(null);

		if (selectedDirectory == null)
		{
			System.out.println("No Directory selected");
		} else
		{
			masterPath = selectedDirectory.getAbsolutePath();
			System.out.println("Choosed: " + masterPath);

		}

	}

	public static Pane getPaneCentrum()
	{
		return mainPane;
	}

}
