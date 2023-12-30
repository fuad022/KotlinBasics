package com.example.kotlinbasics

//data class Branch(
//    val Id: Int,
//    val BranchType: String,
//    val BranchName: String,
//    var isCashInAndExchange: Boolean
//)
//
//fun main() {
//    val inputList = listOf(
//        Branch(200, "CashInAtm", "Head office", false),
//        Branch(201, "ExchangeAtm", "Head office", false),
//        Branch(202, "CashInAtm", "Second office", false),
//        Branch(203, "ExchangeAtm", "Third office", false),
//        Branch(204, "ExchangeAtm", "Fourth office", false),
//        Branch(205, "Atm", "Six office", false),
//        Branch(206, "Atm", "Seven office", false),
//        Branch(207, "Branch", "Eight office", false),
//        Branch(208, "Branch", "Nine office", false)
//    )
//
////    val result = inputList
////        .filter { it.BranchType == "CashInAtm" || it.BranchType == "ExchangeAtm" }
////        .groupBy { it.BranchName }
////        .values
////        .map { it.first() }
//
//    val list = arrayListOf<Branch>()
//
//    inputList
//        .filter { it.BranchType == "CashInAtm" || it.BranchType == "ExchangeAtm" }
//        .groupBy { it.BranchName }
//        .forEach{(key, valueList) ->
//            valueList[0].isCashInAndExchange = true
//
//            list.addAll(valueList)
//        }
//
//
//
//    list.forEach { println(it) }
//}



data class Branch(
    val Id: Int,
    val BranchType: String,
    val BranchName: String,
    val isCashInAndExchange: Boolean
)

fun main() {
    val inputList = listOf(
        Branch(200, "CashInAtm", "Head office", false),
        Branch(201, "ExchangeAtm", "Head office", false),
        Branch(202, "CashInAtm", "Second office", false),
        Branch(203, "ExchangeAtm", "Third office", false),
        Branch(204, "ExchangeAtm", "Fourth office", false),
        Branch(205, "Atm", "Six office", false),
        Branch(206, "Atm", "Seven office", false),
        Branch(207, "Branch", "Eight office", false),
        Branch(208, "Branch", "Nine office", false)
    )

    val result = inputList
        .filter { it.BranchType == "CashInAtm" || it.BranchType == "ExchangeAtm" }
        .groupBy { it.BranchName }
        .values
        .map { branches -> branches.first() } // Take the first element of each group

    println(result)
}















//fun main() {
////    val branches = listOf(
////        Branch(200, "CashInAtm", "Head office"),
////        Branch(201, "ExchangeAtm", "Head office"),
////        Branch(202, "CashInAtm", "Second office"),
////        Branch(203, "ExchangeAtm", "Third office"),
////        Branch(204, "ExchangeAtm", "Fourth office")
////    )
////
////    val groupedBranches = branches.groupBy { it.BranchName }
////        .filterValues { list ->
////            list.any { it.BranchType == "CashInAtm" } && list.any { it.BranchType == "ExchangeAtm" }
////        }
////
////    println(groupedBranches.firstNotNullOf {
////        it.key
////    })
////
////    // Print the result
////    groupedBranches.forEach { (branchName, branches) ->
////        println("Branch Name: $branchName")
////        branches.forEach { branch ->
////            println("  Id: ${branch.Id}, BranchType: ${branch.BranchType}")
////        }
////        println()
////    }
//
//    val inputList = listOf(
//        Branch(200, "CashInAtm", "Head office"),
//        Branch(201, "ExchangeAtm", "Head office"),
//        Branch(202, "CashInAtm", "Second office"),
//        Branch(203, "ExchangeAtm", "Third office"),
//        Branch(204, "ExchangeAtm", "Fourth office"),
//        Branch(205, "Atm", "Six office"),
//        Branch(206, "Atm", "Seven office"),
//        Branch(207, "Branch", "Eight office"),
//        Branch(208, "Branch", "Nine office")
//    )
//
//    val result = inputList
//        .filter { it.BranchType == "CashInAtm" || it.BranchType == "ExchangeAtm" }
//        .groupBy { it.BranchName }
//        .values
//        .map { it.first() }
//
//    result.forEach { println(it) }
//}
//
////data class Branch(
////    val Id: Int,
////    val BranchType: String,
////    val BranchName: String
////)
//
//data class Branch(val Id: Int, val BranchType: String, val BranchName: String)