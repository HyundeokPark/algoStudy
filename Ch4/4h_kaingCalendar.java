
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
		
	}

	/**
	 * 'index'번째 날짜의 Y(오른쪽 번호)를 반환하는 함수
	 *
	 * @param index
	 * @return
	 */
	public int getYByIndex(int index)
	{
		
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
		/*
	M,N의 배수들 +x,y의 값이 같은 값이 연도인것은 알았으나!.... 이것은 최소M,N이 각각 최소 1바퀴 이상씩 돌았다는 가정하에!......
	*0을 포함한 배수들이면 1회차에도 구할수있다!!!
	M과 N의 최대공약수와 최소공배수를 구해서 배수의 마지막까지 나열!
		*/
		int lcd =0; // 최소공배수
		int gcm =0; // 최대공약수
		
		while(x !=0){
			int tmp = x%y;
			x =y;
			y =tmp;
		}
		
		for(int i=0; i<?; i++){
			
		}
		for(int i=0; i<?; i++){
			
		}
	}
}