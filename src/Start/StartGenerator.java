package Start;

import java.io.FileNotFoundException;
import java.io.IOException;

import Analog.GeneratorAnalog;
import Binary.GeneratorBinary;
import Motors.GeneratorMotorDOL;
import Motors.GeneratorMotorVFD;
import PID.GeneratorPID;
import Valve.GeneratorValves;

public class StartGenerator
{

	
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
//		GeneratorAnalog 	analog 		= new GeneratorAnalog();
//		GeneratorBinary 	binary 		= new GeneratorBinary();
//		GeneratorMotorDOL 	motorDOL 	= new GeneratorMotorDOL();
//		GeneratorMotorVFD 	motorVFD 	= new GeneratorMotorVFD();
//		GeneratorValves 	valve 		= new GeneratorValves();
		GeneratorPID		pid  		= new GeneratorPID();
		
//		analog.CreateOutputsFiles("Analog");
//		binary.CreateOutputsFiles("Binary");
//		motorDOL.CreateOutputsFiles("Motor DOL");
//		motorVFD.CreateOutputsFiles("Motor VFD");
//		valve.CreateOutputsFiles("Valve");
		pid.CreateOutputsFiles("PID");
	}

}
