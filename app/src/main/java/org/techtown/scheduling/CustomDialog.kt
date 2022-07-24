package org.techtown.scheduling

import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import android.widget.EditText
import org.techtown.scheduling.databinding.SchediaolgBinding


class CustomDialog(context: Context) {
    private val dialog = Dialog(context)
    private lateinit var onClickListener: OnDialogClickListener

    fun setOnClickListener(listener: OnDialogClickListener)
    {
        onClickListener = listener
    }
    fun showDialog()
    {
        dialog.setContentView(R.layout.schediaolg)
        dialog.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

       // val edit_name = dialog.findViewById<EditText>(R.id.name_edit)

      //  dialog.cancel_button.setOnClickListener {
        //    dialog.dismiss()
       // }

   //     dialog.finish_button.setOnClickListener {
      //      onClickListener.onClicked(edit_name.text.toString())
     //       dialog.dismiss()
     //   }

    }
    interface OnDialogClickListener
    {
        fun onClicked(name: String)
    }

}