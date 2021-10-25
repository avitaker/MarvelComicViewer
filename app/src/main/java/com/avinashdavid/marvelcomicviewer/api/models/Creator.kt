/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: 
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package com.avinashdavid.marvelcomicviewer.api.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

/**
 * @property id The unique ID of the creator resource.
 * @property firstName The first name of the creator.
 * @property middleName The middle name of the creator.
 * @property lastName The last name of the creator.
 * @property suffix The suffix or honorific for the creator.
 * @property fullName The full name of the creator (a space-separated concatenation of the above four fields).
 * @property modified The date the resource was most recently modified.
 * @property resourceURI The canonical URL identifier for this resource.
 * @property urls A set of public web site URLs for the resource.
 * @property thumbnail The representative image for this creator.
 * @property series A resource list containing the series which feature work by this creator.
 * @property stories A resource list containing the stories which feature work by this creator.
 * @property comics A resource list containing the comics which feature work by this creator.
 * @property events A resource list containing the events which feature work by this creator.
 */
@JsonClass(generateAdapter = true)
data class Creator(
    @Json(name = "id") @field:Json(name = "id") var id: Int? = null,
    @Json(name = "firstName") @field:Json(name = "firstName") var firstName: String? = null,
    @Json(name = "middleName") @field:Json(name = "middleName") var middleName: String? = null,
    @Json(name = "lastName") @field:Json(name = "lastName") var lastName: String? = null,
    @Json(name = "suffix") @field:Json(name = "suffix") var suffix: String? = null,
    @Json(name = "fullName") @field:Json(name = "fullName") var fullName: String? = null,
    @Json(name = "modified") @field:Json(name = "modified") var modified: Date? = null,
    @Json(name = "resourceURI") @field:Json(name = "resourceURI") var resourceURI: String? = null,
    @Json(name = "urls") @field:Json(name = "urls") var urls: Array<Url>? = null,
    @Json(name = "thumbnail") @field:Json(name = "thumbnail") var thumbnail: Image? = null,
    @Json(name = "series") @field:Json(name = "series") var series: SeriesList? = null,
    @Json(name = "stories") @field:Json(name = "stories") var stories: StoryList? = null,
    @Json(name = "comics") @field:Json(name = "comics") var comics: ComicList? = null,
    @Json(name = "events") @field:Json(name = "events") var events: EventList? = null
)