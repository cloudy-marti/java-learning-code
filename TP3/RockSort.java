public class RockSort
{
	public static void swap(int[] array, int index1, int index2)
	{
		int tmp = array[index1];

		array[index1] = array[index2];
		array[index2] = tmp;
	}

	public static int indexOfMin(int[] array)
	{
		int i, tmp, minIndex;

		minIndex = 0;
		tmp = array[0];

		for(i = 0; i < array.length; ++i)
		{
			if(tmp > array[i])
			{
				tmp = array[i];
				minIndex = i;
			}
		}

		return minIndex;
	}

	public static int indexOfMinRestricted(int[] array, int firstIndex, int secondIndex)
	{
		int i, tmp, minIndex;

		minIndex = firstIndex;
		tmp = array[firstIndex];

		for(i = firstIndex; i < secondIndex; ++i)
		{
			if(tmp > array[i])
			{
				tmp = array[i];
				minIndex = i;
			}
		}

		return minIndex;
	}

	public static void sort(int[] array)
	{
		int index, tmpIndex;

		for(index = 0; index < array.length; ++index)
		{

			tmpIndex = indexOfMinRestricted(array, index, array.length);

			if(array[tmpIndex] < array[index])
				swap(array, index, tmpIndex);

			// System.out.print("index = " + index + " minIndex = " + tmpIndex + "\t");
			// displayArray(array);
		}
	}

	public static void displayArray(int[] array)
	{
		for(int i = 0; i < array.length; ++i)
			System.out.print(array[i] + " ");

		System.out.println();
	}

	public static void main(String[] args)
	{
		int[] array = {4, 5, 6, 2, 1};
		RockSort.displayArray(array);

		RockSort.sort(array);
		RockSort.displayArray(array);
	}
}