package com.igoraugusto.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.igoraugusto.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    /*Função responsavel por fazer a criação da Activity*/
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)

    }
    /*Função responsavel por tratar qualquer evento de click nos elementos*/
    override fun onClick(view: View) {
        /*O "R" representa tudo que a gente cria em drawable, layout, values, tudo que está nesta pasta é
        representada pela letra R, que no caso chama o id do button_calculate. Ou seja, estamos referenciando
        tudo que está em XML para código sendo assim possível trocar id por color para entrar nas opções de
        cores dentro do código por exemplo.*/
        if (view.id == R.id.button_calculate){
            calculate()
        }
    }

    fun isValid(): Boolean{
        return (binding.editDistance.text.toString() != ""
                && binding.editPrice.text.toString() != ""
                && binding.editAutonomy.text.toString() != ""
                && binding.editAutonomy.text.toString().toFloat() != 0f)
    }

    /*Função responsável por realizar o calculo de gastos com a viagem baseando na distância
    percorrida * preõ médio do combustivél / pela autonomia do veículo*/
    fun calculate() {
        //Pegando o valor que vai ser digitado
        if (isValid()) {
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()

            val totalValue = (distance * price) / autonomy

            //Formatando o resultado final
            binding.textTotalvalue.text = "R$ ${"%.2f".format(totalValue).replace(".", ",")}"
        } else {
        /* Uma boa pratica nesse caso é transforma o texto em uma string e chama ela, para caso tenho alguma
        aplicação que precise de tradução, ou alguma edição na string
        "Toast notification" é uma pequena notificação para o usuário.*/
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
        }



    }

}