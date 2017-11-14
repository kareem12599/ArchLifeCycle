package com.example.kareem.archlifecycle;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kareem.archlifecycle.Model.User;

public class MainActivity extends AppCompatActivity {

    TextView usernameTv;
    EditText name;
    DataProviderModel model;
    Button  button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameTv = findViewById(R.id.username);
        name = findViewById(R.id.name);
        button = findViewById(R.id.button);
        model = ViewModelProviders.of(this).get(DataProviderModel.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.getUser().setValue(new User(name.getText().toString()));
            }
        });


        Observer<String> observer = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String user) {
                usernameTv.setText(user);

            }

        };
    model.userString.observe(this, observer);
    }


//    public static class FileAsyncTaskLoader extends AsyncTaskLoader<List<User>>{
//         private List<User> mData;
//         private FileObserver mFileObserver;
//        public FileAsyncTaskLoader(Context context){
//            super(context);
//        }
//
//        @Override
//        protected void onStartLoading() {
//            if(mData != null){
//                deliverResult(mData);
//            }
//            if(mFileObserver == null){
//                String path = new File(getContext().getFilesDir(), "downloaded file.json").getPath();
//                mFileObserver = new FileObserver(path) {
//                    @Override
//                    public void onEvent(int event, @Nullable String path) {
//                        onContentChanged();
//                    }
//                };
//                mFileObserver.startWatching();
//            }
//            if(takeContentChanged() || mData == null)
//                forceLoad();
//        }
//
//        @Override
//        public void deliverResult(List<User> data) {
//            mData = data;
//            super.deliverResult(data);
//        }
//
//        @Override
//        public List<User> loadInBackground() {
//            File jsonFile = new File(getContext().getFilesDir(), "downloaded file.json");
//            List <User>data = new ArrayList();
//            // parsing data
//            return data;
//        }
//        protected void onReset() {
//            // Stop watching for file changes
//            if (mFileObserver != null) {
//                mFileObserver.stopWatching();
//                mFileObserver = null;
//            }
//        }
//    }
//
//    @Override
//    public Object onRetainCustomNonConfigurationInstance() {
//
//        return this;
//    }
//
//    @Nullable
//    @Override
//    public Object getLastNonConfigurationInstance() {
//        return super.getLastNonConfigurationInstance();
//    }
}
