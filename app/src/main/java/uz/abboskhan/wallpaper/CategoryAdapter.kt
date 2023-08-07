package uz.abboskhan.wallpaper

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CategoryAdapter(
    private val categoryItems: List<CategoryItem>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryImageView: ImageView = itemView.findViewById(R.id.c_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val categoryItem = categoryItems[position]
        val firstImageResId = categoryItem.categoryImages[0]
        holder.categoryImageView.setImageResource(firstImageResId)

        // Avtomatik tanlash va rangni o'zgartirish
        val isSelected = position == lastClickedPosition
        val backgroundColor = if (isSelected) {
            holder.itemView.context.resources.getColor(R.color.selected_color)
        } else {
            holder.itemView.context.resources.getColor(R.color.default_color)
        }
        holder.itemView.setBackgroundColor(backgroundColor)

        holder.itemView.setOnClickListener {
            if (isFirstLoad) {
                isFirstLoad = false
            } else {
                itemClickListener.onItemClick(position)
            }

            // Avtomatik tanlash va rangni o'zgartirishni yangilash
            setSelectedPosition(position)
        }
    }

    override fun getItemCount(): Int {
        return categoryItems.size
    }

    private var lastClickedPosition = RecyclerView.NO_POSITION
    private var isFirstLoad = true

    fun setSelectedPosition(position: Int) {
        val previousPosition = lastClickedPosition
        lastClickedPosition = position

        // Avvalgi tanlangan va hozirgi tanlangan elementlarni o'zgartiramiz
        notifyItemChanged(previousPosition)
        notifyItemChanged(position)
    }
}