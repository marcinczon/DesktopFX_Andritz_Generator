package Start;

import java.io.FileNotFoundException;
import java.io.IOException;

import Analog.GeneratorAnalog;
import Binary.GeneratorBinary;
import Motors.GeneratorMotorDOL;
import Motors.GeneratorMotorVFD;
import PID.GeneratorPID;
import Valve.GeneratorValves;

// ****************************
//
// To do:
//
// 1. Code to optimize
// 2. Fix problem with generating functions and screens
// 3. Prepared for PID function screens and function
// 4. Make a GUI
// 5. Oprimize the paths
// 
//****************************

//****************************
//
// Program to generating variables functions and screens for COPA DATA - ZENON 
// Scada, according Andritz standard 
// 
// How its work:
//
//	1. Importing .XML files prepered before
//	   extracted variables, types, drivers from oryginal files
//	2. Changed settings inside
//	3. Combine into one file each generated source
//	4. Save to one file to import
// 
//  Settings:
//  - The structute of input file have be like in Paths.java
//  - mainPath String variable to change according where are base folder
//  Example of folder structure:
//
// \ Base \	A999MW1 - Analog  \	 Source - Analog.txt
//						  		 \Oryginal\Variable	\*.XML
//								  		  \Screen	\*.XML
//								  		  \Function	\*.XML
//						  		 \Import\ImportVariablePart1.XML
//								  		 \ImportVariablePart2.XML
//								  		 \ImportVariablePart3.XML
//								 		 \...Screens
//								 		 \...Functions			
//						  		 \Generator\File to imports (*.XML)
//						
//
//
//     \ B999GS1 - Binary	\...
//****************************

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
