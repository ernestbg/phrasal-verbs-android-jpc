package com.ernestbg.phrasalverbs.navigation

enum class PhrasalVerbsScreens(val route: String, val label: String) {
    DictionaryScreen("dictionary", "Diccionario", ),
    LearnScreen("learn", "Aprendizaje"),
    PhrasalVerbDetailScreen("phrasal_verb_detail/{phrasalVerbId}", "Detalle del Phrasal Verb"),
    FavoritesScreen("favorites", "Favoritos");

    companion object {
        fun fromRoute(route: String?): PhrasalVerbsScreens =
            when (route?.substringBefore("/")) {
                DictionaryScreen.route -> DictionaryScreen
                LearnScreen.route -> LearnScreen
                PhrasalVerbDetailScreen.route -> PhrasalVerbDetailScreen
                FavoritesScreen.route -> FavoritesScreen
                null -> DictionaryScreen
                else -> throw IllegalArgumentException("Route $route is not recognized")
            }
    }
}