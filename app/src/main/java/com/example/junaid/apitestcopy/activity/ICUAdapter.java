package com.example.junaid.apitestcopy.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.junaid.apitestcopy.R;


import java.util.List;


public class ICUAdapter extends RecyclerView.Adapter<ICUAdapter.ProductViewHolder>  {

    private Context mCtx;
    private List<ICUStructure> ICUList;

    public ICUAdapter(Context mCtx, List<ICUStructure> ICUList) {
        this.mCtx = mCtx;
        this.ICUList = ICUList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.search_list, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        final ICUStructure product = ICUList.get(position);


        holder.hos_name.setText(product.getHname());
        holder.hos_location.setText(product.getHlocation());
        holder.hos_contact.setText(product.getHcontact());
        holder.hos_cost.setText(product.getCost());
        holder.hos_numofbeds.setText(product.getNumoficu());

        //button work for call
        holder.callhos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                String n=product.getHcontact();
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+n));
                mCtx.startActivity(intent);

            }
        });

        //button work for booking
        holder.bookhos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                //String n=product.getHcontact();
                String a=product.getHname();
                String b="ICU";
                ApplicationForm.getinfo(a,b);
                Intent intent=new Intent(mCtx,ApplicationForm.class);
               // intent.setData(Uri.parse("tel:"+n));

                mCtx.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return ICUList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView hos_name, hos_location, hos_contact, hos_cost , hos_numofbeds ;
        Button callhos,bookhos;

        public ProductViewHolder(View itemView) {
            super(itemView);

            hos_name = itemView.findViewById(R.id.hos_name);
            hos_location = itemView.findViewById(R.id.hos_location);
            hos_contact = itemView.findViewById(R.id.hos_contact);
            hos_cost = itemView.findViewById(R.id.hos_cost);
            hos_numofbeds = itemView.findViewById(R.id.hos_numofbeds);
            //call button
            callhos=itemView.findViewById(R.id.call_button);
            //booking button
            bookhos=itemView.findViewById(R.id.booking_button);


        }
    }



}
