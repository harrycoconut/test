import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class UI2 implements ActionListener
{
	JFrame frame;
	JPanel panel;
	private JTextField accTF,nameTF,passTF,idTF;
	private Member member;
	public int w=1000,h=750;
	public static void main(String[] args)
	{
		UI2 UI2=new UI2();
		UI2.ui2();
	}

	public UI2()
	{
		frame = new JFrame("圖書館");
		frame.setResizable(false);
		frame.setSize(w, h);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				int result = JOptionPane.showConfirmDialog(frame,
						"是否關閉程式",
						"警告",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE);
				if (result == JOptionPane.YES_OPTION){System.exit(0);}
			}
		});
	}
	
	public void actionPerformed(ActionEvent e)
	{
		switch (Integer.parseInt(e.getActionCommand()))
		{
			case 0:
				frame.remove(panel);
				ui2();
				break;
			case 1:
				log_in();
				break;
			case 2:
				sign_up();
				break;
			case 3:
				if(accTF.getText().isBlank()||nameTF.getText().isBlank()||passTF.getText().isBlank()||idTF.getText().isBlank())
				{
					JOptionPane.showMessageDialog(null, "輸入值不能為空!","警告",3);
					sign_up();
				}
				member=new Member(accTF.getText(),nameTF.getText(),passTF.getText(),idTF.getText());
				if(member.sign_up()){home();}
				else
				{
					frame.remove(panel);
					sign_up();
				}
				break;
			case 4:
				if(accTF.getText().isBlank()||nameTF.getText().isBlank()||passTF.getText().isBlank()||idTF.getText().isBlank())
				{
					JOptionPane.showMessageDialog(null, "輸入值不能為空!","警告",3);
					sign_up();
				}
				else
				{
					member=new Member(accTF.getText(),nameTF.getText(),passTF.getText(),idTF.getText());
					if(member.sign_up())
					{
						member.sign_up();
						home();
					}
					else
					{
						member.sign_up();
						sign_up();
					}
				}
			default:
				break;
		}
	}
	public void ui2()
	{

		panel= new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,w/3,h*2));
		panel.setLayout(null);
		//new ImageIcon("user.png")

		JButton log_in = new JButton("登入");
		log_in.setBounds(100,200,100,50);
		JButton panel_up = new JButton("註冊");
		panel_up.setBounds(300,200,100,50);
		log_in.setActionCommand("1");
		panel_up.setActionCommand("2");
		log_in.addActionListener(this);
		panel_up.addActionListener(this);

		panel.add(log_in);
		panel.add(panel_up);
		frame.add(panel);
		frame.setVisible(true);
	}
	


	public void log_in()
	{
		frame.remove(panel);
		panel= new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT,w/100,h/2));
		panel.setLayout(null);
		//new ImageIcon("user.png")

		JButton confirm = new JButton("確認");
		confirm.setBounds(100,300,100,30);
		JButton back = new JButton("返回");
		back.setBounds(300,300,100,30);

		JLabel accLB=new JLabel("帳號");
		accLB.setBounds(80,50,100,20);
		JTextField accTF = new JTextField(16);
		accTF.setBounds(120,50,100,20);
		JLabel passLB=new JLabel("密碼");
		passLB.setBounds(80,120,100,20);
		JTextField passTF = new JPasswordField(16);
		passTF.setBounds(120,120,100,20);// 非明文密碼輸入；
		
		panel.add(accLB);
		panel.add(accTF);
		panel.add(passLB);
		panel.add(passTF);
		
		back.setActionCommand("0");
		confirm.addActionListener(this);
		back.addActionListener(this);

		panel.add(confirm);
		panel.add(back);
		frame.add(panel);
		frame.setVisible(true);
	}
	
	public void sign_up()
	{
		frame.remove(panel);
		panel= new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setLayout(null);
		//new ImageIcon("user.png")

		JButton confirm = new JButton("確認");
		confirm.setBounds(100,300,100,30);
		JButton back = new JButton("返回");
		back.setBounds(300,300,100,30);

		JLabel nameLB=new JLabel("姓名");
		nameLB.setBounds(80,150,100,20); 
		nameTF = new JTextField(16);
		nameTF.setBounds(120,150,100,20); 
		JLabel idLB=new JLabel("身分");
		idLB.setBounds(80,200,100,20); 
		idTF = new JTextField(16);
		idTF.setBounds(120,200,100,20); 
		JLabel accLB=new JLabel("帳號");
		accLB.setBounds(80,50,100,20);
		accTF = new JTextField(16);
		accTF.setBounds(120,50,100,20);
		JLabel passLB=new JLabel("密碼");
		passLB.setBounds(80,100,100,20);
		passTF = new JPasswordField(16);
		passTF.setBounds(120,100,100,20);// 非明文密碼輸入；
		panel.add(accLB);
		panel.add(accTF);
		panel.add(nameLB);
		panel.add(nameTF);
		panel.add(passLB);
		panel.add(passTF);
		panel.add(idLB);
		panel.add(idTF);

		confirm.setActionCommand("4");
		back.setActionCommand("0");
		confirm.addActionListener(this);
		back.addActionListener(this);

		panel.add(confirm);
		panel.add(back);
		frame.add(panel);
		frame.setVisible(true);
	}
	
	public void home()
	{
		frame.remove(panel);
		panel= new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,w/50,h/4));
		
		JButton sear = new JButton("書籍查詢");
		JButton returnBook = new JButton("還書");
		JButton inform = new JButton("個人資訊");
		JButton history = new JButton("歷史紀錄");
		JButton manaBook = new JButton("書籍管理");
		JButton fee = new JButton("繳納罰金");
		
		sear.setActionCommand("4");
		returnBook.setActionCommand("5");
		inform.setActionCommand("6");
		history.setActionCommand("7");
		manaBook.setActionCommand("8");
		fee.setActionCommand("9");
		sear.addActionListener(this);
		returnBook.addActionListener(this);
		inform.addActionListener(this);
		history.addActionListener(this);
		manaBook.addActionListener(this);
		fee.addActionListener(this);

		panel.add(sear);
		panel.add(returnBook);
		panel.add(inform);
		panel.add(history);
		if(member.getIdentity().equals("Admin"))
		{
			panel.add(manaBook);
			panel.add(fee);
		}
		frame.add(panel);
		frame.setVisible(true);
	}
}
