package br.com.bravi.breaktheice.framework.source

import br.com.bravi.breaktheice.data.source.IActivityDataSource
import br.com.bravi.breaktheice.domain.entity.ActivityModel
import br.com.bravi.breaktheice.framework.BreakTheIceDatabase
import br.com.bravi.breaktheice.framework.service.IActivityService
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import retrofit2.Retrofit

/**
 * @author Daniel Rodrigues
 * "Sometimes I believe the compiler ignores all my comments."
 */
class ActivityDataSourceImpl(
    private val _database: BreakTheIceDatabase,
    private val _retrofit: Retrofit
) : IActivityDataSource {

    /*
    *   Network Implementation
    */
    override fun doActivity(): Observable<ActivityModel?> {
        return _retrofit.create(IActivityService::class.java)
            .doActivity()
    }

    override fun doActivityFiltered(options: MutableMap<String, String>?): Observable<ActivityModel?> {
        return _retrofit.create(IActivityService::class.java)
            .doActivityFiltered(options)
    }

    /*
    *   Database Implementation
    */
    override fun getActivity(id: Int): Flowable<ActivityModel?> {
        return _database.activityDao()
            .getActivity(id)
    }

    override fun getActivities(): Flowable<MutableList<ActivityModel?>?> {
        return _database.activityDao()
            .getActivities()
    }

    override fun insertActivity(activityModel: ActivityModel) {
        _database.activityDao()
            .insertActivity(activityModel)
    }

    override fun deleteActivity(activityModel: ActivityModel) {
        _database.activityDao()
            .deleteActivity(activityModel)
    }

    override fun updateStartTime(startTime: String) {
        _database.activityDao()
            .updateStartTime(startTime)
    }

    override fun updateFinishTime(finishTime: String) {
        _database.activityDao()
            .updateFinishTime(finishTime)
    }
}
