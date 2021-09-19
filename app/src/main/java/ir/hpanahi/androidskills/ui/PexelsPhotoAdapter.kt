package ir.hpanahi.androidskills.ui

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ir.hpanahi.androidskills.data.models.PexelsPhoto
import ir.hpanahi.androidskills.databinding.ListItemPhotoBinding

class PexelsPhotoAdapter :
    PagingDataAdapter<PexelsPhoto, PexelsPhotoAdapter.PexelsPhotoViewHolder>(GalleryDiffCallback()) {

    class PexelsPhotoViewHolder(
        private val binding: ListItemPhotoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener { view ->
                binding.photo?.let { photo ->
                    val uri = Uri.parse(photo.url)
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    view.context.startActivity(intent)
                }
            }
        }

        fun bind(item: PexelsPhoto) {
            binding.apply {
                photo = item
                executePendingBindings()
            }
        }
    }

    override fun onBindViewHolder(holder: PexelsPhotoViewHolder, position: Int) {
        val photo = getItem(position)
        if (photo != null) {
            holder.bind(photo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PexelsPhotoViewHolder {
        return PexelsPhotoViewHolder(
            ListItemPhotoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}

private class GalleryDiffCallback : DiffUtil.ItemCallback<PexelsPhoto>() {
    override fun areItemsTheSame(oldItem: PexelsPhoto, newItem: PexelsPhoto): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PexelsPhoto, newItem: PexelsPhoto): Boolean {
        return oldItem == newItem
    }
}
