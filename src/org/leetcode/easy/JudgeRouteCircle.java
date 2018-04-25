package org.leetcode.easy;

public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        int count1 = 0, count2 = 0;
        for(int i = 0; i < moves.length(); i++) {
            switch(moves.charAt(i)) {
            case 'U' : count1++; break;
            case 'D' : count1--; break;
            case 'L' : count2++; break;
            case 'R' : count2--; break;
            }
        }
        if(count1 == 0 && count2 == 0) return true;
        return false;
    }
}
