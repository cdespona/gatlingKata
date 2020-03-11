package com.mango.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import io.netty.handler.codec.http.HttpResponseStatus.OK

import scala.language.postfixOps

object ValidationScenario {

  private val jsonFileFeeder = jsonFile("iso.json").circular

  def scenario(): ScenarioBuilder =
    ScenarioBuilder("Mango Validator Scenario")
      .feed(jsonFileFeeder)
      .exec(countryCodes)

  def assertions: Seq[Assertion] = {
    val path = details("Mango Validate Country ISOs Endpoint")
    Seq(
      path.failedRequests.percent lte 1,
      path.responseTime.percentile3 lte 1000)
  }

  private def countryCodes: HttpRequestBuilder =
    http("Mango Validate Country ISOs Endpoint")
      .get("/phone/country-codes")
      .queryParam("countryIso", "${country}")
      .queryParam("languageIso", "${language}")
      .check(status.is(OK.code()))
      .check(jsonPath("$..defaultCountryId").ofType[String])
      .check(jsonPath("$..countryCodes"))
}
