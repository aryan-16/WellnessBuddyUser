package com.example.wellnessbuddy_user.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.wellnessbuddy_user.R

class LoginFragment : Fragment() {

    private lateinit var textRegister: TextView
    private lateinit var textForgotPass : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textRegister = view.findViewById(R.id.textRegister)
        textRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }

        textForgotPass = view.findViewById(R.id.textForgotPass)
        textForgotPass.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_forgotPassFragment)
        }
    }
}
