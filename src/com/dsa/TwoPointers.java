package com.dsa;

import java.util.*;

public class TwoPointers {
	
	public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int l = 0;
        int r = tokens.length - 1;
        int score = 0;

        while (l <= r) {
            if (power >= tokens[l]) {
                score++;
                power -= tokens[l];
                l++;
            } else if (power < tokens[l] && score > 0) {
                score--;
                power += tokens[r];
                r--;
            } else {
                return score;
            }
        }
        return score;
    }

	public static void main(String[] args) {
		TwoPointers twoPointers =  new TwoPointers();
		int[] tokens = {200,100};
		int power = 150;
		twoPointers.bagOfTokensScore(tokens, power);

	}

}
