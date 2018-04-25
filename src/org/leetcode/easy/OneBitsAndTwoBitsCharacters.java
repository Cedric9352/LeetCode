package org.leetcode.easy;

public class OneBitsAndTwoBitsCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        int index = 0;
        //the rest number of bits is 1 or 2
        while(index < bits.length - 2) {
            if(bits[index] == 0)
                index++;
            else
                index += 2;
        }
        if(bits[index] == 0)
            return true;
        else
            return false;
    }
}
