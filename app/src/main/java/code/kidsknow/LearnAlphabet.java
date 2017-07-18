package code.kidsknow;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

/**
 * Created by syaiful9508 on 18/07/17.
 */

public class LearnAlphabet extends AppCompatActivity implements ViewSwitcher.ViewFactory {
    private ImageSwitcher imageSwitcher;
    ImageButton btnNext, btnPrev, btnHome;
    private MediaPlayer mp3;

    String textv[] = {"\n\n"+"ei","\n\n"+"bie","\n\n"+"sie","\n\n"+"die","\n\n"+"ie","\n\n"+"ef","\n\n"+"jie","\n\n"+"eic","\n\n"+"ai","\n\n"+"jei","\n\n"+"kei","\n\n"+"el",
            "\n\n"+"em","\n\n"+"en","\n\n"+"ow","\n\n"+"pie","\n\n"+"kyuw","\n\n"+"ar","\n\n"+"es","\n\n"+"tie","\n\n"+"yuw","\n\n"+"vie","\n\n"+"dabl;yu ","\n\n"+"eks","\n\n"+"wai","\n\n"+"sie"};
    // Array of Image arrImage to Show In ImageSwitcher
    int bgtext[] = {R.drawable.rounded_alpha,R.drawable.rounded_alpha,R.drawable.rounded_alpha,R.drawable.rounded_alpha,R.drawable.rounded_alpha,R.drawable.rounded_alpha,R.drawable.rounded_alpha,R.drawable.rounded_alpha,
            R.drawable.rounded_alpha,R.drawable.rounded_alpha,R.drawable.rounded_alpha,R.drawable.rounded_alpha,R.drawable.rounded_alpha,R.drawable.rounded_alpha,R.drawable.rounded_alpha,R.drawable.rounded_alpha,R.drawable.rounded_alpha,R.drawable.rounded_alpha,
            R.drawable.rounded_alpha,R.drawable.rounded_alpha,R.drawable.rounded_alpha,R.drawable.rounded_alpha,R.drawable.rounded_alpha,R.drawable.rounded_alpha,R.drawable.rounded_alpha,R.drawable.rounded_alpha};
    int arrImage[] = {R.drawable.letter1,R.drawable.letter2,R.drawable.letter3,R.drawable.letter4,R.drawable.letter5,R.drawable.letter6,
            R.drawable.letter7,R.drawable.letter8,R.drawable.letter9,R.drawable.letter10,R.drawable.letter11,
            R.drawable.letter12,R.drawable.letter13,R.drawable.letter14,R.drawable.letter15,R.drawable.letter16,
            R.drawable.letter17,R.drawable.letter18,R.drawable.letter19,R.drawable.letter20,R.drawable.letter21,
            R.drawable.letter22,R.drawable.letter23,R.drawable.letter24,R.drawable.letter25,R.drawable.letter26};
    private int voiceEN[] = {R.raw.a_en, R.raw.b_en, R.raw.c_en, R.raw.d_en, R.raw.e_en,
                            R.raw.f_en, R.raw.g_en, R.raw.h_en, R.raw.i_en, R.raw.j_en, R.raw.k_en,
                            R.raw.l_en, R.raw.m_en, R.raw.n_en, R.raw.o_en, R.raw.p_en, R.raw.q_en, R.raw.r_en,
                            R.raw.s_en, R.raw.t_en, R.raw.u_en, R.raw.v_en, R.raw.w_en, R.raw.x_en, R.raw.y_en, R.raw.z_en};

