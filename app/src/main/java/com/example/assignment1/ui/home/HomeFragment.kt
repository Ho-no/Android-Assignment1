package com.example.assignment1.ui.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.assignment1.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val editTextName: EditText = binding.editTextHomeName
        val editTextAge: EditText = binding.editTextHomeAge
        val editTextHeight: EditText = binding.editTextHomeHeight

        val textView : TextView = binding.textHome

        val buttonDisplay: Button = binding.displayButtonHome
        val buttonDelete: Button = binding.deleteButtonHome

        textView.visibility = INVISIBLE

        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        editTextAge.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int) {

            }
            override fun onTextChanged(s:CharSequence, start:Int, count:Int, after:Int) {

            }
            override fun afterTextChanged(s: Editable?) {
                val content = s.toString().toInt()
                homeViewModel.updateAge(content)
            }
        })

        editTextName.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int) {

            }
            override fun onTextChanged(s:CharSequence, start:Int, count:Int, after:Int) {

            }
            override fun afterTextChanged(s: Editable?) {
                val content = s.toString()
                homeViewModel.updateName(content)
            }
        })

        editTextHeight.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int) {

            }
            override fun onTextChanged(s:CharSequence, start:Int, count:Int, after:Int) {

            }
            override fun afterTextChanged(s: Editable?) {
                val content = s.toString().toDouble()
                homeViewModel.updateHeight(content)
            }
        })

        buttonDisplay.setOnClickListener {textView.visibility = VISIBLE}
        buttonDelete.setOnClickListener {textView.visibility = INVISIBLE}

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}