package com.android.multimoduletemplate.onboarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.android.multimoduletemplate.core.presentation.BaseFragment
import com.android.multimoduletemplate.core.presentation.viewBinding
import com.android.multimoduletemplate.onboarding.databinding.FragmentOnBoardingCompletedBinding


class OnBoardingCompletedFragment : BaseFragment(R.layout.fragment_on_boarding_completed) {
    private val binding by viewBinding(FragmentOnBoardingCompletedBinding::bind)
    private val viewModel by viewModels<OnBoardingViewModel> {
        OnboardingViewModelFactory(
            OnBoardingCoordinator
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNavigationListener(viewModel.navigationLiveDataField)
        binding.btnOnboardingComplete.setOnClickListener {
            viewModel.onBoardingCompleted()
        }
    }

}
