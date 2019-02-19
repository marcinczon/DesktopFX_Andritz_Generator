package Binary;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Utils.Messages;
import Utils.Paths;
import Utils.ReadWrite;
import Utils.Settings;

public class GeneratorBinary
{

	// *******************
	//
	// Nie dodaje parametru <No screan> (Standard)
	//
	// *******************

	static int IdComplex = Settings.IdComplexBinary;

	ArrayList<String> bufferArrayList = new ArrayList<>();

	static StringBuilder stringBulder = new StringBuilder();
	static StringBuilder stringBuilderVariables = new StringBuilder();
	static StringBuilder stringBuilderFunctions = new StringBuilder();
	static StringBuilder stringBuilderScreen = new StringBuilder();

	// Zrodla z calego pliku oryginalnego
	String sourceCMD_B999GS1;
	String sourceCONFIG_B999GS1;
	String sourceSTAT_B999GS1;
	String sourcePUP_B999GS1_BIN;
	String sourceSHOW_PUP_B999GS1_BIN;

	// Zrodla tylko dla zmiennych
	String sourceVariableCMD_B999GS1;
	String sourceVariableCONFIG_B999GS1;
	String sourceVariableSTAT_B999GS1;

	String sourceVariablePart1_B999GS1;
	String sourceVariablePart2_B999GS1;
	String sourceVariablePart3_B999GS1;

	// Zrodlo tylko dla funkcji
	String sourceFunctionPart1_B999GS1;
	String sourceFunctionPart2_B999GS1;
	String sourceFunctionPart3_B999GS1;

	// Zrodlo tylko dla Ekranu
	String sourceScreenPart1_B999GS1;
	String sourceScreenPart2_B999GS1;
	String sourceScreenPart3_B999GS1;

	public GeneratorBinary()
	{
		Messages.ShowMessage("Generator Binary");
		
		// *********************************************+
		//
		// Odczyt z plikow zrodelowych
		//
		// *********************************************+

		// Zrodla z calego pliku oryginalnego
		sourceCMD_B999GS1 = ReadWrite.readFile(Paths.pathCMD_B999GS1);
		sourceCONFIG_B999GS1 = ReadWrite.readFile(Paths.pathCONFIG_B999GS1);
		sourceSTAT_B999GS1 = ReadWrite.readFile(Paths.pathSTAT_B999GS1);
		sourcePUP_B999GS1_BIN = ReadWrite.readFile(Paths.pathPUP_B999GS1_BIN);
		sourceSHOW_PUP_B999GS1_BIN = ReadWrite.readFile(Paths.pathSHOW_PUP_B999GS1_BIN);

		// Zrodla tylko dla zmiennych
		sourceVariableCMD_B999GS1 = ReadWrite.readFile(Paths.pathVariableCMD_B999GS1);
		sourceVariableCONFIG_B999GS1 = ReadWrite.readFile(Paths.pathVariableCONFIG_B999GS1);
		sourceVariableSTAT_B999GS1 = ReadWrite.readFile(Paths.pathVariableSTAT_B999GS1);

		// Zrodlo tylko dla zmiennych
		sourceVariablePart1_B999GS1 = ReadWrite.readFile(Paths.pathVariablePart1_B999GS1);
		sourceVariablePart2_B999GS1 = ReadWrite.readFile(Paths.pathVariablePart2_B999GS1);
		sourceVariablePart3_B999GS1 = ReadWrite.readFile(Paths.pathVariablePart3_B999GS1);

		// Zrodlo tylko dla funkcji
		sourceFunctionPart1_B999GS1 = ReadWrite.readFile(Paths.pathFunctionPart1_B999GS1);
		sourceFunctionPart2_B999GS1 = ReadWrite.readFile(Paths.pathFunctionPart2_B999GS1);
		sourceFunctionPart3_B999GS1 = ReadWrite.readFile(Paths.pathFunctionPart3_B999GS1);

		// Zrodlo tylko dla Ekranu
		sourceScreenPart1_B999GS1 = ReadWrite.readFile(Paths.pathScreenPart1_B999GS1);
		sourceScreenPart2_B999GS1 = ReadWrite.readFile(Paths.pathScreenPart2_B999GS1);
		sourceScreenPart3_B999GS1 = ReadWrite.readFile(Paths.pathScreenPart3_B999GS1);
	}

