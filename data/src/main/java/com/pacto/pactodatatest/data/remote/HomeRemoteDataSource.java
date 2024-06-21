package com.pacto.pactodatatest.data.remote;

import com.pacto.pactodatatest.data.remote.entities.UserDto;
import io.reactivex.rxjava3.core.Single;

public interface HomeRemoteDataSource {
  Single<UserDto> getUser();
}
