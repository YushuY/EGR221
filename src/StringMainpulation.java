import java.util.*;

public class StringMainpulation {
   String myString;
    public StringMainpulation(){
    }

    public void setMyString(String newString){
        this.myString = newString;
    }

    public String hold(){
        return myString;
    }

    public void reverse(){
        for(int i = myString.length() - 1; i >= 0; i --){
            System.out.print(myString.charAt(i));
        }
    }

    public void decimates(){
        for(int i = 0; i < myString.length(); i ++){
            if((i+1)/5 == 1){
                System.out.print(" ");
            }else{
                System.out.print(myString.charAt(i));
            }
        }
    }


}
