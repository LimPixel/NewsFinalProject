package news.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import news.com.adapter.SectionPagerAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val vpNews : ViewPager2 = findViewById(R.id.view_pager_news)
        val hSectionPagerAdapter = SectionPagerAdapter(this)
        vpNews.adapter = hSectionPagerAdapter

        val tabs : TabLayout = findViewById(R.id.tabs)

        val tabList = arrayOf("Trending", "Popular")
        TabLayoutMediator(tabs, vpNews) { tab, position ->
            tab.text = tabList[position]
        }.attach()

    }
}