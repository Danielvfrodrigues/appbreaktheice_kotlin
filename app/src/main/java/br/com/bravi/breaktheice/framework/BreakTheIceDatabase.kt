package br.com.bravi.breaktheice.framework

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.bravi.breaktheice.domain.entity.ActivityModel
import br.com.bravi.breaktheice.framework.dao.IActivityDao

/**
 * @author Daniel Rodrigues
 * "Sometimes I believe the compiler ignores all my comments."
 */
@Database(entities = [ActivityModel::class], version = 1, exportSchema = false)
abstract class BreakTheIceDatabase : RoomDatabase() {

    abstract fun activityDao(): IActivityDao
}
