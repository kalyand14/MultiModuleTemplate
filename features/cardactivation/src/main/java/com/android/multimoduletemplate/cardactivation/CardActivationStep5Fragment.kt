package com.android.multimoduletemplate.cardactivation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.android.multimoduletemplate.cardactivation.databinding.FragmentCardActivationStep5Binding
import com.android.multimoduletemplate.core.presentation.BaseFragment
import com.android.multimoduletemplate.core.presentation.viewBinding

/**
 * A simple [Fragment] subclass.
 */
class CardActivationStep5Fragment : BaseFragment(R.layout.fragment_card_activation_step5) {

    private val binding by viewBinding(FragmentCardActivationStep5Binding::bind)
    private val viewModel by viewModels<CardActivationViewModel> {
        CardActivationViewModelFactory(
            CardActivationCoordinator
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNavigationListener(viewModel.navigationLiveDataField)
        binding.btnSubmit.setOnClickListener {
            viewModel.onStep5Complete()
        }
    }

}
