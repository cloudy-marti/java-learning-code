import java.util.ArrayList;
import java.util.Iterator;
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
	
	public Optional<Book> longuestTitleWithIndex()
	{
		Book longuestTitleBook = this.shoppingCart.get(0);
		
		if(this.bookCounter == 0)
			return Optional.empty();
		else
		{
			for(int i = 0; i < this.bookCounter; ++i)
				if(longuestTitleBook.getTitle().length() < this.shoppingCart.get(0).getTitle().length())
					longuestTitleBook = this.shoppingCart.get(0);
		}	
		
		return Optional.of(longuestTitleBook);
	}
	
	public Optional<Book> longuestTitleWithIterator()
	{
		Book longuestTitleBook = this.shoppingCart.get(0);
		
		Iterator<Book> bookIterator = this.shoppingCart.iterator();
		
		if(this.bookCounter == 0)
			return Optional.empty();
		else
		{
			while(bookIterator.hasNext())
			{
				if(longuestTitleBook.getTitle().length() < this.shoppingCart.get(0).getTitle().length())
					longuestTitleBook = this.shoppingCart.get(0);
			}
		}	
		
		return Optional.of(longuestTitleBook);
	}
	
	public Optional<Book> longuestTitleWithForEach()
	{
		Book longuestTitleBook = this.shoppingCart.get(0);
				
		if(this.bookCounter == 0)
			return Optional.empty();
		else
		{
			for(Book eachBook : this.shoppingCart)
			{
				if(longuestTitleBook.getTitle().length() < this.shoppingCart.get(0).getTitle().length())
					longuestTitleBook = this.shoppingCart.get(0);
			}
		}	
		
		return Optional.of(longuestTitleBook);
	}
}
