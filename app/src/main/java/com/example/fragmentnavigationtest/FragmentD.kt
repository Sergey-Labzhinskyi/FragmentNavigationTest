package com.example.fragmentnavigationtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_d.*

class FragmentD : BaseFragment() {

    companion object {
        fun newInstance() = FragmentD()
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_d, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startFragE.setOnClickListener { showFragmentE() }
    }

    private fun showFragmentE() {
        requireFragmentManager().beginTransaction()
                .replace(R.id.childFragmentContainer, FragmentE.newInstance())
                .addToBackStack(FragmentE.javaClass.simpleName)
                .commit()
    }
}