package com.botsoft.trawlbens3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.botsoft.trawlbens3.di.extension.DaggerViewModelFactory
import com.botsoft.trawlbens3.di.extension.ViewModelKey
import com.botsoft.trawlbens3.ui.list.ListFragment
import com.botsoft.trawlbens3.ui.list.ListViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ViewInjectModule {

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory?): ViewModelProvider.Factory?

    @ContributesAndroidInjector
    abstract fun bindListFragment(): ListFragment
//
    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    abstract fun provideListViewModel(listViewModel: ListViewModel?): ViewModel?

}