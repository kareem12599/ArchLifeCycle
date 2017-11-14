package com.example.kareem.archlifecycle;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.example.kareem.archlifecycle.Model.User;

/**
 * Created by KAREEM on 11/13/2017.
 */

public class  DataProviderModel extends ViewModel {
    private String userId;
    private MutableLiveData<User> user  = new MutableLiveData<>();
    public final LiveData<String> userString = Transformations.map(user, new Function<User, String>() {
        @Override
        public String apply(User input) {
            return input.toString();
        }
    }); // return string livedata to activity so activity do less work
    // now we can observe userString liveData


    public MutableLiveData<User> getUser() {
        return user;
    }

    public DataProviderModel() {
        //user.postValue(new User ("Kareem Hassan "));  background thread
//        user.setValue(new User("Kareem")); // main thread
    }
}
