package wolfe.jake;

import java.util.*;
public class Collections {

	public static void main(String a[]) {		         
	        List<Integer> list = new ArrayList<Integer>();  
	        list.add(46);  
	        list.add(67);  
	        list.add(24);  
	        list.add(16);  
	        list.add(8);  
	        list.add(12);  
	        System.out.println(list);
	        
	        List<String> l1 = createList();
	        l1.sort(null);
	        l1.forEach(System.out::println);
	        
	        System.out.println();
	        
	        System.out.println("Demonstration of removeIf");
	        List<String> l2 = createList();
	        
	        for(Iterator<String> listIter = l2.iterator(); listIter.hasNext();) {
	        	
	        }
	        
	        l2.removeIf(s -> s.toLowerCase().contains("x"));
	        l2.forEach(s->System.out.println(s));
 	        
	}

	private static List<String> createList(){
		return Arrays.asList("Iphone", "Ubuntu", "Android", "Mac OS X");	
	}
}
