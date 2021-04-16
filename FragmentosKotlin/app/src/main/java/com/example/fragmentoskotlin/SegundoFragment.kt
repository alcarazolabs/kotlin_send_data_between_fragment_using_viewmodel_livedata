package com.example.fragmentoskotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs


class SegundoFragment : Fragment(R.layout.fragment_segundo) {

    //view mdel atachado a la actividad:
    private val viewModel: MainViewModel by activityViewModels() //De esta manera la activity contenedora de los fragmentos permitira que ambos fragmentos accedan al viewModel con el mismo contexto de la actividad que los contiene


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = view.findViewById<TextView>(R.id.txtFragment2)
        val button = view.findViewById<Button>(R.id.btnNavegarFrg2)


      //owner es quien esta escuchando la informacion.. observa mientras este owner este vivo en todo su ciclo de vida
      //si estamos en una actividad usamos this en vez de viewLifecyclerOwner
      viewModel.getUsuario().observe(viewLifecycleOwner, { usuario ->
            //este observer va a estar escichando y retornar la informacion de este liveData
           // text.text = "${it.nombre} - Edad: ${it.edad}"
            text.text = "${usuario.nombre} - Edad: ${usuario.edad}"
        } )
      //setear una informacion
      // previousBackStackEntry setea el valor al fragmento anterior al que abrio este fragmento.
      // el savedStateHandle perrmite que el valor sobreviba a la rotacion
      // set: Seteamos la clave y el result.. sera un bundle. Setear un usuario al previosBackEntry
      findNavController().previousBackStackEntry?.savedStateHandle?.set("usuario", Usuario("Daniel Ibañez", 40)) //Este usuario se envia comprimido. Para eso a la clase se agrego @Parcelize

    }


}