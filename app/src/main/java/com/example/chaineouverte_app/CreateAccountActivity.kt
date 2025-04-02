package com.example.chaineouverte_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.chaineouverte_app.R
import com.example.chaineouverte_app.data.database.AppDatabase
import com.example.chaineouverte_app.data.model.Utilisateur
import kotlinx.coroutines.launch

class CreateAccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        val Nom = findViewById<EditText>(R.id.Nom)
        val Email = findViewById<EditText>(R.id.Email)
        val Mot_de_passe = findViewById<EditText>(R.id.Mot_de_passe)
        val ConfirmMdp = findViewById<EditText>(R.id.ConfirmMdp)
        val errorTextView = findViewById<TextView>(R.id.ErrorMdp)
        val buttonInscription = findViewById<Button>(R.id.buttonInscription)
        val AlreadyAccount = findViewById<TextView>(R.id.AlreadyAccount)

        buttonInscription.setOnClickListener {
            val nom = Nom.text.toString()
            val email = Email.text.toString()
            val motdepasse = Mot_de_passe.text.toString()
            val confirmPassword = ConfirmMdp.text.toString()

            if (motdepasse != confirmPassword) {
                errorTextView.visibility = TextView.VISIBLE
                return@setOnClickListener
            }

            // Créer un objet User
            val utilisateur = Utilisateur(Nom = nom, Email = email, Mot_de_passe = motdepasse)

            // Insérer l'utilisateur dans la base de données Room
            val db = AppDatabase.getInstance(applicationContext)
            val utilisateurDao = db.utilisateurDao()

            lifecycleScope.launch {
                utilisateurDao.insert(utilisateur)

            }


        }

            AlreadyAccount.setOnClickListener{

            val intent = Intent(this, Login::class.java)
           startActivity(intent)
        }
    }
}

