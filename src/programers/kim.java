package programers;

public class kim {

	public static void main(String[] args) {
		
		String[] seoul = {"Kim","Jane","Lee"};
		String answer="";
		
		for(int i = 0; i < seoul.length; i++) {
			answer = seoul[i];
			answer.substring(0,1);
			if(answer.contains("K")){
				System.out.println(answer);
			}
		}
		
		

		
		
		
	
	}
}


