package com.anushka.navdemo5


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.anushka.navdemo5.databinding.FragmentWelcomeBinding


/**
 * A simple [Fragment] subclass.
 */
class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_welcome, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arguments=arguments
        val name:String=arguments?.getString("name").toString()
        val email:String=arguments?.getString("email").toString()

        binding.nameTextView.text=name
        binding.emailTextView.text=email

        binding.viewTermsButton.setOnClickListener{
            if (findNavController().currentDestination?.id==R.id.welcomeFragment &&isVisible){
                findNavController().navigate(R.id.action_welcomeFragment_to_termsFragment)
            }
        }
    }
}
