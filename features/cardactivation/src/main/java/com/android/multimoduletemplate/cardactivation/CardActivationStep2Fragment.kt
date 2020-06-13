package com.android.multimoduletemplate.cardactivation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.android.multimoduletemplate.cardactivation.databinding.FragmentCardActivationStep2Binding
import com.android.multimoduletemplate.core.presentation.BaseFragment
import com.android.multimoduletemplate.core.presentation.viewBinding

class CardActivationStep2Fragment : BaseFragment(R.layout.fragment_card_activation_step2) {
    private val binding by viewBinding(FragmentCardActivationStep2Binding::bind)
    private val viewModel by viewModels<CardActivationViewModel> {
        CardActivationViewModelFactory(
            CardActivationCoordinator
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNavigationListener(viewModel.navigationLiveDataField)
        binding.btnSubmit.setOnClickListener {
            viewModel.onStep2Complete()
        }
    }
}
