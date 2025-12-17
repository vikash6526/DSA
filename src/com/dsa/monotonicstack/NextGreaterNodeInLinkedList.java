package com.dsa.monotonicstack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.dsa.ListNode;

public class NextGreaterNodeInLinkedList {
	public int[] nextLargerNodes(ListNode head) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> list = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();

		ListNode current = head;
		int index = 0;
		while (current != null) {
			list.add(current.val);
			while (!stack.isEmpty() && list.get(stack.peek()) < current.val) {
				map.put(stack.pop(), current.val);
			}
			stack.push(index++);
			current = current.next;
		}
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = map.get(i) != null ? map.get(i) : 0;
		}
		return result;
	}

	public static void main(String[] args) {
		ListNode listNode = new ListNode(2);
		listNode.next = new ListNode(1);
		listNode.next.next = new ListNode(5);

		NextGreaterNodeInLinkedList greaterNodeInLinkedList = new NextGreaterNodeInLinkedList();
		greaterNodeInLinkedList.nextLargerNodes(listNode);

	}

}
