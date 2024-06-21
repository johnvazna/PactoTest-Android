package com.pacto.pactodatatest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.pacto.pactodatatest.domain.entities.User;
import com.pacto.pactodatatest.domain.usecase.GetUserUseCase;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import javax.inject.Inject;

public class MainViewModel extends ViewModel {

  private final GetUserUseCase getUserUseCase;
  private final CompositeDisposable compositeDisposable = new CompositeDisposable();
  private final MutableLiveData<User> userLiveData = new MutableLiveData<>();
  private final MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();

  @Inject
  public MainViewModel(GetUserUseCase getUserUseCase) {
    this.getUserUseCase = getUserUseCase;
  }

  public LiveData<User> getUserLiveData() {
    return userLiveData;
  }

  public LiveData<Throwable> getErrorLiveData() {
    return errorLiveData;
  }

  public void getUser() {
    compositeDisposable.add(
        getUserUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                userLiveData::setValue,
                errorLiveData::setValue
            )
    );
  }
}
