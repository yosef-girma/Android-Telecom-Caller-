package app.orit.com.caller.Fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import app.orit.com.caller.MainActivity;
import app.orit.com.caller.R;

import app.orit.com.caller.USSD;
import app.orit.com.caller.util.Config;

import static app.orit.com.caller.util.Utility.ussdToCallableUri;
//import static app.orit.com.caller.util.Utility.ussdToCallableUri;


public class BlankFragment extends Fragment {



    private OnFragmentInteractionListener mListener;
    private ListView listView;
    private TextView textView;
    private String[] listItem;
    private Context  context;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_blank, container, false);

        listView=(ListView)v.findViewById(R.id.listView);
        textView=(TextView)v.findViewById(R.id.textView);
        listItem = getResources().getStringArray(R.array.services);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                String value=adapter.getItem(position);

                selection(position);

                Toast.makeText(getActivity().getApplicationContext(),value,Toast.LENGTH_SHORT).show();

            }
        });

        return v;
    }


    public void selection(int pos)
    {

        switch (pos)
        {
            case 0:

                Intent callIntent = new Intent(Intent.ACTION_CALL, ussdToCallableUri(Config.BALANCE));
                if (isPermissionGranted())
                    startActivity(callIntent);
                else
                {
                 Toast.makeText(getActivity(),"Permission Denied",Toast.LENGTH_LONG).show();

                }
            break;

            case 1:

            break;
               case 2:

            break;
               case 3:

            break;
               case 4:

            break;
        }

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void requestPermission()
    {
        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CALL_PHONE},1);

    }
    public  boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG","Permission is granted");
                return true;
            } else {

                Log.v("TAG","Permission is revoked");
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG","Permission is granted");
            return true;
        }
    }

}
