package com.lottery.ticket

import scala.concurrent.Future
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

//import scala.concurrent.Future
//import scala.concurrent._

object LotteryTicket {
  def main(args: Array[String]): Unit = {
    generateFiveMillion()
    Thread.sleep(50000)
  }
  //Function to generate one random number between 1 and 90
  def generateOneRandom: Int = (Math.floor(Math.random() * 90) + 1).toInt

  //Function to generate array of 5 random numbers
  @annotation.tailrec
  def generateFive: Array[Int] = {
    val first = Array(generateOneRandom, generateOneRandom, generateOneRandom, generateOneRandom, generateOneRandom)
    if (first.distinct.length == 5) first
    else generateFive
  }

  //Function to recursively generate 5 million tickets from previous function (maybe store as:
  //Nested array
  //JSON
  def generateXTickets(x: Int): IndexedSeq[Future[Array[Int]]] = for(i <- 1 to x) yield Future {
    generateFive
  }
  def generateFiveMillion(): Unit = {
    println("-------------------- Please generate entropy by moving the mouse as much as possible ------------------")
    val combine: Future[IndexedSeq[Array[Int]]] = Future.sequence(generateXTickets(5000000))
    combine.onComplete {
      case Success(r) => checkWinners(r)
      case Failure(e) => println(e.printStackTrace())
    }
  }
  //Function to check against previous 5 million tickets to check for match against winning ticket (hash map)?
  def checkWinners(tickets: IndexedSeq[Array[Int]], winner: Array[Int] = generateFive): Int = {
    println("------------------------------------ Entropy generated, thanks! ---------------------------------------")
    val winners = tickets.count(_ sameElements  winner)
    println("Winners: " + winners)
    winners
  }
}
