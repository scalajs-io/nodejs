package io.scalajs.npm.aws.sns

import scala.scalajs.js

/**
  * Returns a list of phone numbers that are opted out, meaning you cannot send SMS messages to them.
  *
  * The results for ListPhoneNumbersOptedOut are paginated, and each page returns up to 100 phone numbers. If
  * additional phone numbers are available after the first page of results, then a NextToken string will be returned.
  * To receive the next page, you call ListPhoneNumbersOptedOut again using the NextToken string received from the
  * previous call. When there are no more records to return, NextToken will be null.
  * @param nextToken A NextToken string is used when you call the ListPhoneNumbersOptedOut action to retrieve
  *                  additional records that are available after the first page of results.
  */
class ListPhoneNumbersOptedOut(var nextToken: js.UndefOr[String] = js.undefined) extends js.Object