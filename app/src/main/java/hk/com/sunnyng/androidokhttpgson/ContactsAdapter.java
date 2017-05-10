package hk.com.sunnyng.androidokhttpgson;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by sunnyng on 10/5/2017.
 */

public class ContactsAdapter extends ArrayAdapter<Contact> {

    Context context;
    int layoutResourceId;
    Contact data[] = null;

    public ContactsAdapter(Context context, int layoutResourceId, Contact[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ContactHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((ListActivity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ContactHolder();
            holder.firstName = (TextView)row.findViewById(R.id.first_name);
            holder.email = (TextView) row.findViewById(R.id.email);
            holder.mobile = (TextView) row.findViewById(R.id.mobile);

            row.setTag(holder);
        }
        else
        {
            holder = (ContactHolder)row.getTag();
        }

        Contact contact = data[position];
        holder.firstName.setText(contact.getFirstName());
        holder.email.setText(contact.getEmail());
        holder.mobile.setText(contact.getMobile());

        return row;
    }

    static class ContactHolder
    {
        TextView firstName;
        TextView email;
        TextView mobile;
    }

}
