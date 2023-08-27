package com.wallet.sadapay.ui.msisdn.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    val msisdnFieldValue = mutableStateOf("")
}