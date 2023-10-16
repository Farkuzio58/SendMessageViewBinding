package com.farkuzio58.sendmessageviewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.farkuzio58.sendmessageviewbinding.databinding.ActivitySendMessageBinding;
import com.farkuzio58.sendmessageviewbinding.model.data.Message;
import com.farkuzio58.sendmessageviewbinding.model.data.Person;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * @author farku
 * @version 1.0
 * Activity para escribir un mensaje y enviar dicho mensaje a otra Activity
 * También se puede visualizar el ciclo de vida de la activity
 * En la parte superior posee un menú desplegable
 */
public class SendMessageActivity extends AppCompatActivity {
    private ActivitySendMessageBinding binding;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("1", "S Start");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("1", "S Stop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        Log.d("1", "S Destroy");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.faSend.setOnClickListener(view -> {
            sendMessage();
        });
    }
    private void sendMessage() {
        Intent intent = new Intent(this, ViewActivity.class);
        Bundle bundle = new Bundle();
        Person person = new Person("Jose Enrique", "Valle", "0982475J");
        Message message = new Message(1, binding.edMessage.getText().toString(), person, person);
        bundle.putParcelable(Message.KEY, message);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_about:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }




}