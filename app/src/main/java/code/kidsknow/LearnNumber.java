package code.kidsknow;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class LearnNumber extends AppCompatActivity implements ViewSwitcher.ViewFactory {

    private ImageSwitcher imageSwitcher;
    private MediaPlayer mp3;

    //for backgroud with rounded

    int arrImage[] = {R.drawable.number1, R.drawable.number2, R.drawable.number3, R.drawable.number4, R.drawable.number5, R.drawable.number6, R.drawable.number7, R.drawable.number8,
            R.drawable.number9, R.drawable.number10};
    int viewbg[] = {R.drawable.rounded_corner, R.drawable.rounded_corner, R.drawable.rounded_corner, R.drawable.rounded_corner, R.drawable.rounded_corner, R.drawable.rounded_corner, R.drawable.rounded_corner, R.drawable.rounded_corner, R.drawable.rounded_corner, R.drawable.rounded_corner, R.drawable.rounded_corner, R.drawable.rounded_corner};

    private int voiceENG[] = {R.raw.en_1, R.raw.en_2, R.raw.en_3, R.raw.en_4, R.raw.en_5, R.raw.en_6, R.raw.en_7,
            R.raw.en_8, R.raw.en_9, R.raw.en_10};
    private int voiceIND[] = {R.raw.id_1, R.raw.id_2, R.raw.id_3, R.raw.id_4, R.raw.id_5, R.raw.id_6, R.raw.id_7,
            R.raw.id_8, R.raw.id_9, R.raw.id_10};
    private String textnumbers[] = {"\n" + " " + "One" + "\n" + "Satu", "\n" + " " + "Two" + "\n" + "Dua", "\n" + " " + "Three" + "\n" + "Tiga", "\n" + " " + "Four" + "\n" + "Empat", "\n" + " " + "Five" + "\n" + "Lima",
            "\n" + " " + "Six" + "\n" + "Enam", "\n" + " " + "Seven" + "\n" + "Tujuh", "\n" + " " + "Eight" + "\n" + "Delapan", "\n" + " " + "Nine" + "\n" + "Sembilan", "\n" + " " + "Ten" + "\n" + "Sepuluh", "\n"};
    int messageCount = arrImage.length;
    // to keep current Index of arrImage array
    int currentIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_learn_number);

        final ImageView img = (ImageView) findViewById(R.id.viewnumber);
        final TextView textview = (TextView) findViewById(R.id.txtviewnum);

        final ImageView img1 = (ImageView) findViewById(R.id.viewnumber1);
        final TextView textview2 = (TextView) findViewById(R.id.txtviewnum1);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher1);
        imageSwitcher.setFactory(this);
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
        Gallery gallery = (Gallery) findViewById(R.id.glnumber);
        gallery.setAdapter(new ImageAdapter(this));
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageSwitcher.setImageResource(arrImage[position]);
                playSound(voiceENG[position]);
                textview.setText(textnumbers[position]);
                img.setImageResource(viewbg[position]);
                img1.setImageResource(viewbg[position]);
                textview2.setText(textnumbers[position]);



            }
        });



    }


    private void playSound(int Btn) {
        try {
            if (mp3.isPlaying()) {
                mp3.stop();
                mp3.release();
            }
        } catch (Exception e) {
            //Toast.makeText(this, "Masuk Exception", Toast.LENGTH_LONG).show();
        }
        if (Btn == voiceENG[0]) {
            mp3 = MediaPlayer.create(this, voiceENG[0]);
        } else if (Btn == voiceENG[1]) {
            mp3 = MediaPlayer.create(this, voiceENG[1]);
        } else if (Btn == voiceENG[2]) {
            mp3 = MediaPlayer.create(this, voiceENG[2]);
        } else if (Btn == voiceENG[3]) {
            mp3 = MediaPlayer.create(this, voiceENG[3]);
        } else if (Btn == voiceENG[4]) {
            mp3 = MediaPlayer.create(this, voiceENG[4]);
        } else if (Btn == voiceENG[5]) {
            mp3 = MediaPlayer.create(this, voiceENG[5]);
        } else if (Btn == voiceENG[6]) {
            mp3 = MediaPlayer.create(this, voiceENG[6]);
        } else if (Btn == voiceENG[7]) {
            mp3 = MediaPlayer.create(this, voiceENG[7]);
        } else if (Btn == voiceENG[8]) {
            mp3 = MediaPlayer.create(this, voiceENG[8]);
        }

        mp3.setLooping(false);
        mp3.start();
    }

    @Override
    public View makeView() {
        ImageView imageView = new ImageView(this);
        //imageView.setBackgroundColor(@drawable/bg_kosakata);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                WindowManager.LayoutParams.FILL_PARENT,
                WindowManager.LayoutParams.FILL_PARENT));

        return imageView;
    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;
        private int itemBackground;

        public ImageAdapter(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return arrImage.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(arrImage[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setLayoutParams(new Gallery.LayoutParams(135, 200));
            //	imageView.setBackgroundResource(itemBackground);

            return imageView;
        }

        public View getVie(int position, View convertVie, ViewGroup parent) {
            // TODO Auto-generated method stub
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(viewbg[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setLayoutParams(new Gallery.LayoutParams(135, 200));
            //	imageView.setBackgroundResource(itemBackground);

            return imageView;
        }


    }
}
