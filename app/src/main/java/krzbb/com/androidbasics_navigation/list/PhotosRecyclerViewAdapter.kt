package krzbb.com.androidbasics_navigation.list

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import krzbb.com.androidbasics_navigation.R
import krzbb.com.androidbasics_navigation.list.dummy.DummyContent.DummyItem

import kotlinx.android.synthetic.main.item_photo.view.*

class PhotosRecyclerViewAdapter(
        private val mValues: List<DummyItem>,
        private val mListener: (item: DummyItem) -> Unit?)
    : RecyclerView.Adapter<PhotosRecyclerViewAdapter.ViewHolder>()
{
    override fun getItemCount(): Int = mValues.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_photo, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val item = mValues[position]

        holder.mIdView.text = item.id
        holder.mContentView.text = item.content

        holder.mView.apply {
            setOnClickListener {
                mListener(item)
            }
        }
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView)
    {
        val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content
    }
}
