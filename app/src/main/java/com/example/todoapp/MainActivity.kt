package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding:ActivityMainBinding
    private lateinit var  db:NoteDatabaseHelper
    private lateinit var adapter:NotesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db= NoteDatabaseHelper(this)
        adapter=NotesAdapter(db.getAllNotes(),this)

        binding.notesRecyclerView.layoutManager=LinearLayoutManager(this)
        binding.notesRecyclerView.adapter= adapter

        binding.addButton.setOnClickListener{
            val intent=Intent(this,AddNoteActivity::class.java)
            startActivity(intent)

        }

    }
    override fun onResume() {
        super.onResume()
        adapter.refreshData(db.getAllNotes())
    }
}


