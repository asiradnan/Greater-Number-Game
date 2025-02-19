package com.asiradnan.greaternumbergame

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val score:TextView = findViewById(R.id.scoreTextView);
        val tryCount:TextView = findViewById((R.id.triesTextView))
        val leftNumber:TextView = findViewById(R.id.leftNumberText)
        val rightNumber:TextView = findViewById(R.id.rightNumberText)
        var scoreNum = 0;
        var tryCounter = 0;
        var num1 = 0
        var num2 = 0
        var  flag = false;
        val button:Button = findViewById(R.id.leftButton);
        val button2:Button = findViewById(R.id.rightButton);
        val button3:Button = findViewById(R.id.resetButton)

        fun updateNewValues() {
            num1 = Random.nextInt(1, 100);
            num2 = Random.nextInt(1, 100);
            while (num1 == num2) {
                num1 = Random.nextInt(1, 100);
                num2 = Random.nextInt(1, 100);
            }
            leftNumber.text = num1.toString();
            rightNumber.text = num2.toString();
        }
        fun MojarFunction(){
            if (flag==true){
                if (num1>num2) scoreNum++;
                else scoreNum--
            }
            else{
                if (num1<num2) scoreNum++
                else scoreNum--
            }

            score.text = "Score: " + scoreNum
            tryCount.text = "Tries: " + ++tryCounter
            updateNewValues()
        }
        fun reset(){
            scoreNum = 0
            tryCounter = 0
            score.text = "Score: " + scoreNum
            tryCount.text = "Tries: " + tryCounter
            updateNewValues()
        }
        updateNewValues()
        button.setOnClickListener{
            flag = true;
            MojarFunction();
        };
        button2.setOnClickListener{
            flag = false;
            MojarFunction();
        }
        button3.setOnClickListener {
            reset()
        }
    }
}