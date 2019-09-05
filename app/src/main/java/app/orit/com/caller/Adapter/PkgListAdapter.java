package app.orit.com.caller.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import app.orit.com.caller.Model.PkgList;
import app.orit.com.caller.R;

/**
 * Created by Joseph on 8/29/2019.
 */

public class PkgListAdapter  extends RecyclerView.Adapter<PkgListAdapter.MyViewHolder> {

private LayoutInflater inflater;
private ArrayList<PkgList> pkgLists;

public PkgListAdapter(Context ctx, ArrayList<PkgList> pkgLists){

        inflater = LayoutInflater.from(ctx);
        this.pkgLists = pkgLists;
        }

@Override
public PkgListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.pkg_list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
        }

@Override
public void onBindViewHolder(PkgListAdapter.MyViewHolder holder, int position) {

        holder.mPkgtview.setText(pkgLists.get(position).getName());
        }

@Override
public int getItemCount() {
        return pkgLists.size();
        }

class MyViewHolder extends RecyclerView.ViewHolder{

    TextView mPkgtview ;


    public MyViewHolder(View itemView) {
        super(itemView);

        mPkgtview = (TextView) itemView.findViewById(R.id.pkg_list_item_textview);

    }}}

