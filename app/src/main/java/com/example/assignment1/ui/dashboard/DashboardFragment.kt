package com.example.assignment1.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.assignment1.InformationShowActivity
import com.example.assignment1.databinding.FragmentDashboardBinding
import java.lang.Exception

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val editTextName: EditText = binding.editTextHomeName
        val editTextAge: EditText = binding.editTextHomeAge
        val editTextHeight: EditText = binding.editTextHomeHeight

        val buttonDisplay: Button = binding.displayButtonHome
        val buttonDelete: Button = binding.deleteButtonHome

        editTextAge.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int) {

            }
            override fun onTextChanged(s:CharSequence, start:Int, count:Int, after:Int) {

            }
            override fun afterTextChanged(s: Editable?) {
                try {
                    val content = s.toString().toInt()
                    dashboardViewModel.updateAge(content)
                } catch (e: Exception) {
                    dashboardViewModel.updateAge(0)
                }

            }
        })

        editTextName.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int) {

            }
            override fun onTextChanged(s:CharSequence, start:Int, count:Int, after:Int) {

            }
            override fun afterTextChanged(s: Editable?) {
                val content = s.toString()
                dashboardViewModel.updateName(content)
            }
        })

        editTextHeight.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int) {

            }
            override fun onTextChanged(s:CharSequence, start:Int, count:Int, after:Int) {

            }
            override fun afterTextChanged(s: Editable?) {
                try {
                    val content = s.toString().toDouble()
                    dashboardViewModel.updateHeight(content)
                } catch (e: Exception) {
                    dashboardViewModel.updateHeight(0.0)
                }
            }
        })

        buttonDisplay.setOnClickListener {
            val intent = Intent(context, InformationShowActivity::class.java)
            intent.putExtra("msg", dashboardViewModel.text.value)
            startActivity(intent)
        }

        buttonDelete.setOnClickListener {
            editTextAge.text = null
            editTextHeight.text = null
            editTextName.text = null
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}