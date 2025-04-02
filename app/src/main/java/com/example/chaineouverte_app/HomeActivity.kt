package com.example.chaineouverte_app

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.chaineouverte_app.data.model.SportType

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val listView = findViewById<ListView>(R.id.ListPost)

        // Créer une liste dynamique à partir de SportType
        val sportList = SportType.values().map { sport ->
            PostActivite(sport.name, sport.description, sport.drawableId)
        }

        // Convertir la liste en ArrayList<PostActivite>
        val postsAdapter = PostsAdapter(
            this,
            R.layout.item_post,
            ArrayList(sportList) // Conversion explicite en ArrayList<PostActivite>
        )

        listView.adapter = postsAdapter

        // Détecter le clic sur un item
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedPost = postsAdapter.getItem(position)

            // Créer un Intent pour démarrer PostDetailActivity
            val intent = Intent(this, PostDetailActivity::class.java)
            intent.putExtra("sport_type", selectedPost?.titre) // Passer le sport sélectionné
            intent.putExtra("exercice_name", selectedPost?.titre) // Passer le nom de l'exercice sélectionné
            startActivity(intent)
        }
    }
}
