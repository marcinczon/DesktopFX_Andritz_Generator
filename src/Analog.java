import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Analog
{
	
	//*******************
	//
	// Nie dodaje parametru <No screan> (Standard)
	//
	//*******************
	static int IdComplex = 90000;
	
	ArrayList<String> bufferArrayList = new ArrayList<>();

	static StringBuilder stringBulder = new StringBuilder();
	static StringBuilder stringBuilderVariables = new StringBuilder();
	static StringBuilder stringBuilderFunctions = new StringBuilder();
	static StringBuilder stringBuilderScreen = new StringBuilder();
	
	// Zrodla z calego pliku oryginalnego
	String sourceCMD_A999MW1;
	String sourceCONFIG_A999MW1;
	String sourceSTAT_A999MW1;
	String sourcePUP_A999MW1_BIN;
	String sourceSHOW_PUP_A999MW1_BIN;

	// Zrodla tylko dla zmiennych
	String sourceVariableCMD_A999MW1;
	String sourceVariableCONFIG_A999MW1;
	String sourceVariableSTAT_A999MW1;
	
	String sourceVariablePart1_A999MW1;
	String sourceVariablePart2_A999MW1;
	String sourceVariablePart3_A999MW1;

	// Zrodlo tylko dla funkcji
	String sourceFunctionPart1_A999MW1;
	String sourceFunctionPart2_A999MW1;
	String sourceFunctionPart3_A999MW1;

	// Zrodlo tylko dla Ekranu
	String sourceScreenPart1_A999MW1;
	String sourceScreenPart2_A999MW1;
	String sourceScreenPart3_A999MW1;
	


	public Analog()
	{
		// *********************************************+
		//
		// Odczyt z plikow zrodel
		//
		// *********************************************+

		// Zrodla z calego pliku oryginalnego
		 sourceCMD_A999MW1 = ReadWrite.readFile(Paths.pathCMD_A999MW1);
		 sourceCONFIG_A999MW1 = ReadWrite.readFile(Paths.pathCONFIG_A999MW1);
		 sourceSTAT_A999MW1 = ReadWrite.readFile(Paths.pathSTAT_A999MW1);
		 sourcePUP_A999MW1_BIN = ReadWrite.readFile(Paths.pathPUP_A999MW1_ANALOG);
		 sourceSHOW_PUP_A999MW1_BIN = ReadWrite.readFile(Paths.pathSHOW_PUP_A999MW1_ANALOG);

		// Zrodla tylko dla zmiennych
		 sourceVariableCMD_A999MW1 = ReadWrite.readFile(Paths.pathVariableCMD_A999MW1);
		 sourceVariableCONFIG_A999MW1 = ReadWrite.readFile(Paths.pathVariableCONFIG_A999MW1);
		 sourceVariableSTAT_A999MW1 = ReadWrite.readFile(Paths.pathVariableSTAT_A999MW1);

		// Zrodlo tylko dla zmiennych
		 sourceVariablePart1_A999MW1 = ReadWrite.readFile(Paths.pathVariablePart1_A999MW1);
		 sourceVariablePart2_A999MW1 = ReadWrite.readFile(Paths.pathVariablePart2_A999MW1);
		 sourceVariablePart3_A999MW1 = ReadWrite.readFile(Paths.pathVariablePart3_A999MW1);
		 
		// Zrodlo tylko dla funkcji
		 sourceFunctionPart1_A999MW1 = ReadWrite.readFile(Paths.pathFunctionPart1_A999MW1);
		 sourceFunctionPart2_A999MW1 = ReadWrite.readFile(Paths.pathFunctionPart2_A999MW1);
		 sourceFunctionPart3_A999MW1 = ReadWrite.readFile(Paths.pathFunctionPart3_A999MW1);

		// Zrodlo tylko dla Ekranu
		 sourceScreenPart1_A999MW1 = ReadWrite.readFile(Paths.pathScreenPart1_A999MW1);
		 sourceScreenPart2_A999MW1 = ReadWrite.readFile(Paths.pathScreenPart2_A999MW1);
		 sourceScreenPart3_A999MW1 = ReadWrite.readFile(Paths.pathScreenPart3_A999MW1);

	}
	
	public void CreateOutputsFiles() throws FileNotFoundException, IOException
	{

		// *********************************************+
		//
		// Odczyt i przygotowanie zmiennych z pliku
		//
		// *********************************************

		try (BufferedReader bufferReader = new BufferedReader(new FileReader(Paths.sourcePathAnalog)))
		{
			String line;
			while ((line = bufferReader.readLine()) != null)
			{
				bufferArrayList.add(line);
			}
		}

		// *********************************************
		// Odczyt urzadzen i zmiennych z listy i dodanie ich do arraylist
		//
		// [ArrayList] [Tab 1] [Tab 2] [Tab 3] [...]
		// [Urzadzenie 1][Zmienna 1][Zmienna 2][Zmienna 3][...]
		// [Urzadzenie 2][Zmienna 1][Zmienna 2][Zmienna 3][...]
		// [Urzadzenie 3][Zmienna 1][Zmienna 2][Zmienna 3][...]
		//
		// *********************************************

		ArrayList<String[]> devicesArrayList = new ArrayList<>();
		for (String deviceString : bufferArrayList)
		{
			String[] deviceTable = deviceString.split("	");
			devicesArrayList.add(deviceTable);

		}

		// *********************************************
		// Utworzenie wielu osobnych plikow do importu
		// oraz przygotowanie pliku buffora zmiennych do
		// jednego pliku
		// *********************************************

		for (String[] strings : devicesArrayList)
		{
			// Utworzenie folderu dla urzadzenia
			System.out.print(strings[0] + "\n");
			ReadWrite.createFolder(Paths.outputPathAnalog + strings[0]);

			// Utworzenie Variables
			ReadWrite.createFileAndFill(Paths.outputPathAnalog + strings[0] + "\\", "CMD_" + strings[0] + ".XML", praseString_A999MW1(sourceCMD_A999MW1, strings, 4), 0);
			stringBuilderVariables.append(praseString_A999MW1(sourceVariableCMD_A999MW1, strings, 4));
														      

			ReadWrite.createFileAndFill(Paths.outputPathAnalog + strings[0] + "\\", "CONFIG_" + strings[0] + ".XML", praseString_A999MW1(sourceCONFIG_A999MW1, strings, 5), 0);
			stringBuilderVariables.append(praseString_A999MW1(sourceVariableCONFIG_A999MW1, strings, 5));

			ReadWrite.createFileAndFill(Paths.outputPathAnalog + strings[0] + "\\", "STAT_" + strings[0] + ".XML", praseString_A999MW1(sourceSTAT_A999MW1, strings, 6), 0);
			stringBuilderVariables.append(praseString_A999MW1(sourceVariableSTAT_A999MW1, strings, 6));

			// Utworzenie Ekranow
			ReadWrite.createFileAndFill(Paths.outputPathAnalog + strings[0] + "\\", "PUP_" + strings[0] + "_BIN" + ".XML", praseStringPUP_A999MW1(sourcePUP_A999MW1_BIN, strings), 0);
			stringBuilderScreen.append(praseStringPUP_A999MW1(sourceScreenPart2_A999MW1, strings));

			// Utworzenie Funkcji
			ReadWrite.createFileAndFill(Paths.outputPathAnalog + strings[0] + "\\", "SHOW_PUP_" + strings[0] + "_BIN" + ".XML", praseStringSHOW_PUP_A999MW1(sourceSHOW_PUP_A999MW1_BIN, strings), 0);
			stringBuilderFunctions.append(praseStringSHOW_PUP_A999MW1(sourceFunctionPart2_A999MW1, strings));
		}

		//ReadWrite.createFileAndFill(Paths.outputPathAnalog, "ImportAnalogVariables.XML", stringBuilderVariables.toString(), 1);

		// *********************************************
		//
		// Utworzenie jednego pliku do imporu zmiennych
		//
		// Plik sklada sie z trzech czesci
		// [Part1] + [Variable] + [Part2]
		// [Part 1] - Naglowek - Staly element
		// [Variable] - Zmienne utworzone przez program
		// [Part 2] - Typy importowanych danych - staly element dla danego urzadzenia
		//
		// Pamietac o konwersji
		// Odczytany plik musi byc kodowany na ANSI
		// Zapisany plik do importu kodowany USC2 - LE
		//
		// *********************************************

		
		ReadWrite.createFileAndFill(Paths.outputPathAnalog, "ImportAnalogVariable.XML", sourceVariablePart1_A999MW1 + stringBuilderVariables + sourceVariablePart3_A999MW1, 0);
		ReadWrite.createFileAndFill(Paths.outputPathAnalog, "ImportFunction.XML", sourceFunctionPart1_A999MW1 + stringBuilderFunctions + sourceFunctionPart3_A999MW1, 0);
		ReadWrite.createFileAndFill(Paths.outputPathAnalog, "ImportScreen.XML", sourceScreenPart1_A999MW1 + stringBuilderScreen + sourceScreenPart3_A999MW1, 0);

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
