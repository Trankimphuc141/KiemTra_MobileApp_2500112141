package vn.edu.vlsc.kiemtra_2500112141

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ProfileActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Ánh xạ View bằng findViewById
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        // Nhận Email do LoginActivity gửi sang
        val email = intent.getStringExtra("EMAIL")
        tvEmail.text = getString(R.string.profile_email, email)

        // Đăng xuất: đóng màn hình này, quay về LoginActivity
        btnLogout.setOnClickListener {
            finish()
        }
    }
}