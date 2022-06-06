import java.io.IOException;
public class Admin extends Member
{
	public Admin(String account,String name,String password,String identity)throws IOException{super(account,name,password,identity);}
	public void addBook(String ISBN,String title,String author,String publisher)throws IOException
	{
		Book book=new Book(ISBN,title,author,publisher,"in_Library");
		data.addBook(book);
	}
	//public void removeBook(String title,String author,String publisher){books.remove(index);}
}