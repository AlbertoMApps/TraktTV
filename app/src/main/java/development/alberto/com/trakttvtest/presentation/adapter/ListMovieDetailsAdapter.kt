package development.alberto.com.trakttvtest.presentation.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import development.alberto.com.trakttvtest.data.model.realmobject.ImageMovieDetails
import kotlinx.android.synthetic.main.images_row.view.*

/**
 * Created by alber on 09/09/2017.
 */

class ListMovieDetailsAdapter(var context: Context,var mLayout: Int, var listMovieDetail: List<ImageMovieDetails>) : RecyclerView.Adapter<ListMovieDetailsAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.bindItems( this.listMovieDetail.get(position) )
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
                    .resize(350, 350)
                    .into(itemView.ivMovieImage)
        }
    }


}