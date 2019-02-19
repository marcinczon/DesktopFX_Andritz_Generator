package Utils;


public final class Paths
{
	public static String LineName="C";
	
	public static String mainPath = "D:\\3_Praca\\Projekty\\Andritz\\04_Tools\\01_Generator\\Andritz_Generator_Input_Files\\New Base\\";
	
	//***************
	//
	// Analog Paths
	//
	//***************

	public static String mainPathAnalog = 						mainPath	   + "A999MW1 - Analog\\";
	//public static String outputPathAnalog = 					mainPath       + "A999MW1 - Analog\\Generator\\";
	//public static String outputPathAnalog = 					mainPath       + "A999MW1 - Analog\\Generator\\LINE_A\\";
	//public static String outputPathAnalog = 					mainPath       + "A999MW1 - Analog\\Generator\\LINE_B\\";
	public static String outputPathAnalog = 					mainPath       + "A999MW1 - Analog\\Generator\\LINE_C\\";
	
	//public static String sourcePathAnalog = 					mainPathAnalog + "Source - Analog.txt";
	//public static String sourcePathAnalog = 					mainPathAnalog + "Source A - Analog.txt";
	//public static String sourcePathAnalog = 					mainPathAnalog + "Source B - Analog.txt";
	public static String sourcePathAnalog = 					mainPathAnalog + "Source C - Analog.txt";

	public static String pathCMD_A999MW1 = 						mainPathAnalog + "Oryginal\\Variable\\CMD_A999MW1.XML";
	public static String pathCONFIG_A999MW1 = 					mainPathAnalog + "Oryginal\\Variable\\CONFIG_A999MW1.XML";
	public static String pathSTAT_A999MW1 = 					mainPathAnalog + "Oryginal\\Variable\\STAT_A999MW1.XML";
	
	public static String pathPUP_A999MW1_ANALOG = 				mainPathAnalog + "Oryginal\\Screen\\PUP_A999MW1_ANALOG.XML";
	public static String pathPUP_A999MW1_ANALOG_DET = 			mainPathAnalog + "Oryginal\\Screen\\PUP_A999MW1_ANALOG_DET.XML";
	public static String pathPUP_A999MW1_ANALOG_TREND =			mainPathAnalog + "Oryginal\\Screen\\PUP_A999MW1_ANALOG_TREND.XML";
	
	public static String pathSHOW_PUP_A999MW1_ANALOG = 			mainPathAnalog + "Oryginal\\Function\\SHOW_PUP_A999MW1_ANALOG.XML";
	public static String pathSHOW_PUP_A999MW1_ANALOG_DET = 		mainPathAnalog + "Oryginal\\Function\\SHOW_PUP_A999MW1_ANALOG_DET.XML";
	public static String pathSHOW_PUP_A999MW1_ANALOG_TREND = 	mainPathAnalog + "Oryginal\\Function\\SHOW_PUP_A999MW1_ANALOG_TREND.XML";
	
	
	public static String pathVariableCMD_A999MW1 = 				mainPathAnalog + "Import\\Variable_CMD_A999MW1.XML";
	public static String pathVariableCONFIG_A999MW1 = 			mainPathAnalog + "Import\\Variable_CONFIG_A999MW1.XML";
	public static String pathVariableSTAT_A999MW1 = 			mainPathAnalog + "Import\\Variable_STAT_A999MW1.XML";
	
	public static String pathVariablePart1_A999MW1 = 			mainPathAnalog + "Import\\ImportVariablePart1.XML";
	public static String pathVariablePart2_A999MW1 = 			mainPathAnalog + "Import\\ImportVariablePart2.XML";
	public static String pathVariablePart3_A999MW1 = 			mainPathAnalog + "Import\\ImportVariablePart3.XML";

	public static String pathFunctionPart1_A999MW1 = 			mainPathAnalog + "Import\\ImportFunctionPart1.XML";
	public static String pathFunctionPart2_A999MW1 = 			mainPathAnalog + "Import\\ImportFunctionPart2.XML";
	public static String pathFunctionPart3_A999MW1 = 			mainPathAnalog + "Import\\ImportFunctionPart3.XML";

	public static String pathScreenPart1_A999MW1 = 				mainPathAnalog + "Import\\ImportScreenPart1.XML";
	public static String pathScreenPart2_A999MW1 = 				mainPathAnalog + "Import\\ImportScreenPart2.XML";
	public static String pathScreenPart3_A999MW1 = 				mainPathAnalog + "Import\\ImportScreenPart3.XML";
	
	//***************
	//
	// Binary Paths
	//
	//***************	

