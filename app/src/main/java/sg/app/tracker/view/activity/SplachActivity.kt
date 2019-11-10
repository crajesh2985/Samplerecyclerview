package sg.app.tracker.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel
import sg.app.tracker.R
import sg.app.tracker.databinding.ActivitySplashBinding
import sg.app.tracker.viewmodel.SplashViewModel


class SplachActivity : AppCompatActivity() {


    private val loginViewModel: SplashViewModel by viewModel()

    private val observer = Observer<Boolean> {
        startActivity(Intent(this@SplachActivity,HomeActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivitySplashBinding>(
            this, R.layout.activity_splash
        ).apply {
            this.setLifecycleOwner(this@SplachActivity)
        }
        getSupportActionBar()?.hide()



       // btn_login_submit.setOnClickListener(View.OnClickListener {
            loginViewModel.dataStoreList.observe(this, observer)
       // })
    }
}
