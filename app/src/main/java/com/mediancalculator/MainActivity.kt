package com.mediancalculator

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /*
    Regex for matching
    1,2,3,4
    1 , 2 ,3 ,4 ,6
    1.2 , 5, 5.5, 6
     */
    private val ARRAY_FORMAT_REGEX = """^(\s*-?\d+(\.\d+)?)(\s*,\s*-?\d+(\.\d+)?)*${'$'}""".toRegex()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt_input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (!s.isNullOrBlank() && s.matches(ARRAY_FORMAT_REGEX)) {
                    til_input.error = null

                    val numbers = s.toString().replace(" ", "").split(",").map { it.toFloat() }

                    txt_mean.text = numbers.average().round(1).toString()

                    txt_median.text = numbers.median().toString()
                } else {
                    if (til_input.error == null)
                        til_input.error = getString(R.string.invalid_input)
                }

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        })
    }

}

