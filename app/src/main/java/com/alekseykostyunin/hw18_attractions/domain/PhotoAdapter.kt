package com.alekseykostyunin.hw18_attractions.domain

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alekseykostyunin.hw18_attractions.databinding.PhotoItemBinding
import com.alekseykostyunin.hw18_attractions.entity.Photo
import com.bumptech.glide.Glide

class PhotoAdapter : RecyclerView.Adapter<PhotoViewHolder>() {

    private var data: List<Photo> = emptyList()

    fun setData(data: List<Photo>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
            PhotoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item: Photo? = data.getOrNull(position)
        with(holder.binding) {
            item?.let {
                date.text = item.date
                Glide
                    .with(cardViewPhoto.context)
                    .load(item.uri)
                    .centerCrop()
                    .into(imageViewPhoto)
            }
        }
    }
}

class PhotoViewHolder(val binding: PhotoItemBinding) : RecyclerView.ViewHolder(binding.root)