package com.example.fragmentnavigationtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


/**
 * 1. When we need display FragmentA on MainActivity we must use getSupportFragmentManager().
 * Never try to use getSupportFragmentManager in a Fragment, because it is memory leak.
 * Example: getSupportFragmentManager().beginTransaction().replace(R.id.container, FragmentA.newInstance()).
 * 2. When we need display FragmentB on FragmentA we must use getFragmentManager()(requireFragmentManager())
 * and reuse container.
 * Example: getFragmentManager().beginTransaction().replace(R.id.container, FragmentB.newInstance()).
 * 3. When we need display FragmentB on FragmentA in new graph we must use getChildFragmentManager()
 * and use new container. We need create new layout.
 * Example: getChildFragmentManager().beginTransaction().replace(R.id.container_new, FragmentB.newInstance())
 *
 * Replace vs Add.
 * When we use add we are added FragmentB above FragmentA on back stack. When we return to FragmentA wont call
 * "onViewCreated". When use replace we remove FragmentA and create FragmentB and when we return to FragmentA
 * will be "onViewCreated".
 *
 * Commit() vs commitAllowingStateLoss()
 * Commit() throw an exception if state loss,  commitAllowingStateLoss() not throw exception.
 * Need use commit().
 *
 * Show() and Hide()
 * These methods set the visibility of the fragment's views without affecting the lifecycle of the fragment.
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TestFragment", "${this.javaClass.simpleName} onCreate")
        setContentView(R.layout.activity_main)

        bntFragment.setOnClickListener {
            startMainFragment()
        }

        bntFragmentA.setOnClickListener {
            startFragmentA()
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("TestFragment", "${this.javaClass.simpleName} onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TestFragment", "${this.javaClass.simpleName} onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TestFragment", "${this.javaClass.simpleName} onDestroy")
    }

    private fun startFragmentA() {
        supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, FragmentA.newInstance())
                .addToBackStack(FragmentA.javaClass.simpleName)
                .setReorderingAllowed(true)
                .commit()
    }

    private fun startMainFragment() {
        supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, MainFragment.newInstance("", ""))
                .commit()
    }
}