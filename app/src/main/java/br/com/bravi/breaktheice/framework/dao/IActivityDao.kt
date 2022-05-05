package br.com.bravi.breaktheice.framework.dao

import androidx.room.*
import br.com.bravi.breaktheice.domain.entity.ActivityModel
import io.reactivex.rxjava3.core.Flowable

/**
 * @author Daniel Rodrigues
 * "Sometimes I believe the compiler ignores all my comments."
 */
@Dao
interface IActivityDao {

    @Query("SELECT * FROM activity WHERE _id = :id")
    fun getActivity(id: Int): Flowable<ActivityModel?>

    @Query("SELECT * FROM activity")
    fun getActivities(): Flowable<MutableList<ActivityModel?>?>

    @Query("UPDATE activity SET startTime = :startTime")
    fun updateStartTime(startTime: String)

    @Query("UPDATE activity SET finishTime = :finishTime")
    fun updateFinishTime(finishTime: String)

    @Insert
    fun insertActivity(activityModel: ActivityModel)

    @Delete
    fun deleteActivity(activityModel: ActivityModel)
}
