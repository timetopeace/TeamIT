package anton.ttp.myapplication.view
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import anton.ttp.myapplication.R
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_news.*
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit

class NewsActivity : AppCompatActivity() {

    class New(
            val title: String,
            val text: String,
            val image: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val client = OkHttpClient.Builder().readTimeout(1000L,TimeUnit.MILLISECONDS).build()

        val task = Runnable {
            val request = Request.Builder()
                    .url("https://api.myjson.com/bins/a829r")
                    .build()
            val result = client.newCall(request)
                    .execute() // Запрос в сеть (может повиснуть на секунду)
                    .body().string()

            val resultJson = JsonParser().parse(result).asJsonObject
            val code = resultJson["code"].asInt

            val news = mutableListOf<New>()

            val responseArray = resultJson["response"].asJsonArray
            for(el in responseArray) {
                val newJson = el.asJsonObject

                val title = newJson["title"].asString
                val text = newJson["text"].asString
                val image = newJson["image"].asString
                news.add(New(title, text, image))
            }

            runOnUiThread {
                val adapter = NewsAdapter()
                adapter.setData(news)
                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(this)
            }
            Log.e ("NewsActivity", result)
        }
//
//        val request = Request.Builder()
//                    .url("https://bash.im/index/1269?count=2&offset=14")
//                    .get()
//                    .build()
//
//       val request = Request.Builder()
//                   .url("https://w3schools.com/test/demo_form.php")
//                   .get()
//                   .build()
//
        Thread(task).start()
    }
}
