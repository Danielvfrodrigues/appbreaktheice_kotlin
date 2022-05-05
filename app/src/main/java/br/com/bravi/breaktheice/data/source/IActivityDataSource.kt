package br.com.bravi.breaktheice.data.source

import br.com.bravi.breaktheice.domain.entity.ActivityModel
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable

/**
 * @author Daniel Rodrigues
 * "Sometimes I believe the compiler ignores all my comments."
 */
interface IActivityDataSource {

    /*
    *   Network Contracts
    */
    fun doActivity(): Observable<ActivityModel?>

    fun doActivityFiltered(options: MutableMap<String, String>?): Observable<ActivityModel?>

    /*
    *   Database Contracts
    */
    fun getActivity(id: Int): Flowable<ActivityModel?>

    fun getActivities(): Flowable<MutableList<ActivityModel?>?>

    fun insertActivity(activityModel: ActivityModel)

    fun deleteActivity(activityModel: ActivityModel)

    fun updateStartTime(startTime: String)

    fun updateFinishTime(finishTime: String)
}
