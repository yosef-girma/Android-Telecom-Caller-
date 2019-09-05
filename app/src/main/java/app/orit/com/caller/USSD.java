package app.orit.com.caller;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

import static app.orit.com.caller.util.Utility.ussdToCallableUri;

/**
 * Created by Joseph on 8/21/2019.
 */

public class USSD {



    public static void  getCallIntent (Context context, String ussd)
    {

       Uri URI = ussdToCallableUri(ussd);

      Intent callIntent = new Intent(Intent.ACTION_DIAL,URI);

      context.startActivity(callIntent);

    }


}
