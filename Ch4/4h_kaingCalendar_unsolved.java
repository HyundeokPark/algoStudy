
import java.io.*;
import java.lang.*;
import java.util.*;


public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static void testCase(int caseIndex) {
		int M = scanner.nextInt();
		int N = scanner.nextInt();
		int x = scanner.nextInt();
		int y = scanner.nextInt();

		// <1,1> ~ <M, N> 연도를 표현하는 카잉 달력을 생성한다
		KaingCalendar calendar = new KaingCalendar(M, N);

		// 이 달력에서 <x, y>가 몇 번째 연도인지 계산한다
		int answer = calendar.getIndex(x, y);

		// 정답을 출력한다
		System.out.println(answer);
	}

	public static void main(String[] args) throws Exception {
		int caseSize = scanner.nextInt();

		for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
			testCase(caseIndex);
		}
	}

}

class KaingCalendar
{
	final int M;    // 왼쪽 번호의 최대 값
	final int N;    // 오른쪽 번호의 최대 값

	KaingCalendar(int M, int N)
	{
		this.M   = M;
		this.N   = N;
	}

	/**
	 * 'index'번째 날짜의 X(왼쪽 번호)를 반환하는 함수
	 *
	 * @param index
	 * @return
	 */
	public int getXbyIndex(int index)
	{
		int x =0;
		if(index % this.M ==0){
			x = this.M;
		}else{
			x = index % this.M;
		}
		return x;
	}

	/**
	 * 'index'번째 날짜의 Y(오른쪽 번호)를 반환하는 함수
	 *
	 * @param index
	 * @return
	 */
	public int getYByIndex(int index)
	{
		int y = 0;
		if(index % this.N ==0){
			y =this.N;
		}else{
			y = index % this.N;
		}
		return y;
	}

	public int getLCM(int x, int y){
		int gcd = this.getGCD(x,y);
		return (x*y) / gcd;
	}
	
	public int getGCD(int x, int y){
	  int tmp = 0;
		while(y!=0){
			tmp = x % y;
			x =y;
			y =tmp;
		}
		return x;
	}
	/**
	 *
	 *
	 * @param x
	 * @param y
	 * @return  이 달력에서 <x, y>라는 연도가 최초로 등장하는 순번
	 *          등장하지 않는 연도라면 -1을 반환한다
	 */
	public int getIndex(int x, int y)
	{
		//최소공배수만금 횟수가 필요!!!
		//int lcm = this.getLCM(this.M,this.N);
		//System.out.println("lcm : " + lcm);
		/*for(int i=1; i<=this.M*this.N; i++){
			//System.out.println("24X "+ this.getXbyIndex(40000));
			//System.out.println("24Y "+ this.getYByIndex(40001));
			if(x == this.getXbyIndex(i)  && y == this.getYByIndex(i)){
				return i;
			}
		}*/
		for (int index = x; index <= M * N; index += M){
			// 왼쪽이 x인 모든 날짜에 대해 
			if (getYByIndex(index) == y) {
				// 오른쪽이 y인 날짜가 존재한다면 반환한다
				return index;
			}
		}
		return -1;
	}
}