	public static String mainPathBinary = 						mainPath	   + "B999GS1 - Binary\\";
	public static String outputPathBinary = 					mainPath	   + "B999GS1 - Binary\\Generator\\";
	//public static String outputPathBinary = 					mainPath	   + "B999GS1 - Binary\\Generator\\Line C\\";

	
	public static String sourcePathBinary = 					mainPathBinary + "Source - Binary.txt";
	//public static String sourcePathBinary = 					mainPathBinary + "Source C - Binary.txt";

	public static String pathCMD_B999GS1 = 						mainPathBinary + "Oryginal\\Variable\\CMD_B999GS1.XML";
	public static String pathCONFIG_B999GS1 = 					mainPathBinary + "Oryginal\\Variable\\CONFIG_B999GS1.XML";
	public static String pathSTAT_B999GS1 = 					mainPathBinary + "Oryginal\\Variable\\STAT_B999GS1.XML";
	public static String pathPUP_B999GS1_BIN = 					mainPathBinary + "Oryginal\\Screen\\PUP_B999GS1_BIN.XML";
	public static String pathSHOW_PUP_B999GS1_BIN = 			mainPathBinary + "Oryginal\\Function\\SHOW_PUP_B999GS1_BIN.XML";

	public static String pathVariableCMD_B999GS1 = 				mainPathBinary + "Import\\Variable_CMD_B999GS1.XML";
	public static String pathVariableCONFIG_B999GS1 = 			mainPathBinary + "Import\\Variable_CONFIG_B999GS1.XML";
	public static String pathVariableSTAT_B999GS1 = 			mainPathBinary + "Import\\Variable_STAT_B999GS1.XML";

	public static String pathVariablePart1_B999GS1 = 			mainPathBinary + "Import\\ImportVariablePart1.XML";
	public static String pathVariablePart2_B999GS1 = 			mainPathBinary + "Import\\ImportVariablePart2.XML";
	public static String pathVariablePart3_B999GS1 = 			mainPathBinary + "Import\\ImportVariablePart3.XML";

	public static String pathFunctionPart1_B999GS1 = 			mainPathBinary + "Import\\ImportFunctionPart1.XML";
	public static String pathFunctionPart2_B999GS1 = 			mainPathBinary + "Import\\ImportFunctionPart2.XML";
	public static String pathFunctionPart3_B999GS1 = 			mainPathBinary + "Import\\ImportFunctionPart3.XML";

	public static String pathScreenPart1_B999GS1 = 				mainPathBinary + "Import\\ImportScreenPart1.XML";
	public static String pathScreenPart2_B999GS1 = 				mainPathBinary + "Import\\ImportScreenPart2.XML";
	public static String pathScreenPart3_B999GS1 = 				mainPathBinary + "Import\\ImportScreenPart3.XML";
	
	
	//***************
	//
	// Valve Paths
	//
	//***************

	public static String mainPathValve = 						mainPath + 		"V999MV1 - Valve\\";
	public static String outputPathValve = 					    mainPath +  	"V999MV1 - Valve\\Generator\\";
	//public static String outputPathValve = 					mainPath +  	"V999MV1 - Valve\\Generator\\Line A\\";
	//public static String outputPathValve = 					mainPath +  	"V999MV1 - Valve\\Generator\\Line B\\";
	//public static String outputPathValve = 					mainPath +  	"V999MV1 - Valve\\Generator\\Line C\\";
	
	public static String sourcePathValve = 						mainPathValve + "Source - ValveV1.txt";
	//public static String sourcePathValve = 					mainPathValve + "Source A - ValveV1.txt";
	//public static String sourcePathValve = 					mainPathValve + "Source B - ValveV1.txt";
	//public static String sourcePathValve = 					mainPathValve + "Source C - ValveV1.txt";

	public static String pathCMD_V999MV1 = 						mainPathValve + "Oryginal\\Variable\\CMD_V999MV1.XML";
	public static String pathSTAT_V999MV1 = 					mainPathValve + "Oryginal\\Variable\\STAT_V999MV1.XML";
	
	public static String pathPUP_V999MV1_VAL= 					mainPathValve + "Oryginal\\Screen\\PUP_V999MV1_VAL.XML";
	public static String pathPUP_V999MV1_VAL_DET = 				mainPathValve + "Oryginal\\Screen\\PUP_V999MV1_VAL_DET.XML";
	public static String pathPUP_V999MV1_VAL_LCK =		    	mainPathValve + "Oryginal\\Screen\\PUP_V999MV1_VAL_LCK.XML";
	public static String pathPUP_V999MV1_VAL_2_LCK =		    mainPathValve + "Oryginal\\Screen\\PUP_V999MV1_VAL_2_LCK.XML";
	public static String pathPUP_V999MV1_VAL_PARAM= 			mainPathValve + "Oryginal\\Screen\\PUP_V999MV1_VAL_PARAM.XML";
	
