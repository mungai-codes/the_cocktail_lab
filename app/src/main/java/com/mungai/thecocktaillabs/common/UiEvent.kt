package com.mungaicodes.tomesanctuary.util

sealed class UiEvent {
    data class ShowSnackBar(val message: String) : UiEvent()

}
