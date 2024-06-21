package com.pacto.pactodatatest.data;

import com.pacto.pactodatatest.domain.HomeDataSource;
import com.pacto.pactodatatest.domain.entities.User;
import io.reactivex.rxjava3.core.Single;
import javax.inject.Inject;

public class HomeRepository implements HomeDataSource {

  @Inject
  public HomeRepository() {
    //Empty constructor
  }

  @Override public Single<User> getUser() {
    return null; //TODO:: Please connect with dataRemoteSource
  }
}
