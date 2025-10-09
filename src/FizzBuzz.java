public class FizzBuzz {

    //iterative fizzBuzz - if multiple of 3-> Fizz, multiple of 5 -> Buzz and if both -> FizzBuzz

    public static void normalFizzBuzz(int n){
        for(int i=0; i<n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    // use recursive way to print Fizz Buzz

    public static void recursiveFizzBuzz(int current, int n){
        if(current>n){
            return;
        }
        if (current % 3 == 0 && current % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (current % 3 == 0) {
            System.out.println("Fizz");
        } else if (current % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(current);
        }

        recursiveFizzBuzz(current+1, n);
    }

    public static void main(String args[]){
        System.out.println("iterative way");
        normalFizzBuzz(20);

        System.out.println("recursive way");

        recursiveFizzBuzz(0, 20);
    }
}
