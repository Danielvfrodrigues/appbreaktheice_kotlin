package br.com.bravi.breaktheice.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.bravi.breaktheice.domain.entity.ActivityModel
import br.com.bravi.breaktheice.domain.usecase.*
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableCompletableObserver
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.subscribers.ResourceSubscriber
import java.util.*

/**
 * @author Daniel Rodrigues
 * "Sometimes I believe the compiler ignores all my comments."
 */
class MainViewModel(
    private val _deleteActivityUseCase: DeleteActivityUseCase,
    private val _doActivityFilteredUseCase: DoActivityFilteredUseCase,
    private val _doActivityUseCase: DoActivityUseCase,
    private val _getActivitiesUseCase: GetActivitiesUseCase,
    private val _getActivityUseCase: GetActivityUseCase,
    private val _insertActivityUseCase: InsertActivityUseCase,
    private val _updateStartTimeUseCase: UpdateStartTimeUseCase,
    private val _updateFinishTimeUseCase: UpdateFinishTimeUseCase
) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    /*
     * Live Data properties.
     */
    private val _activities by lazy {
        MutableLiveData<MutableList<ActivityModel?>?>(arrayListOf())
    }
    private val _activity by lazy {
        MutableLiveData<ActivityModel?>(null)
    }
    private val _startTime by lazy {
        MutableLiveData<String?>(null)
    }
    private val _finishTime by lazy {
        MutableLiveData<String?>(null)
    }
    private val _error by lazy {
        MutableLiveData<Throwable?>(null)
    }

    val activities: LiveData<MutableList<ActivityModel?>?>
        get() = _activities
    val activity: LiveData<ActivityModel?>
        get() = _activity
    val error: LiveData<Throwable?>
        get() = _error

    fun deleteActivity(activityModel: ActivityModel?) {
        _deleteActivityUseCase.invoke(
            compositeDisposable,
            object : DisposableCompletableObserver() {

                override fun onComplete() {}

                override fun onError(err: Throwable) {
                    _error.postValue(err)
                }
            },
            activityModel
        )
    }

    fun doActivityFiltered(options: MutableMap<String, String>) {
        _doActivityFilteredUseCase.invoke(
            compositeDisposable,
            object : DisposableObserver<ActivityModel?>() {

                override fun onNext(res: ActivityModel?) {
                    insertActivity(res)
                }

                override fun onError(err: Throwable) {
                    _error.postValue(err)
                }

                override fun onComplete() {}
            },
            options
        )
    }

    fun doActivity() {
        _doActivityUseCase.invoke(
            compositeDisposable,
            object : DisposableObserver<ActivityModel?>() {

                override fun onNext(res: ActivityModel?) {
                    insertActivity(res)
                }

                override fun onError(err: Throwable) {
                    _error.postValue(err)
                }

                override fun onComplete() {}
            })
    }

    fun getActivities() {
        _getActivitiesUseCase.invoke(
            compositeDisposable,
            object : ResourceSubscriber<MutableList<ActivityModel?>?>() {

                override fun onNext(res: MutableList<ActivityModel?>?) {
                    _activities.postValue(res)
                }

                override fun onError(err: Throwable) {
                    _error.postValue(err)
                }

                override fun onComplete() {}
            })
    }

    fun getActivity(id: Int) {
        _getActivityUseCase.invoke(
            compositeDisposable,
            object : ResourceSubscriber<ActivityModel?>() {

                override fun onNext(res: ActivityModel?) {
                    _activity.postValue(res)
                }

                override fun onError(err: Throwable) {
                    _error.postValue(err)
                }

                override fun onComplete() {}
            },
            id
        )
    }

    fun insertActivity(activityModel: ActivityModel?) {
        _insertActivityUseCase.invoke(
            compositeDisposable,
            object : DisposableCompletableObserver() {

                override fun onComplete() {
                    getActivities()
                }

                override fun onError(err: Throwable) {
                    _error.postValue(err)
                }
            },
            activityModel
        )
    }

    fun updateStartTime(startTime: String) {
        _updateStartTimeUseCase.invoke(
            compositeDisposable,
            object : DisposableCompletableObserver() {
                override fun onComplete() {
                    _startTime.postValue(startTime)
                }

                override fun onError(err: Throwable) {
                    _error.postValue(err)
                }

            },
            startTime
        )
    }

    fun updateFinishTime(finishTime: String) {
        _updateFinishTimeUseCase.invoke(
            compositeDisposable,
            object : DisposableCompletableObserver() {
                override fun onComplete() {
                    _finishTime.postValue(finishTime)
                }

                override fun onError(err: Throwable) {
                    _error.postValue(err)
                }

            },
            finishTime
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}