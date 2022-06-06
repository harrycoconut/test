import java.util.ArrayList;
public class Book
{
	private ArrayList<String> book = new ArrayList<String>();
	public Book(String ISBN,String title,String author,String publisher,String state)
	{
		setISBN(ISBN);
		setTitle(title);
		setAuthor(author);
		setPublisher(publisher);
		setState(state);
	}
	public String toString()
	{
		String output="";
		for(int i=0;i<book.size();i++)
		{
			output+=book.get(i)+((i==book.size()-1)?"\n":"\t");
		}
		return output;
	}

	public ArrayList<String> getBook(){return book;}

	public void setISBN(String ISBN){book.add(0,ISBN);}
	public String getISBN(){return book.get(0);}
	
	public void setTitle(String title){book.add(1,title);}
	public String getTitle(){return book.get(1);}

	public void setAuthor(String author){book.add(2,author);}
	public String getAuthor(){return book.get(2);}

	public void setPublisher(String publisher){book.add(3,publisher);}
	public String getPublisher(){return book.get(3);}

	public void setState(String state){book.add(4,state);}
	public String getState(){return book.get(4);}

	
}
