package com.lottery.ticket

//import scala.concurrent.Future
//import scala.concurrent._

object LotteryTicket {
  def main(args: Array[String]): Unit = {

  }
  //Function to generate one random number between 1 and 90
  def generateOneRandom: Int = (Math.floor(Math.random() * 90) + 1).toInt

  //Function to generate array of 5 random numbers
  @annotation.tailrec
  def generateFive: Array[Int] = {
    val first = Array(generateOneRandom, generateOneRandom, generateOneRandom, generateOneRandom, generateOneRandom)
    if (first.distinct.size == first.size) first
    else generateFive
  }

  //Function to recursively generate 5 million tickets from previous function (maybe store as:
  //Nested array
  //JSON
//  def generateFiveMillion = {
//    val fiveMillion: IndexedSeq[Future[IndexedSeq[Array[Int]]]] = for (i <- 0 to 100) yield Future {
//      for (i <- 1 to 50000) yield generateFive
//    }
//  }

  //Function to check against previous 5 million tickets to check for match against winning ticket (hash map)?

}
