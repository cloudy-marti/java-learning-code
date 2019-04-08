
public class Main
{
	public static void main(String[] args)
	{
		System.out.println("Hello Eclipse.");
		
		Book blueBook = new Book("Harry Potter", "J.K.Rowling");
		
		Book redBook = new Book("Harry Potter II", "J.K.Rowling");
		
		ArrayShoppingCart myShoppingCart = new ArrayShoppingCart();
		myShoppingCart.addBook(blueBook);
		myShoppingCart.addBook(redBook);
		
		System.out.println(myShoppingCart.toString());
		
		System.out.println(myShoppingCart.longuestTitle());
	}
}
