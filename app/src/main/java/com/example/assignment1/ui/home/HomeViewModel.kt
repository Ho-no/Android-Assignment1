package com.example.assignment1.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _age: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>().also { it.value = 0 }
    }

    private val _name: MutableLiveData<String> by lazy {
        MutableLiveData<String>().also { it.value = "" }
    }

    private val _height: MutableLiveData<Double> by lazy {
        MutableLiveData<Double>().also { it.value = 0.0 }
    }

    private val _text = MutableLiveData<String>().apply {
        value = ""
    }
    val text: LiveData<String> = _text

    private fun updateText() {
        _text.value =  "${_name.value}${_age.value.toString()}岁了，身高是${_height.value}米"
    }

    fun updateAge(age: Int) {
        _age.value = age
        updateText()
    }

    fun updateName(name: String) {
        _name.value = name
        updateText()
    }

    fun updateHeight(height: Double) {
        _height.value = height
        updateText()
    }
}