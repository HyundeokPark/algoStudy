import java.io.*;
import java.lang.*;
import java.util.*;


public class Main {
	public static final Scanner scanner = new Scanner(System.in);
	public static final int MAX_VALUE = 1000000;
	public static final Sieve sieve = new Sieve(MAX_VALUE);

	public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void testCase(int caseIndex) {
		int x = scanner.nextInt();

		int a = -1;
		int b = -1;
		//홀수의 경우에만 소수인지 판별한다!
		for(int i=3; i<x; i+=2){
			//i가 소수일때만 판별실행
			if(sieve.isPrimeNumber[i]==true){
				//x -i 의 결과값이 isPrimeNumber에서 소수면 맞다! 
				if(sieve.isPrimeNumber[x-i] == true){
					a = i;
					b = x-i;
					break;
				} 
			}
		}
		
		
		// 정답을 출력한다
		System.out.printf("Case #%d:\n", caseIndex);
		if(a > 0 && b > 0)
		{
			System.out.printf("%d = %d + %d\n", x, a, b);
		}else{
			System.out.println(-1);
		}
	}

	public static void main(String[] args) throws Exception {
		int caseSize = scanner.nextInt();

		for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
			testCase(caseIndex);
		}
	}
	
	public static class  Sieve {
		int maxValue;
		boolean[] isPrimeNumber;
		
		public Sieve(int max){
			maxValue = max;
			isPrimeNumber = new boolean[max+1];
			fillArr();
		}
		public void fillArr(){
			//boolean 배열은 false가 기본값이기 때문에, true로 초기화 한다.
			Arrays.fill(isPrimeNumber,true);
			isPrimeNumber[0] = false;
			isPrimeNumber[1] = false; 
			for(int n=2;n<maxValue+1; n++){
				//값이 fasle라면 넘어간다.
				if(isPrimeNumber[n] == false){
					continue;
				}
				//값이 true라면 해당 값의 모든 배수를 false로 바꾼다.
				for(long m = (long)n*n; m<maxValue+1; m+=n){
					int index = (int)m;
					isPrimeNumber[index] = false;
				}
			}	
		
		}
	}
}