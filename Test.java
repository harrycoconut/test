public class Test
{
    public static void main(String [] args)
    {          
        Data acd= new Data();
        for(int i=0;i<acd.readMembers().size();i++)
        {
            System.out.println(acd.readMembers().size());
        }
    }
}