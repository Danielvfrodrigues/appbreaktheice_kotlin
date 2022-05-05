package br.com.bravi.breaktheice.domain.usecase

import br.com.bravi.breaktheice.data.repository.ActivityRepository
import br.com.bravi.breaktheice.domain.entity.ActivityModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.subscribers.ResourceSubscriber

/**
 * @author Daniel Rodrigues
 * "Sometimes I believe the compiler ignores all my comments."
 */
class GetActivityUseCase(
    private val _activityRepository: ActivityRepository
) {

    operator fun invoke(
        compositeDisposable: CompositeDisposable,
        resourceSubscriber: ResourceSubscriber<ActivityModel?>,
        id: Int
    ) {
        compositeDisposable.add(
            _activityRepository.getActivity(id)
                .subscribeWith(resourceSubscriber)
        )
    }
}
