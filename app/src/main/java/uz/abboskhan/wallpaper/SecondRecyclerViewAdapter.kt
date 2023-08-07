package uz.abboskhan.wallpaper

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView


class SecondRecyclerViewAdapter(val context: Context, private var imageResIds: List<Int>) :
    RecyclerView.Adapter<SecondRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.second_img_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.second_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageResId = imageResIds[position]
        holder.imageView.setImageResource(imageResId)

        holder.imageView.setOnClickListener {
            val i = Intent(context, ImageActivity::class.java)
            i.putExtra("IMG", imageResId)
            context.startActivity(i)
        }

    }

    override fun getItemCount(): Int {
        return imageResIds.size
    }

    fun updateData(newImageResIds: List<Int>) {
        imageResIds = newImageResIds
        notifyDataSetChanged()
    }

}