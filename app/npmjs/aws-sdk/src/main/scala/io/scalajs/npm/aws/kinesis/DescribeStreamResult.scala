package io.scalajs.npm.aws.kinesis

import io.scalajs.npm.aws.kinesis.DescribeStreamResult._

import scala.scalajs.js

/**
  * @example {{{
  * {
  *    "StreamDescription": { 
  *       "EncryptionType": "string",
  *       "EnhancedMonitoring": [ 
  *          { 
  *             "ShardLevelMetrics": [ "string" ]
  *          }
  *       ],
  *       "HasMoreShards": boolean,
  *       "KeyId": "string",
  *       "RetentionPeriodHours": number,
  *       "Shards": [ 
  *          { 
  *             "AdjacentParentShardId": "string",
  *             "HashKeyRange": { 
  *                "EndingHashKey": "string",
  *                "StartingHashKey": "string"
  *             },
  *             "ParentShardId": "string",
  *             "SequenceNumberRange": { 
  *                "EndingSequenceNumber": "string",
  *                "StartingSequenceNumber": "string"
  *             },
  *             "ShardId": "string"
  *          }
  *       ],
  *       "StreamARN": "string",
  *       "StreamCreationTimestamp": number,
  *       "StreamName": "string",
  *       "StreamStatus": "string"
  *    }
  * }          
  * }}}
  */
trait DescribeStreamResult extends js.Object {

  def StreamDescription: StreamDescriptionType

}

/**
  * Describe Stream Result Companion
  * @author lawrence.daniels@gmail.com
  */
object DescribeStreamResult {


  trait EnhancedMonitoringType extends js.Object {

    def ShardLevelMetrics: js.Array[String]

  }

  trait HashKeyRangeType extends js.Object {

    def EndingHashKey: String

    def StartingHashKey: String

  }

  trait SequenceNumberRangeType extends js.Object {

    def EndingSequenceNumber: String

    def StartingSequenceNumber: String

  }

  trait ShardType extends js.Object {

    def AdjacentParentShardId: String

    def HashKeyRange: HashKeyRangeType

    def ParentShardId: String

    def SequenceNumberRange: SequenceNumberRangeType

    def ShardId: String

  }

  trait StreamDescriptionType extends js.Object {

    def EncryptionType: String

    def EnhancedMonitoring: js.Array[EnhancedMonitoringType]

    def HasMoreShards: Boolean

    def KeyId: String

    def RetentionPeriodHours: Int

    def Shards: js.Array[ShardType]

    def StreamARN: String

    def StreamCreationTimestamp: Double

    def StreamName: String

    def StreamStatus: String

  }

}