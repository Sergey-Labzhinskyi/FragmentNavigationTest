package com.example.fragmentnavigationtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_b.*

class FragmentB: BaseFragment() {

    companion object {
        fun newInstance() = FragmentB()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startFragC.setOnClickListener { startFragmentC() }
    }

    private fun startFragmentC() {
        requireFragmentManager().beginTransaction()
            .add(R.id.fragmentContainer, FragmentC.newInstance())
            .addToBackStack(FragmentC.javaClass.simpleName)
            .commit()
    }
}