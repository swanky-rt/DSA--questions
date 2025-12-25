public class solveInterestingQuestions {

    public boolean checkIfPower2(int n){
        if(n>0 && (n & (n-1)) == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public int powerOf2(int n){
        int result = -1;
        int count =0;

        if(checkIfPower2(n)){
            while(result != 1){
                result = n/2;
                count = count+1;
                n = result;
            }
        }
        return count;
    }

    public static void main(String args[]){
        solveInterestingQuestions s = new solveInterestingQuestions();
        System.out.println(s.checkIfPower2(8));
        System.out.println(s.powerOf2(8));
    }
}
