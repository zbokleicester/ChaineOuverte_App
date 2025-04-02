package com.example.chaineouverte_app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.chaineouverte_app.data.model.Utilisateur

@Dao
interface UtilisateurDao {
    @Insert
    suspend fun insert(user: Utilisateur)

    @Query("SELECT * FROM Utilisateur_table WHERE Email = :email LIMIT 1")
    suspend fun getUserByEmail(email: String): Utilisateur?

    @Query("SELECT * FROM Utilisateur_table WHERE Email = :email and Mot_de_passe = :motDePasse LIMIT 1")
    suspend fun testconnexion(email: String, motDePasse: String): Utilisateur?


}

