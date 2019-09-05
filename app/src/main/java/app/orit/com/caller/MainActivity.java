package app.orit.com.caller;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.orit.com.caller.Fragment.Account.CallMeBackFrag;
import app.orit.com.caller.Fragment.Account.CamRechargeFragment;
import app.orit.com.caller.Fragment.Account.RechargeFrag;
import app.orit.com.caller.Fragment.Account.TransferFrag;
import app.orit.com.caller.Fragment.BlankFragment;
import app.orit.com.caller.Fragment.Credit.DebtInfoFrag;
import app.orit.com.caller.Fragment.Credit.EligibilityFrag;
import app.orit.com.caller.Fragment.CreditFragment;
import app.orit.com.caller.Fragment.HomeFragment;
import app.orit.com.caller.Fragment.Pkg.PkgInternet;
import app.orit.com.caller.Fragment.Pkg.PkgSMSFrag;
import app.orit.com.caller.Fragment.Pkg.PkgVoiceFrag;
import app.orit.com.caller.util.Config;

import static app.orit.com.caller.util.Utility.ussdToCallableUri;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {

//    private TextView mTextMessage;

    ActionBar toolbar;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private long mBasedId = 0;

    private ViewPagerAdapter viewPagerAdapter;
    private static  final  int PERMISSION_REQUEST_CODE = 100;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(MenuItem item) {


            Fragment fragment;

            switch (item.getItemId()) {


                case R.id.navigation_home:


                    // removeAllFragment(viewPagerAdapter);
                    viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());


                    viewPagerAdapter.clear();
                    //   viewPagerAdapter.removeFragment();
                    viewPagerAdapter.addFragment(new HomeFragment(), " ");

                    viewPagerAdapter.notifyDataSetChanged();

                    viewPager.setAdapter(viewPagerAdapter);
                    tabLayout.setupWithViewPager(viewPager);
                    // fragment = new HomeFragment();
                    // loadFragment(fragment);
                    //   toolbar.setTitle("Home");
                    //          mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_account:


                    //removeAllFragment(viewPagerAdapter);


                    viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());


                    //  viewPagerAdapter.removeFragment();

                    viewPagerAdapter.clear();

                    viewPagerAdapter.addFragment(new RechargeFrag(), "Recharge ");
                    viewPagerAdapter.addFragment(new TransferFrag(), "Transfer");
                    viewPagerAdapter.addFragment(new CallMeBackFrag(), "Call Me Back");

                    viewPagerAdapter.notifyDataSetChanged();

                    viewPager.setAdapter(viewPagerAdapter);
                    tabLayout.setupWithViewPager(viewPager);


                    //fragment = new RechargeFrag();
                    //loadFragment(fragment);
                    // toolbar.setTitle("Account");
                    return true;

                case R.id.navigation_pkg:

/*
                    try {

                    }catch (Exception e){

                        removeAllFragment();

                    }*/

                    //removeAllFragment(viewPagerAdapter);
                    viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());


                    viewPagerAdapter.clear();
                    //  viewPagerAdapter.removeFragment();

                    viewPagerAdapter.addFragment(new PkgInternet(), " INTERNET");
                    viewPagerAdapter.addFragment(new PkgVoiceFrag(), "VOICE");
                    viewPagerAdapter.addFragment(new PkgSMSFrag(), " SMS");

                    viewPagerAdapter.notifyDataSetChanged();

                    viewPager.setAdapter(viewPagerAdapter);
                    tabLayout.setupWithViewPager(viewPager);
                    //fragment = new PkgFragment();
                    //loadFragment(fragment);
                    //toolbar.setTitle("Package");

                    return true;
                case R.id.navigation_credit:


                    // removeAllFragment(viewPagerAdapter);
                    viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

                    viewPagerAdapter.clear();
                    //  viewPagerAdapter.removeFragment();


                    viewPagerAdapter.addFragment(new EligibilityFrag(), "Eligibility");
                    viewPagerAdapter.addFragment(new CreditFragment(), "Credit");
                    viewPagerAdapter.addFragment(new DebtInfoFrag(), "Debt Info");

                    viewPagerAdapter.notifyDataSetChanged();
                    viewPager.setAdapter(viewPagerAdapter);

                    tabLayout.setupWithViewPager(viewPager);
                    // fragment = new CreditFragment();
                    // loadFragment(fragment);
                    //toolbar.setTitle("Credit");
                    //                mTextMessage.setText(R.string.title_dashboard);
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar topToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(topToolBar);
        topToolBar.setTitle("Quick Caller");


        viewPager = (ViewPager) findViewById(R.id.view_pager_main);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(new HomeFragment(), " ");

        viewPager.setAdapter(viewPagerAdapter);


        //  loadFragment(new HomeFragment());
        // mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.setting:


               startActivity(new Intent(MainActivity.this,SettingsActivity.class));

                return true;

            case R.id.about_me:
                startActivity(new Intent(MainActivity.this,AboutActivity.class));
                return true;


        }

        return super.onOptionsItemSelected(item);

    }

    private void setupViewPager(ViewPager viewPager) {


        viewPagerAdapter.addFragment(new BlankFragment(), "Top ");
        viewPagerAdapter.addFragment(new CamRechargeFragment(),"Credit");

        viewPager.setAdapter(viewPagerAdapter);
    }
/*
    public void removeAllFragment(ViewPagerAdapter viewPagerAdapter)
    {
        if(!fragmentList.isEmpty())
        {

            Toast.makeText(MainActivity.this,"Fragment List has element",Toast.LENGTH_LONG).show();

            for(int i =0 ; i <fragmentList.size();i++)  fragmentList.remove(i);

        }

        Toast.makeText(MainActivity.this,"Fragment List i snUll",Toast.LENGTH_LONG).show();
        viewPagerAdapter.notifyDataSetChanged();
    }
    */

    /*
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    */

/*
*//*
    public void host()
    {

        String USSDCode = "*804#";

        Intent callIntent = USSD.getCallIntent(MainActivity.this,USSDCode);

        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            Toast.makeText(MainActivity.this,"Grant permission to stop shutdown",Toast.LENGTH_LONG).show();
            requestPermission();
        }
        else
        {
           MainActivity.this.startActivity(callIntent);
        }
    }
    */
    public void requestForCallPermission()
    {

        if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CALL_PHONE))
        {
        }
        else {

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},PERMISSION_REQUEST_CODE);
        }
    }
    public void requestPermission()
    {
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults)
    {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();

                }
                else
                {

                    Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();

                }
                return;
        }
    }

    public  boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG","Permission is granted");
                return true;
            } else {

                Log.v("TAG","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG","Permission is granted");
            return true;
        }
    }
    public class ViewPagerAdapter extends FragmentStatePagerAdapter {

        private    List<Fragment> fragmentList = new ArrayList<>();
        private    List<String>   fragmentTitles = new ArrayList<>();


        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {


            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }


        public void clear()
        {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            for( Fragment fragment:fragmentList)
            {
                transaction.remove(fragment);
            }
            fragmentList.clear();
            transaction.commitAllowingStateLoss();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitles.get(position);
        }

        public void addFragment(Fragment fragment, String name) {

            fragmentList.add(fragment);
            fragmentTitles.add(name);

        }


    }
}
