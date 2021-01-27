package eecs2011.project;


public class Solution {

	 /**
     * Solution to Part 1
     */
    public void check_validity() {
    	
    	Helper_Check_Validity help = new Helper_Check_Validity();
	    help.acceptInput();
	    
    }

    /**
     * Solution Part 2
     */
    public void schedule_1() {
    	Helper_schedule_1 help = new Helper_schedule_1();
	    help.acceptInput();	
    }

    /**
     * Solution to Part 3
     */
    
    public void schedule_x() {
        ; // read from standard input
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // number of functions
        int[][] matrix = new int[n + 2][n + 2]; // workflow graph
        int[] responseTime = new int[n]; // response time of functions
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++)
                matrix[i][j] = input.nextInt(); // read workflow graph from standard input
        }
        for (int i = 0; i < n; i++) {
            responseTime[i] = input.nextInt(); // read response time from standard input
        }
        input.close();

        ; // do something

        LinkedList[] graph = GraphConstruction.ConstructGraph(matrix);

        GraphTraversal g = new GraphTraversal(graph,0);

        LinkedList scheduleList = g.getScheduleList();


        int[] availability_time = new int[graph.length];

        int[] endTime = new int[graph.length - 2];

        Iterator<Integer> itr = scheduleList.iterator();
        itr.next();



        while(itr.hasNext()){
            int current_function = itr.next();

            if(itr.hasNext()){

                endTime[current_function-1] = availability_time[current_function] + responseTime[current_function-1];

                for(int w : graph[current_function]) {

                    if(endTime[current_function - 1] > availability_time[w]){
                        availability_time[w] = endTime[current_function - 1];
                    }
                }

            }

        }

        ; // write your answer to standard output

        for(int i = 1; i < availability_time.length-1; i++)
            System.out.println(i + " " + availability_time[i]);
        System.out.println(availability_time[graph.length-1]);


    }

}
