package com.example.todo_app

import android.app.Dialog
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.todo_app.databinding.ActivityMainBinding
import com.example.todo_app.utils.setupDialog

class MainActivity : AppCompatActivity() {

    private val mainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val addTaskDialog : Dialog by lazy {
        Dialog(this,R.style.DialogCustomTheme).apply {
            setupDialog(R.layout.add_task_dialog)
        }
    }

    private val updateTaskDialog : Dialog by lazy {
        Dialog(this,R.style.DialogCustomTheme).apply {
            setupDialog(R.layout.update_task_dialog)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        val addCloseImg = addTaskDialog.findViewById<ImageView>(R.id.cancelImg)
        val updateCloseImg = updateTaskDialog.findViewById<ImageView>(R.id.cancelImg)

        addCloseImg.setOnClickListener { addTaskDialog.dismiss() }
        updateCloseImg.setOnClickListener { updateTaskDialog.dismiss() }

        mainBinding.addTaskFABtn.setOnClickListener{
            addTaskDialog.show()

        }
    }
}