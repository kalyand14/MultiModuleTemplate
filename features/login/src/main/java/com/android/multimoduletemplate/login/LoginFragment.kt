package com.android.multimoduletemplate.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.android.multimoduletemplate.core.presentation.BaseFragment
import com.android.multimoduletemplate.core.presentation.viewBinding
import com.android.multimoduletemplate.login.databinding.FragmentLoginBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi


/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : BaseFragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)
    private val viewModel by viewModels<LoginViewModel> { LoginViewModelFactory(LoginCoordinator) }

    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNavigationListener(viewModel.navigationLiveDataField)
        binding.btnLogin.setOnClickListener {
            viewModel.onLoginClick()
        }
    }

}
