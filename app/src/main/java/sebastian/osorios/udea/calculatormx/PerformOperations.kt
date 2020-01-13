package sebastian.osorios.udea.calculatormx


class PerformOperations {
    var result : Float = 0F

    private  fun add(oldValue:Float ,newValue : Float): Float{
        return oldValue+newValue
    }
    private  fun substract(oldValue:Float ,newValue : Float): Float{
        return oldValue-newValue
    }

    private  fun multiply(oldValue:Float ,newValue : Float): Float{
        return oldValue*newValue
    }

    private  fun div(oldValue:Float ,newValue : Float): Float {
        if(newValue != 0F) {
            return oldValue / newValue
        }else{
            return error("Math Error")
        }
    }

    fun selectOperation(oldValue:Float ,newValue : Float,opertaion : String): Float{

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

        return removeDecimals(result.toString()).toFloat()
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

    fun removeDecimals(resulta : String) : String{
        var index : Int = resulta.indexOf(".")
        var chain = resulta.substring(index+1)
        var check = false
        for(i in 0..chain.length-1){
            if(!chain[i].toString().equals("0")){
                check = true
            }
        }
        var a =resulta.substring(0,index)
        if(check){
            return resulta
        }else{
            return resulta.substring(0,index)
        }
    }

}