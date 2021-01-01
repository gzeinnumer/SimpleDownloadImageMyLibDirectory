package com.gzeinnumer.simpledownloadimagemylibdirectory;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gzeinnumer.gzndirectory.helper.FGFile;
import com.gzeinnumer.simpledownloadimagemylibdirectory.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity_";

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //todo 13 initOnClick
        initOnClick();

    }

    private void initOnClick() {
        //todo 14
        binding.btnDownload.setOnClickListener(v -> {

            String imgUrl = "https://avatars3.githubusercontent.com/u/45892408?s=460&u=94158c6479290600dcc39bc0a52c74e4971320fc&v=4";
            String saveTo = "/Foto_Download"; //   /storage/emulated/0/SimpleDownloadImageMyLibDirectory/Foto_Download
//        String saveTo = "/"; //   /storage/emulated/0/SimpleDownloadImageMyLibDirectory/     //Jika tidak mau diletakan dalam folder
            String fileName = "file name.jpg";

            // jika file name ada di akhir link seperti dibawah, maka kamu bsa gunakan cara seperti ini
            // imgUrl = "https://helpx.adobe.com/content/dam/help/en/stock/how-to/visual-reverse-image-search/jcr_content/main-pars/image/visual-reverse-image-search-v2_intro.jpg";
            // String fileName = imgUrl.substring(url.lastIndexOf('/') + 1, url.length());

            boolean overwriteExistingFiles =  true;
            //Jika isNew true maka file lama akan dihapus dan diganti dengan yang baru.
            FGFile.initFileImageFromInternet(getApplicationContext(),imgUrl, saveTo, fileName, overwriteExistingFiles, new FGFile.ImageLoadCallBack() {
                @Override
                public void onBitmapReturn(Bitmap bitmap, String path, String msg) {
                    binding.img.setImageBitmap(bitmap);
                    Log.d(TAG, "onBitmapReturn: "+path);
                    Log.d(TAG, "onBitmapReturn: "+msg);
                }
            });
        });
    }
}