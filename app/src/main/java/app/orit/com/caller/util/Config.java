package app.orit.com.caller.util;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;

import app.orit.com.caller.R;

/**
 * Created by Joseph on 8/21/2019.
 */

public class Config

{
    Context context;

   public Config(Context context)
        {

            this.context = context;

        }

    public static final String BALANCE ="*804#";
    public static final String RECHARGE= "*805*";
    public static final String TRANSFER= "*806*";
    public static final String CALLMEBACK= "*807*";
    public static final String HEADER = "*999*";

    private static final int[] _AMOUNT_DINTERNET = new int[]{25,45,100,200,500};
    private static final int[] _PRICE_DINTERNET  = new int[]{3,5,10,15,35};


    private static final int[] _AMOUNT_DVOICE = new int[]{8,13,28};
    private static final int[] _PRICE_DVOICE  = new int[]{3,5,10};

    private static final int[] _AMOUNT_WVOICE = new int[]{46,65,100};
    private static final int[] _PRICE_WVOICE  = new int[]{15,20,30};


    private static final int[] _AMOUNT_MVOICE = new int[]{8,13,28};
    private static final int[] _PRICE_MVOICE  = new int[]{3,5,10};

    private static final int[] _AMOUNT_NVOICE = new int[]{30,60,120,420};
    private static final double[] _PRICE_NVOICE  = new double[]{3.49,4.99,6.99,9.99};

    private static final int[] _AMOUNT_DSMS = new int[]{18,35,70};
    private static final int[] _PRICE_DSMS  = new int[]{2,3,5};

    private static final int[] _AMOUNT_WSMS = new int[]{140,283};
    private static final int[] _PRICE_WSMS  = new int[]{10,15};

    private static final int[] _AMOUNT_MSMS = new int[]{525,1050};
    private static final int[] _PRICE_MSMS  = new int[]{30,50};


    private HashMap<Integer,Integer> amountPricePair;
    public ArrayList<String> getPkgList()
    {
        ArrayList<String> arrayList = new ArrayList<>();


                arrayList.add(this.context.getResources().getString(R.string.title_daily));
                arrayList.add(this.context.getResources().getString(R.string.title_weekly));
                arrayList.add(this.context.getResources().getString(R.string.title_monthly));
                arrayList.add(this.context.getResources().getString(R.string.title_night));



          return arrayList;
    }






}
