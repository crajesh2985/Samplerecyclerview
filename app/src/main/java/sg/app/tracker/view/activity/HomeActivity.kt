package sg.app.tracker.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import sg.app.tracker.R
import sg.app.tracker.databinding.ActivityHomeBinding
import sg.app.tracker.view.fragment.FriendDetailsFragment
import sg.app.tracker.view.fragment.ToolDetailsFragment


class HomeActivity : AppCompatActivity() {


   /* private val homeViewModel: HomeViewModel by viewModel()*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityHomeBinding>(
            this, R.layout.activity_home
        ).apply {
            this.setLifecycleOwner(this@HomeActivity)
        }
        //setContentView(R.layout.activity_home)
        getSupportActionBar()?.hide()

        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigationView.selectedItemId = R.id.action_queue
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.action_queue -> {
                val toolDetailsFragment = ToolDetailsFragment.newInstance()

                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.main_container, toolDetailsFragment)

                transaction.commit()


                return@OnNavigationItemSelectedListener true
            }
            R.id.action_new_appointment -> {
                val friendDetailsFragment = FriendDetailsFragment.newInstance()

                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.main_container, friendDetailsFragment)
                transaction.commit()

                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }
}
