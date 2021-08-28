package packages

abstract class DFA(
    val states: Set<String>,
    val alphabet: String,
    val initialState: String,
    val finalState: Set<String>,
){
    abstract fun delta (state: String, input: Char) : String
    abstract fun getInfo(): String
    fun isFinalState(state: String) = finalState.contains(state)
    fun contains(input: Char) = alphabet.contains(input)
}

class computadorDFA(states: Set<String> = setOf("q0","q1","q2","q3","q4","q5","q6","q7","q8","q9","q10","q11","q12","q13"),
                    alphabet: String = "qwertyuiopasdfghjklçzxcvbnmáâãàéêíóõôúü" +
                                       "QWERTYUIOPASDFGHJKLÇZXCVBNMÁÂÃÀÉÊÍÓÕÔÚÜ" +
                                       "0123456789-+/*"+
                                       " .,;:\'\"(){}[]\\",
                    initialState: String = "q0",
                    finalState: Set<String> = setOf("q12"),
                    val stateBeginKeyword: String = "q2")
    : DFA(states, alphabet, initialState, finalState){

    override fun delta(state: String, input: Char): String = when(state){
        "q0" ->
            if(alphabet.contains(input))
                when (input){' ' -> "q1"; else -> "q0"}
            else
                "erro"
        "q1" ->
            if(alphabet.contains(input))
                when (input){ ' ' -> "q1"; 'c' -> "q2"; else -> "q0"}
            else
                "erro"
        "q2" ->
            if(alphabet.contains(input))
                when (input){ 'o' -> "q3"; ' ' -> "q1"; else -> "q0" }
            else
                "erro"
        "q3" ->
            if(alphabet.contains(input))
                when (input){ 'm' -> "q4"; ' ' -> "q1"; else -> "q0" }
            else
                "erro"
        "q4" ->
            if(alphabet.contains(input))
                when (input){ 'p' -> "q5"; ' ' -> "q1"; else -> "q0" }
            else
                "erro"
        "q5" ->
            if(alphabet.contains(input))
                when (input){ 'u' -> "q6"; ' ' -> "q1"; else -> "q0" }
            else
                "erro"
        "q6" ->
            if(alphabet.contains(input))
                when (input){ 't' -> "q7"; ' ' -> "q1"; else -> "q0" }
            else
                "erro"
        "q7" ->
            if(alphabet.contains(input))
                when (input){ 'a' -> "q8"; ' ' -> "q1"; else -> "q0" }
            else
                "erro"
        "q8" ->
            if(alphabet.contains(input))
                when (input){ 'd' -> "q9"; ' ' -> "q1"; else -> "q0" }
            else
                "erro"
        "q9" ->
            if(alphabet.contains(input))
                when (input){ 'o' -> "q10"; ' ' -> "q1"; else -> "q0" }
            else
                "erro"
        "q10" ->
            if(alphabet.contains(input))
                when (input){ 'r' -> "q11"; ' ' -> "q1"; else -> "q0" }
            else
                "erro"
        "q11" ->
            if(alphabet.contains(input))
                when (input){ ' ' -> "q12"; else -> "q0" }
            else
                "erro"
        "q12" ->
            if(alphabet.contains(input))
                when (input){ ' ' -> "q1"; else -> "q0" }
            else
                "erro"
        else -> "erro"
    }

    fun findAll(text: String): ArrayList<Int> {
        val inputs = text.toCharArray()
        var position = 0
        var stateCurrent = this.initialState
        val founded = arrayListOf<Int>()

        for ((i, input) in inputs.withIndex()){
            stateCurrent = this.delta(stateCurrent,input)
            if(stateCurrent == stateBeginKeyword)
                position = i
            if(this.isFinalState(stateCurrent))
                founded.add(position)
        }
        return founded
    }

    override fun getInfo(): String {
        return "Questão 03: Implemente um autômato finito que reconheça todas as ocorrências da palavra computador" +
               "no texto T. O programa deve apontar em quais posições ocorreram o casamento exato da palavra."
    }

}