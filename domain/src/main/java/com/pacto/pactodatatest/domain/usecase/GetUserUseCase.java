package com.pacto.pactodatatest.domain.usecase;

import com.pacto.pactodatatest.domain.HomeDataSource;
import com.pacto.pactodatatest.domain.entities.User;
import io.reactivex.rxjava3.core.Single;

public class GetUserUseCase {

  private final HomeDataSource homeDataSource;

  public Single<User> execute() {
    return homeDataSource.getUser();
  }
}
