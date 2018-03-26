public class fibonacci {
    public int fibonacci (int n){
        if (n <= 1){
            return n;
        } else{
            return fibonacci (n-1)+ fibonacci (n-2);
        }
    }

    public  static void main(String args[]){

        fibonacci f= new fibonacci ();
        System.out.println(f.fibonacci (5));
        System.out.println(f.fibonacci (7));
        System.out.println(f.fibonacci (14));
    }

}

