package bronze;

import java.util.Arrays;
import java.util.HashMap;

public class Problem2_2020 {
    public static void main(String[] args) {
        int[] position = {7,1,15,3,10,6};
        int[] isInfected = {1,1,1,1,0,1};
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i=0;i<position.length;i++){
            hm.put(position[i],isInfected[i]);
        }

        int maxR = findMaxR(hm, position);
        System.out.println("maxR = " + maxR);
        System.out.println(numOfInitInfected(position, hm,maxR));
    }

    static int findMaxR(HashMap<Integer,Integer> hm, int[] position){
        Arrays.sort(position);
        int maxR = position[position.length-1];
        for (int i=0; i<position.length; i++){
            if(hm.get(position[i]) == 0){
                int smallerDistance = Math.max(position[i] - position[i-1],position[i-1] - position[i]);
                if(maxR > smallerDistance)
                    maxR = smallerDistance - 1;
            }
        }
        return maxR;
    }

    static int numOfInitInfected(int[] position, HashMap<Integer,Integer> hm, int maxR){
        int leftMostInfectedIndex = position.length -1;
        int numInitInfected = 0;
        for(int i=0; i<position.length; i++){
            if(hm.get(position[i]) == 1){
                leftMostInfectedIndex = i;
                break;
            }
        }
        for(int item : position){
            System.out.print("\n position =" + item + " ");
        }

        for (int i=leftMostInfectedIndex; i<position.length -1; i++){
            if(position[i+1] == 0) break;
            if(position[i+1]-position[i] > maxR){
                System.out.println("index :" + i);
                numInitInfected++;
            }
        }

        return numInitInfected;
    }
}
