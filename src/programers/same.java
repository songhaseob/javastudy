package programers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;

public class same {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		arr.add(1);
		arr.add(1);
		arr.add(3);
		arr.add(3);
		arr.add(0);
		arr.add(1);
		arr.add(1);
		
		System.out.println(arr);
		
		int temp = 0;
		
		for(int i = 0; i < arr.size(); i++) {
				if (arr.contains(arr.size())){
				}else {
					arr.add(arr.get(i));
					
					
				}
			}
			System.out.println(arr.get(0));
		}
	}

