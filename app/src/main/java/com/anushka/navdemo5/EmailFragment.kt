package com.anushka.navdemo5


import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.anushka.navdemo5.databinding.FragmentEmailBinding


/**
 * A simple [Fragment] subclass.
 */
class EmailFragment : Fragment() {

    private lateinit var binding: FragmentEmailBinding
    private lateinit var mActivity:Activity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity=context as Activity
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_email, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arguments=arguments
        val name:String=arguments?.getString("key").toString()


        binding.submitButton.setOnClickListener{
            val email=binding.emailEditText.text.toString()
            if (email.length>0){
            val bundle=Bundle()
            bundle.putString("name",name)
            bundle.putString("email",email)
            if (findNavController().currentDestination?.id==R.id.emailFragment){
                findNavController().navigate(R.id.action_emailFragment_to_welcomeFragment,bundle)
            }
        }
            else{
                Toast.makeText(mActivity,"please enter email",Toast.LENGTH_SHORT).show()
            }
        }


    }
}
