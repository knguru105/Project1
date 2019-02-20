package Assignment2;
import java.util.LinkedList;
public class MaintainCharacter {
	
	public static LinkedList<Character> readCharacters(String name)
	{
		LinkedList<Character> listOfCharacters = new LinkedList();
		int length = name.length();
		for(int i=0;i<length;i++) {
			Character charVal = name.charAt(i);
			if(listOfCharacters.contains(charVal)) {
				listOfCharacters.remove(charVal);
			}
			listOfCharacters.offerFirst(charVal);
			
		}
		return listOfCharacters;
	}

}
