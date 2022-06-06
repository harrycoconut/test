import java.io.IOException;

public class Test
{
    
    public static void main(String [] argv) throws IOException
    {
        Data acd=new Data();
        Admin b=new Admin("QQQ@gmail.com", "Java", "123456","Admin");
        acd.addMember(b);
        System.out.println(acd.readMembers().get(0).getAccount());
        b.addBook("97654321","bookname","author","publisher");
        System.out.println(acd.readBooks().get(0).getISBN());
    }
}