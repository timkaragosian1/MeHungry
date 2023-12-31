package com.example.mehungry.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mehungry.R

@Composable
fun SignInScreen(
    onSignUpNavButtonClick: () -> Unit,
    onSignInButtonClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column {
        Text(text = "Sign In Screen")

        SignInUpAuthButton(
            labelResourceId = R.string.sign_in_auth_button_text,
            onClick = onSignInButtonClick
        )

        SignInUpAuthButton(
            labelResourceId = R.string.sign_up_nav_button_text,
            onClick = onSignUpNavButtonClick
        )
    }
}

@Composable
fun SignInUpAuthButton(
    @StringRes labelResourceId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.widthIn(min = 250.dp)
    ) {
        Text(stringResource(labelResourceId))
    }
}

@Composable
fun SignUpScreen(
    onBackToSignInClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column {
        Text(text = "Sign Up Screen")

        SignInUpAuthButton(
            labelResourceId = R.string.sign_up_back_button_text,
            onClick = onBackToSignInClick
        )
    }
}

@Composable
fun SignInAuthScreen(
    onBackToSignInClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column {
        Text(text = "Sign In Auth Screen")

        SignInUpAuthButton(
            labelResourceId = R.string.sign_up_back_button_text,
            onClick = onBackToSignInClick
        )
    }
}