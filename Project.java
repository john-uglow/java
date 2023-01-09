import java.util.Scanner;

public class Project {
	
    // Array for storing customer names
	
    static String[] names = new String[100];
    
    // Array for storing customer ID's
    
    static int[] id = new int[100];
    
    // Array for storing total sales
    
    static float[] sales = new float[100];

    static int index = 0;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		// Switch menu

        int exitLoop = 0;
        
        while (exitLoop != 1) {

          System.out.println("MENU");
          System.out.println("1: Add multiple new customers");
		  System.out.println("2: Add single new customer");
		  System.out.println("3: Display all customers");
		  System.out.println("4: Retrieve a specific customer's data");	
		  System.out.println("5: Retrieve customers with orders based on range");	
		  System.out.println("9: Exit program");
          System.out.println();
		  System.out.println("Enter your selection: ");
          String choice = input.nextLine();

          switch (choice) {
		
		    case "1":{
		      addMultiple();
			  System.out.println();
			  break;
		    }
		
     	    case "2":{
			  addSingle();
			  System.out.println();
		 	  break;
		    }
		
		    case "3":{
			  displayAll();
		      System.out.println();
		      break;
		    }
		    
		    case "4":{
			  displaySingle();
		      System.out.println();
		      break;
		    }
		    
		    case "5":{
			  displayRange();
		      System.out.println();
		      break;
		    }

            case "9":{
              exitLoop = 1;
              System.out.println("Thanks for using the program!");
              break;
            }

          }

        }

        input.close();
	
	}
	
    // Method to add multiple customers

    public static void addMultiple() {
    	
        Scanner input = new Scanner(System.in);
        
        //Get number of customers to be added from user
        
        System.out.println("How many customers do you want to add?: ");
        int customers = input.nextInt();
        String newLine = input.nextLine(); 
        
        //Add customers
        
        int count;
        for (count=index; count<(index+customers); count++ ) { 

            System.out.println("Enter customer name:");
            names[count] = input.nextLine();

            System.out.println("Enter customer id:");
            id[count] = input.nextInt();
            newLine = input.nextLine();
            
            System.out.println("Enter total sales");
            sales[count] = input.nextFloat();
            newLine = input.nextLine();

        }

        index = count;
                
        return;
        
    }
	
    // Method to add a single customer

    public static void addSingle() {
    	    	
		Scanner input = new Scanner(System.in);
        
		// Add new customer data from user to arrays
		
        System.out.println("Enter customer name:");
        names[index] = input.nextLine();

        System.out.println("Enter customer id:");
        id[index] = input.nextInt();        
            
        System.out.println("Enter total sales");
        sales[index] = input.nextFloat();
        
        index++;
        
        return;
    }
    
    // Method to display all customers' data

    public static void displayAll() {
        
        for (int count=0; count<index; count++ ) {      

            System.out.println("Name: " + names[count] + " ID: "+ id[count] + " Total Sales: " + sales[count]);
        }
        
        return;
    }
    
    // Method to retrieve a specific customer's data based on customer ID input by the user

    public static void displaySingle() {
    	
		Scanner input = new Scanner(System.in);
    	
		int displayId = 0;
		
		// Get customer id from user
		
        System.out.println("Enter customer id:");
    	int getId = input.nextInt();
        String newLine = input.nextLine();

        // For loop to find the matching customer ID
        
    	for (int i = 0; i < id.length; i++ ) {
    		if (id[i] == getId) {displayId = i;}
    	}
    	
    	// Display data of matching customer ID
    	
        System.out.println("Name: " + names[displayId] + " ID: "+ id[displayId] + " Total Sales: " + sales[displayId]);
    	
    	return;
        
    }
    
    // Method to retrieve and display all data for customers with sales in a range input by the user
    
    public static void displayRange() {
    	
        Scanner input = new Scanner(System.in);
        
        // Get low end of range from user
        
        System.out.println("Enter lowest sales of range:");
    	float lowest = input.nextFloat();
    	
    	// Get high end of range from user
    	
        System.out.println("Enter highest sales of range:");
    	float highest = input.nextFloat();
        
    	// Find sales within the range and display data for those customers
    	
    	for (int i = 0; i < sales.length; i++ ) {
    		if (sales[i] >= lowest && sales[i] <= highest) {System.out.println("Name: " + names[i] + " ID: "+ id[i] + " Total Sales: " + sales[i]);
    		}
    	}
        
        return;
    }
    	
}
