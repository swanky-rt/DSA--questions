import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MW {

    public int equalTeamSkills(List<Integer> TeamA, List<Integer> TeamB){
        long sumA = 0;
        long sumB = 0;

        int zerosA = 0;
        int zerosB = 0;

        for(int i=0; i<TeamA.size(); i++){
            if(TeamA.get(i)==0){
                zerosA++;
            }
            sumA+= TeamA.get(i);
        }
        for(int j=0; j<TeamB.size(); j++){
            if(TeamB.get(j)==0){
                zerosB++;
            }
            sumB += TeamB.get(j);
        }

        if(zerosA==0 && zerosB==0){
            return (sumA==sumB)?(int) sumA: -1;
        }
// Examples
//
//Already equal with zeros
//A = [5, 0] → sumA = 5, zerosA = 1 ⇒ baseA = 5 + 1 = 6
//B = [3, 0] → sumB = 3, zerosB = 1 ⇒ baseB = 3 + 1 = 4
//Minimum equal total must be ≥ 6 and ≥ 4 ⇒ at least 6.
//We can set B’s zero to 3 → B = 3 + 3 = 6. Answer = 6.
//
//One side must catch up (has a zero)
//A = [10] → baseA = 10 + 0 = 10
//B = [0] → baseB = 0 + 1 = 1
//Minimum equal total is at least 10. B has a zero, so raise that 1 to 9 → total 10. Answer = 10.
//
//Impossible (no zeros to adjust)
//A = [10] → baseA = 10
//B = [4, 5] → baseB = 9
//Final equal total must be ≥10 and ≥9 ⇒ at least 10, but B has no zeros to increase. Cannot reach 10 → -1.
//
//Both sides have many zeros
//A = [0, 0, 7] → baseA = 7 + 2 = 9
//B = [0, 4] → baseB = 4 + 1 = 5

        long baseA = sumA + zerosA;
        long baseB = sumB + zerosB;

        if(baseA==baseB){
            return (int) baseA;
        }
        else if(baseA>baseB){
            return (zerosB>0)? (int) baseA: -1;
        }
        else{
            return (zerosA>0)? (int) baseB: -1;
        }





    }
    public static void main(String args[]){

        MW mw = new MW();
        List<List<Integer>> teamAs = new ArrayList<>();
        teamAs.add(Arrays.asList(3, 4));                              // → 7
        teamAs.add(Arrays.asList(10));                                 // → -1
        teamAs.add(Arrays.asList(10));                                 // → 10
        teamAs.add(Arrays.asList(0, 5));                               // → 6
        teamAs.add(Arrays.asList(1000));                               // → 1000
        teamAs.add(Arrays.asList(7, 7));                               // → 14
        teamAs.add(Arrays.asList(5));                                  // → 5
        teamAs.add(Arrays.asList(5, 0));                               // → 6
        teamAs.add(Arrays.asList(0));                                  // → 1
        teamAs.add(Arrays.asList(0, 0, 7));                            // → 9
        teamAs.add(Arrays.asList(2, 0, 3));                            // → 6
        teamAs.add(Arrays.asList(10, 0));                              // → -1
        teamAs.add(Arrays.asList(8));                                  // → -1
        teamAs.add(Arrays.asList(1_000_000_000, 1_000_000_000));       // → 2000000000
        teamAs.add(Arrays.asList(1_000_000_000));                      // → 1000000000
        teamAs.add(Arrays.asList(1_000_000_000));                      // → -1
        teamAs.add(Arrays.asList(0, 0, 0));                            // → 3
        teamAs.add(Arrays.asList(0, 1, 0));                            // → 4
        teamAs.add(Arrays.asList(0, 0));                               // → 5
        teamAs.add(Arrays.asList(0));                                  // → 5

        List<List<Integer>> teamBs = new ArrayList<>();
        teamBs.add(Arrays.asList(2, 5));                               // 7
        teamBs.add(Arrays.asList(4, 5));                               // -1
        teamBs.add(Arrays.asList(0));                                // 10
        teamBs.add(Arrays.asList(6));                                  // 6
        teamBs.add(Arrays.asList(0, 0));                               // 1000
        teamBs.add(Arrays.asList(0));                                  // 14
        teamBs.add(Arrays.asList(0, 1));                               // 5
        teamBs.add(Arrays.asList(3, 0));                               // 6
        teamBs.add(Arrays.asList(0));                                  // 1
        teamBs.add(Arrays.asList(0, 4));                               // 9
        teamBs.add(Arrays.asList(1, 0, 4));                            // 6
        teamBs.add(Arrays.asList(9));                                  // -1
        teamBs.add(Arrays.asList(0, 7, 0, 0));                         // -1
        teamBs.add(Arrays.asList(0));                                  // 2000000000
        teamBs.add(Arrays.asList(1_000_000_000));                      // 1000000000
        teamBs.add(Arrays.asList(999_999_999));                        // -1
        teamBs.add(Arrays.asList(0, 0));                               // 3
        teamBs.add(Arrays.asList(0, 2, 0));                            // 4
        teamBs.add(Arrays.asList(5));                                  // 5
        teamBs.add(Arrays.asList(2, 3));                               // 5

        for (int i = 0; i < teamAs.size(); i++) {
            int result = mw.equalTeamSkills(teamAs.get(i), teamBs.get(i));
            System.out.println("Test " + (i + 1) + ": " + result);
        }
    }
}
