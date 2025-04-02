package com.example.chaineouverte_app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Utilisateur_table")
data class Utilisateur(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val Nom: String,
    val Email: String,
    val Mot_de_passe: String
)