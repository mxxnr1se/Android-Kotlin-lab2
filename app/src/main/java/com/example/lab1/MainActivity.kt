package com.example.lab1

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.RangeSlider
import java.text.NumberFormat
import java.util.*


class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val spinner: Spinner = findViewById(R.id.droplist)
		ArrayAdapter.createFromResource(this, R.array.spinner_values, R.layout.spinner_item).also { adapter ->
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
				spinner.adapter = adapter
			}
	}

	fun onOk(view: View) {
		val spinner = findViewById<Spinner>(R.id.droplist)
		val checkbox_m1 = findViewById<CheckBox>(R.id.checkbox_m1)
		val checkbox_m2 = findViewById<CheckBox>(R.id.checkbox_m2)
		val checkbox_m3 = findViewById<CheckBox>(R.id.checkbox_m3)
		val rangeSlider = findViewById<com.google.android.material.slider.RangeSlider>(R.id.range_slider)
		var flag = 0
		var checkboxValues = "Manufacturer:  "

		if (spinner.selectedItem.toString() == "") {
			Toast.makeText(this, "Tableware doesn't checked", Toast.LENGTH_SHORT).show()
			return
		}


		if (checkbox_m1.isChecked) {
			checkboxValues += "\n\t\t" + checkbox_m1.text.toString()
			flag = 1
		}
		if (checkbox_m2.isChecked) {
			checkboxValues += "\n\t\t" + checkbox_m2.text.toString()
			flag = 1
		}
		if (checkbox_m3.isChecked) {
			checkboxValues += "\n\t\t" + checkbox_m3.text.toString()
			flag = 1
		}
		if (flag == 0) {
			Toast.makeText(this, "Checkbox doesn't checked", Toast.LENGTH_SHORT).show()
			return
		}

		rangeSlider.setLabelFormatter { value: Float ->
			val format = NumberFormat.getCurrencyInstance()
			format.maximumFractionDigits = 0
			format.currency = Currency.getInstance("USD")
			format.format(value.toDouble())
		}

		rangeSlider.addOnChangeListener { slider, value, fromUser ->
			slider.values[slider.activeThumbIndex]
		}

		findViewById<TextView>(R.id.textResult).text =
			"Tableware: " + "\n\t\t" + spinner.selectedItem.toString() + "\n" + checkboxValues + "\n" + rangeSlider.values[0].toInt() + " - " + rangeSlider.values[1].toInt() + " USD"
	}
}