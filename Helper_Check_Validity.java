package eecs2011.project;


import java.util.Scanner;


public class Helper_Check_Validity {
	
// attributes	
	private Stack<Integer> stack;  	//for checking cycle
	private Queue<Integer> queue;	//for checking connectivity
    private int[][] workflow;
    private int numofFunc;
    
//constructors    
    public Helper_Check_Validity() 
    {
        stack = new Stack<Integer>();
        queue = new Queue<Integer>();
    }
    
// method to accept input    
    void acceptInput(){
		
		 Scanner input = new Scanner(System.in);
		    numofFunc = input.nextInt(); // number of functions
	        workflow = new int[numofFunc + 2][numofFunc + 2]; // workflow graph
	        int[] rt = new int[numofFunc]; // response time of functions
	        for (int i = 0; i < numofFunc + 2; i++) {
	            for (int j = 0; j < numofFunc + 2; j++) {
	                workflow[i][j] = input.nextInt();  // read workflow graph from standard input
	            	}
	            }
     
	        for (int i = 0; i < numofFunc; i++) {
	            rt[i] = input.nextInt(); // read response time from standard input
	        }
	        input.close();	
	       
	       boolean checkLoop = checkLoop(workflow);
	       boolean checkCycle = checkCycle(workflow,0);
	       boolean checkDisconnected = checkDisconnected(workflow,0);
	      
	       if(!checkLoop&&!checkCycle&&!checkDisconnected) {
	    	   System.out.println("True");
	       }else {
	    	   System.out.println("False");
	       }
    }
    
    
    
    public boolean checkLoop(int [][] workflow) {
    	
    	for(int i = 1, j =1 ; i<workflow.length-1;i++,j++) {
    			if(workflow[i][j]==1) {
    				return true;
    			}
    		}
      	return false;
    }
    
    public boolean checkCycle(int adjacency_matrix[][], int source){
    	
        int number_of_nodes = adjacency_matrix[source].length - 1;
        int[] topological_sort = new int [number_of_nodes + 2];
        int pos = 1;
        int j;
        boolean cycle = false;
 
 
        int visited[] = new int[number_of_nodes + 1];
        int element = source;
        int i = source;
        visited[source] = 1;
        stack.push(source);
 
 
        while (!stack.isEmpty())
        {
            element = stack.peek();
            while (i <= number_of_nodes)
            {
                if (adjacency_matrix[element][i] == 1 && visited[i] == 1)
                {
                    if (stack.contains(i))
                    {
                      //  System.out.println("The Graph Contains a cycle");
                        cycle = true; 
                        return cycle;
                    }
                }
                if (adjacency_matrix[element][i] == 1 && visited[i] == 0)
                {
                    stack.push(i);
                    visited[i] = 1;
                    element = i;
                    i = 1;
                    continue;
                }
                i++;
            }
            j = stack.pop();	
            topological_sort[pos++] = j;
            i = ++j;
        }
    //    System.out.println("The Graph does not Contain cycle");
        return cycle;
    }	
    
   
    public boolean checkDisconnected(int adjacency_matrix[][], int source)
    {
        int number_of_nodes = adjacency_matrix[source].length - 1;
        int[] visited = new int[number_of_nodes + 1];
        int i, element;
        visited[source] = 1;
        queue.enqueue(source);
 
        while (!queue.isEmpty())
        {
            element = queue.dequeue();
            i = element;
           while (i <= number_of_nodes)
           {
               if (adjacency_matrix[element][i] == 1 && visited[i] == 0)
               {
                   queue.enqueue(i);
                   visited[i] = 1;
               }
               i++;
           }
        }
        boolean connected = false; 
 
        for (int vertex = 1; vertex <= number_of_nodes; vertex++)
        {
            if (visited[vertex] == 1)
            {
                connected = true;
            } else
            { 
                connected = false;
                break;
            }
        }
 
        if (connected)
        {
          //  System.out.println("The graph is connected");
            return false;		//returning false so that the condition checking above works as required 
        } else
        {
          //  System.out.println("The graph is disconnected");
            return true;
        }
    } 
 
    
	
}
