package string;

public class _657_JudgeRouteCircle {

	public static void main(String[] args) {
		String s1 = "UUDDRLRRLL";
		System.out.println(judgeCircle(s1));
	}

	public static boolean judgeCircle(String moves) {
		char[] arr = moves.toCharArray();
		int[] count = new int[4]; // U, D, R, L
		for (int i = 0; i < arr.length; i++) {
			switch (arr[i]) {
			case 'U':
				count[0]++;
				break;
			case 'D':
				count[1]++;
				break;
			case 'R':
				count[2]++;
				break;
			case 'L':
				count[3]++;
				break;
			}
		}
		if (count[0] == count[1] && count[2] == count[3])
			return true;
		else
			return false;
	}
}
