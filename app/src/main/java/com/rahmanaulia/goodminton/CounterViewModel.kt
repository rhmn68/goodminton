package com.rahmanaulia.goodminton

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class CounterViewModel(application: Application): AndroidViewModel(application){

    private val scoreA : MutableLiveData<Int>? = MutableLiveData()
    private val scoreB : MutableLiveData<Int>? = MutableLiveData()

    fun addScoreA(point: Int){
        val result = getScoreA()?.value?.plus(point)
        scoreA?.postValue(result)
    }

    fun addScoreB(point: Int){
        val result = getScoreB()?.value?.plus(point)
        scoreB?.postValue(result)
    }

    fun minScoreA(point: Int){
        val result = getScoreA()?.value?.minus(point)
        if (result!! < 0){
            scoreA?.postValue(0)
        }else{
            scoreA?.postValue(result)
        }
    }

    fun minScoreB(point: Int){
        val result = getScoreB()?.value?.minus(point)
        if (result!! < 0){
            scoreB?.postValue(0)
        }else{
            scoreB?.postValue(result)
        }
    }

    fun resetScore(){
        scoreA?.postValue(0)
        scoreB?.postValue(0)
    }

    fun getScoreA(): LiveData<Int>?{
        if (scoreA?.value == null){
            scoreA?.postValue(0)
        }
        return scoreA
    }

    fun getScoreB(): LiveData<Int>?{
        if (scoreB?.value == null){
            scoreB?.postValue(0)
        }
        return scoreB
    }
}