package com.ubs.opsit.interviews;

/**
 * @author Madan
 *
 */
public class TimeUtil {

	
/**
 * @param berlinHours
 * @return
 */
public static String processTopHours(int  berlinHours){
	return getOnOff(4, getTopTimeON(berlinHours));
	
	
}

/**
 * @param berlinHours
 * @return
 */
public static  String processBottomHours(int  berlinHours){
	  return getOnOff(4, berlinHours % 5);
	
	
}

/**
 * @param berlinMunutes
 * @return
 */
public static  String processTopMinutes(int  berlinMunutes){
	 return getOnOff(11, getTopTimeON(berlinMunutes), "Y").replaceAll("YYY", "YYR");
	
	
}

/**
 * @param berlinMunutes
 * @return
 */
public static String processBottomMinutes(int  berlinMunutes){
	return getOnOff(4, berlinMunutes % 5, "Y");
	
	
}

/**
 * @param berlinSec
 * @return
 */
public static String processSeconds(int  berlinSec){
	 if (berlinSec % 2 == 0) return "Y";
     else return "O";
	
}

/**
 * @param time
 * @return
 */
private static int getTopTimeON(int time) {
    return (time - (time % 5)) / 5;
}


/**
 * @param lamps
 * @param onSigns
 * @return
 */
private static String getOnOff(int lamps, int onSigns) {
    return getOnOff(lamps, onSigns, "R");
}

/**
 * @param lamps
 * @param onSigns
 * @param onSign
 * @return
 */
private static String getOnOff(int lamps, int onSigns, String onSign) {
    String out = "";
    for (int i = 0; i < onSigns; i++) {
        out += onSign;
    }
    for (int i = 0; i < (lamps - onSigns); i++) {
        out += "O";
    }
    return out;
}


}



