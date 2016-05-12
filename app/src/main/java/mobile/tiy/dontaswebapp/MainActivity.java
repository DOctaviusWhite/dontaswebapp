package mobile.tiy.dontaswebapp;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener   {
    ListView list;
    EditText text;
    Button sendButton;
    ArrayAdapter<String> message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.listView);
        text = (EditText) findViewById(R.id.editText);
        sendButton = (Button) findViewById(R.id.button);
        message = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(message);
        sendButton.setOnClickListener(this);
//        list.setOnItemLongClickListener(this);
        message.add("test todo");
        message.add("test todo 2");



    }

    @Override
    public void onClick(View v) {
        ChatClient client = new ChatClient();
        System.out.print("test");
        String item = text.getText().toString();
        message.add(item);
        text.setText("");

        try {
            client.sendMessage(item);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

//    @Override
//    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//        System.out.println("test2");
//        String item = items.getItem(position);
//        items.remove(item);
//        return true;
//
//    }
}
