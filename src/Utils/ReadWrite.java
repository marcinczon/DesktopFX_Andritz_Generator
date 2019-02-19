package Utils;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadWrite
{
	public static String readFile(String filePath)
	{
		String content = null;
		try
		{
			content = new String(Files.readAllBytes(Paths.get(filePath)));

		} catch (IOException e)
		{
			Messages.ShowError(e.toString());
		}
		return content;
	}

	public static void createFolder(String path)
	{
		boolean success = (new File(path)).mkdirs();
		if (!success)
		{
			Messages.ShowWarning("Path not created : " + path);
		} else
		{
			Messages.ShowMessage("Path created : " + path);
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
				Messages.ShowMessage("Created file: " + name);
			} else
			{
				Messages.ShowWarning("File already exists: " + name);
			}
		} catch (IOException e)
		{
			Messages.ShowError(e.toString());
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
			Messages.ShowError(e1.toString());
		}
	}
}
