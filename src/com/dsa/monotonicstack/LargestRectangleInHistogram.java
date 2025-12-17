package com.dsa.monotonicstack;

import java.util.Stack;

public class LargestRectangleInHistogram {

	public int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;
		int n = heights.length;

		for (int i = 0; i <= n; i++) {
			int currentHeight = (i == n) ? 0 : heights[i];

			while (!stack.isEmpty() && heights[stack.peek()] > currentHeight) {
				int height = heights[stack.pop()];
				int width = stack.isEmpty() ? i : i - stack.peek() - 1;
				maxArea = Math.max(maxArea, height * width);
			}

			stack.push(i);
		}
		return maxArea;
	}

	public static void main(String[] args) {
		LargestRectangleInHistogram histogram = new LargestRectangleInHistogram();
		int[] heights = { 2, 1, 5, 6, 2, 3 };
		histogram.largestRectangleArea(heights);

	}

}
