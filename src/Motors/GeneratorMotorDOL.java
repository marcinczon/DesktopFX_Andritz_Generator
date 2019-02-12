package Motors;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Utils.Paths;
import Utils.ReadWrite;

public class GeneratorMotorDOL
{

	//*******************
	//
	// Nie dodaje parametru <No screan> (Standard)
	//
	//*******************
	
	static int IdComplex = 94000;
	
	ArrayList<String> bufferArrayList = new ArrayList<>();

	static StringBuilder stringBulder 			= new StringBuilder();
	static StringBuilder stringBuilderVariables = new StringBuilder();
	static StringBuilder stringBuilderFunctions = new StringBuilder();
	static StringBuilder stringBuilderScreen 	= new StringBuilder();
	
	// Zrodla z calego pliku oryginalnego
	String sourceCMD_M999CM1;
	String sourceCONFIG_M999CM1;
	String sourceSTAT_M999CM1;
	String sourceOP_HOURS_M999CM1;
	String sourcePUP_M999CM1_MOT;
	String sourceSHOW_PUP_M999CM1_MOT;

	// Zrodla tylko dla zmiennych
	String sourceVariableCMD_M999CM1;
	String sourceVariableCONFIG_M999CM1;
	String sourceVariableSTAT_M999CM1;
	String sourceVariableOP_HOURS_M999CM1;

	String sourceVariablePart1_M999CM1;
	String sourceVariablePart2_M999CM1;
	String sourceVariablePart3_M999CM1;

	// Zrodlo tylko dla funkcji
	String sourceFunctionPart1_M999CM1;
	String sourceFunctionPart2_M999CM1;
	String sourceFunctionPart3_M999CM1;

	// Zrodlo tylko dla Ekranu
	String sourceScreenPart1_M999CM1;
	String sourceScreenPart2_M999CM1;
	String sourceScreenPart3_M999CM1;
	


	public GeneratorMotorDOL()
	{
		System.out.println("Generator Motor DOL");
		
		// *********************************************+
		//
		// Odczyt z plikow zrodel
		//
		// *********************************************+

		// Zrodla z calego pliku oryginalnego
		 sourceCMD_M999CM1 = ReadWrite.readFile(Paths.pathCMD_M999CM1);
		 sourceCONFIG_M999CM1 = ReadWrite.readFile(Paths.pathCONFIG_M999CM1);
		 sourceSTAT_M999CM1 = ReadWrite.readFile(Paths.pathSTAT_M999CM1);
		 sourceOP_HOURS_M999CM1 = ReadWrite.readFile(Paths.pathOP_HOURS_M999CM1);
		 sourcePUP_M999CM1_MOT = ReadWrite.readFile(Paths.pathPUP_M999CM1_MOT);
		 sourceSHOW_PUP_M999CM1_MOT = ReadWrite.readFile(Paths.pathSHOW_PUP_M999CM1_MOT);
		 
			// Zrodla tylko dla zmiennych
		 sourceVariableCMD_M999CM1 = ReadWrite.readFile(Paths.pathVariableCMD_M999CM1);
		 sourceVariableCONFIG_M999CM1 = ReadWrite.readFile(Paths.pathVariableCONFIG_M999CM1);
		 sourceVariableSTAT_M999CM1 = ReadWrite.readFile(Paths.pathVariableSTAT_M999CM1);
		 sourceVariableOP_HOURS_M999CM1 = ReadWrite.readFile(Paths.pathVariableOP_HOURS_M999CM1);

		
		// Zrodlo tylko dla zmiennych
		 sourceVariablePart1_M999CM1 = ReadWrite.readFile(Paths.pathVariablePart1_M999CM1);
		 sourceVariablePart2_M999CM1 = ReadWrite.readFile(Paths.pathVariablePart2_M999CM1_DOL);
		 sourceVariablePart3_M999CM1 = ReadWrite.readFile(Paths.pathVariablePart3_M999CM1);
		 
		// Zrodlo tylko dla funkcji
		 sourceFunctionPart1_M999CM1 = ReadWrite.readFile(Paths.pathFunctionPart1_M999CM1);
		 sourceFunctionPart2_M999CM1 = ReadWrite.readFile(Paths.pathFunctionPart2_M999CM1);
		 sourceFunctionPart3_M999CM1 = ReadWrite.readFile(Paths.pathFunctionPart3_M999CM1);

		// Zrodlo tylko dla Ekranu
		 sourceScreenPart1_M999CM1 = ReadWrite.readFile(Paths.pathScreenPart1_M999CM1);
		 sourceScreenPart2_M999CM1 = ReadWrite.readFile(Paths.pathScreenPart2_M999CM1);
		 sourceScreenPart3_M999CM1 = ReadWrite.readFile(Paths.pathScreenPart3_M999CM1);

	}
	
