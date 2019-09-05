package app.orit.com.caller.Fragment.Credit;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import app.orit.com.caller.R;
import app.orit.com.caller.util.Config;
import app.orit.com.caller.util.CreditConstant;

import static app.orit.com.caller.USSD.getCallIntent;
import static app.orit.com.caller.util.Utility.ussdToCallableUri;


public class DebtInfoFrag extends Fragment {


    private Button checkDebitBtn;
    private Intent callIntent;
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v =inflater.inflate(R.layout.fragment_debt_info, container, false);

       checkDebitBtn = (Button)v.findViewById(R.id.check_debit_btn);

       checkDebitBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                callIntent = new Intent(Intent.ACTION_CALL, ussdToCallableUri(CreditConstant.CHECKDEBTBALANCE));
               if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE)
                       != PackageManager.PERMISSION_GRANTED) {
                   // Should we show an explanation?
                   if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                           Manifest.permission.CALL_PHONE)) {

                   } else {

                       ActivityCompat.requestPermissions(getActivity(),
                               new String[]{Manifest.permission.CALL_PHONE},
                               MY_PERMISSIONS_REQUEST_CALL_PHONE);
                   }

               }
               else
               {

                   startActivity(callIntent);

                   Toast.makeText(getActivity(),"Permission Denied",Toast.LENGTH_LONG).show();

               }
           }
       });


       return v;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {

            if(requestCode == MY_PERMISSIONS_REQUEST_CALL_PHONE)
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                startActivity(callIntent);

                } else
                    {

                    Toast.makeText(getActivity(), "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }


}
