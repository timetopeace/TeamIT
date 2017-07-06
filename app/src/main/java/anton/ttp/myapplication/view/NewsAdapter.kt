package anton.ttp.myapplication.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import anton.ttp.myapplication.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_new.view.*



// Позволяет из котлин классов получать андроид отображения
// generics
class NewsAdapter : RecyclerView.Adapter<NewsAdapter.Holder>() {

    var mData: List<NewsActivity.New> = emptyList() // Хранит отображаемые данные

    fun setData(data: List<NewsActivity.New>){ // Заполняет данные, которые передаем
        mData = data
        notifyDataSetChanged() // Обновляет данные внутри RecyclerView
    }

    // Ячейки заполняются новыми данными. Приходит сама ячейка и позиция. Заполняем отображние данными
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val new = mData[position]
        holder.title.text = new.title
        holder.text.text = new.text
        Glide.with(holder.itemView.context)
                .load(new.image)
                .into(holder.image)
    }

    // Holder запоминает
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_new, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view){
        val title: TextView = view.title
        val text: TextView = view.text
        val image: ImageView = view.image
    }
}