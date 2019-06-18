package io.scalajs.npm.amcharts

import scala.scalajs.js

/**
  * Base class of [[AmRectangularChart]] and [[AmRadarChart]]. It can not be instantiated explicitly.
  * @see https://docs.amcharts.com/3/javascriptstockchart/AmCoordinateChart
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait AmCoordinateChart extends AmChart {

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
  //    Properties
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////

  // TODO

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
  //    Methods
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
    * Adds a graph to the chart.
    * @param graph the instance of [[AmGraph graph]]
    */
  def addGraph(graph: AmGraph): Unit = js.native

  /**
    * Adds value axis to the chart. One value axis is created automatically, so if you don't want to change
    * anything or add more value axes, you don't need to add it.
    * @param axis the instance of ValueAxis
    */
  def addValueAxis(axis: ValueAxis): Unit = js.native

  /**
    * You can trigger the animation of the chart.
    */
  def animateAgain(): Unit = js.native

  /**
    * Returns graph by id.
    * @param id the graph's id
    * @return the [[AmGraph graph]]
    */
  def getGraphById(id: String): AmGraph = js.native

  /**
    * , String	ValueAxis	Returns value axis by id.
    * @param id the value axis' id
    * @return the [[ValueAxis value axis]]
    */
  def getValueAxisById(id: String): ValueAxis = js.native

  /**
    * Hide the graph (if it is visible). Usually this method is called from the Legend, when you click on the legend marker.
    * @param graph the instance of [[AmGraph graph]]
    */
  def hideGraph(graph: AmGraph): Unit = js.native

  /**
    * Hide value balloon of a graph. Usually this method is called from the Legend, when you click on the legend text.
    * @param graph the instance of [[AmGraph graph]]
    */
  def hideGraphsBalloon(graph: AmGraph): Unit = js.native

  /**
    * Highlight the graph. Usually this method is called from the Legend, when you roll-over the legend entry.
    * @param graph the instance of [[AmGraph graph]]
    */
  def highlightGraph(graph: AmGraph): Unit = js.native

  /**
    * Removes graph from the chart.
    * @param graph the instance of [[AmGraph graph]]
    */
  def removeGraph(graph: AmGraph): Unit = js.native

  /**
    * Removes value axis from the chart. When you remove value axis, all graphs assigned to this axis are also removed.
    * @param axis the instance of ValueAxis
    */
  def removeValueAxis(axis: ValueAxis): Unit = js.native

  /**
    * Show the graph (if it is hidden). Usually this method is called from the Legend, when you click on the legend marker.
    * @param graph the instance of [[AmGraph graph]]
    */
  def showGraph(graph: AmGraph): Unit = js.native

  /**
    * Show value balloon of a graph. Usually this method is called from the Legend, when you click on the legend text.
    * @param graph the instance of [[AmGraph graph]]
    */
  def showGraphsBalloon(graph: AmGraph): Unit = js.native

  /**
    * UnhighlightGraph the graph. Usually this method is called from the Legend, when you roll-out the legend entry.
    * @param graph the instance of [[AmGraph graph]]
    */
  def unhighlightGraph(graph: AmGraph): Unit = js.native

}
