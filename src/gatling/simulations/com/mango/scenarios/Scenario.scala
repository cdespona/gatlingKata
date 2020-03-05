package com.mango.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.request.builder.HttpRequestBuilder
import io.gatling.http.Predef._
import io.netty.handler.codec.http.HttpResponseStatus.OK

import scala.language.postfixOps

object Scenario {

  def scenario(): ScenarioBuilder =
    ScenarioBuilder("Scenario Name")

  def assertions: Seq[Assertion] = {
    val path = details("Endpoint Name")
    Seq()
  }

  private def getOnOurEndpoint: HttpRequestBuilder =
    http("Endpoint Name")
      .get("/endPointPath")
}
