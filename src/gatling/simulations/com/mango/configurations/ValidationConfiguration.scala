package com.mango.configurations

import scala.language.postfixOps

object ValidationConfiguration {
  val baseUrl: String = "http://internal-mango-validator.dev.k8s.mango"
  val accept: String = "application/json"
  val doNotTrack: String = "1"
  val acceptLanguage: String = "en-US,en;q=0.5"
  val acceptEncoding: String = "gzip, deflate"
  val userAgent: String = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0"
}
