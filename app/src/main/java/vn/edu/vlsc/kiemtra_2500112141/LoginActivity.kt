package vn.edu.vlsc.kiemtra_2500112141

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString()

            val errorRes = when {
                email.isEmpty() && password.isEmpty() -> R.string.err_empty_both
                email.isEmpty() -> R.string.err_empty_email
                password.isEmpty() -> R.string.err_empty_password
                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> R.string.err_invalid_email
                password.length < 6 -> R.string.err_short_password
                else -> null
            }

            if (errorRes != null) {
                tvStatus.setTextColor(getColor(R.color.error_red))
                tvStatus.setText(errorRes)
            } else {
                tvStatus.setTextColor(getColor(R.color.success_green))
                tvStatus.setText(R.string.msg_login_ok)

                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("EMAIL", email)
                startActivity(intent)
            }
        }
    }
}