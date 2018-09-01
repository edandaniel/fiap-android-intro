package com.edandaniel.primeiroprojeto

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.ActionBar
import android.widget.Toast
import com.edandaniel.primeiroprojeto.extensions.format
import com.edandaniel.primeiroprojeto.extensions.value
import kotlinx.android.synthetic.main.activity_formulario.*
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val weight = intent.extras.getString("KEY_WEIGHT")
        val height = intent.extras.getString("KEY_HEIGHT")
        //Toast.makeText(this,weight,Toast.LENGTH_SHORT).show()
        calcularIMC(weight.toDouble(),height.toDouble())
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun calcularIMC(weight: Double, height: Double){
        val bmi = weight/height/height

        tvBMI.setText(bmi.format(2))

        when (bmi){
            in 0..17 -> {
                setImage(R.drawable.magreza)
                tvDescription.text = "Magreza"
            }
            in 17.1..18.5 -> {
                setImage(R.drawable.abaixo)
                tvDescription.text = "Abaixo do peso"
            }
            in 18.6..24.9 -> {
                setImage(R.drawable.ideal)
                tvDescription.text = "Peso ideal"
            }
            in 25.0..29.9 -> {
                setImage(R.drawable.sobre)
                tvDescription.text = "Levemente Acima"
            }
            in 30.0..34.9 -> {
                setImage(R.drawable.obesidade)
                tvDescription.text = "Obesidade 1"
            }
            in 35.0..39.9 -> {
                setImage(R.drawable.obesidade)
                tvDescription.text = "Obesidade 2"
            }
            in 40.0..Double.POSITIVE_INFINITY -> {
                setImage(R.drawable.obesidade)
                tvDescription.text = "Obesidade 3"
            }
        }
    }

    private  fun setImage(resourceId: Int){
        ivBMI.setImageDrawable(ContextCompat.getDrawable(this,resourceId))
    }
}