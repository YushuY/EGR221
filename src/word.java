import java.util.TreeMap;

public class word {
    TreeMap <String, String> words = new TreeMap<String, String>();

    public word(){
    }
    public void setWords(String word, String synonym){
        words.put(word, synonym);
    }

    public String getSynonym(String word){
        return words.get(word);
    }
}