	public void CreateOutputsFiles() throws FileNotFoundException, IOException
	{

		// *********************************************+
		//
		// Odczyt i przygotowanie zmiennych z pliku
		//
		// *********************************************

		try (BufferedReader bufferReader = new BufferedReader(new FileReader(Paths.sourcePathMotorDOL)))
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
			String name = strings[0];
			
			// Utworzenie folderu dla urzadzenia
			System.out.print(name + "\n");
			ReadWrite.createFolder(Paths.outputPathMotorDOL + name);

			// Utworzenie Variables
			ReadWrite.createFileAndFill(Paths.outputPathMotorDOL + name + "\\", "CMD_" + name + ".XML", praseString_M999CM1(sourceCMD_M999CM1, strings, 4), 0);
			stringBuilderVariables.append(praseString_M999CM1(sourceVariableCMD_M999CM1, strings, 4));
														      
			ReadWrite.createFileAndFill(Paths.outputPathMotorDOL + name + "\\", "CONFIG_" + name + ".XML", praseString_M999CM1(sourceCONFIG_M999CM1, strings, 5), 0);
			stringBuilderVariables.append(praseString_M999CM1(sourceVariableCONFIG_M999CM1, strings, 5));

			ReadWrite.createFileAndFill(Paths.outputPathMotorDOL + name + "\\", "STAT_" + name + ".XML", praseString_M999CM1(sourceSTAT_M999CM1, strings, 6), 0);
			stringBuilderVariables.append(praseString_M999CM1(sourceVariableSTAT_M999CM1, strings, 6));

			ReadWrite.createFileAndFill(Paths.outputPathMotorDOL + name + "\\", "OP_HOURS_" + strings[7] + ".XML", praseString_M999CM1(sourceOP_HOURS_M999CM1, strings, 7), 0);
			stringBuilderVariables.append(praseString_M999CM1(sourceVariableOP_HOURS_M999CM1, strings, 7));
			
			// Utworzenie Ekranow
			ReadWrite.createFileAndFill(Paths.outputPathMotorDOL + name + "\\", "PUP_" + name + "_BIN" + ".XML", praseStringPUP_M999CM1(sourcePUP_M999CM1_MOT, strings), 0);
			stringBuilderScreen.append(praseStringPUP_M999CM1(sourceScreenPart2_M999CM1, strings));

			// Utworzenie Funkcji
			ReadWrite.createFileAndFill(Paths.outputPathMotorDOL + name + "\\", "SHOW_PUP_" + name + "_BIN" + ".XML", praseStringSHOW_PUP_M999CM1(sourceSHOW_PUP_M999CM1_MOT, strings), 0);
			stringBuilderFunctions.append(praseStringSHOW_PUP_M999CM1(sourceFunctionPart2_M999CM1, strings));
		}

		//ReadWrite.createFileAndFill(Paths.outputPathMOTOR, "ImportMOTORVariables.XML", stringBuilderVariables.toString(), 1);

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

		
		ReadWrite.createFileAndFill(Paths.outputPathMotorDOL, "ImportVariable.XML", sourceVariablePart1_M999CM1 + stringBuilderVariables + sourceVariablePart3_M999CM1, 0);
		ReadWrite.createFileAndFill(Paths.outputPathMotorDOL, "ImportFunction.XML", sourceFunctionPart1_M999CM1 + stringBuilderFunctions + sourceFunctionPart3_M999CM1, 0);
		ReadWrite.createFileAndFill(Paths.outputPathMotorDOL, "ImportScreen.XML", sourceScreenPart1_M999CM1 + stringBuilderScreen + sourceScreenPart3_M999CM1, 0);

	}

	private static String praseString_M999CM1(String source, String[] parameters, int offsetParameter)
	{
		String newSource_M999CM1 	= new String(source);
		String name 				= parameters[0];
		String description 			= parameters[1] + "  " + parameters[2] + "  " + parameters[3];
		String offSet 				= parameters[offsetParameter].replaceAll("\\D+", "");
		String netAdress 			= parameters[8];

		newSource_M999CM1 = newSource_M999CM1.replaceAll("M999CM1", name);
		newSource_M999CM1 = newSource_M999CM1.replaceAll("<ID_Complex>.*.</ID_Complex>", "<ID_Complex>" + IdComplex++ + "</ID_Complex>");
		newSource_M999CM1 = newSource_M999CM1.replaceAll("<ID_ComplexVariable>.*.</ID_ComplexVariable>", "<ID_ComplexVariable>" + IdComplex++ + "</ID_ComplexVariable>");
		newSource_M999CM1 = newSource_M999CM1.replaceAll("<Tagname />", "<Tagname>" + description + "</Tagname>");
		newSource_M999CM1 = newSource_M999CM1.replaceAll("<Offset>0</Offset>", "<Offset>" + offSet + "</Offset>");
		newSource_M999CM1 = newSource_M999CM1.replaceAll("<NetAddr>1</NetAddr>", "<NetAddr>" + netAdress + "</NetAddr>");
		newSource_M999CM1 = newSource_M999CM1.replaceAll("Identification", "@"+name + " - " + description);
		
		
		stringBulder.append(newSource_M999CM1);

		return newSource_M999CM1;
	}

	private static String praseStringPUP_M999CM1(String source, String[] parameters)
	{
		String newSource_M999CM1 = new String(source);
		String name = parameters[0];

		newSource_M999CM1 = newSource_M999CM1.replaceAll("M999CM1", name);
		newSource_M999CM1 = newSource_M999CM1.replaceAll("<SubstituteSource />", "<SubstituteSource>*M999CM1*</SubstituteSource>");
		newSource_M999CM1 = newSource_M999CM1.replaceAll("\\*" + name + "\\*", "*M999CM1*");

		return newSource_M999CM1;
	}

	private static String praseStringSHOW_PUP_M999CM1(String source, String[] parameters)
	{
		String newSource_M999CM1 = new String(source);
		String name = parameters[0];

		
		newSource_M999CM1 = newSource_M999CM1.replaceAll("M999CM1", name);
		newSource_M999CM1 = newSource_M999CM1.replaceAll("@TEMPOERARY OVERVIEW", "@PUP_" + name + "_MOTOR");

		return newSource_M999CM1;
	}
}
