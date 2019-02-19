package Utils;

public  class Messages
{
	public static void ShowMessage(String message)
	{
		if(Settings.showMessageConsole)
		{
			System.out.println("Message: " + message);
		}
	}
	public static void ShowError(String error)
	{
		if(Settings.showErrorConsole)
		{
			System.err.println("Error: " + error);
		}
	}
	public static void ShowWarning(String warning)
	{
		if(Settings.showWarningeConsole)
		{
			System.out.println("Warning: " + warning);
		}
	}

}
