package com.example.jcuygulama12

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jcuygulama12.ui.theme.JCuygulama12Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JCuygulama12Theme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        val backStackEntry = navController.currentBackStackEntryAsState().value
                        val showBackButton = backStackEntry?.destination?.route != NavigationItems.Login.route
                        myTopBar(showBackButton , navController)
                    }) { innerPadding ->
                    AppNavHost(navController = navController, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myTopBar(showBackButton: Boolean, navController: NavHostController) {
    TopAppBar(title = { Text(text = "TopBar") },
        navigationIcon = {
            if (showBackButton) {
                Image(modifier = Modifier.size(35.dp).clickable { navController.popBackStack() }, painter = painterResource(id = R.drawable.img_1),contentDescription = null)}
            })

        }

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JCuygulama12Theme {
        Greeting("Android")
    }
}


@Composable
fun LoginScreen(navController: NavHostController , modifier: Modifier = Modifier) {

    Text(text = "Giriş Yap Sayfası")

    Button(onClick = {
        val nameSurname = "sude bayram"
        navController.navigate("${NavigationItems.Register.route}/$nameSurname")
    },
        modifier = modifier.padding(top = 19.dp)

    )
    {
        Text(text = "Kayıt Ol Sayfası")
    }}



@Composable
fun RegisterScreen(navController: NavHostController , modifier: Modifier = Modifier , nameSurname: String) {
    Text(text = "Kayıt Ol Sayfası : $nameSurname")
    Button(onClick = {
        navController.navigate(NavigationItems.Login.route)
    },
        modifier = modifier.padding(top = 19.dp)
    )
    {
        Text(text = "Giriş Yap Sayfası")
    }}

