package com.altwav.technicalsummative3

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_loading.*
//val builder: AlertDialog.Builder = AlertDialog.Builder(getActivity())
class HomepageActivity : AppCompatActivity() {
    private lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        context = this
    }
    fun showLogin(v: View?) {
        var loginFragment = LoginDialogFragment()
        var fragmentManager = (context as FragmentActivity).supportFragmentManager
        loginFragment.show(fragmentManager, "Login")
    }

    class LoginDialogFragment : DialogFragment() {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val builder: AlertDialog.Builder = AlertDialog.Builder(getActivity())
            val inflater: LayoutInflater = getActivity()!!.getLayoutInflater()
            val v = inflater.inflate(R.layout.layout_login, null)
            val etUsername = v.findViewById<View>(R.id.username) as EditText
            val etPassword = v.findViewById<View>(R.id.password) as EditText
            builder.setView(v)
                .setPositiveButton(R.string.login, DialogInterface.OnClickListener { dialog, id ->
                    val username: String
                    val password: String
                    username = etUsername.text.toString()
                    password = etPassword.text.toString()
                    val msg: String
                    if (username.equals("altwav", ignoreCase = true) && password.equals("altwav", ignoreCase = true)) {
                        msg = "Access Granted"
                        val intent = Intent(context, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        msg = "Access Denied"
                    }
                    Toast.makeText(
                        context, msg,
                        Toast.LENGTH_SHORT
                    ).show()
                })
                .setNegativeButton(R.string.cancel,
                    DialogInterface.OnClickListener { dialog, id ->
                    })
            return builder.create()
        }



    }

}