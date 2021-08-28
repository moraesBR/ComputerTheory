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