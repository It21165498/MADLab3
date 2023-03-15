package com.example.lab3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.example.lab3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnSubmit.setOnClickListener {
            showAlertBox(
                this,
                binding.edtName.text.toString(),
                binding.edtEmail.text.toString(),
                binding.edtPhone.text.toString(),
                binding.edtPassword.text.toString(),
                binding.edtRePassword.text.toString()

            )
        }

        binding.btnCancel.setOnClickListener {
            binding.edtName.setText("")
            binding.edtEmail.setText("")
            binding.edtPhone.setText("")
            binding.edtPassword.setText("")
            binding.edtRePassword.setText("")

        }




    }//end ofCreate method

    fun showAlertBox(
        context: Context,
        name: String,
        email: String,
        phone: String,
        password: String,
        rePassword: String
    ) {
        val builder = AlertDialog.Builder(context)

        val message =   "Email: $email\n" +
                "Phone: $phone\n" +
                "Passwords: ${if (password == rePassword) "Matching" else "Not Matching"}."

        builder.setTitle("Welcome $name!")
        builder.setMessage(message)

        builder.setPositiveButton("Ok") { _, _ ->
            Toast.makeText(context, "Submitted", Toast.LENGTH_LONG).show()
        }

        builder.setNegativeButton("Cancel") { _, _ ->
        }

        val dialog = builder.create()
        dialog.show()
    }
}