package kopycinski.tomasz.ideefixecreator.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Attribute(
    val name: String,
    val description: String,
    val level: Int = 8,

    @PrimaryKey(autoGenerate = true) val attributeId: Long = 0
)