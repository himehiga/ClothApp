package com.example.nkenji.clothapp.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nkenji.clothapp.BR;
import com.example.nkenji.clothapp.R;
import com.example.nkenji.clothapp.viewmodel.Cloth;

import java.util.List;


public class ClothRecyclerViewAdapter extends RecyclerView.Adapter<ClothRecyclerViewAdapter.ItemViewHolder>{

    //Adapterはviewとviewmodelのどちらに割当たるか
    //Adapterの役割はViewとCollectionの間にあるもの
    //やっていることは、Viewの生成をやり、イベントをハンドルしているからviewか。。。

    private List<Cloth> mClothList;
    private Context mContext;
    //
    public ClothRecyclerViewAdapter(Context context, List<Cloth> clothList){
        mContext = context;
        mClothList = clothList;
    }

    public void resetRecyclerViewItems(List<Cloth> clothList) {
        mClothList = clothList;
    }

    // ViewHolder
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding mBinding;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
        }

        public ViewDataBinding getBinding(){
            return mBinding;
        }

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        view.setOnClickListener((View clickedView) -> {
            Toast.makeText(mContext,"Test",Toast.LENGTH_SHORT).show();
        });
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Cloth cloth = mClothList.get(position);

        holder.getBinding().setVariable(BR.cloth, cloth);
        //即時にバインディング
        //変数やオブザーバブルが変更されると、次のフレームの前にバインディングがスケジュールされます。ただし、直ちにバインディングを実行する必要がある場合もあります。強制的に実行するには、executePendingBindings() メソッドを使用してください。
        holder.getBinding().executePendingBindings();
//        holder.mTextView.setText(mClothList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mClothList.size();
    }
}
