import java.util.LinkedList;
import java.util.Iterator;
import java.util.Optional;

public class FreeShoppingCart
{
	private LinkedList<Book> shoppingCart;
	private int bookCounter;
	
	public FreeShoppingCart()
	{
		 this.shoppingCart = new LinkedList<Book>();
		 this.bookCounter = 0;
	}
	
	public void addBook(Book newBook)
	{
		this.shoppingCart.add(newBook); // this.shoppingCart.offerLast(newBook)
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

	public Optional<Book> removeFirstOccurrence()
	{
		return this.shoppingCart.removeFirst();
	}

	public void removeFirstOccurrenceWithIterator()
	{
		this.shoppingCart.next().remove();
	}

}

/**
 * 3.7
 * Changer ArrayList par LinkedList sans changer le reste du code marche bien
 * car elles doivent posséder les mêmes méthodes même si codées différemment)
 *
 * La complexité doit être la même car on s'occupe que du premier élément
 *
 */