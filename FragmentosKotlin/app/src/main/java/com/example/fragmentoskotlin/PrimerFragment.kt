package com.example.fragmentoskotlin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.*
import androidx.navigation.fragment.findNavController

class PrimerFragment : Fragment(R.layout.fragment_primer) {

   // private val viewModel: MainViewModel by viewModels() //Esta instancia solo permite que este fragmento pueda acceder a esete viewModel
   //view mdel atachado a la actividad: asignado al contexto de la actividad
    private val viewModel: MainViewModel by activityViewModels() //De esta manera la activity contenedora de los fragmentos permitira que ambos fragmentos accedan al viewModel con el mismo contexto de la actividad que los contiene
   //viewmodel compartido
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //mapeo de widgets
        val button = view.findViewById<Button>(R.id.btnNavegar)
        val texto = view.findViewById<TextView>(R.id.txtFragment1)

        button.setOnClickListener{
            // findNavController().navigate(R.id.action_primerFragment_to_segundoFragment, bundleOf("nombre" to "Freddy", "edad" to 24))

           // val action = PrimerFragmentDirections.actionPrimerFragmentToSegundoFragment("Freddy",24)
           // findNavController().navigate(action)

            viewModel.setUsuario(Usuario("Freddy Alc", 23))
            findNavController().navigate(R.id.action_primerFragment_to_segundoFragment)

        }
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<Usuario>("usuario")?.observe(viewLifecycleOwner) { result ->
            texto.text = "Nombre: ${result.nombre} - Edad: ${result.edad}"
        }

    }

    //para recibir los datos del fragment 2 debemos de escuchar un listener con setFragmentResultListener
    //para pasar parametros entre fragmento se agrego el plugin navigation-safe-args en el gradle del proyecto
    //classpath "androidx.navigation:navigation-safe-args-gradle-plugin:2.3.4"
    // y en el gradle de la aplicación se agrego el plugin  id 'androidx.navigation.safeargs.kotlin'
}