package com.kurt.example.rickandmorty.core.domain.usecases


import com.kurt.example.rickandmorty.core.domain.repositories.LocationsRepository
import javax.inject.Inject

/**
 * Copyright 2019, Kurt Renzo Acosta, All rights reserved.
 *
 * @author Kurt Renzo Acosta
 * @since 08/09/2019
 */
class GetLocation @Inject constructor(private val locationsRepository: LocationsRepository) {
    suspend operator fun invoke(locationId: Int) = locationsRepository.getLocation(locationId)
}