import java.util.TreeMap;
/**
 * This class manages a dictionary where all keys (lexemes) are stored in lowercase and without leading and trailing spaces.
 */
public class Dictionary {
	private TreeMap<String, String> dictionary;  
	public Dictionary() {
		dictionary = new TreeMap<>(); 
	}

	public TreeMap<String, String> getDictionary(){
		return dictionary;
	}
}