import java.util.Optional;
 
public class ArrayShoppingCart
{
	private int cartCapacity;
	
	private Book[] bookArray;
	private int counter;
	
	public ArrayShoppingCart()
	{
		this.cartCapacity = 10;
		this.bookArray = new Book[this.cartCapacity];
		this.counter = 0;
	}
	
	public void addBook(Book nextBook)
	{
		this.bookArray[this.counter] = nextBook;
		this.counter++;
	}
	
	public int numberOfBooks()
	{
		return this.counter;
	}
	
	@Override
	public String toString()
	{
		StringBuilder cartString = new StringBuilder();
				
		cartString.append("We have ");
		cartString.append(this.counter);
		cartString.append(" books in the shopping cart !\n");
		
		for(int i = 0; i < this.counter; ++i)
		{
			cartString.append(i);
			
			cartString.append("\t-\t");
			cartString.append(bookArray[i]);
			
			cartString.append("\n");
		}
		
		return cartString.toString();
	}
	
	public Optional<Book> longuestTitle()
	{
		Book longuestTitleBook = this.bookArray[0];
				
		if(this.counter > 0)
		{
			for(int i = 0; i < this.counter; ++i)
				if(longuestTitleBook.getTitle().length() < bookArray[i].getTitle().length())
					longuestTitleBook = this.bookArray[i];
		}
		else
		{
			return Optional.empty();
		}	
		
		return Optional.of(longuestTitleBook);
	}
	
	public void removeAllOccurrences(Book deletedBook)
	{
		for(int i = 0; i < this.counter; ++i)
			if(deletedBook.equals(this.bookArray[i]))
				bookArray[i] = null;
	}
}
