package com.training.android.abode;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;
import com.training.android.abode.Data.ModelClass;

public class NoticeBoard extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    private RecyclerView mBlogList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_board);
        mBlogList = (RecyclerView) findViewById(R.id.blog_list);
        mBlogList.setHasFixedSize(true);
        mBlogList.setLayoutManager(new LinearLayoutManager(this));

        // Send a Query to the database
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Data").child("NoticeBoard");
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<ModelClass, BlogViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ModelClass, BlogViewHolder>(
                        ModelClass.class,
                        R.layout.cardview_layout,
                        BlogViewHolder.class,
                        myRef) {


                    @Override
                    protected void populateViewHolder(BlogViewHolder viewHolder, ModelClass model, int position) {
                        viewHolder.setTitle(model.getTitle());
                        viewHolder.setImage(getApplicationContext(), model.getImgUrl());
                        viewHolder.setDesc(model.getDescription());
                    }
                };
        mBlogList.setAdapter(firebaseRecyclerAdapter);
    }

    //View Holder For Recycler View
    private static class BlogViewHolder extends RecyclerView.ViewHolder {
        View mView;

        public BlogViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

        }

        public void setTitle(String title) {
            TextView post_title = (TextView) mView.findViewById(R.id.titleText);
            post_title.setText(title);
        }

        public void setDesc(String desc) {
            TextView post_desc = (TextView) mView.findViewById(R.id.tvNoticeDesc);
            post_desc.setText(desc);
        }

        public void setImage(Context ctx, String image) {
            ImageView post_image = (ImageView) mView.findViewById(R.id.imageViewy);
            // We Need TO pass Context
            Picasso.with(ctx).load(image).into(post_image);
        }
    }
}
