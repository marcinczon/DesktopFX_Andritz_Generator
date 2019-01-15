import java.io.IOException;

public class StartAnalog
{

	public static void main(String[] args)
	{
		Analog analog = new Analog();
		
		try
		{
			analog.CreateOutputsFiles();
		} catch (IOException e)
		{
			
			e.printStackTrace();
		}

	}

}
