package Binary;
import java.io.IOException;

public class StartBinary
{

	public static void main(String[] args)
	{
		GeneratorBinary binary = new GeneratorBinary();
		
		try
		{
			binary.CreateOutputsFiles();
		} catch (IOException e)
		{
			
			e.printStackTrace();
		}

	}

}
