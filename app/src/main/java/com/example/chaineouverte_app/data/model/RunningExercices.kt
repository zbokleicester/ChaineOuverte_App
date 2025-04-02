package com.example.chaineouverte_app.data.model

enum class RunningExercices(temps: List<Int>, distance: List<Int>) {
    SPRINT(listOf(15,25,45,60), listOf(15,25,45,60)),
    JOGGING(listOf(15,25,45,60), listOf(15,25,45,60)),
    FRACTIONNE(listOf(15,25,45,60), listOf(15,25,45,60)),
    MONTEES_DE_COTES(listOf(15,25,45,60), listOf(15,25,45,60)),
    FARTLEK(listOf(15,25,45,60), listOf(15,25,45,60)),
}
enum class SwimmingExercices(temps: List<Int>, distance: List<Int>) {
    ENDURANCE_LONGUE_DISTANCE(listOf(15,25,45,60), listOf(15,25,45,60)),
    SPRINTS_EN_COTES(listOf(15,25,45,60), listOf(15,25,45,60)),
    TRAINING_INTERVAL(listOf(15,25,45,60), listOf(15,25,45,60)),
    VELO_SALLE(listOf(15,25,45,60), listOf(15,25,45,60)),
    PISTE_VTT(listOf(15,25,45,60), listOf(15,25,45,60)),
}
enum class CyclingExercices(temps: List<Int>, distance: List<Int>) {
    NAGE_LIBRE(listOf(15,25,45,60), listOf(15,25,45,60)),
    SPRINT_BASSINS(listOf(15,25,45,60), listOf(15,25,45,60)),
    ENTRAINEMENT_PLANCHE(listOf(15,25,45,60), listOf(15,25,45,60)),
    NAGE_PALMES(listOf(15,25,45,60), listOf(15,25,45,60)),
    APNEE_DYNAMIC(listOf(15,25,45,60), listOf(15,25,45,60)),
}
enum class StrengthTrainingExercices(temps: List<Int>, distance: List<Int>) {
    SQUATS(listOf(15,25,45,60), listOf(15,25,45,60)),
    POMPES(listOf(15,25,45,60), listOf(15,25,45,60)),
    DEADLIFTS(listOf(15,25,45,60), listOf(15,25,45,60)),
    TRACTIONS(listOf(15,25,45,60), listOf(15,25,45,60)),
    PLANCHE(listOf(15,25,45,60), listOf(15,25,45,60))
}