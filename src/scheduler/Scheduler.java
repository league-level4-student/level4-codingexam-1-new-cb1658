package scheduler;



import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/*
 * Objective: Create a weekly scheduling application.
 * 
 * You may create any additional enums, classes, methods or variables needed
 * to accomplish the requirements below:
 * 
 * - You should use an array filled with enums for the days of the week and each
 *   enum should contain a LinkedList of events that includes a time and what is 
 *   happening at the event.
 * 
 * - The user should be able to to interact with your application through the
 *   console and have the option to add events, view events or remove events by
 *   day.
 *   
 * - Each day's events should be sorted by chronological order.
 *  
 * - If the user tries to add an event on the same day and time as another event
 *   throw a SchedulingConflictException(created by you) that tells the user
 *   they tried to double book a time slot.
 *   
 * - Make sure any enums or classes you create have properly encapsulated member
 *   variables.
 */

public class Scheduler {
	
	

	DaysOfTheWeek [] days = DaysOfTheWeek.values(); 
	
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	Scheduler scheduler = new Scheduler();
    	
    	boolean continue_ = true;
    	
    	
    	
    	do {
    		
    		
    		
    		System.out.println("What do you want to do with your schedule? (Add, Remove, View, Quit)");
    		
    		
    		
    		
    		String option = sc.nextLine();
    		
    		
    		
    		
    		switch(option) {
    		
    		case "Add":
    			scheduler.add(sc);
    			break;
    			
    		case "Remove":
    			scheduler.remove(sc);
    			break;
    			
    		case "View":
    			scheduler.view();
    			break;
    			
    		case "Quit":
    			continue_ = false;
    			
    			break;
    			
    		default:
    			System.out.println("What you entered was gibberish, " + option);
    		}

    		
    		
    	}while(continue_);
    	
    	sc.close();
    	
    }
    
    
    public void add(Scanner sc) {
    	
    	
    	System.out.println("Which day do you want to add things to? (Mon, Tue, Wed, Thu, Fri)");
    	
    	String a = sc.nextLine();
    	
    	switch(a) {
    		
    	case "Mon":
    		addPrompting(0,sc);
    	break;
    		
    	
    	case "Tue":
    		addPrompting(1,sc);
    	break;
    	
    	
    	case "Wed":
    		addPrompting(2,sc);
    	break;
    	
    	
    	case "Thu":
    		addPrompting(3,sc);
    	break;
    	
    	
    	case "Fri":
    		addPrompting(4,sc);
    	break;
    	
    	}
    	
    	
    	
    	
    }
    
    public void attemptAddToSchedule(Integer day, String time, String addThis) throws SchedulingErrorException{
    	// time would be a key in the hashmap
    	if(days[day].schedule.containsKey(Integer.parseInt(time))) {
    		throw new SchedulingErrorException();
    	}
    	else {
    		days[day].schedule.put(Integer.parseInt(time), addThis);
    	}
    }
    
    public void addPrompting(Integer day, Scanner sc) {
    	
		System.out.println("Enter what time you want (0-23)");
		String time = sc.nextLine();
		
		System.out.println("Enter what you want to add (anything)");
		String addThis = sc.nextLine();
		
		String[] arr = new String[2];
		arr[0] = time;
		arr[1] = addThis;
		
		try {
			attemptAddToSchedule(day, time,addThis);
		}catch(SchedulingErrorException e) {
			System.out.println("You double booked on " + days[day] + " at " + time);
			
			
		}
	}
    
    
    public void view() {
    	
    	for(DaysOfTheWeek day: days) {
    		for(Entry<Integer, String> e : day.schedule.entrySet()) {
        		System.out.println("You have " + e.getValue() + " at " + e.getKey() + " on " + day);
        	}
    	}
    }
    
    public void remove(Scanner sc) {
    	
    	
    	System.out.println("Which day do you want to remove activities from? (Mon, Tue, Wed, Thu, Fri)");
    	
    	String a = sc.nextLine();
    	
    	switch(a) {
    		
    	case "Mon":
    		removePrompting(0,sc);
    	break;
    		
    	
    	case "Tue":
    		removePrompting(1,sc);
    	break;
    	
    	
    	case "Wed":
    		removePrompting(2,sc);
    	break;
    	
    	
    	case "Thu":
    		removePrompting(3,sc);
    	break;
    	
    	
    	case "Fri":
    		removePrompting(4,sc);
    	break;
    	
    	}
    	
    	
    }
    
    public void attemptToRemoveFromSchedule(Integer day, String time) throws SchedulingErrorException{
    	// time would be a key in the hashmap
    	if(!days[day].schedule.containsKey(Integer.parseInt(time))) {
    		throw new SchedulingErrorException();
    	}
    	else {
    		days[day].schedule.remove(Integer.parseInt(time));
    	}
    }
    
    public void removePrompting(Integer day, Scanner sc) {
    	
    	
    	
    	System.out.println("Enter what time you want to remove from (0-23)");
		String time = sc.nextLine();
		
		
		try {
			attemptToRemoveFromSchedule(day, time);
		}catch(SchedulingErrorException e) {
			System.out.println("You tried to remove something from " + days[day] + " at " + time);
			
		}
		
		
    }
}
