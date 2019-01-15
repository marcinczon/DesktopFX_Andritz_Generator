import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import GUI.gui;
import javafx.application.Application;
import javafx.stage.Stage;

// *********************************************
// Do poprawki: SHOW_PUP nie importuje zmiennej PICTURE trzeba ustawiac reczenie, po podstawieniu crt+f w n++ zadzialalo
//
//
// *********************************************
public class StartBinary extends Application
{

	static gui gui;

	static String pathGlobal = "C:\\Users\\mczonstke\\Desktop\\Wizu\\Changed\\Binary\\";

	static StringBuilder stringBulder = new StringBuilder();
	static StringBuilder stringBuilderVariables = new StringBuilder();
	static StringBuilder stringBuilderFunctions = new StringBuilder();
	static StringBuilder stringBuilderScreen = new StringBuilder();

	static int IdComplex = 90000;

	@Override
	public void start(Stage stageMain)
	{
		stageMain.setTitle("Zenon Generator");
		stageMain.setScene(gui.getMainScene());
		// stageMain.show();
	}

	public static void main(String[] args) throws IOException
	{
		gui = new gui();

		ArrayList<String> bufferArrayList = new ArrayList<>();

		// *********************************************
		//
		// Linki do plikow
		//
		// *********************************************

		String sourcePath = "C:\\Users\\mczonstke\\Desktop\\Wizu\\source.txt";
		String pathVariables = "C:\\Users\\mczonstke\\Desktop\\Wizu\\Changed\\Import\\";

		String pathCMD_B999GS1 = "C:\\Users\\mczonstke\\Desktop\\Wizu\\Oryginal\\BINARY_B999GS1\\CMD_B999GS1.XML";
		String pathCONFIG_B999GS1 = "C:\\Users\\mczonstke\\Desktop\\Wizu\\Oryginal\\BINARY_B999GS1\\CONFIG_B999GS1.XML";
		String pathSTAT_B999GS1 = "C:\\Users\\mczonstke\\Desktop\\Wizu\\Oryginal\\BINARY_B999GS1\\STAT_B999GS1.XML";
		String pathPUP_B999GS1_BIN = "C:\\Users\\mczonstke\\Desktop\\Wizu\\Oryginal\\BINARY_B999GS1\\PUP_B999GS1_BIN.XML";
		String pathSHOW_PUP_B999GS1_BIN = "C:\\Users\\mczonstke\\Desktop\\Wizu\\Oryginal\\BINARY_B999GS1\\SHOW_PUP_B999GS1_BIN.XML";

		String pathVariableCMD_B999GS1 = "C:\\Users\\mczonstke\\Desktop\\Wizu\\Changed\\Import\\Base\\B999GS1 - Binary\\Variable_CMD_B999GS1.XML";
		String pathVariableCONFIG_B999GS1 = "C:\\Users\\mczonstke\\Desktop\\Wizu\\Changed\\Import\\Base\\B999GS1 - Binary\\Variable_CONFIG_B999GS1.XML";
		String pathVariableSTAT_B999GS1 = "C:\\Users\\mczonstke\\Desktop\\Wizu\\Changed\\Import\\Base\\B999GS1 - Binary\\Variable_STAT_B999GS1.XML";

		String pathFunctionPart1_B999GS1 = "C:\\Users\\mczonstke\\Desktop\\Wizu\\Changed\\Import\\Base\\B999GS1 - Binary\\ImportFunctionPart1.XML";
		String pathFunctionPart2_B999GS1 = "C:\\Users\\mczonstke\\Desktop\\Wizu\\Changed\\Import\\Base\\B999GS1 - Binary\\\\ImportFunctionPart2.XML";
		String pathFunctionPart3_B999GS1 = "C:\\Users\\mczonstke\\Desktop\\Wizu\\Changed\\Import\\Base\\B999GS1 - Binary\\\\ImportFunctionPart3.XML";

		String pathScreenPart1_B999GS1 = "C:\\Users\\mczonstke\\Desktop\\Wizu\\Changed\\Import\\Base\\B999GS1 - Binary\\ImportScreenPart1.XML";
		String pathScreenPart2_B999GS1 = "C:\\Users\\mczonstke\\Desktop\\Wizu\\Changed\\Import\\Base\\B999GS1 - Binary\\ImportScreenPart2.XML";
		String pathScreenPart3_B999GS1 = "C:\\Users\\mczonstke\\Desktop\\Wizu\\Changed\\Import\\Base\\B999GS1 - Binary\\ImportScreenPart3.XML";

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

		// *********************************************+
		//
		// Odczyt i przygotowanie zmiennych z pliku
		//
		// *********************************************

		try (BufferedReader bufferReader = new BufferedReader(new FileReader(sourcePath)))
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
			createFolder(pathGlobal + strings[0]);

			// Utworzenie Variables
			createFileAndFill(pathGlobal + strings[0] + "\\", "CMD_" + strings[0] + ".XML", praseString_B999GS1(sourceCMD_B999GS1, strings, 4), 0);
			stringBuilderVariables.append(praseString_B999GS1(sourceVariableCMD_B999GS1, strings, 4));

			createFileAndFill(pathGlobal + strings[0] + "\\", "CONFIG_" + strings[0] + ".XML", praseString_B999GS1(sourceCONFIG_B999GS1, strings, 5), 0);
			stringBuilderVariables.append(praseString_B999GS1(sourceVariableCONFIG_B999GS1, strings, 5));

			createFileAndFill(pathGlobal + strings[0] + "\\", "STAT_" + strings[0] + ".XML", praseString_B999GS1(sourceSTAT_B999GS1, strings, 6), 0);
			stringBuilderVariables.append(praseString_B999GS1(sourceVariableSTAT_B999GS1, strings, 6));

			// Utworzenie Ekranow
			createFileAndFill(pathGlobal + strings[0] + "\\", "PUP_" + strings[0] + "_BIN" + ".XML", praseStringPUP_B999GS1(sourcePUP_B999GS1_BIN, strings), 0);
			stringBuilderScreen.append(praseStringPUP_B999GS1(sourceScreenPart2_B999GS1, strings));

			// Utworzenie Funkcji
			createFileAndFill(pathGlobal + strings[0] + "\\", "SHOW_PUP_" + strings[0] + "_BIN" + ".XML", praseStringSHOW_PUP_B999GS1(sourceSHOW_PUP_B999GS1_BIN, strings), 0);
			stringBuilderFunctions.append(praseStringSHOW_PUP_B999GS1(sourceFunctionPart2_B999GS1, strings));
		}

