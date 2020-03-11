package com.mango

import com.mango.configurations.Configuration._
import com.mango.scenarios.StockScenario
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration._
import scala.language.postfixOps

class StockSimulation extends Simulation {
  val httpConf: HttpProtocolBuilder = http
    .baseUrl(baseUrl)
    .acceptHeader(accept)
    .doNotTrackHeader(doNotTrack)
    .acceptLanguageHeader(acceptLanguage)
    .acceptEncodingHeader(acceptEncoding)
    .userAgentHeader(userAgent)

  val globalAssertions: Seq[Assertion] = Seq(global.successfulRequests.percent gt 95)

  setUp(
    StockScenario.scenario inject (constantUsersPerSec(3) during(5 seconds))
  )
    .protocols(httpConf)
    .assertions(
      globalAssertions ++
      StockScenario.assertions
    )
}
