package com.davidcombita.data.models

import com.google.gson.annotations.SerializedName

data class Cat (
    val weight: Weight,
    val id: String,
    val name: String,

    @SerializedName("cfa_url")
    val cfaURL: String? = null,

    @SerializedName("vetstreet_url")
    val vetstreetURL: String? = null,

    @SerializedName("vcahospitals_url")
    val vcahospitalsURL: String? = null,

    val temperament: String,
    val origin: String,

    @SerializedName("country_codes")
    val countryCodes: String,

    @SerializedName("country_code")
    val countryCode: String,

    val description: String,

    @SerializedName("life_span")
    val lifeSpan: String,

    val indoor: Long,
    val lap: Long? = null,

    @SerializedName("alt_names")
    val altNames: String? = null,

    val adaptability: Long,

    @SerializedName("affection_level")
    val affectionLevel: Long,

    @SerializedName("child_friendly")
    val childFriendly: Long,

    @SerializedName("dog_friendly")
    val dogFriendly: Long,

    @SerializedName("energy_level")
    val energyLevel: Long,

    val grooming: Long,

    @SerializedName("health_issues")
    val healthIssues: Long,

    val intelligence: Long,

    @SerializedName("shedding_level")
    val sheddingLevel: Long,

    @SerializedName("social_needs")
    val socialNeeds: Long,

    @SerializedName("stranger_friendly")
    val strangerFriendly: Long,

    val vocalisation: Long,
    val experimental: Long,
    val hairless: Long,
    val natural: Long,
    val rare: Long,
    val rex: Long,

    @SerializedName("suppressed_tail")
    val suppressedTail: Long,

    @SerializedName("short_legs")
    val shortLegs: Long,

    @SerializedName("wikipedia_url")
    val wikipediaURL: String? = null,

    val hypoallergenic: Long,

    @SerializedName("reference_image_id")
    val referenceImageID: String? = null,

    @SerializedName("cat_friendly")
    val catFriendly: Long? = null,

    val bidability: Long? = null
)

data class Weight (
    val imperial: String,
    val metric: String
)