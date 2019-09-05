package app.orit.com.caller.util;

/**
 * Created by Joseph on 8/21/2019.
 */

public class VoiceConstant {



    public static  final String VOICEHEADER = Config.HEADER+"1*1*1*";

    public static  final String VOICE_NIGHT_HEADER = VOICEHEADER+"1*";

    public static final String NIGHT30MIN= VOICE_NIGHT_HEADER   +  "1*1#";
    public static final String NIGHT60MIN= VOICE_NIGHT_HEADER   +  "2*1#";
    public static final String NIGHT120MIN=VOICE_NIGHT_HEADER   +   "3*1#";
    public static final String NIGHT420MIN= VOICE_NIGHT_HEADER  +   "4*1#";



    public static final String VOICE_DAILY_HEADER = VOICEHEADER    +    "2*";
    public static final String DAILY8MIN     = VOICE_DAILY_HEADER  +    "1*1#";
    public static final String DAILY13MIN    = VOICE_DAILY_HEADER  +    "2*1#";
    public static final String DAILY28MIN    = VOICE_DAILY_HEADER  +    "3*1#";


    public static final String VOICE_WEEKLY_HEADER = VOICEHEADER+"3*";

    public static final String WEEKLY46MIN    = VOICE_WEEKLY_HEADER  + "1*1#";
    public static final String WEEKLY65MIN    = VOICE_WEEKLY_HEADER  + "2*1#";
    public static final String WEEKLY100MIN   = VOICE_WEEKLY_HEADER  + "3*1#";


    public static final String VOICE_MONTHLY_HEADER = VOICEHEADER +    "4";
    public static final String MONTHLY100MIN  = VOICE_MONTHLY_HEADER + "1*1#";
    public static final String MONTHLY166MIN  = VOICE_MONTHLY_HEADER + "2*1#";
    public static final String MONTHLY280MIN  = VOICE_MONTHLY_HEADER + "3*1#";
    public static final String MONTHLY415MIN  = VOICE_MONTHLY_HEADER + "4*1#";
    public static final String MONTHLY450MIN  = VOICE_MONTHLY_HEADER + "5*1#";

    public static final String MONTHLY600MIN  = VOICE_MONTHLY_HEADER + "6*1#";
    public static final String MONTHLY750MIN  = VOICE_MONTHLY_HEADER + "7*1#";
    public static final String MONTHLY830MIN  = VOICE_MONTHLY_HEADER + "8*1#";
    public static final String MONTHLY930MIN  = VOICE_MONTHLY_HEADER + "9*1#";
    public static final String MONTHLY1080MIN = VOICE_MONTHLY_HEADER + "10*1#";

    public static final String MONTHLY1230MIN = VOICE_MONTHLY_HEADER + "11*1#";
    public static final String MONTHLY1380MIN = VOICE_MONTHLY_HEADER + "12*1#";
    public static final String MONTHLY1545MIN = VOICE_MONTHLY_HEADER + "13*1#";
    public static final String MONTHLY1660MIN = VOICE_MONTHLY_HEADER + "14*1#";
    public static final String MONTHLY1845MIN = VOICE_MONTHLY_HEADER + "15*1#";
    public static final String MONTHLY4150MIN = VOICE_MONTHLY_HEADER + "16*1#";





    public static  final  String PREMIUMVOICE1WK = "";
    public static  final  String PREMIUMVOICE2WK = "";
    public static  final  String PREMIUMVOICEMON= "";


}
