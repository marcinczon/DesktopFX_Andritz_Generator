package Valve;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Utils.Paths;
import Utils.ReadWrite;
import Utils.Settings;

public class GeneratorValves
{
	
	//*******************
	//
	// Nie dodaje parametru <No screan> (Standard)
	//
	//*******************
	

    public static int IdComplex = 94000;
    
	ArrayList<String> bufferArrayList = new ArrayList<>();

	static StringBuilder stringBulder 			= new StringBuilder();
	static StringBuilder stringBuilderVariables = new StringBuilder();
	static StringBuilder stringBuilderFunctions = new StringBuilder();
	static StringBuilder stringBuilderScreen 	= new StringBuilder();
	
	// Zrodla z calego pliku oryginalnego
	String sourceCMD_V999MV1;
	String sourceSTAT_V999MV1;
	String sourcePUP_V999MV1_BIN;
	String sourceSHOW_PUP_V999MV1_BIN;

	// Zrodla tylko dla zmiennych
	String sourceVariableCMD_V999MV1;
	String sourceVariableSTAT_V999MV1;
	
	String sourceVariablePart1_V999MV1;
	String sourceVariablePart2_V999MV1;
	String sourceVariablePart3_V999MV1;

	// Zrodlo tylko dla funkcji
	String sourceFunctionPart1_V999MV1;
	String sourceFunctionPart2_V999MV1;
	String sourceFunctionPart3_V999MV1;

	// Zrodlo tylko dla Ekranu
	String sourceScreenPart1_V999MV1;
	String sourceScreenPart2_V999MV1;
	String sourceScreenPart3_V999MV1;
	


	public GeneratorValves()
	{
		
		// *********************************************+
		//
		// Odczyt z plikow zrodel
		//
		// *********************************************+

		// Zrodla z calego pliku oryginalnego
		 sourceCMD_V999MV1 			= ReadWrite.readFile(Paths.pathCMD_V999MV1);
		 sourceSTAT_V999MV1 		= ReadWrite.readFile(Paths.pathSTAT_V999MV1);
		 sourcePUP_V999MV1_BIN 		= ReadWrite.readFile(Paths.pathPUP_V999MV1_VAL);
		 sourceSHOW_PUP_V999MV1_BIN = ReadWrite.readFile(Paths.pathSHOW_PUP_V999MV1_VAL);

		// Zrodla tylko dla zmiennych
		 sourceVariableCMD_V999MV1 	= ReadWrite.readFile(Paths.pathVariableCMD_V999MV1);
		 sourceVariableSTAT_V999MV1 = ReadWrite.readFile(Paths.pathVariableSTAT_V999MV1);

		// Zrodlo tylko dla zmiennych
		 sourceVariablePart1_V999MV1 = ReadWrite.readFile(Paths.pathVariablePart1_V999MV1);
		 sourceVariablePart2_V999MV1 = ReadWrite.readFile(Paths.pathVariablePart2_V999MV1);
		 sourceVariablePart3_V999MV1 = ReadWrite.readFile(Paths.pathVariablePart3_V999MV1);
		 
		// Zrodlo tylko dla funkcji
		 sourceFunctionPart1_V999MV1 = ReadWrite.readFile(Paths.pathFunctionPart1_V999MV1);
		 sourceFunctionPart2_V999MV1 = ReadWrite.readFile(Paths.pathFunctionPart2_V999MV1);
		 sourceFunctionPart3_V999MV1 = ReadWrite.readFile(Paths.pathFunctionPart3_V999MV1);

		// Zrodlo tylko dla Ekranu
		 sourceScreenPart1_V999MV1 = ReadWrite.readFile(Paths.pathScreenPart1_V999MV1);
		 sourceScreenPart2_V999MV1 = ReadWrite.readFile(Paths.pathScreenPart2_V999MV1);
		 sourceScreenPart3_V999MV1 = ReadWrite.readFile(Paths.pathScreenPart3_V999MV1);

	}
	
