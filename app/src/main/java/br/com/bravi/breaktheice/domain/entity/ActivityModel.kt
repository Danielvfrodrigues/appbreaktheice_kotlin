package br.com.bravi.breaktheice.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Daniel Rodrigues
 * "Sometimes I believe the compiler ignores all my comments."
 */
@Entity(tableName = "activity")
data class ActivityModel(
        @field:PrimaryKey(autoGenerate = true)
        var _id: Int,

        @field:ColumnInfo(name = "participants")
        var participants: Int,

        @field:ColumnInfo(name = "activity")
        var activity: String?,

        @field:ColumnInfo(name = "key")
        var key: String?,

        @field:ColumnInfo(name = "link")
        var link: String?,

        @field:ColumnInfo(name = "type")
        var type: String?,

        @field:ColumnInfo(name = "accessibility")
        var accessibility: Float,

        @field:ColumnInfo(name = "price")
        var price: Float,

        @field:ColumnInfo(name = "startTime")
        var startTime: String?,

        @field:ColumnInfo(name = "finishTime")
        var finishTime: String?
) {

    val isObjectValid: Boolean
        get() = key != null
}
