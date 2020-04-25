package com.mediancalculator

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    /*
    Regex for matching
    1,2,3,4
    1 , 2 ,3 ,4 ,6
    1.2 , 5, 5.5, 6
     */
    private val ARRAY_FORMAT_REGEX =
        """^(\s*-?\d+(\.\d+)?)(\s*,\s*-?\d+(\.\d+)?)*${'$'}""".toRegex()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setMeanMedianCalculatorUi(til_input, txt_mean, txt_median)

    }

    private fun setMeanMedianCalculatorUi(
        textInput: TextInputLayout,
        meanTextView: TextView,
        medianTextView: TextView
    ) {

        textInput.editText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (!s.isNullOrBlank() && s.matches(ARRAY_FORMAT_REGEX)) {

                    textInput.error = null

                    val numbers = editableToFloatArray(s)

                    meanTextView.text = numbers.average().round(1).toString()
                    medianTextView.text = numbers.median().toString()

                } else {

                    if (textInput.error == null)
                        textInput.error = getString(R.string.invalid_input)

                    medianTextView.text = ""
                    meanTextView.text = ""
                }

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        })
    }

    private fun editableToFloatArray(s: Editable): List<Float> {
        return s.toString().replace(" ", "").split(",").map { it.toFloat() }
    }

}

