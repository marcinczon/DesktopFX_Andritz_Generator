package PID;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Utils.Messages;
import Utils.Paths;
import Utils.ReadWrite;
import Utils.Settings;

public class GeneratorPID
{
	
	//*******************
	//
	// Nie dodaje parametru <No screan> (Standard)
	//
	//*******************
	

	static int IdComplex = Settings.IdComplexPID;
    
	ArrayList<String> bufferArrayList = new ArrayList<>();

	static StringBuilder stringBulder 			= new StringBuilder();
	static StringBuilder stringBuilderVariables = new StringBuilder();
	static StringBuilder stringBuilderFunctions = new StringBuilder();
	static StringBuilder stringBuilderScreen 	= new StringBuilder();
	
	// Zrodla z calego pliku oryginalnego
	String sourceCMD_C999TIC;
	String sourceSTAT_C999TIC;
	String sourceCONFIG_C999TIC;


	// Zrodla tylko dla zmiennych
	String sourceVariableCMD_C999TIC;
	String sourceVariableSTAT_C999TIC;
	String sourceVariableCONFIG_C999TIC;
	
	String sourceVariablePart1_C999TIC;
	String sourceVariablePart2_C999TIC;
	String sourceVariablePart3_C999TIC;




	public GeneratorPID()
	{
		Messages.ShowMessage("Generator PID");
		
		// *********************************************+
		//
		// Odczyt z plikow zrodel
		//
		// *********************************************+

		// Zrodla z calego pliku oryginalnego
		 sourceCMD_C999TIC 			= ReadWrite.readFile(Paths.pathCMD_C999TIC);
		 sourceSTAT_C999TIC 		= ReadWrite.readFile(Paths.pathSTAT_C999TIC);
		 sourceCONFIG_C999TIC 		= ReadWrite.readFile(Paths.pathCONFIG_C999TIC);

		// Zrodla tylko dla zmiennych
		 sourceVariableCMD_C999TIC 	= ReadWrite.readFile(Paths.pathVariableCMD_C999TIC);
		 sourceVariableSTAT_C999TIC = ReadWrite.readFile(Paths.pathVariableSTAT_C999TIC);
		 sourceVariableCONFIG_C999TIC = ReadWrite.readFile(Paths.pathVariableCONFIG_C999TIC);

		// Zrodlo tylko dla zmiennych
		 sourceVariablePart1_C999TIC = ReadWrite.readFile(Paths.pathVariablePart1_C999TIC);
		 sourceVariablePart2_C999TIC = ReadWrite.readFile(Paths.pathVariablePart2_C999TIC);
		 sourceVariablePart3_C999TIC = ReadWrite.readFile(Paths.pathVariablePart3_C999TIC);

	}
	
	public void CreateOutputsFiles(String dataType) throws FileNotFoundException, IOException
	{

		// *********************************************+
		//
		// Odczyt i przygotowanie zmiennych z pliku
		//
		// *********************************************

		try (BufferedReader bufferReader = new BufferedReader(new FileReader(Paths.sourcePathPID)))
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
			ReadWrite.createFileAndFill(Paths.outputPathPID + VariableName + "\\", "CMD_" + VariableName + ".XML", praseStringVariable_C999TIC(sourceCMD_C999TIC, variableParameters, 4), 0);
			stringBuilderVariables.append(praseStringVariable_C999TIC(sourceVariableCMD_C999TIC, variableParameters, 4));

			ReadWrite.createFileAndFill(Paths.outputPathPID + VariableName + "\\", "CONFIG_" + VariableName + ".XML", praseStringVariable_C999TIC(sourceCONFIG_C999TIC, variableParameters, 5), 0);
			stringBuilderVariables.append(praseStringVariable_C999TIC(sourceVariableCONFIG_C999TIC, variableParameters, 5));

			ReadWrite.createFileAndFill(Paths.outputPathPID + VariableName + "\\", "STAT_" + VariableName + ".XML", praseStringVariable_C999TIC(sourceSTAT_C999TIC, variableParameters, 6), 0);
			stringBuilderVariables.append(praseStringVariable_C999TIC(sourceVariableSTAT_C999TIC, variableParameters, 6));						

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

		
		ReadWrite.createFileAndFill(Paths.outputPathPID, "ImportPIDVariable.XML", sourceVariablePart1_C999TIC + stringBuilderVariables + sourceVariablePart3_C999TIC, 0);

	}

	private static String praseStringVariable_C999TIC(String source, String[] parameters, int offsetParameter)
	{
		String newSource_C999TIC = new String(source);
		String name = parameters[0];
		String description = parameters[1] + "  " + parameters[2] + "  " + parameters[3];
		String offSet = parameters[offsetParameter].replaceAll("\\D+", "");
		String netAdress = parameters[7];

		newSource_C999TIC = newSource_C999TIC.replaceAll("C999TIC", name);
		newSource_C999TIC = newSource_C999TIC.replaceAll("<ID_Complex>.*.</ID_Complex>", "<ID_Complex>" + IdComplex++ + "</ID_Complex>");
		newSource_C999TIC = newSource_C999TIC.replaceAll("<ID_ComplexVariable>.*.</ID_ComplexVariable>", "<ID_ComplexVariable>" + IdComplex++ + "</ID_ComplexVariable>");
		newSource_C999TIC = newSource_C999TIC.replaceAll("<Tagname />", "<Tagname>" + description + "</Tagname>");
		newSource_C999TIC = newSource_C999TIC.replaceAll("<Offset>.*.</Offset>", "<Offset>" + offSet + "</Offset>");	
		newSource_C999TIC = newSource_C999TIC.replaceAll("<NetAddr>.*.</NetAddr>", "<NetAddr>" + netAdress + "</NetAddr>");
		newSource_C999TIC = newSource_C999TIC.replaceAll("Identification", "@"+name + " - " + description);
			
		stringBulder.append(newSource_C999TIC);

		return newSource_C999TIC;
	}
}
