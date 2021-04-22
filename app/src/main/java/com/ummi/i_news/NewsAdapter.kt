import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ummi.i_news.R
import com.ummi.i_news.activity.DetailActivity
import com.ummi.newsay.model.Article
import kotlinx.android.synthetic.main.item_news.view.*
import org.jetbrains.anko.intentFor

class NewsAdapter(var context: Context, var listNews: List<Article?>?) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {



    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(news: Article) {
            with(itemView) {
                tv_title_item_news.text = news.title
                tv_time_item_news.text = news.publishedAt
                tv_date_item_news.text = news.author
                Glide.with(context).load(news.urlToImage).centerCrop().into(iv_item_news)
                itemView.setOnClickListener {
                    itemView.context?.startActivity(
                        itemView.context.intentFor<DetailActivity>(
                            "EXTRA_NEWS" to news
                        )
                    )
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        holder.bind(listNews?.get(position)!!)

    }
    override fun getItemCount(): Int = listNews!!.size
}