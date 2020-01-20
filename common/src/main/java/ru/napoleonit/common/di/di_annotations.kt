package ru.napoleonit.common.di

import androidx.fragment.app.Fragment
import dagger.MapKey
import kotlin.reflect.KClass

@Retention(value = AnnotationRetention.RUNTIME)
annotation class FeatureScope

@Retention(value = AnnotationRetention.RUNTIME)
annotation class ActivityScope

@Retention(value = AnnotationRetention.RUNTIME)
annotation class FragmentScope

@MustBeDocumented
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class FragmentKey(val value: KClass<out Fragment>)