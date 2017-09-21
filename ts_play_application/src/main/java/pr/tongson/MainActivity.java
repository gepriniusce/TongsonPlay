package pr.tongson;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_share_text).setOnClickListener(this);
        findViewById(R.id.btn_share_image).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_share_text:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/*");
                intent.putExtra(Intent.EXTRA_SUBJECT, "EXTRA_SUBJECT");
                intent.putExtra(Intent.EXTRA_TEXT, "EXTRA_TEXT");//内容
                intent.putExtra("Kdescription", "Kdescription");
                intent.putExtra("sms_body", "sms_body");
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                try {
                    startActivity(Intent.createChooser(intent, "title"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_share_image:
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(null));
                shareIntent.setType("image/*");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "EXTRA_SUBJECT");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "EXTRA_TEXT");
                shareIntent.putExtra("Kdescription", "Kdescription");
                shareIntent.putExtra("sms_body", "sms_body");
                shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                try {
                    startActivity(Intent.createChooser(shareIntent, "title"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
