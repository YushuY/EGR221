import com.sun.source.util.Trees;
import com.sun.tools.classfile.Opcode;

import java.util.*;

public class HangmanManager {

    int guessesLeft;
    String pattern;
    TreeSet<String> answerSpace= new TreeSet<>();
    TreeSet<Character> guessedCharacter= new TreeSet<>();

    //HangmanManager constructor
    //IllegalArgumentException if length is less than 1 or if max is less than 0.
    HangmanManager(Collection<String> dictionary, int length, int max){
        if (length < 1)
            throw new IllegalArgumentException ("Length should not less than 1");
        if (max < 0)
            throw new IllegalArgumentException ("Maximum incorrect guesses must be more than 0.");
        for(String word:dictionary){
            if(word.length() == length){
                answerSpace.add(word);
            }
        }
        guessesLeft = max;
        pattern = "-";
        for(int i = 1; i < length; i++){

            pattern += " -";
        }
    }

    // get access to the current set of words
    // being considered by the hangman manager.
    public Set <String> words(){
        return answerSpace;
    }

    //return how many times left
    public int guessesLeft(){
        return guessesLeft;
    }

    //Find out the letters already have been guessed by user
    public SortedSet <Character> guesses(){
        return guessedCharacter ;
    }

    //Return current pattern
    //Letters that have not yet been
    //guessed should be displayed as a dash and there
    //should be spaces separating the letters. There should
    //be no leading or trailing spaces. This method should
    //throw an IllegalStateException if the set of words is
    //empty.
    public String pattern(){
        if(answerSpace.isEmpty()){
            throw new IllegalStateException("Answer space should not be empty.");
        }
        return pattern;
    }

    //Return the number of occurrences of the guessed letter
    //Update the number of guesses left
    //throw an IllegalStateException if the number of guesses left is not at least 1
    // or if the set of words is empty.
    // throw an IllegalArgumentException if the set of words is
    //nonempty and the character being guessed was
    //guessed previously.
    public int record(char guess){
        int count = 0;
        if(answerSpace.isEmpty()){
            throw new IllegalStateException("The set of words is empty.");
        } else if(guessesLeft < 1){
            throw new IllegalStateException("No guesses left.");
        } else if(guessedCharacter.contains(guess)){
            throw new IllegalArgumentException(guess + "has been guessed.");
        }
        guessedCharacter.add(guess);
        //build Map
        Map<String, Set<String>> treeMap = new TreeMap<>();
        for(String word: answerSpace){
            String key = pattern;
            for(int i = 0; i < word.length(); i++){
                if(word.charAt(i)== guess){
                    key = key.replace(key.charAt(i*2),guess);
                }
            }
            Set<String> value;
            if(!treeMap.containsKey(key)){
                value = new TreeSet<>();

            } else{
                value = treeMap.get(key);
            }
            value.add(word);;
            treeMap.put(key,value);
        }
        //compare the longest one
        //get the best key
        Set<String> keyset = treeMap.keySet();
        String result = keyset.iterator().next();
        for(String key:keyset){
            if(treeMap.get(key).size() > treeMap.get(result).size())
                result = key;
        }

        System.out.print(result);
        //pattern = result;
        //find the # of the occurrences of guess
        for(int i = 0; i < result.length(); i++){
            if(result.charAt(i) == guess)
                count++;
        }
        if(count == 0)
            guessesLeft--;
        pattern = result;
        return count;
    }
}