	public static String pathSHOW_PUP_V999MV1_VAL = 			mainPathValve + "Oryginal\\Function\\SHOW_PUP_V999MV1_VAL.XML";
	public static String pathSHOW_PUP_V999MV1_VAL_DET = 		mainPathValve + "Oryginal\\Function\\SHOW_PUP_V999MV1_VAL_DET.XML";
	public static String pathSHOW_PUP_V999MV1_VAL_LCK = 		mainPathValve + "Oryginal\\Function\\SHOW_PUP_V999MV1_VAL_LCK.XML";
	public static String pathSHOW_PUP_V999MV1_VAL_2_LCK = 		mainPathValve + "Oryginal\\Function\\SHOW_PUP_V999MV1_VAL_2_LCK.XML";
	public static String pathSHOW_PUP_V999MV1_VAL_PARAM = 		mainPathValve + "Oryginal\\Function\\SHOW_PUP_V999MV1_VAL_PARAM.XML";

	
	public static String pathVariableCMD_V999MV1 = 				mainPathValve + "Import\\Variable_CMD_V999MV1.XML";
	public static String pathVariableSTAT_V999MV1 = 			mainPathValve + "Import\\Variable_STAT_V999MV1.XML";
	
	public static String pathVariablePart1_V999MV1 = 			mainPathValve + "Import\\ImportVariablePart1.XML";
	public static String pathVariablePart2_V999MV1 = 			mainPathValve + "Import\\ImportVariablePart2.XML";
	public static String pathVariablePart3_V999MV1 = 			mainPathValve + "Import\\ImportVariablePart3.XML";

	public static String pathFunctionPart1_V999MV1 = 			mainPathValve + "Import\\ImportFunctionPart1.XML";
	public static String pathFunctionPart2_V999MV1 = 			mainPathValve + "Import\\ImportFunctionPart2.XML";
	public static String pathFunctionPart3_V999MV1 = 			mainPathValve + "Import\\ImportFunctionPart3.XML";

	public static String pathScreenPart1_V999MV1 = 				mainPathValve + "Import\\ImportScreenPart1.XML";
	public static String pathScreenPart2_V999MV1 = 				mainPathValve + "Import\\ImportScreenPart2.XML";
	public static String pathScreenPart3_V999MV1 = 				mainPathValve + "Import\\ImportScreenPart3.XML";
	

	//***************
	//
	// Motor Paths
	//
	//***************

	public static String mainPathMotor = 						mainPath 	  + "M999CM1 - Motor\\";
	public static String outputPathMotorDOL = 					mainPathMotor + "Generator\\DOL\\LINE_" + LineName + "\\";
	public static String outputPathMotorVFD = 					mainPathMotor + "Generator\\VFD\\LINE_" + LineName + "\\";	
	
	public static String sourcePathMotorDOL = 					mainPathMotor + "Source " + LineName + " - MotorDOL.txt";
	public static String sourcePathMotorVFD = 					mainPathMotor + "Source " + LineName + " - MotorVFD.txt";

	//Oryginal Export Files From ZENON
	public static String pathCMD_M999CM1 = 						mainPathMotor + "Oryginal\\Variable\\CMD_M999CM1.XML";
	public static String pathCONFIG_M999CM1 = 					mainPathMotor + "Oryginal\\Variable\\CONFIG_M999CM1.XML";
	public static String pathSTAT_M999CM1 = 					mainPathMotor + "Oryginal\\Variable\\STAT_M999CM1.XML";
	//VFD A999MW1
	public static String pathCMD_A999MW1_SIC = 					mainPathMotor + "Oryginal\\Variable\\CMD_ A999WM1_SIC.XML";
	public static String pathCONFIG_A999WM1_SIC = 				mainPathMotor + "Oryginal\\Variable\\CONFIG_A999WM1_SIC.XML";
	public static String pathSTAT_A999WM1_SIC = 				mainPathMotor + "Oryginal\\Variable\\STAT_A999WM1_SIC.XML";	
	public static String pathOP_HOURS_M999CM1 = 				mainPathMotor + "Oryginal\\Variable\\OP_HOURS_M999CM1.XML";
	
	public static String pathPUP_M999CM1_MOT = 					mainPathMotor + "Oryginal\\Screen\\PUP_M999CM1_MOT.XML";
	public static String pathPUP_A999MW1_SIC = 					mainPathMotor + "Oryginal\\Screen\\PUP_A999MW1_SIC.XML";
	
	public static String pathSHOW_PUP_M999CM1_MOT = 			mainPathMotor + "Oryginal\\Function\\SHOW_PUP_M999CM1_MOT.XML";
	public static String pathSHOW_PUP_A999MW1_SIC = 			mainPathMotor + "Oryginal\\Function\\SHOW_PUP_A999MW1_SIC.XML";


