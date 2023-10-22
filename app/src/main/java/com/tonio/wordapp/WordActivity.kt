package com.tonio.wordapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.tonio.wordapp.databinding.ActivityMainBinding

class WordActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    private val viewModel: WordsViewModel by viewModels()

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.addWordFab.setOnClickListener { showAddWordDialog() }

        viewModel.getAllWords().observe(this){
            binding.wordsRecyclerView
        }
    }

    private fun showAddWordDialog() {
        MaterialDialog(this).show {
            input { dialog, text ->
                viewModel.saveWord(text.toString())
            }
            positiveButton(text = "Submit")
        }
    }
}