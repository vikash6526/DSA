package com.dsa.monotonicstack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
	public int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];
		Stack<Integer> stack = new Stack<Integer>();
		Arrays.fill(result, -1);

		for (int i = 0; i < n * 2; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
				result[stack.pop()] = nums[i % n];
			}
			if (i < n) {
				stack.push(i);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		NextGreaterElementII greaterElementII = new NextGreaterElementII();
		int[] nums = { 1, 2, 1 };
		greaterElementII.nextGreaterElements(nums);

	}

}
