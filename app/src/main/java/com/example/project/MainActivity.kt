package com.example.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.project.ChatListFragment
import com.example.project.HomeFragment
import com.example.project.MyPageFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val chatListFragment = ChatListFragment()
        val myPageFragment = MyPageFragment()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigationView)

        replaceFragment(homeFragment) // 최초 홈 설정.

        // 네비게이션 버튼 리스너;
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(homeFragment)
                R.id.chatList -> replaceFragment(chatListFragment)
                R.id.myPage -> replaceFragment(myPageFragment)
            }
            true
        }
    }

    // fragmet 화면 전환
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction() // 트랜젝션 : 작업을 시작한다고 알려줌;
            .apply {
                replace(R.id.fragmentContainer, fragment)
                commit() // 트랜잭션 끝.
            }
    }
}
