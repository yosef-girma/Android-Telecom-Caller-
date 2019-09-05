package app.orit.com.caller.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import app.orit.com.caller.Model.GridItem;
import app.orit.com.caller.R;


/**
 * Created by Joseph on 8/27/2019.
 */

public class GridBaseAdapter extends BaseAdapter{

    private LayoutInflater inflater;
    private Context ctx;
    private ArrayList<GridItem> gridItemArrayList;
    private TextView amtTextView;
    private TextView priceTextView;



    public GridBaseAdapter(Context ctx, ArrayList<GridItem> gridItemArrayList) {

        this.ctx = ctx;
        this.gridItemArrayList = gridItemArrayList;
    }

    @Override
    public int getCount() {
        return gridItemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return gridItemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        inflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.grid_item, parent, false);

        amtTextView =   (TextView) itemView.findViewById(R.id.tv_amount);
        priceTextView = (TextView) itemView.findViewById(R.id.tv_price);

       // amtTextView.setText(gridItemArrayList.get(position).getAmount());
       // priceTextView.setText(gridItemArrayList.get(position).getPrice());

        return itemView;
    }
}
