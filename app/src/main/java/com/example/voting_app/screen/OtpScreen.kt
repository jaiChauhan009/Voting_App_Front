package com.example.voting_app.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun OtpScreen(navController: NavController, userDataStore: UserDataStore) {
    var otp by remember { mutableStateOf("") }

    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), verticalArrangement = Arrangement.Center
    ) {
        Text("Enter OTP", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = otp, onValueChange = { otp = it }, label = { Text("6-digit OTP") })

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            // Simulate OTP verification
            coroutineScope.launch {
                userDataStore.saveLoginState("user@example.com")
                navController.navigate("home")
            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Verify")
        }
    }
}
