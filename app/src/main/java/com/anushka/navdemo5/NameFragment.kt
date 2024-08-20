package com.anushka.navdemo5


import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.anushka.navdemo5.databinding.FragmentNameBinding


/**
 * A simple [Fragment] subclass.
 */
class NameFragment : Fragment() {
    private lateinit var binding: FragmentNameBinding
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_name, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextButton.setOnClickListener{
            val getData:String=binding.nameEditText.text.toString()
            if (getData.length>0) {
                val bundle=Bundle()
                bundle.putString("key",getData)
                if (findNavController().currentDestination?.id == R.id.nameFragment && isVisible) {
                    findNavController().navigate(R.id.action_nameFragment_to_emailFragment,bundle)
                }
            }
            else{
                Toast.makeText(mActivity,"please enter name",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
