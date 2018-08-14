package com.ubs.opsit.interviews;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author Madan
 *
 */
public class BerlinClock implements  TimeConverter {
	int[] berlinTime;
	static BerlinClock clock = new BerlinClock();
	String  NEW_LINE = "\r\n";
	static String ENTER_INPUT = "Please enter the Time in HH:MM:SS  format";
	static String INCORRECT_INPUT = "Input is inValid, Plase enter the correct time\n";
	

public static void main(String[] args) {
	
	/*
	 * Take input from user at run time,
	 * please un- comments to process the input from User
	 */
	
	//inputFromUser();
	
	/*
	 * This is default call
	 */
	
	String  time = "12:00:40";
	
	System.out.println(clock.convertTime(time));
	
	
}
/**
 * This Method use to take the input time from user from cmd Line
 */
private static void inputFromUser() {
	Boolean correctInput = false;
	//String time = "00:00:00";
	System.out.println( ENTER_INPUT);
	Scanner sc = new Scanner(System.in);
	String time = sc.nextLine();
	while(!correctInput)
	if(clock.verifyInput(time)){
		correctInput = true;
	System.out.println(clock.convertTime(time));
	}else{
		System.out.println(INCORRECT_INPUT);
		time = sc.nextLine();
	}
}
	/* (non-Javadoc)
	 * @see com.ubs.opsit.interviews.TimeConverter#convertTime(java.lang.String)
	 * return the time  in required format  for example 
		Y
		RROO
		RROO
		OOOOOOOOOOO
		OOOO
		
	 */
	@Override
	public String convertTime(String aTime) {
		
		//process the Time and convert to String array 
		String[] time= clock.ProcessTime(aTime);
		
		StringBuffer sb = new StringBuffer();
		
		int length =time.length;
		for(int i=0;i<length-1; i++){
			sb.append(time[i]);
		    sb.append(NEW_LINE);
	}
	   sb.append(time[length-1]);
		return sb.toString();
	}

	
	/**
	 * @param time
	 * @return
	 *  convert the HH:MM:SS into below format  
		Y
		RROO
		RROO
		OOOOOOOOOOO
		OOOO
		
	 */
	private String[] ProcessTime(String time ) {
		berlinTime = Stream.of(time.split(":")).mapToInt(Integer::parseInt).toArray();
	    return new String[] {
	            TimeUtil.processSeconds(berlinTime[2]),
	            TimeUtil.processTopHours(berlinTime[0]),
	            TimeUtil.processBottomHours(berlinTime[0]),
	            TimeUtil.processTopMinutes(berlinTime[1]),
	            TimeUtil.processBottomMinutes(berlinTime[1])
	    };
	}
	
	/**
	 * @param time
	 * @return
	 */
	private  Boolean verifyInput(String time){
	berlinTime = Stream.of(time.split(":")).mapToInt(Integer::parseInt).toArray();
	
	if((berlinTime[0]>23||berlinTime[1]>59 ||berlinTime[2]>59))
		if(((berlinTime[0]==24 && berlinTime[1]==00 && berlinTime[2]==00)))
			return true;
		
			else return false; 
		return true;
	}
}
