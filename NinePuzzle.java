//Siraj Mughal

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class NinePuzzle {

	public static void main(String[] args) {
		int counterr = 0;
		
		boolean[] visited = new boolean[999999999];
		Queue<State> toExplore = new LinkedList<State>();
		ArrayDeque<State> soln = new ArrayDeque<State>();
		boolean b = false;
		
		Scanner scan = new Scanner(System.in);
		String seq = scan.nextLine();
		State start = new State(seq);
		
		toExplore.add(start);
		
		int startVal = Integer.parseInt(start.seq);
		visited[startVal] = true;
		
		while (! toExplore.isEmpty()) {
			State next = toExplore.remove();
			int idx = next.seq.indexOf("9");
			
			if (next.seq.compareTo("123456789") == 0) {
				b = true;
				for (State x = next; x != null; x = x.prev) {
					soln.offerLast(x);
				}
					State s = soln.pollLast();
					
					while(s != null) {
						counterr+= 1;
						s.display();
						s = soln.pollLast();
						}
					break;
				}
													  										  								
			for (int i = 0; i < 9; i++) {
				
				if (i == idx)
					continue;
				
				State p = next.move(i, idx);
	
				if (! p.legal())
					continue;
	
				int val = Integer.parseInt(p.seq);
				if (visited[val])
					continue;
				
				toExplore.add(p);
				visited[val] = true;
			}
		}
		if (! b)
			System.out.println("-1");	
		
		System.out.println(counterr);
	}

}
