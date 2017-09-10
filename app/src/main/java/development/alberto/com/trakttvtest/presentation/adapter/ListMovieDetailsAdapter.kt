package development.alberto.com.trakttvtest.presentation.adapter

import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import development.alberto.com.trakttvtest.data.model.realmobject.ImageMovieDetails
import development.alberto.com.trakttvtest.presentation.view.initialmovies.MainActivity
import kotlinx.android.synthetic.main.images_row.view.*
import android.view.ViewAnimationUtils



/**
 * Created by alber on 09/09/2017.
 */

class ListMovieDetailsAdapter(var context: MainActivity,var mLayout: Int, var listMovieDetail: List<ImageMovieDetails>) : RecyclerView.Adapter<ListMovieDetailsAdapter.ViewHolder>() {


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.bindItems( this.listMovieDetail.get(position) )
        holder.itemView.setOnClickListener(View.OnClickListener {
            context.receiveActualPositionListClickToDisplay(this.listMovieDetail.get(position))
            val anim = ViewAnimationUtils.createCircularReveal(holder.itemView.ivMovieImage, 100, 100, 1000f, 0f)
            anim.start()
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(mLayout, parent, false)
        return ViewHolder(view, context)
    }

    override fun getItemCount(): Int {
        return this::listMovieDetail.get().size
    }


    class ViewHolder(itemView: View?, var context: Context) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(imageMovieDetails: ImageMovieDetails) {
            itemView.tvMovieTitle.text = imageMovieDetails.title
            Picasso.with(context)
                    .load("https://image.tmdb.org/t/p/w640/"+imageMovieDetails.posterPath.toString())
                    .resize(500, 350)
                    .into(itemView.ivMovieImage)
        }
    }


}