/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: 
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package com.avinashdavid.marvelcomicviewer.api.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property available The number of total available stories in this list. Will always be greater than or equal to the \&quot;returned\&quot; value.
 * @property returned The number of stories returned in this collection (up to 20).
 * @property collectionURI The path to the full list of stories in this collection.
 * @property items The list of returned stories in this collection.
 */
@JsonClass(generateAdapter = true)
data class StoryList(
    @Json(name = "available") @field:Json(name = "available") var available: Int? = null,
    @Json(name = "returned") @field:Json(name = "returned") var returned: Int? = null,
    @Json(name = "collectionURI") @field:Json(name = "collectionURI") var collectionURI: String? = null,
    @Json(name = "items") @field:Json(name = "items") var items: Array<StorySummary>? = null
)
