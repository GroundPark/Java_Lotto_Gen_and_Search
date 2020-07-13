
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
// ����� �ܺ� ��Ű�� import

public class Main21315015
//main ���� MainPage Ŭ����
{
	public static void main(String[] args) {
		//���� �޼ҵ�
        		System.out.println("�ڹ� �ζ� ��ȣ ���α׷��Դϴ�.");
       		SelectLotto();
		}	
	
	public static void SelectLotto() {
			//��ȣ �Է� �޼ҵ�
	        System.out.println("���� ��ȣ ������ 1�� �Է��ϼ���.");
	        System.out.println("�ֱ� ��÷ȸ�� �˻��� 2�� �Է��ϼ���.");
	        System.out.println("�����Ϸ��� 3�� �Է��ϼ���.");
	        try{
	        	int Myinput;
				Scanner Mychoice = new Scanner(System.in);
	        	// scanner ���
	        	
	        	Myinput = Mychoice.nextInt();
	        	// ���� Ű����� �Է��ϴ°�(mychoice)�� �Է°�(myinput)�� ����
	        	
	        	// (����)myinput���� ���� �޼��� ȣ��
	        	if(Myinput == 1) {
	        		GetLottonum();
	        		// �ζ� ��ȣ ���� �޼��� ȣ��
	        		}
	        	else if(Myinput == 2) {
	        		RecentLottonum();
	        		// �ֱ� ��÷ȸ�� �˻� �޼��� ȣ��
	        		}
	        	else if(Myinput == 3) {
	        		System.exit(0);
	        		// ����
	        	}
	        	else {
	        		// ���� �Է°��� 1,2,3 �� �ƴѰ��
					System.out.println("�Է°��� Ȯ���ϼ���.");
					SelectLotto();
	        		}
				}
			catch(Exception e) {
				// �Է°��� ������ �ƴѰ��
				System.out.println("�������� �ƴ�. �Է°��� Ȯ���ϼ���.");
				SelectLotto();
								}	
		 }
    public static void GetLottonum() 
    {
		//�ζ� ��ȣ ���� ȣ��
			System.out.println("�ζ� ��ȣ�� ����������ϴ�.");
			Lotto21315015 lot=new Lotto21315015(45,6);
			// �ζ� ��ü ����
			lot.make();
			lot.print();
			SelectLotto();
	 }

    public static void RecentLottonum() 
    {
		//�ֱ� ��÷ ��ȣ �˻� �޼���
		Recent_lotto();
		SelectLotto();
		}

	private static void Recent_lotto() {
		//��÷��ȣ �Ľ� �޼���
		ArrayList<String> each_PS_num = new ArrayList<String>();
		// ���ڿ��� �����Ҽ��ִ� array list ��ü ����
		String lottourl="http://www.dreamlotto.net/lotto/nlotto-history";
		
		String s="";
		each_PS_num.clear();
		URL url=null;
		// ���� �ʱ�ȭ
		
			try{
				url=new URL(lottourl);
				// URL ��ü ����
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(),"euc-kr"),8);
				String line ="";
				
				while((line = reader.readLine()) != null) 
					//�ѹ��ھ� �о� ����, �������� ������ ����
					{						
						if(line.trim().contains("<li><i class=")){
							// Ư�� ���ڿ��� ã��; <li><i class=		
							s=line.trim();
								// s ���ٰ� Ư�� ���ڿ� �����ϴ� ���ڿ��� ����					
								s=s.substring(0,s.indexOf("</i"));
									// <li><i class="ball_num_9">9</i></li> ����   </i>  ������ ����		
								s=s.substring(s.indexOf("\">")+2).trim();
							    		// <li><i class="ball_num_9">9 ����   ">  ������ ����
								each_PS_num.add(s);
								    // each_PS_num �迭�� s �� ����			
							}
						}
					}
		
			catch(Exception e){

				System.out.println("�Ľ� �����Դϴ�");
				SelectLotto();
				// ���������� ó��
				}	
			
			// each_PS_num �迭�ȿ� �ִ°͵��� 'PS����' �� ���� ����
			String PS0 = each_PS_num.get(0).toString();
			String PS1 = each_PS_num.get(1).toString();
			String PS2 = each_PS_num.get(2).toString();
			String PS3 = each_PS_num.get(3).toString();
			String PS4 = each_PS_num.get(4).toString();
			String PS5 = each_PS_num.get(5).toString();
			// ����� �������� �ҽ����� 6��° ���� �ʿ䰡 �����Ƿ� �������
			String PS6 = each_PS_num.get(7).toString();

			System.out.printf("��÷ ��ȣ : %s %s %s %s %s %s. %n",PS0 ,PS1, PS2, PS3, PS4, PS5); 	
			System.out.println("���ʽ� ��ȣ : " +PS6);		
			}
	}
