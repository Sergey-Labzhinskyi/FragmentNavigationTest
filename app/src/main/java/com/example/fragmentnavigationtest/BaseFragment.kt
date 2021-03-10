package com.example.fragmentnavigationtest

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment

open class BaseFragment: Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("TestFragment", "${this.javaClass.simpleName} onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TestFragment", "${this.javaClass.simpleName} onCreate")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TestFragment", "${this.javaClass.simpleName} onViewCreated")
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

    override fun onDetach() {
        super.onDetach()
        Log.d("TestFragment", "${this.javaClass.simpleName} onDetach")
    }
}