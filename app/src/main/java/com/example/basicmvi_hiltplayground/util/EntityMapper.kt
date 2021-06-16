package com.example.basicmvi_hiltplayground.util

interface EntityMapper<Entity, DomainModel> {

    fun mapFromEntity(entity: Entity): DomainModel

    fun mapTOEntity(domainModel: DomainModel): Entity

}