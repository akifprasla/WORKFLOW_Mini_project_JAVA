package eecs2011.project;

import java.util.Scanner;

public class Helper_schedule_1 {

	private int[][] workflow;
	private int numofFunc;
	private Stack<Integer> stack;

	public Helper_schedule_1() {
		stack = new Stack<Integer>();
	}

//=================method to accept input=====================================
	void acceptInput() {

		Scanner input = new Scanner(System.in);
		numofFunc = input.nextInt(); // number of functions
		workflow = new int[numofFunc + 2][numofFunc + 2]; // workflow graph
		int[] rt = new int[numofFunc]; // response time of functions
		for (int i = 0; i < numofFunc + 2; i++) {
			for (int j = 0; j < numofFunc + 2; j++) {
				workflow[i][j] = input.nextInt(); // read workflow graph from standard input
			}
		}

		for (int i = 0; i < numofFunc; i++) {
			rt[i] = input.nextInt(); // read response time from standard input
		}
		input.close();

		int[] schedule;

		schedule = scheduler(workflow, 0);

		int sum = 0;
		for (int i = schedule.length - 1; i > 1; i--) {
			if (schedule[i] != 0) {
				System.out.print(schedule[i] + " ");
				System.out.println(sum);
				sum = sum + (rt[schedule[i] - 1]);
			}
		}
		System.out.println(sum);
	}

	
	public int[] scheduler(int workflow[][], int source) throws NullPointerException {

		int number_of_funct = workflow[source].length - 1;
		int[] schedule = new int[number_of_funct + 2];
		int pos = 1;
		int pop;
		int visited[] = new int[number_of_funct + 1];
		int elem = source;
		int i = source;
		visited[source] = 1;

		stack.push(source);

		while (!stack.isEmpty()) {
			elem = stack.peek();
			while (i <= number_of_funct) {
				if (workflow[elem][i] == 1 && visited[i] == 1) {
					if (stack.contains(i)) {
						return null;
					}
				}
				if (workflow[elem][i] == 1 && visited[i] == 0) {
					stack.push(i);
					visited[i] = 1;
					elem = i;
					i = 1;
					continue;
				}
				i++;
			}
			pop = stack.pop();
			schedule[pos++] = pop;
			i = ++pop;
		}
		return schedule;
	}

}
