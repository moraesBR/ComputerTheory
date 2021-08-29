package packages

class Question04(states: Set<String> = setOf("q0","q1","q2","q3"),
                 alphabet: Set<Int> = setOf(25,50,100),
                 initialState: String = "q0",
                 finalState: Set<String> = setOf("q0","q1","q2","q3"),
                 val outAlphabet: Set<Int> = setOf(0,1)
                ) : IntDFA(states, alphabet, initialState, finalState)
{
    override fun delta(state: String, input: Int): String =
        if(alphabet.contains(input) && states.contains(state)){
            when(state){
                "q0" -> when (input){ 25 -> "q1"; 50 -> "q2"; 100 -> "q0"; else -> "erro"}
                "q1" -> when (input){ 25 -> "q2"; 50 -> "q3"; 100 -> "q1"; else -> "erro"}
                "q2" -> when (input){ 25 -> "q3"; 50 -> "q0"; 100 -> "q2"; else -> "erro" }
                "q3" -> when (input){ 25 -> "q0"; 50 -> "q1"; 100 -> "q3"; else -> "erro" }
                else -> "erro"
            }
        }
        else "erro"

    override fun getInfo(): String {
        return "Máquina de Mealy que, dada uma sequência de moedas de 25 e 50 centavos e de 1 real, forneça uma " +
               "lata de refrigerante quando a sequência totalizar 1 real ou mais. Cada moeda inserida deverá " +
               "corresponder a uma de duas saídas: 0, se uma lata não pode ser (ainda) liberada, ou 1, se uma " +
               "lata deve ser liberada."
    }

    fun lambda (state: String, input: Int): Int =
        if(alphabet.contains(input) && states.contains(state)){
            when(state){
                "q0" -> when (input){ 25 -> 0; 50 -> 0; 100 -> 1; else -> -1 }
                "q1" -> when (input){ 25 -> 0; 50 -> 0; 100 -> 1; else -> -1 }
                "q2" -> when (input){ 25 -> 0; 50 -> 1; 100 -> 1; else -> -1 }
                "q3" -> when (input){ 25 -> 1; 50 -> 1; 100 -> 1; else -> -1 }
                else -> -1
            }
        }
        else -1

    fun validation (input: ArrayList<Int>): ArrayList<Int> {
        val output = arrayListOf<Int>()
        var currentState = initialState
        for ( value in input ){
            output.add(lambda(currentState, value))
            currentState = delta(currentState, value)
            if(!states.contains(currentState)) return output
        }
        return output
    }
}