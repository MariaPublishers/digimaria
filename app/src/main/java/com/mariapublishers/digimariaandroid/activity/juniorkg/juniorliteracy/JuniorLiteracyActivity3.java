package com.mariapublishers.digimariaandroid.activity.juniorkg.juniorliteracy;

import android.content.ClipData;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.activity.mainprocess.RedirectPages;
import com.mariapublishers.digimariaandroid.prefference.Pref;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class JuniorLiteracyActivity3 extends BaseActivity implements View.OnClickListener {

    int i = 0;
    TextView a_h, b_h, c_h, d_h, e_h, f_h, g_h, h_h, i_h, j_h, k_h, l_h, m_h, n_h, o_h, p_h, q_h, r_h, s_h, t_h, u_h, v_h, w_h, x_h, y_h, z_h;
    CardView a_id, b_id, c_id, d_id, e_id, f_id, g_id, h_id, i_id, j_id, k_id, l_id, m_id, n_id, o_id, p_id, q_id, r_id, s_id, t_id, u_id, v_id, w_id, x_id, y_id, z_id;
    CardView next, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_junior_literacy3);

        currentContext = JuniorLiteracyActivity3.this;

        intialize();
        actionbar();
        clickEvent();

    }

    public void actionbar() {

        ImageView toback = findViewById(R.id.toback);

        toback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectPage();
            }
        });

        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Fill in the missing letters \n (Hold & Drag)");

    }

    public void intialize() {
        a_h = findViewById(R.id.a_h);
        b_h = findViewById(R.id.b_h);
        c_h = findViewById(R.id.c_h);
        d_h = findViewById(R.id.d_h);
        e_h = findViewById(R.id.e_h);
        f_h = findViewById(R.id.f_h);
        g_h = findViewById(R.id.g_h);
        h_h = findViewById(R.id.h_h);
        i_h = findViewById(R.id.i_h);
        j_h = findViewById(R.id.j_h);
        k_h = findViewById(R.id.k_h);
        l_h = findViewById(R.id.l_h);
        m_h = findViewById(R.id.m_h);
        n_h = findViewById(R.id.n_h);
        o_h = findViewById(R.id.o_h);
        p_h = findViewById(R.id.p_h);
        q_h = findViewById(R.id.q_h);
        r_h = findViewById(R.id.r_h);
        s_h = findViewById(R.id.s_h);
        t_h = findViewById(R.id.t_h);
        u_h = findViewById(R.id.u_h);
        v_h = findViewById(R.id.v_h);
        w_h = findViewById(R.id.w_h);
        x_h = findViewById(R.id.x_h);
        y_h = findViewById(R.id.y_h);
        z_h = findViewById(R.id.z_h);

        a_id = findViewById(R.id.a_id);
        b_id = findViewById(R.id.b_id);
        c_id = findViewById(R.id.c_id);
        d_id = findViewById(R.id.d_id);
        e_id = findViewById(R.id.e_id);
        f_id = findViewById(R.id.f_id);
        g_id = findViewById(R.id.g_id);
        h_id = findViewById(R.id.h_id);
        i_id = findViewById(R.id.i_id);
        j_id = findViewById(R.id.j_id);
        k_id = findViewById(R.id.k_id);
        l_id = findViewById(R.id.l_id);
        m_id = findViewById(R.id.m_id);
        n_id = findViewById(R.id.n_id);
        o_id = findViewById(R.id.o_id);
        p_id = findViewById(R.id.p_id);
        q_id = findViewById(R.id.q_id);
        r_id = findViewById(R.id.r_id);
        s_id = findViewById(R.id.s_id);
        t_id = findViewById(R.id.t_id);
        u_id = findViewById(R.id.u_id);
        v_id = findViewById(R.id.v_id);
        w_id = findViewById(R.id.w_id);
        x_id = findViewById(R.id.x_id);
        y_id = findViewById(R.id.y_id);
        z_id = findViewById(R.id.z_id);
        next = findViewById(R.id.next);
        back = findViewById(R.id.back);

        next.setOnClickListener(this);
        back.setOnClickListener(this);

    }

    private void redirectPage() {
        Intent intent = new Intent(JuniorLiteracyActivity3.this, RedirectPages.class);
        intent.putExtra("type", "activity");
        startActivity(intent);
        finish();
    }

    public void clickEvent() {

        a_id.setOnLongClickListener(onClickListener);
        b_id.setOnLongClickListener(onClickListener);
        c_id.setOnLongClickListener(onClickListener);
        d_id.setOnLongClickListener(onClickListener);
        e_id.setOnLongClickListener(onClickListener);
        f_id.setOnLongClickListener(onClickListener);
        g_id.setOnLongClickListener(onClickListener);
        h_id.setOnLongClickListener(onClickListener);
        i_id.setOnLongClickListener(onClickListener);
        j_id.setOnLongClickListener(onClickListener);
        k_id.setOnLongClickListener(onClickListener);
        l_id.setOnLongClickListener(onClickListener);
        m_id.setOnLongClickListener(onClickListener);
        n_id.setOnLongClickListener(onClickListener);
        o_id.setOnLongClickListener(onClickListener);
        p_id.setOnLongClickListener(onClickListener);
        q_id.setOnLongClickListener(onClickListener);
        r_id.setOnLongClickListener(onClickListener);
        s_id.setOnLongClickListener(onClickListener);
        t_id.setOnLongClickListener(onClickListener);
        u_id.setOnLongClickListener(onClickListener);
        v_id.setOnLongClickListener(onClickListener);
        w_id.setOnLongClickListener(onClickListener);
        x_id.setOnLongClickListener(onClickListener);
        y_id.setOnLongClickListener(onClickListener);
        z_id.setOnLongClickListener(onClickListener);

        a_h.setOnDragListener(dragListenre);
        b_h.setOnDragListener(dragListenre);
        c_h.setOnDragListener(dragListenre);
        d_h.setOnDragListener(dragListenre);
        e_h.setOnDragListener(dragListenre);
        f_h.setOnDragListener(dragListenre);
        g_h.setOnDragListener(dragListenre);
        h_h.setOnDragListener(dragListenre);
        i_h.setOnDragListener(dragListenre);
        j_h.setOnDragListener(dragListenre);
        k_h.setOnDragListener(dragListenre);
        l_h.setOnDragListener(dragListenre);
        m_h.setOnDragListener(dragListenre);
        n_h.setOnDragListener(dragListenre);
        o_h.setOnDragListener(dragListenre);
        p_h.setOnDragListener(dragListenre);
        q_h.setOnDragListener(dragListenre);
        r_h.setOnDragListener(dragListenre);
        s_h.setOnDragListener(dragListenre);
        t_h.setOnDragListener(dragListenre);
        u_h.setOnDragListener(dragListenre);
        v_h.setOnDragListener(dragListenre);
        w_h.setOnDragListener(dragListenre);
        x_h.setOnDragListener(dragListenre);
        y_h.setOnDragListener(dragListenre);
        z_h.setOnDragListener(dragListenre);

    }

    View.OnLongClickListener onClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadow = new View.DragShadowBuilder(v);
            v.startDrag(data, shadow, v, 0);
            return false;
        }
    };

    View.OnDragListener dragListenre = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();

            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_STARTED:
