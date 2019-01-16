import java.io.IOException;

public class StartMotor
{

	public static void main(String[] args)
	{
		GeneratorMotorDOL motor = new GeneratorMotorDOL();
		
		try
		{
			motor.CreateOutputsFiles();
		} catch (IOException e)
		{
			
			e.printStackTrace();
		}

	}

}
