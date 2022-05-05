package br.com.bravi.breaktheice.data.repository

import br.com.bravi.breaktheice.data.source.IActivityDataSource
import br.com.bravi.breaktheice.domain.entity.ActivityModel
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable

/**
 * @author Daniel Rodrigues
 * "Sometimes I believe the compiler ignores all my comments."
 */
class ActivityRepository(
    private val _activityDataSource: IActivityDataSource
) {
    /*
    *   Network Repository
    */
    fun doActivity(): Observable<ActivityModel?> {
        return _activityDataSource.doActivity()
    }

    fun doActivityFiltered(options: MutableMap<String, String>): Observable<ActivityModel?> {
        return _activityDataSource.doActivityFiltered(options)
    }

    /*
    *   Database Repository
    */
    fun getActivity(id: Int): Flowable<ActivityModel?> {
        return _activityDataSource.getActivity(id)
    }

    fun getActivities(): Flowable<MutableList<ActivityModel?>?> {
        return _activityDataSource.getActivities()
    }

    fun insertActivity(activityModel: ActivityModel) {
        _activityDataSource.insertActivity(activityModel)
    }

    fun deleteActivity(activityModel: ActivityModel) {
        _activityDataSource.deleteActivity(activityModel)
    }

    fun updateStartTime(startTime: String) {
        _activityDataSource.updateStartTime(startTime)
    }

    fun updateFinishTime(finishTime: String) {
        _activityDataSource.updateFinishTime(finishTime)
    }
}