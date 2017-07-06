package anton.ttp.myapplication.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import anton.ttp.myapplication.R
import kotlinx.android.synthetic.main.activity_reg.*
import org.jetbrains.anko.sdk15.listeners.onClick
import org.jetbrains.anko.startActivity

class RegActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

        button_registered.onClick {
            startActivity<LoginActivity>()
        }

        val name : String= reg_name.toString()
    }
}
