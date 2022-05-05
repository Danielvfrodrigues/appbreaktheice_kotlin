package br.com.bravi.breaktheice.domain.usecase

import br.com.bravi.breaktheice.data.repository.ActivityRepository
import br.com.bravi.breaktheice.domain.entity.ActivityModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * @author Daniel Rodrigues
 * "Sometimes I believe the compiler ignores all my comments."
 */
class DoActivityUseCase(
    private val _activityRepository: ActivityRepository
) {

    operator fun invoke(
        compositeDisposable: CompositeDisposable,
        disposableObserver: DisposableObserver<ActivityModel?>
    ) {
        compositeDisposable.add(
            _activityRepository.doActivity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(disposableObserver)
        )
    }
}
