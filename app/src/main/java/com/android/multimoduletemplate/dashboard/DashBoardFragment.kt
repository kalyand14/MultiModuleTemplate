package com.android.multimoduletemplate.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.android.multimoduletemplate.R
import com.android.multimoduletemplate.core.presentation.BaseFragment
import com.android.multimoduletemplate.core.presentation.viewBinding
import com.android.multimoduletemplate.databinding.FragmentDashboardBinding
import com.android.multimoduletemplate.root.RootCoordinator

/**
 * A simple [Fragment] subclass.
 */
class DashBoardFragment : BaseFragment(R.layout.fragment_dashboard) {
    private val binding by viewBinding(FragmentDashboardBinding::bind)
    private val viewModel by viewModels<DashBoardViewModel> {
        DashBoardViewModelFactory(
            RootCoordinator
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNavigationListener(viewModel.navigationLiveDataField)
        binding.btnActivateCard.setOnClickListener {
            viewModel.activateCard()
        }
    }

}
