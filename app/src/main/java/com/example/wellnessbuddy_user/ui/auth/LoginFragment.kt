package com.example.wellnessbuddy_user.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.wellnessbuddy_user.R
import com.example.wellnessbuddy_user.ui.Home.HomeActivity

class LoginFragment : Fragment() {

    private lateinit var textRegister: TextView
    private lateinit var textForgotPass : TextView
    private lateinit var loginBtn : Button

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
        loginBtn = view.findViewById(R.id.loginEmailBtn)
        loginBtn.setOnClickListener {
            val intent = Intent(requireContext(), HomeActivity::class.java)
            startActivity(intent)
            requireActivity().finish() // optional: finishes the current activity so user can't go back to login
        }

    }
}
