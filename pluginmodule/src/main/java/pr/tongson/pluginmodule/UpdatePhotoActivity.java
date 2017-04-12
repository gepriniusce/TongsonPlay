package pr.tongson.pluginmodule;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import pr.tongson.pluginmodule.dialog.TongsonGetPhotoDialog;
import pr.tongson.pluginmodule.utils.CropUtils;

import static pr.tongson.pluginmodule.utils.CropUtils.getOutputMediaFile;

public class UpdatePhotoActivity extends AppCompatActivity {

    /**
     * 图片
     */
    private final int PHOTO_REQUEST_CAREMA = 00001;
    private final int PHOTO_REQUEST_CUT = 00002;
    private final int PHOTO_REQUEST_GALLERY = 00003;
    private Uri imagePhotoUri;
    private Uri imageCropUri;
    private Bitmap photoBitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_photo);

        Button fabuBtn = (Button) findViewById(R.id.btn_fabu);
        fabuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TongsonGetPhotoDialog tongsonGetPhotoDialog = new TongsonGetPhotoDialog(UpdatePhotoActivity.this);
                tongsonGetPhotoDialog.setOnGoCameraBtnListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imagePhotoUri = Uri.fromFile(getOutputMediaFile());
                        //调用系统相机
                        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        //将拍照结果保存至photo_file的Uri中，不保留在相册中
                        intentCamera.putExtra(MediaStore.EXTRA_OUTPUT, imagePhotoUri);
                        startActivityForResult(intentCamera, PHOTO_REQUEST_CAREMA);
                        tongsonGetPhotoDialog.dismiss();
                    }
                });
                tongsonGetPhotoDialog.setOnGoAlbumBtnBtnListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //调用系统相册
                        Intent photoPickerIntent = new Intent(Intent.ACTION_GET_CONTENT);
                        photoPickerIntent.setType("image/*");
                        startActivityForResult(photoPickerIntent, PHOTO_REQUEST_GALLERY);
                        tongsonGetPhotoDialog.dismiss();
                    }
                });
                tongsonGetPhotoDialog.show();
            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case PHOTO_REQUEST_CAREMA:
                imageCropUri = Uri.fromFile(getOutputMediaFile());
                if (resultCode == RESULT_OK) {
                    //从相机拍摄保存的Uri中取出图片，调用系统剪裁工具
                    if (imagePhotoUri != null) {
                        CropUtils.cropImageUri(this, imagePhotoUri, imageCropUri, 300, 300, PHOTO_REQUEST_CUT);
                    } else {
                    }
                } else if (resultCode == RESULT_CANCELED) {
                } else {
                }

                break;
            case PHOTO_REQUEST_GALLERY:
                imageCropUri = Uri.fromFile(getOutputMediaFile());
                if (resultCode == RESULT_OK) {
                    //从相册选取成功后，需要从Uri中拿出图片的绝对路径，再调用剪切
                    Uri newUri = Uri.parse("file:///" + CropUtils.getPath(this, data.getData()));
                    if (newUri != null) {
                        CropUtils.cropImageUri(this, newUri, imageCropUri, 300, 300, PHOTO_REQUEST_CUT);
                    } else {
                    }
                } else if (resultCode == RESULT_CANCELED) {
                } else {
                }
                break;
            case PHOTO_REQUEST_CUT:
                if (resultCode == RESULT_OK) {
                    /**
                     * 更新rcyView
                     */
                    photoBitmap = CropUtils.decodeUriAsBitmap(this, imageCropUri);
                    ImageView imageView = (ImageView) findViewById(R.id.iv_photo);
                    imageView.setImageBitmap(photoBitmap);
                    /**
                     * 保存-->上传图片
                     */
                    new SavePhotoAsy(photoBitmap).execute();
                } else if (resultCode == RESULT_CANCELED) {
                } else {
                }
                break;
        }

    }


    /**
     * 异步保存图片
     */
    class SavePhotoAsy extends AsyncTask<String, String, File> {

        Bitmap mBitmap;

        public SavePhotoAsy(Bitmap bitmap) {
            mBitmap = bitmap;
        }

        @Override
        protected File doInBackground(String... params) {
            File parentPath = Environment.getExternalStorageDirectory();
            File temp = new File(parentPath, "/" + "TongsonPhoto/" + "666~" + System.currentTimeMillis() + ".jpg");
            File photoFile = CropUtils.saveBitmap2File(mBitmap, temp.getAbsolutePath());
            if (null != photoFile && photoFile.exists()) {
                return photoFile;
            } else {
                return null;
            }
        }

        //onPostExecute方法用于在执行完后台任务后更新UI,显示结果  
        @Override
        protected void onPostExecute(File photoFile) {
            if (photoFile != null) {
                //这里点击更换图片-->每次点击都会更换图片调用接口，然后取到服务器的URL
                Toast.makeText(UpdatePhotoActivity.this, "success:" + photoFile.toString(), Toast.LENGTH_SHORT).show();
//                String result = UploadUtil.uploadFile(photoFile, "https://onlinesacrifice.linghit.com/sacrifice/uploadImage");

//                Toast.makeText(UpdatePhotoActivity.this, result, Toast.LENGTH_SHORT).show();
                
                
                
                
                
                
            }
        }
        //参数类型
        private  final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
        //创建OkHttpClient实例
        private final OkHttpClient client = new OkHttpClient();
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
    }
}
