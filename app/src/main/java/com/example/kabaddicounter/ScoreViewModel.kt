package com.example.kabaddicounter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    private val _scoreA = MutableLiveData<Int>(0)
    val scoreA: LiveData<Int> = _scoreA

    private val _scoreB = MutableLiveData<Int>(0)
    val scoreB: LiveData<Int> = _scoreB

    fun incrementScore(isTeamA: Boolean, points: Int) {
        if (isTeamA) {
            _scoreA.value = _scoreA.value?.plus(points) ?: points
        } else {
            _scoreB.value = _scoreB.value?.plus(points) ?: points
        }
    }

    fun resetScores() {
        _scoreA.value = 0
        _scoreB.value = 0
    }
}