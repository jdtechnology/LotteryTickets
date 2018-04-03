package com.lottery.ticket

import org.scalatest._

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

}
