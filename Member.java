
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Member
{
	protected Data data=new Data();
	protected ArrayList<Member> members=data.readMembers();
	protected ArrayList<String> member=new ArrayList<String>(); 

	public Member(String account,String name,String password,String identity)
	{
		setAccount(account);
		setName(name);
		setPassword(password);
		setIdentity(identity);
	}
	public Member(String account,String password)
	{
		setAccount(account);
		setPassword(password);
	}

	public String sign_up()
	{
		if(findAccount(this)==-1)
		{
			data.addMember(this);
			return "3";
		}
		else
		{
			JOptionPane.showMessageDialog(null,"此帳號已被註冊!","錯誤",0);
			return "2";
		}
	}

	public String log_in()
	{
		if(findAccount(this)==-1)
		{
			JOptionPane.showMessageDialog(null,"此帳號不存在!","錯誤",0);
			return "2";
		}
		else if(members.get(findAccount(this)).getPassword()==getPassword())
		{
			setName(members.get(findAccount(this)).getName());
			setIdentity(members.get(findAccount(this)).getIdentity());
			JOptionPane.showMessageDialog(null,"登入成功\n歡迎 "+getName(),"歡迎",1);
			return "3";
		}
		else
		{
			JOptionPane.showMessageDialog(null,"密碼錯誤!","警告",3);
			return "2";
		}
	}

	public int findAccount(Member member)
	{
		int accIndex=-1;
		for(int i=0;i<members.size();i++)
		{
			if(members.get(i).getAccount()==member.getAccount()){accIndex=i;}
		}
		return accIndex;
	}
	public String toString()
	{
		String output="";
		for(int i=0;i<member.size();i++)
		{
			output+=member.get(i)+((i==member.size()-1)?"\n":"\t");
		}
		return output;
	}
	public void setAccount(String account){member.add(0,account);}
	public String getAccount(){return member.get(0);}

	public void setName(String name){member.add(1,name);}
	public String getName(){return member.get(1);}

	public String getPassword(){return member.get(2);}
	public void setPassword(String password){member.add(2,password);}

	public void setIdentity(String identity){member.add(3,identity);}
	public String getIdentity(){return member.get(3);}
}