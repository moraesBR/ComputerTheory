import packages.Question03
import packages.Question1a
import packages.Question1b

fun main(){
    val question1a = Question1a()
    val question1b = Question1b()
    val question3 = Question03()

    val input1a = arrayListOf("0","0100","100","1","1001","010","0001")
    println("\n${question1a.getInfo()}")
    input1a.map { println("$it -> ${question1a.validation(it.toCharArray())}")}


    val input1b = arrayListOf("b","babab","baab","aab","a","ab","bab","aba")
    println("\n${question1b.getInfo()}")
    input1b.map { println("$it -> ${question1b.validation(it.toCharArray())}")}

    val text3 = "O computador é uma máquina capaz de variados tipos de tratamento automático de informações ou " +
            "processamento de dados. Entende-se por computador um sistema físico que realiza algum tipo de " +
            "computação. Assumiu-se que os computadores pessoais e laptops são ícones da era da informação. " +
            "O primeiro computador eletromecânico foi construído por Konrad Zuse (1910-1995). Atualmente, um " +
            "microcomputador é também chamado computador pessoal ou ainda computador doméstico."
    println("\n${question3.getInfo()}")
    println(question3.findAll(text3))
}