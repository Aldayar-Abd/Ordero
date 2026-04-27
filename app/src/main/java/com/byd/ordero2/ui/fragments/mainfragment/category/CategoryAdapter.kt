package com.byd.ordero2.ui.fragments.mainfragment.category

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.byd.ordero2.R

class CategoryAdapter(
    private val items: List<CategoryItem>,
    private val onClick: (CategoryItem) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private var selectedPosition = 0
    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tv_category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = items[position]

        val drawable = ContextCompat
            .getDrawable(holder.itemView.context, R.drawable.bg_category)
            ?.mutate() as GradientDrawable

        drawable.setColor(ContextCompat.getColor(holder.itemView.context, item.colorRes))

        if (position == selectedPosition) {
            drawable.setStroke(5, ContextCompat.getColor(holder.itemView.context, R.color.main_color))
        } else {
            drawable.setStroke(0, Color.TRANSPARENT)
        }

        holder.textView.background = drawable
        holder.textView.text = item.title
        holder.itemView.setOnClickListener {
            val old = selectedPosition
            selectedPosition = position

            notifyItemChanged(old)
            notifyItemChanged(position)

            onClick(item)
        }
    }

    override fun getItemCount(): Int = items.size
}