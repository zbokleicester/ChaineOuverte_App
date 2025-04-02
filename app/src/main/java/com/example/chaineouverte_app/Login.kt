package com.example.chaineouverte_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.chaineouverte_app.CreateAccountActivity
import com.example.chaineouverte_app.data.database.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Login : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val buttonInscription = findViewById<Button>(R.id.buttonInscription)
        val Email = findViewById<EditText>(R.id.Email)
        val Mot_de_passe = findViewById<EditText>(R.id.Mot_de_passe)
        val ErrorMdp = findViewById<TextView>(R.id.ErrorMdp)
        val CreateAccount = findViewById<TextView>(R.id.CreateAccount)




        buttonInscription.setOnClickListener{

            ErrorMdp.visibility = View.GONE
            val txtEmail = Email.text.toString()
            val txtMot_de_passe = Mot_de_passe.text.toString()
            //val ErrorMdp = ErrorMdp.text.toString()
            if (txtEmail.trim().isEmpty() || txtMot_de_passe.trim().isEmpty()) {
                ErrorMdp.text = "Vous devez remplir tous les champs"
                ErrorMdp.visibility = View.VISIBLE
                return@setOnClickListener
            }

            CoroutineScope(Dispatchers.IO).launch {

                val utilisateur = AppDatabase.getInstance(this@Login).utilisateurDao().testconnexion(email = txtEmail, motDePasse = txtMot_de_passe)
                if (utilisateur == null) {
                    withContext(Dispatchers.Main){
                        ErrorMdp.text = "Email/mot de passe incorrect"
                        ErrorMdp.visibility = View.VISIBLE
                    }
                    return@launch
                }

                // Intent explicite
                Intent(this@Login, HomeActivity::class.java).also { it ->
                    it.putExtra("Email", txtEmail)
                    startActivity(it)
                }
            }
        }

        CreateAccount.setOnClickListener{

            val intent = Intent(this, CreateAccountActivity::class.java)
            startActivity(intent)
        }
    }
}



