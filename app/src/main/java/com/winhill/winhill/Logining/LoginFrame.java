package com.winhill.winhill.Logining;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.org.apache.commons.codec.binary.Base64;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.winhill.winhill.ForgotPass.ForgotPassword;
import com.winhill.winhill.R;
import com.winhill.winhill.Wallet.WalletStartButton;

import java.util.concurrent.ExecutionException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class LoginFrame extends Fragment implements View.OnClickListener {

    String secretKey = "XMzDdG4D03CKm2IxIWQw7g==";


    View rootView;
    Button forgot_pass_butt;
    //    Button sign_up_butt;
    Button lunch_demo_butt;
    private AsyncTask<String, String, String> asyncTask;
    Button log_in_butt;
    protected EditText email, pass;
    FragmentTransaction fragManager;
    private String response;
    private static Context context;
    private String resp;
    private String errorMsg;
    String TAG = "LoginFrame";




    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.login_frame, container, false);

        forgot_pass_butt = (Button) rootView.findViewById(R.id.forgot_pass_butt);
//        sign_up_butt = (Button) rootView.findViewById(R.id.sign_up_butt);
        lunch_demo_butt = (Button) rootView.findViewById(R.id.lunch_demo_butt);
        log_in_butt = (Button) rootView.findViewById(R.id.log_in_butt);
        email =(EditText) rootView.findViewById(R.id.email);
        pass = (EditText) rootView.findViewById(R.id.password);

        forgot_pass_butt.setOnClickListener(this);
//        sign_up_butt.setOnClickListener(this);
        lunch_demo_butt.setOnClickListener(this);
        log_in_butt.setOnClickListener(this);


        return rootView;
    }

    @Override
    public void onClick(View v) {

        fragManager = getFragmentManager().beginTransaction();


        switch (v.getId()) {
            case R.id.forgot_pass_butt:

                fragManager.setCustomAnimations(R.animator.gla_there_come, R.animator.gla_there_gone);
                fragManager.replace(R.id.container, new ForgotPassword());
                fragManager.addToBackStack(null);

                break;
//            case R.id.sign_up_butt:

//                fragManager.replace(R.id.container, new SignUp());
//                break;
            case R.id.lunch_demo_butt:

                fragManager.setCustomAnimations(R.animator.gla_there_come, R.animator.gla_there_gone);
                fragManager.replace(R.id.container, new WalletStartButton()); // не тооо

                break;
            case R.id.log_in_butt:
                AsyncTaskRunner runner=new AsyncTaskRunner();
                final String getEmail = email.getText().toString();
                final String getPass = pass.getText().toString();
                ValidatorLogIn logIn = new ValidatorLogIn();

                String str = symmetricEncrypt(getPass, secretKey);
                System.out.println(str);
                System.out.println(symmetricDecrypt(str,secretKey));


                if (logIn.isValidEmail(getEmail) && logIn.isValidPassword(getPass)== true) {
                    asyncTask=runner.execute(getEmail,getPass);
                    try {
                        String asyncResultText=asyncTask.get();
                        response = asyncResultText.trim()+"normal";
                    } catch (InterruptedException e1) {
                        response = e1.getMessage()+"one";
                    } catch (ExecutionException e1) {
                        response = e1.getMessage()+"two";
                    } catch (Exception e1) {
                        response = e1.getMessage()+"tree";
                    }
                    email.setError(response);
                }


                else
                {
                    if(logIn.isValidEmail(getEmail)!=true){
                        email.setError("Invalid Email");}
                    if(logIn.isValidPassword(getPass)!=true){
                        pass.setError("Pass must cont +6");}
                }
                break;
        }
        fragManager.commit();
    }


    public static String symmetricEncrypt(String text, String secretKey) {
        byte[] raw;
        String encryptedString;
        SecretKeySpec skeySpec;
        byte[] encryptText = text.getBytes();
        Cipher cipher;
        try {
            
            raw = Base64.decodeBase64(secretKey);
            skeySpec = new SecretKeySpec(raw, "AES");
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            encryptedString = Base64.encodeBase64String(cipher.doFinal(encryptText));
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
        return encryptedString;
    }

    public static String symmetricDecrypt(String text, String secretKey) {
        Cipher cipher;
        String encryptedString;
        byte[] encryptText = null;
        byte[] raw;
        SecretKeySpec skeySpec;
        try {
            raw = Base64.decodeBase64(secretKey);
            skeySpec = new SecretKeySpec(raw, "AES");
            encryptText = Base64.decodeBase64(text);
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            encryptedString = new String(cipher.doFinal(encryptText));
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
        return encryptedString;
    }


}
