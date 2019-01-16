import java.io.IOException;

public class StartValve
{

	public static void main(String[] args)
	{
		GeneratorValves valve = new GeneratorValves();
		
		try
		{
			valve.CreateOutputsFiles();
		} catch (IOException e)
		{
			
			e.printStackTrace();
		}

	}

}
