package app.orit.com.caller.Fragment.Account;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import app.orit.com.caller.R;
import app.orit.com.caller.util.Config;
import app.orit.com.caller.util.CreditConstant;

import static android.app.Activity.RESULT_OK;
import static app.orit.com.caller.util.Utility.ussdToCallableUri;

public class RechargeFrag extends Fragment {




    TextInputLayout    hiddenCardNoTIL;
    TextInputEditText  hiddenCardNo;
    TextInputLayout    giftPhoneNoTIL;
    TextInputEditText  giftPhoneNo;
    RadioGroup rechargingRgrp;
    RadioButton forUradiobtn,asGradiobtn;
    Button rechargeBtn;

    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 3;
    private static final int SELECT_PHONE_NUMBER = 5;
    private Intent callIntent;


    private CompoundButton.OnCheckedChangeListener checkedListener = new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch(buttonView.getId()){
                case R.id.recharge_asgift_rbtn:

                    giftPhoneNoTIL.setVisibility(View.VISIBLE);
                    giftPhoneNo.setVisibility(View.VISIBLE);

                    break;
                case R.id.recharge_4u_rbtn:

                    giftPhoneNoTIL.setVisibility(View.GONE);
                    giftPhoneNo.setVisibility(View.GONE);
                    break;
            }
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_recharge, container, false);

        hiddenCardNoTIL =(TextInputLayout)v.findViewById(R.id.recharge_til);
        hiddenCardNo  = (TextInputEditText)v.findViewById(R.id.card_number);
        rechargingRgrp = (RadioGroup)v.findViewById(R.id.radioGroup);

        forUradiobtn  = (RadioButton)v.findViewById(R.id.recharge_4u_rbtn);
        asGradiobtn   = (RadioButton)v.findViewById(R.id.recharge_asgift_rbtn);
        giftPhoneNoTIL =(TextInputLayout)v.findViewById(R.id.gifted_for_til);
        giftPhoneNo    = (TextInputEditText)v.findViewById(R.id.gifted_phone_number);
        rechargeBtn   = (Button)v.findViewById(R.id.recharge_btn);


       rechargingRgrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch(checkedId){
                    case R.id.recharge_asgift_rbtn:

                        Toast.makeText(getActivity(),"as gift",Toast.LENGTH_LONG).show();
                        giftPhoneNoTIL.setVisibility(View.VISIBLE);
                        giftPhoneNo.setVisibility(View.VISIBLE);

                        break;
                    case R.id.recharge_4u_rbtn:

                        Toast.makeText(getActivity(),"as gift",Toast.LENGTH_LONG).show();
                        giftPhoneNoTIL.setVisibility(View.GONE);
                        giftPhoneNo.setVisibility(View.GONE);
                        break;
                }
            }

        });


        hiddenCardNo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (hiddenCardNo.getRight() - hiddenCardNo.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        // your action here


                        return true;
                    }
                }
                return false;
            }
        });

        giftPhoneNo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (hiddenCardNo.getRight() - hiddenCardNo.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
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



        rechargeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

           String hiddenNo = hiddenCardNo.getText().toString();

           if(! hiddenNo.isEmpty())
           {  Toast.makeText(getActivity(),"out check",Toast.LENGTH_LONG).show();
               if(forUradiobtn.isChecked())
               {
                   Toast.makeText(getActivity(),"for u iside",Toast.LENGTH_LONG).show();

                   callIntent = new Intent(Intent.ACTION_CALL, ussdToCallableUri(Config.RECHARGE+hiddenNo+"#"));
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
               if(asGradiobtn.isChecked())
               {

               }

           }
           else
           {
               hiddenCardNoTIL.setErrorEnabled(true);
               hiddenCardNoTIL.setError("please enter hiden number on your card");
           }



            }
        });


         return v;
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

                giftPhoneNo.setText(number);

            }

            cursor.close();
        }

    }




}
