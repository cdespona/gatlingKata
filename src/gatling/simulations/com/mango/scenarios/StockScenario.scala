package com.mango.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import io.netty.handler.codec.http.HttpResponseStatus.OK

import scala.language.postfixOps

object StockScenario {

  def scenario(): ScenarioBuilder =
    ScenarioBuilder("Stock Info Scenario") exec info

  def assertions: Seq[Assertion] = {
    val path = details("Stock Info Endpoint")
    Seq(
      path.failedRequests.percent lte 1,
      path.responseTime.percentile3 lte 1000)
  }

  private def info: HttpRequestBuilder =
    http("Stock Info Endpoint")
      .get("/info")
      .check(status.is(OK.code()))
}
