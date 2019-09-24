// https://www.vogella.com/tutorials/JavaRegularExpressions/article.html

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PatternRecognition
{
	public static void main(String[] args)
	{
		String patternString = "([^0-9]*)([0-9]+)";
		Pattern pattern = Pattern.compile(patternString);

		for(String argv : args)
		{
			Matcher matcher = pattern.matcher(argv);
			boolean bool = matcher.matches();

			if(bool)
				System.out.println(matcher.group(2));
		}

		int ipArray[] = getIPv4(args[0]);

		if(ipArray == null)
			System.out.println("this is NOT an IPv4 !");
		else
		{
			System.out.println("this is an IPv4 !");
			
			for(int i = 0; i < 4; ++i)
			{
				System.out.print(ipArray[i]);
				if(i < 3)
					System.out.print(".");
			}

			System.out.println();
		}
	}

	public static int[] getIPv4(String str)
	{
		int ipArray[] = new int[4];

		// This RegEx below checks the IP directly (without if)
		// However I couldn't understand it all
		// I keep it but I don't use it here

		// String ipPatternString = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		// 					"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		// 					"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		// 					"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

		// Pattern ipPattern = Pattern.compile(ipPatternString);

		// Matcher ipMatcher = ipPattern.matcher(str);
		// boolean isIPv4 = ipMatcher.matches();

		 // The RegEx below works if we only want to check a match
		 // But doesn't create the 4 groups needed after
		 // It only creates two : the first ([0-9]{1,3}) and the last ([0-9]{1,3})
		
		// String ipPatternString = "(?:([0-9]{1,3})\\.){3}([0-9]{1,3})";

		String ipPatternString = "([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})";
		 // Compile pattern for further use
		Pattern ipPattern = Pattern.compile(ipPatternString);
		 // Check if the pattern and the string match
		Matcher ipMatcher = ipPattern.matcher(str);
		boolean isIPv4 = ipMatcher.matches();

		if(!isIPv4 || 
				Integer.parseInt(ipMatcher.group(1)) > 255 ||
				Integer.parseInt(ipMatcher.group(2)) > 255 ||
				Integer.parseInt(ipMatcher.group(3)) > 255 ||
				Integer.parseInt(ipMatcher.group(4)) > 255
			)
			return null;

		for(int i = 0; i < 4; ++i)
			ipArray[i] = Integer.parseInt(ipMatcher.group(i+1));

		return ipArray;
	}
}

// Exercice 3.1

// La méthode compile de regex permet de créer un objet Pattern
// Ce dernier nous permet d'utiliser d'autres méthodes comme Matcher.

// Matcher permet de retrouver des "match", des séquences qui correspondent à une expression donnée

