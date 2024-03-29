package com.kraemericaindustries.section13_recordkeeper.running

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kraemericaindustries.section13_recordkeeper.EditRecordActivity
import com.kraemericaindustries.section13_recordkeeper.INTENT_EXTRA_SCREEN_DATA
import com.kraemericaindustries.section13_recordkeeper.databinding.FragmentRunningBinding

class RunningFragment : Fragment() {
    private lateinit var binding: FragmentRunningBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRunningBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }
    override fun onResume() {
        super.onResume()
        displayRecords()
    }
    private fun setupClickListeners() {
        binding.container5km.setOnClickListener { launchRunningRecordScreen("5km") }
        binding.container10km.setOnClickListener { launchRunningRecordScreen("10km") }
        binding.container15km.setOnClickListener { launchRunningRecordScreen("15km") }
        binding.container20km.setOnClickListener { launchRunningRecordScreen("20km") }
    }
    private fun displayRecords() {
        val runningPreferences = requireContext().getSharedPreferences(FILENAME, Context.MODE_PRIVATE)

        binding.textView5kmValue.text = runningPreferences.getString("5km ${EditRecordActivity.SHARED_PREFERENCE_RECORD_KEY}", null)
        binding.textView5kmDate.text = runningPreferences.getString("5km ${EditRecordActivity.SHARED_PREFERENCE_DATE_KEY}", null)
        binding.textView10kmValue.text = runningPreferences.getString("10km ${EditRecordActivity.SHARED_PREFERENCE_RECORD_KEY}", null)
        binding.textView10kmDate.text = runningPreferences.getString("10km ${EditRecordActivity.SHARED_PREFERENCE_DATE_KEY}", null)
        binding.textView15kmValue.text = runningPreferences.getString("15km ${EditRecordActivity.SHARED_PREFERENCE_RECORD_KEY}", null)
        binding.textView15kmDate.text = runningPreferences.getString("15km ${EditRecordActivity.SHARED_PREFERENCE_DATE_KEY}", null)
        binding.textView20kmValue.text = runningPreferences.getString("20km ${EditRecordActivity.SHARED_PREFERENCE_RECORD_KEY}", null)
        binding.textView20kmDate.text = runningPreferences.getString("20km ${EditRecordActivity.SHARED_PREFERENCE_DATE_KEY}", null)
    }
    private fun launchRunningRecordScreen(distance: String) {
        val intent = Intent(context, EditRecordActivity::class.java)
        intent.putExtra(INTENT_EXTRA_SCREEN_DATA, EditRecordActivity.ScreenData(distance, FILENAME, "Time"))
        startActivity(intent)
    }

    companion object {
        const val FILENAME = "running"
    }

}