package sebastian.osorios.udea.calculatormx


class PrintToDisplay{

    constructor() {}

    fun writeNumber(oldValue:String ,newValue : String) : String {
        if(!oldValue.equals("0")) {
            return oldValue + newValue
        }else{
            return newValue
        }
    }

    fun writeOperation(oldValue:String ,newValue : String) : String {
        var lastValor = oldValue.substring(oldValue.length-1,oldValue.length)
        if(!lastValor.equals("+") && !lastValor.equals("-") && !lastValor.equals("*") && !lastValor.equals("÷") && !lastValor.equals("= ")){
            return  oldValue + newValue
        }else{
            return oldValue
        }

    }

}