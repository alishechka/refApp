package com.example.refapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.refapplication.model.RandomPoem;
import com.example.refapplication.repo.Repo;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;

public class PoetryViewModel extends ViewModel {
    private CompositeDisposable compositeDisposable;
    private Repo repo;
    private MutableLiveData<RandomPoem> _poem = new MutableLiveData<>();
    private MutableLiveData<String> _error = new MutableLiveData<>();


    public LiveData<RandomPoem> poem() {
        return _poem;
    }

    public LiveData<String> error() {
        return _error;
    }

    public void getPoemData() {
        repo = new Repo();
        compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(
                repo.getRepoClientCallThing().subscribeWith(new DisposableSingleObserver<List<RandomPoem>>() {

                    @Override
                    public void onSuccess(List<RandomPoem> randomPoem) {
                        _poem.setValue(randomPoem.get(0));
                    }

                    @Override
                    public void onError(Throwable e) {
                        _error.setValue(e.getLocalizedMessage());
                    }
                })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (compositeDisposable != null) {
            compositeDisposable.clear();
            compositeDisposable = null;
        }
    }
}
