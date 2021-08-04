package mi.primer.calculadora

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var numero1: Double = 0.0
    private var numero2: Double = 0.0
    private var operacionEnCurso: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        Borrador()

        Boton_0.setOnClickListener {
            IngresoDeDatos(0)
        }

        Boton_1.setOnClickListener {
            IngresoDeDatos(1)
        }

        Boton_2.setOnClickListener {
            IngresoDeDatos(2)
        }

        Boton_3.setOnClickListener {
            IngresoDeDatos(3)
        }

        Boton_4.setOnClickListener {
            IngresoDeDatos(4)
        }

        Boton_5.setOnClickListener {
            IngresoDeDatos(5)
        }

        Boton_6.setOnClickListener {
            IngresoDeDatos(6)
        }

        Boton_7.setOnClickListener {
            IngresoDeDatos(7)
        }

        Boton_8.setOnClickListener {
            IngresoDeDatos(8)
        }

        Boton_9.setOnClickListener {
            IngresoDeDatos(9)
        }

        //-------------------------------------------------------------

        Boton_Suma.setOnClickListener {
            Texto.text = ""
            Operaciones(suma)
        }

        Boton_Resta.setOnClickListener {
            Texto.text = ""
            Operaciones(resta)
        }

        Boton_Multiplicacion.setOnClickListener {
            Texto.text = ""
            Operaciones(multiplicacion)
        }

        Boton_Division.setOnClickListener {
            Texto.text = ""
            Operaciones(division)
        }

        Boton_C.setOnClickListener {
            numero1 = 0.0
            numero2 = 0.0
            Texto.text = ""
            operacionEnCurso = noHayOperacion
        }

        Boton_Igual.setOnClickListener {
            var resultado = when (operacionEnCurso) {
                suma -> numero1 + numero2
                resta -> numero1 - numero2
                multiplicacion -> numero1 * numero2
                division -> numero1 / numero2

                else -> 0
            }

            Texto.text = resultado.toString()
        }
    }

    fun Borrador() {
        numero1 = 0.0
        numero2 = 0.0
        Texto.text = ""
        operacionEnCurso = noHayOperacion
    }

    fun IngresoDeDatos(digito: Int) {

        Texto.text = "${Texto.text}$digito"

        if (operacionEnCurso == noHayOperacion) {
            numero1 = Texto.text.toString().toDouble()
        } else {
            numero2 = Texto.text.toString().toDouble()
        }
    }

    fun Operaciones(operacion: Int) {
        this.operacionEnCurso = operacion
    }

    companion object {
        const val suma = 1
        const val resta = 2
        const val multiplicacion = 3
        const val division = 4
        const val noHayOperacion = 5
    }
}