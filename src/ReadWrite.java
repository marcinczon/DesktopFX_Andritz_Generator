import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadWrite
{
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
