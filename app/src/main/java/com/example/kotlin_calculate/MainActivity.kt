package com.example.kotlin_calculate

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.kotlin_calculate.databinding.ActivityMainBinding


/**
 *
 * 기본적으로 코틀린은 fun
 * return 형이 없을 때는 Unit 이라고 써줌 Unit = void
 * return 형이 있을 때는 자바랑 다르게 앞에 리턴형이 옴
 * 변수명이 Type 보다 먼저 옴
 * 매개 변수 같은 경우
 * java int i = 0;
 * kotlin i : Int = 0;
 *
 * =================================
 *
 * val , var // value , variable
 * val = value
 * val 상수  == fianl
 * var 변수
 * val ,var 같은 경우 자동으로 Type 지정이 됨
 * 그치만 바로 자료를 지정하지 않을 경우 Type 지정을 해줘야 댐
 *
 * ==================================
 * 조건 식
 * 기본적 if의 문법은 같지만
 * 자동추론의 방식으로 함수 앞에 적을 수도 있다.
 * ex )
 * 1. fun plusVal( a: Int , b : Int) = if(a>b) a else b
 * 2. if (a > b)
 *      return a
 *    else
 *      return b
 * 1 번과 2번은 같다.
 *
 * when == switch case 문
 * ex)
 *   when (변수)
 *      0 -> 기능
 *      1 -> 기능
 *      else -> default
 *
 * when 같은 경우 함수의 return 으로도 사용 가능 , break 을 안적어도됨
 * ex)
 *      var a : Int = 5;
 *
 *         var b : Int = when(a){
 *             1 -> 1;
 *             else -> 2;
 *         }
 * 코틀린은 기본적으로 모든 함수는 Expression (표현식)
 * return을 안하더라도 무조건 Unit 을 리턴함
 * ===============================================
 * 배열 과 리스트 (Array , List)
 * 초기화의 문법은
 * 배열 = arrayOf();
 * 리스트 = listOf();
 * 어레이리스트 = arrayListOf<>()
 *
 * 자바랑 다른게 없음
 *
 * ===============================================
 * 반복문 For / While
 *  for each 문
 *  val name = "ww";
 *         val list2 = arrayListOf(String);
 *         for (name in list2){
 *
 *         }
 *  for ( i in 1..100)
 *  {
 *      .. 이 1부터 100까지 문법
 *  }
 *
 *  while 문은 같음
 *  while(boolean)
 *  ==============================================
 *  Nullable / NonNull
 *  변수 및 상수 앞에 ? 붙이면 Null 처리가 가능
 *  ?: 를 사용 하면 if( 변수 != Null) 구현이 됨
 *  변수 및 상수 뒤에 !! 를 붙이면 절대 Null 이라는걸 확신할때 사용
 *  만약 !! 이 붙였는데 Null 이 들어가면 NullPoint 뜸
 *  뒤에 ?.let = if( 변수 != Null)
 *
 * ================================================
 * Class 문법
 * 코틀린은 파일 이름이랑 클래스 이름이랑 일치 안해도 됨
 * 1. 기본 문법은
 * Class 이름 {}
 *
 * 2. 초기화 문법
 * val 클래스 이름 = 클래스 이름 ()
 *
 * 3. 생성자
 *  Class 이름{
 *  init{}
 *  }
 *  - 부생성자
 *  Class 이름 {
 *  init{}
 *  constructor(매개 변수){}
 *  }
 *  순서는 무저건 Init 부터 그 다음이 constructor
 *
 * 4. 상속
 * 이떄 상속할 클래스는 open 이라고 적어줘야댐.
 * class 이름 : 상속할 이름(){
 *
 * }
 *
 * 5. override
 * 사용할 메서드 앞에 open 적어 줘야댐.
 *  super , this 는 자바랑 같음
 * **/

class MainActivity : AppCompatActivity() {

    // lateinit = 나중에 초기화 한대요
    private lateinit var binding: ActivityMainBinding
    private var inputData1 = arrayListOf<Int>();
    private var inputData2 = arrayListOf<Int>();
    private val TAG : String = "MainActivity"
    private enum class Operation{
        plus,minus,divide,multi,default
    }


