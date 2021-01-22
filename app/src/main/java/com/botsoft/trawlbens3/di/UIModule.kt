package com.botsoft.trawlbens3.di

import com.botsoft.trawlbens3.ViewInjectModule
import dagger.Module

@Module(
    includes = [
        ViewInjectModule::class
    ]
)
class UiModule { }