package com.example.kabaddicounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.kabaddicounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: ScoreViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding  // Add this line

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        // Set the lifecycle owner and view model
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        // Set up click listeners
        binding.plusOneTeamA.setOnClickListener {
            viewModel.incrementScore(true, 1)
        }

        binding.plusTwoTeamA.setOnClickListener {
            viewModel.incrementScore(true, 2)
        }

        binding.plusOneTeamB.setOnClickListener {
            viewModel.incrementScore(false, 1)
        }

        binding.plusTwoTeamB.setOnClickListener {
            viewModel.incrementScore(false, 2)
        }

        binding.resetButton.setOnClickListener {
            viewModel.resetScores()
        }
    }
}