package grant.com.fragmentexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import grant.com.fragmentexercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , FirstFragmentListener, SecondFragmentListener{
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        loadFirstFragment()

    }

    private fun loadFirstFragment() {
        supportFragmentManager.beginTransaction().add(R.id.first_fragment, FirstFragment.newInstance(), "FirstFragment").commit()
    }

    override fun goToSecond(text: String) {
        supportFragmentManager.beginTransaction().add(R.id.second_fragment, SecondFragment.newInstance(text), "SecondFragment").commit()
    }

    override fun goToThird(textFirst: String?) {
        supportFragmentManager.beginTransaction().add(R.id.third_fragment, ThirdFragment.newInstance(textFirst), "ThirdFragment").commit()
    }

    override fun goToThirdSecond(textSecond: String?) {
        supportFragmentManager.beginTransaction().add(R.id.third_fragment, ThirdFragment.newInstance(textSecond), "ThirdFragment").commit()
    }
}