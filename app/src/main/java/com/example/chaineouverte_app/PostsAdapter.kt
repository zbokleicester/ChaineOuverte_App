package com.example.chaineouverte_app
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class PostsAdapter(
    var mContext: Context,
    var resource: Int,
    var values: ArrayList<PostActivite>
) : ArrayAdapter<PostActivite>(mContext, resource, values) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val choix = values[position]
        val itemView = LayoutInflater.from(mContext).inflate(resource, parent, false)
        val TitrePost = itemView.findViewById<TextView>(R.id.TitrePost)
        val descriptionPost = itemView.findViewById<TextView>(R.id.descriptionPost)
        val Imagepost = itemView.findViewById<ImageView>(R.id.Imagepost)

        TitrePost.text = choix.titre
        descriptionPost.text = choix.description
        Imagepost.setImageResource(choix.image)

        return itemView
    }
}
