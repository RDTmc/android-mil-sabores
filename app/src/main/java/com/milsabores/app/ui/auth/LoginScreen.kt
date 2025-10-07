package com.milsabores.app.ui.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LoginScreen (
    onLoginSuccess: () -> Unit,
    onNavigateToRegister: () -> Unit,
    modifier: Modifier = Modifier,
    authViewModel: AuthViewModel = viewModel()
) {
   LaunchedEffect(authViewModel.isAuthenticated) {
       if (authViewModel.isAuthenticated) {
           onLoginSuccess()
       }
   }

   Column(
       modifier = Modifier
           .fillMaxSize()
           .padding(24.dp),
       horizontalAlignment = Alignment.CenterHorizontally,
       verticalArrangement = Arrangement.Center
   ) {
       Text(
           text = "Iniciar Sesión",
           style = MaterialTheme.typography.headlineMedium,
           modifier = Modifier.padding(bottom = 24.dp)
       )

       OutlinedTextField(
           value = authViewModel.email,
           onValueChange = authViewModel::onEmailChange,
           label = { Text("Email") },
           modifier = Modifier.fillMaxWidth()
       )

       Spacer(modifier = Modifier.height(16.dp))

       OutlinedTextField(
           value = authViewModel.password,
           onValueChange = authViewModel::onPasswordChange,
           label = { Text("Contraseña") },
           visualTransformation = PasswordVisualTransformation(),
           modifier = Modifier.fillMaxWidth()
       )

       if (authViewModel.errorMessage.isNotBlank()) {
           Spacer(modifier = Modifier.height(8.dp))
           Text(
               text = authViewModel.errorMessage,
               color = MaterialTheme.colorScheme.error,
               modifier = Modifier.fillMaxWidth()
           )
       }

       Spacer(modifier = Modifier.height(24.dp))

       Button(
           onClick = authViewModel::login,
           enabled = !authViewModel.isLoading,
           modifier = Modifier.fillMaxWidth()
       ) {
           if (authViewModel.isLoading) {
               CircularProgressIndicator(
                   color = MaterialTheme.colorScheme.onPrimary,
                   modifier = Modifier.size(24.dp)
               )
           } else {
               Text("Iniciar Sesión")
           }
       }

       TextButton(onClick = onNavigateToRegister) {
               Text("¿No tienes cuenta? Regístrate")
       }
   }
}





