package anton.ttp.myapplication.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import anton.ttp.myapplication.R
import kotlinx.android.synthetic.main.activity_anketa.*
import org.jetbrains.anko.sdk15.listeners.onClick
import org.jetbrains.anko.startActivity

class AnketaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anketa)
        button_news.onClick {
            startActivity<NewsActivity>()
        }
    }
}
