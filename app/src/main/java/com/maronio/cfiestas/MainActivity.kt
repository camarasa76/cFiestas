package com.maronio.cfiestas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()/*,  AdapterView.OnItemClickListener*/ {

    private var acumulado=0f
    private var totalGto=0f
    private var import=0f
    private var totalPers: Int=0
    private var precioxPer: Float=0f
    private var nPers=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // val comensales = resources.getStringArray(R.array.arrayComensales)
        val num=resources.getStringArray(R.array.arrayPers)

        //************************* CLICK BOTON GUARDAR

        btnGuardar.setOnClickListener {

            val nPers=findViewById<Spinner>(R.id.npers)
            val adaptador=ArrayAdapter(this, android.R.layout.simple_spinner_item, num)
/*                    nPers.adapter = adaptador
                    nPers.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(

                            parent: AdapterView<*>, view: View,
                            position: Int,
                            id: Long)

                        {
                            Toast.makeText(this,
                                getString(num[position],
                                Toast.LENGTH_SHORT).show()}

                        override fun onNothingSelected(parent: AdapterView<*>?) {
                            TODO("Not yet implemented")
                        }
                    }
*/

            guardar()  // Función  para guardar registros

            //   totalPers += npers.getPositionForView()
            Toast.makeText(this, "pulsado boton guardar $totalGto",
                Toast.LENGTH_LONG).show()

            acumulado=0f
        }

        // ***************** CLICK DEL BOTON ACUMULAR.

        // por cada comensal se irán guardando lo gastado, num pers y comensal
        btnAcumular.setOnClickListener {
            tvAcumulado.visibility=View.VISIBLE

            //                 import = importeGto.text.toString().toFloat()

            // funcioón para acumular importes de los gastos por comensal/familia

            acumular()

        }
    }

    fun acumular() {
        import=importeGto.text.toString().toFloat()
        acumulado+=import // se acumula lo gastado por comensal/familia
        tvAcumulado.text=acumulado.toString() // Mostramos el total acumulado de gastos por comensal
        importeGto.setText("")
        Toast.makeText(this,
            " Gasto, ${import},   acumulado ${acumulado}",
            Toast.LENGTH_LONG).show()
    }

    fun guardar() {
        //  tvAcumulado.setText("Acumulado 0")
        // por cada comensal que se guarde lo que ha gastado el campo se invisibiliza
        tvAcumulado.visibility=View.INVISIBLE

        //    nPers = findViewById<Spinner>(R.id.npers)

        totalPers+=1  // Aqui irá el número de personas seleccionadas del spinner que asiste al evento, se acumularán
        // para hacer cálculos àra el reparto,  de momento para pruebas se suma 1

        totalGto+=acumulado // Se totaliza lo gastado por comensal para hacer calculos para el reparto

        // Se calcula el precio por persona en base al total de todos los gastos
        tvPrecioxPersona.text=(totalGto / totalPers).toString()
        tvPersonas.text=totalPers.toString()
        tvTotal.text=totalGto.toString()

    }

}






