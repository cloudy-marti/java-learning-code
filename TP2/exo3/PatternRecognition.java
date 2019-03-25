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

		getIPv4(args[0]);
	}

	public static int[] getIPv4(String str)
	{
		int ipvArray[] = new int[4];

		String ipPatternString = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
							"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
							"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
							"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
		Pattern ipPattern = Pattern.compile(ipPatternString);

		String ipPatternStringV2 = "(?:([0-9]{1,3})\\.){3}([0-9]{1,3})";
		Pattern ipPatternV2 = Pattern.compile(ipPatternStringV2);

		Matcher ipMatcherV2 = ipPatternV2.matcher(str);
		boolean check = ipMatcherV2.matches();

		if(!check || 
				Integer.parseInt(matcher.group(1)) > 255 ||
				Integer.parseInt(matcher.group(2)) > 255 ||
				Integer.parseInt(matcher.group(3)) > 255 ||
				Integer.parseInt(matcher.group(4)) > 255
			)
			System.out.println("this is not ipv4");


		Matcher ipMatcher = ipPattern.matcher(str);
		boolean isIPv4 = ipMatcher.matches();

		if(isIPv4)
			System.out.println("we have a good ipv4 :)");
		else
			System.out.println("meh");

		return ipvArray;
	}
}

// Exercice 3.1

// La méthode compile de regex permet de créer un objet Pattern
// Ce dernier nous permet d'utiliser d'autres méthodes comme Matcher.

// Matcher permet de retrouver des "match", des séquences qui correspondent à une expression donnée

