package packages

abstract class Question02(states: Set<String>,
                          alphabet: String,
                          initialState: String,
                          finalState: Set<String>
                         ) : StringDFA(states, alphabet, initialState, finalState) {
    fun validation (word: CharArray): Boolean {
        var currentState = initialState
        for ( input in word ){
            currentState = delta(currentState, input)
            if(!states.contains(currentState)) return false
        }
        return if(finalState.contains(currentState)) true else false
    }
}

class Question2a (states: Set<String> = setOf("q0","q1","q2","q3"),
                     alphabet: String = "abc",
                     initialState: String = "q0",
                     finalState: Set<String> = setOf("q0","q1","q2","q3")
                 ) : Question02(states, alphabet, initialState, finalState){
    override fun delta(state: String, input: Char) =
        if(alphabet.contains(input) && states.contains(state)){
            when(state){
                "q0" -> when (input){ 'a' -> "q1"; else -> "erro"}
                "q1" -> when (input){ 'a' -> "q1"; 'b' -> "q2"; 'c' -> "q3"; else -> "erro"}
                "q2" -> when (input){ 'a' -> "q1"; 'b' -> "q2"; 'c' -> "q3"; else -> "erro" }
                "q3" -> when (input){ 'a' -> "q1"; 'c' -> "q3"; else -> "erro" }
                else -> "erro"
            }
        }
        else "erro"

    override fun getInfo(): String {
        return "Question 2a: Construa um autômato finito que reconheça as cadeias pertence a linguagem (ab*c*)*"
    }
}

class Question2b (states: Set<String> = setOf("q0","q1","q2","q3","q4","q5","q6","q7"),
                     alphabet: String = "abc",
                     initialState: String = "q0",
                     finalState: Set<String> = setOf("q3","q7")
                 ) : Question02(states, alphabet, initialState, finalState){
    override fun delta(state: String, input: Char): String =
        if(alphabet.contains(input) && states.contains(state)){
            when(state){
                "q0" -> when (input){ 'a' -> "q1"; 'b' -> "q4"; 'c' -> "q4"; else -> "erro"}
                "q1" -> when (input){ 'a' -> "q2"; else -> "erro"}
                "q2" -> when (input){ 'a' -> "q3"; else -> "erro" }
                "q3" -> when (input){ 'b' -> "q3"; 'c' -> "q3"; else -> "erro" }
                "q4" -> when (input){ 'a' -> "q5"; else -> "erro"}
                "q5" -> when (input){ 'a' -> "q6"; else -> "erro"}
                "q6" -> when (input){ 'a' -> "q7"; else -> "erro" }
                else -> "erro"
            }
        }
        else "erro"

    override fun getInfo(): String {
        return "Question 2b: Construa um autômato finito que reconheça as cadeias pertence a linguagem aaa(b|c)* | (b|c)* aaa"
    }
}

class Question2c (states: Set<String> = setOf("e0","e1","e2","e3","e4"),
                     alphabet: String = "ab",
                     initialState: String = "e0",
                     finalState: Set<String> = setOf("e1","e2","e4")
                 ) : Question02(states, alphabet, initialState, finalState){
    override fun delta(state: String, input: Char): String =
        if(alphabet.contains(input) && states.contains(state)){
            when(state){
                "e0" -> when (input){ 'a' -> "e1"; 'b' -> "e2"; else -> "erro"}
                "e1" -> when (input){ 'a' -> "e3"; 'b' -> "e4" else -> "erro"}
                "e2" -> "erro"
                "e3" -> when (input){ 'a' -> "e3"; 'b' -> "e2"; else -> "erro" }
                "e4" -> when (input){ 'b' -> "e4"; else -> "erro" }
                else -> "erro"
            }
        }
        else "erro"

    override fun getInfo(): String {
        return "Question 2c: Construa um autômato finito que reconheça as cadeias pertence a linguagem a*b|ab*"
    }
}

class Question2d (states: Set<String> = setOf("e0","e1","e2","e3"),
                     alphabet: String = "abc",
                     initialState: String = "e0",
                     finalState: Set<String> = setOf("e1","e3")
                 ) : Question02(states, alphabet, initialState, finalState){
    override fun delta(state: String, input: Char): String  =
        if(alphabet.contains(input) && states.contains(state)){
            when(state){
                "e0" -> when (input){ 'a' -> "e1"; 'b' -> "e2"; else -> "erro"}
                "e1" -> when (input){ 'a' -> "e1"; 'b' -> "e2"; 'c' -> "e3"; else -> "erro"}
                "e2" -> when (input){ 'a' -> "e3"; 'b' -> "e2"; else -> "erro" }
                "e3" -> when (input){ 'c' -> "e3"; else -> "erro" }
                else -> "erro"
            }
        }
        else "erro"

    override fun getInfo(): String {
        return "Question 2d: Construa um autômato finito que reconheça as cadeias pertence a linguagem a*b*(a|ac*)"
    }
}