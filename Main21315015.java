
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
// 사용할 외부 패키지 import

public class Main21315015
//main 있을 MainPage 클래스
{
	public static void main(String[] args) {
		//메인 메소드
        		System.out.println("자바 로또 번호 프로그램입니다.");
       		SelectLotto();
		}	
	
	public static void SelectLotto() {
			//번호 입력 메소드
	        System.out.println("랜덤 번호 생성은 1을 입력하세요.");
	        System.out.println("최근 당첨회차 검색은 2를 입력하세요.");
	        System.out.println("종료하려면 3을 입력하세요.");
	        try{
	        	int Myinput;
				Scanner Mychoice = new Scanner(System.in);
	        	// scanner 사용
	        	
	        	Myinput = Mychoice.nextInt();
	        	// 내가 키보드로 입력하는것(mychoice)을 입력값(myinput)에 넣음
	        	
	        	// (정수)myinput값에 따라 메서드 호출
	        	if(Myinput == 1) {
	        		GetLottonum();
	        		// 로또 번호 생성 메서드 호출
	        		}
	        	else if(Myinput == 2) {
	        		RecentLottonum();
	        		// 최근 당첨회차 검색 메서드 호출
	        		}
	        	else if(Myinput == 3) {
	        		System.exit(0);
	        		// 종료
	        	}
	        	else {
	        		// 정수 입력값이 1,2,3 이 아닌경우
					System.out.println("입력값을 확인하세요.");
					SelectLotto();
	        		}
				}
			catch(Exception e) {
				// 입력값이 정수가 아닌경우
				System.out.println("정수값이 아님. 입력값을 확인하세요.");
				SelectLotto();
								}	
		 }
    public static void GetLottonum() 
    {
		//로또 번호 생성 호출
			System.out.println("로또 번호가 만들어졌습니다.");
			Lotto21315015 lot=new Lotto21315015(45,6);
			// 로또 객체 생성
			lot.make();
			lot.print();
			SelectLotto();
	 }

    public static void RecentLottonum() 
    {
		//최근 당첨 번호 검색 메서드
		Recent_lotto();
		SelectLotto();
		}

	private static void Recent_lotto() {
		//당첨번호 파싱 메서드
		ArrayList<String> each_PS_num = new ArrayList<String>();
		// 문자열만 저장할수있는 array list 객체 생성
		String lottourl="http://www.dreamlotto.net/lotto/nlotto-history";
		
		String s="";
		each_PS_num.clear();
		URL url=null;
		// 변수 초기화
		
			try{
				url=new URL(lottourl);
				// URL 객체 생성
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(),"euc-kr"),8);
				String line ="";
				
				while((line = reader.readLine()) != null) 
					//한문자씩 읽어 들임, 읽을것이 없을때 까지
					{						
						if(line.trim().contains("<li><i class=")){
							// 특정 문자열을 찾음; <li><i class=		
							s=line.trim();
								// s 에다가 특정 문자열 포함하는 문자열을 저장					
								s=s.substring(0,s.indexOf("</i"));
									// <li><i class="ball_num_9">9</i></li> 에서   </i>  뒤쪽을 버림		
								s=s.substring(s.indexOf("\">")+2).trim();
							    		// <li><i class="ball_num_9">9 에서   ">  앞쪽을 버림
								each_PS_num.add(s);
								    // each_PS_num 배열에 s 를 저장			
							}
						}
					}
		
			catch(Exception e){

				System.out.println("파싱 에러입니다");
				SelectLotto();
				// 에러났을때 처리
				}	
			
			// each_PS_num 배열안에 있는것들을 'PS숫자' 에 각각 저장
			String PS0 = each_PS_num.get(0).toString();
			String PS1 = each_PS_num.get(1).toString();
			String PS2 = each_PS_num.get(2).toString();
			String PS3 = each_PS_num.get(3).toString();
			String PS4 = each_PS_num.get(4).toString();
			String PS5 = each_PS_num.get(5).toString();
			// 사용한 페이지의 소스에서 6번째 줄은 필요가 없으므로 저장안함
			String PS6 = each_PS_num.get(7).toString();

			System.out.printf("당첨 번호 : %s %s %s %s %s %s. %n",PS0 ,PS1, PS2, PS3, PS4, PS5); 	
			System.out.println("보너스 번호 : " +PS6);		
			}
	}