    private var nowOperation : Operation = Operation.default

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        btnListener()

    }

    private fun btnListener()
    {
        binding.btn0.setOnClickListener{
            binding.textInputNum.setText(add(0))
        }

        binding.btn1.setOnClickListener{
            binding.textInputNum.setText(add(1))
        }

        binding.btn2.setOnClickListener{
            binding.textInputNum.setText(add(2))
        }

        binding.btn3.setOnClickListener{
            binding.textInputNum.setText(add(3))
        }

        binding.btn4.setOnClickListener{
            binding.textInputNum.setText(add(4))
        }

        binding.btn5.setOnClickListener{
            binding.textInputNum.setText(add(5))
        }

        binding.btn6.setOnClickListener{
            binding.textInputNum.setText(add(6))
        }

        binding.btn7.setOnClickListener{
            binding.textInputNum.setText(add(7))
        }

        binding.btn8.setOnClickListener{
            binding.textInputNum.setText(add(8))
        }

        binding.btn9.setOnClickListener{
            binding.textInputNum.setText(add(9))
        }

        binding.btnPlus.setOnClickListener{
            if(binding.textInputNum.text.isEmpty())
            {
                binding.textNotify.setText("숫자를 입력해주세요")
            }
            else
            {
                nowOperation = Operation.plus
                inputOperation()
            }

        }

        binding.btnMinus.setOnClickListener{
            if(binding.textInputNum.text.isEmpty())
            {
                binding.textNotify.setText("숫자를 입력해주세요")
            }
            else
            {
                nowOperation = Operation.minus
                inputOperation()
            }
        }

        binding.btnDivide.setOnClickListener{
            if(binding.textInputNum.text.isEmpty())
            {
                binding.textNotify.setText("숫자를 입력해주세요")
            }
            else
            {
                nowOperation = Operation.divide
                inputOperation()
            }
        }

        binding.btnMulti.setOnClickListener{
            if(binding.textInputNum.text.isEmpty())
            {
                binding.textNotify.setText("숫자를 입력해주세요")
            }
            else
            {
                nowOperation = Operation.multi
                inputOperation()
            }
        }

        // inputdata1 사칙연산 inputdata2 로 진행
        // 계산한 뒤 inputdata2 초기화
        // operation 클릭하게 되면 inputdata1 초기화
        binding.btnResult.setOnClickListener{
            if(!inputData1.isEmpty() && !inputData2.isEmpty())
            {
                // mode default
                var result : Int = 0
                Log.i(TAG,"Minus : " + Integer.parseInt(inputData1.joinToString(separator = "")) + Integer.parseInt(inputData2.joinToString(separator = "")))
                when(nowOperation)
                {
                    Operation.plus -> result = Integer.parseInt(inputData1.joinToString(separator = "")) + Integer.parseInt(inputData2.joinToString(separator = ""))
                    Operation.minus -> result = Integer.parseInt(inputData1.joinToString(separator = "")) - Integer.parseInt(inputData2.joinToString(separator = ""))
                    Operation.divide -> result = Integer.parseInt(inputData1.joinToString(separator = "")) / Integer.parseInt(inputData2.joinToString(separator = ""))
                    Operation.multi -> result = Integer.parseInt(inputData1.joinToString(separator = "")) * Integer.parseInt(inputData2.joinToString(separator = ""))

                    else -> {
                        Log.i(TAG,"")}
                }

                binding.textInputNum.setText(result.toString())
                inputData1.clear()
                inputData2.clear()
                inputData1.add(result)
                nowOperation = Operation.default
            }
            else
            {
                binding.textNotify.setText("숫자를 입력해주세요")
            }
        }

        binding.btnDelete.setOnClickListener{
            binding.textInputNum.setText(delete())
        }

    }

    private fun add(value : Int) : String{

        binding.textNotify.setText("")

        if(inputData1.size < 8 && inputData2.size < 8)
        {
            if(nowOperation != Operation.default)
            {
                inputData2.add(value)
            }
            else
            {
                inputData1.add(value)
            }
        }
        else
        {
            binding.textNotify.setText("7자리 숫자가 넘어갔습니다. D 버튼을 눌러주세요")
        }

        if(nowOperation != Operation.default)
        {
            return inputData2.joinToString(separator = "")
        }
        else
        {
            return inputData1.joinToString(separator = "")
        }
    }

    private fun delete() : String{

        if(inputData1.size > 0 || inputData2.size > 0)
        {
            if(nowOperation != Operation.default)
            {
                inputData2.remove(inputData2.get(inputData2.size - 1))
            }
            else
            {
                inputData1.remove(inputData1.get(inputData1.size - 1))
            }
        }
        else
        {
            binding.textNotify.setText("지울 수 있는게 없습니다.")
        }

        if(nowOperation != Operation.default)
        {
            return inputData2.joinToString(separator = "")
        }
        else
        {
            return inputData1.joinToString(separator = "")
        }
    }

    // + - * / 에만 적용
    private fun inputOperation(){
//        inputData2.addAll(inputData1)
//        inputData1.clear()
        binding.textInputNum.setText("")
    }



}