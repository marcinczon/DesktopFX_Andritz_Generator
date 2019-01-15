
public class Analog
{
	static int IdComplex = 90000;

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
		String sourceCMD_A999MW1 = ReadWrite.readFile(Paths.pathCMD_A999MW1);
		String sourceCONFIG_A999MW1 = ReadWrite.readFile(Paths.pathCONFIG_A999MW1);
		String sourceSTAT_A999MW1 = ReadWrite.readFile(Paths.pathSTAT_A999MW1);
		String sourcePUP_A999MW1_BIN = ReadWrite.readFile(Paths.pathPUP_A999MW1_ANALOG);
		String sourceSHOW_PUP_A999MW1_BIN = ReadWrite.readFile(Paths.pathSHOW_PUP_A999MW1_ANALOG);

		// Zrodla tylko dla zmiennych
		String sourceVariableCMD_A999MW1 = ReadWrite.readFile(Paths.pathVariableCMD_A999MW1);
		String sourceVariableCONFIG_A999MW1 = ReadWrite.readFile(Paths.pathVariableCONFIG_A999MW1);
		String sourceVariableSTAT_A999MW1 = ReadWrite.readFile(Paths.pathVariableSTAT_A999MW1);

		// Zrodlo tylko dla funkcji
		String sourceFunctionPart1_A999MW1 = ReadWrite.readFile(Paths.pathFunctionPart1_A999MW1);
		String sourceFunctionPart2_A999MW1 = ReadWrite.readFile(Paths.pathFunctionPart2_A999MW1);
		String sourceFunctionPart3_A999MW1 = ReadWrite.readFile(Paths.pathFunctionPart3_A999MW1);

		// Zrodlo tylko dla Ekranu
		String sourceScreenPart1_A999MW1 = ReadWrite.readFile(Paths.pathScreenPart1_A999MW1);
		String sourceScreenPart2_A999MW1 = ReadWrite.readFile(Paths.pathScreenPart2_A999MW1);
		String sourceScreenPart3_A999MW1 = ReadWrite.readFile(Paths.pathScreenPart3_A999MW1);

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
		//@PUP_A999MW1_ANALOG
		newSource_A999MW1 = newSource_A999MW1.replaceAll("@TEMPOERARY OVERVIEW", "@PUP_" + name + "_ANALOG");

		return newSource_A999MW1;
	}

}