		createFileAndFill(pathVariables, "ImportFileVariables.XML", stringBuilderVariables.toString(), 1);

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

		String tempPath = "C:\\Users\\mczonstke\\Desktop\\Wizu\\Changed\\Import\\";
		
		createFileAndFill(tempPath, "ImportVariable.XML", readFile(tempPath + "\\Base\\ImportFilePart_1.XML") + readFile(tempPath + "ImportFileVariables.XML") + readFile(tempPath + "\\Base\\ImportFilePart_2.XML"), 0);
		createFileAndFill(tempPath, "ImportFunction.XML", sourceFunctionPart1_B999GS1 + stringBuilderFunctions + sourceFunctionPart3_B999GS1, 0);
		createFileAndFill(tempPath, "ImportScreen.XML", sourceScreenPart1_B999GS1 + stringBuilderScreen + sourceScreenPart3_B999GS1, 0);

	}

	private static String praseString_B999GS1(String source, String[] parameters, int offsetParameter)
	{
		String newSource_B999GS1 = new String(source);
		String name = parameters[0];
		String tagName = parameters[1] + "  " + parameters[2] + "  " + parameters[3];
		String offSet = parameters[offsetParameter].replaceAll("\\D+", "");
		String netAdress = parameters[7];

		newSource_B999GS1 = newSource_B999GS1.replaceAll("B999GS1", name);
		newSource_B999GS1 = newSource_B999GS1.replaceAll("<ID_Complex>.*.</ID_Complex>", "<ID_Complex>" + IdComplex + "</ID_Complex>");
		newSource_B999GS1 = newSource_B999GS1.replaceAll("<ID_ComplexVariable>.*.</ID_ComplexVariable>", "<ID_ComplexVariable>" + IdComplex + "</ID_ComplexVariable>");
		newSource_B999GS1 = newSource_B999GS1.replaceAll("<Tagname />", "<Tagname>" + tagName + "</Tagname>");
		newSource_B999GS1 = newSource_B999GS1.replaceAll("<Offset>0</Offset>", "<Offset>" + offSet + "</Offset>");
		newSource_B999GS1 = newSource_B999GS1.replaceAll("<NetAddr>1</NetAddr>", "<NetAddr>" + netAdress + "</NetAddr>");

		IdComplex++;
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

	private static String readFile(String filePath)
	{
		String content = null;
		try
		{
			content = new String(Files.readAllBytes(Paths.get(filePath)));

		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return content;
	}

	public static void createFolder(String path)
	{
		boolean success = (new File(path)).mkdirs();
		if (!success)
		{
			System.err.println("Path not created : " + path);
		} else
		{
			System.out.println("Path created : " + path);
		}

	}

	public static void createFileAndFill(String path, String name, String source, int mode)
	{

		File file = new File(path + name);
		PrintWriter writer;

		// Create the file
		try
		{
			if (file.createNewFile())
			{
				System.out.println("Created file: " + name);
			} else
			{
				System.err.println("File already exists: " + name);
			}
		} catch (IOException e)
		{

			e.printStackTrace();
		}

		try
		{
			if (mode == 0)
			{
				writer = new PrintWriter(file, "UTF-16LE");
			} else
			{
				writer = new PrintWriter(file);
			}
			writer.write("\uFEFF");
			writer.write(source);
			writer.close();
		} catch (IOException e1)
		{
			System.err.println("ERROR: Cant fill file by source!");
			e1.printStackTrace();
		}
	}

}
