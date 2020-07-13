
import java.util.Arrays;

public class Lotto21315015 {
// Lotto6Num 클래스 생성
 private int[] lots;
// 6개 정수 저장하기 위한 배열 lots 선언
 private int base;
// 로또 공의 개수 
 private int ballNum;
// 배열에 저장할 로또 공의 개수 
 
 public Lotto21315015(int base,int ballNum) {
	this.ballNum=ballNum;
	this.base=base;
	//배열 생성
	lots=new int[ballNum];
	// 로또 공의 개수(배열크기)
 }
 public Lotto21315015() {
	this(45,6);
	// 공 개수: 45, 배열크기 : 6 으로 초기화
 }
 public void print() {
	for (int i = 0; i < lots.length; i++) {
		// 0부터 배열 길이(6)까지 1씩 증가하는 동안 (0,1,2,3,4,5) 아래 for문을 반복함; 1,2,3,4,5,6
		if(i==lots.length-1){
			System.out.printf("%d",lots[i]);
			}
			else{
			System.out.printf("%d,",lots[i]);
			}
	}
	System.out.println();
 }
 private int rand(){
	return (int)(Math.random()*base)+1;
	// 1~45 사이 임의의 정수를 만든다.
 }
 public boolean contain(int n){
	boolean TorF=false;
	// 입력받은 n이 배열에 포함되어있는지 판단함
	for (int i = 0; i < lots.length; i++) {
		if(lots[i]==n){
			TorF=true;
			break;
		}
	}
	return TorF;
 }
 
 public void make(){
	Arrays.fill(lots, 0);
	// 배열을 0으로 초기화 한다.
	int count=0;
	while(count!=ballNum){
	//배열에 6개의 서로 다른 정수가 채워질때까지 반복함.
		int temp=rand(); 
		// 임의의 정수를 temp에 넣음
		if(! contain(temp)){
			lots[count++]=temp;
		// 이 정수가 배열에 포함되어 있지 않으면 배열에 저장하고 저장된 개수 증가
		}
	}
	Arrays.sort(lots);
	// 배열을 오름차순으로 정렬한다.
 }
 public int[] getLots() {
	 // 배열을 반환함.
	return lots;
 }
}
	