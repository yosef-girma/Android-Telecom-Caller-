package app.orit.com.caller.Fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.orit.com.caller.Fragment.Account.CamRechargeFragment;
import app.orit.com.caller.R;
import me.relex.circleindicator.CircleIndicator;


public class HomeFragment extends Fragment {



    private TabLayout tabLayout;
    private  ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private static final int NO_SCREEN = 2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        circleIndicator = view.findViewById(R.id.circle);
        circleIndicator.createIndicators(5,0);

        circleIndicator.animatePageSelected(2);
        setupViewPager(viewPager);
        circleIndicator.setViewPager(viewPager);
//        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);


  return view;
    }



    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragment(new BlankFragment(), "Top ");
       // viewPagerAdapter.addFragment(new CamRechargeFragment(),"Credit");

        viewPager.setAdapter(viewPagerAdapter);
    }



    public class ViewPagerAdapter extends FragmentPagerAdapter {

        List<Fragment> fragmentList = new ArrayList<>();
        List<String>   fragmentTitles = new ArrayList<>();

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
