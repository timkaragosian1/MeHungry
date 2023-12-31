package com.example.mehungry

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mehungry.ui.components.SignInAuthScreen
import com.example.mehungry.ui.components.SignInScreen
import com.example.mehungry.ui.components.SignUpScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


enum class SignInUpScreen(@StringRes val title: Int) {
    SignIn(title = R.string.title_sign_in),
    SignUp(title = R.string.title_sign_up),
    Authorize(title = R.string.title_authorize_sign_in)
}

@Composable
fun SignInUpApp(
    viewModel: SignInViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = SignInUpScreen.valueOf(
        backStackEntry?.destination?.route ?: SignInUpScreen.SignIn.name
    )

    Scaffold() {
        innerPadding -> val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = SignInUpScreen.SignIn.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = SignInUpScreen.SignIn.name) {
                Column(

                ){
                    SignInScreen(
                        onSignUpNavButtonClick = { navController.navigate(SignInUpScreen.SignUp.name) },
                        onSignInButtonClick = { navController.navigate(SignInUpScreen.Authorize.name) },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(dimensionResource(R.dimen.padding_medium))
                    )
                }
            }

            composable(route = SignInUpScreen.SignUp.name) {
                SignUpScreen(
                    onBackToSignInClick = { navController.navigate(SignInUpScreen.SignIn.name) },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }

            composable(route = SignInUpScreen.Authorize.name) {
                SignInAuthScreen(
                    onBackToSignInClick = { navController.navigate(SignInUpScreen.SignIn.name) },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
        }
    }
}

class SignInViewModel : ViewModel () {
    private val _uiState = MutableStateFlow(InitUiState())
    val uiState: StateFlow<InitUiState> = _uiState.asStateFlow()
}

data class InitUiState(
    val userName: String = "",
    val pass: String = "",
    val apiKey: String = "",
    val rememberMe: Boolean = false,
    val userJSON: String = ""
)