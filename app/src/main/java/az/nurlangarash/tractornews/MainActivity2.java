package az.nurlangarash.tractornews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity2 extends AppCompatActivity {
    private WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myWebView = (WebView)findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("http://www.tractorf.cf");
        myWebView.setWebViewClient(new WebViewClient());

    }
    @Override
    public void onBackPressed(){
        if(myWebView.canGoBack()){
            myWebView.goBack();
        } else{
            super.onBackPressed();
        }
    }
}