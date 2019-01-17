import java.io.IOException;

public class StartMotor
{

	public static void main(String[] args)
	{
		//GeneratorMotorDOL motorDOL = new GeneratorMotorDOL();
		GeneratorMotorVFD motorVFD = new GeneratorMotorVFD();
		
		try
		{
		//	motorDOL.CreateOutputsFiles();
			motorVFD.CreateOutputsFiles();
		} catch (IOException e)
		{
			
			e.printStackTrace();
		}

	}

}
