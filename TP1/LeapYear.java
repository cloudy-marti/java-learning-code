import java.util.GregorianCalendar;

public class LeapYear
{
	public static boolean isLeapYear(int year)
	{
		if(year % 4 == 0 && year % 100 != 0)
			return true;
		else if(year % 400 == 0)
			return true;
		else
			return false;
	}

	public static boolean isLeapYearLazy(int year)
	{
		GregorianCalendar calendar = new GregorianCalendar();
		return calendar.isLeapYear(year);
	}

	public static int[] showAllInTheRange(int firstYear, int secondYear)
	{
		int count = ((secondYear - firstYear)/4) + 1;
		System.out.println("count = " + count);

		int leapYears[] = new int[count];

		System.out.print("Leap Years between " + firstYear + " and " + secondYear + " :\n[ ");

		for(int i = firstYear; i <= secondYear; ++i)
		{
			// System.out.println(i);
			if(isLeapYear(i))
			{
				leapYears[(i-firstYear)/4] = i;
				System.out.print(i + " ");
			}
		}
		System.out.println("]");

		return leapYears;
	}

	public static void main(String[] args)
	{
		if(args.length == 0)
			System.out.println("Too few arguments ...");
		else if(args.length == 1)
		{
			if(isLeapYear(Integer.parseInt(args[0])))
				System.out.println(args[0] + " is a leap year !");
			else
				System.out.println(args[0] + " is NOT a leap year ...");
		}
		else
		{
			int count = ((Integer.parseInt(args[1]) - Integer.parseInt(args[0]))/4) + 1;
			int leapYears[] = new int[count];

			leapYears = showAllInTheRange(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		}

	}
}