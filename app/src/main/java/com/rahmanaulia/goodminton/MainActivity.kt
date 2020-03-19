package com.rahmanaulia.goodminton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var counterViewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
        firstInit()
        onClick()
    }

    private fun firstInit() {
        counterViewModel.getScoreA()?.observe(this, Observer {
            if (it != null){
                tvScoreA.text = it.toString()
            }
        })

        counterViewModel.getScoreB()?.observe(this, Observer {
            tvScoreB.text = it.toString()
        })
    }

    private fun initViewModel() {
        counterViewModel = ViewModelProvider(this).get(CounterViewModel::class.java)
    }

    private fun onClick() {
        btnPlusA.setOnClickListener {
            counterViewModel.addScoreA(1)
        }

        btnPlusB.setOnClickListener {
            counterViewModel.addScoreB(1)
        }

        btnMinA.setOnClickListener {
            counterViewModel.minScoreA(1)
        }

        btnMinB.setOnClickListener {
            counterViewModel.minScoreB(1)
        }

        btnReset.setOnClickListener {
            counterViewModel.resetScore()
        }
    }
}
