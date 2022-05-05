package br.com.bravi.breaktheice.domain.usecase

import br.com.bravi.breaktheice.data.repository.ActivityRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableCompletableObserver

/**
 * @author Daniel Rodrigues
 * "Sometimes I believe the compiler ignores all my comments."
 */
class UpdateStartTimeUseCase(
    private val _activityRepository: ActivityRepository
) {

    operator fun invoke(
        compositeDisposable: CompositeDisposable,
        disposableCompletableObserver: DisposableCompletableObserver,
        startTime: String
    ) {
        compositeDisposable.add(
            Completable
                .fromRunnable {
                    _activityRepository.updateStartTime(startTime)
                }
                .subscribeWith(disposableCompletableObserver)
        )
    }
}