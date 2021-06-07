package com.example.messageexample.ui.view.message

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messageexample.data.model.MessageModel
import com.example.messageexample.databinding.ActivityMainBinding
import com.example.messageexample.ui.view.messagedetail.MessageDetailActivity
import com.example.messageexample.ui.viewmodel.MessageViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    var context = this
    lateinit var adapter : MessageAdapter

    private val messageViewModel : MessageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        messageViewModel.onCreate()
        initObserver()
    }

    private fun initObserver(){
        messageViewModel.messageModel.observe(this, Observer {
            binding.apply {
                rvMessage.layoutManager = LinearLayoutManager(context)
                adapter = MessageAdapter(context, it, object : MessageAdapter.ElementClick{
                    override fun onElementClick(element: MessageModel) {
                        goToMessageDetail(element)
                    }
                })
                rvMessage.adapter = adapter

                val item = object : SwipeAdapter(context, 0, ItemTouchHelper.LEFT){
                    override fun onSwiped(
                        viewHolder: RecyclerView.ViewHolder,
                        direction: Int
                    ) {
                        adapter.delete(viewHolder.adapterPosition)
                        super.onSwiped(viewHolder, direction)
                    }
                }
                val itemTouchHelper = ItemTouchHelper(item)
                itemTouchHelper.attachToRecyclerView(rvMessage)
            }
        })
    }

    private fun goToMessageDetail(element: MessageModel){
        val intent = Intent(this, MessageDetailActivity::class.java)
        intent.putExtra("tittle", element.title)
        intent.putExtra("body", element.body)
        setResult(Activity.RESULT_OK, intent)
        startActivity(intent)
    }

    private fun swipeToDelete(){
    }

}