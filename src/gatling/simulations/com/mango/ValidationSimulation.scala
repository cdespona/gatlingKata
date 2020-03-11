package com.mango

import ch.qos.logback.classic.{Level, LoggerContext}
import com.mango.configurations.ValidationConfiguration._
import com.mango.scenarios.ValidationScenario
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import org.slf4j.LoggerFactory

import scala.concurrent.duration._
import scala.language.postfixOps

class ValidationSimulation extends Simulation {
  val context: LoggerContext = LoggerFactory.getILoggerFactory.asInstanceOf[LoggerContext]
  context.getLogger("io.gatling.http").setLevel(Level.valueOf("TRACE"))

  val httpConf: HttpProtocolBuilder = http
    .baseUrl(baseUrl)
    .acceptHeader(accept)
    .doNotTrackHeader(doNotTrack)
    .acceptLanguageHeader(acceptLanguage)
    .acceptEncodingHeader(acceptEncoding)
    .userAgentHeader(userAgent)

  val globalAssertions: Seq[Assertion] = Seq(global.successfulRequests.percent gt 95)

  setUp(
    ValidationScenario.scenario inject (constantUsersPerSec(3) during(5 seconds))
  )
    .protocols(httpConf)
    .assertions(
      globalAssertions ++
      ValidationScenario.assertions
    )
}
