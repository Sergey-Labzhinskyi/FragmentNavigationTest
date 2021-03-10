package com.example.fragmentnavigationtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_a.*

class FragmentA: BaseFragment() {

    companion object {
        fun newInstance() = FragmentA()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startFragB.setOnClickListener { startFragmentB() }
        startFragD.setOnClickListener { startFragmentD() }
    }

    /**
     * Start fragment for requireFragmentManager()
     */
    private fun startFragmentB() {
        requireFragmentManager().beginTransaction()
            .replace(R.id.fragmentContainer, FragmentB.newInstance())
            .addToBackStack(FragmentB.javaClass.simpleName)
            .commit()
    }

    /**
     * Start fragment for childFragmentManager()
     */
    private fun startFragmentD() {
        childFragmentManager.beginTransaction()
                .replace(R.id.childFragmentContainer, FragmentD.newInstance())
                .addToBackStack(FragmentD.javaClass.simpleName)
                .commit()
    }
}