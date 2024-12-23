package com.irubenmh.kmp.pizzeria.di

import com.irubenmh.kmp.pizzeria.common.vm.BaseViewModel
import com.irubenmh.kmp.pizzeria.data.service.LoginService
import com.irubenmh.kmp.pizzeria.data.service.LoginServiceImpl
import com.irubenmh.kmp.pizzeria.domain.repository.LoginRepository
import com.irubenmh.kmp.pizzeria.domain.repository.LoginRepositoryImpl
import com.irubenmh.kmp.pizzeria.feature.auth.vm.LoginViewModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(viewModelsModule, dataModule)
    }
}

expect val nativeModule: Module

val viewModelsModule = module {
    viewModelOf(::BaseViewModel)
    viewModelOf(::LoginViewModel)
}

val dataModule = module {

    //Login
    factory<LoginService>{ LoginServiceImpl()}
    factory<LoginRepository>{ LoginRepositoryImpl(get())}
}
