package br.com.deeper.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.deeper.R
import br.com.deeper.ui.home.adapter.WallpaperAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var recycleViewWallpapers: RecyclerView

    private lateinit var listWallPaper: ArrayList<Int>

    override fun onStart() {
        super.onStart()
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listWallPaper = ArrayList<Int>()
        listWallPaper.add(R.drawable.wallpaper_depper_1)
        listWallPaper.add(R.drawable.wallpaper_depper_2)
        configureRecyclerViewOfWallpapers()
    }

    private fun configureRecyclerViewOfWallpapers() {
        val linearLayout = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
        val dividerItemDecoration = DividerItemDecoration(activity, DividerItemDecoration.HORIZONTAL)
        recycleViewWallpapers = recycler_view
        recycleViewWallpapers.addItemDecoration(dividerItemDecoration)
        recycleViewWallpapers.setHasFixedSize(true)
        recycleViewWallpapers.setItemAnimator(DefaultItemAnimator())
        recycleViewWallpapers.setLayoutManager(linearLayout)
        recycleViewWallpapers.setNestedScrollingEnabled(false)

        val con : Context? = activity?.applicationContext
        val wallpaperAdapter: WallpaperAdapter = WallpaperAdapter(con!!, listWallPaper)

        recycleViewWallpapers.adapter = wallpaperAdapter
    }
}