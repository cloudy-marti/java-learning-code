import java.util.ArrayList;
import java.util.Optional;

public class FreeShoppingCart
{
	private ArrayList<Book> shoppingCart;
	private int bookCounter;
	
	public FreeShoppingCart()
	{
		 this.shoppingCart = new ArrayList<Book>();
		 this.bookCounter = 0;
	}
	
	public void addBook(Book newBook)
	{
		this.shoppingCart.add(newBook);
		this.bookCounter++;
	}
	
	public Optional<Book> longuestTitle()
	{

	}
}
