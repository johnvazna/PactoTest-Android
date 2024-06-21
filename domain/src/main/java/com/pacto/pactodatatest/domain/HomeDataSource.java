package com.pacto.pactodatatest.domain;

import com.pacto.pactodatatest.domain.entities.User;
import io.reactivex.rxjava3.core.Single;

public interface HomeDataSource {
  Single<User> getUser();
}