	//Variables From Standard Block(Seperated from Oryginal)
	public static String pathVariableCMD_M999CM1 = 				mainPathMotor + "Import\\Variable_M999CM1_CMD.XML";
	public static String pathVariableSTAT_M999CM1 = 			mainPathMotor + "Import\\Variable_M999CM1_STAT.XML";
	public static String pathVariableCONFIG_M999CM1 = 			mainPathMotor + "Import\\Variable_M999CM1_CONFIG.XML";
	public static String pathVariableOP_HOURS_M999CM1 = 		mainPathMotor + "Import\\Variable_M999CM1_OP_HOURS.XML";	
	//VFD A999MW1
	public static String pathVariableCMD_A999MW1_SIC = 			mainPathMotor + "Import\\Variable_A999MW1_CMD_SIC.XML";
	public static String pathVariableCONFIG_A999MW1_SIC = 		mainPathMotor + "Import\\Variable_A999MW1_CONFIG_SIC.XML";
	public static String pathVariableSTAT_A999MW1_SIC = 		mainPathMotor + "Import\\Variable_A999MW1_STAT_SIC.XML";
	
	//Files prepared to create one import file Part1(Static) + Part2(Generated) + Part3(Static)
	public static String pathVariablePart1_M999CM1 = 			mainPathMotor + "Import\\ImportVariablePart1.XML";
	public static String pathVariablePart2_M999CM1_DOL = 		mainPathMotor + "Import\\ImportVariablePart2_DOL.XML";
	public static String pathVariablePart2_M999CM1_VFD = 		mainPathMotor + "Import\\ImportVariablePart2_VFD.XML";
	public static String pathVariablePart3_M999CM1 = 			mainPathMotor + "Import\\ImportVariablePart3.XML";

	public static String pathFunctionPart1_M999CM1 = 			mainPathMotor + "Import\\ImportFunctionPart1.XML";
	public static String pathFunctionPart2_M999CM1 = 			mainPathMotor + "Import\\ImportFunctionPart2_M999CM1.XML";
	public static String pathFunctionPart2_A999MW1_SIC = 		mainPathMotor + "Import\\ImportFunctionPart2_A999MW1_SIC.XML";
	public static String pathFunctionPart3_M999CM1 = 			mainPathMotor + "Import\\ImportFunctionPart3.XML";

	public static String pathScreenPart1_M999CM1 = 				mainPathMotor + "Import\\ImportScreenPart1.XML";
	public static String pathScreenPart2_A999MW1_SIC = 	    	mainPathMotor + "Import\\ImportScreenPart2_A999MW1_SIC.XML";
	public static String pathScreenPart2_M999CM1 = 				mainPathMotor + "Import\\ImportScreenPart2_M999CM1.XML";
	public static String pathScreenPart3_M999CM1 = 				mainPathMotor + "Import\\ImportScreenPart3.XML";
	

	//***************
	//
	// PID Paths
	//
	//***************

	public static String mainPathPID = 							mainPath + 		"C999TIC - PID\\";
	//public static String outputPathPID = 					    mainPathPID +  	"Generator\\";
	//public static String outputPathPID = 						mainPath +  	"C999TIC - PID\\Generator\\Line A\\";
	//public static String outputPathPID = 						mainPath +  	"C999TIC - PID\\Generator\\Line B\\";
	public static String outputPathPID = 						mainPath +  	"C999TIC - PID\\Generator\\Line C\\";
	
	//public static String sourcePathPID = 						mainPathPID + "Source - PID.txt";
	//public static String sourcePathPID = 						mainPathPID + "Source A - PID.txt";
	//public static String sourcePathPID = 						mainPathPID + "Source B - PID.txt";
	public static String sourcePathPID = 						mainPathPID + "Source C - PID.txt";

	public static String pathCMD_C999TIC = 						mainPathPID + "Oryginal\\Variable\\CMD_C999TIC.XML";
	public static String pathSTAT_C999TIC = 					mainPathPID + "Oryginal\\Variable\\STAT_C999TIC.XML";
	public static String pathCONFIG_C999TIC = 					mainPathPID + "Oryginal\\Variable\\CONFIG_C999TIC.XML";
	
	
	public static String pathVariableCMD_C999TIC = 				mainPathPID + "Import\\Variable_CMD_C999TIC.XML";
	public static String pathVariableSTAT_C999TIC = 			mainPathPID + "Import\\Variable_STAT_C999TIC.XML";
	public static String pathVariableCONFIG_C999TIC = 			mainPathPID + "Import\\Variable_CONFIG_C999TIC.XML";
	
	public static String pathVariablePart1_C999TIC = 			mainPathPID + "Import\\ImportVariablePart1.XML";
	public static String pathVariablePart2_C999TIC = 			mainPathPID + "Import\\ImportVariablePart2.XML";
	public static String pathVariablePart3_C999TIC = 			mainPathPID + "Import\\ImportVariablePart3.XML";


	
	


}
