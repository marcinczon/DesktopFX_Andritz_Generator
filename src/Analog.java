
public class Analog
{
	static int IdComplex = 90000;
	
	String pathVariableCMD_A999MW1 = "C:\\Users\\mczonstke\\Desktop\\Wizu\\Changed\\Import\\Base\\A999MW1 - Binary\\Variable_CMD_A999MW1.XML";
	String pathVariableCONFIG_A999MW1 = "C:\\Users\\mczonstke\\Desktop\\Wizu\\Changed\\Import\\Base\\A999MW1 - Binary\\Variable_CONFIG_A999MW1.XML";
	String pathVariableSTAT_A999MW1 = "C:\\Users\\mczonstke\\Desktop\\Wizu\\Changed\\Import\\Base\\A999MW1 - Binary\\Variable_STAT_A999MW1.XML";

	String pathFunctionPart1_A999MW1 = "C:\\Users\\mczonstke\\Desktop\\Wizu\\Changed\\Import\\Base\\A999MW1 - Binary\\ImportFunctionPart1.XML";
	String pathFunctionPart2_A999MW1 = "C:\\Users\\mczonstke\\Desktop\\Wizu\\Changed\\Import\\Base\\A999MW1 - Binary\\ImportFunctionPart2.XML";
	String pathFunctionPart3_A999MW1 = "C:\\Users\\mczonstke\\Desktop\\Wizu\\Changed\\Import\\Base\\A999MW1 - Binary\\ImportFunctionPart3.XML";

	String pathScreenPart1_A999MW1 = "C:\\Users\\mczonstke\\Desktop\\Wizu\\Changed\\Import\\Base\\A999MW1 - Binary\\ImportScreenPart1.XML";
	String pathScreenPart2_A999MW1 = "C:\\Users\\mczonstke\\Desktop\\Wizu\\Changed\\Import\\Base\\A999MW1 - Binary\\ImportScreenPart2.XML";
	String pathScreenPart3_A999MW1 = "C:\\Users\\mczonstke\\Desktop\\Wizu\\Changed\\Import\\Base\\A999MW1 - Binary\\ImportScreenPart3.XML";
	
	
	static StringBuilder stringBulder = new StringBuilder();
	static StringBuilder stringBuilderVariables = new StringBuilder();
	static StringBuilder stringBuilderFunctions = new StringBuilder();
	static StringBuilder stringBuilderScreen = new StringBuilder();
	
	public Analog()
	{
		// *********************************************+
		//
		// Odczyt z plikow zrodel
		//
		// *********************************************+

		// Zrodla z calego pliku oryginalnego
		String sourceCMD_B999GS1 = readFile(pathCMD_B999GS1);
		String sourceCONFIG_B999GS1 = readFile(pathCONFIG_B999GS1);
		String sourceSTAT_B999GS1 = readFile(pathSTAT_B999GS1);
		String sourcePUP_B999GS1_BIN = readFile(pathPUP_B999GS1_BIN);
		String sourceSHOW_PUP_B999GS1_BIN = readFile(pathSHOW_PUP_B999GS1_BIN);

		// Zrodla tylko dla zmiennych
		String sourceVariableCMD_B999GS1 = readFile(pathVariableCMD_B999GS1);
		String sourceVariableCONFIG_B999GS1 = readFile(pathVariableCONFIG_B999GS1);
		String sourceVariableSTAT_B999GS1 = readFile(pathVariableSTAT_B999GS1);

		// Zrodlo tylko dla funkcji
		String sourceFunctionPart1_B999GS1 = readFile(pathFunctionPart1_B999GS1);
		String sourceFunctionPart2_B999GS1 = readFile(pathFunctionPart2_B999GS1);
		String sourceFunctionPart3_B999GS1 = readFile(pathFunctionPart3_B999GS1);

		// Zrodlo tylko dla Ekranu
		String sourceScreenPart1_B999GS1 = readFile(pathScreenPart1_B999GS1);
		String sourceScreenPart2_B999GS1 = readFile(pathScreenPart2_B999GS1);
		String sourceScreenPart3_B999GS1 = readFile(pathScreenPart3_B999GS1);
		
	}
	
	private static String praseString_A999MW1(String source, String[] parameters, int offsetParameter)
	{
		String newSource_A999MW1 = new String(source);
		String name = parameters[0];
		String tagName = parameters[1] + "  " + parameters[2] + "  " + parameters[3];
		String offSet = parameters[offsetParameter].replaceAll("\\D+", "");
		String netAdress = parameters[7];

		newSource_A999MW1 = newSource_A999MW1.replaceAll("A999MW1", name);
		newSource_A999MW1 = newSource_A999MW1.replaceAll("<ID_Complex>.*.</ID_Complex>", "<ID_Complex>" + IdComplex + "</ID_Complex>");
		newSource_A999MW1 = newSource_A999MW1.replaceAll("<ID_ComplexVariable>.*.</ID_ComplexVariable>", "<ID_ComplexVariable>" + IdComplex + "</ID_ComplexVariable>");
		newSource_A999MW1 = newSource_A999MW1.replaceAll("<Tagname />", "<Tagname>" + tagName + "</Tagname>");
		newSource_A999MW1 = newSource_A999MW1.replaceAll("<Offset>0</Offset>", "<Offset>" + offSet + "</Offset>");
		newSource_A999MW1 = newSource_A999MW1.replaceAll("<NetAddr>1</NetAddr>", "<NetAddr>" + netAdress + "</NetAddr>");

		IdComplex++;
		stringBulder.append(newSource_A999MW1);

		return newSource_A999MW1;
	}

	private static String praseStringPUP_A999MW1(String source, String[] parameters)
	{
		String newSource_A999MW1 = new String(source);
		String name = parameters[0];

		newSource_A999MW1 = newSource_A999MW1.replaceAll("A999MW1", name);
		newSource_A999MW1 = newSource_A999MW1.replaceAll("\\*" + name + "\\*", "*A999MW1*");

		return newSource_A999MW1;
	}

	private static String praseStringSHOW_PUP_A999MW1(String source, String[] parameters)
	{
		String newSource_A999MW1 = new String(source);
		String name = parameters[0];

		newSource_A999MW1 = newSource_A999MW1.replaceAll("A999MW1", name);
		newSource_A999MW1 = newSource_A999MW1.replaceAll("@TEMPOERARY OVERVIEW", "@PUP_" + name + "_BIN");

		return newSource_A999MW1;
	}


}
