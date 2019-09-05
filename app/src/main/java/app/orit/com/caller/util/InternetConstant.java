package app.orit.com.caller.util;

/**
 * Created by Joseph on 8/21/2019.
 */

public class InternetConstant {

    public static final String INTERNET_HEADER = Config.HEADER+"1*1*1*";
    public static  final String INTERNET_DAILY_HEADER = INTERNET_HEADER+"1*";


    // Daily Internet

    public static final String DAILY25MB   = INTERNET_DAILY_HEADER + "1*1#";
    public static final String DAILY45MB   = INTERNET_DAILY_HEADER + "2*1#";
    public static final String DAILY100MB  = INTERNET_DAILY_HEADER + "3*1#";
    public static final String DAILY200MB  = INTERNET_DAILY_HEADER + "4*1#";
    public static final String DAILY500MB  = INTERNET_DAILY_HEADER + "5*1#";

    //  internet week

    public static  final String INTERNET_WEEKLY_HEADER = INTERNET_HEADER+"2*";
    public static final String WEEKLY250MB = INTERNET_WEEKLY_HEADER  + "1*1#";
    public static final String WEEKLY500MB = INTERNET_WEEKLY_HEADER  + "2*1#";
    public static final String WEEKLY700MB = INTERNET_WEEKLY_HEADER  + "3*1#";
    public static final String WEEKLY1GB   = INTERNET_WEEKLY_HEADER  + "4*1#";

    public static  final String INTERNET_MONTHLY_HEADER = INTERNET_HEADER+"3*";

    // Monthly

    public static final String  MONTHLY500MB = INTERNET_MONTHLY_HEADER + "1*1#";
    public static final String  MONTHLY1GB   = INTERNET_MONTHLY_HEADER + "2*1#";
    public static final String  MONTHLY2GB   = INTERNET_MONTHLY_HEADER + "3*1#";
    public static final String  MONTHLY4GB   = INTERNET_MONTHLY_HEADER + "4*1#";
    public static final String  MONTHLY8GB   = INTERNET_MONTHLY_HEADER + "5*1#";
    public static final String  MONTHLY10GB  = INTERNET_MONTHLY_HEADER + "6*1#";
    public static final String  MONTHLY20GB  = INTERNET_MONTHLY_HEADER + "7*1#";
    public static final String  MONTHLY30GB  = INTERNET_MONTHLY_HEADER + "8*1#";

    public static  final String INTERNET_NIGHT_HEADER = INTERNET_HEADER+"4*";

    // Night

    public static final String  NIGHT50MB    = INTERNET_NIGHT_HEADER + "1*1#";
    public static final String  NIGHT100MB   = INTERNET_NIGHT_HEADER + "2*1#";
    public static final String  NIGHT160MB   = INTERNET_NIGHT_HEADER + "3*1#";

    public static final  String WEEKEND500MB = " ";
    public static final  String WEEKEND1GB = " ";
    public static final  String WEEKEND2GB = " ";

    public static  final  String PREMIUM1WKINTERNET = "";
    public static  final  String PREMIUMI2WKNTERNET = "";
    public static  final  String PREMIUM1MONINTERNET = "";

}
