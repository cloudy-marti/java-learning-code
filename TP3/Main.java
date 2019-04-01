import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		// Book book = new Book("hello", "moto");
		// Book book2 = new Book("Hello");
		
		// System.out.println(book.getTitle() + ' ' + book.getAuthor());
		// System.out.println(book2.getTitle() + ' ' + book2.getAuthor());

		// Book b1 = new Book("Da Java Code", "Duke Brown");
		// Book b2 = b1;
		// Book b3 = new Book("Da Java Code", "Duke Brown");

		// System.out.println(b1 == b2);
		// System.out.println(b1.isSameBook(b3));

		// Book b1 = new Book("Da Java Code", "Duke Brown");
		// Book b2 = b1;
		// Book b3 = new Book("Da Java Code", "Duke Brown");

		// ArrayList list = new ArrayList();
		// list.add(b1);
		// System.out.println(list.indexOf(b2));
		// System.out.println(list.indexOf(b3));

		Book aBook = new Book("Da Java Code", "Duke Brown");
		Book anotherBook = new Book("hello");
		ArrayList list = new ArrayList();
		list.add(aBook);
		System.out.println(list.indexOf(anotherBook));

		System.out.println(aBook.toString());
		System.out.println(anotherBook.toString());
	}
}

