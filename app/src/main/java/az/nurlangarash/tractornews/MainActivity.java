package az.nurlangarash.tractornews;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button activity_main_btnGo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();

        if(!isNetworkAvailable()==true)
        {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("İnternet bağlantısı xətası!")
                    .setMessage("Xahiş edirik internet bağlantınızı yoxlayın")
                    .setPositiveButton("Bağla", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    }).show();
        }
        else if(isNetworkAvailable()==true)
        {
            Toast.makeText(MainActivity.this,
                    "İnternetə qoşuldu", Toast.LENGTH_LONG).show();
        }

    }
    private void initView() {
        //TODO 3 Java - Xml eşleştirmelerini initView metotu içerisinde yapıyoruz
        activity_main_btnGo = (Button) findViewById(R.id.activity_main_btnGo);
    }

    private void initEvent() {
        //TODO 4 Button onClick tanımlaması yapıyoruz

        activity_main_btnGo.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        //TODO 5 Intent tanımı yapıp parantez içine var olan Activity , geçmek istediğimiz activity'yi yazıyoruz

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

        //TODO 5.1 startActivity metoduna yazdığımız intent'i veriyoruz Bu şekilde diğer activity'ye geçeceğiz.
        startActivity(intent);

    }
    public boolean isNetworkAvailable() {

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {


            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                if (capabilities != null) {
                    if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {

                        return true;
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {

                        return true;
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {

                        return true;
                    }
                }
            }
        }


        return false;




    }
}
