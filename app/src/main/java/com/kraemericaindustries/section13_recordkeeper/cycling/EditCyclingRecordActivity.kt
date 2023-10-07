package com.kraemericaindustries.section13_recordkeeper.cycling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kraemericaindustries.section13_recordkeeper.databinding.ActivityEditCyclingRecordBinding
class EditCyclingRecordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditCyclingRecordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditCyclingRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val heading: String? = intent.getStringExtra("Heading")
        title = "$heading Record"
    }
}