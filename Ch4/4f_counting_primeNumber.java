import java.io.*;
import java.lang.*;
import java.util.*;


public class Main {
	public static final Scanner scanner = new Scanner(System.in);
	public static final int MAX_VALUE = 1000000;
	public static final int MAX_VALUE2 = 100000;
	public static final Sieve sieve = new Sieve(MAX_VALUE);

	public static ArrayList<Integer> getAllPrimeNumbers(int from, int to)
	{
		ArrayList<Integer> primes = new ArrayList<>();

		for(int num = from; num <= to; num += 1)
		{
			if(sieve.isPrimeNumber(num) == true)
			{
				primes.add(num);
			}
		}

		return primes;
	}

	public static void testCase(int caseIndex) {
		int L = scanner.nextInt();
		int R = scanner.nextInt();

		ArrayList<Integer> allPrimeNumbers = getAllPrimeNumbers(L, R);

		System.out.printf("Case #%d:\n", caseIndex);
		System.out.println(allPrimeNumbers.size());
	}

	public static void main(String[] args) throws Exception {
		int caseSize = scanner.nextInt();

		for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
			testCase(caseIndex);
		}
	}

}


class Sieve //소인수 분해를 빠르게
{
	final int maximumValue;     // 에라토스테네스의 체에서 다룰 가장 큰 범위의 값
	final boolean[] isPrime;    // 각 숫자별 소수 여부
	Sieve(int maximumValue)
	{
		this.maximumValue = maximumValue;
		this.isPrime = new boolean[maximumValue+1];
		this.fillSieve();
	}

	/**
	 *
	 * @param num
	 * @return 'num'이 소수라면 true, 그렇지 않으면 false
	 */
	public boolean isPrimeNumber(int num)
	{
		return this.isPrime[num];
	}

	/**
	 * isPrime 배열의 값을 채우는 함수
	 */
	private void fillSieve()
	{
		int a = 46349*46349;
		System.out.println("a : " + a);
		long b = 46349*46349;
		System.out.println("(long)a : " + b);
		//모든 배열 원소 true로 초기화
		Arrays.fill(this.isPrime,true);
		
		//0,1은 소수가 아니므로 false!
		this.isPrime[0] = this.isPrime[1]= false;
		
		for(int n=2; n<=this.maximumValue; n++){
			//소수가 아니라고 판별된 수는 건너뛴다!!!
			if(this.isPrime[n] == false){
				continue;
			}
			//소수가 맞다고 판별된 수의 모~든 배수를 false로 입력한다!
			//int가 아닌 long일때 오류가 왜 안나는걸까?
			// -214673749는 int의 범위에 해당된다!.. 그런데.... 왜?... n*n을 했는데 음수가 나오지??;;..
			//n == 46349일때 n*n의 값이 int형 범위를 초과한다. 그래서 제곱을 했으나 음수형이 나온다!
			//long으로 해도 음수가 나온다... 뭐지.///
			for(long m = n*n; m<=this.maximumValue; m+=n){
				int index = (int)m;
				try{
					this.isPrime[index] = false;	
					//throw new Exception();
				} catch(Exception e){
					//e.printStackTrace();
					/*
					System.out.println("n : " +n);
					System.out.println("m : " +m);
					System.out.println("(Long)m :" + (long)m );
					*/
					//throw e;
				}
				
			}
		}
	}
}