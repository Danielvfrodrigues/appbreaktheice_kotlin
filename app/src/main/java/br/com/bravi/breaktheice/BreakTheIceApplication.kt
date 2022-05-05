package br.com.bravi.breaktheice

import android.app.Application
import br.com.bravi.breaktheice.di.injectBreakTheIceModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * @author Daniel Rodrigues
 * "Sometimes I believe the compiler ignores all my comments."
 */
class BreakTheIceApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(applicationContext)

            modules(
                arrayListOf(
                    injectBreakTheIceModule()
                )
            )
        }
    }
}
