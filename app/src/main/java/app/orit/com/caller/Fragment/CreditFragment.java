package app.orit.com.caller.Fragment;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import app.orit.com.caller.R;
import app.orit.com.caller.util.CreditConstant;

import static app.orit.com.caller.util.Utility.ussdToCallableUri;


public class CreditFragment extends Fragment {



    private GridView gridView;
    private String[] gridItem ;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_credit, container, false);

        gridView = (GridView)v.findViewById(R.id.credit_list);

        gridItem = new String[]{"5 Birr","10 Birr","15 Birr","25 Birr","50 Birr","100 Birr"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),R.layout.list,gridItem);

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

             boolean x=   onGridItemSelected(i);




            }
        });

        return v;
    }

    private boolean onGridItemSelected(int i) {
        Intent callIntent;

        switch (i) {
            case 0:
                callIntent = new Intent(Intent.ACTION_CALL, ussdToCallableUri(CreditConstant.CREDIT5BR));
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE)
                        == PackageManager.PERMISSION_GRANTED) {

                    startActivity(callIntent);
                } else {
                    Toast.makeText(getActivity(), "Permission Denied", Toast.LENGTH_LONG).show();

                }
            case 1:
                callIntent = new Intent(Intent.ACTION_CALL, ussdToCallableUri(CreditConstant.CREDIT10BR));
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE)
                        == PackageManager.PERMISSION_GRANTED) {

                    startActivity(callIntent);
                } else {
                    Toast.makeText(getActivity(), "Permission Denied", Toast.LENGTH_LONG).show();

                }
                return true;
            case 2:
                callIntent = new Intent(Intent.ACTION_CALL, ussdToCallableUri(CreditConstant.CREDIT15BR));
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE)
                        == PackageManager.PERMISSION_GRANTED) {

                    startActivity(callIntent);
                } else {
                    Toast.makeText(getActivity(), "Permission Denied", Toast.LENGTH_LONG).show();

                }
                return true;
            case 3:
                callIntent = new Intent(Intent.ACTION_CALL, ussdToCallableUri(CreditConstant.CREDIT25BR));
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE)
                        == PackageManager.PERMISSION_GRANTED) {

                    startActivity(callIntent);
                } else {
                    Toast.makeText(getActivity(), "Permission Denied", Toast.LENGTH_LONG).show();

                }
                return true;

            case 4:
            callIntent = new Intent(Intent.ACTION_CALL, ussdToCallableUri(CreditConstant.CREDIT50BR));
            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {

                startActivity(callIntent);
            } else {
                Toast.makeText(getActivity(), "Permission Denied", Toast.LENGTH_LONG).show();

            }
            return true;
            case 5:

                callIntent = new Intent(Intent.ACTION_CALL, ussdToCallableUri(CreditConstant.CREDIT100BR));
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE)
                        == PackageManager.PERMISSION_GRANTED) {

                    startActivity(callIntent);
                } else {
                    Toast.makeText(getActivity(), "Permission Denied", Toast.LENGTH_LONG).show();

                }
                return true;

        }

        return false;
    }


}
