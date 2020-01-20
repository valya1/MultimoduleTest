package ru.napoleonit.multimoduletests

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import ru.napoleonit.multimoduletests.featuresInjector.FeaturesProxy
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject
import javax.inject.Named

class RootActivity : AppCompatActivity() {

    @Inject
    lateinit var globalCicerone: Cicerone<Router>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.settings -> {
                    globalCicerone.router.navigateTo(FeaturesProxy.startSettingsFeature())
                }
            }

            true
        }
    }

    override fun onPause() {
        super.onPause()

        globalCicerone.navigatorHolder.removeNavigator()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()

        globalCicerone.navigatorHolder.setNavigator(object :
            SupportAppNavigator(this, supportFragmentManager, R.id.flFragmentsContainer) {})
    }
}