package packages

abstract class IntDFA(
    val states: Set<String>,
    val alphabet: Set<Int>,
    val initialState: String,
    val finalState: Set<String>,
){
    abstract fun delta (state: String, input: Int) : String
    abstract fun getInfo(): String
    fun isFinalState(state: String) = finalState.contains(state)
    fun contains(input: Int) = alphabet.contains(input)
}