	public void CreateOutputsFiles(String dataType) throws FileNotFoundException, IOException
	{

		// *********************************************+
		//
		// Odczyt i przygotowanie zmiennych z pliku
		//
		// *********************************************

		try (BufferedReader bufferReader = new BufferedReader(new FileReader(Paths.sourcePathBinary)))
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
			Messages.ShowMessage(dataType + " - " + VariableName + "\n");
			ReadWrite.createFolder(Paths.outputPathPID + VariableName);

			// Utworzenie Variables
			ReadWrite.createFileAndFill(Paths.outputPathPID + VariableName + "\\", "CMD_" + VariableName + ".XML", praseStringVariable_B999GS1(sourceCMD_B999GS1, variableParameters, 4), 0);
			stringBuilderVariables.append(praseStringVariable_B999GS1(sourceVariableCMD_B999GS1, variableParameters, 4));

			ReadWrite.createFileAndFill(Paths.outputPathPID + VariableName + "\\", "CONFIG_" + VariableName + ".XML", praseStringVariable_B999GS1(sourceCONFIG_B999GS1, variableParameters, 5), 0);
			stringBuilderVariables.append(praseStringVariable_B999GS1(sourceVariableCONFIG_B999GS1, variableParameters, 5));

			ReadWrite.createFileAndFill(Paths.outputPathPID + VariableName + "\\", "STAT_" + VariableName + ".XML", praseStringVariable_B999GS1(sourceSTAT_B999GS1, variableParameters, 6), 0);
			stringBuilderVariables.append(praseStringVariable_B999GS1(sourceVariableSTAT_B999GS1, variableParameters, 6));

			// Utworzenie Ekranow
			ReadWrite.createFileAndFill(Paths.outputPathPID + VariableName + "\\", "PUP_" + VariableName + "_BIN" + ".XML", praseStringPUP_B999GS1(sourcePUP_B999GS1_BIN, variableParameters), 0);
			stringBuilderScreen.append(praseStringPUP_B999GS1(sourceScreenPart2_B999GS1, variableParameters));

			// Utworzenie Funkcji
			ReadWrite.createFileAndFill(Paths.outputPathPID + VariableName + "\\", "SHOW_PUP_" + VariableName + "_BIN" + ".XML", praseStringSHOW_PUP_B999GS1(sourceSHOW_PUP_B999GS1_BIN, variableParameters), 0);
			stringBuilderFunctions.append(praseStringSHOW_PUP_B999GS1(sourceFunctionPart2_B999GS1, variableParameters));
		}

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

		ReadWrite.createFileAndFill(Paths.outputPathPID, "ImportBinaryVariable.XML", sourceVariablePart1_B999GS1 + stringBuilderVariables + sourceVariablePart3_B999GS1, 0);
		ReadWrite.createFileAndFill(Paths.outputPathPID, "ImportBinaryFunction.XML", sourceFunctionPart1_B999GS1 + stringBuilderFunctions + sourceFunctionPart3_B999GS1, 0);
		ReadWrite.createFileAndFill(Paths.outputPathPID, "ImportBinaryScreen.XML",   sourceScreenPart1_B999GS1 + stringBuilderScreen + sourceScreenPart3_B999GS1, 0);

	}

	private static String praseStringVariable_B999GS1(String source, String[] parameters, int offsetParameter)
	{
		String newSource_B999GS1 = new String(source);
		String name 			 = parameters[0];
		String description 		 = parameters[1] + "  " + parameters[2] + "  " + parameters[3];
		String offSet 			 = parameters[offsetParameter].replaceAll("\\D+", "");
		String netAdress 		 = parameters[7];

		newSource_B999GS1 = newSource_B999GS1.replaceAll("B999GS1", name);
		newSource_B999GS1 = newSource_B999GS1.replaceAll("<ID_Complex>.*.</ID_Complex>", "<ID_Complex>" + IdComplex++ + "</ID_Complex>");
		newSource_B999GS1 = newSource_B999GS1.replaceAll("<ID_ComplexVariable>.*.</ID_ComplexVariable>", "<ID_ComplexVariable>" + IdComplex++ + "</ID_ComplexVariable>");
		newSource_B999GS1 = newSource_B999GS1.replaceAll("<Tagname />", "<Tagname>" + description + "</Tagname>");
		newSource_B999GS1 = newSource_B999GS1.replaceAll("<Offset>.*.</Offset>", "<Offset>" + offSet + "</Offset>");
		newSource_B999GS1 = newSource_B999GS1.replaceAll("<NetAddr>.*.</NetAddr>", "<NetAddr>" + netAdress + "</NetAddr>");
		newSource_B999GS1 = newSource_B999GS1.replaceAll("Identification", "@"+name + " - " + description);
		
		
		stringBulder.append(newSource_B999GS1);

		return newSource_B999GS1;
	}

	private static String praseStringPUP_B999GS1(String source, String[] parameters)
	{
		String newSource_B999GS1 = new String(source);
		String name = parameters[0];

		newSource_B999GS1 = newSource_B999GS1.replaceAll("B999GS1", name);
		newSource_B999GS1 = newSource_B999GS1.replaceAll("\\*" + name + "\\*", "*B999GS1*");

		return newSource_B999GS1;
	}

	private static String praseStringSHOW_PUP_B999GS1(String source, String[] parameters)
	{
		String newSource_B999GS1 = new String(source);
		String name = parameters[0];

		newSource_B999GS1 = newSource_B999GS1.replaceAll("B999GS1", name);
		newSource_B999GS1 = newSource_B999GS1.replaceAll("@TEMPOERARY OVERVIEW", "@PUP_" + name + "_BIN");

		return newSource_B999GS1;
	}

}
