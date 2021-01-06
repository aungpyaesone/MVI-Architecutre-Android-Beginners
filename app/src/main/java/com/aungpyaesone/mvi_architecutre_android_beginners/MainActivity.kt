package com.aungpyaesone.mvi_architecutre_android_beginners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.aungpyaesone.mvi_architecutre_android_beginners.adapter.MainAdapter
import com.aungpyaesone.mvi_architecutre_android_beginners.data.api.RetrofitBuilder
import com.aungpyaesone.mvi_architecutre_android_beginners.data.api.impls.ApiHelperImpl
import com.aungpyaesone.mvi_architecutre_android_beginners.data.model.User
import com.aungpyaesone.mvi_architecutre_android_beginners.ui.main.intent.MainIntent
import com.aungpyaesone.mvi_architecutre_android_beginners.ui.main.viewmodel.MainViewModel
import com.aungpyaesone.mvi_architecutre_android_beginners.ui.main.viewstate.MainState
import com.aungpyaesone.mvi_architecutre_android_beginners.utils.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.recyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var mMainViewModel: MainViewModel
    private var mAdapter = MainAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setupViewModel()
        observableViewModel()
        setupClicks()
    }

    private fun setupClicks() {
        buttonFetchUser.setOnClickListener {
            lifecycleScope.launch {
                mMainViewModel.userIntent.send(MainIntent.FetchUser)
            }
        }

        swipeRefresh.setOnRefreshListener {
            swipeRefresh.isRefreshing = true
            lifecycleScope.launch {
                mMainViewModel.userIntent.send(MainIntent.SwipeRefreshIntent)
            }
        }
    }

    private fun observableViewModel() {
        lifecycleScope.launch {
            mMainViewModel.state.collect {
                when(it){
                    is MainState.Idle ->{
                        swipeRefresh.isRefreshing = false
                    }
                    is MainState.Loading ->{
                        buttonFetchUser.visibility = View.GONE
                        progressBar.visibility = View.VISIBLE
                        swipeRefresh.isRefreshing = true
                    }
                    is MainState.Users ->{
                        progressBar.visibility = View.GONE
                        swipeRefresh.isRefreshing = false
                        buttonFetchUser.visibility = View.GONE
                        renderList(it.user)
                    }
                    is MainState.Errors -> {
                        progressBar.visibility = View.GONE
                        buttonFetchUser.visibility = View.VISIBLE
                        swipeRefresh.isRefreshing = false
                        Toast.makeText(this@MainActivity,it.error,Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }


    private fun renderList(user:List<User>){
        recyclerView.visibility = View.VISIBLE
        user?.let {
            mAdapter.setData(it)
        }

    }
    private fun setupViewModel() {
        mMainViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelperImpl(RetrofitBuilder.apiService)))
            .get(MainViewModel::class.java)
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.run {
            addItemDecoration(
                DividerItemDecoration(
                    recyclerView.context,
                    (recyclerView.layoutManager as LinearLayoutManager).orientation
                )
            )
        }
        recyclerView.adapter = mAdapter
    }
}