package com.example.chaineouverte_app.data.model

import androidx.annotation.DrawableRes
import com.example.chaineouverte_app.R

enum class SportType(
    val description: String,
    @DrawableRes val drawableId: Int,
    val exercices: Class<*>
) {
    Running("Supra course", R.drawable.hommequicours, RunningExercices::class.java),
    Cycling("Supra vélo", R.drawable.cycling, CyclingExercices::class.java),
    Swimming("Supra nage", R.drawable.swimming, SwimmingExercices::class.java),
    StrengthTraining("Supra force", R.drawable.strongman, StrengthTrainingExercices::class.java)
}
