package com.example.duongtainhan555.sharepreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private CheckBox cbRememberMe;
    private EditText edUser, edPass;

    private SharedPreferences sharedPreferences;
    boolean checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Anh xa
        btnLogin = findViewById(R.id.btnLogin);
        cbRememberMe = findViewById(R.id.cbRememberMe);
        edUser = findViewById(R.id.edUser);
        edPass = findViewById(R.id.edPass);
        //
        sharedPreferences = getSharedPreferences("InfoUser", MODE_PRIVATE);
        //get value
        edUser.setText(sharedPreferences.getString("taikhoan",""));
        edPass.setText(sharedPreferences.getString("matkhau",""));
        cbRememberMe.setChecked(sharedPreferences.getBoolean("checked",false));

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edUser.getText().toString();
                String pass = edPass.getText().toString();
                if(user.equals("Nhan") && pass.equals("1997"))
                {
                    Toast.makeText(MainActivity.this,"Dang nhap thanh cong",Toast.LENGTH_SHORT).show();
                    if(cbRememberMe.isChecked())
                    {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("taikhoan",user);
                        editor.putString("matkhau",pass);
                        editor.putBoolean("checked",true);
                        editor.commit();
                    }
                    else
                    {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("taikhoan");
                        editor.remove("matkhau");
                        editor.remove("checked");
                        editor.commit();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Dang nhap that bai",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
