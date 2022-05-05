package br.com.bravi.breaktheice.di

import androidx.room.Room
import br.com.bravi.breaktheice.data.repository.ActivityRepository
import br.com.bravi.breaktheice.data.source.IActivityDataSource
import br.com.bravi.breaktheice.domain.usecase.*
import br.com.bravi.breaktheice.framework.BreakTheIceDatabase
import br.com.bravi.breaktheice.framework.source.ActivityDataSourceImpl
import br.com.bravi.breaktheice.presentation.viewmodel.MainViewModel
import br.com.bravi.breaktheice.util.constant.DatabaseConstant.DATABASE_NAME
import br.com.bravi.breaktheice.util.constant.WebserviceConstant
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Daniel Rodrigues
 * "Sometimes I believe the compiler ignores all my comments."
 */

fun injectBreakTheIceModule(): Module {
    return module {
        /*
         * OkHttpClient injection.
         */
        factory {
            OkHttpClient.Builder()
                .build()
        }

        /*
         * Retrofit injection.
         */
        single {
            Retrofit.Builder()
                .baseUrl(WebserviceConstant.WEBSERVICE_BASEURL)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(get())
                .build()
        }

        /*
         * Room Database Injection.
         */
        single {
            Room.databaseBuilder(androidContext(), BreakTheIceDatabase::class.java, DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }

        /*
         * Data Source injection.
         */
        factory<IActivityDataSource> {
            ActivityDataSourceImpl(
                get(),
                get()
            )
        }

        /*
         * Repository injection.
         */
        factory {
            ActivityRepository(get())
        }

        /*
         * Use Case injection.
         */
        factory {
            DeleteActivityUseCase(get())
        }
        factory {
            DoActivityFilteredUseCase(get())
        }
        factory {
            DoActivityUseCase(get())
        }
        factory {
            GetActivitiesUseCase(get())
        }
        factory {
            GetActivityUseCase(get())
        }
        factory {
            InsertActivityUseCase(get())
        }
        factory {
            UpdateStartTimeUseCase(get())
        }
        factory {
            UpdateFinishTimeUseCase(get())
        }

        /*
         * View Model injection.
         */
        viewModel {
            MainViewModel(get(), get(), get(), get(), get(), get(), get(), get())
        }
    }
}
