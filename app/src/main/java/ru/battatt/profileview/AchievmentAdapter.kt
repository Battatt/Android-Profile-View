package ru.battatt.profileview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AchievmentAdapter(
    val achievmentsArray: ArrayList<Achievment>
)
    : RecyclerView.Adapter<AchievmentAdapter.AchievmentHolder>() {

    override fun getItemCount(): Int {
        return achievmentsArray.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
    }

    override fun onBindViewHolder(holder: AchievmentHolder, position: Int) {
        val achievment: Achievment = achievmentsArray[position]
        holder.nameTV?.text = achievment.name
        holder.dateTV?.text = achievment.date
    }

    override fun onBindViewHolder(
        holder: AchievmentHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        super.onBindViewHolder(holder, position, payloads)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchievmentHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.card_achievment, parent, false)
        return AchievmentHolder(view)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
    }

    override fun onFailedToRecycleView(holder: AchievmentHolder): Boolean {
        return super.onFailedToRecycleView(holder)
    }

    override fun onViewAttachedToWindow(holder: AchievmentHolder) {
        super.onViewAttachedToWindow(holder)
    }

    override fun onViewDetachedFromWindow(holder: AchievmentHolder) {
        super.onViewDetachedFromWindow(holder)
    }

    override fun onViewRecycled(holder: AchievmentHolder) {
        super.onViewRecycled(holder)
    }

    override fun registerAdapterDataObserver(observer: RecyclerView.AdapterDataObserver) {
        super.registerAdapterDataObserver(observer)
    }

    override fun setHasStableIds(hasStableIds: Boolean) {
        super.setHasStableIds(hasStableIds)
    }

    override fun unregisterAdapterDataObserver(observer: RecyclerView.AdapterDataObserver) {
        super.unregisterAdapterDataObserver(observer)
    }

    inner class AchievmentHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            var nameTV: TextView? = null
            var dateTV: TextView? = null

            init {
                nameTV = itemView.findViewById(R.id.achievmentName)
                dateTV = itemView.findViewById(R.id.achievmentDate)
            }
        }
    }
