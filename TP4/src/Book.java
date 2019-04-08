import java.lang.Override;
import java.util.Objects;

public class Book
{
	private String title;
	private String author;

	boolean authorKnown = true;

	public Book(String title, String author)
	{
		this.title = Objects.requireNonNull(title);
		this.author = Objects.requireNonNull(author);
	}

	public Book(String title)
	{
		this(title, "<no author>");
		this.authorKnown = false;
	}

	public String getTitle()
	{
		return this.title;
	}

	public String getAuthor()
	{
		return this.author;
	}

	public boolean isSameBook(Book b)
	{
		return this.title.equals(b.title) && this.author.equals(b.author);
	}

	@Override
	public boolean equals(Object obj)
	{
		Book myBook = (Book)obj;

		return this.title.equals(myBook.title) && this.author.equals(myBook.author);
	}

	@Override
	public String toString()
	{
		String bookString = new String();

		if(!this.authorKnown)
			bookString = this.title;
		else
			bookString = this.title + " by " + this.author;

		return bookString;
	}
}