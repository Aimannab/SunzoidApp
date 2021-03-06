/*
 * Copyright (c) 2020 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.android.data.db.mapper

import com.raywenderlich.android.data.db.entities.DbForecast
import com.raywenderlich.android.data.db.entities.DbLocationDetails
import com.raywenderlich.android.domain.model.Forecast
import com.raywenderlich.android.domain.model.LocationDetails

class DbMapperImpl : DbMapper {
  override fun mapDomainLocationDetailsToDb(locationDetails: LocationDetails): DbLocationDetails {
    return with(locationDetails) {
      DbLocationDetails(
        time, sunrise, sunset, title, id
      )
    }
  }

  override fun mapDbLocationDetailsToDomain(locationDetails: DbLocationDetails): LocationDetails {
    return with(locationDetails) {
      LocationDetails(emptyList(), time, sunrise, sunset, title, id)
    }
  }

  override fun mapDomainForecastsToDb(forecasts: List<Forecast>): List<DbForecast> {
    return forecasts.map {
      with(it) {
        DbForecast(
          id,
          state,
          windDirection,
          date,
          minTemp,
          maxTemp,
          temp,
          windSpeed,
          pressure,
          humidity,
          visibility,
          predictability,
          weatherStateAbbreviation
        )
      }
    }
  }

  override fun mapDbForecastsToDomain(forecasts: List<DbForecast>): List<Forecast> {
    return forecasts.map {
      with(it) {
        Forecast(
          id,
          state,
          windDirection,
          date,
          minTemp,
          maxTemp,
          temp,
          windSpeed,
          pressure,
          humidity,
          visibility,
          predictability,
          weatherStateAbbreviation
        )
      }
    }
  }
}
