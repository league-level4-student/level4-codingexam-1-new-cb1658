package scheduler;



import java.util.HashMap;
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
    	
    	Scheduler scheduler = new Scheduler();
    	
    	scheduler.add();
    	
    }
    
    
    public void add() {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Which day do you want to add things to? (Mon, Tue, Wed, Thu, Fri)");
    	
    	String a = sc.nextLine();
    	
    	switch(a) {
    		
    	case "Mon":
    		triviaQuestion(0);
    	break;
    		
    	
    	case "Tue":
    		triviaQuestion(1);
    	break;
    	
    	
    	case "Wed":
    		triviaQuestion(2);
    	break;
    	
    	
    	case "Thu":
    		triviaQuestion(3);
    	break;
    	
    	
    	case "Fri":
    		triviaQuestion(4);
    	break;
    	
    	}
    	
    	
    	
    	
    }
    
    public void attemptAddToSchedule(Integer num, String time, String addThis) throws SchedulingConflictException{
    	// time would be a key in the hashmap
    	if(days[num].schedule.containsKey(Integer.parseInt(time))) {
    		throw new SchedulingConflictException();
    	}
    	else {
    		days[num].schedule.put(Integer.parseInt(time), addThis);
    	}
    }
    
    public void triviaQuestion(Integer num) {
    	Scanner sc = new Scanner(System.in);
    	
		System.out.println("Enter what time you want (1-24)");
		String time = sc.nextLine();
		
		System.out.println("Enter what you want to add (anything)");
		String addThis = sc.nextLine();
		
		String[] arr = new String[2];
		arr[0] = time;
		arr[1] = addThis;
		
		try {
			attemptAddToSchedule(num, time,addThis);
		}catch(SchedulingConflictException e) {
			System.out.println("You double booked on " + days[num] + " at " + time);
			
			
		}
	}
}
