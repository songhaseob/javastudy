package programers;

public class twosum {

	public static void main(String[] args) {
		
		int a = 5;
		int b = 3;
		int sum = 0;
		

		sum = 0;
		for (int i = a; a <= b; a++) {
				sum += a;
				
			}
			System.out.println("합계 : " + sum);
		sum = 0;
		for(int i = b; b <= a; b++) {
			sum += b;
		}
		System.out.println("합계 :" + sum);
		}

	}


