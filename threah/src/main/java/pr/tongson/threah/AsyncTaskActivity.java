package pr.tongson.threah;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AsyncTaskActivity extends BaseActivity {
    private MyTask mTask;
    private ProgressBar progressBar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);


        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        textView = (TextView) findViewById(R.id.text_view);

        mTask = new MyTask();
        mTask.execute("666");
    }

    private class MyTask extends AsyncTask<String, Integer, String> {
        //onPreExecute方法用于在执行后台任务前做一些UI操作  
        @Override
        protected void onPreExecute() {
            Log.i(TAG, "onPreExecute() called");
            textView.setText("loading...");
        }

        //doInBackground方法内部执行后台任务,不可在此方法内修改UI  
        @Override
        protected String doInBackground(String... params) {
            Log.i(TAG, "doInBackground(Params... params) called");
            try {
                if(params[0].equals("666")){
                    int progresses = 0;
                    while (progresses != 100) {
                        publishProgress((int) (progresses));
                        //为了演示进度,休眠500毫秒  
                        Thread.sleep(100);
                        progresses++;
                    }
                }
                return new String("666");

            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }
            return null;
        }

        //onProgressUpdate方法用于更新进度信息  
        @Override
        protected void onProgressUpdate(Integer... progresses) {
            Log.i(TAG, "onProgressUpdate(Progress... progresses) called");
            progressBar.setProgress(progresses[0]);
            textView.setText("loading..." + progresses[0] + "%");
        }

        //onPostExecute方法用于在执行完后台任务后更新UI,显示结果  
        @Override
        protected void onPostExecute(String result) {
            Log.i(TAG, "onPostExecute(Result result) called");
            textView.setText(result);

        }

        //onCancelled方法用于在取消执行中的任务时更改UI  
        @Override
        protected void onCancelled() {
            Log.i(TAG, "onCancelled() called");
            textView.setText("cancelled");
            progressBar.setProgress(0);
        }
    }

}
