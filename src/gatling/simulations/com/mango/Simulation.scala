package com.mango

import com.mango.configurations.Configuration._
import com.mango.scenarios.Scenario
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration._
import scala.language.postfixOps

class Simulation extends Simulation {
  val httpConf: HttpProtocolBuilder = http
    .baseUrl(baseUrl)
    .acceptHeader(accept)
    .doNotTrackHeader(doNotTrack)
    .acceptLanguageHeader(acceptLanguage)
    .acceptEncodingHeader(acceptEncoding)
    .userAgentHeader(userAgent)

  val globalAssertions: Seq[Assertion] = Seq(global.successfulRequests.percent gt 95)

  setUp(
    Scenario.scenario inject (constantUsersPerSec(3) during(5 seconds))
  )
    .protocols(httpConf)
    .assertions(
      globalAssertions ++
      Scenario.assertions
    )
}
