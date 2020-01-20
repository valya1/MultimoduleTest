package ru.napoleonit.featureCloser

import ru.napoleonit.settings.dependency.FeatureCloser
import ru.terrakok.cicerone.Router
import javax.inject.Inject
import javax.inject.Named

class FeatureCloserImpl @Inject constructor(@Named("global") private val appRouter: Router) :
    FeatureCloser {

    override fun close() = appRouter.exit()
}