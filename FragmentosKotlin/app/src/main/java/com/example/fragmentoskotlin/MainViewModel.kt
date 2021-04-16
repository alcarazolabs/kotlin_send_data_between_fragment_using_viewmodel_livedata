package com.example.fragmentoskotlin

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.android.parcel.Parcelize

class MainViewModel : ViewModel() {
  private  val user = MutableLiveData<Usuario>()

    fun setUsuario(usuario: Usuario){ //setear informeacion a mutableLivedata
        user.value = usuario
    }
    //exponer informacion
    fun getUsuario(): LiveData<Usuario>{
        return user //retornar el mutableLiveData.. Es observable ya que es LiveData
    }


}

@Parcelize //Para usar esta anotacion se agrego el plugin id 'kotlin-android-extensions' al gradle de aplicacion. Esto permitira que el bundle se descomprima y se pueda enviar desde el fragment 2 el dato al fragment 1
data class Usuario(val nombre: String, val edad: Int) : Parcelable
//Parcelize descomprime que el objeto se descomprima y se envie por un bundle