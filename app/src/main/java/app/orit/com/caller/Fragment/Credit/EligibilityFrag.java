package app.orit.com.caller.Fragment.Credit;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
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


public class EligibilityFrag extends Fragment {


    private Button checkEligibilityBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v= inflater.inflate(R.layout.fragment_eligibility, container, false);


        checkEligibilityBtn = (Button)v.findViewById(R.id.check_eligibility_btn);

        checkEligibilityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL, ussdToCallableUri(CreditConstant.CHECKELIGIBILITY));
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE)
                        == PackageManager.PERMISSION_GRANTED) {

                    startActivity(callIntent);
                }
                else
                {
                    Toast.makeText(getActivity(),"Permission Denied",Toast.LENGTH_LONG).show();

                }
            }
        });
       return  v;

    }


}
