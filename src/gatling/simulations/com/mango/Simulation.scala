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
}
