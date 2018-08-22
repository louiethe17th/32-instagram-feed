package com.example.tyler.instagramfeed;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.List;

public class Adapter  extends RecyclerView.Adapter<Adapter.MyViewHolder>{
    private List<Post> mFeed;

    public Adapter(){
        mFeed = new ArrayList<>();
    }

    public Adapter(List<Post> feed){
        mFeed = feed;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_post, parent, false);

        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        Post post = mFeed.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount(){
        return mFeed.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        View mView;

        public ImageView mImage;
        public TextView mAuthor;
        private TextView mDescription;

        private Post mPost;

        public MyViewHolder(View view){
            super(view);
            mView = view;

            mImage = view.findViewById(R.id.pictures);
            mAuthor = view.findViewById(R.id.author);
            mDescription = view.findViewById(R.id.description);
        }

        public void bind(Post post){
            mPost = post;
            mAuthor.setText(post.author);
            mDescription.setText(post.description);

            Ion.with(mImage).placeholder(R.drawable.loading).load(mPost.imageUrl);
        }
    }
}
