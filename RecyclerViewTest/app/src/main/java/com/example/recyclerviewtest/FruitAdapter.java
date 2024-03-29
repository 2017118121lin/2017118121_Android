package com.example.recyclerviewtest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> mFruitList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;
        Button delete;
        Button add;
        Button edit;
        EditText editText;
        LinearLayout layout;
        public ViewHolder(View view){
            super(view);
            fruitView=view;
            fruitImage=view.findViewById(R.id.fruit_image);
            fruitName=view.findViewById(R.id.fruit_name);
            delete=view.findViewById(R.id.delete);
            add=view.findViewById(R.id.add);
            edit=view.findViewById(R.id.edit);
            editText=view.findViewById(R.id.editText);
            layout=view.findViewById(R.id.layout);
        }
    }

    public FruitAdapter(List<Fruit> fruitList){
        mFruitList=fruitList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                Fruit fruit=mFruitList.get(position);
                Toast.makeText(view.getContext(),"you clicked view"+fruit.getName(),Toast.LENGTH_SHORT).show();

            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                Fruit fruit=mFruitList.get(position);
                Toast.makeText(view.getContext(),"you clicked image"+fruit.getName(),Toast.LENGTH_SHORT).show();
                holder.layout.setVisibility(View.VISIBLE);
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                removeItem(position);
//                holder.delete.setVisibility(View.GONE);
//                holder.add.setVisibility(View.GONE);
//                holder.edit.setVisibility(View.GONE);
            }
        });
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                addData(position);
                holder.layout.setVisibility(View.GONE);
            }
        });
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int position=holder.getAdapterPosition();
                holder.editText.setVisibility(View.VISIBLE);
            }
        });

        holder.editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                int position=holder.getAdapterPosition();
                if (i == KeyEvent.KEYCODE_ENTER) {
                    String inputText = holder.editText.getText().toString();
                    ChangeData(position,inputText);
                    holder.layout.setVisibility(View.GONE);
                    toggleInput(view.getContext());
                }
                return true;
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruit fruit=mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }


    public void removeItem(int position){
        mFruitList.remove(position);//删除数据源,移除集合中当前下标的数据
        notifyItemRemoved(position);//刷新被删除的地方
        notifyItemRangeChanged(position,getItemCount()); //刷新被删除数据，以及其后面的数据
    }

    public void ChangeData(int position ,String str) {
        Fruit fruit=mFruitList.get(position);
        Fruit fruit1=new Fruit(str,fruit.getImageId());
        mFruitList.set(position,fruit1);
        notifyItemChanged(position);
    }

    public void addData(int position) {
//      在list中添加数据，并通知条目加入一条
        Fruit fruit=mFruitList.get(position);
        mFruitList.add(position,fruit);
        //添加动画
        notifyItemInserted(position);
    }

    private void toggleInput(Context context){
        InputMethodManager inputMethodManager =
                (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

}
