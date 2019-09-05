package app.orit.com.caller.util;

/**
 * Created by Joseph on 8/21/2019.
 */

public class SMSConstant {

    public static  final String SMS_HEADER = Config.HEADER+"1*1*1*";

    public static  final String SMS_DAILY_HEADER = SMS_HEADER+"1*";

    public static  final String DAILY18SMS  = SMS_DAILY_HEADER + "1*1#";
    public static  final String DAILY35SMS  = SMS_DAILY_HEADER + "2*1#";
    public static  final String DAILY70SMS  = SMS_DAILY_HEADER + "3*1#";


    public static final String SMS_WEEKLY_HEADER = SMS_HEADER + "2*";

    public static  final String WEEKLY140SMS = SMS_WEEKLY_HEADER + "1*1#";
    public static  final String WEEKLY283SMS = SMS_WEEKLY_HEADER + "2*1#";

    public static final String SMS_MONTHLY_HEADER = "3*";

    public static final  String  MONTHLY525SMS = SMS_MONTHLY_HEADER   +  "1*1#";
    public static final  String  MONTHLY1050SMS = SMS_MONTHLY_HEADER  + "2*1#";


}
