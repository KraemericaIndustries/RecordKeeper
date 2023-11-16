package com.kraemericaindustries.section13_recordkeeper.cycling

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kraemericaindustries.section13_recordkeeper.CYCLING
import com.kraemericaindustries.section13_recordkeeper.EditRecordActivity
import com.kraemericaindustries.section13_recordkeeper.INTENT_EXTRA_SCREEN_DATA
import com.kraemericaindustries.section13_recordkeeper.databinding.FragmentCyclingBinding
class CyclingFragment : Fragment() {

    private lateinit var binding: FragmentCyclingBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCyclingBinding.inflate(inflater, container, false)
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
    private fun displayRecords() {
        val cyclingPreferences = requireContext().getSharedPreferences(CYCLING, Context.MODE_PRIVATE)

        binding.textViewLongestRideValue.text = cyclingPreferences.getString("Longest Ride record", null)
        binding.textViewLongestRideDate.text = cyclingPreferences.getString("Longest Ride date", null)
        binding.textViewBiggestClimbValue.text = cyclingPreferences.getString("Biggest Climb record", null)
        binding.textViewBiggestClimbDate.text = cyclingPreferences.getString("Biggest Climb date", null)
        binding.textViewBestAverageSpeedValue.text = cyclingPreferences.getString("Best Average Speed record", null)
        binding.textViewBestAverageSpeedDate.text = cyclingPreferences.getString("Best Average Speed date", null)
    }
    private fun setupClickListeners() {
        binding.containerLongestRide.setOnClickListener { launchEditCyclingRecordScreen("Longest Ride", "Distance") }
        binding.containerBiggestClimb.setOnClickListener { launchEditCyclingRecordScreen("Biggest Climb", "Height") }
        binding.containerBestAverageSpeed.setOnClickListener { launchEditCyclingRecordScreen("Best Average Speed", "Average Speed") }
    }
    private fun launchEditCyclingRecordScreen(record: String, recordFieldHint: String) {
        val intent = Intent(context, EditRecordActivity::class.java)
        intent.putExtra(INTENT_EXTRA_SCREEN_DATA, EditRecordActivity.ScreenData(record, CYCLING, recordFieldHint))
        startActivity(intent)
    }
}