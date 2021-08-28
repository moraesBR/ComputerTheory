import packages.computadorDFA

fun main(){
    val question3 = computadorDFA()
    val text = "O computador é uma máquina capaz de variados tipos de tratamento automático de informações ou " +
            "processamento de dados. Entende-se por computador um sistema físico que realiza algum tipo de " +
            "computação. Assumiu-se que os computadores pessoais e laptops são ícones da era da informação. " +
            "O primeiro computador eletromecânico foi construído por Konrad Zuse (1910-1995). Atualmente, um " +
            "microcomputador é também chamado computador pessoal ou ainda computador doméstico."
    println(question3.getInfo())
    println(question3.findAll(text))
}