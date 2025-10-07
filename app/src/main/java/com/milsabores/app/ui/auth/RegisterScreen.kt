package com.milsabores.app.ui.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RegisterScreen(
    onRegisterSuccess: () -> Unit,
    onNavigateToLogin: () -> Unit,
    modifier: Modifier = Modifier,
    authViewModel: AuthViewModel = viewModel()
) {
    LaunchedEffect(authViewModel.isEmailConfirmationRequired) {
        if (authViewModel.isEmailConfirmationRequired) {
            onRegisterSuccess()
        }
    }

    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Crear Cuenta",
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
            onClick = authViewModel::register,
            enabled = !authViewModel.isLoading,
            modifier = Modifier.fillMaxWidth()

        ) {
            if (authViewModel.isLoading) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(16.dp)
                )
            } else {
                Text("Registrarse")
            }
        }

        TextButton(onClick = onNavigateToLogin) {
            Text("¿Ya tienes una cuenta? Inicia sesión")
        }

    }
}