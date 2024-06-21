package com.pacto.pactodatatest.data.di;

import com.pacto.pactodatatest.data.HomeRepository;
import com.pacto.pactodatatest.data.remote.HomeRemoteDataSourceImpl;
import com.pacto.pactodatatest.domain.HomeDataSource;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@Module
@InstallIn(SingletonComponent.class)
public abstract class HomeDataModule {

  @Binds
  @Singleton
  public abstract HomeDataSource bindAuthRemoteDataSource(HomeRemoteDataSourceImpl impl);

  @Binds
  @Singleton
  public abstract HomeDataSource bindAuthDataSource(HomeRepository impl);
}
