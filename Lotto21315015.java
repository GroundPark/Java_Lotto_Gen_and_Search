
import java.util.Arrays;

public class Lotto21315015 {
// Lotto6Num Ŭ���� ����
 private int[] lots;
// 6�� ���� �����ϱ� ���� �迭 lots ����
 private int base;
// �ζ� ���� ���� 
 private int ballNum;
// �迭�� ������ �ζ� ���� ���� 
 
 public Lotto21315015(int base,int ballNum) {
	this.ballNum=ballNum;
	this.base=base;
	//�迭 ����
	lots=new int[ballNum];
	// �ζ� ���� ����(�迭ũ��)
 }
 public Lotto21315015() {
	this(45,6);
	// �� ����: 45, �迭ũ�� : 6 ���� �ʱ�ȭ
 }
 public void print() {
	for (int i = 0; i < lots.length; i++) {
		// 0���� �迭 ����(6)���� 1�� �����ϴ� ���� (0,1,2,3,4,5) �Ʒ� for���� �ݺ���; 1,2,3,4,5,6
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
	// 1~45 ���� ������ ������ �����.
 }
 public boolean contain(int n){
	boolean TorF=false;
	// �Է¹��� n�� �迭�� ���ԵǾ��ִ��� �Ǵ���
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
	// �迭�� 0���� �ʱ�ȭ �Ѵ�.
	int count=0;
	while(count!=ballNum){
	//�迭�� 6���� ���� �ٸ� ������ ä���������� �ݺ���.
		int temp=rand(); 
		// ������ ������ temp�� ����
		if(! contain(temp)){
			lots[count++]=temp;
		// �� ������ �迭�� ���ԵǾ� ���� ������ �迭�� �����ϰ� ����� ���� ����
		}
	}
	Arrays.sort(lots);
	// �迭�� ������������ �����Ѵ�.
 }
 public int[] getLots() {
	 // �迭�� ��ȯ��.
	return lots;
 }
}
	