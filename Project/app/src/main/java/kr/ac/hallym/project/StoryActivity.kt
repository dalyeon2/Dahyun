package kr.ac.hallym.project

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.hallym.project.databinding.ActivityStoryBinding

class StoryActivity : AppCompatActivity() {
    lateinit var binding: ActivityStoryBinding
    lateinit var adapter: OneAdapter
    var contents: MutableList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_add)
        binding = ActivityStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        contents = mutableListOf<String>("ㅋㅋㅋㅋ", "우와", "귀여워")

        binding.commentView.layoutManager = LinearLayoutManager(this)
        binding.commentView.adapter = OneAdapter(contents)
        binding.commentView.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        )


        // 데이터 수신
        val receivedData = intent.getStringExtra("data_key")
        // receivedData를 사용하여 데이터 처리
    }

    /*
    override fun onCreateOptionsMenu (menu: Menu?): Boolean {
        menuInflater.inflate (R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

     */

    override fun onOptionsItemSelected (item: MenuItem): Boolean = when (item.itemId) {
        android.R.id.home -> { // 뒤로가기 버튼을 누를 때
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
            true
        }

        R.id.menu_add_save -> {
            val inputData = binding.addEditView.text.toString()
            val db = DBHelper (this).writableDatabase
            db.execSQL ("insert into TODO_TB (todo) values (?)",
                arrayOf<String>(inputData))
            db.close()

            val intent = Intent(this, SettingActivity::class.java)
            setResult(Activity.RESULT_OK, intent)
            finish()
            true
        }
        else -> true
    }
}