package com.lashawn.dtappiaads.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.lashawn.dtappiaads.R
import com.lashawn.dtappiaads.databinding.AdListItemBinding
import com.lashawn.dtappiaads.models.Ad

class DataBindingRecyclerAdapter(private val onAdClicked: (clickedAd: Ad) -> Unit) :
    RecyclerView.Adapter<DataBindingRecyclerAdapter.AdListItemViewHolder>() {

    private var listOfAds = listOf<Ad>()

    fun setAdsList(list: List<Ad>) {
        this.listOfAds = list
        notifyDataSetChanged()
    }

    inner class AdListItemViewHolder (val viewDataBinding: AdListItemBinding):
        RecyclerView.ViewHolder(viewDataBinding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdListItemViewHolder {
        val binding = AdListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewHolder = AdListItemViewHolder(binding)
        viewHolder.itemView.setOnClickListener {
            if (viewHolder.adapterPosition != RecyclerView.NO_POSITION) {
                onAdClicked.invoke(listOfAds[viewHolder.adapterPosition])
            }
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: AdListItemViewHolder, position: Int) {
        val ad = this.listOfAds[position]
        holder.viewDataBinding.ad  = ad
        holder.viewDataBinding.ivThumbnail.load(ad.productThumbnail) {
            crossfade(true)
            placeholder(R.drawable.ic_launcher_foreground)
            transformations(RoundedCornersTransformation(10f))
        }

        holder.viewDataBinding.ivRating.load(ad.averageRatingImageURL)
        //TODO: Determine correct level
//        holder.viewDataBinding.root.setOnClickListener {
//            onAdClicked.invoke(ad)
//        }
    }

    override fun getItemCount(): Int {
        return this.listOfAds.size
    }
}