/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: 
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package com.avinashdavid.marvelcomicviewer.api.apis

import com.avinashdavid.marvelcomicviewer.api.models.ComicDataWrapper
import com.avinashdavid.marvelcomicviewer.api.tools.CSV
import org.threeten.bp.ZonedDateTime
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

@JvmSuppressWildcards
interface DocspublicApi {
    /**
     * Fetches a single comic by id.
     * This method fetches a single comic resource.  It is the canonical URI for any comic resource provided by the API.
     * The endpoint is owned by marvel service owner
     * @param comicId A single comic. (required)
     */
    @Headers(
        "X-Operation-ID: getComicIndividual"
    )
    @GET("v1/public/comics/{comicId}")
    suspend fun getComicIndividual(
        @retrofit2.http.Path("comicId") comicId: Int,
        @Query("ts") timeStamp: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String?,
    ): ComicDataWrapper?
    /**
     * Fetches lists of comics.
     * Fetches lists of comics with optional filters. See notes on individual parameters below.
     * The endpoint is owned by marvel service owner
     * @param format Filter by the issue format (e.g. comic, digital comic, hardcover). (optional)
     * @param formatType Filter by the issue format type (comic or collection). (optional)
     * @param noVariants Exclude variants (alternate covers, secondary printings, director&#39;s cuts, etc.) from the result set. (optional)
     * @param dateDescriptor Return comics within a predefined date range. (optional)
     * @param dateRange Return comics within a predefined date range.  Dates must be specified as date1,date2 (e.g. 2013-01-01,2013-01-02).  Dates are preferably formatted as YYYY-MM-DD but may be sent as any common date format. (optional)
     * @param title Return only issues in series whose title matches the input. (optional)
     * @param titleStartsWith Return only issues in series whose title starts with the input. (optional)
     * @param startYear Return only issues in series whose start year matches the input. (optional)
     * @param issueNumber Return only issues in series whose issue number matches the input. (optional)
     * @param diamondCode Filter by diamond code. (optional)
     * @param digitalId Filter by digital comic id. (optional)
     * @param upc Filter by UPC. (optional)
     * @param isbn Filter by ISBN. (optional)
     * @param ean Filter by EAN. (optional)
     * @param issn Filter by ISSN. (optional)
     * @param hasDigitalIssue Include only results which are available digitally. (optional)
     * @param modifiedSince Return only comics which have been modified since the specified date. (optional)
     * @param creators Return only comics which feature work by the specified creators (accepts a comma-separated list of ids). (optional)
     * @param characters Return only comics which feature the specified characters (accepts a comma-separated list of ids). (optional)
     * @param series Return only comics which are part of the specified series (accepts a comma-separated list of ids). (optional)
     * @param events Return only comics which take place in the specified events (accepts a comma-separated list of ids). (optional)
     * @param stories Return only comics which contain the specified stories (accepts a comma-separated list of ids). (optional)
     * @param sharedAppearances Return only comics in which the specified characters appear together (for example in which BOTH Spider-Man and Wolverine appear). Accepts a comma-separated list of ids. (optional)
     * @param collaborators Return only comics in which the specified creators worked together (for example in which BOTH Stan Lee and Jack Kirby did work). Accepts a comma-separated list of ids. (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     */
    @Headers(
        "X-Operation-ID: getComicsCollection"
    )
    @GET("v1/public/comics")
    suspend fun getComicsCollection(
        @Query("ts") timeStamp: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String?,
        @retrofit2.http.Query("format") format: String?,
        @retrofit2.http.Query("formatType") formatType: String?,
        @retrofit2.http.Query("noVariants") noVariants: Boolean?,
        @retrofit2.http.Query("dateDescriptor") dateDescriptor: String? = null,
        @retrofit2.http.Query("dateRange") @CSV dateRange: List<Int>? = null,
        @retrofit2.http.Query("title") title: String? = null,
        @retrofit2.http.Query("titleStartsWith") titleStartsWith: String? = null,
        @retrofit2.http.Query("startYear") startYear: Int? = null,
        @retrofit2.http.Query("issueNumber") issueNumber: Int? = null,
        @retrofit2.http.Query("diamondCode") diamondCode: String? = null,
        @retrofit2.http.Query("digitalId") digitalId: Int? = null,
        @retrofit2.http.Query("upc") upc: String? = null,
        @retrofit2.http.Query("isbn") isbn: String? = null,
        @retrofit2.http.Query("ean") ean: String? = null,
        @retrofit2.http.Query("issn") issn: String? = null,
        @retrofit2.http.Query("hasDigitalIssue") hasDigitalIssue: Boolean? = true,
        @retrofit2.http.Query("modifiedSince") modifiedSince: ZonedDateTime? = null,
        @retrofit2.http.Query("creators") @CSV creators: List<Int>? = null,
        @retrofit2.http.Query("characters") @CSV characters: List<Int>? = null,
        @retrofit2.http.Query("series") @CSV series: List<Int>? = null,
        @retrofit2.http.Query("events") @CSV events: List<Int>? = null,
        @retrofit2.http.Query("stories") @CSV stories: List<Int>? = null,
        @retrofit2.http.Query("sharedAppearances") @CSV sharedAppearances: List<Int>? = null,
        @retrofit2.http.Query("collaborators") @CSV collaborators: List<Int>? = null,
        @retrofit2.http.Query("orderBy") @CSV orderBy: List<String>? = null,
        @retrofit2.http.Query("limit") limit: Int? = 100,
        @retrofit2.http.Query("offset") offset: Int? = 0,
    ): ComicDataWrapper?
}
