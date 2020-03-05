# Gatling Kata

## [Gatling](https://gatling.io/open-source/)

What is Gatling?
Gatling is a powerful open-source load testing solution.

Gatling is designed for continuous load testing and integrates with your development pipeline. Gatling includes a web recorder and colorful reports.

It is important to remark that gatling uses [**Scala**](https://www.scala-lang.org/) as a programming language.

[Gatling Documentation](https://gatling.io/docs/current/general/)

## Gatling Gradle Plugin

As there is no default gradle plugin for gatling the easiest one to plug in so far is the one created by [Laszlo Kishalmi](https://github.com/lkishalmi), 
you can find the repository and documentation [here](https://github.com/lkishalmi/gradle-gatling-plugin)

### Project Structure

The plugin already provides a project structure and all your Scala code must be under `src/gatling`, by default Gatling is going to scan
for `**/*Simulation*.scala`.

## How to execute

The plugin provides a task to run gradle easily.

    ./gradlew clean gatlingRun

or for a specific simulation

     ./gradlew clean gatlingRun-SimulationName