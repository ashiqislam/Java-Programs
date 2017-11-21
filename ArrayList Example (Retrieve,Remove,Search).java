import java.util.*;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello World");
		
		ArrayList<String> Names = new ArrayList<String>();
		
		Names.add("Rose");
		Names.add("Mimi");
		Names.add("Jackie");
		
		System.out.println(Names.get(0)); // retrieve element in array
		Names.remove(0); //remove element in array
		System.out.println(Names.get(0)); 
		
		if (Names.contains("Mimi")) {  //array search
			System.out.println("True");
		}
	}

}
