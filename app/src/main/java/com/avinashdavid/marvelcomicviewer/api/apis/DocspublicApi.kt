/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: 
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package com.avinashdavid.marvelcomicviewer.api.apis

import com.avinashdavid.marvelcomicviewer.api.tools.CSV
import org.threeten.bp.ZonedDateTime
import retrofit2.http.GET
import retrofit2.http.Headers

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
        @retrofit2.http.Path("comicId") comicId: Int
    ): Unit
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
        @retrofit2.http.Query("format") format: String?,
        @retrofit2.http.Query("formatType") formatType: String?,
        @retrofit2.http.Query("noVariants") noVariants: Boolean?,
        @retrofit2.http.Query("dateDescriptor") dateDescriptor: String?,
        @retrofit2.http.Query("dateRange") @CSV dateRange: List<Int>?,
        @retrofit2.http.Query("title") title: String?,
        @retrofit2.http.Query("titleStartsWith") titleStartsWith: String?,
        @retrofit2.http.Query("startYear") startYear: Int?,
        @retrofit2.http.Query("issueNumber") issueNumber: Int?,
        @retrofit2.http.Query("diamondCode") diamondCode: String?,
        @retrofit2.http.Query("digitalId") digitalId: Int?,
        @retrofit2.http.Query("upc") upc: String?,
        @retrofit2.http.Query("isbn") isbn: String?,
        @retrofit2.http.Query("ean") ean: String?,
        @retrofit2.http.Query("issn") issn: String?,
        @retrofit2.http.Query("hasDigitalIssue") hasDigitalIssue: Boolean?,
        @retrofit2.http.Query("modifiedSince") modifiedSince: ZonedDateTime?,
        @retrofit2.http.Query("creators") @CSV creators: List<Int>?,
        @retrofit2.http.Query("characters") @CSV characters: List<Int>?,
        @retrofit2.http.Query("series") @CSV series: List<Int>?,
        @retrofit2.http.Query("events") @CSV events: List<Int>?,
        @retrofit2.http.Query("stories") @CSV stories: List<Int>?,
        @retrofit2.http.Query("sharedAppearances") @CSV sharedAppearances: List<Int>?,
        @retrofit2.http.Query("collaborators") @CSV collaborators: List<Int>?,
        @retrofit2.http.Query("orderBy") @CSV orderBy: List<String>?,
        @retrofit2.http.Query("limit") limit: Int?,
        @retrofit2.http.Query("offset") offset: Int?
    ): Unit
    /**
     * Fetches lists of creators filtered by a comic id.
     * Fetches lists of comic creators whose work appears in a specific comic, with optional filters. See notes on individual parameters below.
     * The endpoint is owned by marvel service owner
     * @param comicId The comic id. (required)
     * @param firstName Filter by creator first name (e.g. brian). (optional)
     * @param middleName Filter by creator middle name (e.g. Michael). (optional)
     * @param lastName Filter by creator last name (e.g. Bendis). (optional)
     * @param suffix Filter by suffix or honorific (e.g. Jr., Sr.). (optional)
     * @param nameStartsWith Filter by creator names that match critera (e.g. B, St L). (optional)
     * @param firstNameStartsWith Filter by creator first names that match critera (e.g. B, St L). (optional)
     * @param middleNameStartsWith Filter by creator middle names that match critera (e.g. Mi). (optional)
     * @param lastNameStartsWith Filter by creator last names that match critera (e.g. Ben). (optional)
     * @param modifiedSince Return only creators which have been modified since the specified date. (optional)
     * @param comics Return only creators who worked on in the specified comics (accepts a comma-separated list of ids). (optional)
     * @param series Return only creators who worked on the specified series (accepts a comma-separated list of ids). (optional)
     * @param stories Return only creators who worked on the specified stories (accepts a comma-separated list of ids). (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     */
    @Headers(
        "X-Operation-ID: getCreatorCollection"
    )
    @GET("v1/public/comics/{comicId}/creators")
    suspend fun getCreatorCollection(
        @retrofit2.http.Path("comicId") comicId: Int,
        @retrofit2.http.Query("firstName") firstName: String?,
        @retrofit2.http.Query("middleName") middleName: String?,
        @retrofit2.http.Query("lastName") lastName: String?,
        @retrofit2.http.Query("suffix") suffix: String?,
        @retrofit2.http.Query("nameStartsWith") nameStartsWith: String?,
        @retrofit2.http.Query("firstNameStartsWith") firstNameStartsWith: String?,
        @retrofit2.http.Query("middleNameStartsWith") middleNameStartsWith: String?,
        @retrofit2.http.Query("lastNameStartsWith") lastNameStartsWith: String?,
        @retrofit2.http.Query("modifiedSince") modifiedSince: ZonedDateTime?,
        @retrofit2.http.Query("comics") @CSV comics: List<Int>?,
        @retrofit2.http.Query("series") @CSV series: List<Int>?,
        @retrofit2.http.Query("stories") @CSV stories: List<Int>?,
        @retrofit2.http.Query("orderBy") @CSV orderBy: List<String>?,
        @retrofit2.http.Query("limit") limit: Int?,
        @retrofit2.http.Query("offset") offset: Int?
    ): Unit
}