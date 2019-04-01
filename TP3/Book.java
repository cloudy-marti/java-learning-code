import java.lang.Override;
import java.util.Objects;

public class Book
{
	private String title;
	private String author;

	public Book(String title, String author)
	{
		this.title = Objects.requireNonNull(title);
		this.author = Objects.requireNonNull(author);
	}

	public static Book Book(String title)
	{
		return new Book(title, "<no author>");
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
		
	}
}