    int messageCount = arrImage.length;
    // to keep current Index of arrImage array
    int currentIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remote tittle
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_learn_alphabet);
        final ImageView img = (ImageView)findViewById(R.id.viewnumber);
        final TextView textview = (TextView)findViewById(R.id.txtviewnum);
        imageSwitcher = (ImageSwitcher)findViewById(R.id.imageSwitcher1);
        imageSwitcher.setFactory(this);
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
        Gallery gallery = (Gallery)findViewById(R.id.glnumber);
        gallery.setAdapter(new ImageAdapter(this));
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageSwitcher.setImageResource(arrImage[position]);
                playSound(voiceEN[position]);
                textview.setText(textv[position]);
                img.setImageResource(bgtext[position]);



            }
        });


    }

    private void playSound(int Btn){
        try{
            if (mp3.isPlaying()){
                mp3.stop();
                mp3.release();
            }
        }catch(Exception e){
            //Toast.makeText(this, "Masuk Exception", Toast.LENGTH_LONG).show();
        }
        if (Btn == voiceEN[0]){
            mp3= MediaPlayer.create(this, voiceEN[0]);
        }
        else if (Btn == voiceEN[1]){
            mp3=MediaPlayer.create(this, voiceEN[1]);
        }
        else if (Btn == voiceEN[2]){
            mp3=MediaPlayer.create(this, voiceEN[2]);
        }
        else if (Btn == voiceEN[3]){
            mp3=MediaPlayer.create(this, voiceEN[3]);
        }
        else if (Btn == voiceEN[4]){
            mp3=MediaPlayer.create(this, voiceEN[4]);
        }
        else if (Btn == voiceEN[5]){
            mp3=MediaPlayer.create(this, voiceEN[5]);
        }
        else if (Btn == voiceEN[6]){
            mp3=MediaPlayer.create(this, voiceEN[6]);
        }
        else if (Btn == voiceEN[7]){
            mp3=MediaPlayer.create(this, voiceEN[7]);
        }
        else if (Btn == voiceEN[8]){
            mp3=MediaPlayer.create(this, voiceEN[8]);
        }
        else if (Btn == voiceEN[9]){
            mp3=MediaPlayer.create(this, voiceEN[9]);
        }
        else if (Btn == voiceEN[10]){
            mp3=MediaPlayer.create(this, voiceEN[10]);
        }
        else if (Btn == voiceEN[11]){
            mp3=MediaPlayer.create(this, voiceEN[11]);
        }
        else if (Btn == voiceEN[12]){
            mp3=MediaPlayer.create(this, voiceEN[12]);
        }
        else if (Btn == voiceEN[13]){
            mp3=MediaPlayer.create(this, voiceEN[13]);
        }
        else if (Btn== voiceEN[14]){
            mp3=MediaPlayer.create(this, voiceEN[14]);
        }
        else if (Btn == voiceEN[15]){
            mp3=MediaPlayer.create(this, voiceEN[15]);
        }
        else if (Btn == voiceEN[16]){
            mp3=MediaPlayer.create(this, voiceEN[16]);
        }
        else if (Btn == voiceEN[17]){
            mp3=MediaPlayer.create(this, voiceEN[17]);
        }
        else if (Btn == voiceEN[18]){
            mp3=MediaPlayer.create(this, voiceEN[18]);
        }
        else if (Btn== voiceEN[19]){
            mp3=MediaPlayer.create(this, voiceEN[19]);
        }
        else if (Btn == voiceEN[20]){
            mp3=MediaPlayer.create(this, voiceEN[20]);
        }
        else if (Btn == voiceEN[21]){
            mp3=MediaPlayer.create(this, voiceEN[21]);
        }
        else if (Btn == voiceEN[22]){
            mp3=MediaPlayer.create(this, voiceEN[22]);
        }
        else if (Btn == voiceEN[23]){
            mp3=MediaPlayer.create(this, voiceEN[23]);
        }
        else if (Btn == voiceEN[24]){
            mp3=MediaPlayer.create(this, voiceEN[24]);
        }
        else if (Btn == voiceEN[25]){
            mp3=MediaPlayer.create(this, voiceEN[25]);
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
    public class ImageAdapter extends BaseAdapter
    {
        private Context context;
        private int itemBackground;
        public ImageAdapter(Context c)
        {
            context = c ;
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
            imageView.setLayoutParams(new Gallery.LayoutParams(135,200));
            //	imageView.setBackgroundResource(itemBackground);

            return imageView;
        }

        public View getVie(int position, View convertVie, ViewGroup parent ){
            // TODO Auto-generated method stub
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(bgtext[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setLayoutParams(new Gallery.LayoutParams(135,200));
            //	imageView.setBackgroundResource(itemBackground);

            return imageView;
        }



    }
}
