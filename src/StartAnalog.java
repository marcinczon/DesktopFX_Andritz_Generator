import java.io.IOException;

public class StartAnalog
{

	public static void main(String[] args)
	{
		GeneratorAnalog analog = new GeneratorAnalog();
		
		try
		{
			analog.CreateOutputsFiles();
		} catch (IOException e)
		{
			
			e.printStackTrace();
		}

	}

}