	public void CreateOutputsFiles() throws FileNotFoundException, IOException
	{

		// *********************************************+
		//
		// Odczyt i przygotowanie zmiennych z pliku
		//
		// *********************************************

		try (BufferedReader bufferReader = new BufferedReader(new FileReader(Paths.sourcePathValve)))
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

		for (String[] variableParameters : devicesArrayList)
		{
			String VariableName = variableParameters[0];
			
			// Utworzenie folderu dla urzadzenia
			System.out.print(VariableName + "\n");
			ReadWrite.createFolder(Paths.outputPathValve + VariableName);

			// Utworzenie Variables
			ReadWrite.createFileAndFill(Paths.outputPathValve + VariableName + "\\", "STAT_" + VariableName + ".XML", praseString_V999MV1(sourceSTAT_V999MV1, variableParameters, 6), 0);
			stringBuilderVariables.append(praseString_V999MV1(sourceVariableSTAT_V999MV1, variableParameters, 6));

			ReadWrite.createFileAndFill(Paths.outputPathValve + VariableName + "\\", "CMD_" + VariableName + ".XML", praseString_V999MV1(sourceCMD_V999MV1, variableParameters, 4), 0);
			stringBuilderVariables.append(praseString_V999MV1(sourceVariableCMD_V999MV1, variableParameters, 4));
														

			// Utworzenie Ekranow
			ReadWrite.createFileAndFill(Paths.outputPathValve + VariableName + "\\", "PUP_" + VariableName + "_BIN" + ".XML", praseStringPUP_V999MV1(sourcePUP_V999MV1_BIN, variableParameters), 0);
			stringBuilderScreen.append(praseStringPUP_V999MV1(sourceScreenPart2_V999MV1, variableParameters));

			// Utworzenie Funkcji
			ReadWrite.createFileAndFill(Paths.outputPathValve + VariableName + "\\", "SHOW_PUP_" + VariableName + "_BIN" + ".XML", praseStringSHOW_PUP_V999MV1(sourceSHOW_PUP_V999MV1_BIN, variableParameters), 0);
			stringBuilderFunctions.append(praseStringSHOW_PUP_V999MV1(sourceFunctionPart2_V999MV1, variableParameters));
		}

		//ReadWrite.createFileAndFill(Paths.outputPathValve, "ImportValveVariables.XML", stringBuilderVariables.toString(), 1);

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

		
		ReadWrite.createFileAndFill(Paths.outputPathValve, "ImportValveVariable.XML", sourceVariablePart1_V999MV1 + stringBuilderVariables + sourceVariablePart3_V999MV1, 0);
		ReadWrite.createFileAndFill(Paths.outputPathValve, "ImportFunction.XML", sourceFunctionPart1_V999MV1 + stringBuilderFunctions + sourceFunctionPart3_V999MV1, 0);
		ReadWrite.createFileAndFill(Paths.outputPathValve, "ImportScreen.XML", sourceScreenPart1_V999MV1 + stringBuilderScreen + sourceScreenPart3_V999MV1, 0);

	}

	private static String praseString_V999MV1(String source, String[] parameters, int offsetParameter)
	{
		String newSource_V999MV1 = new String(source);
		String name = parameters[0];
		String description = parameters[1] + "  " + parameters[2] + "  " + parameters[3];
		String offSet = parameters[offsetParameter].replaceAll("\\D+", "");
		String netAdress = parameters[7];

	
		newSource_V999MV1 = newSource_V999MV1.replaceAll("V999MV1", name);
		newSource_V999MV1 = newSource_V999MV1.replaceAll("<ID_Complex>.*.</ID_Complex>", "<ID_Complex>" + IdComplex++ + "</ID_Complex>");
		System.out.println("IdComplex : "+IdComplex);
		newSource_V999MV1 = newSource_V999MV1.replaceAll("<ID_ComplexVariable>.*.</ID_ComplexVariable>", "<ID_ComplexVariable>" + IdComplex++ + "</ID_ComplexVariable>");
		System.out.println("IdComplex : "+IdComplex);
		newSource_V999MV1 = newSource_V999MV1.replaceAll("<Tagname />", "<Tagname>" + description + "</Tagname>");
		newSource_V999MV1 = newSource_V999MV1.replaceAll("<Offset>0</Offset>", "<Offset>" + offSet + "</Offset>");
		newSource_V999MV1 = newSource_V999MV1.replaceAll("<NetAddr>1</NetAddr>", "<NetAddr>" + netAdress + "</NetAddr>");
		newSource_V999MV1 = newSource_V999MV1.replaceAll("Identification", "@"+name + " - " + description);
		
		//IdComplex++;
		//System.out.println("IdComplex : "+IdComplex);

		
		stringBulder.append(newSource_V999MV1);

		return newSource_V999MV1;
	}

	private static String praseStringPUP_V999MV1(String source, String[] parameters)
	{
		String newSource_V999MV1 = new String(source);
		String name = parameters[0];

		newSource_V999MV1 = newSource_V999MV1.replaceAll("V999MV1", name);		
		newSource_V999MV1 = newSource_V999MV1.replaceAll("<SubstituteSource />", "<SubstituteSource>*V999MV1*</SubstituteSource>");
		newSource_V999MV1 = newSource_V999MV1.replaceAll("\\*" + name + "\\*", "*V999MV1*");

		return newSource_V999MV1;
	}

	private static String praseStringSHOW_PUP_V999MV1(String source, String[] parameters)
	{
		String newSource_V999MV1 = new String(source);
		String name = parameters[0];

		
		newSource_V999MV1 = newSource_V999MV1.replaceAll("V999MV1", name);
		//@PUP_V999MV1_Valve
		newSource_V999MV1 = newSource_V999MV1.replaceAll("@TEMPOERARY OVERVIEW", "@PUP_" + name + "_Valve");

		return newSource_V999MV1;
	}

}
