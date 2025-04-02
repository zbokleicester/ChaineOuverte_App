package com.example.chaineouverte_app

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.chaineouverte_app.data.model.SportType

class PostDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)

        val titrePostDetail = findViewById<TextView>(R.id.TitrePostDetail)
        val gifImageView = findViewById<ImageView>(R.id.gifImageView)
        val listDetailPost = findViewById<ListView>(R.id.ListDetailPost)
        val buttonRetour = findViewById<Button>(R.id.button2)

        val sportTypeName = intent.getStringExtra("sport_type")
        val sportType = SportType.valueOf(sportTypeName ?: "Running")
        titrePostDetail.text = sportType.name

        val postActivites = when (sportType) {
            SportType.Running -> arrayListOf(
                PostActivite("Running 1", "Exercice 1 de running", R.drawable.hommequicours),
                PostActivite("Running 2", "Exercice 2 de running", R.drawable.hommequicours),
                PostActivite("Running 3", "Exercice 3 de running", R.drawable.hommequicours),
                PostActivite("Running 4", "Exercice 4 de running", R.drawable.hommequicours)
            )
            SportType.Cycling -> arrayListOf(
                PostActivite("Cycling 1", "Exercice 1 de vélo", R.drawable.cycling),
                PostActivite("Cycling 2", "Exercice 2 de vélo", R.drawable.cycling),
                PostActivite("Cycling 3", "Exercice 3 de vélo", R.drawable.cycling),
                PostActivite("Cycling 4", "Exercice 4 de vélo", R.drawable.cycling)
            )
            SportType.Swimming -> arrayListOf(
                PostActivite("Swimming 1", "Exercice 1 de natation", R.drawable.swimming),
                PostActivite("Swimming 2", "Exercice 2 de natation", R.drawable.swimming),
                PostActivite("Swimming 3", "Exercice 3 de natation", R.drawable.swimming),
                PostActivite("Swimming 4", "Exercice 4 de natation", R.drawable.swimming)
            )
            SportType.StrengthTraining -> arrayListOf(
                PostActivite("Strength Training 1", "Exercice 1 de force", R.drawable.strongman),
                PostActivite("Strength Training 2", "Exercice 2 de force", R.drawable.strongman),
                PostActivite("Strength Training 3", "Exercice 3 de force", R.drawable.strongman),
                PostActivite("Strength Training 4", "Exercice 4 de force", R.drawable.strongman)
            )
        }

        val postsAdapter = PostsAdapter(this, R.layout.item_post, postActivites)
        listDetailPost.adapter = postsAdapter

        listDetailPost.setOnItemClickListener { _, _, position, _ ->
            val selectedPost = postsAdapter.getItem(position)
            startTimer(selectedPost?.titre, sportType)
            loadGif(selectedPost?.titre, sportType)
        }

        buttonRetour.setOnClickListener {
            finish()
        }
    }

    private fun startTimer(exerciceName: String?, sportType: SportType) {
        Toast.makeText(this, "Démarrage du timer pour: $exerciceName", Toast.LENGTH_SHORT).show()
        object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                Toast.makeText(
                    applicationContext,
                    "Temps restant: ${millisUntilFinished / 1000} secondes",
                    Toast.LENGTH_SHORT
                ).show()
            }
            override fun onFinish() {
                Toast.makeText(applicationContext, "Le temps est écoulé pour: $exerciceName", Toast.LENGTH_LONG).show()
            }
        }.start()
    }

    private fun loadGif(exerciceName: String?, sportType: SportType) {
        val gifImageView = findViewById<ImageView>(R.id.gifImageView)
        val gifResource = when {
            sportType == SportType.Running && exerciceName == "Running 1" -> R.drawable.cours1
            sportType == SportType.Running && exerciceName == "Running 2" -> R.drawable.cours2
            sportType == SportType.Running && exerciceName == "Running 3" -> R.drawable.cours3
            sportType == SportType.Running && exerciceName == "Running 4" -> R.drawable.cours4
            sportType == SportType.Cycling && exerciceName == "Cycling 1" -> R.drawable.cycling1
            sportType == SportType.Cycling && exerciceName == "Cycling 2" -> R.drawable.cycling2
            sportType == SportType.Cycling && exerciceName == "Cycling 3" -> R.drawable.cycling3
            sportType == SportType.Cycling && exerciceName == "Cycling 4" -> R.drawable.cycling4
            sportType == SportType.Swimming && exerciceName == "Swimming 1" -> R.drawable.swimming1
            sportType == SportType.Swimming && exerciceName == "Swimming 2" -> R.drawable.swimming2
            sportType == SportType.Swimming && exerciceName == "Swimming 3" -> R.drawable.swimming3
            sportType == SportType.Swimming && exerciceName == "Swimming 4" -> R.drawable.swimming4
            sportType == SportType.StrengthTraining && exerciceName == "Strength Training 1" -> R.drawable.strenth1
            sportType == SportType.StrengthTraining && exerciceName == "Strength Training 2" -> R.drawable.strenth2
            sportType == SportType.StrengthTraining && exerciceName == "Strength Training 3" -> R.drawable.strenth3
            sportType == SportType.StrengthTraining && exerciceName == "Strength Training 4" -> R.drawable.strenth4
            else -> R.drawable.hommequicours
        }

        Glide.with(this)
            .asGif()
            .load(gifResource)
            .into(gifImageView)
    }
}