package squareandcube.com.displaycontacts;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CustomAdapter  extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>  {
    List<Contact> listContacts;
    Context context;
    //ImageView imageView;
    ContactsAdapterListener listener;

    public CustomAdapter(Context context, List<Contact> listContacts,ContactsAdapterListener listener) {
        this.context = context;
        this.listener=listener;
        this.listContacts=listContacts;
    }
     @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.single_contact_view,null);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Contact contact=listContacts.get(position);
        holder.name.setText(contact.getName());
        holder.number.setText(contact.getNumber());
        String s=contact.getContactImage1();

       }
    @Override
    public int getItemCount() {

        return listContacts.size();
        }
    public interface ContactsAdapterListener {
        void onContactSelected(Contact contact);

    }
    public void setFilter(ArrayList<Contact> newList)
    {
        listContacts=new ArrayList<>();
        listContacts.addAll(newList);
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,number;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
        name=(TextView)itemView.findViewById(R.id.name);
        number=(TextView)itemView.findViewById(R.id.number);
        itemView=(ImageView)itemView.findViewById(R.id.imageview);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onContactSelected(listContacts.get(getAdapterPosition()));
            }
        });
        }
    }

}
