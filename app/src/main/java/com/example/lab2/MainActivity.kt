package com.example.lab2

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import com.example.lab2.fragments.FragmentForm
import com.example.lab2.fragments.FragmentResult

class MainActivity : AppCompatActivity(), FragmentForm.OnFragmentFormDataListener {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}

	override fun onSendData(data: String?) {
		if (data != "") (supportFragmentManager.findFragmentById(R.id.FragmentResult) as FragmentResult?)?.setSelectedItem(
			data
		)
	}
}