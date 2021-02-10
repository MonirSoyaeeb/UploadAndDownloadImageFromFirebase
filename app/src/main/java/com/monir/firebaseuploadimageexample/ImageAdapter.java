package com.monir.firebaseuploadimageexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private Context context;
    private List<Upload> uploadList;

    public ImageAdapter(Context context, List<Upload> uploadList){
        this.context = context;
        this.uploadList = uploadList;
    }


    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_item,parent,false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
             Upload currentUpload = uploadList.get(position);

             holder.textViewName.setText(currentUpload.getImageName());
             Picasso.with(context).
                     load(currentUpload.getImageUrl()).
                     placeholder(R.mipmap.ic_launcher).
                     fit().
                     centerCrop().
                     into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return uploadList.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewName;
        public ImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.text_view_name);
            imageView = itemView.findViewById(R.id.image_view_upload);

        }
    }
}
