package br.com.bravi.breaktheice.domain.usecase

import br.com.bravi.breaktheice.data.repository.ActivityRepository
import br.com.bravi.breaktheice.domain.entity.ActivityModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableCompletableObserver

/**
 * @author Daniel Rodrigues
 * "Sometimes I believe the compiler ignores all my comments."
 */
class InsertActivityUseCase(
    private val _activityRepository: ActivityRepository
) {

    operator fun invoke(
        compositeDisposable: CompositeDisposable,
        disposableCompletableObserver: DisposableCompletableObserver,
        activityModel: ActivityModel?
    ) {
        compositeDisposable.add(
            Completable
                .fromRunnable {
                    if (activityModel?.isObjectValid == true) {
                        _activityRepository.insertActivity(activityModel)
                    }
                }
                .subscribeWith(disposableCompletableObserver)
        )
    }
}
