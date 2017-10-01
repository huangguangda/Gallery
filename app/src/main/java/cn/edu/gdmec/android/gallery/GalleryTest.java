package cn.edu.gdmec.android.gallery;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import android.widget.Gallery.LayoutParams;
import android.widget.BaseAdapter;
public class GalleryTest extends AppCompatActivity implements OnItemSelectedListener,ViewSwitcher.ViewFactory {
    //声明ImageSwitcher
    private ImageSwitcher mSwitcher;
    private Integer[] mThumbIds = {
            R.drawable.thumb0,
            R.drawable.thumb1,
            R.drawable.thumb2,
            R.drawable.thumb3,
            R.drawable.thumb4,
            R.drawable.thumb5,
            R.drawable.thumb6,
            R.drawable.thumb7
    };
    private Integer[] mImageIds = {
            R.drawable.img0,
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        //设置窗口特征无标题
        requestWindowFeature ( Window.FEATURE_NO_TITLE );
        setContentView ( R.layout.activity_gallery_test );
        mSwitcher=(ImageSwitcher)findViewById ( R.id.switcher );
        mSwitcher.setFactory (this);
        mSwitcher.setInAnimation ( AnimationUtils.loadAnimation ( this, android.R.anim.fade_in ) );
        mSwitcher.setOutAnimation ( AnimationUtils.loadAnimation ( this, android.R.anim.fade_out ) );
        Gallery g=(Gallery)findViewById ( R.id.gallery );
        g.setAdapter ( new ImageAdapter ( this ) );
        g.setOnItemSelectedListener ( this );
    }

    public class ImageAdapter extends BaseAdapter{
        public ImageAdapter(Context c){
            mContext = c;
        }
        public int getCount(){
            return mThumbIds.length;
        }
        public Object getItem(int position){
            return position;
        }
        public long getItemId(int position){
            return position;
        }
        public View getView(int position, View convertView, ViewGroup parent){
            ImageView i = new ImageView ( mContext );
            i.setImageResource ( mThumbIds[position] );
            i.setAdjustViewBounds ( true );
            i.setLayoutParams ( new Gallery.LayoutParams ( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT ) );
            return i;
        }
        private Context mContext;
    }

    @Override
    public View makeView(){
        ImageView i = new ImageView ( this );
        i.setBackgroundColor ( 0xFF000000 );
        i.setScaleType ( ImageView.ScaleType.FIT_CENTER );
        i.setLayoutParams ( new ImageSwitcher.LayoutParams ( LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT ) );
        return i;
    }
    @Override
    public void onItemSelected(AdapterView<?> adapter, View v, int position, long id){
        mSwitcher.setImageResource ( mImageIds[position] );
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0){

    }
}
