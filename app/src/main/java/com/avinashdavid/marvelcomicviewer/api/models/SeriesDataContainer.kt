/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: 
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package com.avinashdavid.marvelcomicviewer.api.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property offset The requested offset (number of skipped results) of the call.
 * @property limit The requested result limit.
 * @property total The total number of resources available given the current filter set.
 * @property count The total number of results returned by this call.
 * @property results The list of series returned by the call
 */
@JsonClass(generateAdapter = true)
data class SeriesDataContainer(
    @Json(name = "offset") @field:Json(name = "offset") var offset: Int? = null,
    @Json(name = "limit") @field:Json(name = "limit") var limit: Int? = null,
    @Json(name = "total") @field:Json(name = "total") var total: Int? = null,
    @Json(name = "count") @field:Json(name = "count") var count: Int? = null,
    @Json(name = "results") @field:Json(name = "results") var results: Array<Series>? = null
)
