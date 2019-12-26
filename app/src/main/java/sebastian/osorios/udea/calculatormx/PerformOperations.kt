package sebastian.osorios.udea.calculatormx


class PerformOperations {
    var result : Int = 0

    private  fun add(oldValue:Int ,newValue : Int): Int{
        return oldValue+newValue
    }
    private  fun substract(oldValue:Int ,newValue : Int): Int{
        return oldValue-newValue
    }

    private  fun multiply(oldValue:Int ,newValue : Int): Int{
        return oldValue*newValue
    }

    private  fun div(oldValue:Int ,newValue : Int): Int {
        if(newValue != 0) {
            return oldValue / newValue
        }else{
            return error("Math Error")
        }
    }

    fun selectOperation(oldValue:Int ,newValue : Int,opertaion : String): Int{

        when (opertaion) {
            "+" -> {
               result = add(oldValue,newValue)
            }
            "-"-> {
               result = substract(oldValue,newValue)

            }
            "*" -> {
                result = multiply(oldValue,newValue)

            }
            "÷" -> {
                result = div(oldValue,newValue)
            }
            else -> {
                //agregar erroe
            }
        }
        return result
    }

    fun concatNumber(number : String, valueConcat : String): String {
        var auxiliar = valueConcat
        if(!valueConcat.equals("0")){
            auxiliar = auxiliar+number
        }else{
            auxiliar = number
        }
        return auxiliar
    }

    fun getPriority(opertaion : String): Int{
        if(opertaion.equals("+") || opertaion.equals("-")){
            return 2
        }else{
            return 1
        }
    }

}