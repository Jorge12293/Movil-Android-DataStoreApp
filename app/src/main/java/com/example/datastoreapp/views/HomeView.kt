package com.example.datastoreapp.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.datastoreapp.dataStore.StoreDarkMode
import com.example.datastoreapp.dataStore.StoreUserEmail
import kotlinx.coroutines.launch

@Composable
fun HomeView(navController: NavController,darkModeStore: StoreDarkMode, darkMode: Boolean){
    Content(darkModeStore,darkMode)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content(darkModeStore: StoreDarkMode, darkMode: Boolean) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val dataStore = StoreUserEmail(context)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        var email by rememberSaveable { mutableStateOf("") }
        val userEmail = dataStore.getEmail.collectAsState(initial = "")

        Text(
            text = "Home",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        TextField(value = email, onValueChange = {email = it},
            keyboardOptions = KeyboardOptions().copy(keyboardType = KeyboardType.Email)
        )
        Spacer(modifier = Modifier.height(25.dp))
        Button(onClick = {
            scope.launch {
                dataStore.saveEmail(email)
            }
        }) {
            Text(text = "Save Email")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = userEmail.value)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            scope.launch {
                if (darkMode){
                    darkModeStore.saveDarkMode(false)
                }else{
                    darkModeStore.saveDarkMode(true)
                }
            }
        }) {
            Text(text = "Change Dark")
        }
        Switch(checked = darkMode, onCheckedChange = { isChecked->
            scope.launch {
                darkModeStore.saveDarkMode(isChecked)
            }
        })
    }
}
