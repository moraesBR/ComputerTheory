package packages

class Question2a (states: Set<String> = setOf("q0","q1","q2","q3"),
                     alphabet: String = "abc",
                     initialState: String = "q0",
                     finalState: Set<String> = setOf("q1","q2")
                 ) : DFA(states, alphabet, initialState, finalState){
    override fun delta(state: String, input: Char): String {
        TODO("Not yet implemented")
    }

    override fun getInfo(): String {
        TODO("Not yet implemented")
    }

}

class Question2b (states: Set<String> = setOf("q0","q1","q2","q3","q4","q5","q6","q7","q8"),
                     alphabet: String = "abc",
                     initialState: String = "q0",
                     finalState: Set<String> = setOf("q8")
                 ) : DFA(states, alphabet, initialState, finalState){
    override fun delta(state: String, input: Char): String {
        TODO("Not yet implemented")
    }

    override fun getInfo(): String {
        TODO("Not yet implemented")
    }

}

class Question2c (states: Set<String> = setOf("q0","q1","q2","q3","q4"),
                     alphabet: String = "ab",
                     initialState: String = "q0",
                     finalState: Set<String> = setOf("q1","q2","q3","q4")
                 ) : DFA(states, alphabet, initialState, finalState){
    override fun delta(state: String, input: Char): String {
        TODO("Not yet implemented")
    }

    override fun getInfo(): String {
        TODO("Not yet implemented")
    }

}

class Question2d (states: Set<String> = setOf("q0","q1","q2","q3","q4"),
                     alphabet: String = "01",
                     initialState: String = "q0",
                     finalState: Set<String> = setOf("q1","q3","q4")
                 ) : DFA(states, alphabet, initialState, finalState){
    override fun delta(state: String, input: Char): String {
        TODO("Not yet implemented")
    }

    override fun getInfo(): String {
        TODO("Not yet implemented")
    }

}