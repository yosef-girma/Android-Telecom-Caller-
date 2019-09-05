package app.orit.com.caller.Fragment.Pkg;

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

import java.util.ArrayList;

import app.orit.com.caller.Adapter.PkgListAdapter;
import app.orit.com.caller.Model.PkgList;
import app.orit.com.caller.R;
import app.orit.com.caller.util.Config;


public class PkgSMSFrag extends Fragment {

    private GridView mSmsGView;

    private RecyclerView pkgListRecyclerView;
    private ArrayList<PkgList> pkgLists ;
    private PkgListAdapter adapter;

    private ArrayList<String> pkgSmsOpt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment





        View v = inflater.inflate(R.layout.fragment_pkg_sms, container, false);

        pkgListRecyclerView = (RecyclerView)v.findViewById(R.id.pkgSmsRecycler);
        pkgLists = getPkgList();
        adapter = new PkgListAdapter(getActivity().getApplicationContext(), pkgLists);
        pkgListRecyclerView.setAdapter(adapter);
        pkgListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        // pkgListRecyclerView.addItemDecoration(new MyDividerItemDecoration(getContext(),LinearLayoutManager.HORIZONTAL,4));

        return v;
    }

    public ArrayList<PkgList> getPkgList() {

        ArrayList<PkgList> pkgList = new ArrayList<>();

        pkgSmsOpt = new Config(getActivity().getApplicationContext()).getPkgList();

        if( ! pkgSmsOpt.isEmpty())
        {
            // remove night option for sms as night is last item of pkglist arraylist

            pkgSmsOpt.remove(pkgSmsOpt.size()-1);

            for (String list:
                    pkgSmsOpt) {
                PkgList pList = new PkgList();
                pList.setName(list);
                pkgList.add(pList);

            }
        }



        return pkgList;

    }
}
