package math;

import java.util.ArrayList;
import java.util.List;

public class _204_CountPrimes {

	public static void main(String[] args) {
		_204_CountPrimes obj = new _204_CountPrimes();
		System.out.println(obj.countPrimes(100));
	}

	
	/* Very slow method */ 
	public int countPrimes(int n) {
		List<Integer> primes = new ArrayList<Integer>();
		if (n == 0)
			return 0;
		if (n == 1)
			return 0;

		int count = 0;

		// less than n
		for (int target = 2; target < n; ++target) {
			if (testPrime(target, primes))
				++count;
		}
		return count;
	}

	private boolean testPrime(int target, List<Integer> primes) {
		int k = (int) Math.sqrt(target);
		for (Integer e : primes) {
			if (e > k) {
				primes.add(target);
				return true;
			}
			if (target % e == 0)
				return false;
		}
		primes.add(target);
		return true;
	}
}
