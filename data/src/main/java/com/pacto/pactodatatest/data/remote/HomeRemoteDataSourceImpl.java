package com.pacto.pactodatatest.data.remote;

import com.pacto.pactodatatest.data.remote.entities.UserDto;
import io.reactivex.rxjava3.core.Single;

public class HomeRemoteDataSourceImpl implements HomeRemoteDataSource {

  @Override public Single<UserDto> getUser() {
    return Single.create(emitter -> {
      try {
        UserDto userDto = new UserDto("Administrator", "test@pacto.co");
        emitter.onSuccess(userDto);
      } catch (Exception e) {
        emitter.onError(e);
      }
    });
  }
}
