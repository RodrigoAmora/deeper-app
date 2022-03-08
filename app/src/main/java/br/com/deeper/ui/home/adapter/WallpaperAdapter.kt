package br.com.deeper.ui.home.adapter

import android.annotation.SuppressLint
import android.app.WallpaperManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.deeper.R
import br.com.deeper.ui.home.viewholder.WallpaperViewHolder
import kotlinx.android.synthetic.main.adapter_wallpaper.view.*

class WallpaperAdapter(context: Context,
                        listWallPapers: List<Int>): RecyclerView.Adapter<WallpaperViewHolder>() {

    val context: Context = context
    var listWallPapers: List<Int>? = listWallPapers
    //var listener: OnItemListClickListener<News>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallpaperViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.adapter_wallpaper,
                        parent, false)
        return WallpaperViewHolder(view)
    }

    override fun onBindViewHolder(holder: WallpaperViewHolder, position: Int) {
        holder.setValues(listWallPapers!!.get(position))

        holder.itemView.wallpaper?.setOnLongClickListener ( object : View.OnLongClickListener {
            @SuppressLint("ResourceType")
            override fun onLongClick(view: View?): Boolean {
                val wallpaperManager: WallpaperManager = WallpaperManager.getInstance(context)

                when (position) {
                    0 -> {
                        wallpaperManager.setResource(R.drawable.wallpaper_depper_1)
                    }
                    1 -> {
                        wallpaperManager.setResource(R.drawable.wallpaper_depper_2)
                    }
                }

                return true
            }
        })

    }

    override fun getItemCount(): Int = listWallPapers?.size!!
}