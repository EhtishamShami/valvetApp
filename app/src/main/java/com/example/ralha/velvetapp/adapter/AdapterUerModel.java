package com.example.ralha.velvetapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ralha.velvetapp.Items;
import com.example.ralha.velvetapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rana Rafae Malik Ishtiaq Jinjua  on 3/19/2018.
 */

//implements Filterable
public class AdapterUerModel extends RecyclerView.Adapter<AdapterUerModel.RecyclerViewHolder>  {
    List<Items> mArrayList = new ArrayList<>();
    List<Items> mFilteredList = new ArrayList<>();

    Context context;

    public AdapterUerModel(List<Items> itemModelList, Context context)

    {
        this.context = context;

        this.mArrayList = itemModelList;


    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_model, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view, context, mArrayList);

        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.itemName.setText(mArrayList.get(position).getItemTitle());
        holder.size.setText(mArrayList.get(position).getItemSize());
        holder.purchaseValue.setText(context.getString(R.string.rental) + " " + "$" + mArrayList.get(position).getItemRentalPrice());
        holder.retailValue.setText(context.getString(R.string.retail) + " " + "$" + mArrayList.get(position).getItemRetailPrice());

        holder.imageView.setImageBitmap(mArrayList.get(position).getImage());

//        holder.user_id.setText(gParsingList.get(position).getTitle());
//        holder.status_id.setText(gParsingList.get(position).getId());
//        holder.completeTag.setText(gParsingList.get(position).getStatus());

    }






    public void updateList(List<Items> itemModelList) {
        this.mArrayList = itemModelList;
        notifyDataSetChanged();
    }


    public void updateListNew(List<Items> list) {
        //this.mArrayList.clear();
        this.mArrayList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView itemName, size, purchaseValue, retailValue;
        List<Items> itemModelList;
        ImageView imageView;
        Context context;

        public RecyclerViewHolder(View view, Context context, List<Items> itemModelList) {

            super(view);
            this.context = context;
            this.itemModelList = new ArrayList<>();
            this.itemModelList = itemModelList;

            view.setOnClickListener(this);


            itemName = (TextView) view.findViewById(R.id.item_name);
            size = (TextView) view.findViewById(R.id.size_value);
            purchaseValue = (TextView) view.findViewById(R.id.purchase_price);
            retailValue = (TextView) view.findViewById(R.id.retail_price);
            imageView = view.findViewById(R.id.imageView);
//            completeTag = (TextView) view.findViewById(R.id.completeTag);

        }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();

            TextView brandValue, yearPurchasedValue, retailPrice, rentalPrice, category, size, color;

            final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
            View dialogView = View.inflate(context, R.layout.dialog_item_model_details, null);
            dialogBuilder.setView(dialogView);
            dialogBuilder.setCancelable(true);

            brandValue = dialogView.findViewById(R.id.brand_value_tv);
            yearPurchasedValue = dialogView.findViewById(R.id.year_purchased_value_tv);

            retailPrice = dialogView.findViewById(R.id.retail_purchased_value_tv);
            rentalPrice = dialogView.findViewById(R.id.rental_purchased_value_tv);
            category = dialogView.findViewById(R.id.category_retail_purchased_value_tv);
            size = dialogView.findViewById(R.id.size_value_tv);
            color = dialogView.findViewById(R.id.color_value_tv);


            brandValue.setText(itemModelList.get(position).getItemBrand());
            yearPurchasedValue.setText(itemModelList.get(position).getItemYear());
            retailPrice.setText(itemModelList.get(position).getItemRetailPrice());
            rentalPrice.setText(itemModelList.get(position).getItemRentalPrice());
            category.setText(itemModelList.get(position).getItemCategory());
            size.setText(itemModelList.get(position).getItemSize());
            color.setText(itemModelList.get(position).getItemColor());


            final AlertDialog alertDialog = dialogBuilder.create();

            if (context instanceof Activity && !((Activity) context).isFinishing()) {
                alertDialog.show();
            }

            dialogView.findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();

                }
            });


        }
    }


//    public void filter(String text) {
//        mArrayList.clear();
//        if(text.isEmpty()){
//            mArrayList.addAll(itemModelList);
//        } else{
//            text = text.toLowerCase();
//            for(ItemModel item: itemModelList){
//                if(item.getColor().toLowerCase().contains(text) || item.getItemName().toLowerCase().contains(text)){
//                    itemModelListCopy.add(item);
//                }
//            }
//        }
//        notifyDataSetChanged();
//    }


//    @Override
//    public Filter getFilter() {
//
//        return new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence charSequence) {
//
//                String charString = charSequence.toString();
//
//                if (charString.isEmpty()) {
//
//                    mFilteredList = mArrayList;
//                } else {
//
//                    List<ItemModel> filteredList = new ArrayList<>();
//
//                    for (ItemModel androidVersion : mArrayList) {
//
//                        if (androidVersion.getItemName().toLowerCase().contains(charString) || androidVersion.getColor().toLowerCase().contains(charString) || androidVersion.getSize().toLowerCase().contains(charString)) {
//
//                            filteredList.add(androidVersion);
//                        }
//                    }
//
//                    mFilteredList = filteredList;
//                }
//
//                FilterResults filterResults = new FilterResults();
//                filterResults.values = mFilteredList;
//                return filterResults;
//            }
//
//            @Override
//            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
//                mFilteredList = (List<ItemModel>) filterResults.values;
//                notifyDataSetChanged();
//            }
//        };
//    }
//

    public void filterNew(String charText) {
        charText = charText.toLowerCase();
        mFilteredList.clear();
        if (charText.length() == 0) {
            mFilteredList.addAll(mArrayList);
        } else {
            for (Items wp : mArrayList) {
                if (wp.getItemColor().toLowerCase().contains(charText)) {
                    mFilteredList.add(wp);
                }
            }
        }

        updateListNew(mFilteredList);

//        notifyDataSetChanged();
    }


//
//    private class ValueFilter extends Filter{
//
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//            FilterResults results = new FilterResults();
//
//            if (constraint != null && constraint.length() > 0) {
//                List<ItemModel> filterList = new ArrayList<BabyDetailsData>();
//                for (int i = 0; i < mStringFilterList.size(); i++) {
//                    if ((mStringFilterList.get(i).getBabyname().toUpperCase())
//                            .contains(constraint.toString().toUpperCase())) {
//
//                        BabyDetailsData babydata = new BabyDetailsData(mStringFilterList.get(i)
//                                .getBabyname(), mStringFilterList.get(i)
//                                .getBabypicture());
//
//                        filterList.add(babydata);
//                    }
//                }
//                results.count = filterList.size();
//                results.values = filterList;
//            } else {
//                results.count = mStringFilterList.size();
//                results.values = mStringFilterList;
//            }
//            return results;
//
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint,
//                                      FilterResults results) {
//            babylist = (ArrayList<BabyDetailsData>) results.values;
//            notifyDataSetChanged();
//        }
//
//
//    }
//
}






