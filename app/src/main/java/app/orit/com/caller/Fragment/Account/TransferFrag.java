package app.orit.com.caller.Fragment.Account;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.orit.com.caller.R;
import app.orit.com.caller.util.Config;

import static android.app.Activity.RESULT_OK;
import static app.orit.com.caller.util.Utility.ussdToCallableUri;


public class TransferFrag extends Fragment {


   private EditText transferTo,transferAmt;
   private Button   transferBtn;

    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 3;
    private static final int SELECT_PHONE_NUMBER = 5;

    private Intent callIntent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_transfer, container, false);

         transferTo  = (EditText)v.findViewById(R.id.transfer_to);
         transferAmt = (EditText)v.findViewById(R.id.transfer_amount);
         transferBtn = (Button) v.findViewById(R.id.transfer_btn);


        transferTo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (transferTo.getRight() - transferTo.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        // your action here
                        Toast.makeText(getActivity(),"drawable clicked",Toast.LENGTH_LONG).show();

                        Intent i=new Intent(Intent.ACTION_PICK);
                        i.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                        startActivityForResult(i, SELECT_PHONE_NUMBER);
                        return true;


                    }
                }
                return false;
            }
        });
           transferBtn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

                   transferBalance();

               }
           });
        return v;
    }

    private void transferBalance() {

        String phoneNo      = transferTo.getText().toString();
        String transferAmount  =  transferAmt.getText().toString();

        if(! phoneNo.isEmpty() && !TextUtils.isEmpty(transferAmount))
        {

            callIntent = new Intent(Intent.ACTION_CALL, ussdToCallableUri(Config.TRANSFER+phoneNo+"#"));
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

            }
        }


    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SELECT_PHONE_NUMBER && resultCode == RESULT_OK) {
            // Get the URI and query the content provider for the phone number
            Uri contactUri = data.getData();
            String[] projection = new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER};
            Cursor cursor = getContext().getContentResolver().query(contactUri, projection,
                    null, null, null);

            // If the cursor returned is valid, get the phone number
            if (cursor != null && cursor.moveToFirst()) {
                int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String number = cursor.getString(numberIndex);
                Toast.makeText(getActivity(),"Phone No "+number,Toast.LENGTH_LONG).show();
                // Do something with the phone number

                transferTo.setText(number);

            }

            cursor.close();
        }

    }


}