// Executed after startDrag() is called.
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    // Executed after the Drag Shadow enters the drop area
                    break;
                case DragEvent.ACTION_DROP:
                    if (view.getId() == R.id.a_id && v.getId() == R.id.a_h) {
                        if (i == 0) {
                            i += 1;
                            a_h.setText("a");
                            a_id.setVisibility(View.GONE);
                        } else {
                            alertError("Go with order");
                        }
                    } else if (view.getId() == R.id.b_id && v.getId() == R.id.b_h) {
                        if (i == 1) {
                            i += 1;
                            b_h.setText("b");
                            b_id.setVisibility(View.GONE);
                        } else {
                            alertError("Go with order");
                        }
                    } else if (view.getId() == R.id.c_id && v.getId() == R.id.c_h) {
                        if (i == 2) {
                            i += 1;
                            c_h.setText("c");
                            c_id.setVisibility(View.GONE);
                        } else {
                            alertError("Go with order");
                        }
                    } else if (view.getId() == R.id.d_id && v.getId() == R.id.d_h) {
                        if (i == 3) {
                            i += 1;
                            d_h.setText("d");
                            d_id.setVisibility(View.GONE);
                        } else {
                            alertError("Go with order");
                        }
                    } else if (view.getId() == R.id.e_id && v.getId() == R.id.e_h) {
                        if (i == 4) {
                            i += 1;
                            e_h.setText("e");
                            e_id.setVisibility(View.GONE);
                        } else {
                            alertError("Go with order");
                        }
                    } else if (view.getId() == R.id.f_id && v.getId() == R.id.f_h) {
                        if (i == 5) {
                            i += 1;
                            f_h.setText("f");
                            f_id.setVisibility(View.GONE);
                        } else {
                            alertError("Go with order");
                        }
                    } else if (view.getId() == R.id.g_id && v.getId() == R.id.g_h) {
                        if (i == 6) {
                            i += 1;
                            g_h.setText("g");
                            g_id.setVisibility(View.GONE);
                        } else {
                            alertError("Go with order");
                        }
                    } else if (view.getId() == R.id.h_id && v.getId() == R.id.h_h) {
                        if (i == 7) {
                            i += 1;
                            h_h.setText("h");
                            h_id.setVisibility(View.GONE);
                        } else {
                            alertError("Go with order");
                        }
                    } else if (view.getId() == R.id.i_id && v.getId() == R.id.i_h) {
                        if (i == 8) {
                            i += 1;
                            i_h.setText("i");
                            i_id.setVisibility(View.GONE);
                        } else {
                            alertError("Go with order");
                        }
                    } else if (view.getId() == R.id.j_id && v.getId() == R.id.j_h) {
                        if (i == 9) {
                            i += 1;
                            j_h.setText("j");
                            j_id.setVisibility(View.GONE);
                        } else {
                            alertError("Go with order");
                        }
                    } else if (view.getId() == R.id.k_id && v.getId() == R.id.k_h) {
                        if (i == 10) {
                            i += 1;
                            k_h.setText("k");
                            k_id.setVisibility(View.GONE);
                        } else {
                            alertError("Go with order");
                        }
                    } else if (view.getId() == R.id.l_id && v.getId() == R.id.l_h) {
                        if (i == 11) {
                            i += 1;
                            l_h.setText("l");
                            l_id.setVisibility(View.GONE);
                        } else {
                            alertError("Go with order");
                        }
                    } else if (view.getId() == R.id.m_id && v.getId() == R.id.m_h) {
                        if (i == 12) {
                            i += 1;
                            m_h.setText("m");
                            m_id.setVisibility(View.GONE);
                        } else {
                            alertError("Go with order");
                        }
                    } else if (view.getId() == R.id.n_id && v.getId() == R.id.n_h) {
                        if (i == 13) {
                            i += 1;
                            n_h.setText("n");
                            n_id.setVisibility(View.GONE);
                        } else {
                            alertError("Go with order");
                        }
                    } else if (view.getId() == R.id.o_id && v.getId() == R.id.o_h) {
                        if (i == 14) {
                            i += 1;
                            o_h.setText("o");
                            o_id.setVisibility(View.GONE);
                        } else {
                            alertError("Go with order");
                        }
                    } else if (view.getId() == R.id.p_id && v.getId() == R.id.p_h) {
                        if (i == 15) {
                            i += 1;
                            p_h.setText("p");
                            p_id.setVisibility(View.GONE);
                        } else {
                            alertError("Go with order");
                        }
                    } else if (view.getId() == R.id.q_id && v.getId() == R.id.q_h) {
                        if (i == 16) {
                            i += 1;
                            q_h.setText("q");
                            q_id.setVisibility(View.GONE);
                        } else {
                            alertError("Go with order");
                        }
                    } else if (view.getId() == R.id.r_id && v.getId() == R.id.r_h) {
                        if (i == 17) {
                            i += 1;
                            r_h.setText("r");
                            r_id.setVisibility(View.GONE);
                        } else {
                            alertError("Go with order");
                        }
                    } else if (view.getId() == R.id.s_id && v.getId() == R.id.s_h) {
                        if (i == 18) {
                            i += 1;
                            s_h.setText("s");
                            s_id.setVisibility(View.GONE);
                        } else {
                            alertError("Go with order");
                        }
                    } else if (view.getId() == R.id.t_id && v.getId() == R.id.t_h) {
                        if (i == 19) {
                            i += 1;
                            t_h.setText("t");
                            t_id.setVisibility(View.GONE);
                        } else {
                            alertError("Go with order");
                        }
                    } else if (view.getId() == R.id.u_id && v.getId() == R.id.u_h) {
                        if (i == 20) {
                            i += 1;
                            u_h.setText("u");
                            u_id.setVisibility(View.GONE);
                        } else {
                            alertError("Go with order");
                        }
                    } else if (view.getId() == R.id.v_id && v.getId() == R.id.v_h) {
                        if (i == 21) {
                            i += 1;
                            v_h.setText("v");
                            v_id.setVisibility(View.GONE);
                        } else {
                            alertError("Go with order");
                        }
                    } else if (view.getId() == R.id.w_id && v.getId() == R.id.w_h) {
                        if (i == 22) {
                            i += 1;
                            w_h.setText("w");
                            w_id.setVisibility(View.GONE);
                        } else {
                            alertError("Go with order");
                        }
                    } else if (view.getId() == R.id.x_id && v.getId() == R.id.x_h) {
                        if (i == 23) {
                            i += 1;
                            x_h.setText("x");
                            x_id.setVisibility(View.GONE);
                        } else {
                            alertError("Go with order");
                        }
                    } else if (view.getId() == R.id.y_id && v.getId() == R.id.y_h) {
                        if (i == 24) {
                            i += 1;
                            y_h.setText("y");
                            y_id.setVisibility(View.GONE);
                        } else {
                            alertError("Go with order");
                        }
                    } else if (view.getId() == R.id.z_id && v.getId() == R.id.z_h) {
                        if (i == 25) {
                            i += 1;
                            z_h.setText("z");
                            z_id.setVisibility(View.GONE);
                            toBack();
                        } else {
                            alertError("Go with order");
                        }
                    } else {
                        alertError("Put on the correct carriage.");
                    }
                    break;

            }
            return true;
        }
    };
    
    public void alertError(String message) {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.wrong);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(JuniorLiteracyActivity3.this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setConfirmText("OK")
                .setContentText(message)
                .show();
    }

    @Override
    public void onBackPressed() {
        onclickBack();
    }

    public void toBack() {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(JuniorLiteracyActivity3.this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Hurray!")
                .setContentText("Activity Cleared.")
                .setConfirmText("OK")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        startActivity(new Intent(JuniorLiteracyActivity3.this, JuniorLiteracyActivity4.class));
                        finish();
                    }
                })
                .show();
    }

    public void onclickNext() {
        startActivity(new Intent(JuniorLiteracyActivity3.this, JuniorLiteracyActivity4.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(JuniorLiteracyActivity3.this, JuniorLiteracyActivity2.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.next) {
            onclickNext();
        } else if (v.getId() == R.id.back) {
            onclickBack();
        }
    }
}
