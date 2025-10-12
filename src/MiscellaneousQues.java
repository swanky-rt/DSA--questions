public class MiscellaneousQues {
    //Fibanocci series

    // iterative way
    public void fibonacciSeries(int n){
        int a =0;
        int b = 1;
        for(int i=0; i<n; i++){
            System.out.println(a);
            int c = a+b;
            a = b;
            b = c;
        }
    }

    // recursive way

    public int fibonacciSeriesRecursive(int n){
        if(n<=1){
            return n;
        }
        return fibonacciSeriesRecursive(n-1) + fibonacciSeriesRecursive(n-2);
    }

    // dynamic array

    public int dynamicFibnacciSeries(int n){
        int [] f = new int[n+2];
        f[0] = 0;
        f[1] = 1;

        for(int i=2; i<=n; i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    public static void main(String args[]){
        int n = 10;
        MiscellaneousQues miscellaneousQues = new MiscellaneousQues();
        //miscellaneousQues.fibonacciSeries(n);

//        for(int i=0; i<n; i++){
//            System.out.println(miscellaneousQues.fibonacciSeriesRecursive(i));
//        }

        for(int i=0; i<n; i++){
            System.out.println(miscellaneousQues.dynamicFibnacciSeries(i));
        }
    }
}
