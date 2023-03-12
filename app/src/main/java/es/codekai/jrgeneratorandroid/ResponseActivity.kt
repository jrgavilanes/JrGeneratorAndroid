package es.codekai.jrgeneratorandroid

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import es.codekai.jrgeneratorandroid.databinding.ActivityResponseBinding

const val RESPONSE_ACTIVITY_NAME = "RESPONSE_ACTIVITY_NAME"

class ResponseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResponseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResponseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUI()
    }

    private fun setUI() {
        binding.apply {
            btnReponse.setOnClickListener {
                if (!txtResponse.text.isNullOrEmpty()) {
                    val intent = Intent().apply {
                        putExtra(RESPONSE_ACTIVITY_NAME, txtResponse.text.toString())
                    }
                    setResult(RESULT_OK, intent)
                } else {
                    setResult(RESULT_CANCELED)
                }
                finish()
            }
            btnSelectPrinter.setOnClickListener {
                showPrinterDialog()
            }
        }
    }

    private fun showPrinterDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.select_printer_dialog)
        dialog.setCancelable(false)

        val btnCancel = dialog.findViewById<Button>(R.id.btnCancel)
        val btnAccept = dialog.findViewById<Button>(R.id.btnAccept)
        val rbPrinter1 = dialog.findViewById<RadioButton>(R.id.rbPrinter1)
        val rbPrinter2 = dialog.findViewById<RadioButton>(R.id.rbPrinter2)
        val rbPrinter3 = dialog.findViewById<RadioButton>(R.id.rbPrinter3)

        btnAccept.setOnClickListener {
            if (rbPrinter1.isChecked) {
                binding.txtSelectedPrinter.text = rbPrinter1.text
            } else if (rbPrinter2.isChecked) {
                binding.txtSelectedPrinter.text = rbPrinter2.text
            } else if (rbPrinter3.isChecked) {
                binding.txtSelectedPrinter.text = rbPrinter3.text
            }
            dialog.hide()
        }

        btnCancel.setOnClickListener {
            dialog.hide()
        }

        dialog.show()
    }
}
