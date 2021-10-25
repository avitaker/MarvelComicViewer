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
 * @property id The unique ID of the series resource.
 * @property title The canonical title of the series.
 * @property description A description of the series.
 * @property resourceURI The canonical URL identifier for this resource.
 * @property urls A set of public web site URLs for the resource.
 * @property startYear The first year of publication for the series.
 * @property endYear The last year of publication for the series (conventionally, 2099 for ongoing series) .
 * @property rating The age-appropriateness rating for the series.
 * @property modified The date the resource was most recently modified.
 * @property thumbnail The representative image for this series.
 * @property comics A resource list containing comics in this series.
 * @property stories A resource list containing stories which occur in comics in this series.
 * @property events A resource list containing events which take place in comics in this series.
 * @property characters A resource list containing characters which appear in comics in this series.
 * @property creators A resource list of creators whose work appears in comics in this series.
 * @property next A summary representation of the series which follows this series.
 * @property previous A summary representation of the series which preceded this series.
 */
@JsonClass(generateAdapter = true)
data class Series(
    @Json(name = "id") @field:Json(name = "id") var id: Int? = null,
    @Json(name = "title") @field:Json(name = "title") var title: String? = null,
    @Json(name = "description") @field:Json(name = "description") var description: String? = null,
    @Json(name = "resourceURI") @field:Json(name = "resourceURI") var resourceURI: String? = null,
    @Json(name = "urls") @field:Json(name = "urls") var urls: Array<Url>? = null,
    @Json(name = "startYear") @field:Json(name = "startYear") var startYear: Int? = null,
    @Json(name = "endYear") @field:Json(name = "endYear") var endYear: Int? = null,
    @Json(name = "rating") @field:Json(name = "rating") var rating: String? = null,
    @Json(name = "modified") @field:Json(name = "modified") var modified: Date? = null,
    @Json(name = "thumbnail") @field:Json(name = "thumbnail") var thumbnail: Image? = null,
    @Json(name = "comics") @field:Json(name = "comics") var comics: ComicList? = null,
    @Json(name = "stories") @field:Json(name = "stories") var stories: StoryList? = null,
    @Json(name = "events") @field:Json(name = "events") var events: EventList? = null,
    @Json(name = "characters") @field:Json(name = "characters") var characters: CharacterList? = null,
    @Json(name = "creators") @field:Json(name = "creators") var creators: CreatorList? = null,
    @Json(name = "next") @field:Json(name = "next") var next: SeriesSummary? = null,
    @Json(name = "previous") @field:Json(name = "previous") var previous: SeriesSummary? = null
)