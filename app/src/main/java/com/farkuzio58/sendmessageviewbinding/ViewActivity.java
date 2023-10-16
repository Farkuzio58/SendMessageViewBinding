package com.farkuzio58.sendmessageviewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.farkuzio58.sendmessageviewbinding.databinding.ActivitySendMessageBinding;
import com.farkuzio58.sendmessageviewbinding.databinding.ActivityViewBinding;
import com.farkuzio58.sendmessageviewbinding.model.data.Message;

/**
 * @author farku
 * @version 1.0
 * Activity para visualizar un mensaje recibido de otra Activity
 * También se puede visualizar el ciclo de vida de la activity
 */
public class ViewActivity extends AppCompatActivity {
    private ActivityViewBinding binding;
    private Message message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle bundle = getIntent().getExtras();
        message = bundle.getParcelable(Message.KEY);
        initialiceView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("1", "V Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("1", "V Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        Log.d("1", "V Destroy");
    }

    private void initialiceView() {
        String user = "La persona " + message.getSender().getName() + " " + message.getSender().getSurname() + " con DNI: " + message.getSender().getDni() + "\nTe ha mandado un mensaje:";
        String mes = message.getContent();
        binding.tvMessage.setText(mes);
        binding.tvUserInfo.setText(user);
    }
}