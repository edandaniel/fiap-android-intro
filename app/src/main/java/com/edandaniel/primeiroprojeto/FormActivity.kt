package com.edandaniel.primeiroprojeto

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.edandaniel.primeiroprojeto.extensions.myClear
import com.edandaniel.primeiroprojeto.extensions.value
import com.edandaniel.primeiroprojeto.utils.ConstantsExtra
import kotlinx.android.synthetic.main.activity_formulario.*

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        btClear.setOnClickListener {
            it.isEnabled = false;
            inputWeight.myClear()
            inputHeight.myClear()
            it.isEnabled = true;
        }

        btCalculate.setOnClickListener {
            callResultScreen()
        }
    }

    //TODO: nao foi dado em aula, fiz de alegre, depois implementar certinho
    private fun validation(): Boolean {
        if(inputWeight== null || inputHeight== null){
            Toast.makeText(this,"Preencha os campos",Toast.LENGTH_SHORT).show()
            return false;
        }
        return true;
    }

    fun callResultScreen(){
        val resultScreenIntent = Intent(this,ResultActivity::class.java)
        resultScreenIntent.putExtra(ConstantsExtra.KEY_WEIGHT,inputWeight.value())
        resultScreenIntent.putExtra(ConstantsExtra.KEY_HEIGHT,inputHeight.value())
        startActivity(resultScreenIntent)
    }
}
