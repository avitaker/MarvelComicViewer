/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: 
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package com.avinashdavid.marvelcomicviewer.api.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property resourceURI The path to the individual comic resource.
 * @property name The canonical name of the comic.
 */
@JsonClass(generateAdapter = true)
data class ComicSummary(
    @Json(name = "resourceURI") @field:Json(name = "resourceURI") var resourceURI: String? = null,
    @Json(name = "name") @field:Json(name = "name") var name: String? = null
)
