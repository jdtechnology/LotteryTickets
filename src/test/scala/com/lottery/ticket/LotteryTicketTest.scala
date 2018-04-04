package com.lottery.ticket

import org.scalatest._
import scala.concurrent.Future

class LotteryTicketTest extends WordSpec with Matchers  {

  "generateOneRandom" should {
    "always be an integer" in {
      for(i <- 0 to 1000) LotteryTicket.generateOneRandom.isInstanceOf[Int] shouldBe true
    }
    "never be more than 90" in {
      for(i <- 0 to 1000) LotteryTicket.generateOneRandom should be <= 90
    }
    "never be less than one" in {
      for(i <- 0 to 1000) LotteryTicket.generateOneRandom should be >= 1
    }
  }
  "generateFive" should {
    "should have a length of 5" in {
      LotteryTicket.generateFive should have length 5
    }
    "return an Array[Int]" in {
      LotteryTicket.generateFive.isInstanceOf[Array[Int]] shouldBe true
    }
    "generate suitably random numbers" in {
      val testCase = for(i <- 1 to 100) yield LotteryTicket.generateFive
      val occurrenceSort: Map[Int, Int] = testCase.flatten.groupBy(identity).mapValues(_.size)
      val overOdds = occurrenceSort.filter(_._2 > 9)
      overOdds.size should be <= 3
    }
  }
  "checkWinners" should {
    val testData = List(IndexedSeq(Array(1, 2, 3, 4, 5), Array(2, 3, 4, 5, 6)), IndexedSeq(Array(1, 2, 3, 4, 5), Array(3, 4, 5, 6, 7), Array(4, 5, 6, 7, 8)))
    "return an Int given valid input" in {
      for (ticketColl <- testData) {
        LotteryTicket.checkWinners(ticketColl).isInstanceOf[Int] shouldBe true
      }
    }
    "return 0 when there is no match" in {
      testData.foreach { ticketColl =>
        LotteryTicket.checkWinners(ticketColl, Array(90, 89, 88, 87, 86)) shouldBe 0
      }
    }
    "return 1 when there is one match" in {
      testData.foreach { ticketColl =>
        LotteryTicket.checkWinners(IndexedSeq(Array(1, 2, 3, 4, 5), Array(2, 3, 4, 5, 6)), Array(1, 2, 3, 4, 5)) shouldBe 1
      }
    }
    "return 200 when there are 200 matches" in {
      val testData = IndexedSeq(Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5),
        Array(1,2,3,4,5)
      )
      LotteryTicket.checkWinners(testData, Array(1,2,3,4,5)) shouldBe 200
    }
  }
}

class AsyncLotteryTicketTest extends AsyncWordSpec with Matchers {
  "generateXTickets" should {
    "eventually generate an IndexedSeq of Array[Int]" in {
      val futureSeq = Future.sequence(LotteryTicket.generateXTickets(500))
      futureSeq.map{seq => assert(seq.isInstanceOf[IndexedSeq[Array[Int]]])}
    }
    "eventually generate an IndexedSeq of length x where x is given as 500" in {
      val futureSeq = Future.sequence(LotteryTicket.generateXTickets(500))
      futureSeq.map{seq => assert(seq.length == 500)}
    }
    "eventually generate an IndexedSeq of length x where x is given as 5e6" in {
      val futureSeq = Future.sequence(LotteryTicket.generateXTickets(5000000))
      futureSeq.map{seq => assert(seq.length == 5000000)}
    }
    //Maybe add checks for randomness, although we do check randomness without futures above
  }
}
