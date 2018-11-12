package com.example.djamel.fragment_tp5;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

         import android.content.Context;
        import android.content.res.TypedArray;

        import android.widget.AdapterView;
        import android.widget.AdapterView.OnItemClickListener;
        import android.widget.BaseAdapter;
        import android.widget.Gallery;
        import android.widget.ImageView;
        import android.widget.Toast;

public class fragment1 extends Fragment {

    View v;
    /** Called when the activity is first created. */
     @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            v =inflater.inflate(R.layout.fragment1_layout,container,false);

       // setContentView(R.layout.main);

        Gallery g = (Gallery) v.findViewById(R.id.gallery);
        g.setAdapter(new ImageAdapter(v.getContext()));

        g.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(v.getContext(), "" + position, Toast.LENGTH_SHORT).show();
            }
        });
         return  v;
     }

    public class ImageAdapter extends BaseAdapter {
        int mGalleryItemBackground;
        private Context mContext;

        private Integer[] mImageIds = {
                R.drawable.sample_1,
                R.drawable.sample_2,
                R.drawable.sample_3,
                R.drawable.sample_4,
                R.drawable.sample_5,
                R.drawable.sample_6,
                R.drawable.sample_7
        };

        public ImageAdapter(Context c) {
            mContext = c;
            TypedArray a = v.getContext().obtainStyledAttributes(R.styleable.GalleryActivity);
            mGalleryItemBackground = a.getResourceId(
                    R.styleable.GalleryActivity_android_galleryItemBackground, 0);
            a.recycle();
        }

        public int getCount() {
            return mImageIds.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView i = new ImageView(mContext);

            i.setImageResource(mImageIds[position]);
            i.setLayoutParams(new Gallery.LayoutParams(800, 800));
            i.setScaleType(ImageView.ScaleType.FIT_XY);
            i.setBackgroundResource(mGalleryItemBackground);

            return i;
        }
    }
}