package sebastian.osorios.udea.calculatormx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val printToDisplay = PrintToDisplay()
        val performOperations = PerformOperations()
        var oldValue : Float = 0F
        var newValue : Float = 0F
        var valueConcat = "0"
        var result : Float
        var check = true
        var operations = ""
        var priority = 0
        var opertationAuxiliar = ""

        buttonOne.setOnClickListener{
            displayOperations.text = printToDisplay.writeNumber(displayOperations.text.toString(),buttonOne.text.toString())
            valueConcat = performOperations.concatNumber(buttonOne.text.toString(),valueConcat)
        }

        buttonTwo.setOnClickListener{
            displayOperations.text = printToDisplay.writeNumber(displayOperations.text.toString(),buttonTwo.text.toString())
            valueConcat = performOperations.concatNumber(buttonTwo.text.toString(),valueConcat)
        }

        buttonThree.setOnClickListener{
            displayOperations.text = printToDisplay.writeNumber(displayOperations.text.toString(),buttonThree.text.toString())
            valueConcat = performOperations.concatNumber(buttonThree.text.toString(),valueConcat)
        }

        buttonFour.setOnClickListener{
            displayOperations.text = printToDisplay.writeNumber(displayOperations.text.toString(),buttonFour.text.toString())
            valueConcat = performOperations.concatNumber(buttonFour.text.toString(),valueConcat)

        }

        buttonFive.setOnClickListener{
            displayOperations.text = printToDisplay.writeNumber(displayOperations.text.toString(),buttonFive.text.toString())
            valueConcat = performOperations.concatNumber(buttonFive.text.toString(),valueConcat)
        }

        buttonSix.setOnClickListener{
            displayOperations.text = printToDisplay.writeNumber(displayOperations.text.toString(),buttonSix.text.toString())
            valueConcat = performOperations.concatNumber(buttonSix.text.toString(),valueConcat)
        }

        buttonSeven.setOnClickListener{
            displayOperations.text = printToDisplay.writeNumber(displayOperations.text.toString(),buttonSeven.text.toString())
            valueConcat = performOperations.concatNumber(buttonSeven.text.toString(),valueConcat)
        }

        buttonEight.setOnClickListener{
            displayOperations.text = printToDisplay.writeNumber(displayOperations.text.toString(),buttonEight.text.toString())
            valueConcat = performOperations.concatNumber(buttonEight.text.toString(),valueConcat)

        }

        buttonNine.setOnClickListener{
            displayOperations.text = printToDisplay.writeNumber(displayOperations.text.toString(),buttonNine.text.toString())
            valueConcat = performOperations.concatNumber(buttonNine.text.toString(),valueConcat)
        }

        buttonZero.setOnClickListener{
           if(!valueConcat.equals("0")){
               displayOperations.text = printToDisplay.writeNumber(displayOperations.text.toString(),buttonZero.text.toString())
               valueConcat = performOperations.concatNumber(buttonZero.text.toString(),valueConcat)
            }
        }

        buttonAdd.setOnClickListener{
            displayOperations.text = printToDisplay.writeOperation(displayOperations.text.toString(),buttonAdd.text.toString())
            if(newValue!=0F && priority==2){
                oldValue = newValue
                newValue = performOperations.selectOperation(oldValue,valueConcat.toFloat(),opertationAuxiliar)
            }else if(priority == 1 && check){
                newValue = performOperations.selectOperation(newValue,valueConcat.toFloat(),operations)
                newValue = performOperations.selectOperation(oldValue,newValue,opertationAuxiliar)
                oldValue = 0F
                operations = ""
            }else if(!check && priority == 1){
                newValue = performOperations.selectOperation(newValue,valueConcat.toFloat(),operations)
                operations = ""
            }else{
                newValue =  valueConcat.toFloat()
            }
            valueConcat = "0"
            opertationAuxiliar = buttonAdd.text.toString()
            priority = performOperations.getPriority(buttonAdd.text.toString())
        }

        buttonSubstract.setOnClickListener{
            displayOperations.text = printToDisplay.writeOperation(displayOperations.text.toString(),buttonSubstract.text.toString())
            if(newValue!=0F && priority==2){
                oldValue = newValue
                newValue = performOperations.selectOperation(oldValue,valueConcat.toFloat(),opertationAuxiliar)
            }else if(priority == 1 && check){
                newValue = performOperations.selectOperation(newValue,valueConcat.toFloat(),operations)
                newValue = performOperations.selectOperation(oldValue,newValue,opertationAuxiliar)
                oldValue = 0F
                operations = ""
            }else if(!check){
                newValue = performOperations.selectOperation(newValue,valueConcat.toFloat(),operations)
                operations = ""
            }else{
                newValue =  valueConcat.toFloat()
            }
            valueConcat = "0"
            opertationAuxiliar = buttonSubstract.text.toString()
            priority = performOperations.getPriority(buttonAdd.text.toString())
        }

        buttonMultiply.setOnClickListener{
            displayOperations.text = printToDisplay.writeOperation(displayOperations.text.toString(),buttonMultiply.text.toString())

            if(opertationAuxiliar.isEmpty() && check){
                oldValue = newValue
                newValue = valueConcat.toFloat()
                valueConcat = "0"
                check = false
                operations = buttonMultiply.text.toString()
            } else if(priority == 2){
                oldValue = newValue
                newValue = valueConcat.toFloat()
                valueConcat = "0"
                operations = buttonMultiply.text.toString()
                check = true
            }else{
                newValue = performOperations.selectOperation(newValue,valueConcat.toFloat(),operations)
                valueConcat = "0"
                operations = buttonMultiply.text.toString()
            }
            priority = performOperations.getPriority(buttonMultiply.text.toString())
        }

        buttonDiv.setOnClickListener{
            displayOperations.text = printToDisplay.writeOperation(displayOperations.text.toString(),buttonDiv.text.toString())

            if(opertationAuxiliar.isEmpty() && check){
                oldValue = newValue
                newValue = valueConcat.toFloat()
                valueConcat = "0"
                check = false
                operations = buttonDiv.text.toString()
            } else if(priority == 2){
                oldValue = newValue
                newValue = valueConcat.toFloat()
                valueConcat = "0"
                operations = buttonDiv.text.toString()
                check = true
            }else{
                newValue = performOperations.selectOperation(newValue,valueConcat.toFloat(),operations)
                valueConcat = "0"
                operations = buttonDiv.text.toString()
            }
            priority = performOperations.getPriority(buttonDiv.text.toString())
        }


        buttonEquals.setOnClickListener{
            if(newValue!=0F && priority == 2){
                oldValue = newValue
                newValue = 0F
                newValue = valueConcat.toFloat()
            }else if(priority == 1){
                newValue = performOperations.selectOperation(newValue,valueConcat.toFloat(),operations)
            }
            valueConcat = "0"
            result = performOperations.selectOperation(oldValue,newValue,opertationAuxiliar).toString().toFloat()
            displayOperations.text =  result.toString()
            oldValue = 0F
            newValue = displayOperations.text.toString().replace(buttonEquals.text.toString() +" ","").toFloat()
            operations = ""
            check = true
        }

        buttonDelete.setOnClickListener{
            displayOperations.text=""
            newValue=0F
            oldValue=0F
            valueConcat="0"
            opertationAuxiliar=""
            operations=""
            result = 0f
            check = true
        }


    }


}



