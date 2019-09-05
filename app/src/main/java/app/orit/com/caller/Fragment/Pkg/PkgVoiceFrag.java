package app.orit.com.caller.Fragment.Pkg;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import app.orit.com.caller.Adapter.PkgListAdapter;
import app.orit.com.caller.Model.PkgList;
import app.orit.com.caller.util.Config;

import java.util.ArrayList;
import java.util.List;

import app.orit.com.caller.R;


public class PkgVoiceFrag extends Fragment {


    private GridView mVoiceGView;
    private ArrayList<String> pkgVoiceOpt;


    private RecyclerView pkgListRecyclerView;
    private ArrayList<PkgList> pkgLists ;
    private PkgListAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment




        View v =  inflater.inflate(R.layout.fragment_pkg_voice, container, false);
        pkgListRecyclerView = (RecyclerView)v.findViewById(R.id.pkgVoiceRecycler);
        pkgLists = getPkgList();
        adapter = new PkgListAdapter(getActivity().getApplicationContext(), pkgLists);
        pkgListRecyclerView.setAdapter(adapter);
        pkgListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        // pkgListRecyclerView.addItemDecoration(new MyDividerItemDecoration(getContext(),LinearLayoutManager.HORIZONTAL,4));


        return v;
    }
    public ArrayList<PkgList> getPkgList() {

        ArrayList<PkgList> pkgList = new ArrayList<>();

        pkgVoiceOpt = new Config(getActivity().getApplicationContext()).getPkgList();

        if( ! pkgVoiceOpt.isEmpty())
            for (String list:
                    pkgVoiceOpt) {
                PkgList pList = new PkgList();
                pList.setName(list);
                pkgList.add(pList);

            }


        return pkgList;

    }
}
