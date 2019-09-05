package app.orit.com.caller.Fragment.Pkg;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import app.orit.com.caller.Adapter.GridBaseAdapter;
import app.orit.com.caller.Adapter.PkgListAdapter;
import app.orit.com.caller.Model.GridItem;
import app.orit.com.caller.Model.PkgList;
import app.orit.com.caller.MyDividerItemDecoration;
import app.orit.com.caller.R;
import app.orit.com.caller.util.Config;


public class PkgInternet extends Fragment {

    private GridView mInternetGView;
    private GridView mInternetItemListGView;
    private GridBaseAdapter gridBaseAdapter;
    private ArrayList<GridItem> amtPriceArrayList;


    private RecyclerView pkgListRecyclerView;
    private ArrayList<PkgList> pkgLists ;
    private PkgListAdapter adapter;

    private ArrayList<String> pkgInternetOpt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment




        View v =  inflater.inflate(R.layout.fragment_pkg_internet, container, false);

        pkgListRecyclerView = (RecyclerView)v.findViewById(R.id.pkgInternetRecycler);
        pkgLists = getPkgList();
        adapter = new PkgListAdapter(getActivity().getApplicationContext(), pkgLists);
        pkgListRecyclerView.setAdapter(adapter);
        pkgListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
       // pkgListRecyclerView.addItemDecoration(new MyDividerItemDecoration(getContext(),LinearLayoutManager.HORIZONTAL,4));

        return v;

    }

    public ArrayList<PkgList> getPkgList() {

        ArrayList<PkgList> pkgList = new ArrayList<>();

        pkgInternetOpt = new Config(getActivity().getApplicationContext()).getPkgList();


        if( ! pkgInternetOpt.isEmpty()) {
            pkgInternetOpt.add(" WEEKEND");
            for (String list :
                    pkgInternetOpt) {
                PkgList pList = new PkgList();
                pList.setName(list);
                pkgList.add(pList);

            }
        }

        return pkgList;

    }
}
