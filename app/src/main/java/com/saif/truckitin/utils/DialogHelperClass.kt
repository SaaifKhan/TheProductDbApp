package com.saif.truckitin.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.TextView
import com.saif.truckitin.R
import kotlinx.android.synthetic.main.dialog_layout_error.*

class DialogHelperClass {
    companion object {

        fun loadingDialog(context: Context): Dialog {
            val dialog = Dialog(context)
            dialog.setContentView(R.layout.dialog_layout_loading)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setCancelable(false)
            return dialog
        }


        fun errorDialog(context: Context, errorMessage: String,clickAble: ClickAble) {
            val dialog = Dialog(context)
            dialog.setContentView(R.layout.dialog_layout_error)
            val errorTextMessage = dialog.findViewById<TextView>(R.id.tv_error_message)
            errorTextMessage.setText(errorMessage)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.retryBtn.setOnClickListener {
                clickAble.onclick()
                dialog.dismiss()
            }
            dialog.show()
        }
    }

    public interface ClickAble{
        fun onclick()
    }

}