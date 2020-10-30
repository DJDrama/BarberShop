package com.barbershop.www.ui.main.style;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.barbershop.www.databinding.ItemLayoutStylePictureBinding;
import java.util.ArrayList;
import java.util.List;


interface OnPhotoClickListener {
    void onPhotoClicked(int drawable);
}

public class HorizontalRecyclerviewAdapter extends RecyclerView.Adapter<HorizontalRecyclerviewAdapter.PhotoViewHolder> {
    private List<Integer> photoList;
    private OnPhotoClickListener onPhotoClickListener;

    HorizontalRecyclerviewAdapter(OnPhotoClickListener onPhotoClickListener) {
        photoList = new ArrayList<>();
        this.onPhotoClickListener = onPhotoClickListener;
    }

    void submitList(List<Integer> list) {
        if (this.photoList.size() != 0)
            this.photoList.clear();
        this.photoList.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhotoViewHolder(ItemLayoutStylePictureBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false), onPhotoClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        int drawable = photoList.get(position);
        holder.bind(drawable);
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    static class PhotoViewHolder extends RecyclerView.ViewHolder {
        private final ItemLayoutStylePictureBinding binding;
        private final OnPhotoClickListener onPhotoClickListener;

        public PhotoViewHolder(ItemLayoutStylePictureBinding binding, OnPhotoClickListener onPhotoClickListener) {
            super(binding.getRoot());
            this.binding = binding;
            this.onPhotoClickListener = onPhotoClickListener;
        }

        public void bind(int drawable) {
            binding.getRoot().setOnClickListener(view -> {
                onPhotoClickListener.onPhotoClicked(drawable);
            });
            binding.imageView5.setImageResource(drawable);
        }
    }
}

