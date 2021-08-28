package packages

class Question1a (states: Set<String> = setOf("q0","q1","q2","q3"),
                     alphabet: String = "01",
                     initialState: String = "q0",
                     finalState: Set<String> = setOf("q0","q3")) : DFA(states, alphabet, initialState, finalState){
    override fun delta(state: String, input: Char): String =
        if(alphabet.contains(input) && states.contains(state)){
            when(state){
                "q0" -> when (input){ '0' -> "q0"; '1' -> "q1" else -> "erro" }
                "q1" -> when (input){ '0' -> "q2" else -> "erro" }
                "q2" -> when (input){ '0' -> "q3" else -> "erro" }
                "q3" -> when (input){ '0' -> "q3"; '1' -> "q1" else -> "erro" }
                else -> "erro"
            }
        }
        else "erro"

    override fun getInfo(): String {
        return "Todas as cadeias em {0,1}* que representam cada 1 seguido imediatamente de dois 0."
    }

    fun validation (word: CharArray): Boolean {
        var currentState = initialState
        for ( input in word ){
            currentState = delta(currentState, input)
            if(!states.contains(currentState)) return false
        }
        return if(finalState.contains(currentState)) true else false
    }
}

class Question1b (states: Set<String> = setOf("q0","q1","q2","q3"),
                     alphabet: String = "ab",
                     initialState: String = "q0",
                     finalState: Set<String> = setOf("q0","q3")) : DFA(states, alphabet, initialState, finalState){
    override fun delta(state: String, input: Char): String =
        if(alphabet.contains(input) && states.contains(state)){
            when(state){
                "q0" -> when (input){ 'a' -> "q1"; 'b' -> "q0"; else -> "erro"}
                "q1" -> when (input){ 'a' -> "q2"; 'b' -> "q1"; else -> "erro"}
                "q2" -> when (input){ 'b' -> "q3"; else -> "erro" }
                "q3" -> when (input){ 'a' -> "q1"; 'b' -> "q3"; else -> "erro" }
                else -> "erro"
            }
        }
        else "erro"

    override fun getInfo(): String {
        return "Todas as cadeias em {a,b}* de modo que o último símbolo seja b e o número de símbolos a seja par."
    }

    fun validation (word: CharArray): Boolean {
        var currentState = initialState
        for ( input in word ){
            currentState = delta(currentState, input)
            if(!states.contains(currentState)) return false
        }
        return if(finalState.contains(currentState)) true else false
    }
}