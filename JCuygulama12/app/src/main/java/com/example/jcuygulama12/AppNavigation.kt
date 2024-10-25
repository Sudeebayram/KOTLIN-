package com.example.jcuygulama12

enum class Screen{
    LOGIN,
    REGISTER
}

sealed class NavigationItems(val route: String){
    object Login: NavigationItems(Screen.LOGIN.name)
    object Register: NavigationItems(Screen.REGISTER.name)
}
