package br.com.deeper.ui.home.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_wallpaper.view.*

class WallpaperViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setValues(wallpaper: Int) {
        Picasso.get().load(wallpaper).into(itemView?.wallpaper)
    }
}